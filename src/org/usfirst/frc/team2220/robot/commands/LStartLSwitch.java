package org.usfirst.frc.team2220.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import utils.Converter;

public class LStartLSwitch extends CommandGroup{

	
	
	public LStartLSwitch() {
		
		addSequential(new DriveToDistance(Converter.getInstance().ftToTEncick(14)));
		addSequential(new Delay(2));
		addSequential(new DriveToDistance(Converter.getInstance().ftToTEncick(7)));
		
	}
	
}
