/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.raypec.frc2357.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.raypec.frc2357.CRIORobot;
import org.raypec.frc2357.OI;
import org.raypec.frc2357.subsystems.DriveSubsystem;

/**
 */
public class ArcadeDriveCommand extends Command {

	private final DriveSubsystem driveSub = CRIORobot.instance.driveSub;
	private OI oi;
	
	public ArcadeDriveCommand() {
		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);
		requires(driveSub);
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		oi = CRIORobot.instance.oi;
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		driveSub.arcade(oi.getDriveSpeed(), oi.getDriveRotation());
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
	}
}
