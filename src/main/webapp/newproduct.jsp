<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Corona Kit-Add New Product(Admin)</title>
<link rel="stylesheet" type="text/css" href="css/custom.css">
</head>
<body>
<jsp:include page="header.jsp"/>


<%-- Required View Template --%>
<div id="containier">
		<form action="admin?action=insertproduct" method="post">
			<!-- <input type="hidden" name="command" value="ADD"/> -->
			
			<table>
			<tr>
				<td><label>Product Name:</label></td>
				<td><input type="text" name="pname"/></td>
			</tr>
			<tr>
				<td><label>Cost:</label></td>
				<td><input type="text" name="pcost"/></td>
			</tr>
			<tr>
				<td><label>Description:</label></td>
				<td><input type="text" name="pdesc"/></td>
			</tr>
			<tr>
				<td><label></label></td>
				<td><input type="submit" value="Save" class="save"/></td>
			</tr>
			</table>
			
		</form>
		<div style="clear:both"></div>
		<p>
		<a href="admin?action=list">Back To List of products</a>
		</p>
	
	</div>
	
	<jsp:include page="footer.jsp"/>
</body>
</html>