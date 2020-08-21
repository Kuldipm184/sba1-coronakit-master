<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Corona Kit-Error</title>
<link rel="stylesheet" type="text/css" href="css/error.css">
</head>
<body id="error">
<jsp:include page="header.jsp"/>

	<div>
		<h3>Something went wrong! We regret the inconvenience!</h3>
		<p>Error Message : <%=exception.getMessage()%> </p>
		<p>Please Contact Administrator</p>
	</div>

	<jsp:include page="footer.jsp"/>
</body>
</html>