package com.msedcl.main.util;

public class LoginUtil {
	
	public boolean validateUserName(String userName)
	{
		if(userName.equals("admin"))
			return true;
		return false;
	}

}
