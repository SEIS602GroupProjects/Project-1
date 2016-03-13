package PointOfSale.TestCases;

import static org.junit.Assert.*;

import org.junit.Test;

import PointOfSale.Item;

public class ItemTest {

	private Item testItem = new Item(12345, "test", 2, 0.75, 5, false);
	
	@Test
	public void getNameTest()
	{
		assertEquals("test", testItem.getName());
	}
	
	@Test
	public void getQuantityTest()
	{
		assertEquals(2, testItem.getQuantity());
	}
	
	
	@Test
	public void addQuantityTest() {
		testItem.addQuantity(2);
		assertEquals(4, testItem.getQuantity());
	}
	
	@Test
	public void  remveQuantityTest()
	{
		testItem.remveQuantity(1);
		assertEquals(1, testItem.getQuantity());
	}
	
	@Test
	public void getPriceTest()
	{
		assertEquals(0.75, testItem.getPrice(), 0.0001);
	}
	
	@Test
	public void getUpcTest()
	{
		assertEquals(12345, testItem.getUpc());
	}
	
	@Test
	public void setThresholdTest()
	{
		int newThreshold = 10;
		testItem.setThreshold(newThreshold);
		assertEquals(newThreshold, testItem.getThreshold());
	}
	
	@Test
	public void getThresholdTest()
	{
		assertEquals(5, testItem.getThreshold());
	}
	
	@Test
	public void getIsReorderTest()
	{
		assertEquals(false, testItem.getIsReorder());
	}
	
	@Test
	public void setIsReorderTest()
	{
		boolean newReOrder = true;
		testItem.setIsReorder(newReOrder);
		assertEquals(newReOrder, testItem.getIsReorder());
	}
}
