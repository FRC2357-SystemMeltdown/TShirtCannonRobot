/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.raypec.frc2357.subsystems;

import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Talon;
import org.raypec.frc2357.commands.TankDriveCommand;

/**
 *
 * @author Kevin
 */
public class DriveSubsystem extends Subsystem {
	// Put methods for controlling this subsystem
	// here. Call these from Commands.
	
	private Talon left = new Talon(1);
	private Talon right = new Talon(2);
	private RobotDrive drive = new RobotDrive( left, right );

	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		setDefaultCommand(new TankDriveCommand());	
	}
	
	public void arcade(double speed, double rotation) {
		drive.arcadeDrive(speed, rotation);
		System.out.println("arccade runs");
	}
	
	public void tankDrive(double left, double right) {
		drive.tankDrive(left, right);
	}
}
