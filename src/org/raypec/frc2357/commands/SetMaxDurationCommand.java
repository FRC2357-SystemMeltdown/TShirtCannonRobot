package org.raypec.frc2357.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.raypec.frc2357.CRIORobot;
import org.raypec.frc2357.subsystems.FiringValveSubsystem;

/**
 */
public class SetMaxDurationCommand extends Command {
	private final FiringValveSubsystem firingSub;
	
	public SetMaxDurationCommand() {
		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);
		firingSub = CRIORobot.instance.firingSub;
		requires(firingSub);
	}

	// Called just before this Command runs the first time
	protected void initialize() {
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		firingSub.setMaxDuration((long) firingSub.getCurrentDuration());
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return true;
	}

	// Called once after isFinished returns true
	protected void end() {
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
		end();
	}
}
