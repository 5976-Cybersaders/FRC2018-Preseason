package org.usfirst.frc.team5976.robot.commands;

import org.usfirst.frc.team5976.robot.RobotMap;
import org.usfirst.frc.team5976.robot.SmartValue;
import org.usfirst.frc.team5976.robot.subsystems.DriveTrain;

public class DoNothingCommand extends AbstractEncoderDriveCommand {
	private SmartValue miliSeconds;
	private long t0;
	
	public DoNothingCommand(DriveTrain driveTrain) {
		super(driveTrain);
	}
	
	public DoNothingCommand(DriveTrain driveTrian, SmartValue miliSeconds) {
		this(driveTrian);
		this.miliSeconds = miliSeconds;
	}

	protected void initialize() {
		super.initialize();
		t0 = System.currentTimeMillis();
		leftMaster.setSafetyEnabled(false);
		rightMaster.setSafetyEnabled(false);
		reportExecute(leftMaster, "Left Master", RobotMap.LEFT_MASTER_PDP);
		// reportExecute(leftSlave, "Left Slave", RobotMap.LEFT_SLAVE_PDP);
		reportExecute(rightMaster, "Right Master", RobotMap.RIGHT_MASTER_PDP);
		// reportExecute(rightSlave, "Right Slave", RobotMap.RIGHT_SLAVE_PDP);
		System.out.println("INITIALIZE OUTPUT");
	}

	protected void execute() {
		leftSlave.set(leftMaster.getDeviceID());
		rightSlave.set(rightMaster.getDeviceID());
		if (printCounter == printInterval) {
			reportExecute(leftMaster, "Left Master", RobotMap.LEFT_MASTER_PDP);
			// reportExecute(leftSlave, "Left Slave", RobotMap.LEFT_SLAVE_PDP);
			reportExecute(rightMaster, "Right Master", RobotMap.RIGHT_MASTER_PDP);
			// reportExecute(rightSlave, "Right Slave", RobotMap.RIGHT_SLAVE_PDP);
			System.out.println();
			printCounter = 0;
		} else {
			printCounter++;
		}
	}

	@Override
	protected boolean isFinished() {
		if (miliSeconds != null) {
			return System.currentTimeMillis() - t0 > miliSeconds.getLong();
		}
		return false;
	}

	protected void end() {
		leftMaster.setSafetyEnabled(true);
		rightMaster.setSafetyEnabled(true);
	}
}
 