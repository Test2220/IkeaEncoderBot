package org.usfirst.frc.team2220.robot.utils;

public class Converter {

	double finalTick;

	double encTickPerRev = 1440; //https://www.andymark.com/E4T-OEM-Miniature-Optical-Encoder-Kit-p/am-3132.htm

	double wheelDiameter = 4;
	double wheelCircumference = Math.PI * 4;

	double frameWidthFt = 27.5/12;

	
	private static Converter _instance = new Converter();

	public static Converter getInstance() {

		return _instance;

	}

	public double ftToEncTicks(double inputFt) {

		//inputFt = this.inputFt;

		return (inputFt * 12) / (wheelCircumference) * encTickPerRev ;

	}

	public double degreesTurnToEncTicks(double degreesToTurn) {

		double circumFt = frameWidthFt * Math.PI;
		double turnRatio = (degreesToTurn + 15)/360;

		double arcLengthFt = turnRatio * circumFt;
		double arcLengthTicks = ftToEncTicks(arcLengthFt);


		return arcLengthTicks;

	}

	public double maxRPMToFGain(int maxRPM) {

		if (maxRPM ==  0) {

			return 0;

		} else {

			double fGainTemp = maxRPM * (1.0/60) * (1.0/10) * (encTickPerRev/1);
			double fGain = 1023.0/fGainTemp;
			System.out.println("FGain = " + fGain);
			return fGain;

		}
	}

	public double errorToPGain(double error, double pMultiplier) {
		if (error == 0) {

			return 0;

		} else {

			double pGain = (pMultiplier*1023) / error;
			return pGain;

		}
	}

}
