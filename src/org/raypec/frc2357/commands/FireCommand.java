/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.raypec.frc2357.commands;

import org.raypec.frc2357.CRIORobot;
import org.raypec.frc2357.RobotMap;
import org.raypec.frc2357.subsystems.FiringValveSubsystem;

/**
 *
 */
public class FireCommand extends CommandBase {
	
	private FiringValveSubsystem firingSub;
	private long duration;
	
    public FireCommand() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
	firingSub = CRIORobot.instance.firingSub;
	requires(firingSub);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
	    // TODO: Read this from the smart dashboard
	   duration = 50;
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
	    firingSub.fire(duration);
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
