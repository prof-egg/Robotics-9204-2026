// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.TankDrivetrainSubsystem;

/* You should consider using the more terse Command factories API instead https://docs.wpilib.org/en/stable/docs/software/commandbased/organizing-command-based.html#defining-commands */
public class DefaultTankDriveCommand extends Command {

  private final TankDrivetrainSubsystem tankDriveSubsystem;
  private final DoubleSupplier leftSpeedSupplier;
  private final DoubleSupplier rightSpeedSupplier;
      
  /** Creates a new DefaultTankDriveCommand. */
  public DefaultTankDriveCommand(TankDrivetrainSubsystem tankDrivetrainSubsystem, DoubleSupplier leftSpeedSupplier, DoubleSupplier rightSpeedSupplier) {
    this.tankDriveSubsystem = tankDrivetrainSubsystem;
    this.leftSpeedSupplier = leftSpeedSupplier;
    this.rightSpeedSupplier = rightSpeedSupplier;
    super.addRequirements(tankDrivetrainSubsystem);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double leftSpeed = this.leftSpeedSupplier.getAsDouble();
    double rightSpeed = this.rightSpeedSupplier.getAsDouble();
    this.tankDriveSubsystem.tankDrive(leftSpeed, rightSpeed);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    this.tankDriveSubsystem.stop();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
