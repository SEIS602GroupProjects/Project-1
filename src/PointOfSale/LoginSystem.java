package PointOfSale;

import java.util.Scanner;

public class LoginSystem {

	private IOSystem IO = new IOSystem();
	private String[] usernames;
	private String[] passwords;
	
	public LoginSystem()
	{
		readLoginData();
	}
	
	public void Login()
	{
		boolean isCorrect = false;
		String tmp = "";
		String tmppw = "";
		
		// Check username
		System.out.println("Please enter your username:");
		
		Scanner in = new Scanner(System.in);
		
		while (true)
		{
			tmp = in.nextLine();
			for (int i=0; i < usernames.length; i++)
			{
				if (tmp.equals(usernames[i]))
				{
					System.out.println("Please enter your password:");
					while (true)
					{
						tmppw = in.nextLine();
						if (tmppw.equals(passwords[i]))
						{
							System.out.println("Welcome, " + tmp + ". Electronic-Sales Counter system started.");
							isCorrect = true;
							break;
						}
						System.out.println("Password not found. Enter again.");
					}
					break;
				}
			}
			if (isCorrect)
			{
				break;
			}
			System.out.println("Username " + tmp + " not found. Please try again.");
		}
		
		
	}
	
	private void readLoginData()
	{
		String[] tmp = IO.ReadFile("Data/loginInfo.txt");
		usernames = new String[tmp.length];
		passwords = new String[tmp.length];
		
		for (int i=0; i < tmp.length; i++)
		{
			String[] tmp_split = tmp[i].split(";");
			usernames[i] = tmp_split[0];
			passwords[i] = tmp_split[1];
			//System.out.println(usernames[i]);
			//System.out.println(passwords[i]);
		}
	}
	
	
}
