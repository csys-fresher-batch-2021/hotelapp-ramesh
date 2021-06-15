package in.ramesh.validator;

import static org.junit.Assert.*;

import org.junit.Test;

public class LoginValidationTest {

	@Test
	public void correctUserName() {
		String username = "ram";
		boolean expected = LoginValidation.checkUserName(username);
		assertTrue(expected);
	}

	@Test
	public void invalidUserName() {
		String username = "sr";
		boolean expected = LoginValidation.checkUserName(username);
		assertFalse(expected);
	}

	@Test
	public void invalidUserNameWithNumbers() {
		String username = "ramesh123";
		boolean expected = LoginValidation.checkUserName(username);
		assertFalse(expected);
	}

	@Test
	public void userNameInSpace() {
		String username = "";
		boolean expected = LoginValidation.checkUserName(username);
		assertFalse(expected);
	}

}
