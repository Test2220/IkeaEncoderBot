package org.usfirst.frc.team2220.robot.commands.middlestart;

import org.usfirst.frc.team2220.robot.utils.Converter;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class MStartLSwitch extends CommandGroup{
	
	double target1 = Converter.getInstance().ftToEncTicks(27);
	double target2 = Converter.getInstance().ftToEncTicks(3.49);
	
	
}
