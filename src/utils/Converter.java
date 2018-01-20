package utils;

public class Converter {
	
	double finalTick;
	
	double encTickPerRev = 1440;
	
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
		double turnRatio = degreesToTurn/360;
		
		double arcLengthFt = turnRatio * circumFt;
		double arcLengthTicks = ftToEncTicks(arcLengthFt);
		
		return arcLengthTicks;
		
	}

}
