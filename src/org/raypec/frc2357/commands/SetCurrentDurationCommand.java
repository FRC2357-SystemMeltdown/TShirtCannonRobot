/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.raypec.frc2357.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.raypec.frc2357.CRIORobot;
import org.raypec.frc2357.OI;
import org.raypec.frc2357.subsystems.FiringValveSubsystem;

/**
 *
 * @author Kevin
 */
public class SetCurrentDurationCommand extends Command {
	private final FiringValveSubsystem firingSub;
	private OI oi;
	
	public SetCurrentDurationCommand() {
		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);
		firingSub = CRIORobot.instance.firingSub;
		requires(firingSub);
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		oi = CRIORobot.instance.oi;
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		double durationAdjust = oi.getDurationAdjustment();

		long min = firingSub.getMinDuration();
		long max = firingSub.getMaxDuration();
		double current = firingSub.getCurrentDuration();

		double nextDuration = current + durationAdjust;
		nextDuration = Math.max(nextDuration, min);
		nextDuration = Math.min(nextDuration, max);

		firingSub.setCurrentDuration(nextDuration);
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return false;
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
