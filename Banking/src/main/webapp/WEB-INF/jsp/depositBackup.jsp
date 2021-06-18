<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1 style="color: red">${msg}</h1>
	<div style="text-align: center">
		<!-- <h1>Deposit</h1>
		<form action="/deposit" method="post">
			<div>
				<input type="text" name="deposit" id="deposit"
					placeholder="Deposit Amount" required="required">
			</div>
			<input type="submit" name="submit" value="Submit">
		</form> -->
		<form role="form" method="POST" action="/payment">
			<div class="form-group">
				<div class="col-7 mx-auto text-center">
					<input type="text" name="name" placeholder="Card Owner Name"
						required class="form-control form-control-sm">
				</div>
			</div>

			<button type="submit" class="subscribe btn btn-primary"
				style="background-color: #5cb85c;">Confirm Payment</button>
		</form>

	</div>
</body>
</html>