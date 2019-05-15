<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Money Transfer</title>
<link rel="stylesheet" href="../css/bootstrap.css"/>
	<script type="text/javascript" src="../js/bootstrap.js"></script>
</head>
<body>


<h2> Enter Your Account Number and Amount to Start Transferring </h2>


<div class="container h-100">
	<div class="row h-100 justify-content-center align-items-center">
	  <div class="col-md-6" >
		<form name="Form" action="../HomeController" method="post" class="form-horizontal">
  		<div class="form-group row" style="margin-top: 25%">
	    <label for="accountInput">Account Number</label>
	    <input type="number" class="form-control" id="accountNo" name="accountNo" placeholder="Enter Account Number" min="0">
	  </div>
	  <div class="form-group row" style="margin-top: 5%">
	    <label for="amountInput">Amount</label>
	    <input type="number" class="form-control" id="amount" name="amount" placeholder="Enter Amount" min="0">
	  </div>
	 
	  <button type="submit" class="btn btn-primary">Transfer</button>
	 
	</form>
	</div>
	</div>
	</div>


</body>
</html>