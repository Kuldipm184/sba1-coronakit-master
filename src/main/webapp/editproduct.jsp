<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Corona Kit-Edit Product(Admin)</title>
<link rel="stylesheet" type="text/css" href="css/custom.css">
</head>
<body>
<jsp:include page="header.jsp"/>


<%-- Required View Template --%>
<div id="containier">
		<form action="admin?action=updateproduct" method="post">
			<input type="hidden" name="productId" value="${THE_PRODUCT.id}"/>
			
			<table>
			<tr>
				<td><label>Product Name:</label></td>
				<td><input type="text" name="pname" value="${THE_PRODUCT.productName}"/></td>
			</tr>
			<tr>
				<td><label>Cost:</label></td>
				<td><input type="text" name="pcost" value="${THE_PRODUCT.cost}"/></td>
			</tr>
			<tr>
				<td><label>Description:</label></td>
				<td><input type="text" name="pdesc" value="${THE_PRODUCT.productDescription}"/></td>
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