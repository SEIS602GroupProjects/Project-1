package PointOfSale;

public class Cashier {
	Register drawer = new Register();
	
	// Sell a quantity of an item 
	public void Sell(String item, int quant)
	{
		Items curItem = findItem(item);
		
		if (curItem == null)
		{
			System.out.println("Item " + item + " not found. Please enter a valid item name");
		}
		else
		{
			// If we have the item, lower quantity, add money to drawer, etc.
			curItem.remveQuantity(quant);
			drawer.AddMoney(curItem.getPrice() * quant);
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
			drawer.RemoveMoney(curItem.getPrice() * quant);
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
					"\n UPC: " + curItem.getUpc() + 
					"\n Quantity: " + curItem.getQuantity() + 
					"\n Price: " + curItem.getPrice()); 
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
				System.out.println("item " + InventorySystem.items()[i].getName() +  " found.");
				return InventorySystem.items()[i];
			}
		}
	
		return null;
	}
	
}
