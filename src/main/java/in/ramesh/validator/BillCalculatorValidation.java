package in.ramesh.validator;

public class BillCalculatorValidation {
	private BillCalculatorValidation() {

	}

	public static boolean hotelTypeValidation(String username) {

		boolean isValidService = true;

		if (username.length() == 0 || username.trim().equals("")) {
			isValidService = false;
		}

		return isValidService;
	}

}
