package PointOfSale;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class LoginSystem {
	private String[] usernames;
	private String[] passwords;
	private static String curUser = "";
	
	public LoginSystem()
	{
		readLoginData();
	}
	
	// Get current logged in user
	public static String getCurUser()
	{
		return curUser;
	}
	
	public void Login()
	{
		boolean isCorrect = false;
		String tmp = "";
		String tmppw = "";
		
		// Ask for username
		System.out.println("Please enter your username:");
		
		Scanner in = new Scanner(System.in);
		
		// Keep asking for username until valid one given
		while (true)
		{
			// Get typed input
			tmp = in.nextLine();

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
			LoggingSystem.logAction("INVALID LOGIN ATTEMPT BY USER: '" + tmp + "'");
		}
	}
	
	// TO DO: LOGOUT 
	public void Logout()
	{
		
	}
	
	private String GetDateTime()
	{
		SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
		return dateFormat.format(new Date());
	}
	
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
	
	
}
