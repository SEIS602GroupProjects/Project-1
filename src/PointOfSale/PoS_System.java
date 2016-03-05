package PointOfSale;

import java.util.Scanner;

public class PoS_System {

	private LoginSystem logSys;
	private Cashier cashier;
	
	public PoS_System()
	{
		logSys = new LoginSystem();
		cashier = new Cashier();
		InventorySystem.ReadInventory();
	}
	
	public void Run()
	{
		String tmp = "";
		//logSys.Login();

		System.out.println("Please enter a command:");
		
		
		Scanner in = new Scanner(System.in);
		while (true)
		{
			tmp = in.nextLine();
			// Quit out of loop and system when "exit" is typed
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
		System.out.println("inventory -   Check current inventory.");
		System.out.println();
		System.out.println("Please enter a command:");
	}
	
	// Place to add new commands to
	// If a command "" is typed, do something.
	private boolean Command(String cmd)
	{
		
		if (cmd.equals("help"))
		{
			Help();
		}
		else if (cmd.equals("exit"))
		{
			return false;
		}
		else if (cmd.equals("drawer"))
		{
			// Do something
			
		}
		else if (cmd.equals("inventory"))
		{
			InventorySystem.PrintInventory();
		}
		else
		{
			System.out.println("Incorrect command. Type 'help' for a list of commands.");
		}
		
		return true;
	}
	
}
