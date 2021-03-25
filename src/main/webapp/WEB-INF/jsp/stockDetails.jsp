<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Historic stock data listing</title>

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
</head>
<body>
	<%@page import="java.util.ArrayList"%>
	<%@page import="com.rbc.stock.model.StockData"%>
	<%@page import="java.util.Iterator"%>

	<%
	ArrayList<StockData> stockList = (ArrayList) request.getAttribute("stockList");
	%>

	<ul class="text-center list-inline py-3">
		<li class="list-inline-item"><a href="#" class="btn btn-info"
			onclick="history.back()">Back to home page</a></li>
	</ul>
	<div class="card my-5">
		<div class="card-body">
			<%
				if (request.getAttribute("stockList") == null) {
				%>
					<label>No records found!</label>
			<% } %>
			<table class="table table-bordered table-striped">
				<thead class="thead-dark">
					<tr>
						<th scope="col">Stock Name</th>
						<th scope="col">Quarter</th>
						<th scope="col">Trading Date</th>
						<th scope="col">Opening Price</th>
						<th scope="col">Highest Price</th>
						<th scope="col">Lowest Price</th>
						<th scope="col">Closing Price</th>
						<th scope="col">Trading Volume</th>
						<th scope="col">% Change In Price</th>
						<th scope="col">Days To Next Dividend</th>
						<th scope="col">% Return In Next Dividend</th>
					</tr>
				</thead>
				<%
				if (request.getAttribute("stockList") != null) {
					Iterator<StockData> iterator = stockList.iterator();

					while (iterator.hasNext()) {
						StockData stockData = iterator.next();
				%>
				<tbody>
					<tr>
						<td><%=stockData.getStock().getStock_name()%></td>
						<td><%=stockData.getQuarter()%></td>
						<td><%=stockData.getTrading_date()%></td>
						<td><%=stockData.getOpen_price()%></td>

						<td><%=stockData.getHighest()%></td>

						<td><%=stockData.getLowest()%></td>

						<td><%=stockData.getClosing_price()%></td>

						<td><%=stockData.getVolume()%></td>

						<td><%=stockData.getPercent_change_price()%></td>

						<td><%=stockData.getDays_to_next_dividend()%></td>

						<td><%=stockData.getPercent_return_next_dividend()%></td>

					</tr>
				</tbody>
				<%
	}
}
%>
			</table>
		</div>
	</div>

	<ul class="text-center list-inline py-3">
		<li class="list-inline-item"><a href="#" class="btn btn-info"
			onclick="history.back()">Back to home page</a></li>
	</ul>
</body>
</html>