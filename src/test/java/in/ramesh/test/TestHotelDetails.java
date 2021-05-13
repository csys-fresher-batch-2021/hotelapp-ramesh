package in.ramesh.test;
import java.util.List;
import static org.junit.Assert.*;
import org.junit.Test;
import in.ramesh.service.HotelDetailService;


public class TestHotelDetails {

	@Test
	public void testGetHotels(){
		List<String> hotelList = HotelDetailService.getHotels();
		assertEquals(5,hotelList.size());
		
	}
}
