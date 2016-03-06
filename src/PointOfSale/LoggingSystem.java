package PointOfSale;

public class LoggingSystem {

	//private String action = new String();
	
	public static void logAction(String action)
	{
		IOSystem.AppendFile(action, "Data/Log.txt");
	}
	
	
	
}
