package PointOfSale;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class LoginSystem {
	private String[] usernames;
	private String[] passwords;
	private int[] validRegisters;
	private static String curUser = "";
	private static int curRegister = 0;
	
	public LoginSystem()
	{
		readLoginData();
	}
	
	// Get current logged in user
	public static String getCurUser()
	{
		return curUser;
	}
	
	public void Login(Scanner in)
	{
		boolean isCorrect = false;
		String tmp = "";
		String tmppw = "";		
		
		// Keep asking for username until valid one given
		while (true)
		{
			// Ask for username
			System.out.println("Please enter your username: ");
			tmp = in.nextLine();
			
			// Ask for password
			System.out.println("Please enter your password: ");
			tmppw = in.nextLine();
			
			// Loop through the array of valid usernames
			for (int i=0; i < usernames.length; i++)
			{
				// If the text inputed is a valid username 
				if (tmp.equals(usernames[i]))
				{ 
					if (tmppw.equals(passwords[i]))
					{
						// Welcome the user to the system, give them access
						System.out.println("Welcome, " + tmp + ". Electronic-Sales Counter system started.");
						isCorrect = true;
						curUser = usernames[i];
						// Break out of while loop checking for password
						LoggingSystem.logAction(GetDateTime() + " || " +
								"Login Complete: '" + tmp + "' allowed access to the system.");
						LoggingSystem.logCashier(GetDateTime() + " || " +
								"Login Complete: '" + tmp + "' allowed access to the system.");
						break;
					}
					// If the password inputed isn't correct, ask for user/pass combination again
					LoggingSystem.logAction(GetDateTime() + " || " +
							"INVALID PASSWORD BY USER: " + "'"
							+ tmp + "'");
				}					
			}
			
			if (isCorrect)
			{
				break;
			}						
			// If an incorrect username was typed in, ask for the user/pass combination again
			System.out.println("Username/Password combination not found. Please try again");
			LoggingSystem.logAction(GetDateTime() + " || " +
					"INVALID LOGIN ATTEMPT WITH USERNAME '" + tmp + "'");
		}
			/*
			// Loop through the array of valid usernames
			for (int i=0; i < usernames.length; i++)
			{
				// If the text inputed is a valid username 
				if (tmp.equals(usernames[i]))
				{
					// Ask for password
					System.out.println("Please enter your password:");

					// Keep asking for password until a valid one is given
					while (true)
					{
						// Get typed input
						tmppw = in.nextLine();
						// If the text inputed is the password that corresponds to the username 
						if (tmppw.equals(passwords[i]))
						{
							// Welcome the user to the system, give them access
							System.out.println("Welcome, " + tmp + ". Electronic-Sales Counter system started.");
							isCorrect = true;
							curUser = usernames[i];
							// Break out of while loop checking for password
							LoggingSystem.logAction(GetDateTime() + " || " +
									"Login Complete: '" + tmp + "' allowed access to the system.");
							LoggingSystem.logCashier(GetDateTime() + " || " +
									"Login Complete: '" + tmp + "' allowed access to the system.");
							break;
						}
						// If the password inputed isn't correct, ask for it again
						LoggingSystem.logAction(GetDateTime() + " || " +
								"INVALID PASSWORD BY USER: " + "'"
								+ tmp + "'");
						System.out.println("Password not found. Enter again.");
					}					
				}
			}
			
			// If the correct username and corresponding password were inputed,
			// Break out of the login system 
			if (isCorrect)
			{
				break;
			}
			// If an incorrect username was typed in, ask for the username again
			System.out.println("Username " + tmp + " not found. Please try again.");
			LoggingSystem.logAction(GetDateTime() + " || " +
					"INVALID LOGIN ATTEMPT WITH USERNAME '" + tmp + "'");
		}
		*/
	}
	
	// Choose a register
	public void ChooseRegister(Scanner in, Cashier cashier)
	{
		readRegisterData();
		String tmp = "";
		boolean isCorrect = false;
		
		System.out.print("Choose an active register (");
		PrintValidRegisters();
		System.out.println("): ");
		
		while (true)
		{
			tmp = in.nextLine();
			try {
				int tmpInt = Integer.parseInt(tmp);
				for (int i=0; i < validRegisters.length; i++)
				{
					if (tmpInt == validRegisters[i])
					{
						cashier.SetRegister(tmpInt);
						curRegister = tmpInt;
						isCorrect = true;
						break;
					}
				}
				if (isCorrect)
				{
					LoggingSystem.logAction(GetDateTime() + " || " + "User '" + 
										curUser + "' is now on Register #" + curRegister);
					LoggingSystem.logCashier(GetDateTime() + " || " + "User '" + 
							curUser + "' is now on Register #" + curRegister);
					LoggingSystem.logRegister(GetDateTime() + " || Register #"
							+ curRegister + ": User '" + curUser + 
							"' is now on this register.", curRegister);
					cashier.InitSalesRecords();
					break;
				}
				else
				{
					System.out.print("Invalid Register #. Please choose a valid one (");
					PrintValidRegisters();
					System.out.println("): ");
				}
			}
			catch (NumberFormatException e)
			{
				System.out.print("Invalid Register #. Please choose a valid one (");
				PrintValidRegisters();
				System.out.println("): ");
			}
		}
	}
	
	// Logout of system
	public void Logout()
	{
		LoggingSystem.logAction(GetDateTime() + " || " + "User '" + curUser + 
						"' logged out. They left Register #" + curRegister);
		LoggingSystem.logCashier(GetDateTime() + " || " + "User '" + curUser + 
				"' logged out. They left Register #" + curRegister);
		LoggingSystem.logRegister(GetDateTime() + " || Register #"
				+ curRegister + ": User '" + curUser + 
				"' left this register.", curRegister);
		curUser = "";
		curRegister = 0;
		System.out.println("Logout successful.");
	}
	
	private String GetDateTime()
	{
		SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
		return dateFormat.format(new Date());
	}
	
	// Get valid login info
	private void readLoginData()
	{
		String[] tmp = IOSystem.ReadFile("Data/loginInfo.txt");
		usernames = new String[tmp.length];
		passwords = new String[tmp.length];
		
		for (int i=0; i < tmp.length; i++)
		{
			String[] tmp_split = tmp[i].split(";");
			usernames[i] = tmp_split[0];
			passwords[i] = tmp_split[1];
		}
	}
	
	// Get active/existing registers
	private void readRegisterData()
	{
		String[] tmp = IOSystem.ReadFile("Data/registerInfo.txt");
		validRegisters = new int[tmp.length];
		
		for (int i=0; i < tmp.length; i++)
		{
			String[] tmp_split = tmp[i].split(";");
			validRegisters[i] = Integer.parseInt(tmp_split[0]);
			//System.out.println(validRegisters[i]);
		}
	}
	
	private void PrintValidRegisters()
	{
		for (int i=0; i < validRegisters.length; i++)
		{
			if (i != validRegisters.length-1)
			{
				System.out.print(validRegisters[i] + ",");
			}
			else
			{
				System.out.print(validRegisters[i]);
			}
		}
	}
	
	
	
}
