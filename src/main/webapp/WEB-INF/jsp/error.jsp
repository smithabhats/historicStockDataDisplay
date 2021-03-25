<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="ISO-8859-1">
<title>Application Error</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
</head>
<body>
	<form action="/RBC/stockIndex/home" method="GET" id="errorForm">
		<div class="container">
			<div class="row">
				<div class="col-md-12">
					<div class="card bg-dark my-5">
						<div class="card-body">
							<h2 class="card-title text-center text-white py-3">Internal
								application error!</h2>
							<ul class="text-center list-inline py-3">
								<li class="list-inline-item"><a href="#"
									class="btn btn-info" onclick="loadHomePage()">Back to home
										page</a></li>
							</ul>
						</div>
					</div>
				</div>
			</div>
		</div>
	</form>


	<script type="text/javascript">
		function loadHomePage() {
			console.log("go to home page");
			document.getElementById('errorForm').action = "/RBC/stockIndex/home";
			document.getElementById('errorForm').method = "get"
			document.getElementById('errorForm').submit();
		}
	</script>
</body>
</html>