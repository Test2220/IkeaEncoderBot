package org.usfirst.frc.team2220.robot.commands.leftstart;

import org.usfirst.frc.team2220.robot.commands.DriveToDistance;
import org.usfirst.frc.team2220.robot.commands.TurnToAngle;

import edu.wpi.first.wpilibj.command.CommandGroup;
import utils.Converter;

public class LStartLScale extends CommandGroup{
	
	public LStartLScale() {
		
		double target1 = Converter.getInstance().ftToEncTicks(27);
		double target2 = Converter.getInstance().ftToEncTicks(3.49);
		
		addSequential(new DriveToDistance(target1));
		addSequential(new TurnToAngle(90));
		//Turn Right 90 degrees
		addSequential(new DriveToDistance(target2));
		
	}

}
