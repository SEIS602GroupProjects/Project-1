package PointOfSale;

public class InventorySystem {

	private IOSystem IO = new IOSystem();
	private String[] items;
	private String[] quantities;
	
	public InventorySystem()
	{
		ReadInventory();
	}
	
	// Print out the inventory
	public void PrintInventory()
	{
		// For each item, print the item name and the quantities left
		for (int i=0; i < items.length; i++)
		{
			System.out.print(items[i] + ": " + quantities[i]);
			System.out.println();
		}
	}
	
	// Read the inventory from a file
	private void ReadInventory()
	{
		// Read the inventory from the "Data/Inventory.txt" file
		String[] tmp = IO.ReadFile("Data/Inventory.txt");

		// Create the items array and set the size to be the 
		// same as the number of lines in the file
		items = new String[tmp.length];
		// Do the same for quantities
		quantities = new String[tmp.length];
		
		// For each line in the file
		for (int i=0; i < tmp.length; i++)
		{
			// Split the line of the file up at the = sign 			
			String[] tmp_split = tmp[i].split("=");
			items[i] = tmp_split[0];
			quantities[i] = tmp_split[1];
			
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
