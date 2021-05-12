package in.ramesh.service;

import java.util.ArrayList;
import java.util.List;

public class HotelDetails {
	private HotelDetails() {
		
	}
	

	private static List<String> hotelList = new ArrayList<>();
	
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


}
