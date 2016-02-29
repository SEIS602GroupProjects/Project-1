package PointOfSale;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class IOSystem {
	
	public String[] ReadFile(String fileToRead)
	{
		String[] str = new String[FileLength(fileToRead)];
		
		try {
			BufferedReader bufferedReader = new BufferedReader(new FileReader(fileToRead));			
			for (int i=0; i < str.length; i++)
			{
				if ((str[i] = bufferedReader.readLine()) != null)
				{
					//System.out.println(str[i]);
				}
			}
			bufferedReader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//String[] str_split = str[0].split(";");
		//System.out.println(str_split[0]);
		//System.out.println(str_split[1]);
		
		return str;
		
	}
	
	private int FileLength(String fileToRead)
	{
		int tmp = 0;
		
		try
		{
			BufferedReader reader = new BufferedReader(new FileReader(fileToRead));
			while (reader.readLine() != null)
			{
				tmp++;
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	
		return tmp;
	}
	
	
	
}
