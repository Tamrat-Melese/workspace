package com.mpp.library.controller;

import com.mpp.library.entity.Person;

public class UserController extends Controller<Person> {

	private static UserController instance = new UserController();
	
	private UserController() {
		super();
	}

	public static UserController getInstance() {
		return instance;
	}
	
	public Person searchMember(String key) {
		return get(key);
	}
}
