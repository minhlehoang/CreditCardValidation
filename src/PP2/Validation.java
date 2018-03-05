package PP2;

//****************************************
//
//			CIS 611	
//			Spring 2018		
//			
//			Andy Carlson
//			Minh Le
//			Ryan Flyn
//
//			PP02
//
//			Classes and Objects
//			
//			March 5, 2018
//	
//			Saved in LeFlynnCarlsonPP02.zip
//
//****************************************


public class Validation
{
    // Return true if the card number is valid, otherwise returns false, this method
    // is already implemented
    public boolean aValidNumber(String n) {
        long number = Long.parseLong(n);
        return (numLength(number) >= 13)
                && (numLength(number) <= 16) && (prefixCheck(number, 4) || prefixCheck(number, 5)
                        || prefixCheck(number, 6) || prefixCheck(number, 37))
                && (totalEvenNumbers(number) + totalOddNumbers(number)) % 10 == 0;
    }// end of aValidNumber method
    
    // get the sum of even places numbers, Starting from the second digit from right
    private int totalEvenNumbers(long number) {
        int result = 0;
        int charConvert;
        // iterate through String elements and calculate total
        String ccStr = String.valueOf(number);
        if(ccStr.length() % 2 == 0) {
        	//System.out.print("length is even");
        	for (int z = 0; z < ccStr.length(); z = z + 2) {
                    charConvert = ((Integer.parseInt(String.valueOf(ccStr.charAt(z))) * 2)); 
                    result += singleDigit(charConvert);
            }
        }
        else {
        	System.out.print("length is odd");
        	System.out.print("\n");
        	for (int z = 1; z < ccStr.length(); z = z + 2) {
                    charConvert = ((Integer.parseInt(String.valueOf(ccStr.charAt(z))) * 2));                    
                    result += singleDigit(charConvert);
            }
        }
        return result;
    }// end of totalEevenNumbers method

    // Return the same number if it is a single digit, otherwise, return the sum of
    // the two digits in this number
    private int singleDigit(int number) {
        if (number < 10)
            return number;
        else {
        	number = number - 9;
        	return number;
        }
    } // end of singleDigit method

    // Return the sum of odd place digits in number
    private int totalOddNumbers(long number) {
        int result = 0;
        // iterate through String elements and calculate total
        String ccStr = String.valueOf(number);
        if(ccStr.length() % 2 == 0) {
        	for (int z = 1; z < ccStr.length(); z = z + 2) {
        		result += ((Integer.parseInt(String.valueOf(ccStr.charAt(z)))));         
            }
        }
        else {
        	for(int z = 0; z < ccStr.length(); z = z + 2) {
        		result += ((Integer.parseInt(String.valueOf(ccStr.charAt(z)))));   
        	}
        }
        return result;
    }// end of totalOddNumbers method

    // Return true if the digit d is a prefix for number
    private boolean prefixCheck(long number, int d) {
    	String str = String.valueOf(number);
    	int i = 0;    	
		char achar = str.charAt(i);
		if((Integer.parseInt(String.valueOf(achar)) == d) || (Integer.parseInt(String.valueOf(achar) + String.valueOf(str.charAt(i+1))) == d )) {
			return true;
		}
		else {
			return false;
		}    		
    }// end of prefixCheck method

    // Return the number of digits in this number parameter
    private int numLength(long number) {
        String ccStr = String.valueOf(number);
        return ccStr.length();
    }// end of numLength method

    // Return the first k number of digits from number, which is either a first
    // digit or first two digits
    // Depending on the card type
    private long numPrefix(long number, int k) {
        return 0L;
    }// end of numPrefix method
}// end of the class

