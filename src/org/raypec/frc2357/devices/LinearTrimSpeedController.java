/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.raypec.frc2357.devices;

import edu.wpi.first.wpilibj.SpeedController;

/**
 * Adds a linear trim setting to a speed controller.
 */
public class LinearTrimSpeedController implements SpeedController {
	private final SpeedController controller;
	private final double min;
	private final double max;
	private double inputValue;

	public LinearTrimSpeedController(SpeedController controller, double min, double max) {
		this.controller = controller;
		this.min = min;
		this.max = max;
		this.inputValue = 0.0D;
	}

	private double convertInputValue(double value){
		return (value * (max - min)) + min;
	}

	public double get() {
		return inputValue;
	}

	public void set(double value, byte syncGroup) {
		this.inputValue = value;
		controller.set(convertInputValue(value), syncGroup);
	}

	public void set(double value) {
		this.inputValue = value;
		controller.set(convertInputValue(value));
	}

	public void disable() {
		controller.disable();
	}

	public void pidWrite(double d) {
		throw new Error("Not supported yet.");
	}
	
}
