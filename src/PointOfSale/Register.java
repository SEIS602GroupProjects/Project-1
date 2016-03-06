package PointOfSale;

public class Register {
	
	// Money in drawer
	private double curMoney = 0.00; 
	private int registerID = 0;
	
	public Register(int curRegister)
	{
		registerID = curRegister;
		getRegisterInfo(registerID);
	}
	
	public int GetRegisterID()
	{
		return registerID;
	}
	
	// Add money to the register
	public void AddMoney(double money)
	{
		curMoney += money;
		UpdateRegister();
		// TO DO
	}
	
	// Remove money from the register
	public void RemoveMoney(double money)
	{
		curMoney -= money;
		UpdateRegister();
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
	
	public void UpdateRegister()
	{
		String[] fileInfo = IOSystem.ReadFile("Data/registerInfo.txt");
		
		String[] tmp = new String[fileInfo.length]; 
		for (int i=0; i < fileInfo.length; i++)
		{
			curMoney *= 100;
			curMoney = ((int)curMoney);
			curMoney /= 100;
			String[] tmp_split = fileInfo[i].split(";");
			if (Integer.parseInt(tmp_split[0]) == registerID)
			{
				tmp[i] = registerID + ";" + curMoney;
			}else
			{
				tmp[i] = fileInfo[i];
			}
		}
		IOSystem.WriteFile(tmp, "Data/registerInfo.txt");
	}
	
	
	
}
