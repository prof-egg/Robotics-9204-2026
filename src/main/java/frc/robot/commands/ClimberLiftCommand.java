package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constants;
import frc.robot.subsystems.ClimberSubsystem;

public class ClimberLiftCommand extends Command {
    private ClimberSubsystem climber;
    private double targetPosition;

    public ClimberLiftCommand(ClimberSubsystem climber) {
        this.climber = climber;
        addRequirements(climber);
    }

    @Override
    public void initialize() {
        this.targetPosition=Constants.ClimberConstants.CLIMBER_TARGET_LIFTED;
        climber.setTarget(targetPosition);
    }

    @Override
    public void execute() {} // PID control happens in the subsystem's periodic method

    @Override
    public void end(boolean interrupted) {} // Hold position

    @Override
    public boolean isFinished() {
       return climber.nearTarget();
    }    
}
