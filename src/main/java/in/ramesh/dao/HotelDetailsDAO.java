package in.ramesh.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import in.ramesh.model.BillCalculatorModel;
import in.ramesh.util.ConnectionUtil;

public class HotelDetailsDAO {

	public void addNewHotelDetails(BillCalculatorModel hotelFeilds) {
		Connection connection = null;
		PreparedStatement pst = null;

		try {

			connection = ConnectionUtil.getConnection();
			if (connection != null) {
				String sql = "INSERT INTO hoteltype(hotel_name,contact_no,city_name,"
						+ "district_name,rooms)VALUES(?,?,?,?,?)";

				pst = connection.prepareStatement(sql);

				pst.setString(1, hotelFeilds.getHotelName());
				pst.setString(2, hotelFeilds.getContactNo());
				pst.setString(3, hotelFeilds.getCityName());
				pst.setString(4, hotelFeilds.getDistrict());
				pst.setString(5, hotelFeilds.getRooms());

				pst.executeUpdate();

			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionUtil.close(pst, connection);
		}

	}

	public List<BillCalculatorModel> displayHotelDetails() {
		Connection connection = null;
		PreparedStatement pst = null;
		List<BillCalculatorModel> hotelList = new ArrayList<>();
		try {

			connection = ConnectionUtil.getConnection();
			String sql = "SELECT * FROM hoteltype";

			pst = connection.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				String hotelId = rs.getString("hotel_id");
				String hotelName = rs.getString("hotel_name");
				String contactNo = rs.getString("contact_no");
				String cityName = rs.getString("city_name");
				String district = rs.getString("district_name");
				String rooms = rs.getString("rooms");

				System.out.println(hotelName);
				
				BillCalculatorModel hotel = new BillCalculatorModel(hotelId, hotelName,contactNo, cityName, district, rooms);
				hotelList.add(hotel);
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionUtil.close(pst, connection);
		}
		return hotelList;
	}
}
