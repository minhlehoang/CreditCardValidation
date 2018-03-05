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
import java.io.FileNotFoundException;
import java.text.NumberFormat;
import java.util.Locale;

import javax.swing.JOptionPane;



public class Payment {
	public static Validation validating;
	public static HashCode hashing;
	public static Customer[] customers;
	// the main entry method of the program that will get data from user and
	// perform the business logic
	public static void main(String[] args) throws FileNotFoundException {
		
		hashing = new HashCode();
		validating = new  Validation();
		int n = 0;
		int k = 0; //number of user attempts
		int ATTEMPTS = 4; // number of allowed attempts
		String fName = null;
		String lName = null;
		Double amount = 0.0;
		Long number = 0L;
		String expDate = null;
		int id = 0;
		int option = JOptionPane.YES_OPTION;
		while(option == JOptionPane.YES_OPTION) {
			try {
				n = Integer.parseInt(JOptionPane.showInputDialog(null, "What is the number of customers?")); // must hold the number of customers based on the user input
				if(n < 0) {
					throw new Exception();
				}
				option = 1;
			}
			catch(Exception ex){
				k++;
				option = JOptionPane.showConfirmDialog(null, "Invalid input! " + "You have " + (ATTEMPTS - k) + " more attempts left. Click Cancel to exit the program.");
				if(option != JOptionPane.YES_OPTION || (k == ATTEMPTS)) {
					JOptionPane.showMessageDialog(null, "Exit program");
					k = 0;
					System.exit(0);
				}
			}
		}
		customers = new Customer[n];
		for (int i = 0; i<customers.length; i++){
			
			if (i == n-1&n>1){JOptionPane.showMessageDialog(null, "The following customer and payment\nwill be the final entry.");} // strike add warning for last
			
			
			option = JOptionPane.YES_OPTION;
			while(option == JOptionPane.YES_OPTION) {
				try {
					fName = JOptionPane.showInputDialog(null, "Please enter the customer's first name.");
					if(fName.length() == 0) {
						throw new Exception();
					}
					option = 1;
				}
				catch(Exception ex){
					k++;
					option = JOptionPane.showConfirmDialog(null, "Invalid input! " + "You have " + (ATTEMPTS - k) + " more attempts left. Click Cancel to exit the program.");
					if(option != JOptionPane.YES_OPTION || (k == ATTEMPTS)) {
						k = 0;
						JOptionPane.showMessageDialog(null, "Exit program");
						System.exit(0);
					}
				}
			}
			
			option = JOptionPane.YES_OPTION;
			while(option == JOptionPane.YES_OPTION) {
				try {
					lName = JOptionPane.showInputDialog(null, "Please enter the customer's last name.");
					if(lName.length() == 0) {
						throw new Exception();
					}
					option = 1;
				}
				catch(Exception ex){
					k++;
					option = JOptionPane.showConfirmDialog(null, "Invalid input! " + "You have " + (ATTEMPTS - k) + " more attempts left. Click Cancel to exit the program.");
					if(option != JOptionPane.YES_OPTION || (k == ATTEMPTS)) {
						k = 0;
						JOptionPane.showMessageDialog(null, "Exit program");
						System.exit(0);
					}
				}
			}
			
			
			option = JOptionPane.YES_OPTION;
			while(option == JOptionPane.YES_OPTION) {
				try {
					id = Integer.parseInt(JOptionPane.showInputDialog(null, "What is the customer's ID number?\nEnter '0' to stop customer input."));
					
						if (id == 0) {
							
							
							
						    int count = 0;
						    for (int index = 0; index < customers.length; index++) 
						    {
						        if(customers[index] != null)
						        {
						            count++;
						        }
						    }
						    
						    // special display out
						    
						    if (n==1) {System.exit(0);} else {
						    
						    JOptionPane.showMessageDialog(null, "Input process will end per your command.\n\nPrevious customer payments will now be displayed.");
						    
					 		String statsOut = "====Customer Statistics====\n";
					 		Locale locale = new Locale("en", "US");      
					 		NumberFormat dollar_format = NumberFormat.getCurrencyInstance(locale);
					 		String average_string = null;
					 		String max_string = null;
					 		String min_string = null;
					 		double total = 0;
					 		double average = 0;
					 		double max = 0;
					 		double min = customers[0].getAmount();
					 		int max_index = 0;
					 		int min_index = 0;
					 		for (int d = 0; d < count; d++) {
					 			total += customers[d].getAmount();
					 			average = total / count;
					 			if(customers[d].getAmount() > max) {
					 				max = customers[d].getAmount();
					 				max_index = d;
					 			}
					 			if(customers[d].getAmount() < min) {
					 				min = customers[d].getAmount();
					 				min_index = d;
					 			}
					 			
				 			}
				 			//statsOut += customers[i].toString() + "\n";
				 		
					 		average_string = "The average amount is: " + dollar_format.format(average) + "\n";
							max_string = "The maximum amount is: " + dollar_format.format(customers[max_index].getAmount()) + "\n";
							min_string = "The minimum amount is: " + dollar_format.format(customers[min_index].getAmount()) + "\n";
							statsOut += average_string + max_string + min_string;
					 		JOptionPane.showMessageDialog(null, statsOut);
							
							
							// end special display out
				 		
					 		// start special write to file
					 		
					 		
					 		String message = "Customers with Valid Payment\r\n";
					     	for (int w = 0; w <count; w++) 
					     		message += customers[w].toStringHash() + hashing.getHashCode(customers[w].getCard().getNumber().toString())+"\r\n";     	
					     	java.io.File file = new java.io.File("Output Hashed Records.txt"); // strike renamed file
					     	java.io.PrintWriter output = new java.io.PrintWriter(file);     	
					     	output.print(message);     	
					     	output.close();     	
					     	JOptionPane.showMessageDialog(null, "Done writing to file,\nwhich has been saved\nin source folder.\n\nHave a nice day."); // strike remove space
					 		
					 		
					 		// end special write to file	
							
							System.exit(0);
						    }
						}
			
					// strike end
					
					option = 1;
				}
				catch(Exception ex){
					k++;
					option = JOptionPane.showConfirmDialog(null, "Invalid input! " + "You have " + (ATTEMPTS - k) + " more attempts left. Click Cancel to exit the program.");
					if(option != JOptionPane.YES_OPTION || (k == ATTEMPTS)) {
						JOptionPane.showMessageDialog(null, "Exit program");
						k = 0;
						System.exit(0);
					}
				}
			}
			
			option = JOptionPane.YES_OPTION;
			while(option == JOptionPane.YES_OPTION) {
				try {
					Double tempAmount = Double.parseDouble(JOptionPane.showInputDialog(null, "What is the payment amount?")); // strike added random discount logic
					if(tempAmount < 0) {
						throw new Exception();
					}
					
					int max = 20;
					int min = 5;
			 		Locale locale = new Locale("en", "US");      
			 		NumberFormat dollar_format = NumberFormat.getCurrencyInstance(locale);
					int discount = min + (int)(Math.random() * ((max - min) + 1));
					double discountFactor = (100.00-discount);
					amount = tempAmount * (discountFactor/100.00);
					String display = "For a payment amount of "+dollar_format.format(tempAmount)+",\nyou qualify for a discount of "+dollar_format.format(tempAmount-amount)+", or "+(discount)+"%.\n\nYour final payment is "+dollar_format.format(amount)+".";
					
					JOptionPane.showMessageDialog(null, display);
					
					// strike
					
					option = 1;
				}
				catch(Exception ex){
					k++;
					option = JOptionPane.showConfirmDialog(null, "Invalid input! " + "You have " + (ATTEMPTS - k) + " more attempts left. Click Cancel to exit the program.");
					if(option != JOptionPane.YES_OPTION || (k == ATTEMPTS)) {
						JOptionPane.showMessageDialog(null, "Exit program");
						k = 0;
						System.exit(0);
					}
				}
			}
			option = JOptionPane.YES_OPTION;
			while(option == JOptionPane.YES_OPTION) {
				try {
					number = Long.parseLong(JOptionPane.showInputDialog(null, "What is the credit card number?")); 
					if(number < 0) {
						throw new Exception();
					}
					else if(isValidCard(number) == true) {
						option = JOptionPane.YES_OPTION;
						while(option == JOptionPane.YES_OPTION) {
							try {
								expDate= JOptionPane.showInputDialog(null, "Please enter the credit card's expiration date.\n(in this format: MM-YYYY)");
								if(expDate.length() == 0) {
									throw new Exception();
								}
								option = 1;
							}
							catch(Exception ex){
								k++;
								option = JOptionPane.showConfirmDialog(null, "Invalid input! " + "You have " + (ATTEMPTS - k) + " more attempts left. Click Cancel to exit the program.");
								if(option != JOptionPane.YES_OPTION || (k == ATTEMPTS)) {
									k = 0;
									JOptionPane.showMessageDialog(null, "Exit program");
									System.exit(0);
								}
							}
						}
						addCustomer(new Customer(fName, lName, id, amount, new CreditCard(number, expDate)));
					}
					else{
						throw new Exception();
					}
					option = 1;
				}
				catch(Exception ex){
					k++;
					option = JOptionPane.showConfirmDialog(null, "Invalid input! " + "You have " + (ATTEMPTS - k) + " more attempts left. Click Cancel to exit the program.");
					if(option != JOptionPane.YES_OPTION || (k == ATTEMPTS)) {
						JOptionPane.showMessageDialog(null, "Exit program");
						k = 0;
						System.exit(0);
					}
				}
			}
		}
		
		displayStat();
		writeToFile();
	} //End of the main class
	
	// this will check whether a card is valid
	public static Boolean isValidCard(Long number){
		return validating.aValidNumber(number.toString());
	}// end of the isValidCard method

	// creates a hash code for the credit card number to be stored in file
    public static String createHashCode(Long number){
    	return hashing.getHashCode(number.toString());
	}// end of the createHashCode method

 // it adds a new customer to the array of customers once the payment was successful
  	 public static void addCustomer(Customer customer){
  		 customers[Customer.getNoOfCustomers()-1] = customer;  		 
  	 } // end of the addCustomer method
  	 
  // it displays the payments AVG, MAX payment, and MIN payment,
 	// only for accepted payments with valid cards
 	public static void displayStat(){
 		String statsOut = "====Customer Statistics====\n";
 		Locale locale = new Locale("en", "US");      
 		NumberFormat dollar_format = NumberFormat.getCurrencyInstance(locale);
 		String average_string = null;
 		String max_string = null;
 		String min_string = null;
 		double total = 0;
 		double average = 0;
 		double max = 0;
 		double min = customers[0].getAmount();
 		int max_index = 0;
 		int min_index = 0;
 		for (int i = 0; i <customers.length; i++) {
 			total += customers[i].getAmount();
 			average = total / customers.length;
 			if(customers[i].getAmount() > max) {
 				max = customers[i].getAmount();
 				max_index = i;
 			}
 			if(customers[i].getAmount() < min) {
 				min = customers[i].getAmount();
 				min_index = i;
 			}
 			//statsOut += customers[i].toString() + "\n";
 		}
 		average_string = "The average amount is: " + dollar_format.format(average) + "\n";
		max_string = "The maximum amount is: " + dollar_format.format(customers[max_index].getAmount()) + "\n";
		min_string = "The minimum amount is: " + dollar_format.format(customers[min_index].getAmount()) + "\n";
		statsOut += average_string + max_string + min_string;
 		JOptionPane.showMessageDialog(null, statsOut);
 	}// end of the displayStat method
	
// write data to file, the credit card number should be encrypted
// using one-way hash method in the Hashing class
 	public static void writeToFile()throws FileNotFoundException {
 		String message = "Customers with Valid Payment\r\n";
     	for (int i = 0; i <customers.length; i++) 
     		message += customers[i].toStringHash() + hashing.getHashCode(customers[i].getCard().getNumber().toString())+"\r\n";     	
     	java.io.File file = new java.io.File("Output Hashed Records.txt"); // strike renamed file
     	java.io.PrintWriter output = new java.io.PrintWriter(file);     	
     	output.print(message);     	
     	output.close();     	
     	JOptionPane.showMessageDialog(null, "Done writing to file,\nwhich has been saved\nin source folder.\n\nHave a nice day."); // strike remove space
     } // end of the writeToFile method
}