/* TODO: Replace these file comments with a description of what your program
 * does.
 * 
 * 
 * 
 * 
 * I honestly think this code could have been down a lot easier.
 * 
 * =(
 */
import acm.program.*;

public class AlgorismAlgorithms extends ConsoleProgram {
	public void run() {
		/* Sit in a loop, reading numbers and adding them. */
		while (true) {
			String n1 = readLine("Enter first number:  ");
			String n2 = readLine("Enter second number: ");
			println(n1 + " + " + n2 + " = " + addNumericStrings(n1, n2));
			println();
		}
	}
	
	/**
	 * Given two string representations of nonnegative integers, adds the
	 * numbers represented by those strings and returns the result.
	 * 
	 * @param n1 The first number.
	 * @param n2 The second number.
	 * @return A String representation of n1 + n2
	 */
	private String addNumericStrings(String n1, String n2) {
		
		String result = "";
		int digit = 0;
		int counter = 0;
		int i = 1;
		boolean carry = false;
		
		//determine bigger string
		if(Math.abs(n1.length()-n2.length() ) == 0){
			counter = n1.length();
		}else if(n1.length() > n2.length()){
			counter = n1.length();
		}else{
			counter = n2.length();
		}
		
		//algorithm for adding
		for(int j = 0; j< counter ;j++){
			
			//if both digits available , then add
			if(n1.length()-i >= 0 && n2.length()-i >= 0){
				digit = (n1.charAt(n1.length()-i) - '0' )+ (n2.charAt(n2.length()-i) - '0');
				if(checkLimit(digit)){
					digit = digit - 10  ;
					
					digit += carryOver(carry);
					if(carryOver(carry) == 1)carry = false;
					result = digit + result;
					carry = true;
				}else{
					
					digit += carryOver(carry);
					if(carryOver(carry) == 1)carry = false;
					if(digit > 9){
						digit = digit - 10;
						carry = true;
					}
					result = digit + result;

				
				}


				i++;
		
			//if only 2nd string available, then add with 0
			}else if(n1.length()-i < 0 ){
				digit = 0 + (n2.charAt(n2.length()-i) - '0');
				digit += carryOver(carry);
				if(carryOver(carry) == 1)carry = false;
				result = digit + result;
				i++;
			}
			//if only 1st string available, then add with 0
			else if(n2.length()-i < 0){
				digit = 0 + (n1.charAt(n1.length()-i) - '0');
				digit += carryOver(carry);
				if(carryOver(carry) == 1)carry = false;
				result = digit + result;
				i++;
			}
		}
		
		if(carryOver(carry) == 1)result = "1" + result;
		
		
		
		return result;	
	}
	
	private boolean checkLimit(int digit){
		if(digit >= 10){
			return true;
		}else{
			return false;
		}
	}
	
	private int carryOver(boolean carryValue){
		if(carryValue){
			
			return 1;
		}else{
			return 0;
		}
	}


}



