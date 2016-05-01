package PointOfSale;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

enum SysMode {
	deflt,
	order
}

public class PoS_System {

	private LoginSystem logSys;
	private Cashier cashier;
	private Scanner in;
	private String tmp = "";
	
	private SysMode curMode = SysMode.deflt;
	
	private Order order;
	
	public PoS_System()
	{
		logSys = new LoginSystem();
		cashier = new Cashier();
		InventorySystem.ReadInventory();
	}
	
	public void Run()
	{
		in = new Scanner(System.in);
		logSys.Login(in);
		logSys.ChooseRegister(in, cashier);
		
		System.out.println("Please enter a command (or type 'help'):");
		while (true)
		{
			tmp = in.nextLine();
			// Quit out of loop and system when "exit" is typed
			if (!Command(tmp))
			{
				break;
			}
			System.out.println("Please enter a command (or type 'help'):");
		}
		in.close();
		
		System.out.println("System shutdown complete.");
	}
	
	private void Help()
	{
		if (curMode == SysMode.deflt)
		{
			System.out.println("List of Commands: ");
			System.out.println("drawer -                             Check current money in drawer.");
			System.out.println("user -                               Check current user.");
			System.out.println("sell [item] [quantity] -             Sell a quantity of an item.");
			System.out.println("return [item] [quantity] -           Return a quantity of an item.");
			System.out.println("add [item] [quantity] -              Add items to the inventory.");
			System.out.println("remove [item] [quantity] -           Remove items from the inventory.");
			System.out.println("setThreshold [item] [newThreshold] - Set threshold for re-order.");
			System.out.println("info [item] -                        Check item information.");
			System.out.println("inventory -                          Check current inventory.");
			System.out.println("actionlog -                          Print out the log of every action taken");
			System.out.println("saleslog -                           Print out the log of sales made");
			System.out.println("reglog [RegisterID] -                Print out the log of a particular register.");
			System.out.println("logout -                             Log out of system and let another user log in.");
			System.out.println("exit -                               Exit and shut down system.");
		}
		else if (curMode == SysMode.order)
		{
			System.out.println("List of Commands: ");
			System.out.println("drawer -                             Check current money in drawer.");
			System.out.println("add [item] [quantity] -              Add an item to the order.");
			System.out.println("remove [item] [quantity] -           Remove an item from the order.");
			System.out.println("status -                             View order status.");
			System.out.println("complete -                           Complete an order and exit the ordering system.");
			System.out.println("cancel -                             Cancel an order and exit the ordering system.");
		}
	}
	
	// Place to add new commands to
	// If a command "" is typed, do something.
	private boolean Command(String cmd)
	{
		String[] tmp_split = cmd.split(" ");
		//System.out.println(tmp_split[0]);
		
		if (curMode == SysMode.deflt)
		{
			if (tmp_split[0].equals("help"))
			{
				Help();
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
		else if (tmp_split[0].equals("setThreshold"))
		{
			if (tmp_split.length == 3) 
			{
				try 
				{
					cashier.setThreshold(tmp_split[1], Integer.parseInt(tmp_split[2]));
				}
				catch (NumberFormatException e) 
				{
					System.out.println("Wrong formatting. Please type setThreshold [item] [newThreshold]");
				}
			} 
			else 
			{
				System.out.println("Wrong formatting. Please type setThreshold [item] [newThreshold]");			
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
		else if (tmp_split[0].equals("drawer"))
		{
			System.out.println("Total Sales during shift: $" + cashier.ShiftSales());
			System.out.println("Cash in Register #" + cashier.GetDrawer().GetRegisterID() +
							": $" + cashier.GetDrawer().MoneyInDrawer());
		}
		else if (tmp_split[0].equals("actionlog"))
		{
			LoggingSystem.PrintActionLog();
		}
		else if (tmp_split[0].equals("saleslog"))
		{
			LoggingSystem.PrintCashierLog();
		}
		else if (tmp_split[0].equals("reglog"))
		{
			if (tmp_split.length == 2) 
			{
				try 
				{
					LoggingSystem.PrintRegisterLog(Integer.parseInt(tmp_split[1]));
				}
				catch (NumberFormatException e) 
				{
					System.out.println("Wrong formatting. Please type reglog [RegisterID]");
				}
			} 
			else 
			{
				System.out.println("Wrong formatting. Please type reglog [RegisterID]");			
			}
		}
		else if (tmp_split[0].equals("logout"))
		{
			LoggingSystem.logRegister(GetDateTime() + 
					" || Register #" + cashier.GetDrawer().GetRegisterID() + 
					": Total Sales while on shift: $" + cashier.ShiftSales(),
					cashier.GetDrawer().GetRegisterID());
			logSys.Logout();
			logSys.Login(in);
			logSys.ChooseRegister(in, cashier);
		}
		else if (tmp_split[0].equals("exit"))
		{
			LoggingSystem.logRegister(GetDateTime() + 
					" || Register #" + cashier.GetDrawer().GetRegisterID() + 
					": Total Sales while on shift: $" + cashier.ShiftSales(),
					cashier.GetDrawer().GetRegisterID());
			logSys.Logout();
			return false;
		}
		else if (tmp_split[0].equals("order"))
		{
			order = new Order(cashier);
			System.out.println("Enter ordering mode.");
			curMode = SysMode.order;
		}
		else
		{
			System.out.println("Incorrect command. Type 'help' for a list of commands.");
		}
		} 
		else if (curMode == SysMode.order)
		{
			if (tmp_split[0].equals("add"))
			{
				if (tmp_split.length == 3) 
				{
					try 
					{
						order.AddToOrder(tmp_split[1], Integer.parseInt(tmp_split[2]));
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
						order.RemoveFromOrder(tmp_split[1], Integer.parseInt(tmp_split[2]));
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
			else if (tmp_split[0].equals("status"))
			{
				order.OrderStatus();
			}
			else if (tmp_split[0].equals("complete"))
			{
				order.CompleteOrder();
				curMode = SysMode.deflt;
			}
			else if (tmp_split[0].equals("cancel"))
			{
				order.CancelOrder();
				curMode = SysMode.deflt;
			}
			else
			{
				System.out.println("Incorrect command. Type 'help' for a list of commands.");
			}
		}
		
		return true;
	}
	
	private String GetDateTime()
	{
		SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
		return dateFormat.format(new Date());
	}
	
}
