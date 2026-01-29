package frc.robot.subsystems;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.config.SparkMaxConfig;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.spark.ClosedLoopSlot;
import com.revrobotics.spark.FeedbackSensor;
import com.revrobotics.spark.SparkBase.ControlType;
import com.revrobotics.spark.SparkClosedLoopController;
import com.revrobotics.spark.SparkLowLevel.MotorType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.revrobotics.PersistMode;
import com.revrobotics.ResetMode;
import frc.robot.Constants;

public class ClimberSubsystem extends SubsystemBase {
    private SparkMax climberMotor;
    private SparkClosedLoopController climberController;
    private RelativeEncoder climberEncoder;
    private SparkMaxConfig climberConfig;

    private double target=0.0;

    public ClimberSubsystem() {
        climberMotor = new SparkMax(Constants.Climber.CLIMBER_CHANNEL, MotorType.kBrushless);
        climberController = climberMotor.getClosedLoopController();
        climberEncoder = climberMotor.getEncoder();
        climberEncoder.setPosition(Constants.Climber.CLIMBER_TARGET_RETRACTED);

        climberConfig = new SparkMaxConfig();

        climberConfig.encoder
            .positionConversionFactor(1)
            .velocityConversionFactor(1);

        climberConfig.closedLoop
            .feedbackSensor(FeedbackSensor.kPrimaryEncoder)
            .p(Constants.Climber.CLIMBER_PID_P)
            .i(0)
            .d(0)
            .outputRange(-1, 1); //TODO: May want to change range so that retracting doesn't go too fast

        climberMotor.configure(climberConfig, ResetMode.kResetSafeParameters, PersistMode.kNoPersistParameters);

    }

    public void setTarget(double targetPosition) {
        this.target=targetPosition;
    }

    //Get target position (in rotations)
    public double getTarget() {
        return this.target;
    }

    //Get encoder position (in rotations)
    public double getPosition() {
        return climberEncoder.getPosition();
    }

    //Test if within error
    public boolean nearTarget() {
        return Math.abs(getPosition() - this.target) < Constants.Climber.CLIMBER_ERROR;
    }

    @Override
    public void periodic() {
        climberController.setSetpoint(this.target, ControlType.kPosition, ClosedLoopSlot.kSlot0);
    }
}