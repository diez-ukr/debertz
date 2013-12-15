package com.debertz.authorization;
/*
 * Author: R.Bietin
 * Date: 14.12.13
 * Time: 23:48
 */

import com.debertz.dao.Users;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Authorization
{
	public static boolean register(String username, String password) throws Exception
	{
		if (username.equals("")) throw new Exception("Please, fill 'Username' field.");
		if (password.equals("")) throw new Exception("Please, fill 'Password' field.");
		if (username.length() < 4) throw new Exception("Username can not be shorter then 4 digits.");
		if (password.length() < 4) throw new Exception("Password can not be shorter then 4 digits.");

		if (!Users.addUser(username, md5(password)))
		{
			throw new Exception("User '" + username + "' already exists. Please, choose another username.");
		}
		return true;
	}
	public static String authorize(String username, String password) throws Exception
	{
		if (username.equals("")) throw new Exception("Please, fill 'Username' field.");
		if (password.equals("")) throw new Exception("Please, fill 'Password' field.");
		String sid = Users.generateSID(username, md5(password));
		if(sid.equals(""))
		{
			throw new Exception("Username or Password is not correct");
		}
		return sid;
	}

	public static boolean validateSid(String username, String sid)
	{
		return Users.validateSid(username, sid);
	}

	private static String md5(String input)
	{
		String md5 = null;
		try
		{
			MessageDigest digest = MessageDigest.getInstance("MD5");
			digest.update(input.getBytes(), 0, input.length());
			md5 = new BigInteger(1, digest.digest()).toString(16);
		}
		catch (NoSuchAlgorithmException e)
		{
			e.printStackTrace();
		}
		return md5;
	}

}
