// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import java.io.File;

import edu.wpi.first.math.MathUtil;
import edu.wpi.first.wpilibj.Filesystem;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.Constants.ControllerConstants;
import frc.robot.commands.SwerveFieldCentricCommand;
import frc.robot.commands.SwerveTestCommand;
import frc.robot.subsystems.SwerveSubsystem;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and trigger mappings) should be declared here.
 */
public class RobotContainer {

  	// Initialize Subsystems
  	private final SwerveSubsystem swerveSubsystem = new SwerveSubsystem(new File(Filesystem.getDeployDirectory(), "swerve"));

  	// Get controllers
  	private final CommandXboxController controllerDriver = new CommandXboxController(ControllerConstants.CONTROLLER_DRIVER_PORT);
  	// private final CommandXboxController controllerOperator = new CommandXboxController(ControllerConstants.CONTROLLER_OPERATOR_PORT);

	public RobotContainer() {
		// this.configureBindings(); // May want to split this into two different methods - one controller + two controllers

		this.configureDefaultDriveCommand();
	}

	private void configureDefaultDriveCommand() {
		boolean isOpenField = false;
		SwerveFieldCentricCommand fieldCentricDrive = new SwerveFieldCentricCommand(
			this.swerveSubsystem,
			// I think that forward being +X and left being +Y applies here too
			() -> MathUtil.applyDeadband(controllerDriver.getLeftY(), ControllerConstants.CONTROLLER_DEADBAND),
			() -> MathUtil.applyDeadband(controllerDriver.getLeftX(), ControllerConstants.CONTROLLER_DEADBAND),
			() -> MathUtil.applyDeadband(controllerDriver.getRightX(), ControllerConstants.CONTROLLER_DEADBAND), // this used to be controllerDriver.getRawAxis(2), leaving this note here in case of bugs
			isOpenField
		);

		this.swerveSubsystem.setDefaultCommand(fieldCentricDrive);     
	}

	/**
	 * Use this method to define your trigger->command mappings. Triggers can be created via the
	 * {@link Trigger#Trigger(java.util.function.BooleanSupplier)} constructor with an arbitrary
	 * predicate, or via the named factories in {@link
	 * edu.wpi.first.wpilibj2.command.button.CommandGenericHID}'s subclasses for {@link
	 * CommandXboxController Xbox}/{@link edu.wpi.first.wpilibj2.command.button.CommandPS4Controller
	 * PS4} controllers or {@link edu.wpi.first.wpilibj2.command.button.CommandJoystick Flight
	 * joysticks}.
	 */
	private void configureBindings() {
		this.controllerDriver.a().whileTrue(new SwerveTestCommand(this.swerveSubsystem, true));
	}

	public Command getAutonomousCommand() {
		return Commands.print("No autonomous command configured");
	}
}
