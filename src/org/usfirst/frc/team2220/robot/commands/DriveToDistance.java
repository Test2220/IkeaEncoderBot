package org.usfirst.frc.team2220.robot.commands;

import org.usfirst.frc.team2220.robot.Robot;
import org.usfirst.frc.team2220.robot.subsystems.DrivetrainSubsystem;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class DriveToDistance extends Command{
	
	
	/*
	int driveSpeed = 1000;
	double driveAccel = 2000;
	double turnSpeed = 600;
	double turnAccel = 600;
	
	double tickDistance;
	
	// Called just before this Command runs the first time
		
		public DriveToDistance(double tickDistance) {
			
			requires(DrivetrainSubsystem.getInstance());
			tickDistance = this.tickDistance;
			
		}
	
		@Override
		protected void initialize() {
			
			DrivetrainSubsystem.getInstance().setBothCruiseVel(driveSpeed);
			DrivetrainSubsystem.getInstance().resetEncoderPos();
			
			DrivetrainSubsystem.getInstance().incrementAllPos(tickDistance);
			
		}

		// Called repeatedly when this Command is scheduled to run
		@Override
		protected void execute() {
			
			SmartDashboard.putBoolean("isRunningTeleMotion", true);
			DrivetrainSubsystem.getInstance().incrementAllPos(tickDistance);

		}

		// Make this return true when this Command no longer needs to run execute()
		@Override
		protected boolean isFinished() {
			return DrivetrainSubsystem.getInstance().setpointIsFinished();
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

*/
	
	double finalDistance;
	double currentDistance;
	double inputDistance;
	
	double reachedDistanceFINAL;
	double reachedEncDist;
	
	public DriveToDistance(double Distance) {
	
		inputDistance = Math.abs(Distance);
		
	}


		// Called just before this Command runs the first time
		@Override
		protected void initialize() {
			
			Robot.DriveTrain.resetEncoderPos();
			
		
			
			System.out.println(inputDistance);
			
		}

		// Called repeatedly when this Command is scheduled to run
		@Override
		protected void execute() {
		
			Robot.DriveTrain.incrementAllPos(inputDistance);
			//Robot.DriveTrain.DriveSet(0.2,- 0.2, true);
			System.out.println("COMMAND RUNNING");
			
			reachedEncDist = Robot.DriveTrain.lDriveMaster.getSelectedSensorPosition(0);
			reachedDistanceFINAL = reachedEncDist / 1440 * (4 *  Math.PI) / 12;
			System.out.print(reachedDistanceFINAL);
		}
		// Make this return true when this Command no longer needs to run execute()
		@Override
		protected boolean isFinished() {
			System.out.println(Robot.DriveTrain.setpointIsFinished(inputDistance));
			return Robot.DriveTrain.setpointIsFinished(inputDistance);
			
			
		}

		// Called once after isFinished returns true
		@Override
		protected void end() {
			
			reachedEncDist = Robot.DriveTrain.lDriveMaster.getSelectedSensorPosition(0);
			reachedDistanceFINAL = reachedEncDist / 1440 * (4 *  Math.PI) / 12;
			System.out.print(reachedDistanceFINAL);
			
			System.out.println("END RAN");
			Robot.DriveTrain.driveStop();
			
			
			
		}

		// Called when another command which requires one or more of the same
		// subsystems is scheduled to run
		@Override
		protected void interrupted() {
		}
}
