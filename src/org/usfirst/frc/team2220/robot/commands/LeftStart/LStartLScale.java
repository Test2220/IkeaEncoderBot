package org.usfirst.frc.team2220.robot.commands.LeftStart;

import org.usfirst.frc.team2220.robot.commands.DriveToDistance;

import edu.wpi.first.wpilibj.command.CommandGroup;
import utils.Converter;

public class LStartLScale extends CommandGroup{
	
	public LStartLScale() {
		
		double target1 = Converter.getInstance().ftToTEncick(27);
		double target2 = Converter.getInstance().ftToTEncick(3.49);
		
		addSequential(new DriveToDistance(target1));
		//Turn Right 90 degrees
		addSequential(new DriveToDistance(target2));
		
	}

}
