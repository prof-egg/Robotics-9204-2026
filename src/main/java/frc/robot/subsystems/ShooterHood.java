package frc.robot.subsystems;

import com.revrobotics.RelativeEncoder;
import com.revrobotics.spark.SparkLowLevel;
import com.revrobotics.spark.SparkMax;

import edu.wpi.first.math.MathUtil;
import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.ShooterHoodConstants;;

public class ShooterHood extends SubsystemBase {
    private final SparkMax hood;
    private final PIDController hoodPID = new PIDController(2.0, 0, 0); //TODO: Adjust PID values and use feedforward to account for gravity
    private final RelativeEncoder hoodEncoder;
    private double hoodAngle;
    private final double angleIncrement=0.01;

    public ShooterHood() {
        hoodAngle = 0.0;
        hood = new SparkMax(ShooterHoodConstants.HOOD_CANID, SparkLowLevel.MotorType.kBrushless);
        hoodEncoder = hood.getEncoder();
    }

    public void resetEncoder() {
        hoodEncoder.setPosition(0);
    }

    public boolean isHoodCloseToTarget() {
        return Math.abs(hoodAngle - hoodEncoder.getPosition()) < ShooterHoodConstants.HOOD_ERROR;        
    }

    public void setAngle(double angle) {
        this.hoodAngle = angle;
    }

    public void increaseAngle() {
        if((hoodAngle+angleIncrement)<ShooterHoodConstants.HOOD_ANGLE_MAX) {
            this.hoodAngle+=angleIncrement;
            setAngle(hoodAngle);
        }
    }

    public void decreaseAngle() {
        if((hoodAngle-angleIncrement)>ShooterHoodConstants.HOOD_ANGLE_MIN) {
            this.hoodAngle-=angleIncrement;
            setAngle(hoodAngle);
        }
    }

    @Override
    public void periodic() {
        var hoodPow = hoodPID.calculate(hoodEncoder.getPosition(), hoodAngle);
        hoodPow = MathUtil.clamp(hoodPow, -ShooterHoodConstants.HOOD_POWER, ShooterHoodConstants.HOOD_POWER);
        hood.set(hoodPow);

        SmartDashboard.putNumber("Shooter Hood (Target)", hoodAngle);
        SmartDashboard.putNumber("Shooter Hood (Current)", hoodEncoder.getPosition());
    }
}
