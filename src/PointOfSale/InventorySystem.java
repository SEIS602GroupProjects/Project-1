package PointOfSale;

public class InventorySystem {

	private IOSystem IO = new IOSystem();
	private String[] items;
	private String[] quantities;
	
	public InventorySystem()
	{
		ReadInventory();
	}
	
	public void PrintInventory()
	{
		for (int i=0; i < items.length; i++)
		{
			System.out.print(items[i] + ": " + quantities[i]);
			System.out.println();
		}
	}
	
	private void ReadInventory()
	{
		String[] tmp = IO.ReadFile("Data/Inventory.txt");
		items = new String[tmp.length];
		quantities = new String[tmp.length];
		
		for (int i=0; i < tmp.length; i++)
		{
			String[] tmp_split = tmp[i].split("=");
			items[i] = tmp_split[0];
			quantities[i] = tmp_split[1];
		}
	}
}
