package org.usfirst.frc.team5976.robot.subsystems;

import org.usfirst.frc.team5976.robot.OI;
import org.usfirst.frc.team5976.robot.RobotMap;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;

public class DriveTrain extends Subsystem {
	private RobotDrive robotDrive;
	private CANTalon leftMaster, leftSlave, rightMaster, rightSlave;
	private PowerDistributionPanel pdp;
	private OI oi;

	public DriveTrain(OI oi) {
		super();
		System.out.println("START INIT DriveTrian");
		leftMaster = new CANTalon(RobotMap.LEFT_MASTER);
		rightMaster = new CANTalon(RobotMap.RIGHT_MASTER);
		leftSlave = new CANTalon(RobotMap.LEFT_SLAVE);
		rightSlave = new CANTalon(RobotMap.RIGHT_SLAVE);
		pdp = new PowerDistributionPanel();
		this.oi = oi;
	}

	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub

	}

	public void updateDefaultCommandForNonTeleOp() {
		setDefaultCommand(null);
	}

	public void updateDefaultCommandForTeleOp() {
		// TODO add default command

	}

	public CANTalon getLeftMaster() {
		return leftMaster;
	}

	public CANTalon getLeftSlave() {
		return leftSlave;
	}

	public CANTalon getRightMaster() {
		return rightMaster;
	}

	public CANTalon getRightSlave() {
		return rightSlave;
	}

	public PowerDistributionPanel getPdp() {
		return pdp;
	}

	public OI getOi() {
		return oi;
	}

	public RobotDrive getRobotDrive() {
		return robotDrive;
	}

}
