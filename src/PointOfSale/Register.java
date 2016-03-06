package PointOfSale;

public class Register {
	
	// Money in drawer
	private double curMoney = 0.00; 
	
	public Register(int curRegister)
	{
		getRegisterInfo(curRegister);
	}
	
	// Add money to the register
	public void AddMoney(double money)
	{
		curMoney += money;
		// TO DO
	}
	
	// Remove money from the register
	public void RemoveMoney(double money)
	{
		curMoney -= money;
		// TO DO
	}
	
	// Return the amount of money in the register
	public double MoneyInDrawer()
	{
		return curMoney;
	}
	
	public void getRegisterInfo(int register)
	{
		String[] tmp = IOSystem.ReadFile("Data/registerInfo.txt");
		
		for (int i=0; i < tmp.length; i++)
		{
			String[] tmp_split = tmp[i].split(";");
			if (Integer.parseInt(tmp_split[0]) == register)
			{
				curMoney = Double.parseDouble(tmp_split[1]);
				//System.out.println(curMoney);
			}
		}
	}
	
	
	
}
