package PointOfSale;

public class Order {

	Cashier curCash;
	String[] items = new String[100];
	int[] quant = new int[100];
	
	public Order(Cashier c)
	{
		curCash = c;
	}
	
	public void AddToOrder(String item, int quantity)
	{
		Item tmpItem = findItem(item);
		
		if (tmpItem == null)
		{
			System.out.println("No item exists");
			return;
		}
		
		int i = 0;
		for (i = 0; i < items.length; i++)
		{
			if (items[i] == null)
			{
				items[i] = item;
				quant[i] = quantity;
				break;
			}
		}
		
	}
	
	public void RemoveFromOrder(String item, int quantity)
	{
		
	}
	
	public void CompleteOrder()
	{
		for (int i = 0; i < items.length; i++)
		{
			if (items[i] != null)
			{
				curCash.Sell(items[i], quant[i]);
			}
			else
			{
				break;
			}
		}
		
		System.out.println("Order complete.");
	}
	
	public void CancelOrder()
	{
		items = new String[100];
		quant = new int[100];
		System.out.println("Order Cancelled.");
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
}
