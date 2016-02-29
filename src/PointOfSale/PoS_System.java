package PointOfSale;

import java.util.Scanner;

public class PoS_System {

	private LoginSystem logSys;
	private InventorySystem invSys;
	
	public PoS_System()
	{
		logSys = new LoginSystem();
		invSys = new InventorySystem();
	}
	
	public void Run()
	{
		String tmp = "";
		logSys.Login();

		System.out.println("Please enter a command:");
		
		Scanner in = new Scanner(System.in);
		while (true)
		{
			tmp = in.nextLine();
			if (!Command(tmp))
			{
				break;
			}
		}
		
		
		
		in.close();
		

		
		System.out.println();
		System.out.println("System shutdown complete.");
	}
	
	private void Help()
	{
		System.out.println("List of Commands: ");
		System.out.println("drawer -      Check current drawer");
		System.out.println("exit -        Exit and shut down system.");
		System.out.println();
		System.out.println("Please enter a command:");
	}
	
	private boolean Command(String cmd)
	{
		
		if (cmd.equals("help"))
		{
			Help();
			return true;
		}
		else if (cmd.equals("exit"))
		{
			return false;
		}
		else if (cmd.equals("drawer"))
		{
			// Do something
			
			return true;
		}
		else
		{
			System.out.println("Incorrect command. Type 'help' for a list of commands.");
			return true;
		}
	}
	
}
