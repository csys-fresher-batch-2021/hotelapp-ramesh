package in.ramesh.service;

import java.util.ArrayList;
import java.util.List;

public class HotelDetails {
	

	private static List<String> hotelList = new ArrayList<String>();
	
	static {
		hotelList.add("Sky Lite");
		hotelList.add("Raddison Blu");
		hotelList.add("Blue ice");
		}
	public static List<String> getHotels(){
		return hotelList;
	}

}
