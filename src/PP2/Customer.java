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

public class Customer {
	
	private int id;
	private String fName, lName;
	private double amount;
	private CreditCard card;
	private static int noOfCustomers;
	
	public Customer(String fName, String lName, int id, double amount, CreditCard card) {
		super();
		this.fName = fName;
		this.lName = lName;
		this.id = id;
		this.amount = amount;
		this.card = card;
		noOfCustomers++;
		
		
	}

	public static int getNoOfCustomers() {
		return noOfCustomers;
	}

	public static void setNoOfCustomers(int noOfCustomers) {
		Customer.noOfCustomers = noOfCustomers;
	}

	@Override
	public String toString() {
		return "Customer ID = " + id + ", First Name = " + fName + ", Last Name = " + lName + ", Payment Amount = $" + String.format("%.2f",amount) + ", Credit Card = "+ card;
	}
	
	public String toStringHash() {
		return "Customer ID = " + id + ", First Name = " + fName + ", Last Name = " + lName + ", Payment Amount = $" + amount + ", Encrypted CC Number = ";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public CreditCard getCard() {
		return card;
	}

	public void setCard(CreditCard card) {
		this.card = card;
	}
	
	// add public setter/getter methods, and also the toString method

}