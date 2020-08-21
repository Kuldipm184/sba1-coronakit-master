<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Corona Kit-All Products(Admin)</title>
<link rel="stylesheet" type="text/css" href="css/form_withTable.css">
</head>
<body>
<jsp:include page="header.jsp"/>

<%-- Required View Template --%>
<button  onclick="window.location.href='admin?action=logout';return false;">logOut</button>


<%-- <input type="button" value="logOut" >
<c:url var="logOutLink" value="admin">
	<c:param name="action" value="logout"></c:param>
</c:url> --%>

	<div id="container">
		<div id="content">
		<button id="addProduct" onclick="window.location.href='newproduct.jsp';return false;">Add Product</button>
			<table border="2">
				<thead>
					<tr>
						<th>Product Name</th>
						<th>Cost</th>
						<th>Description</th>
						<th>Action</th>
					</tr>
				</thead>
				<tbody>
					
					<c:forEach var="tempProduct" items="${PRODUCT_LIST}">
						<c:url var="tempLink" value="admin">
							<c:param name="action" value="editproduct"></c:param>
							<c:param name="productId" value="${tempProduct.id}"></c:param>
						</c:url>
						<c:url var="deleteLink" value="admin">
							<c:param name="action" value="deleteproduct"></c:param>
							<c:param name="productId" value="${tempProduct.id}"></c:param>
						</c:url>
						<tr>
							<td>${tempProduct.productName}</td>
							<td>${tempProduct.cost}</td>
							<td>${tempProduct.productDescription}</td>
							<td><a href="${tempLink}">Edit</a>
							|
							<a href="${deleteLink}" 
							onclick="if (!(confirm('Are you sure you want to delete this product?')))return false">Delete</a>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>

	
	<jsp:include page="footer.jsp"/>
</body>
</html>