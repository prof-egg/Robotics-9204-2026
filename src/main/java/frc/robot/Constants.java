package frc.robot;

import edu.wpi.first.math.geometry.Translation3d;
import edu.wpi.first.math.util.Units;
import swervelib.math.Matter;

public final class Constants {
    /* General */
    public static class General {
        //Debug mode
        public static final boolean DEBUG_MODE=true;
    }

    /* Controls */
    public static class Controls {
        //XBox controllers
        public static final int CONTROLLER_DRIVER_PORT = 0;
        public static final int CONTROLLER_OPERATOR_PORT = 0;

        //Deadband
        public static final double CONTROLLER_DEADBAND=0.05;
    }

    /* Drivetrain */
    public static class Drivetrain {
        //Swerve-specific settings
        public static final double SWERVE_MAX_SPEED  = 5.33; //Maximum speed in m/s
        public static final double SWERVE_ROBOT_MASS = (100) * 0.453592; //Weight in kg
        public static final Matter SWERVE_CHASSIS    = new Matter(new Translation3d(0, 0, Units.inchesToMeters(8)), SWERVE_ROBOT_MASS);
        public static final double SWERVE_LOOP_TIME  = 0.13; //s, 20ms + 110ms sprk max velocity lag        
    }
     
    /* Climber */
    public static class Climber {
        //Climber motor
        public static final int CLIMBER_CHANNEL=0;

        //PID
        public static final double CLIMBER_PID_P=0.1;

        //Target positions
        public static final double CLIMBER_TARGET_RETRACTED=0.0; //Initial position; start of match (in rotations)
        public static final double CLIMBER_TARGET_EXTENDED=60.0; //Extended position (to reach bar; in rotations)
        public static final double CLIMBER_TARGET_LIFTED=40.0; //Lifted position (end of auton/teleop for level 1 climb; in rotations)

        //Allowed error to target
        public static final double CLIMBER_ERROR=0.5; //Allowed error (in rotations)
    }    

    /* Extention */
    public static class Extention {
        //TODO: Extension constants here
    }

        /* Indexer */
    public static class Indexer {
        //TODO: Indexer constants here
    }

    /* Intake */
    public static class Intake {
        //TODO: Intake constants here
    }

    /* Shooter */
    public static class Shooter {
        //TODO: Shooter constants here
    }

}
