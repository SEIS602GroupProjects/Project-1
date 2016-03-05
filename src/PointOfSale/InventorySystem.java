package PointOfSale;

public class InventorySystem {

	private IOSystem IO = new IOSystem();
	
	
	private Items[] item;
	
	
	public InventorySystem()
	{
		ReadInventory();
	}
	
	// Print out the inventory
	public void PrintInventory()
	{
		// For each item, print the item name and the quantities left
		for (int i=0; i < item.length; i++)
		{
			System.out.print(item[i].getName() + " : " + item[i].getQuantity()
					+" Price : "+item[i].getPrice());
			System.out.println();
		}
	}
	
	// Read the inventory from a file
	private void ReadInventory()
	{
		// Read the inventory from the "Data/Inventory.txt" file
		String[] tmp = IO.ReadFile("Data/Inventory.txt");

		 
		
		
	
		
		item =new Items[tmp.length];
		
		
		// For each line in the file
		for (int i=0; i < tmp.length; i++)
		{
			
			// Split the line of the file up at the = sign 			
			String[] tmp_split = tmp[i].split(";");
			
			
			item[i]= new Items(tmp_split[1],
					Integer.parseInt(tmp_split[2]), 
					Double.parseDouble(tmp_split[3]),
					Integer.parseInt(tmp_split[0]));
			// For example, tmp[0] == "apples=10" gets stored as
			// items[0] == "apples"
			// quantities[0] == "10"
			// tmp[1] == "oranges=15" stored as
			// items[1] == "oranges
			// quantities[1] == "15"
		}
	}
	
	// Add item(s) to the inventory
	// Take in a string for the item value, int for quantity
	public void Add(String item, int quant)
	{
		// TO DO
	}

	// Remove item(s) to the inventory
	public void Remove(String item, int quant)
	{
		// TO DO
	}
	
	// Get information on an item
	public void Lookup(String item)
	{
		// TO DO
	
	}
}
