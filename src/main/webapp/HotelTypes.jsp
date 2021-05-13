<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="in.ramesh.service.HotelDetailService"%>
    <%@page import="java.util.List"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Hotel Room Booking</title>
	
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
	<table class=" table table-container-fluid">
	<caption> List Of Hotels </caption>
		<thead>
		<tr>
			<th scope="col">S.No</th>
			<th scope="col">Hotel Types</th>
		</tr>
		</thead>
		<tbody>
		<%
		List<String> hotelType=HotelDetailService.getHotels();
				int i=0;
				for(String hotel: hotelType) {
			i++;
		%>
		<tr><td><%=i %></td>
		<td><%=hotel %>
		</td>
		</tr>
<%} %>

		</tbody>



	</table>
</body>
</html>