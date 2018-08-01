/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.raypec.frc2357.commands;


import org.raypec.frc2357.CRIORobot;
import org.raypec.frc2357.OI;
import org.raypec.frc2357.subsystems.DriveSubsystem;
/**
 *
 * @author Kevin
 */
public class TankDriveCommand extends CommandBase {
	
	private DriveSubsystem driveSub = CRIORobot.instance.driveSub;
	private OI oi;
	
	public TankDriveCommand() {
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
		//driveSub.arcade(oi.getDriveSpeed(), oi.getDriveRotation());
		driveSub.tankDrive(oi.getTankLeft(), oi.getTankRight());
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
