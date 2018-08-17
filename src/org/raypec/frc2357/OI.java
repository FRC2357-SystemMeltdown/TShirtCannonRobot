
package org.raypec.frc2357;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.raypec.frc2357.commands.FireCommand;
import org.raypec.frc2357.commands.ResetFiringDurationsCommand;
import org.raypec.frc2357.commands.SetMaxDurationCommand;
import org.raypec.frc2357.commands.SetMinDurationCommand;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	//// CREATING BUTTONS
	// One type of button is a joystick button which is any button on a joystick.
	// You create one by telling it which joystick it's on and which button
	// number it is.
	// Joystick stick = new Joystick(port);
	// Button button = new JoystickButton(stick, buttonNumber);

	// Another type of button you can create is a DigitalIOButton, which is
	// a button or switch hooked up to the cypress module. These are useful if
	// you want to build a customized operator interface.
	// Button button = new DigitalIOButton(1);

	// There are a few additional built in buttons you can use. Additionally,
	// by subclassing Button you can create custom triggers and bind those to
	// commands the same as any other Button.

	//// TRIGGERING COMMANDS WITH BUTTONS
	// Once you have a button, it's trivial to bind it to a button in one of
	// three ways:

	// Start the command when the button is pressed and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenPressed(new ExampleCommand());

	// Run the command while the button is being held down and interrupt it once
	// the button is released.
	// button.whileHeld(new ExampleCommand());

	// Start the command when the button is released  and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenReleased(new ExampleCommand());

	// Center stick dead areas
	static private final double DEAD_ZONE_X = 0.1;
	static private final double DEAD_ZONE_Y = 0.1;
	static private final double DEAD_ZONE_TRIGGER = 0.01;

	// Ratio of stick input to duration adjustment
	static private final double DURATION_ADJUST_FACTOR = 0.75;
	
	private final Joystick driveController = new Joystick(1);
	private final JoystickButton a;
	
	public OI(){
		a = new JoystickButton(driveController, 1);
		a.whenPressed(new FireCommand());

		SmartDashboard.putData("Reset Firing", new ResetFiringDurationsCommand());
		SmartDashboard.putData("Set Min", new SetMinDurationCommand());
		SmartDashboard.putData("Set Max", new SetMaxDurationCommand());
	}
	
	public Joystick getDriveController(){
		return driveController;
	}

	public double getDurationAdjustment() {
		// The differential between triggers are one axis
		// Left trigger goes 0 to +1, Right trigger goes 0 to -1
		double stickInput = driveController.getRawAxis(3);
		double filteredInput =
			(Math.abs(stickInput) > DEAD_ZONE_TRIGGER ? - stickInput : 0);
		return filteredInput * DURATION_ADJUST_FACTOR;
	}
	
	public double getDriveRotation() {
		double x = driveController.getRawAxis(2);
		return (Math.abs(x) > DEAD_ZONE_X ? x : 0.0);		
	}
	
	public double getDriveSpeed() {
		double y = driveController.getRawAxis(4);
		return (Math.abs(y) > DEAD_ZONE_Y ? y : 0.0);
	}
	
	public double getTankLeft() {
		double y = - driveController.getRawAxis(2) * 0.75;
		return (Math.abs(y) > DEAD_ZONE_Y ? y : 0.0);
	}
	
	public double getTankRight() {
		double y = driveController.getRawAxis(5) * 0.75;
		return (Math.abs(y) > DEAD_ZONE_Y ? y : 0.0);
	}
}
	
