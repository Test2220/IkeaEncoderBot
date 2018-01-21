package org.usfirst.frc.team2220.robot.commands;

import org.usfirst.frc.team2220.robot.subsystems.TwilightDrive;

import edu.wpi.first.wpilibj.command.Command;

public class ClockwiseTurn extends Command{
	@SuppressWarnings("deprecation")


	double targetTicks;
	
	public ClockwiseTurn(double targetTicks) {
		
		requires(TwilightDrive.getInstance());
		this.targetTicks = targetTicks;
		
	}
	
	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
		TwilightDrive.getInstance().resetEncoderPos();
		
		TwilightDrive.getInstance().setBothAccel(300);
		TwilightDrive.getInstance().setBothCruiseVel(500);
		TwilightDrive.getInstance().changeToMotionMagic();

		
		
		System.out.println("Initialized");
		System.out.println(targetTicks);
		
		TwilightDrive.getInstance().driveSet(targetTicks, -targetTicks);

	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {
		System.out.println(TwilightDrive.getInstance().lDriveMaster.getClosedLoopError());

		//System.out.println("CLOCKWISE TURN");
		
	}

	// Make this return true when this sCommand no longer needs to run execute()
	@Override
	protected boolean isFinished() {
		//System.out.println(Math.abs(TwilightDrive.getInstance().lDriveMaster.getPosition()) - targetTicks  < 30);
	return TwilightDrive.getInstance().hasHitBothSetpoints(targetTicks);
	
	}

	// Called once after isFinished returns true
	@Override
	protected void end() {
		System.out.println("ENDED?");
    	TwilightDrive.getInstance().changeToPercentVBus();

	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	@Override
	protected void interrupted() {
	
	
	
	}

}
