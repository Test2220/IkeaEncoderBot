package org.usfirst.frc.team2220.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitForChildren;

public class DriveForDistanceGroup extends CommandGroup {
	int input; //in encoder ticks 
	final double tenFeet =  (10 * 12 * ( 4* Math.PI) * 1440); //10 ft -> ticks
	
	public DriveForDistanceGroup(double x) { 
		//x is in ticks 
		int repeats  = (int) ( x / tenFeet); 
		addSequential(new DriveToDistance(tenFeet)); 
		addSequential(new WaitForChildren()); 
		addSequential(new DriveToDistance(tenFeet)); 
	}
}
