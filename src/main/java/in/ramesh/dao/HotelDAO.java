package in.ramesh.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import in.ramesh.model.HotelModel;

import in.ramesh.util.ConnectionUtil;

public class HotelDAO {

	public void addHotel(HotelModel addHotel) {
		Connection connection = null;
		PreparedStatement pst = null;
		try {

			connection = ConnectionUtil.getConnection();
			String sql = "INSERT INTO hotel(hotels) VALUES(?)";
			pst = connection.prepareStatement(sql);
			pst.setString(1, addHotel.getNewHotel());

			pst.executeUpdate();

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionUtil.close(pst, connection);
		}
	}

	public List<HotelModel> displayHotel() {
		Connection connection = null;
		PreparedStatement pst = null;
		List<HotelModel> hotelList = new ArrayList<>();
		try {

			connection = ConnectionUtil.getConnection();
			String sql = "SELECT * FROM hotel";
			pst = connection.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				String hotelType = rs.getString("hotels");
				HotelModel hotel = new HotelModel(hotelType);
				hotelList.add(hotel);
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionUtil.close(pst, connection);
		}
		return hotelList;
	}

	public void deleteHotel(HotelModel deleteHotel) {
		Connection connection = null;
		PreparedStatement pst = null;
		try {

			connection = ConnectionUtil.getConnection();
			String sql = "DELETE FROM hotel WHERE hotels=?";
			pst = connection.prepareStatement(sql);
			pst.setString(1, deleteHotel.getNewHotel());

			pst.executeUpdate();

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionUtil.close(pst, connection);
		}
	}

}
