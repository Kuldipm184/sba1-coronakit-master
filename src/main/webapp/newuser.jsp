<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Corona Kit-New User(user)</title>
<link rel="stylesheet" type="text/css" href="css/custom.css">
</head>
<body>
<jsp:include page="header.jsp"/>
<!-- <hr/> -->

<%-- Required View Template --%>

<div id="containier">
		<form action="user?action=insertuser" method="post">
		<h2><b>Add User</b></h2>
			<table>
				<tr>
					<td><label>Name:</label></td>
					<td><input type="text" name="pname" required  placeholder ="Enter Name"/></td>
				</tr>
				<tr>
					<td><label>Email:</label></td>
					<td><input type="text" name="pemail" required placeholder ="Enter Email"/></td>
				</tr>
				<tr>
					<td><label>Contact:</label></td>
					<td><input type="text" minlength ="10" maxlength = "10" required name="pcontact" placeholder ="Enter Contact"/></td>
				</tr>
				<tr>
					<td><label></label></td>
					<td><input type="submit" value="Save" /></td>
				</tr>
			</table>
			
		</form>
		
	</div>
<!-- <hr/>	 -->
	<jsp:include page="footer.jsp"/>
</body>
</html>