// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;


/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
  public static class ControllerConstants {
    // XBox controllers ports (as indicated on the Driver Station). Read more:
    // https://docs.wpilib.org/en/stable/docs/software/basic-programming/joystick.html
    public static final int CONTROLLER_DRIVER_PORT = 0;

    // Deadband
    public static final double CONTROLLER_DEADBAND=0.05;
  }

  public static class TankDriveConstants {
    // Motor IDs (no idea what these are supposed to be, will have to ask engineers)
    public static final int MOTOR_LEFT_FRONT_ID = 0;
    public static final int MOTOR_LEFT_BACK_ID = 0;
    public static final int MOTOR_RIGHT_FRONT_ID = 0;
    public static final int MOTOR_RIGHT_BACK_ID = 0;

    // Inversion settings (no idea what these are supposed to be, will have to ask engineers)
    public static final boolean ARE_MOTORS_LEFT_INVERTED = false;
    public static final boolean ARE_MOTORS_RIGHT_INVERTED = true;

    // Encoders (no idea what these are supposed to be, will have to ask engineers)
    public static final int DRIVE_LEFT_ENCODER_CHANNEL_A = 0; // Digital DIO port
    public static final int DRIVE_LEFT_ENCODER_CHANNEL_B = 0; // Digital DIO port
    public static final int DRIVE_RIGHT_ENCODER_CHANNEL_A = 0; // Digital DIO port
    public static final int DRIVE_RIGHT_ENCODER_CHANNEL_B = 0; // Digital DIO port

    // The setting for if we should be squaring inputs. Read more: 
    // https://docs.wpilib.org/en/stable/docs/software/hardware-apis/motors/wpi-drive-classes.html#squaring-inputs
    public static final boolean SQUARE_JOYSTICK_INPUTS = true;

    // The setting for easing in and out of motor power. Read more:
    // https://docs.wpilib.org/en/stable/docs/software/advanced-controls/filters/slew-rate-limiter.html
    public static final double SLEW_RATE = 0.5;
  }
}
