package com.mpp.library.controller;

import java.util.Random;

import com.mpp.library.dataaccess.DataAccess;
import com.mpp.library.dataaccess.DataAccessImpl;


public class DataAccessController {

	private static DataAccess dataAccess = null;

	private DataAccessController() {
	}

	public static DataAccess getDataAccess() {
		if (dataAccess == null) {
			dataAccess = new DataAccessImpl();
		}
		return dataAccess;
	}

	public static void setDataAccess(DataAccess dataAccess) {
		dataAccess = dataAccess;
	}

	public static String getRandom() {
		String myRandomNumber;
		Random random = new Random();
		myRandomNumber = Long.toString(System.currentTimeMillis()) + Integer.toString(random.nextInt(10000));
		return myRandomNumber;
	}
}
