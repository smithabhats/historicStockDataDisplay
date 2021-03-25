<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Historic Stock Data Listing</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
</head>
<body>
	<form action="/RBC/stockIndex/getStockDetails" method="GET"
		id="main_form">
		<div class="container">
			<div class="row">
				<div class="col-md-12">
					<div class="card bg-dark my-5">
						<div class="card-body">
							<h2 class="card-title text-center text-white py-3">Historic
								Stock Data Listing</h2>
							<ul class="text-center list-inline py-3">
								<li class="list-inline-item"><a href="#"
									class="btn btn-info"
									onclick="showDisplayOptions(); return false;">List Stock
										Details</a></li>
								<li class="list-inline-item"><a href="#"
									class="btn btn-info" onclick="showAddOptions(); return false;">Update
										Stock Data</a></li>
							</ul>
						</div>
					</div>
				</div>
			</div>

		</div>

<%-- 		<%
		if (request.getAttribute("saveSuccessMsg") != null &&
				request.getAttribute("saveSuccessMsg") == "Success") {%>
		<div id="msgDiv">
			<div class="container">
				<div class="row">
					<div class="col-md-6">
						<div class="card my-5">
							<div class="card-body">
								<div class="form-group">
									<label>Record saved successfully!</label>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<% } %> --%>

		<div id="listingDiv" style="display: none;">
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
									<label>Company</label> <select name="companyId" id="companyId"
										class="form-control">
										<option value="0">All</option>
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
									</select>
								</div>

								<div class="form-group">
									<label>Quarter</label> <select name="quarter" id="quarter"
										class="form-control">
										<option value="1">Q1(Jan-Mar)</option>
										<option value="2">Q2(Apr-Jun)</option>
										<option value="3">Q3(Jul-Sep)</option>
										<option value="4">Q4(Oct-Dec)</option>
									</select>
								</div>
								<button type="submit" class="btn btn-info">Submit</button>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>


		<div id="detailsDiv" style="display: none;">
			<div class="container">
				<div class="row">
					<div class="col-md-6">
						<div class="card my-5">
							<div class="card-body">
								<div class="form-group">
									<label>Bulk Upload: </label> 
									<input type="file" id="dataFile" name="dataFile">										 
								</div>

								<input type="button" class="btn btn-info" value="Upload Data"
									onclick="processBulkData();">
							</div>
						</div>
					</div>


					<div class="col-md-6">
						<div class="card my-5">
							<div class="card-body">
								<div class="form-group">
									<label>Enter data manually</label>
								</div>

								<input type="button" class="btn btn-info"
									value="Stock Details Form" onclick="loadStockForm();">
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>

	</form>

	<script type="text/javascript">
		function showDisplayOptions() {
			console.log("Display stock details");
			var x = document.getElementById("listingDiv");
			var d = document.getElementById("detailsDiv");
			var md = document.getElementById("msgDiv");
			x.style.display = "block";
			d.style.display = "none";
			md.style.display = "none";
		}

		function showAddOptions() {
			console.log("Add stock details");
			var d = document.getElementById("detailsDiv");
			var x = document.getElementById("listingDiv");
			var md = document.getElementById("msgDiv");
			d.style.display = "block";
			x.style.display = "none";
			md.style.display = "none";
		}

		function processBulkData() {
			console.log("Process bulk stock details");
			if(document.getElementById("dataFile").files.length == 0 ){
				alert("Please choose a file to upload!");
				return;
			}
			document.getElementById('main_form').action = "/RBC/stockIndex/bulkUpload";
			document.getElementById('main_form').method = "post"
			document.getElementById('main_form').enctype = "multipart/form-data"
			document.getElementById('main_form').submit();
			alert("File uploaded to be processed!");
		}

		function loadStockForm() {
			console.log("Add stock data");
			document.getElementById('main_form').action = "/RBC/stockIndex/loadStockForm";
			document.getElementById('main_form').method = "get"
			document.getElementById('main_form').submit();
		}
	</script>
</body>
</html>