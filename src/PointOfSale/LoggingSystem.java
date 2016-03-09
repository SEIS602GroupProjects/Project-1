package PointOfSale;

public class LoggingSystem {
	
	public static void logAction(String action)
	{
		IOSystem.AppendFile(action, "Data/Log.txt");
	}
	
	public static void logRegister(String action)
	{
		IOSystem.AppendFile(action, "Data/RegisterLog.txt");
	}
	
	public static void PrintActionLog()
	{
		String[] tmp = IOSystem.ReadFile("Data/Log.txt");
		
		for (int i=0; i < tmp.length; i++)
		{
			System.out.println(tmp[i]);
		}
	}
	
	public static void PrintRegisterLog()
	{
		String[] tmp = IOSystem.ReadFile("Data/RegisterLog.txt");
		
		for (int i=0; i < tmp.length; i++)
		{
			System.out.println(tmp[i]);
		}
	}
	
}
