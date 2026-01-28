package frc.robot.subsystems;

import edu.wpi.first.math.filter.SlewRateLimiter;
// import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.PWMSparkMax;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.TankDriveConstants;

public class TankDrivetrainSubsystem extends SubsystemBase {

	private final PWMSparkMax motorLeftFront = new PWMSparkMax(TankDriveConstants.MOTOR_LEFT_FRONT_ID);
	private final PWMSparkMax motorLeftBack = new PWMSparkMax(TankDriveConstants.MOTOR_LEFT_BACK_ID);
	private final PWMSparkMax motorRightFront = new PWMSparkMax(TankDriveConstants.MOTOR_RIGHT_FRONT_ID);
	private final PWMSparkMax motorRightBack = new PWMSparkMax(TankDriveConstants.MOTOR_RIGHT_BACK_ID);

	// Handles easing for streams of inputs
	private final SlewRateLimiter leftSlewFilter = new SlewRateLimiter(TankDriveConstants.SLEW_RATE);
	private final SlewRateLimiter rightSlewFilter = new SlewRateLimiter(TankDriveConstants.SLEW_RATE);

	private final DifferentialDrive tankDrive;

  public TankDrivetrainSubsystem() {

		// Tie motors together, follower motors just copy the leader motor verbatim
		this.motorLeftFront.addFollower(motorLeftBack);
		this.motorRightFront.addFollower(motorRightBack);

		// Since the back motors have been added as followers, we only need to 
		// interact with the front motors (leader motors). This includes inverting.
		this.motorLeftFront.setInverted(TankDriveConstants.ARE_MOTORS_LEFT_INVERTED);
		this.motorRightFront.setInverted(TankDriveConstants.ARE_MOTORS_RIGHT_INVERTED);

		this.tankDrive = new DifferentialDrive(motorLeftFront, motorRightFront);
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
