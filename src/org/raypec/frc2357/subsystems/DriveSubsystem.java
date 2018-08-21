/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.raypec.frc2357.subsystems;

import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Talon;
import org.raypec.frc2357.commands.ArcadeDriveCommand;
import org.raypec.frc2357.devices.LinearTrimSpeedController;

/**
 * Controls the drive base of the T-Shirt Cannon Robot.
 * 
 * Uses arcade mode to control 2 wheelchair motors.
 * Since one motor seems to be faster than the other, this
 * implements a trim system to compensate for the difference.
 */
public class DriveSubsystem extends Subsystem {
	public static final double TRIM_LEFT = 1.0D;
	public static final double TRIM_RIGHT = 1.0D;
	
	private final SpeedController left =
		new LinearTrimSpeedController(new Talon(1), 0, TRIM_LEFT);
	private final SpeedController right =
		new LinearTrimSpeedController(new Talon(2), 0, TRIM_RIGHT);
	private final RobotDrive drive = new RobotDrive( left, right );

	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		setDefaultCommand(new ArcadeDriveCommand());	
	}
	
	public void arcade(double speed, double rotation) {
		drive.arcadeDrive(speed, rotation);
	}
	
	public void tankDrive(double left, double right) {
		drive.tankDrive(left, right);
	}
}
