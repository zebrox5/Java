<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Merienda+One">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>

<link rel="stylesheet" type="text/css"
	href="https://cdn.datatables.net/1.10.25/css/jquery.dataTables.css">
<script type="text/javascript" charset="utf8"
	src="https://cdn.datatables.net/1.10.25/js/jquery.dataTables.js"></script>

<style>
body {
	background: -webkit-linear-gradient(left, #023145, #04e07a);
}


div.dataTables_wrapper {
	padding-left: 15%;
	padding-right: 15%;
}

th {
	background-color: #343a40;
	color: white;
}

tr:nth-child(even) {
	background-color: #f2f2f2
}

 #radiusOfBox {
        border-radius: 10px;
    }
    
</style>

<script type="text/javascript">
	$(document).ready(function() {
		var data = eval('${customerList}');
		var table = $('#table').DataTable({
			"aaData" : data,
			"aoColumns" : [ {
				"mData" : "tId"
			}, {
				"mData" : "custId"
			}, {
				"mData" : "date"
			}, {
				"mData" : "transactionAmt"
			}, {
				"mData" : "balance"
			}, {
				"mData" : "transactionType"
			} ]
		});
	});
</script>
</head>
<body>
	<div class="card-header">
		<div class="bg-white ml-4 mr-4 pt-4 pl-2 pr-2 pb-2"
			style="height: 100%;" id="radiusOfBox">
			<div class="row mb-4">
				<div class="mx-auto text-center">
					<h1 class="display-6">Transaction History</h1>
				</div>
			</div>
			<div id="credit-card"
				class="mx-auto text-center active pt-3 pl-4 pr-4">
				<h1 style="color: red">${msg}</h1>
				<table id="table" class="table" cellspacing="0" width="100%"
					>
					<thead>
						<tr>
							<th>TId</th>
							<th>Customer Id</th>
							<th>Date</th>
							<th>Transaction Amount</th>
							<th>Balance</th>
							<th>Transaction Type</th>
						</tr>
					</thead>
				</table>


			</div>
		</div>
	</div>

</body>
</html>
