package utils;

public class Converter {
	
	double inputFt;
	double finalTick;
	
	private static Converter _instance = new Converter();
	
	public static Converter getInstance() {
		
		return _instance;
		
	}

	public double ftToTEncick(double inputFt) {
		
		//inputFt = this.inputFt;
		 finalTick = (inputFt * 12) / (4*Math.PI) * 1440 ;
		
		return finalTick;
		
	}

}
