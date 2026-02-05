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

public class SwerveTestCommand extends Command {

    private final SwerveSubsystem swerveSubsystem;
    private final boolean isOpenLoop;    

    public SwerveTestCommand(SwerveSubsystem swerve, boolean isOpenLoop) {
        this.swerveSubsystem = swerve;
        this.isOpenLoop = isOpenLoop;

        super.addRequirements(swerve);
    }

    @Override
    public void initialize() { }

    @Override
    public void execute() {

        final double PERCENT_SPEED = 0.1;
        ChassisSpeeds desiredSpeeds = this.swerveSubsystem.getTargetSpeeds(0, PERCENT_SPEED, new Rotation2d(0));

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