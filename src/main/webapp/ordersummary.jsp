<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Corona Kit-Order Summary(user)</title>
<link rel="stylesheet" type="text/css" href="css/form_withTable.css">
</head>
<body>
<jsp:include page="header.jsp"/>


<%-- Required View Template --%>

<h2><b>Final Order Summary</b></h2>
<button id="addproduct" onclick="window.location.href='success.jsp';return false;">Order Confirm</button>

<form action="user?action=placeorder" method="post">
	<!-- request.setAttribute("orderSummery", odr);
		request.setAttribute("productDetails", filterProduct); -->
<!-- 			private CoronaKit coronaKit;
	private List<KitDetail> kitDetails; -->
<c:set var = "kitDetails" value="${orderSummery.kitDetails}"></c:set>
<c:set var = "coronaKit" value="${orderSummery.coronaKit}"></c:set>

<table border="2">
	<!-- <thead>
		<th>Name:</th>
		<th>Contact:</th>
		<th>Email:</th>
		<th>Address</th>
	</thead> -->
	<tbody>
		<tr>
			<th><label>Name:</label></th>
			<td>${coronaKit.personName}</td>
		</tr>
		<tr>
			<th><label>Contact:</label></th>
			<td>${coronaKit.contactNumber}</td>
			</tr>
			<tr>
			<th><label>Email:</label></th>
			<td>${coronaKit.email}</td>
			</tr>
			<tr>
			<th><label>Address:</label></th>
			<td>${coronaKit.deliveryAddress}</td>
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
		<tr>
		<td colspan="4" align="right">Total Amount</td>
		<td>${coronaKit.totalAmount}</td>
		</tr>
	</tbody>
</table>

<!-- <button type="submit">Order Confirm</button> -->
</form>


	<jsp:include page="footer.jsp"/>
</body>
</html>