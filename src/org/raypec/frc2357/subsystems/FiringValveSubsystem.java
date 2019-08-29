
package org.raypec.frc2357.subsystems;

import java.util.Timer;
import java.util.TimerTask;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Solenoid;

/**
 *
 */
public class FiringValveSubsystem extends Subsystem {
	private final Solenoid solenoid;
	private final Timer timer;
<<<<<<< Updated upstream
=======
	private double currentDuration = 50;
	private long minDuration = MIN_DURATION_DEFAULT;
	private long maxDuration = MAX_DURATION_DEFAULT;
>>>>>>> Stashed changes
	
	private class FiringCompleteTask extends TimerTask {
		public void run() {
			solenoid.set(false);
		}
	}
	
	public FiringValveSubsystem() {
		timer = new Timer();
		solenoid = new Solenoid(1);
	}
		
	public void fire(long duration) {
		timer.schedule( new FiringCompleteTask(), duration);
		solenoid.set(true);
	}

	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		//setDefaultCommand(new MySpecialCommand());
	
	}
}
