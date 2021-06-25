package in.ramesh.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import in.ramesh.exception.DBException;
import in.ramesh.model.PaymentModel;
import in.ramesh.service.PaymentService;
import in.ramesh.util.Logger;

/**
 * Servlet implementation class SearchRecidencyDetails
 */
@WebServlet("/SearchHotelDetailsServlet")
public class SearchHotelDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		Logger log = new Logger();

		String word = request.getParameter("search");
		try {
			List<PaymentModel> search = PaymentService.findHotelDetails(word);
			log.print(search);
			request.setAttribute("hotelList", search);
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("SearchHotelDetails.jsp");
			requestDispatcher.forward(request, response);
		} catch (DBException e) {
			String message = e.getMessage();
			session.setAttribute("message", message);
			response.sendRedirect("SearchHotelDetails.jsp?message=" + message);
		}
	}

}
