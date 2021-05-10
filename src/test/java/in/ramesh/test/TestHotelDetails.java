package in.ramesh.test;
import java.util.List;
import static org.junit.Assert.*;

import org.junit.Test;

import in.ramesh.service.HotelDetails;


public class TestHotelDetails {

	@Test
	public void testgetHotels(){
		List<String> hotelList = HotelDetails.getHotels();
		assertEquals(3,hotelList.size());
		
	}
}
