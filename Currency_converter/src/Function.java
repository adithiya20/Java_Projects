
public class Function {
	/*Checks if input is a valid number or not*/
	public boolean check(String input) {
		try {
			double x = Double.parseDouble(input);
			if(x>=0 || x<0);
			return true;
		}catch(NumberFormatException e){
		return false;	
		}
	}
	
	public void dollarToNok(double input) {
		double nok = input * 8.2;
		System.out.println("Amount in Nok:\t"+ nok);	
	}
	
	
	public void dollarToJPY(double input) {
		char yen='\u00A5';
		double JPY = input * 112.7;
		System.out.println("Amount in JPY:\t"+ yen+ JPY);
		
	}
	
	public void dollarToCAD(double input) {
		char CAD='\u0024';
		double JPY = input * 1.33;
		System.out.println("Amount in CAD:\t"+ CAD+ JPY);
	}

	public void dollarToINR(double input) {
		char INR='\u20B9';
		double JPY = input * 83.22;
		System.out.println("Amount in JPY:\t"+ INR+ JPY);
		
	}
}
