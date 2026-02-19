// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.motorcontrol.PWMSparkMax;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class HoodSubsystem extends SubsystemBase {
  // Define the motor on PWM port 0
  private final PWMSparkMax m_hoodMotor = new PWMSparkMax(0);

  /** Sets the hood motor speed. Positive is one direction, negative the other. */
  public void setHoodSpeed(double speed) {
    m_hoodMotor.set(speed);
  }

  /** Stops the hood motor. */
  public void stop() {
    m_hoodMotor.set(0.5);
  }
}