package PointOfSale.TestCases;

import static org.junit.Assert.*;

import org.junit.Test;

import PointOfSale.Register;

public class RegisterTest {

	private String fileLoc = "Data/Test Files/RegisterTest.txt";
	private Register testReg = new Register(0, fileLoc);
	
	@Test
	public void MoneyInDrawerTest() {
		assertEquals(50.03, testReg.MoneyInDrawer(), 0.0001);
	}
	
	@Test
	public void GetRegisterIDTest()
	{
		assertEquals(0, testReg.GetRegisterID());
	}
	
	@Test
	public void AddMoneyTest()
	{
		double prevMoney = testReg.MoneyInDrawer();
		double moneyToAdd = 0.40;
		testReg.AddMoneyTest(moneyToAdd);
		assertEquals(prevMoney + moneyToAdd, testReg.MoneyInDrawer(), 0.0001);
	}
	
	@Test
	public void RemoveMoneyTest()
	{
		double prevMoney = testReg.MoneyInDrawer();
		double moneyToRemove = 0.30;
		testReg.RemoveMoneyTest(moneyToRemove);
		assertEquals(prevMoney - moneyToRemove, testReg.MoneyInDrawer(), 0.0001);
	}

}
