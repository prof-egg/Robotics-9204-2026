package frc.robot.subsystems;

import com.revrobotics.PersistMode;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.ResetMode;
import com.revrobotics.spark.SparkLowLevel;
import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.config.SparkMaxConfig;

import edu.wpi.first.math.MathUtil;
import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.IntakeWristConstants;
import frc.robot.Constants.ShooterConstants;
import frc.robot.Constants.ShooterHoodConstants;

public class IntakeWrist extends SubsystemBase {
    private final SparkMax wristLeft, wristRight;
    private SparkMaxConfig wristLeftConfig=new SparkMaxConfig();
    private SparkMaxConfig wristRightConfig=new SparkMaxConfig();
    private final PIDController wristPID = new PIDController(2.0, 0, 0);
    private final RelativeEncoder wristLeftEncoder, wristRightEncoder;
    private double wristAngle;
    private final double angleIncrement=0.01;

    public IntakeWrist() {
        wristAngle = 0.0;

        wristLeft=new SparkMax(IntakeWristConstants.WRIST_LEFT_CANID, MotorType.kBrushless);
        wristRight=new SparkMax(IntakeWristConstants.WRIST_RIGHT_CANID, MotorType.kBrushless);

        wristLeftConfig.inverted(IntakeWristConstants.WRIST_LEFT_INVERTED);
        wristLeft.configure(wristLeftConfig, ResetMode.kNoResetSafeParameters, PersistMode.kPersistParameters);
        wristLeftEncoder=wristRight.getEncoder();

        wristRightConfig.inverted(IntakeWristConstants.WRIST_RIGHT_INVERTED);
        wristRightConfig.follow(wristLeft);
        wristRight.configure(wristRightConfig, ResetMode.kNoResetSafeParameters, PersistMode.kPersistParameters);
        wristRightEncoder=wristRight.getEncoder();
    }

    public void resetEncoder() {
        wristLeftEncoder.setPosition(0);
        wristRightEncoder.setPosition(0);
    }

    public boolean isHoodCloseToTarget() {
        return Math.abs(wristAngle - wristLeftEncoder.getPosition()) < IntakeWristConstants.WRIST_ERROR;        
    }

    public void setAngle(double angle) {
        this.wristAngle = angle;
    }

    public void increaseAngle() {
        if((wristAngle+angleIncrement)<IntakeWristConstants.WRIST_ANGLE_MAX) {
            this.wristAngle+=angleIncrement;
            setAngle(wristAngle);
        }
    }

    public void decreaseAngle() {
        if((wristAngle-angleIncrement)>IntakeWristConstants.WRIST_ANGLE_MIN) {
            this.wristAngle-=angleIncrement;
            setAngle(wristAngle);
        }
    }

    @Override
    public void periodic() {
        var wristPow = wristPID.calculate(wristLeftEncoder.getPosition(), wristAngle);
        wristPow = MathUtil.clamp(wristPow, -IntakeWristConstants.WRIST_POWER, IntakeWristConstants.WRIST_POWER);
        wristLeft.set(wristPow);

        SmartDashboard.putNumber("Intake Wrist (Target)", wristAngle);
        SmartDashboard.putNumber("Intake Wrist (Current)", wristLeftEncoder.getPosition());
    }
}
