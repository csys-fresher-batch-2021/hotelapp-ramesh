<%@page import="in.ramesh.model.HotelModel"%>
<%@page import="in.ramesh.dao.HotelDAO"%>
<%@page import="java.util.List"%>
<%@page import="in.ramesh.service.HotelTypeService"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Hotel Room Booking</title>

</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
		<table class=" table table-container-fluid">
			<caption>Available Hotel</caption>
			<h2>Hotel Names</h2>

			<thead>
				<tr>
					<th scope="col">S.No</th>
					<th scope="col">Hotel Names</th>
				</tr>
			</thead>
			<tbody>
				<%
				String infoMessage = request.getParameter("infoMessage");
										if (infoMessage != null) {
											out.println("<font color='green'>" + infoMessage + "</font>");
										}
				%>

				<%
				HotelDAO dao = new HotelDAO();
					List<HotelModel> hotelName = HotelTypeService.displayHotelList();
					int i = 0;
						for (HotelModel hotel : hotelName) {
							i++;
				%>
				<tr>
					<td><%=i%></td>
					<td><%=hotel.getNewHotel()%></td>
					<td><a
						href="DeleteHotelServlet?hotelType=<%=hotel.getNewHotel()%>"
						class="btn btn-danger">Delete</a></td>
				</tr>
				<%
				}
				%>

			</tbody>
		</table>
		<a href="addHotel.jsp">Add Hotel</a>
	</main>
</body>
</html>






