package com.debertz.authorization;
/*
 * Author: R.Bietin
 * Date: 14.12.13
 * Time: 23:48
 */

public class Authorization
{
	public static boolean Register(String username, String password) throws Exception
	{
		if (username.equals("")) throw new Exception("Please, fill 'Username' field.");
		if (password.equals("")) throw new Exception("Please, fill 'Password' field.");
		if (username.length() < 4) throw new Exception("Username can not be shorter then 4 digits.");
		if (password.length() < 4) throw new Exception("Password can not be shorter then 4 digits.");
		;
		if (false)
		{
			throw new Exception("User '" + username + "' already exists. Please, choose another username.");
		}
		return true;
	}
	public static String Authorizate(String username, String password) throws Exception
	{
		if (username.equals("")) throw new Exception("Please, fill 'Username' field.");
		if (password.equals("")) throw new Exception("Please, fill 'Password' field.");
		if(false)
		{
			throw new Exception("Username or Password is not correct");
		}
		return "sid";
	}

	public static boolean ValidateSid(String username, String sid)
	{
		return true;
	}



}
