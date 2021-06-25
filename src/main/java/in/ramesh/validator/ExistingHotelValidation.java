package in.ramesh.validator;

import java.util.List;

import in.ramesh.dao.HotelDetailsDAO;
import in.ramesh.model.BillCalculatorModel;

public class ExistingHotelValidation {
	private ExistingHotelValidation() {

	}

	public static boolean isExistingHotelValue(BillCalculatorModel addHotelDetails) {

		boolean isSame = true;
		HotelDetailsDAO dao = new HotelDetailsDAO();
		List<BillCalculatorModel> hoteldetailsList = dao.displayHotelDetails();
		for (BillCalculatorModel checkHotelDetails : hoteldetailsList) {
			if (checkHotelDetails.getCityName().equalsIgnoreCase(addHotelDetails.getCityName())
					&& checkHotelDetails.getDistrict().equalsIgnoreCase(addHotelDetails.getDistrict())
					&& checkHotelDetails.getContactNo().equalsIgnoreCase(addHotelDetails.getContactNo())
					&& checkHotelDetails.getRooms().equalsIgnoreCase(addHotelDetails.getRooms())
					&& checkHotelDetails.getHotelName().equalsIgnoreCase(addHotelDetails.getHotelName())) {
				isSame = false;
			}
		}
		return isSame;
	}

}
