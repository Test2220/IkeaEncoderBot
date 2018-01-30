package org.usfirst.frc.team2220.robot.commands;

import org.usfirst.frc.team2220.robot.commands.leftstart.LStartLScale;
import org.usfirst.frc.team2220.robot.commands.leftstart.LStartLSwitch;

import edu.wpi.first.wpilibj.command.InstantCommand;
import openrio.powerup.MatchData;

public class LeftAutoHelper extends InstantCommand{
	
	
	@Override
	protected void initialize() {
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {
		MatchData.OwnedSide switchSide = MatchData.getOwnedSide(MatchData.GameFeature.SWITCH_NEAR);
		MatchData.OwnedSide scaleSide = MatchData.getOwnedSide(MatchData.GameFeature.SCALE);

		if (switchSide == MatchData.OwnedSide.LEFT) {
			
			new LStartLSwitch();
			
		} else if (switchSide == MatchData.OwnedSide.RIGHT) {
				
				if (scaleSide == MatchData.OwnedSide.LEFT) {
					
					new LStartLScale();
					
				}
				
				
			}
			
		}


}
