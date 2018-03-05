package PP2;

import java.util.Locale;
import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
 
public class test {
	public static Validation validating;
	public static void main (String[] args) {
		Long number = 371247238281891L;
		String str = String.valueOf(number);
    	int i = 0;    	
		char achar = str.charAt(i);
		if((Integer.parseInt(String.valueOf(achar)) == 37) || (Integer.parseInt(String.valueOf(achar) + String.valueOf(str.charAt(i+1))) == 37 )) {
			System.out.print("true" + "\n") ;
		}
		else {
			System.out.print("false" + "\n");
		}    
		System.out.print((Integer.parseInt(String.valueOf(achar) + String.valueOf(str.charAt(i+1)))) +"\n");
		
		
		//test total odd
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
        
        System.out.print(result + "\n");
        
        //test total even
        int result1 = 0;
        int charConvert;
        // iterate through String elements and calculate total
        String ccStr1 = String.valueOf(number);
        if(ccStr1.length() % 2 == 0) {
        	//System.out.print("length is even");
        	for (int z = 0; z < ccStr1.length(); z = z + 2) {
                    charConvert = ((Integer.parseInt(String.valueOf(ccStr1.charAt(z))) * 2));    
            }
        }
        else {
        	System.out.print("length is odd");
        	System.out.print("\n");
        	for (int z = 1; z < ccStr.length(); z = z + 2) {
                	System.out.print(String.valueOf(ccStr1.charAt(z)));
                    charConvert = ((Integer.parseInt(String.valueOf(ccStr1.charAt(z))) * 2));
                    if(charConvert > 10) {
                    	charConvert = charConvert - 9;
                    }
                    result1 += charConvert;
                    
               
            }
        }
        
        //System.out.print("\n");
        System.out.print(result1);
	}
}