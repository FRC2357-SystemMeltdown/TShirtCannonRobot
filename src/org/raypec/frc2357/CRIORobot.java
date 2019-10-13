/*----------------------------------------------------------------------------*/
/* Copyright (c) FIRST 2008. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.raypec.frc2357;


import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Preferences;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import org.raypec.frc2357.subsystems.FiringValveSubsystem;
import org.raypec.frc2357.subsystems.DriveSubsystem;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class CRIORobot extends IterativeRobot {
	
    public static CRIORobot instance;
    
    public OI oi;
    public FiringValveSubsystem firingSub;
    public DriveSubsystem driveSub;

    private Preferences prefs;

    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
	instance = this;
	System.out.println("robotInit");

	prefs = Preferences.getInstance();
	firingSub = new FiringValveSubsystem(prefs);
	driveSub = new DriveSubsystem();
	oi = new OI();
    }

    public void disabledInit() {
    }

    public void autonomousInit() {
        // schedule the autonomous command (example)
	System.out.println("autonomousInit");
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
    }

    public void teleopInit() {
	// This makes sure that the autonomous stops running when
        // teleop starts running. If you want the autonomous to 
        // continue until interrupted by another command, remove
        // this line or comment it out.
	System.out.println("teleopInit");
    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
        Scheduler.getInstance().run();
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
        LiveWindow.run();
    }
}