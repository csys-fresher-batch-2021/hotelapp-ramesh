package in.ramesh.service;

import java.util.ArrayList;
import java.util.List;

import in.ramesh.dao.PaymentDAO;
import in.ramesh.exception.DBException;
import in.ramesh.exception.ValidationException;
import in.ramesh.model.PaymentModel;
import in.ramesh.util.Logger;
import in.ramesh.validator.HotelStringValidator;

public class PaymentService {
	private PaymentService() {

	}

	static Logger log = new Logger();
	private static PaymentDAO dao = new PaymentDAO();

	public static boolean addPaymentDetails(PaymentModel newPayment) {
		boolean flag = false;

		try {

			dao.addPaymentDetails(newPayment);
			flag = true;

		} catch (ValidationException e) {

			e.printStackTrace();
			throw new ValidationException("Unable to add details");
		}

		return flag;
	}

	public static boolean updatePayment(int paymentId) {

		boolean flag = false;
		try {

			dao.updatePayment(paymentId);
			flag = true;
			log.print("Updated the status");

		} catch (DBException e) {
			throw new DBException("Cannot Update");

		}
		return flag;

	}

	public static List<PaymentModel> findRecidencyDetails(String word) {
		List<PaymentModel> search = new ArrayList<>();
		try {
			if (HotelStringValidator.stringValidation(word)) {
				search = dao.findHotelDetails(word);
				log.print(search);
			}

		} catch (DBException | ValidationException e) {
			throw new ValidationException(e.getMessage());
		}
		return search;

	}

	public static List<PaymentModel> getAllPaymentDetails() {
		return dao.displayPaymentDetails();
	}

	public static List<PaymentModel> getUserBills(String userName) {

		return dao.findMyBills(userName);
	}
}
