/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team2220.robot;

import org.usfirst.frc.team2220.robot.commands.DriveWithXBox;
import org.usfirst.frc.team2220.robot.commands.leftstart.LStartLSwitch;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */

public class OI {
	
	
	Joystick driverStick = new Joystick(0);
	Joystick climberStick = new Joystick(1);
	
	
	Button tankDrive = new JoystickButton(driverStick, 5);
	Button climberButton = new JoystickButton(climberStick, 5);
	Button autoTurnButton = new JoystickButton(driverStick, 11);
	
	Button driveToDistanceButton = new JoystickButton(driverStick, 2);
	
	
	public Joystick getDriverStick() { 
		
		return driverStick;
		
	}
	
	public Joystick getClimberStick() {
		
		return climberStick;
		
	}
	
	public OI(){ 
		
		tankDrive.whenPressed(new DriveWithXBox());
		driveToDistanceButton.whenPressed(new LStartLSwitch());
		//driveToDistanceButton.whenPressed(new DriveStraightForDistance(finalTick));		
		//driveToDistanceButton.whenPressed(new DriveForDistanceGroup(finalTick));
		
	}

	
	
	
}
