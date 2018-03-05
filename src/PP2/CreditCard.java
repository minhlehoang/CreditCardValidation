package PP2;

public class CreditCard {
	
//****************************************
//
//				CIS 611	
//				Spring 2018		
//				
//				Andy Carlson
//				Minh Le
//				Ryan Flyn
//
//				PP02
//
//				Classes and Objects
//				
//				March 5, 2018
//	
//				Saved in LeFlynnCarlsonPP02.zip
//
//****************************************
	
	
	private Long number;
	private String expDate;
	
	public CreditCard(Long number, String expDate){
		this.number = number;
		this.expDate = expDate;
	}

	public Long getNumber() {
		return number;
	}

	public void setNumber(Long number) {
		this.number = number;
	}

	public String getExpDate() {
		return expDate;
	}

	public void setExpDate(String expDate) {
		this.expDate = expDate;
	}

	@Override
	public String toString() {
		return "CreditCard [number=" + number + ", expDate=" + expDate + "]";
	}

	// add public setter/getter methods, and also the toString method
}
