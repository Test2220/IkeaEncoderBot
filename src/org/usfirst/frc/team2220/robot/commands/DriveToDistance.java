package org.usfirst.frc.team2220.robot.commands;

import org.usfirst.frc.team2220.robot.subsystems.TwilightDrive;

import edu.wpi.first.wpilibj.command.Command;

public class DriveToDistance extends Command{

	double targetTicks;
	
	public DriveToDistance(double targetTicks) {
		
		requires(TwilightDrive.getInstance());
		
	}
	
	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
		
		TwilightDrive.getInstance().changeToMotionMagic();
		TwilightDrive.getInstance().resetEncoderPos();
		
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {
		
		TwilightDrive.getInstance().driveSet(targetTicks, targetTicks, false);
		
	}

	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished() {
		return TwilightDrive.getInstance().hasHitBothSetpoints();
	}

	// Called once after isFinished returns true
	@Override
	protected void end() {
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	@Override
	protected void interrupted() {
	
	
	
	}
}
