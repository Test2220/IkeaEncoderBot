package org.usfirst.frc.team2220.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import utils.Converter;

public class TestCommandGroup extends CommandGroup{
	
	public TestCommandGroup() {
		
		double target1 = Converter.getInstance().ftToTEncick(5);
		double target2 = Converter.getInstance().ftToTEncick(2);
		
		addSequential(new DriveToDistance(target1));
		addSequential(new Delay(2));
		//Turn Right 90 degrees
		addSequential(new DriveToDistance(target2));

	}


}
