package in.ramesh.service;

import in.ramesh.dao.HotelDetailsDAO;
import in.ramesh.model.BillCalculatorModel;

public class BillGeneratorService {
	private BillGeneratorService() {

	}

	public static String getId() {

		HotelDetailsDAO dao = new HotelDetailsDAO();
		String hotelId = null;
		for (BillCalculatorModel id : dao.displayHotelDetails()) {
			hotelId = id.getHotelId();
			
		}

		return hotelId;
	}

	public static String generateBill(String hotelName, String userRoom) {

		int room = Integer.parseInt(userRoom);
		int pay = 0;
		int amount = 0;

		if (hotelName.equalsIgnoreCase("normal")) {
			pay = 1200;

		} else if (hotelName.equalsIgnoreCase("good")) {
			pay = 1600;
		} else {
			pay = 2000;
		}
		amount = getAmount(room, pay, amount);

		return String.valueOf(amount);
	}

	public static int getAmount(int room, int pay, int amount) {
		if (room < 4 || room > 0) {
			amount = pay * room;
		}
		return amount;
	}

}
