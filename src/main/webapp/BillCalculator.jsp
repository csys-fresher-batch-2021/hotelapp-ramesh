<%@page import="in.ramesh.model.HotelModel"%>
<%@page import="java.util.List"%>
<%@page import="in.ramesh.service.HotelTypeService"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Select Hotel</title>
</head>
<body>
	<jsp:include page="message.jsp"></jsp:include>
	<main class="container-fluid">
		<h3>Bill Calculation</h3>

		<%
		String message = request.getParameter("message");
		if (message != null) {
			out.println("<font color='green'>" + message + "</font>");
		}
		%>
		<form action="BillCalculator" method="post">

			<label>Hotel Name</label> <select name="hotelName">
				<option value="">Please select a Hotel</option>
				<%
				List<HotelModel> hotelType = HotelTypeService.displayHotelList();

				for (HotelModel hotel : hotelType) {
				%>

				<option value="<%=hotel.getNewHotel()%>">

					<%=hotel.getNewHotel()%>
					<%
					}
					%>
				</option>

			</select><br> 
			<label>Enter your contact number</label> <input type="text" name="contactNo" required><br>

			<label>Enter Your City</label> <input type="text" name="cityName"
				required><br> <label>Enter Your District</label> <input
				type="text" name="districtName" required><br> <label>Enter
				Number of rooms You need to pay</label> <input type="number" name="room"
				min=1 max=3 required><br>

			<button type="submit" class="btn btn-primary">Get Bill</button>
			<button type="reset" class="btn btn-danger">Reset</button>
		</form>
	</main>
</body>
</html>