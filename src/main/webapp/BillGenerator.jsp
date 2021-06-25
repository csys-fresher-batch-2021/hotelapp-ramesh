<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Bill</title>
</head>
<body>


	<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">


		<%
		String finalamount = (String) session.getAttribute("amount");
		String hotelName = (String) session.getAttribute("hotelName");
		%>
		<form action="DisplayAllDetailsServlet" method="post">
			<table class=" table table-container-fluid">

				<caption>Bill is Generated</caption>
				<h2>Get your bill</h2>
				<thead>
					<tr>
						<th scope="col">Your Hotel </th>

						<th scope="col">Your Amount</th>

					</tr>
				</thead>
				<tbody>
					<tr>
						<td><%=hotelName%></td>
						<td>Rs.<%=finalamount%>


						</td>


					</tr>
				<tbody>

				</tbody>
			</table>
			<button type="submit" class="btn btn-primary">Submit</button>
		</form>
	</main>
</body>
</html>