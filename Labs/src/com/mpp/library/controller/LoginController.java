package com.mpp.library.controller;

import com.mpp.library.entity.UserAccount;

public class LoginController extends Controller<UserAccount> {
	
	private static LoginController instance = new LoginController();

	private LoginController() {
	}

	public static LoginController getInstance() {
		return instance;
	}

	public UserAccount login(String username, String password) {
		UserAccount userAccount = get(username);
		if (userAccount == null || !userAccount.getPassword().equalsIgnoreCase(password) ){
			return null;
		}
		else {
			return userAccount;
		}
	}

}
