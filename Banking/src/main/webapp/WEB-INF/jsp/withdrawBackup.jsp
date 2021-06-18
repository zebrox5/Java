<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1 style="color: red"> ${msg} </h1>
	<div style="text-align: center">
		<h1>Withdraw</h1>
		<form action="/withdraw" method="post">
			<div>
				<input type="text" name="withdraw" id="withdraw"
					placeholder="Withdraw Amount" required="required">
			</div>
			<input type="submit" name="submit" value="Submit">
		</form>
	</div>
</body>
</html>