package com.debertz.authorization;
/*
 * Author: R.Bietin
 * Date: 14.12.13
 * Time: 23:48
 */

import com.debertz.dao.Users;
import com.debertz.status.Status;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.regex.Pattern;


public class Authorization
{
	public static Status.Authorization register(String username, String password)
	{
		Status.Authorization status;
		status = validateLogin(username);
		if (!Status.isSuccess(status))
			return status;
		status = validatePassword(password);
		if (!Status.isSuccess(status))
			return status;
		if (!Users.addUser(username, md5(password)))
			return Status.Authorization.NotUniqueUsername;
		return Status.Authorization.OK;
	}

	public static Status.Authorization validateLogin(String username)
	{
		if (username == null || username.isEmpty()) return Status.Authorization.EmptyUsername;
		String loginRegex = "^[A-Za-z0-9_-]{4,16}$";
		if (!Pattern.compile(loginRegex).matcher(username).matches())
			return Status.Authorization.InvalidUsername;
		if (Users.validateUser(username))
			return Status.Authorization.NotUniqueUsername;
		return Status.Authorization.OK;
	}


	public static Status.Authorization validatePassword(String password)
	{
		if (password == null || password.isEmpty()) return Status.Authorization.EmptyPassword;
		if (password.length() <= 4) return Status.Authorization.TooShortPassword;
		return Status.Authorization.OK;
	}

	public static String authorize(String username, String password) throws AuthorizationException
	{


		return Users.generateSID(username, md5(password));
	}

	public static boolean validateSid(String username, String sid)
	{
		return Users.validateSid(username, sid);
	}

	public static boolean validateSid(Object username, Object sid)
	{
		return !(username == null || sid == null) && Users.validateSid(username.toString(), sid.toString());
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
