package org.usfirst.frc.team2220.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import utils.Converter;

public class TestCommandGroup extends CommandGroup{
	
	public TestCommandGroup() {
		
		System.out.println("RAN ONCE");
		
		double target1 = Converter.getInstance().ftToEncTicks(5);
		double target2 = Converter.getInstance().ftToEncTicks(7);
		
		addSequential(new DriveToDistance(target1));
		//addSequential(new Delay(1));
		//TODO Turn right 90 degrees
		addSequential(new ResetEncoderPos());
		//addSequential(new TurnToAngle(90));
		//addSequential(new Delay(1));
		addSequential(new DriveToDistance(target2));

	}


}
