package in.ramesh.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import in.ramesh.model.PaymentModel;

import in.ramesh.util.ConnectionUtil;
import in.ramesh.util.Logger;

public class PaymentDAO {
	
	private static final String HOTEL_NAME="hotel_name";
	private static final String AMOUNT="amount";
	private static final String STATUS="status";
	private static final String USER_NAME="user_name";
	private static final String PAYMENT_ID="payment_id";

	public void addPaymentDetails(PaymentModel pay) {
		Connection connection = null;
		PreparedStatement pst = null;
		Logger log = new Logger();
		log.print(pay.getUsername());
		try {

			connection = ConnectionUtil.getConnection();
			if (connection != null) {
				String sql = "INSERT INTO payment(hotel_name,amount,status,user_name) "
						+ "VALUES(?,?,'PENDING',?)";

				pst = connection.prepareStatement(sql);

				pst.setString(1, pay.getHotelName());
				pst.setString(2, pay.getAmount());
				pst.setString(3, pay.getUsername());

				pst.executeUpdate();

			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionUtil.close(pst, connection);
		}

	}

	public void updatePayment(int paymentId) {
		Connection connection = null;
		PreparedStatement pst = null;
		try {

			connection = ConnectionUtil.getConnection();
			String sql = "UPDATE payment SET status='PAID' WHERE payment_id=?";
			pst = connection.prepareStatement(sql);

			pst.setInt(1, paymentId);

			pst.executeUpdate();

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionUtil.close(pst, connection);
		}
	}

	public List<PaymentModel> displayPaymentDetails() {
		Connection connection = null;
		PreparedStatement pst = null;
		List<PaymentModel> paymentStatus = new ArrayList<>();
		try {

			connection = ConnectionUtil.getConnection();
			String sql = "SELECT * FROM payment";

			pst = connection.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				String hotelName = rs.getString(HOTEL_NAME);
				String amount = rs.getString(AMOUNT);
				String status = rs.getString(STATUS);
				String username = rs.getString(USER_NAME);
				int paymentId = rs.getInt(PAYMENT_ID);
				PaymentModel paymentDetails = new PaymentModel(hotelName, amount, status, username, paymentId);
				paymentStatus.add(paymentDetails);
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionUtil.close(pst, connection);
		}
		return paymentStatus;
	}

	public List<PaymentModel> findHotelDetails(String word) {
		Connection connection = null;
		PreparedStatement pst = null;
		List<PaymentModel> find = new ArrayList<>();
		try {

			connection = ConnectionUtil.getConnection();
			String sql = "SELECT * FROM payment where status ILIKE ? OR hotel_name ILIKE ?;";

			pst = connection.prepareStatement(sql);
			pst.setString(1, "%" + word + "%");
			pst.setString(2, "%" + word + "%");

			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				String hotelName = rs.getString(HOTEL_NAME);
				String amount = rs.getString(AMOUNT);
				String status = rs.getString(STATUS);
				String username = rs.getString(USER_NAME);
				int paymentId = rs.getInt(PAYMENT_ID);
				PaymentModel pay = new PaymentModel( hotelName, amount, status, username, paymentId);
				find.add(pay);
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionUtil.close(pst, connection);
		}
		return find;

	}

	public List<PaymentModel> findMyBills(String username) {
		Connection connection = null;
		PreparedStatement pst = null;
		List<PaymentModel> billList = new ArrayList<>();
		try {

			connection = ConnectionUtil.getConnection();
			String sql = "SELECT*FROM payment WHERE user_name=?";

			pst = connection.prepareStatement(sql);
			pst.setString(1, username);

			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				String hotelName = rs.getString(HOTEL_NAME);
				String amount = rs.getString(AMOUNT);
				String status = rs.getString(STATUS);
				int paymentId = rs.getInt(PAYMENT_ID);
				PaymentModel bill = new PaymentModel( hotelName, amount, status, username, paymentId);
				billList.add(bill);
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionUtil.close(pst, connection);
		}
		return billList;

	}

}
