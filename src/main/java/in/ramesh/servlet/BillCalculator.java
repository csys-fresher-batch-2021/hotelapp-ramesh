package in.ramesh.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import in.ramesh.exception.InputMissMatchException;
import in.ramesh.exception.ValidationException;
import in.ramesh.model.BillCalculatorModel;
import in.ramesh.model.PaymentModel;
import in.ramesh.service.BillCalculatorService;
import in.ramesh.service.BillGeneratorService;
import in.ramesh.service.PaymentService;
import in.ramesh.util.Logger;

/**
 * Servlet implementation class SelectRecidencyType
 */
@WebServlet("/BillCalculator")
public class BillCalculator extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Logger log = new Logger();
		log.print("############ Bill calculator started###########");
		String hotelName = request.getParameter("hotelName");
		String contactNo = request.getParameter("contactNo");
		String cityName = request.getParameter("cityName");
		String district = request.getParameter("districtName");
		String rooms = request.getParameter("room");

		BillCalculatorModel bill = new BillCalculatorModel();
		bill.setHotelName(hotelName);
		bill.setContactNo(contactNo);
		bill.setCityName(cityName);
		bill.setDistrict(district);
		bill.setRooms(rooms);
	
		
		
		
		boolean flag = BillCalculatorService.addHotelDetails(bill);
		HttpSession session = request.getSession();
		String amount = null;
		try {

			if (flag) {
				log.print("room=" + rooms + ",hotelName=" + hotelName);
				amount = BillGeneratorService.generateBill(hotelName, rooms);
				session.setAttribute("amount", amount);
				session.setAttribute("hotelName", hotelName);
				PaymentModel payment = new PaymentModel();
				payment.setHotelName(hotelName);
				payment.setAmount(amount);
				String username = (String) session.getAttribute("LOGGED_IN_USER");
				payment.setUsername(username);
				boolean isCorrect = PaymentService.addPaymentDetails(payment);
				log.print(isCorrect);
				String message = "Bill Generated Successfully";
				response.sendRedirect("BillCalculator.jsp?message=" + message);
			} else {
				String errorMessage = "Unable To Add  Input Credentials";
				session.setAttribute("errorMessage", errorMessage);
				response.sendRedirect("BillCalculator.jsp?errorMessage=" + errorMessage);

			}

		} catch (ValidationException | InputMissMatchException e) {
			e.printStackTrace();

			response.sendRedirect("BillCalculator.jsp?errorMessage=" + e.getMessage());

		}
	}

}
