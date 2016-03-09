package PointOfSale;

import java.util.Date;
import java.text.SimpleDateFormat;

public class Cashier {
	private Register drawer;
	
	public void ChooseRegister(int register)
	{
		drawer = new Register(register);
	}
	
	public Register GetDrawer()
	{
		return drawer;
	}
	
	// Sell a quantity of an item 
	public void Sell(String item, int quant)
	{
		Item curItem = findItem(item);
		
		if (curItem == null)
		{
			System.out.println("Item " + item + " not found. Please enter a valid item name.");
		}
		else
		{
			// If we have the item, lower quantity, add money to drawer, etc.
			if (curItem.getQuantity() >= quant)
			{
				curItem.remveQuantity(quant);
				double actualTransaction = ((curItem.getPrice() * 100) * quant) / 100;
				drawer.AddMoney(actualTransaction);
				System.out.println(quant + " " + item + " sold for $" + actualTransaction);
				LoggingSystem.logAction(GetDateTime() + " || " +
						"User " + LoginSystem.getCurUser() +
						" On Register #" + drawer.GetRegisterID() +
						": Sold " + quant + " " + item + 
						" for $" + actualTransaction);
				InventorySystem.FillInventory();
				UpdateInventory();
			}
			else
			{
				System.out.println("Not enough " + item + " in inventory to sell. Only "
						+ curItem.getQuantity() + " " + item + " available.");
			}
		}
		
	}
	
	// Return a quantity of an item
	public void Return(String item, int quant)
	{
		Item curItem = findItem(item);
		
		if (curItem == null)
		{
			System.out.println("Item " + item + " not found. Please enter a valid item name");
		}
		else
		{
			// If we have the item, lower quantity, add money to drawer, etc.
			curItem.addQuantity(quant);
			double actualTransaction = ((curItem.getPrice() * 100) * quant) / 100;
			drawer.RemoveMoney(actualTransaction);
			System.out.println(quant + " " + item + " returned for $" + actualTransaction);
			LoggingSystem.logAction(GetDateTime() + " || " +
					"User " + LoginSystem.getCurUser() +
					" On Register #" + drawer.GetRegisterID() +
					": Returned " + quant + " " + item + 
					" for $" + actualTransaction);
			UpdateInventory();
		}
		// TO DO
	}
	
	// Report information on an item (name, quantity, price, etc.)
	public void ItemInfo(String item)
	{
		Item curItem = findItem(item);
		
		if (curItem == null)
		{
			System.out.println("Item " + item + " not found. Please enter a valid item name");
		}
		else
		{
			System.out.println("Item: " + curItem.getName() +
					"\nUPC: " + curItem.getUpc() + 
					"\nQuantity: " + curItem.getQuantity() + 
					"\nPrice: " + curItem.getPrice()); 
		}
	}
	
	private void UpdateInventory()
	{
		String[] tmp = new String[InventorySystem.items().length];
		for (int i=0; i < tmp.length; i++)
		{
			tmp[i] = InventorySystem.items()[i].getUpc() + ";" +
					InventorySystem.items()[i].getName() + ";" +
					InventorySystem.items()[i].getQuantity() + ";" +
					InventorySystem.items()[i].getPrice() + ";" +
					InventorySystem.items()[i].getThreshold() + ";" +
					InventorySystem.items()[i].getIsReorder();
		}
		IOSystem.WriteFile(tmp, "Data/Inventory.txt");
	}
	
	private String GetDateTime()
	{
		SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
		return dateFormat.format(new Date());
	}
	
	// Re-order inventory
	// MIGHT be better written in InventorySystem
	public void ReOrderInventory()
	{
		// TO DO
	}
	
	public Item findItem(String itemName)
	{
		for (int i=0; i < InventorySystem.items().length; i++)
		{
			if (itemName.equals(InventorySystem.items()[i].getName()))
			{
				//System.out.println("item " + InventorySystem.items()[i].getName() +  " found.");
				return InventorySystem.items()[i];
			}
		}
	
		return null;
	}
	public void addToInventory(String itemName, int quant){
Item curItem = findItem(itemName);
		
		if (curItem == null)
		{
			System.out.println("Item " + itemName + " not found. Please enter a valid item name");
		}
		else
		{
			// If we have the item, lower quantity, add money to drawer, etc.
			curItem.addQuantity(quant);
			System.out.println(quant + " " + itemName + " added to inventory" );
			LoggingSystem.logAction(GetDateTime() + " || " +
					"User " + LoginSystem.getCurUser() +
					": added " + quant + " " + itemName +" to inventory");
					
	}
	}
	public void removeFromInventory(String itemName, int quant){
Item curItem = findItem(itemName);
		
		if (curItem == null)
		{
			System.out.println("Item " + itemName + " not found. Please enter a valid item name");
		}
		else
		{
			// If we have the item, lower quantity, add money to drawer, etc.
	       curItem.remveQuantity(quant);
	       System.out.println(quant + " " + itemName + " removed from inventory" );
			LoggingSystem.logAction(GetDateTime() + " || " +
					"User " + LoginSystem.getCurUser() +
					": removed " + quant + " " + itemName +" from inventory");
	}
	
	
	}
	public void setThreshold(String itemName,int newThreshold ){
		
Item curItem = findItem(itemName);
		
		if (curItem == null)
		{
			System.out.println("Item " + itemName + " not found. Please enter a valid item name");
		}
		else
		{
			// If we have the item, lower quantity, add money to drawer, etc.
			curItem.setThreshold(newThreshold);
			System.out.println("the new threshold of "+itemName+" is: "+newThreshold);
		//	System.out.println(newThreshold + " " + itemName + " changnig the threshold" );
			LoggingSystem.logAction(GetDateTime() + " || " +
					"User " + LoginSystem.getCurUser() +
					": threshold of : " + itemName +" changed to "+newThreshold);
					
	}
	}
}
