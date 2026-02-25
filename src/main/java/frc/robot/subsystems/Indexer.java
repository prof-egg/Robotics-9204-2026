package frc.robot.subsystems;

import com.revrobotics.spark.SparkBase.ControlType;
import com.revrobotics.spark.SparkClosedLoopController;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.config.SparkMaxConfig;

import frc.robot.Constants.IndexerConstants;
import frc.robot.Constants.ShooterConstants;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.revrobotics.PersistMode;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.ResetMode;
import com.revrobotics.spark.SparkLowLevel.MotorType;

public class Indexer extends SubsystemBase {
    private final SparkMax indexer;
    private SparkMaxConfig indexerConfig=new SparkMaxConfig();
    private SparkClosedLoopController indexerPID;
    private RelativeEncoder indexerEncoder;
    private double indexerSpeed;

    public Indexer() {
        // Initialize indexer/kicker motor
        indexer=new SparkMax(IndexerConstants.INDEXER_CANID, MotorType.kBrushless);
        indexerConfig.inverted(IndexerConstants.INDEXER_INVERTED);
        indexer.configure(indexerConfig, ResetMode.kNoResetSafeParameters, PersistMode.kPersistParameters);
        indexerPID=indexer.getClosedLoopController();
        indexerEncoder=indexer.getEncoder();

        //Set default speed (in RPM)
        indexerSpeed=IndexerConstants.INDEXER_SPEED;
    }

    public void setIndexerSpeed(double speed) {
        indexerPID.setSetpoint(speed, ControlType.kVelocity);  //Note: Right motor set to follower
    }

    public void runIndexer() {
        setIndexerSpeed(indexerSpeed);
    }

    public void stopIndexer() {
        indexer.stopMotor();
    }

    public double getIndexerSpeed() {
        return indexerEncoder.getVelocity();
    }

    @Override
    public void periodic() {
        SmartDashboard.putNumber("Indexer/Kicker (Target Speed)", indexerSpeed);
        SmartDashboard.putNumber("Indexer/Kicker (Actual Speed)", getIndexerSpeed());
    }
}
