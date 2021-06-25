package in.ramesh.service;

import in.ramesh.exception.ValidationException;

import in.ramesh.validator.LoginValidation;

public class UserLoginService {
	private UserLoginService() {

	}

	public static boolean addUserLogin(String username, String password) {
		boolean userValidation = false;
		if (LoginValidation.checkUserName(username) && LoginValidation.checkPassword(password)) {
			userValidation = true;

		} else {
			throw new ValidationException("Invalid");
		}

		return userValidation;
	}

}
