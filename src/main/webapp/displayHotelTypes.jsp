<%@page import="in.ramesh.model.HotelModel"%>
<%@page import="in.ramesh.service.HotelTypeService"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
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
				List<HotelModel> hotelName = HotelTypeService.displayHotelList();
												int i = 0;
												for (HotelModel hotel : hotelName) {
													i++;
				%>
				<tr>
					<td><%=i%></td>
					<td><%=hotel.getNewHotel()%></td>
				</tr>
				<%
				}
				%>
			</tbody>
		</table>
	</main>

</body>
</html>