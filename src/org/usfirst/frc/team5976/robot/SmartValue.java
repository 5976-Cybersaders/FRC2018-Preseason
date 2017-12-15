package org.usfirst.frc.team5976.robot;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class SmartValue {
	private String key;
	private double defaultValue;

	public SmartValue(String key, double defaultValue) {
		this.key = key;
		this.defaultValue = defaultValue;
		SmartDashboard.putNumber(key, defaultValue);
	}

	private double getValue() {
		return SmartDashboard.getNumber(key, defaultValue);
	}

	public long getLong() {
		return (long) getValue();
	}

	public double getDouble() {
		return getValue();
	}

	public String getKey() {
		return key;
	}
}