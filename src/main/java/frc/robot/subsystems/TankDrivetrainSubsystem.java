package frc.robot.subsystems;

import com.revrobotics.spark.SparkMax;
import com.revrobotics.PersistMode;
import com.revrobotics.ResetMode;
import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.config.SparkBaseConfig.IdleMode;
import com.revrobotics.spark.config.SparkMaxConfig;

import edu.wpi.first.math.filter.SlewRateLimiter;
// import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.TankDriveConstants;

public class TankDrivetrainSubsystem extends SubsystemBase {

	private final SparkMax leftLeader = new SparkMax(TankDriveConstants.MOTOR_LEFT_FRONT_ID, MotorType.kBrushed);
	private final SparkMax leftFollower = new SparkMax(TankDriveConstants.MOTOR_LEFT_BACK_ID, MotorType.kBrushed);
	private final SparkMax rightLeader = new SparkMax(TankDriveConstants.MOTOR_RIGHT_FRONT_ID, MotorType.kBrushed);
	private final SparkMax rightFollower = new SparkMax(TankDriveConstants.MOTOR_RIGHT_BACK_ID, MotorType.kBrushed);


	// Handles easing for streams of inputs
	private final SlewRateLimiter leftSlewFilter = new SlewRateLimiter(TankDriveConstants.SLEW_RATE);
	private final SlewRateLimiter rightSlewFilter = new SlewRateLimiter(TankDriveConstants.SLEW_RATE);

	private final DifferentialDrive tankDrive;

  	public TankDrivetrainSubsystem() {

		SparkMaxConfig globalConfig = new SparkMaxConfig();
		SparkMaxConfig rightLeaderConfig = new SparkMaxConfig();
		SparkMaxConfig leftFollowerConfig = new SparkMaxConfig();
		SparkMaxConfig rightFollowerConfig = new SparkMaxConfig();
	
		/*
		* Set parameters that will apply to all SPARKs. We will also use this as
		* the left leader config.
		*/
		globalConfig
			.smartCurrentLimit(50)
			.idleMode(IdleMode.kBrake);

		// Apply the global config and invert since it is on the opposite side
		rightLeaderConfig
			.apply(globalConfig)
			.inverted(true);

		// Apply the global config and set the leader SPARK for follower mode
		leftFollowerConfig
			.apply(globalConfig)
			.follow(leftLeader);

		// Apply the global config and set the leader SPARK for follower mode
		rightFollowerConfig
			.apply(globalConfig)
			.follow(rightLeader);
	

		leftLeader.configure(globalConfig, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);
		leftFollower.configure(leftFollowerConfig, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);
		rightLeader.configure(rightLeaderConfig, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);
		rightFollower.configure(rightFollowerConfig, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);

		this.tankDrive = new DifferentialDrive(leftLeader, rightLeader);
	}

  public void tankDrive(double leftSpeed, double rightSpeed) {
		double filteredLeftSpeed = leftSlewFilter.calculate(leftSpeed);
		double filteredRightSpeed = rightSlewFilter.calculate(rightSpeed);
		this.tankDrive.tankDrive(filteredLeftSpeed, filteredRightSpeed, TankDriveConstants.SQUARE_JOYSTICK_INPUTS);
	}

	public void stop() {
		this.tankDrive.stopMotor();
	}
}
