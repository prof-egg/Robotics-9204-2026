package frc.robot.subsystems;

import com.revrobotics.spark.SparkBase.ControlType;
import com.revrobotics.spark.SparkClosedLoopController;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.config.SparkMaxConfig;

import frc.robot.Constants.IntakeWristConstants;
import frc.robot.Constants.ShooterConstants;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.revrobotics.PersistMode;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.ResetMode;
import com.revrobotics.spark.SparkLowLevel.MotorType;

public class Shooter extends SubsystemBase {
    private final SparkMax shooterLeft, shooterRight;
    private SparkMaxConfig shooterLeftConfig=new SparkMaxConfig();
    private SparkMaxConfig shooterRightConfig=new SparkMaxConfig();
    private SparkClosedLoopController shooterLeftPID;
    private RelativeEncoder shooterLeftEncoder;
    private double shooterSpeed;
    private double speedIncrement=10.0;

    public Shooter() {
        // Initialize shoot motors
        shooterLeft=new SparkMax(ShooterConstants.SHOOTER_LEFT_CANID, MotorType.kBrushless);
        shooterRight=new SparkMax(ShooterConstants.SHOOTER_RIGHT_CANID, MotorType.kBrushless);

        shooterLeftConfig.inverted(ShooterConstants.SHOOTER_LEFT_INVERTED);
        shooterLeft.configure(shooterLeftConfig, ResetMode.kNoResetSafeParameters, PersistMode.kPersistParameters);
        shooterLeftPID=shooterLeft.getClosedLoopController();
        shooterLeftEncoder=shooterLeft.getEncoder();

        shooterRightConfig.inverted(ShooterConstants.SHOOTER_RIGHT_INVERTED);
        shooterRightConfig.follow(shooterLeft);
        shooterRight.configure(shooterRightConfig, ResetMode.kNoResetSafeParameters, PersistMode.kPersistParameters);

        //Set default speed (in RPM)
        shooterSpeed=ShooterConstants.SHOOTER_SPEED;
    }

    public void setShooterSpeed(double speed) {
        shooterLeftPID.setSetpoint(speed, ControlType.kVelocity);  //Note: Right motor set to follower
    }

    public double getShooterSpeed() {
        return shooterLeftEncoder.getVelocity();
    }

    public void runShooter() {
        setShooterSpeed(shooterSpeed);
    }

    public void stopShooter() {
        shooterLeft.stopMotor();
    }

    public boolean isShooterAtSpeed() {
        return Math.abs(getShooterSpeed()-shooterSpeed)<ShooterConstants.SHOOTER_ERROR;
    }

    public void increaseSpeed() {
        this.shooterSpeed+=speedIncrement;
    }

    public void decreaseSpeed() {
        this.shooterSpeed-=speedIncrement;
    }

    @Override
    public void periodic() {
        SmartDashboard.putNumber("Shooter (Target Speed)", shooterSpeed);
        SmartDashboard.putNumber("Shooter (Actual Speed)", getShooterSpeed());
    }
}
