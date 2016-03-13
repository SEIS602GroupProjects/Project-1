package PointOfSale;

public class InventorySystem {
	
	private static Item[] items;
	
	public static Item[] items()
	{
		return items;
	}
	
	
	public InventorySystem()
	{
		ReadInventory();
	}
	
	// Print out the inventory
	public static void PrintInventory()
	{
		// For each item, print the item name and the quantities left
		for (int i=0; i < items.length; i++)
		{
			System.out.print("UPC: " + items[i].getUpc() + " || Name: " + items[i].getName() + 
					" || Quantity: " + items[i].getQuantity()
					+ " || Price: " + items[i].getPrice()
					+ " || Re-order Threshold: " + items[i].getThreshold()
					+ " || Is Re-ordered? " + items[i].getIsReorder());
			System.out.println();
		}
	}
	
	// Read the inventory from a file
	public static void ReadInventory()
	{
		// Read the inventory from the "Data/Inventory.txt" file
		String[] tmp = IOSystem.ReadFile("Data/Inventory.txt");
		items = new Item[tmp.length];
		
		// For each line in the file
		for (int i=0; i < tmp.length; i++)
		{
			
			// Split the line of the file up at the = sign 			
			String[] tmp_split = tmp[i].split(";");
			
			
			items[i]= new Item(Integer.parseInt(tmp_split[0]),
					tmp_split[1], 
					Integer.parseInt(tmp_split[2]),
					Double.parseDouble(tmp_split[3]),
					Integer.parseInt(tmp_split[4]),
					Boolean.parseBoolean(tmp_split[5]));
			// For example, tmp[0] == "apples=10" gets stored as
			// items[0] == "apples"
			// quantities[0] == "10"
			// tmp[1] == "oranges=15" stored as
			// items[1] == "oranges
			// quantities[1] == "15"
		}
	}
	
	public static void FillInventory()
	{
		for (int i=0; i < items.length; i++)
		{
			if (items[i].getQuantity() < items[i].getThreshold())
			{
				items[i].setIsReorder(true);
			}
			else
			{
				items[i].setIsReorder(false);
			}
		}
	
	}
}
