// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.math.geometry.Translation3d;
import edu.wpi.first.math.util.Units;
import swervelib.math.Matter;

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
    public static final int CONTROLLER_OPERATOR_PORT = 0;

    // Deadband
    public static final double CONTROLLER_DEADBAND=0.07;
  }

  public static class SwerveDriveConstants {
    // Swerve-specific settings (Tom's Settings)
    public static final double SWERVE_MAX_SPEED  = 5.33; // Maximum speed in m/s
    public static final double SWERVE_MAX_ROTATION_SPEED = 1;
    public static final double SWERVE_ROBOT_MASS = (100) * 0.453592; // Weight in kg
    public static final Matter SWERVE_CHASSIS    = new Matter(new Translation3d(0, 0, Units.inchesToMeters(8)), SWERVE_ROBOT_MASS);
    public static final double SWERVE_LOOP_TIME  = 0.13; //s, 20ms + 110ms sprk max velocity lag     
  }
}
