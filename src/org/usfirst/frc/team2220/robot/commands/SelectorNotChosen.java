package org.usfirst.frc.team2220.robot.commands;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.InstantCommand;
import openrio.powerup.MatchData;

public class SelectorNotChosen extends InstantCommand{

	//CALLED ONLY IF SELECTORS ARE NOT SELECTED
	
	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
		
		int placementData = DriverStation.getInstance().getLocation(); //Default Location
		
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {

	}

}