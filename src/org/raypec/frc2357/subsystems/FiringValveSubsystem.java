
package org.raypec.frc2357.subsystems;

import edu.wpi.first.wpilibj.Preferences;
import java.util.Timer;
import java.util.TimerTask;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.raypec.frc2357.commands.SetCurrentDurationCommand;

/**
 *
 */
public class FiringValveSubsystem extends Subsystem {

	public static final long MIN_DURATION_DEFAULT = 15;
	public static final long MAX_DURATION_DEFAULT = 80;

	private final Preferences prefs;
	private final Solenoid solenoid;
	private final Timer timer;
	private double currentDuration = MIN_DURATION_DEFAULT;
	private long minDuration = MIN_DURATION_DEFAULT;
	private long maxDuration = MAX_DURATION_DEFAULT;
	
	private class FiringCompleteTask extends TimerTask {
		public void run() {
			solenoid.set(false);
		}
	}
	
	public FiringValveSubsystem(Preferences prefs) {
		this.prefs = prefs;
		timer = new Timer();
		solenoid = new Solenoid(1);

		long min = prefs.getLong("minDuration", MIN_DURATION_DEFAULT);
		long max = prefs.getLong("maxDuration", MAX_DURATION_DEFAULT);

		setMinDuration(min);
		setMaxDuration(max);
		setCurrentDuration(min);
	}
	
	public final void reset() {
		setCurrentDuration(MIN_DURATION_DEFAULT);
		setMinDuration(MIN_DURATION_DEFAULT);
		setMaxDuration(MAX_DURATION_DEFAULT);
	}

	public final double getCurrentDuration() {
		return currentDuration;
	}

	public final void setCurrentDuration(double duration) {
		if (duration < minDuration){
			System.err.println("Warning: Trying to set duration < min");
			duration = minDuration;
		}
		if (duration > maxDuration){
			System.err.println("Warning: Trying to set duration > max");
			duration = maxDuration;
		}
		currentDuration = duration;

		double powerRange = maxDuration - minDuration;
		double powerLevel =
			(currentDuration - minDuration) / powerRange;

		SmartDashboard.putNumber("Fire Duration", (long) currentDuration);
		SmartDashboard.putNumber("Power Level", powerLevel);
	}

	public final long getMinDuration() {
		return minDuration;
	}

	public final void setMinDuration(long duration) {
		if (duration > this.maxDuration){
			System.err.println("Warning: Trying to set min duration > max");
			duration = maxDuration;
		}
		minDuration = duration;
		SmartDashboard.putNumber("Fire Min", minDuration);
		prefs.putLong("minDuration", minDuration);
		prefs.save();
	}

	public final long getMaxDuration() {
		return maxDuration;
	}

	public final void setMaxDuration(long duration) {
		if (duration < minDuration){
			System.err.println("Warning: Trying to set max duration < min");
			duration = minDuration;
		}
		maxDuration = duration;
		SmartDashboard.putNumber("Fire Max", maxDuration);
		prefs.putLong("maxDuration", maxDuration);
		prefs.save();
	}
		
	public final void fire() {
		timer.schedule(new FiringCompleteTask(), (long) currentDuration);
		solenoid.set(true);
	}

	public final void initDefaultCommand() {
		// Set the default command for a subsystem here.
		setDefaultCommand(new SetCurrentDurationCommand());
	}
}
