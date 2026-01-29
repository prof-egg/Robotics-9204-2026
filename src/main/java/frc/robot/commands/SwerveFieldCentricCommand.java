package frc.robot.commands;

import java.util.List;
import java.util.function.DoubleSupplier;

import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.geometry.Translation2d;
import edu.wpi.first.math.kinematics.ChassisSpeeds;
import frc.robot.Constants;
import frc.robot.subsystems.SwerveSubsystem;
import swervelib.SwerveController;
import swervelib.math.SwerveMath;
import edu.wpi.first.wpilibj2.command.Command;

public class SwerveFieldCentricCommand extends Command {
    private final SwerveSubsystem swerve;
    private final DoubleSupplier  vX, vY, heading;
    private final boolean isOpenLoop;    

    public SwerveFieldCentricCommand(SwerveSubsystem swerve, DoubleSupplier vX, DoubleSupplier vY, DoubleSupplier heading, boolean isOpenLoop) {
        this.swerve = swerve;
        this.vX = vX;
        this.vY = vY;
        this.heading = heading;
        this.isOpenLoop = isOpenLoop;

        addRequirements(swerve);
    }

    @Override
    public void initialize() { }

    @Override
    public void execute() {
        ChassisSpeeds desiredSpeeds = swerve.getTargetSpeeds(vX.getAsDouble(), vY.getAsDouble(), new Rotation2d(heading.getAsDouble() * Math.PI));

        //Limit velocity to prevent tippy
        Translation2d translation = SwerveController.getTranslation2d(desiredSpeeds);
        translation = SwerveMath.limitVelocity(translation, swerve.getFieldVelocity(), swerve.getPose(), Constants.SwerveDrivetrainConstants.SWERVE_LOOP_TIME, Constants.SwerveDrivetrainConstants.SWERVE_ROBOT_MASS, List.of(Constants.SwerveDrivetrainConstants.SWERVE_CHASSIS), swerve.getSwerveDriveConfiguration());

        //Make the robot move
        swerve.drive(translation, desiredSpeeds.omegaRadiansPerSecond, true, isOpenLoop);
    }

    @Override
    public void end(boolean interrupted) { }

    @Override
    public boolean isFinished() {
        return false;
    }

}
