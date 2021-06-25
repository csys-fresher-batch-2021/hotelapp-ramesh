package in.ramesh.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.ramesh.model.HotelModel;
import in.ramesh.service.HotelTypeService;

/**
 * Servlet implementation class AddRecidencyServlet
 */
@WebServlet("/AddHotelServlet")
public class AddHotelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	/**
	 * // add data to arraylist
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String newHotel = request.getParameter("hotel");
		HotelModel hotelPackage = new HotelModel(newHotel);
		boolean isValid = HotelTypeService.addHotelList(hotelPackage);
		if (isValid) {

			response.sendRedirect("TypeOfHotel.jsp");

		} else {
			String errorMessage = "Already exists";
			response.sendRedirect("addHotel.jsp?errorMessage=" + errorMessage);
		}

	}

}
