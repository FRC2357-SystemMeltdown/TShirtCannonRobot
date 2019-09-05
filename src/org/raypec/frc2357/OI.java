
package org.raypec.frc2357;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import java.lang.Math;

import org.raypec.frc2357.commands.FireCommand;

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
	static private double deadZoneX = 0.1;
	static private double deadZoneY = 0.1;
	
	private Joystick driveController = new Joystick(1);
	private JoystickButton a;
	
	public OI(){
		a = new JoystickButton(driveController, 1);
		a.whenPressed(new FireCommand());
<<<<<<< Updated upstream
=======
		

		SmartDashboard.putData("Reset Firing", new ResetFiringDurationsCommand());
		SmartDashboard.putData("Set Min", new SetMinDurationCommand());
		SmartDashboard.putData("Set Max", new SetMaxDurationCommand());
>>>>>>> Stashed changes
	}
	
	public Joystick getDriveController(){
		return driveController;
	}
	
	public double getDriveRotation() {
<<<<<<< Updated upstream
<<<<<<< Updated upstream
		double x = driveController.getRawAxis(5);
		return (Math.abs(x) > deadZoneX ? x : 0.0);		
	}
	
	public double getDriveSpeed() {
		double y = driveController.getRawAxis(2);
		return (Math.abs(y) > deadZoneY ? y : 0.0);
	}
	
	public double getTankLeft() {
		double y = driveController.getRawAxis(2);
		return (Math.abs(y) > deadZoneY ? y : 0.0);
	}
	
	public double getTankRight() {
		double y = driveController.getRawAxis(6);
		return (Math.abs(y) > deadZoneY ? y : 0.0);
=======
		double x = driveController.getRawAxis(1);
		System.out.println(x);
		return (Math.abs(x) > DEAD_ZONE_X ? x : 0.0);
               		
=======
		double x = driveController.getRawAxis(1);
		return (Math.abs(x) > DEAD_ZONE_X ? x : 0.0);		
>>>>>>> Stashed changes
	}
	
	public double getDriveSpeed() {
		double y = driveController.getRawAxis(0);
		return (Math.abs(y) > DEAD_ZONE_Y ? y : 0.0);
	}
	
	public double getTankLeft() {
<<<<<<< Updated upstream
		double y = - driveController.getRawAxis(1) * 0.75;
=======
		double y = - driveController.getRawAxis(0) * 0.75;
>>>>>>> Stashed changes
		return (Math.abs(y) > DEAD_ZONE_Y ? y : 0.0);
	}
	
	public double getTankRight() {
<<<<<<< Updated upstream
		double y = driveController.getRawAxis(1) * 0.75;
=======
		double y = driveController.getRawAxis(0) * 0.75;
>>>>>>> Stashed changes
		return (Math.abs(y) > DEAD_ZONE_Y ? y : 0.0);
>>>>>>> Stashed changes
	}
}
	
