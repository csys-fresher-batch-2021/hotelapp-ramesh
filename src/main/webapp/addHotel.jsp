<%@page import="in.ramesh.servlet.AddHotelServlet"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Add Hotel</title>
</head>
<body>

	<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
		<form action="AddHotelServlet" method="post">
			<%
			String errorMessage = request.getParameter("errorMessage");
			if (errorMessage != null) {
				out.println("<font color='red'>" + errorMessage + "</font>");
			}
			%>



			<h2>Add Hotel</h2>

			<label for=" addHotel">Hotel</label> <input type="text"
				name="hotel" required>
			<button type="submit">Submit</button>
		</form>

	</main>


</body>
</html>