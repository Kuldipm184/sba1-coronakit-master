<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Corona Kit-Place Order(user)</title>
<link rel="stylesheet" type="text/css" href="css/custom.css">
</head>
<body>
<jsp:include page="header.jsp"/>


<div id="containier">
		<form action="user?action=saveorder" method="post">
		<h2><b>Place Order</b></h2>
			<table>
				<tr>
					<td><label>Name:</label></td>
					<td><input type="text" name="pname" disabled="disabled" value="${coronaKit.personName}"/></td>
				</tr>
				<tr>
					<td><label>Email:</label></td>
					<td><input type="text" name="pemail" disabled="disabled" value="${coronaKit.email}"/></td>
				</tr>
				<tr>
					<td><label>Contact:</label></td>
					<td><input type="text" name="pcontact" disabled="disabled" value="${coronaKit.contactNumber}"/></td>
				</tr>
				<tr>
					<td><label>Address:</label></td>
					<td><textarea name="address" required placeholder="Enter your complete address"></textarea></td>
				</tr>
				<tr>
					<td><label></label></td>
					<td><input type="submit" value="Order Summary" /></td>
				</tr>
			</table>
			
		</form>
		
	</div>
<%-- Required View Template --%>

	<jsp:include page="footer.jsp"/>
</body>
</html>