<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Corona Kit-Home</title>
<link rel="stylesheet" type="text/css" href="css/custom.css">
</head>
<body>
<div>
<jsp:include page="header.jsp"/>
<!-- <hr/> -->
	
	<form action="admin?action=login" method="post" id="login">
	<h2>Admin Login</h2>
		<div>
			<div><label for="loginid">Enter login Id</label> </div>
			<div><input type="text" id="loginid" name="loginid" placeholder="Enter login Id" required> </div>
		</div>
		<div>
			<div><label for="password">Enter password</label> </div>
			<div><input type="password" id="password" name="password" placeholder="Enter password" required> </div>
		</div>
		<div>
			<div><input type="submit" value="Login"> </div>
		</div>
	</form>
	<div>
	<a href="user?action=newuser"><button>Create Corona Kit</button></a>
</div>
</div>


<!-- <hr/>	 -->
	<jsp:include page="footer.jsp"/>
</body>
</html>