package in.ramesh.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import in.ramesh.model.HotelModel;
import in.ramesh.service.HotelTypeService;

@WebServlet("/DeleteHotelServlet")
public class DeleteHotelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String deleteHotel = request.getParameter("hotelType");
		HotelModel delete = new HotelModel(deleteHotel);
		boolean isValid = HotelTypeService.deleteHotelList(delete);
		if (isValid) {
			String infoMessage = "Hotel Deleted Sucessfully";
			response.sendRedirect("TypeOfHotel.jsp?infoMessage=" + infoMessage);

		} else {
			response.sendRedirect("TypeOfHotel.jsp");
		}

	}
}
