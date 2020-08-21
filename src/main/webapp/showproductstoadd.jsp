<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="css/form_withTable.css">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="header.jsp"/>

<c:set var="tempUser" value="${UserDetails}"></c:set>
<div id="wrapper">
		<div id="header">
			<h2>Welcome ${tempUser.personName}. Start shopping!!!!</h2>
		</div>
	</div>
<form action="user?action=showkit" method="post">	
<c:set var="allproduct" value="${PRODUCT_LIST}"></c:set>
<input type="hidden" name = "custname" value ="${UserDetails.personName}" />
<input type="hidden" name = "custemail" value ="${UserDetails.email}" />
<input type="hidden" name = "custcontact" value ="${UserDetails.contactNumber}" />
<div id="container">
		<div id="content">
			<table border="2">
				<thead>
					<tr>
						<th>Product Name</th>
						<th>Cost</th>
						<th>Description</th>
						<th>Add to Cart</th>
					</tr>
				</thead>
				<tbody>
					
					<c:forEach var="tempProduct" items="${PRODUCT_LIST}">
						
						<tr >
							<td >${tempProduct.productName}</td>
							<td>${tempProduct.cost}</td>
							<td>${tempProduct.productDescription}</td>
							<td>
							<input type="number" name ="${tempProduct.id}" value="0" min="0"/>
							</td>
						</tr>
					</c:forEach>
					
					
				</tbody>
			</table>
			
			
		</div>
	</div>
<button type="submit" >save</button>
</form>

<jsp:include page="footer.jsp"/>
</body>
</html>