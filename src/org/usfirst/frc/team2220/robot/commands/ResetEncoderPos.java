package org.usfirst.frc.team2220.robot.commands;

import org.usfirst.frc.team2220.robot.subsystems.TwilightDrive;

import edu.wpi.first.wpilibj.command.Command;

public class ResetEncoderPos extends Command{

	public ResetEncoderPos() {
		
		requires(TwilightDrive.getInstance());
		
	}
	
protected void initialize() {
		
		TwilightDrive.getInstance().changeToPercentVBus();
		
	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return true;
	}
	
	
	

}
