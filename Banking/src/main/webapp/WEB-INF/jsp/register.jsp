<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>Register - CTS Banking</title>
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

<style>
body {
	color: #999;
	background: #f5f5f5;
	font-family: 'Varela Round', sans-serif;
}

#intro {
	/*         background-image: url("https://ppg-prelaunch.customer-self-service.com/images/Orders%20&%20Returns%20Image.jpg?u=2YhL"); */
	background: -webkit-linear-gradient(left, #023145, #04e07a);
	height: 150vh;
}

.register {
	background: -webkit-linear-gradient(left, #023145, #04e07a);
	margin-top: 3%;
	padding: 3%;
}

.rounded {
	border-radius: .50rem !important;
	/* border-radius: 25px; */
}

.rounded-btn {
	border-radius: .25rem !important;
	/* border-radius: 25px; */
}

.form-control {
	box-shadow: none;
	border-color: #ddd;
}

.form-control:focus {
	border-color: #4aba70;
}

.login-form {
	width: 350px;
	margin: 0 auto;
	padding: 30px 0;
}

.login-form form {
	color: #434343;
	border-radius: 1px;
	margin-bottom: 15px;
	background: whitesmoke;
	border: 1px solid #f3f3f3;
	box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);
	padding: 30px;
}

.login-form h4 {
	text-align: center;
	font-size: 22px;
	margin-bottom: 20px;
}

.login-form .avatar {
	color: #fff;
	margin: 0 auto 30px;
	text-align: center;
	width: 100px;
	height: 100px;
	border-radius: 50%;
	z-index: 9;
	background: #4aba70;
	padding: 15px;
	box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.1);
}

.login-form .avatar i {
	font-size: 62px;
}

.login-form .form-group {
	margin-bottom: 20px;
}

.login-form .form-control, .login-form .btn {
	min-height: 40px;
	border-radius: 2px;
	transition: all 0.5s;
}

.login-form .close {
	position: absolute;
	top: 15px;
	right: 15px;
}

.login-form .btn, .login-form .btn:active {
	background: #4aba70 !important;
	border: none;
	line-height: normal;
}

.login-form .btn:hover, .login-form .btn:focus {
	background: #42ae68 !important;
}

.login-form .checkbox-inline {
	float: left;
}

.login-form input[type="checkbox"] {
	position: relative;
	top: 2px;
}

.login-form .forgot-link {
	float: right;
}

.login-form .small {
	font-size: 13px;
}

.login-form a {
	color: #4aba70;
}
</style>

</head>
<body>
	<div id="intro" class="bg-image shadow-2-strong">
		<div class="mask">
			<div
				class="container d-flex align-items-center justify-content-center text-center h-100">
				<div class="text-white">

					<div class="container rounded login-form">

						<br>
						<form class="rounded" action="register" method="post">
							<h4 class="modal-title">
								<b>CTS Banking</b>
							</h4>
							<div class="avatar">
								<i class="material-icons">&#xE7FF;</i>
							</div>

							<h4 class="modal-title">Register to access CTS Banking
								Service</h4>
							<div class="form-group">
								<input type="text" name="custname" id="custname"
									class="rounded-btn form-control" placeholder="Full Name"
									required="required">
							</div>
							<div class="form-group">
								<input type="text" name="phone" id="phone"
									class="rounded-btn form-control" placeholder="Phone Number"
									required="required">
							</div>
							<div class="form-group">
								<input type="password" name="password" id="password"
									class="rounded-btn form-control" placeholder="Password"
									required="required">
							</div>
							<div class="form-group">
								<input type="password" name="confirmPassword"
									id="confirmPassword" class="rounded-btn form-control"
									placeholder="Confirm Password" required="required">
							</div>
							<input type="submit" name="submit" value="Submit"
								class="btn rounded-btn btn-primary btn-block btn-lg"> <br />
							<h6 style="color: red">${msg}</h6>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>

</body>
</html>