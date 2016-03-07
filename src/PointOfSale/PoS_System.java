package PointOfSale;

import java.io.IOException;
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
		logSys.Login();
		
		Scanner in = new Scanner(System.in);		
		System.out.println("Choose a Register (1-3): ");
		
		while (true)
		{
			tmp = in.nextLine();
			try {
				int tmpInt = Integer.parseInt(tmp);
				if (tmpInt >= 1 && tmpInt <= 3)
				{
					cashier.ChooseRegister(tmpInt);
					break;
				}
				else
				{
					System.out.println("Invalid Register #. Please choose a valid one (1-3).");
				}
			}
			catch (NumberFormatException e)
			{
				System.out.println("Invalid Register #. Please choose a valid one (1-3).");
			}
		}
		
		System.out.println("Please enter a command:");
		while (true)
		{
			tmp = in.nextLine();
			// Quit out of loop and system when "exit" is typed
			if (!Command(tmp))
			{
				break;
			}
			System.out.println("Please enter a command:");
		}
		in.close();
		
		System.out.println();
		System.out.println("System shutdown complete.");
	}
	
	private void Help()
	{
		System.out.println("List of Commands: ");
		System.out.println("openDrawer -               Check current money in drawer.");
		System.out.println("user -                     Check current user.");
		System.out.println("sell [item] [quantity] -   Sell a quantity of an item.");
		System.out.println("return [item] [quantity] - Return a quantity of an item.");
		System.out.println("info [item] -              Check item information.");
		System.out.println("exit -                     Exit and shut down system.");
		System.out.println("inventory -                Check current inventory.");
	}
	
	// Place to add new commands to
	// If a command "" is typed, do something.
	private boolean Command(String cmd)
	{
		String[] tmp_split = cmd.split(" ");
		//System.out.println(tmp_split[0]);
		
		if (tmp_split[0].equals("help"))
		{
			Help();
		}
		else if (tmp_split[0].equals("exit"))
		{
			return false;
		}
		else if (tmp_split[0].equals("inventory"))
		{
			InventorySystem.PrintInventory();
		}
		else if (tmp_split[0].equals("user"))
		{
			System.out.println(LoginSystem.getCurUser());
		}
		else if (tmp_split[0].equals("sell"))
		{
			if (tmp_split.length == 3) 
			{
				try 
				{
					cashier.Sell(tmp_split[1], Integer.parseInt(tmp_split[2]));
				}
				catch (NumberFormatException e) 
				{
					System.out.println("Wrong formatting. Please type sell [item] [quantity].");
				}
			} 
			else 
			{
				System.out.println("Wrong formatting. Please type sell [item] [quantity].");
			}
		}
		// Copy/paste/edit for add/remove inventory/set threshold
		else if (tmp_split[0].equals("return"))
		{
			if (tmp_split.length == 3) 
			{
				try 
				{
					cashier.Return(tmp_split[1], Integer.parseInt(tmp_split[2]));
				}
				catch (NumberFormatException e) 
				{
					System.out.println("Wrong formatting. Please type return [item] [quantity].");
				}
			} 
			else 
			{
				System.out.println("Wrong formatting. Please type return [item] [quantity].");
			}
		}
		else if (tmp_split[0].equals("add"))
		{
			if (tmp_split.length == 3) 
			{
				try 
				{
					cashier.addToInventory(tmp_split[1], Integer.parseInt(tmp_split[2]));
				}
				catch (NumberFormatException e) 
				{
					System.out.println("Wrong formatting. Please type add [item] [quantity].");
				}
			} 
			else 
			{
				System.out.println("Wrong formatting. Please type add [item] [quantity].");
			}
		}
		else if (tmp_split[0].equals("remove"))
		{
			if (tmp_split.length == 3) 
			{
				try 
				{
					cashier.removeFromInventory(tmp_split[1], Integer.parseInt(tmp_split[2]));
				}
				catch (NumberFormatException e) 
				{
					System.out.println("Wrong formatting. Please type remove [item] [quantity].");
				}
			} 
			else 
			{
				System.out.println("Wrong formatting. Please type remove [item] [quantity].");
			}
		}
		else if (tmp_split[0].equals("info"))
		{
			if (tmp_split.length == 2) 
			{
				try 
				{
					cashier.ItemInfo(tmp_split[1]);
				}
				catch (ArrayIndexOutOfBoundsException e) 
				{
					System.out.println("Wrong formatting. Please type info [item].");
				}
			} 
			else 
			{
				System.out.println("Wrong formatting. Please type info [item].");
			}
		}
		else if (tmp_split[0].equals("openDrawer"))
		{
			System.out.println(cashier.GetDrawer().MoneyInDrawer());
		}
		else
		{
			System.out.println("Incorrect command. Type 'help' for a list of commands.");
		}
		
		return true;
	}
	
}
