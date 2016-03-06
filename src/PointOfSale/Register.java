package PointOfSale;

public class Register {
	
	// Money in drawer
	private double curMoney = 15.00; 
	
	// Add money to the drawer
	public void AddMoney(double money)
	{
		curMoney += money;
		// TO DO
	}
	
	// Remove money from the drawer
	public void RemoveMoney(double money)
	{
		curMoney -= money;
		// TO DO
	}
	
	// Return the amount of money in the drawer
	public double MoneyInDrawer()
	{
		return curMoney;
	}
	
	
}
