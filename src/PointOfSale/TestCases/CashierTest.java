package PointOfSale.TestCases;

import static org.junit.Assert.*;

import org.junit.*;

import PointOfSale.Cashier;
import PointOfSale.InventorySystem;
import PointOfSale.Item;


public class CashierTest {

	private Cashier cashier = new Cashier();
	private Item[] items = new Item[] { new Item(12345, "item1", 2, 0.75, 8, false), 
			new Item(23456, "test2", 3, 0.25, 20, true)
	};
	private InventorySystem inventory = new InventorySystem(items);
	
	@Before 
	public void SetUp()
	{
		cashier.SetRegisterTest(0);
	}
	
	@Test
	public void GetDrawerTest()
	{
		assertEquals(0, cashier.GetDrawer().GetRegisterID());
	}
	
	@Test
	public void SetRegisterTest() {
		cashier.SetRegisterTest(1);
		assertEquals(1, cashier.GetDrawer().GetRegisterID());
	}
	
	

}
