package in.ramesh.validator;

import in.ramesh.model.BillCalculatorModel;

public class HotelDetailsValidation {
	private HotelDetailsValidation() {

	}

	public static boolean isCorrectdetail(BillCalculatorModel addHotelDetails) {
		boolean isValid = true;

		if (!BillCalculatorValidation.hotelTypeValidation(addHotelDetails.getHotelName())) {

			isValid = false;
		}
		if (!BillCalculatorValidation.hotelTypeValidation(addHotelDetails.getContactNo())) {

			isValid = false;
		}
		if (!BillCalculatorValidation.hotelTypeValidation(addHotelDetails.getCityName())) {

			isValid = false;
		}
		if (!BillCalculatorValidation.hotelTypeValidation(addHotelDetails.getDistrict())) {

			isValid = false;
		}
		if (!BillCalculatorValidation.hotelTypeValidation(addHotelDetails.getRooms())) {

			isValid = false;
		}

		return isValid;
	}

}
