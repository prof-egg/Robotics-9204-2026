// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import java.io.File;

import edu.wpi.first.math.MathUtil;
import edu.wpi.first.wpilibj.Filesystem;
import edu.wpi.first.wpilibj.RobotBase;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.Constants.ControlsConstants;
import frc.robot.commands.SwerveFieldCentricCommand;
import frc.robot.subsystems.SwerveSubsystem;

public class RobotContainer {
  //TODO:  Initialize all subsystems
  private final SwerveSubsystem swerve = new SwerveSubsystem(new File(Filesystem.getDeployDirectory(), "swerve"));

  //TODO: Initialize sensors

  //Get controllers
  private final CommandXboxController controllerDriver = new CommandXboxController(ControlsConstants.CONTROLLER_DRIVER_PORT);
  private final CommandXboxController controllerOperator = new CommandXboxController(ControlsConstants.CONTROLLER_OPERATOR_PORT);

  public RobotContainer() {
    configureBindings(); //May want to split this into two different methods - one controller + two controllers

    SwerveFieldCentricCommand fieldCentricDrive = new SwerveFieldCentricCommand(swerve,
      () -> MathUtil.applyDeadband(controllerDriver.getLeftY(), Constants.ControlsConstants.CONTROLLER_DEADBAND),
      () -> MathUtil.applyDeadband(controllerDriver.getLeftX(), Constants.ControlsConstants.CONTROLLER_DEADBAND),
      () -> controllerDriver.getRawAxis(2), 
      false);

    swerve.setDefaultCommand(fieldCentricDrive);      
  }

  private void configureBindings() {
      //TODO: Add bindings
  }

  public Command getAutonomousCommand() {
    return Commands.print("No autonomous command configured");
  }
}
