<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home</title>
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Merienda+One">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/icon?family=Material+Icons">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>

</head>
<style>
body {
	background: -webkit-linear-gradient(left, #023145, #04e07a);
}

#radiusOfBox {
	border-radius: 10px;
}
</style>
<body>
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
		<div class="container-fluid">
			<a class="navbar-brand" href="#">CTS Banking</a>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
				aria-controls="navbarSupportedContent" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav me-auto mb-2 mb-lg-0">
					<li class="nav-item"><a class="nav-link active"
						aria-current="page" href="/deposit">Deposit</a></li>
					<li class="nav-item"><a class="nav-link" href="/withdraw">Withdraw</a>
					</li>
					<li class="nav-item"><a class="nav-link" href="/transactionhistory">Transactions
							History</a></li>
				</ul>
			</div>
		</div>
		<form class="d-flex" style="float: right" action="/logout" method="POST">
			<button class="btn btn-outline-light" type="submit">Logout</button>
		</form>
	</nav>
	<div class="container py-5">

		<div class="mx-auto text-center">
			<h1 class="display-6" style="color: rgb(224, 224, 224)">Welcome
				to the CTS Bank. Choose you options from above</h1>
				<br/>
				<br/>
				<h3 style="color: blue"> ${msg} </h3>
		</div>
	</div>

</body>
</html>