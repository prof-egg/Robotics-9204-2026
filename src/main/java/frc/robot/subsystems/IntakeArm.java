// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.motorcontrol.PWMVictorSPX; // Or CANSparkMax for Neo motors
import edu.wpi.first.wpilibj.DigitalInput;

public class IntakeArm extends SubsystemBase {
    // 1. Hardware Declarations
    private final PWMVictorSPX m_motor = new PWMVictorSPX(0); 
    private final DigitalInput m_limitSwitch = new DigitalInput(1);

    public IntakeArm() {
        // Constructor for initial setup
    }

    // 2. Action Methods
    public void setArmSpeed(double speed) {
        m_motor.set(speed);
    }

    public void stop() {
        m_motor.set(0);
    }

    public boolean isAtLimit() {
        return m_limitSwitch.get();
    }

    @Override
    public void periodic() {
        // 3. Periodic Updates (Runs 50 times per second)
    }
}