package PointOfSale.TestCases;

import static org.junit.Assert.*;

import org.junit.Test;

import PointOfSale.IOSystem;

public class IOSystemTest {
	
	@Test
	public void ReadFileTest()
	{
		String s[] = IOSystem.ReadFile("Data/Test Files/ReadFileTest.txt");
		assertEquals("testing123", s[0]);
		assertEquals("testing456", s[1]);
	}
	
	@Test
	public void WriteFileTest()
	{
		String s[] = { "firstline", "secondline" };
		String fileLoc = "Data/Test Files/WriteFileTest.txt";
		IOSystem.WriteFile(s, fileLoc);
		String file[] = IOSystem.ReadFile(fileLoc);
		assertEquals(s[0], file[0]);
		assertEquals(s[1], file[1]);
	}

}
