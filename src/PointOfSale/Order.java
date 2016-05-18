package PointOfSale;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Order {

	Cashier curCash;
	DoublyLinkedList<String> items = new DoublyLinkedList<String>();
	DoublyLinkedList<Integer> quant = new DoublyLinkedList<Integer>();
	//String[] items = new String[100];
	//int[] quant = new int[100];
	
	public Order(Cashier c)
	{
		curCash = c;
	}
	
	public void AddToOrder(String item, int quantity)
	{
		Item tmpItem = findItem(item);
		
		if (tmpItem == null)
		{
			System.out.println("No item exists.");
			return;
		}
		
		// If we're already selling an item of a certain type
		// add a quantity of the item being sold to the same place
		for (int i = 0; i < items.size(); i++)
		{
			if (items.GetNode(i).Data().equals(item))
			{
				quant.GetNode(i).setData(quant.GetNode(i).Data() + quantity);
				return;
			}
		}
	
		items.AddLast(item);
		quant.AddLast(quantity);
		
	}
	
	public void RemoveFromOrder(String item, int quantity)
	{
		Item tmpItem = findItem(item);
		
		if (tmpItem == null)
		{
			System.out.println("No item exists.");
			return;
		}
		
		for (int i = 0; i < items.size(); i++)
		{
			if (items.GetNode(i).Data().equals(item))
			{
				if (quant.GetNode(i).Data() > quantity)
				{
					quant.GetNode(i).setData(quant.GetNode(i).Data() - quantity);
				}
				else if (quant.GetNode(i).Data() == quantity)
				{
					items.Remove(i);
					quant.Remove(i);
				}
				else
				{
					System.out.println("ERROR: Tried to remove a higher quantity of the item than currently in the order.");
				}
				return;
			}
		}
		
	}
	
	public void OrderStatus()
	{
		for (int i = 0; i < items.size(); i++)
		{
			System.out.println("Order item #" + (i+1) + ": " + items.GetNode(i).Data() +
					" | Quantity: " + quant.GetNode(i).Data());
		}
	}
	
	public void CompleteOrder()
	{
		
		String s = GetDateTime() + " || " +
				"User " + LoginSystem.getCurUser() +
				" On Register #" + curCash.GetDrawer().GetRegisterID() +
				" Sold: ";
		for (int i = 0; i < items.size(); i++)
		{
			curCash.Sell(items.GetNode(i).Data(), quant.GetNode(i).Data());
			s += ("\n    " + quant.GetNode(i).Data() + " " +
			items.GetNode(i).Data()); 
		}
		
		LoggingSystem.logAction(s);
		
		System.out.println("Order complete.");
	}
	
	public void CancelOrder()
	{
		items = new DoublyLinkedList<String>();
		quant = new DoublyLinkedList<Integer>();
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
	
	private String GetDateTime()
	{
		SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
		return dateFormat.format(new Date());
	}
}
