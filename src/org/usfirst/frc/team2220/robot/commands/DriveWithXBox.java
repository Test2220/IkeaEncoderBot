package org.usfirst.frc.team2220.robot.commands;

import org.usfirst.frc.team2220.robot.Robot;
import org.usfirst.frc.team2220.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

public class DriveWithXBox extends Command{

	// Called just before this Command runs the first time
	
		protected void DriveWithXBox() {
			
			requires(Robot.DriveTrain);
			
		}
	
		@Override
		protected void initialize() {
			
			
		}

		// Called repeatedly when this Command is scheduled to run
		@Override
		protected void execute() {
			
			//Negated for appropriation
			
			double leftSet = -Robot.oi.getDriverStick().getRawAxis(1);
			double rightSet = -Robot.oi.getDriverStick().getRawAxis(5);
			
			Robot.DriveTrain.DriveSet(leftSet, -rightSet, true);
			
		}

		// Called once after isFinished returns true
		@Override
		protected void end() {

		}
		

		@Override
		protected boolean isFinished() {
			// TODO Auto-generated method stub
			return false;
		}

		// Called when another command which requires one or more of the same
		// subsystems is scheduled to run
		@Override
		protected void interrupted() {
			
			
		}

}
