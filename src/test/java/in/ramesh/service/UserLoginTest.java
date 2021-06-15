package in.ramesh.service;

import static org.junit.Assert.*;

import org.junit.Test;

import in.ramesh.validator.LoginValidation;

public class UserLoginTest {

	@Test
	public void correctUserName() {
		String username = "ramesh";

		boolean usernameTest = LoginValidation.checkUserName(username);
		assertTrue(usernameTest);
	}

	@Test
	public void wrongCorrectPassword() {
		String password = "  ";
		boolean addUserLogin = LoginValidation.checkPassword(password);
		assertFalse(addUserLogin);
	}

	@Test
	public void inCorrectUserName() {
		String username = "ramesh11";

		boolean usernameTest = LoginValidation.checkUserName(username);
		assertFalse(usernameTest);
	}

	@Test
	public void correctPassword() {
		String password = "Haicoimbatore1";

		boolean checkpassword = LoginValidation.checkPassword(password);
		assertTrue(checkpassword);
	}

}
