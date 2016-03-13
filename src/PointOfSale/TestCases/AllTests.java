package PointOfSale.TestCases;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ IOSystemTest.class, ItemTest.class, InventorySystemTest.class, RegisterTest.class, CashierTest.class })
public class AllTests {

}
