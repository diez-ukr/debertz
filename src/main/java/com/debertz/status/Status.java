package com.debertz.status;

/*
 * Author: R.Bietin
 * Date: 17.12.13
 * Time: 9:30
 */
public class Status {
	public enum Authorization
	{
		OK(""),
		EmptyUsername("Please, fill 'Username' field."),
		EmptyPassword("Please, fill 'Password' field."),
		TooShortPassword("Password can not be shorter then 4 digits."),
		InvalidUsername("Username must have at least 4 of those characters, but no more than 16. "
				+ "Only english alphabet letters, underscores and hyphens allowed."),
		NotUniqueUsername("Username is not unique."),
		WrongCredentials("Username or Password is not correct");


		private Authorization(final String text)
		{
			this.text = text;
		}

		private final String text;

		@Override
		public String toString()
		{
			return text;
		}
	}

	public static boolean isSuccess(Authorization status)
	{
		return (status == Authorization.OK);
	}
}
