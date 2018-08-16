/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.raypec.frc2357.subsystems;

import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Talon;
import org.raypec.frc2357.commands.ArcadeDriveCommand;

/**
 * @author Kevin
 */
public class DriveSubsystem extends Subsystem {
	// Put methods for controlling this subsystem
	// here. Call these from Commands.
	
	private final Talon left = new Talon(1);
	private final Talon right = new Talon(2);
	private final RobotDrive drive = new RobotDrive( left, right );

	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		setDefaultCommand(new ArcadeDriveCommand());	
	}
	
	public void arcade(double speed, double rotation) {
		System.out.println( "speed: " + speed + ", rotation: " + rotation );
		drive.arcadeDrive(speed, rotation);
	}
	
	public void tankDrive(double left, double right) {
		System.out.println( "left: " + left + ", right: " + right );
		drive.tankDrive(left, right);
	}
}
