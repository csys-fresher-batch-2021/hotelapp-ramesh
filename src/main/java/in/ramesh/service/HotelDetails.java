package in.ramesh.service;

import java.util.ArrayList;
import java.util.List;

public class HotelDetails {
	

	private static List<String> hotelList = new ArrayList<String>();
	
	static {
		hotelList.add("Sky Lite");
		hotelList.add("Raddison Blu");
		hotelList.add("Blue ice");
		hotelList.add("Orbis");
		hotelList.add("Vijay Elanza");
		
		}
	public static List<String> getHotels(){
		return hotelList;
	}
//	public static void addHotelType(String newHotel) {
//			hotelList.add("Sky Lite");
//			hotelList.add("Raddison Blu");
//			hotelList.add("Blue ice");
//			hotelList.add("Orbis");
//			hotelList.add("Vijay Elanza");
//		
//	}

}
