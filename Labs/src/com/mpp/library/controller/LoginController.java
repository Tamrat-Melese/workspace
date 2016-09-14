package mpp.library.controller;

import mpp.library.dataaccess.LoginDataAccess;
import mpp.library.dataaccess.LoginDataAccessImpl;
import mpp.library.entity.UserAccount;

public class LoginController {

	private LoginDataAccess<String, UserAccount> dataAccess = new LoginDataAccessImpl<String, UserAccount>();
	
	private static LoginController instance = new LoginController();

	private LoginController() {
	}

	public static LoginController getInstance() {
		return instance;
	}

	public UserAccount addUser(UserAccount users) {
		return dataAccess.add(users.getUsername(), users);
	}

	public UserAccount get(String username) {
		return dataAccess.get(username);
	}

	public UserAccount login(String username, String password) {
		UserAccount userAccount = dataAccess.get(username);
		if (userAccount == null || !userAccount.getPassword().equalsIgnoreCase(password) ){
			return null;
		}
		else {
			return userAccount;
		}
	}

}
