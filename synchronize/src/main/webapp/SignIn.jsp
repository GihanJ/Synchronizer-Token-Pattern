<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>SignIn</title>
	<link rel="stylesheet" href="css/bootstrap.css"/>
	<script type="text/javascript" src="js/bootstrap.js"></script>

</head>
<body>
	<div class="container h-100">
	<div class="row h-100 justify-content-center align-items-center">
	  <div class="col-md-6" >
		<form action="SignInController" method="post" class="form-horizontal">
  		<div class="form-group row" style="margin-top: 25%">
	    <label for="emailInput">Email Address</label>
	    <input type="email" class="form-control" id="email" name="email" aria-describedby="emailHelp" placeholder="Enter email">
	  </div>
	  <div class="form-group row" style="margin-top: 5%">
	    <label for="passwordInput">Password</label>
	    <input type="password" class="form-control" id="password" name="password" placeholder="Enter Password">
	  </div>
	 	<c:if test="${not empty sessionScope.invalidCredentials}">
			<div id="message" style="color:red;">Incorrect Credentials!</div>
		</c:if>
	  <button type="submit" class="btn btn-primary">Login</button>
	 
	</form>
	</div>
	</div>
	</div>
</body>
</html>