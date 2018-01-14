package org.usfirst.frc.team2220.robot.subsystems;

import org.usfirst.frc.team2220.robot.Robot;
import org.usfirst.frc.team2220.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class DrivetrainSubsystem extends Subsystem{
	
	public TalonSRX lDriveMaster;
	public TalonSRX lDriveSlave;
	public TalonSRX rDriveMaster;
	public TalonSRX rDriveSlave;

	private static DrivetrainSubsystem instance_ = new DrivetrainSubsystem();
	
	DifferentialDrive ArtemisDrive;
	
	public AHRS navX;
	
	public static FeedbackDevice QuadEncoder;
	
	double leftPos;
	double rightPos;
	
	double leftRPM;
	double rightRPM;
	
	double ticksPerRev = 1440;
	double cyclesPerRev = 360;
	
	public final static int CLOSEDLOOPERROR = 30; 
	
	public static double rDriveMotorSetpoint = 0;
	public static double lDriveMotorSetpoint = 0;
	
	
	private final int DONE_COUNT_MAX = 10;
	private int currentDoneCount = 0;
	

	public static DrivetrainSubsystem getInstance()
	{
		return instance_;
	}
	
	
	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
	
	}
	

	public DrivetrainSubsystem() {
		
		navX = new AHRS(SPI.Port.kMXP);

		//Master
		lDriveMaster = new TalonSRX(RobotMap.leftMaster);
		rDriveMaster = new TalonSRX(RobotMap.rightMaster);
		
		
		//Slave
		lDriveSlave = new TalonSRX(RobotMap.leftSlave);
		rDriveSlave = new TalonSRX(RobotMap.rightSlave);
		
		
		//Set follow
		lDriveSlave.follow(lDriveMaster);	
		rDriveSlave.follow(rDriveMaster);
		
		
		
		lDriveMaster.setInverted(false); //True for Enc Bot
		lDriveSlave.setInverted(false);
		
		lDriveMaster.setSensorPhase(true);
		lDriveSlave.setSensorPhase(true);
		
		rDriveMaster.setSensorPhase(true);
		rDriveSlave.setSensorPhase(false);
		
		rDriveMaster.setInverted(true);
		rDriveSlave.setInverted(true);
		
		//Set Encoder Stuff
		lDriveMaster.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder, 0, 10);
		rDriveMaster.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder, 0, 10);
		
		lDriveMaster.configAllowableClosedloopError(0, CLOSEDLOOPERROR, 10);
		rDriveMaster.configAllowableClosedloopError(0, CLOSEDLOOPERROR, 10);

		
		//Set PID
		double kP = 0.4, kI = 0.0015, kD = 0.0;
		
		rDriveMaster.config_kP(0, kP, 10);
		rDriveMaster.config_kI(0, kI, 10);
		rDriveMaster.config_kD(0, kD, 10);
		
		lDriveMaster.config_kP(0, kP, 10);
		lDriveMaster.config_kI(0, kI, 10);
		lDriveMaster.config_kD(0, kD, 10);
		
		//Set Motion Magic Profiles
		int  accel = 10, cruiseVel = 10;
		
		lDriveMaster.configMotionAcceleration(accel, 10);
		lDriveMaster.configMotionCruiseVelocity(cruiseVel, 10);
		
		rDriveMaster.configMotionAcceleration(accel, 10);
		rDriveMaster.configMotionCruiseVelocity(cruiseVel, 10);
		

		
	}
	
	//-------------------TYPES OF DRIVE-----------------//
	
	
	//Percent VBus DriveSet
	public void DriveSet(double leftSet, double rightSet, boolean deadzoneCase) {
		if (deadzoneCase) {
			
		leftSet = deadzone(-leftSet);
		rightSet = deadzone(-rightSet);	
		
		lDriveMaster.set(ControlMode.PercentOutput,- leftSet);
		rDriveMaster.set(ControlMode.PercentOutput,rightSet);
		
		} else {
			
			leftSet = deadzone(-leftSet);
			rightSet = deadzone(-rightSet);	
			
		}
	}
	
	//Arcade Drive if Necessary
	public void ArcadeDrive(double ySet, double zSet) {
		
		ArtemisDrive.arcadeDrive(ySet, zSet);
		
	}
	
	//Curvature (Cheesy) drive 
	public void CurvatureDrive(double ySet, double zSet, boolean deadzoneCase, boolean isQuickTurn) {
		
		if (deadzoneCase) {
			
			double leftZoned = deadzone(ySet);
			double rightZoned = deadzone(zSet);
			
			ArtemisDrive.curvatureDrive(ySet, zSet, isQuickTurn);
		}  else {
			
			ArtemisDrive.curvatureDrive(ySet, zSet, isQuickTurn);
			
		}
		
		
	}
	
	//Position Increments
	public void incrementRPosition(double x)
	{
		rDriveMotorSetpoint += x;
		rDriveMaster.set(ControlMode.Position,rDriveMotorSetpoint);
	}

	public void incrementLPosition(double x)
	{
		lDriveMotorSetpoint += x;
		lDriveMaster.set(ControlMode.Position,lDriveMotorSetpoint);
	}

	public void incrementAllPos(double x)	
	{
		incrementRPosition(x);
		incrementLPosition(x);
	}
	
	public void driveStop() {
		
		lDriveMaster.set(ControlMode.PercentOutput, 0);
		rDriveMaster.set(ControlMode.PercentOutput, 0);

		
	}
	
	
	public void setBothCruiseVel(int x)
	{
		setRCruiseVel(x);
		setLCruiseVel(x);
	}

	public void setRCruiseVel(int x)
	{
		rDriveMaster.configMotionCruiseVelocity(x, 10);
	}

	public void setLCruiseVel(int x)
	{
		lDriveMaster.configMotionCruiseVelocity(x, 10);
	}
	
	
	//-----------------Encoder Values---------------//
	
	//Get Left Encoder Ticks
	public double getLeftPos() {
		
		leftPos = lDriveMaster.getSelectedSensorPosition(0);
		return leftPos;
		
	}
	
	
	//Get Right Encoder Ticks
	public double getRightPos() {
		
		rightPos = rDriveMaster.getSensorCollection().getQuadraturePosition();
		return rightPos;
		
	}
	
	
	//Get Left RPM
	public double getLeftRPM() {
		
		leftRPM = lDriveMaster.getSelectedSensorVelocity(0)* (600/1440);
		return leftRPM;
		
	}
	
	///Get Right RPM
	public double getRightRPM() {	
		
		rightRPM = rDriveMaster.getSelectedSensorVelocity(0)* (600/1440);
		return rightRPM;
		
	}
	
	public void resetEncoderPos()
	{
		rDriveMotorSetpoint = 0;
		lDriveMotorSetpoint = 0;	
		rDriveMaster.getSensorCollection().setQuadraturePosition(0, 10);
		System.out.println(getRightPos());
		
		lDriveMaster.getSensorCollection().setQuadraturePosition(0, 10);
		System.out.println(getLeftPos());
	}
	
	public boolean  hasHitLSetpoint() {
		
		return Math.abs(lDriveMaster.getClosedLoopError(0)) < CLOSEDLOOPERROR;
		
	}
	
	public boolean  hasHitRSetpoint() {
		
		return Math.abs(rDriveMaster.getClosedLoopError(0)) < CLOSEDLOOPERROR;
		
	}
	
	/*//Non Functional Distance Set
	public void distanceSet(double input) { 
		
		lDriveMaster.set(ControlMode.Position, -input);
		rDriveMaster.set(ControlMode.Position, input);
		
	}
	*/

	
	//Check whether Set point is finished
	public boolean setpointIsFinished(double inputTick) {
		/*
			if (hasHitRSetpoint() && hasHitLSetpoint())
				currentDoneCount++;
			else
				currentDoneCount = 0;
			if(currentDoneCount > DONE_COUNT_MAX)
			{
				currentDoneCount = 0;
				return true;
			}
			return false;
*/
			//return  lDriveMaster.getClosedLoopError(0) < 30 && rDriveMaster.getClosedLoopError(0) < 30;
		
	return Math.abs(lDriveMaster.getSelectedSensorPosition(0) + rDriveMaster.getSelectedSensorPosition(0)) / 2 > inputTick;
	}
	
	
	
	//Super Basic Deadzone function
	public double deadzone(double val) {
		double signum = Math.signum(val);
		return signum * Math.pow(Math.abs(val), 1.8);
}
}
