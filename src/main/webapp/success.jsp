<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Corona Kit-Success</title>
<link rel="stylesheet" type="text/css" href="css/custom.css">
</head>
<body>
<jsp:include page="header.jsp"/>

	<div>
	    <img src="images/success.gif" /> 
		<h2><b>Order placed successfully</b></h2>
		<button  onclick="window.location.href='admin?action=logout';return false;">Navigate to homepage</button>
	</div>

	<jsp:include page="footer.jsp"/>
</body>
</html>