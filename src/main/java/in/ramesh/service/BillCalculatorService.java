package in.ramesh.service;

import java.util.List;

import in.ramesh.dao.HotelDetailsDAO;
import in.ramesh.exception.ValidationException;
import in.ramesh.model.BillCalculatorModel;
import in.ramesh.util.Logger;
import in.ramesh.validator.ExistingHotelValidation;
import in.ramesh.validator.HotelDetailsValidation;

public class BillCalculatorService {
	private BillCalculatorService() {

	}

	static HotelDetailsDAO dao = new HotelDetailsDAO();

	public static List<BillCalculatorModel> getAllHotelName() {

		return dao.displayHotelDetails();

	}

	static Logger log = new Logger();

	public static boolean addHotelDetails(BillCalculatorModel hotelFeilds) {
		boolean isValid = false;

		try {
			boolean existingHotelValue = ExistingHotelValidation.isExistingHotelValue(hotelFeilds);
			boolean correctdetail = HotelDetailsValidation.isCorrectdetail(hotelFeilds);
			log.print(existingHotelValue);
			if (!existingHotelValue) {

				throw new ValidationException("Already exists");

			}
			log.print(existingHotelValue);

			if (!correctdetail) {
				throw new ValidationException("Invalid Details");
			}
			log.print(correctdetail);
			dao.addNewHotelDetails(hotelFeilds);
			isValid = true;

		} catch (Exception e) {
			e.printStackTrace();

		}

		return isValid;

	}
}
