package org.usfirst.frc.team2220.robot.commands.LeftStart;

import org.usfirst.frc.team2220.robot.commands.Delay;
import org.usfirst.frc.team2220.robot.commands.DriveToDistance;

import edu.wpi.first.wpilibj.command.CommandGroup;
import utils.Converter;

public class LStartLSwitch extends CommandGroup{

	
	
	public LStartLSwitch() {
		
		double tickCheck1 = Converter.getInstance().ftToTEncick(14);
		double tickCheck2 = Converter.getInstance().ftToTEncick(4.6);
		
		System.out.println(tickCheck1);
		System.out.println("RAN ONCE");
		addSequential(new DriveToDistance(tickCheck1));
		//addSequential(new Delay(2));
		//Turn Right 90 degrees
		addSequential(new DriveToDistance(tickCheck2));
	
	}
	
}
