<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Corona Kit-My Kit(user)</title>
<link rel="stylesheet" type="text/css" href="css/form_withTable.css">
</head>
<body>
<jsp:include page="header.jsp"/>


<%-- Required View Template --%>

<form action="user?action=placeorder" method="post">


<c:set var = "kitDetails" value="${orderSummery.kitDetails}"></c:set>
<c:set var = "coronaKit" value="${orderSummery.coronaKit}"></c:set>

<table border="2" >
	<thead>
		<th>Name</th>
		<th>Contact</th>
		<th>Email</th>
	</thead>
	<tbody>
		<tr>
			<td>${coronaKit.personName}</td>
			<td>${coronaKit.contactNumber}</td>
			<td>${coronaKit.email}</td>
		</tr>
	</tbody>
</table>
		<!-- new ProductMaster(id, productName, cost, productDescription) -->
<!-- new KitDetail(id, coronaKitId, productId, quantity, amount) -->
<table border="2">
	<thead>
		<th>Product Name</th>
		<th>Cost</th>
		<th>Product Description</th>
		<th>Quantity</th>
		<th>Amount</th>
	</thead>
	<tbody>
		<c:forEach var = "tempPro" items="${productDetails}" varStatus="status">
		<tr>
			<td>${tempPro.productName}</td>
			<td>${tempPro.cost}</td>
			<td>${tempPro.productDescription}</td>
			<td>${kitDetails[status.index].quantity}</td>
			<td>${kitDetails[status.index].amount}</td>
		</tr>
		</c:forEach>
	</tbody>
</table>

<button type="submit"> Place Order </button>
</form>


	<jsp:include page="footer.jsp"/>
</body>
</html>