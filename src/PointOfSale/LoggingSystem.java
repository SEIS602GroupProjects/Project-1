package PointOfSale;

public class LoggingSystem {
	
	public static void logAction(String action)
	{
		IOSystem.AppendFile(action, "Data/Log.txt");
	}
	
	public static void logCashier(String action)
	{
		IOSystem.AppendFile(action, "Data/CashierLog.txt");
	}
	
	public static void logRegister(String action, int registerID)
	{
		IOSystem.AppendFile(action, "Data/Register" + registerID + ".txt");
	}
	
	public static void PrintActionLog()
	{
		String[] tmp = IOSystem.ReadFile("Data/Log.txt");
		
		for (int i=0; i < tmp.length; i++)
		{
			System.out.println(tmp[i]);
		}
	}
	
	public static void PrintCashierLog()
	{
		String[] tmp = IOSystem.ReadFile("Data/CashierLog.txt");
		
		for (int i=0; i < tmp.length; i++)
		{
			System.out.println(tmp[i]);
		}
	}
	
	public static void PrintRegisterLog(int registerID)
	{
		String[] tmp = IOSystem.ReadFile("Data/Register" + registerID + ".txt");
		
		for (int i=0; i < tmp.length; i++)
		{
			System.out.println(tmp[i]);
		}
	}
	
	
	
}
