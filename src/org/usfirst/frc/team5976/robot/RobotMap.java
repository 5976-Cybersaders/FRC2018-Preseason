package org.usfirst.frc.team5976.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	// DriveTrain Motors CAN IDs
	// Master motors are the front motor
	public static final int LEFT_MASTER = 2;
	public static final int LEFT_SLAVE = 1;
	public static final int RIGHT_MASTER = 4;
	public static final int RIGHT_SLAVE = 3;

	// PDP
	public static final int LEFT_MASTER_PDP = 13;
	public static final int LEFT_SLAVE_PDP = 12;
	public static final int RIGHT_MASTER_PDP = 3;
	public static final int RIGHT_SLAVE_PDP = 2;
}
