<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New Stock Record</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
</head>
<body>

	<form:form action="/RBC/stockIndex/saveStockData" method="POST"
		id="stock_form" modelAttribute="stockData"  onsubmit="dispSaved()">

		<div class="container">
			<div class="row">
				<div class="col-md-12">
					<div class="card bg-dark my-5">
						<div class="card-body">
							<h2 class="card-title text-center text-white py-3">Add Stock
								Record</h2>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div id="stockFormDiv">
			<div class="container">
				<div class="row">
					<div class="col-md-6">
						<div class="card my-5">
							<div class="card-body">
								<%@page import="java.util.ArrayList"%>
								<%@page import="com.rbc.stock.model.Stock"%>
								<%@page import="com.rbc.stock.model.StockData"%>
								<%@page import="java.util.Iterator"%>

								<%
								ArrayList<Stock> indexStocks = (ArrayList) request.getAttribute("indexStocks");
								%>
								<div class="form-group">
									<label>Company</label>
									<form:select path="stock_id" class="form-control">
										<%
										if (request.getAttribute("indexStocks") != null) {
											Iterator<Stock> iterator = indexStocks.iterator();

											while (iterator.hasNext()) {
												Stock stock = iterator.next();
										%>
										<option value=<%=stock.getStock_id()%>><%=stock.getStock_name()%></option>
										<%
										}
										}
										%>
									</form:select>
								</div>
								<div class="form-group">
									<form:label path="trading_date">Trading Date</form:label>
									<form:input type="date" path="trading_date" min='2011-01-01' max='2011-12-31'
										class="form-control"  required="true"/>
								</div>
								<div class="form-group">
									<form:label path="open_price">Opening Price</form:label>
									<form:input path="open_price" class="form-control" required="true"/>
								</div>
								<div class="form-group">
									<form:label path="highest">Highest Price</form:label>
									<form:input path="highest" class="form-control" required="true"/>
								</div>
								<div class="form-group">
									<form:label path="lowest">Lowest Price</form:label>
									<form:input path="lowest" class="form-control"  required="true"/>
								</div>
								<div class="form-group">
									<form:label path="closing_price">Closing Price</form:label>
									<form:input path="closing_price" class="form-control"  required="true"/>
								</div>
								<div class="form-group">
									<form:label path="volume">Trading Volume</form:label>
									<form:input path="volume" class="form-control"  required="true"/>
								</div>
								<div class="form-group">
									<form:label path="days_to_next_dividend">Days To Next Dividend</form:label>
									<form:input path="days_to_next_dividend" class="form-control"  required="true"/>
								</div>
								<div class="form-group">
									<form:label path="percent_return_next_dividend">% Return In Next Dividend</form:label>
									<form:input path="percent_return_next_dividend"
										class="form-control"  required="true"/>
								</div>
								<button type="submit" class="btn btn-info">Submit</button>
								<a href="#" class="btn btn-info" onclick="history.back()">Back to home page</a>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>


	</form:form>

<script>
function dispSaved() {
  alert("Data saved successfully!");
  
}
</script>
</body>
</html>