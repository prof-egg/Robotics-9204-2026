package frc.robot.commands;

import java.util.List;
import java.util.function.DoubleSupplier;

import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.geometry.Translation2d;
import edu.wpi.first.math.kinematics.ChassisSpeeds;
import frc.robot.Constants.SwerveDriveConstants;
import frc.robot.subsystems.SwerveSubsystem;
import swervelib.SwerveController;
import swervelib.math.Matter;
import swervelib.math.SwerveMath;
import swervelib.parser.SwerveDriveConfiguration;
import edu.wpi.first.wpilibj2.command.Command;

public class SwerveFieldCentricCommand extends Command {

    private final SwerveSubsystem swerveSubsystem;
    private final DoubleSupplier  vX, vY, heading;
    private final boolean isOpenLoop;    

    public SwerveFieldCentricCommand(SwerveSubsystem swerve, DoubleSupplier vX, DoubleSupplier vY, DoubleSupplier heading, boolean isOpenLoop) {
        this.swerveSubsystem = swerve;
        this.vX = vX;
        this.vY = vY;
        this.heading = heading;
        this.isOpenLoop = isOpenLoop;

        super.addRequirements(swerve);
    }

    @Override
    public void initialize() { }

    @Override
    public void execute() {
		Rotation2d rotation = new Rotation2d(this.heading.getAsDouble() * Math.PI);
        ChassisSpeeds desiredSpeeds = this.swerveSubsystem.getTargetSpeeds(this.vX.getAsDouble(), this.vY.getAsDouble(), rotation);

		ChassisSpeeds fieldVelocity = this.swerveSubsystem.getFieldVelocity();
		Pose2d pose = this.swerveSubsystem.getPose();
		double loopTime = SwerveDriveConstants.SWERVE_LOOP_TIME;
		double mass = SwerveDriveConstants.SWERVE_ROBOT_MASS;
		List<Matter> matter = List.of(SwerveDriveConstants.SWERVE_CHASSIS); // Update when more things (weight) are added to the robot
		SwerveDriveConfiguration config = this.swerveSubsystem.getSwerveDriveConfiguration();

        // Limit velocity to prevent tippy
        Translation2d translation = SwerveController.getTranslation2d(desiredSpeeds);
        translation = SwerveMath.limitVelocity(translation, fieldVelocity, pose, loopTime, mass, matter, config);

        // Make the robot move
		boolean isFieldRelative = true;
        this.swerveSubsystem.drive(translation, desiredSpeeds.omegaRadiansPerSecond, isFieldRelative, this.isOpenLoop);
    }

    @Override
    public void end(boolean interrupted) { }

    @Override
    public boolean isFinished() {
        return false;
    }

}