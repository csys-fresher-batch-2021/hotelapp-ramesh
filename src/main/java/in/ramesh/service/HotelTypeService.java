package in.ramesh.service;

import java.util.List;

import in.ramesh.dao.HotelDAO;
import in.ramesh.model.HotelModel;

public class HotelTypeService {

	private HotelTypeService() {

	}

	public static List<HotelModel> displayHotelList() {
		HotelDAO dao = new HotelDAO();

		return dao.displayHotel();

	}

	public static boolean addHotelList(HotelModel newHotel) {

		boolean valid = false;
		boolean exists = false;
		HotelDAO dao = new HotelDAO();
		List<HotelModel> hotelNames = dao.displayHotel();
		for (HotelModel hotelModel : hotelNames) {

			if (hotelModel.getNewHotel().equalsIgnoreCase(newHotel.getNewHotel())) {

				exists = true;
				break;
			}

		}

		if (!exists) {

			dao.addHotel(newHotel);
			valid = true;
		}

		return valid;

	}

	public static boolean deleteHotelList(HotelModel deleteHotel) {
		boolean valid = false;
		HotelDAO dao = new HotelDAO();
		List<HotelModel> hotelName = dao.displayHotel();
		for (HotelModel hotel : hotelName) {
			String deleteHotel2 = hotel.getNewHotel();
			if (deleteHotel != null && deleteHotel2.equalsIgnoreCase(deleteHotel.getNewHotel())) {

				valid = true;

			}

		}
		if (valid) {
			dao.deleteHotel(deleteHotel);
		}
		return valid;
	}

}
