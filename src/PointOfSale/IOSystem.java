package PointOfSale;

import java.io.*;

public class IOSystem {
	
	// Import a file's contents line by line 
	public static String[] ReadFile(String fileToRead)
	{
		// Temporary string array to store the contents in
		// String str's length is equal to the number of lines in the file
		String[] str = new String[FileLength(fileToRead)];
		
		try {
			// Create and open a BufferedReader, needed so we can read line-by-line
			BufferedReader bufferedReader = new BufferedReader(new FileReader(fileToRead));

			// For each line in the file, do something 
			for (int i=0; i < str.length; i++)
			{
				// Put the line of text from the file into a corresponding
				// corresponding element of the string array
				str[i] = bufferedReader.readLine();
			}
			
			// Close the BufferedReader
			bufferedReader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		// Return the string array containing the contents of the file line-by-line
		return str;
		
	}
	
	public static void AppendFile(String[] toWrite, String fileLoc)
	{
		// Take in String array of lines,
		// output lines to a file
		// APPEND the file
		
		try {
			BufferedWriter bWrite = new BufferedWriter(new FileWriter(fileLoc, true));
			for (int i=0; i < toWrite.length; i++)
			{
				bWrite.write(toWrite[i]);
				bWrite.newLine();
			}
			bWrite.flush();
			bWrite.close();
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}
	
	public static void AppendFile(String toWrite, String fileLoc)
	{		
		try {
			BufferedWriter bWrite = new BufferedWriter(new FileWriter(fileLoc, true));
			bWrite.write(toWrite);
			bWrite.newLine();
			bWrite.flush();
			bWrite.close();
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}
	
	public static void WriteFile(String[] toWrite, String fileLoc)
	{
		try {
			File file = new File(fileLoc);
			file.createNewFile();
			FileWriter fWrite = new FileWriter(file);
			for (int i=0; i < toWrite.length; i++)
			{
				if (i < toWrite.length-1)
				{
					fWrite.write(toWrite[i] + "\n");
				}
				else
				{
					fWrite.write(toWrite[i]);
				}
			}
			fWrite.flush();
			fWrite.close();
		} catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	
	// Return the # of lines in a file
	// Used for ReadFile()
	private static int FileLength(String fileToRead)
	{
		// lines in file variable
		int tmp = 0;
		
		try
		{
			BufferedReader reader = new BufferedReader(new FileReader(fileToRead));
			
			// Read through each line in the file, at the end of each line
			// add one to the variable storing the number of lines in the file
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
