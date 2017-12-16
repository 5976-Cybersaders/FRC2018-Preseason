package org.usfirst.frc.team5976.robot.commands;

import org.usfirst.frc.team5976.robot.RobotMap;
import org.usfirst.frc.team5976.robot.SmartDashboardMap;
import org.usfirst.frc.team5976.robot.subsystems.DriveTrain;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.command.Command;

public class EncoderInit extends Command {
	private CANTalon leftMaster, rightMaster, leftSlave, rightSlave;
	private boolean inversion = false;

	public EncoderInit(DriveTrain driveTrain) {
		leftMaster = driveTrain.getLeftMaster();
		leftSlave = driveTrain.getLeftSlave();
		rightMaster = driveTrain.getRightMaster();
		rightSlave = driveTrain.getRightSlave();
		requires(driveTrain);
	}

	protected void initialize() {
		initMaster(leftMaster, -1);
		initMaster(rightMaster, 1);
		initialize(leftMaster);
		initialize(rightMaster);
		initSlave(leftSlave, RobotMap.LEFT_MASTER);
		initSlave(rightSlave, RobotMap.RIGHT_MASTER);
	}

	protected void initialize(CANTalon talon) {
		talon.reset();
		talon.enable();
		talon.setPosition(0);
	}

	protected void initMaster(CANTalon talon, int side) {
		talon.setControlMode(CANTalon.TalonControlMode.Position.value);
		talon.set(0);
		talon.setFeedbackDevice(CANTalon.FeedbackDevice.CtreMagEncoder_Absolute);
		talon.setEncPosition(0);
		
		// Set values here
		// Profile 1 for Both
		talon.setProfile(1);
		talon.setVoltageRampRate(SmartDashboardMap.RAMP_RATE.getDouble());
		if (side == -1){//Left
			talon.setP(SmartDashboardMap.kPRL.getDouble());
			talon.setI(SmartDashboardMap.kIRL.getDouble());
			talon.setD(SmartDashboardMap.kDRL.getDouble());
			
			talon.setProfile(0);
			talon.setP(SmartDashboardMap.kPFL.getDouble());
			talon.setI(SmartDashboardMap.kIFL.getDouble());
			talon.setD(SmartDashboardMap.kDFL.getDouble());
			talon.configPeakOutputVoltage(SmartDashboardMap.PEAK_VOLTAGE.getDouble(),
					-SmartDashboardMap.PEAK_VOLTAGE.getDouble());
		}
		else {
			talon.setP(SmartDashboardMap.kPRR.getDouble());
			talon.setI(SmartDashboardMap.kIRR.getDouble());
			talon.setD(SmartDashboardMap.kDRR.getDouble());
			
			talon.setProfile(0);
			talon.setP(SmartDashboardMap.kPFR.getDouble());
			talon.setI(SmartDashboardMap.kIFR.getDouble());
			talon.setD(SmartDashboardMap.kDFR.getDouble());
			talon.configPeakOutputVoltage(SmartDashboardMap.PEAK_VOLTAGE.getDouble(),
					-SmartDashboardMap.PEAK_VOLTAGE.getDouble() - 1);
		}
		// Profile 0 For Both
		talon.setVoltageRampRate(SmartDashboardMap.RAMP_RATE.getDouble());
		System.out.println("Setting allowable error to " + SmartDashboardMap.ALLOWABLE_ERROR.getDouble());
		talon.setAllowableClosedLoopErr((int) SmartDashboardMap.ALLOWABLE_ERROR.getDouble());
		talon.enableControl();
		
		talon.configNominalOutputVoltage(SmartDashboardMap.NOMINAL_VOLTAGE.getDouble(),
				-SmartDashboardMap.NOMINAL_VOLTAGE.getDouble());
	}

	protected void initSlave(CANTalon talon, int masterID) {
		talon.changeControlMode(CANTalon.TalonControlMode.Follower);
		talon.set(masterID);
		talon.enable();
	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return true;
	}
}
