package frc.robot.subsystems;

import com.revrobotics.spark.SparkBase.ControlType;
import com.revrobotics.spark.SparkClosedLoopController;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.config.SparkMaxConfig;

import frc.robot.Constants.IntakeConstants;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.revrobotics.PersistMode;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.ResetMode;
import com.revrobotics.spark.SparkLowLevel.MotorType;

public class Intake extends SubsystemBase {
    private final SparkMax intake;
    private SparkMaxConfig intakeConfig=new SparkMaxConfig();
    private SparkClosedLoopController intakePID;
    private RelativeEncoder intakeEncoder;
    private double intakeSpeed;

    public Intake() {
        // Initialize indexer/kicker motor
        intake=new SparkMax(IntakeConstants.INTAKE_CANID, MotorType.kBrushless);
        intakeConfig.inverted(IntakeConstants.INTAKE_INVERTED);
        intake.configure(intakeConfig, ResetMode.kNoResetSafeParameters, PersistMode.kPersistParameters);
        intakePID=intake.getClosedLoopController();
        intakeEncoder=intake.getEncoder();

        //Set default speed (in RPM)
        intakeSpeed=IntakeConstants.INTAKE_SPEED;
    }

    public void setIntakeSpeed(double speed) {
        intakePID.setSetpoint(speed, ControlType.kVelocity);  //Note: Right motor set to follower
    }

    public void runIntake() {
        setIntakeSpeed(intakeSpeed);
    }

    public void stopIntake() {
        intake.stopMotor();
    }

    public double getIntakeSpeed() {
        return intakeEncoder.getVelocity();
    }

    @Override
    public void periodic() {
        SmartDashboard.putNumber("Intake (Target Speed)", intakeSpeed);
        SmartDashboard.putNumber("Intake (Actual Speed)", getIntakeSpeed());
    }
}
