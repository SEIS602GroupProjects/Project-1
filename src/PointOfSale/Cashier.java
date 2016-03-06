package PointOfSale;

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
		Items curItem = findItem(item);
		
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
				System.out.println(quant + " " + item + " sold for " + actualTransaction);
			}
			else
			{
				System.out.println("Not enough " + item + " in inventory to sell. Only "
						+ curItem.getQuantity() + " " + item + " available.");
			}
		}
		
		// TO DO
	}
	
	// Return a quantity of an item
	public void Return(String item, int quant)
	{
		Items curItem = findItem(item);
		
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
			System.out.println(quant + " " + item + " returned for " + actualTransaction);
		}
		// TO DO
	}
	
	// Report information on an item (name, quantity, price, etc.)
	public void ItemInfo(String item)
	{
		Items curItem = findItem(item);
		
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
		// TO DO
	}
	
	// Re-order inventory
	// MIGHT be better written in InventorySystem
	public void ReOrderInventory()
	{
		// TO DO
	}
	
	public Items findItem(String itemName)
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
	
}
