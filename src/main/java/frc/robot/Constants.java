// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.math.geometry.Translation3d;
import edu.wpi.first.math.util.Units;
import swervelib.math.Matter;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean constants. This
 * class should not be used for any other purpose. All constants should be declared globally (i.e. public static). Do
 * not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants
{

  public static final double ROBOT_MASS = (148 - 20.3) * 0.453592; // 32lbs * kg per pound
  public static final Matter CHASSIS    = new Matter(new Translation3d(0, 0, Units.inchesToMeters(8)), ROBOT_MASS);
  public static final double LOOP_TIME  = 0.13; //s, 20ms + 110ms sprk max velocity lag
  public static final double MAX_SPEED  = Units.feetToMeters(14.5); // Maximum speed of the robot in meters per second, used to limit acceleration.

//  public static final class AutonConstants
//  {
//
//    public static final PIDConstants TRANSLATION_PID = new PIDConstants(0.7, 0, 0);
//    public static final PIDConstants ANGLE_PID       = new PIDConstants(0.4, 0, 0.01);
//  }

  public static final class DrivebaseConstants
  {
    // Hold time on motor brakes when disabled
    public static final double WHEEL_LOCK_TIME = 10; // seconds
  }

  public static class OperatorConstants
  {
    // Joystick Deadband
    public static final double DEADBAND        = 0.1;
    public static final double LEFT_Y_DEADBAND = 0.1;
    public static final double RIGHT_X_DEADBAND = 0.1;
    public static final double TURN_CONSTANT    = 6;
  }

  public static final class ShooterConstants {
    // Shooter motors
    public static final int SHOOTER_LEFT_CANID=0; //TODO: Set CAN ID
    public static final boolean SHOOTER_LEFT_INVERTED=false;

    public static final int SHOOTER_RIGHT_CANID=0;  //TODO: Set CAN ID
    public static final boolean SHOOTER_RIGHT_INVERTED=true;

    //Shooter speed (default)
    public static final double SHOOTER_SPEED=2000; //Initial shoot speed (RPM)

    //Allowed shooter speed error before feeding balls
    public static final double SHOOTER_ERROR=200;
  }

  public static final class IndexerConstants {
    // Indexing/kicker motor
    public static final int INDEXER_CANID=0; //TODO: Set CAN ID
    public static final boolean INDEXER_INVERTED=false;

    //Indexer/kicker speed (default)
    public static final double INDEXER_SPEED=2000; //Initial indexer/kicker speed (RPM)
  }

  public static final class IntakeConstants {
    // Indexing/kicker motor
    public static final int INTAKE_CANID=0; //TODO: Set CAN ID
    public static final boolean INTAKE_INVERTED=false;

    //Indexer/kicker speed (default)
    public static final double INTAKE_SPEED=2000; //Initial intake wheel speed (RPM)
  }

  public static final class ShooterHoodConstants {
    public static final int HOOD_CANID=0; //TODO: Set CAN ID

    //Allowed hood angle error
    public static final double HOOD_ERROR=0.1;

    //Hood power
    public static final double HOOD_POWER=0.2;

    //Hood rang of motion
    public static final double HOOD_ANGLE_MIN=0.0;
    public static final double HOOD_ANGLE_MAX=0.3;
  }

  public static final class IntakeWristConstants {
    public static final int WRIST_LEFT_CANID=0; //TODO: Set CAN ID
    public static final boolean WRIST_LEFT_INVERTED=false;

    public static final int WRIST_RIGHT_CANID=0;  //TODO: Set CAN ID
    public static final boolean WRIST_RIGHT_INVERTED=true;

    //Allowed hood angle error
    public static final double WRIST_ERROR=0.1;

    //Hood power
    public static final double WRIST_POWER=0.2;

    //Hood rang of motion
    public static final double WRIST_ANGLE_MIN=0.0;
    public static final double WRIST_ANGLE_MAX=1.0;
  }

}