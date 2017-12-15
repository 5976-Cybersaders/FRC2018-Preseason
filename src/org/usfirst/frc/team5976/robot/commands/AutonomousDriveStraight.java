package org.usfirst.frc.team5976.robot.commands;

import org.usfirst.frc.team5976.robot.SmartDashboardMap;
import org.usfirst.frc.team5976.robot.subsystems.DriveTrain;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutonomousDriveStraight extends CommandGroup {

	public AutonomousDriveStraight(DriveTrain driveTrain) {
		System.out.println("START Command Group");
		commandGroup(driveTrain);
		System.out.println("END Command Group");

	}

	public void commandGroup(DriveTrain driveTrain) {
		addSequential(new EncoderInit(driveTrain));
		addSequential(new EncoderDriveStraight(driveTrain, SmartDashboardMap.DRIVE_DISTANCE_1));
		addSequential(new DoNothingCommand(driveTrain, SmartDashboardMap.TIME));
		addSequential(new EncoderDriveStraight(driveTrain, SmartDashboardMap.DRIVE_DISTANCE_2));
		// addSequential(new DoNothingCommand(driveTrain));
	}

}
