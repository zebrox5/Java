<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Withdraw</title>
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
	<div class="mask">

		<div class="container py-5">
			<div class="row">
				<div class="col-lg-8 mx-auto">
					<div class="card-header">
						<div class="bg-white pt-4 pl-2 pr-2 pb-2" style="height: 350px;"
							id="radiusOfBox">
							<div class="row mb-4">
								<div class="mx-auto text-center">
									<h1 class="display-6">Withdraw Amount</h1>
									<br />
									<h1 style="color: red">${msg}</h1>
								</div>
							</div>
							<div class="mx-auto text-center active pt-3 pl-4 pr-4">
								<form role="form" method="POST" action="/withdraw">
									<div class="form-group">
										<div class="col-7 mx-auto text-center">
											<input type="text" name="withdraw" id="withdraw"
												placeholder="Enter amount here" required
												class="form-control form-control-sm">
										</div>
									</div>

									<button type="submit" class="subscribe btn btn-primary"
										style="background-color: #5cb85c;">Submit</button>
								</form>

							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>