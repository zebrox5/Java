<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="tile" uri="http://tiles.apache.org/tags-tiles"%>
<!DOCTYPE html>

<html lang="en">

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Document</title>
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

.nav-pills .nav-link {
	color: #555;
}

.nav-pills .nav-link.active {
	color: white
}

input[type="radio"] {
	margin-right: 5px;
}

.bold {
	font-weight: bold;
}

#radiusOfBox {
	border-radius: 10px;
}
</style>

<body>


	<div class="card-header">
		<div class="bg-white ml-4 mr-4 pt-4 pl-2 pr-2 pb-2"
			style="height: 450px;" id="radiusOfBox">
			<div class="row mb-4">
				<div
					style="float: top; width: 200px; height: 20px; background-color: #C39BD3;">
					<tile:insertAttribute name="menu" />
				</div>
				
				<div class="mx-auto text-center">
					<h1 class="display-6">Credit Card Details</h1>
				</div>
			</div>
			<div id="credit-card"
				class="mx-auto text-center active pt-3 pl-4 pr-4">

				<tile:insertAttribute name="deposit" />

			</div>
		</div>
	</div>

</body>

</html>