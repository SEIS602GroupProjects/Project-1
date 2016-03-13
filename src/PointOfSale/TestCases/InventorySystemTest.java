package PointOfSale.TestCases;

import static org.junit.Assert.*;

import org.junit.Test;

import PointOfSale.InventorySystem;
import PointOfSale.Item;

public class InventorySystemTest {

	private Item[] items = new Item[] { new Item(12345, "item1", 2, 0.75, 8, false), 
			new Item(23456, "test2", 3, 0.25, 20, true)
	};
	private InventorySystem inventory = new InventorySystem(items);
	
	@Test
	public void ItemsTest() 
	{
		assertArrayEquals(items, InventorySystem.items());
	}
	
	@Test
	public void FillInventoryTest()
	{
		assertEquals(false, InventorySystem.items()[0].getIsReorder());
		InventorySystem.FillInventory();
		assertEquals(true, InventorySystem.items()[0].getIsReorder());
	}

}
