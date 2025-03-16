<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table>
		
		<tr> <td> Id </td>
			<td> Name </td>
			<td> Description </td>
			<td> Quantity</td>
			<td> Reorder-Quantity </td>
			<td> Max-Quantity </td>
		</tr>
	
	
	
	
	<c:forEach items="${item}" var="i"> 
	<tr> 
	<td>${i.id}</td>
	<td>${i.name}</td>
	<td>${i.description}</td>
	<td>${i.quantity}</td>
	<td>${i.reorderQuantity}</td>
	<td>${i.maxQuantity}</td>
	</tr>	
	</c:forEach>
	
	
	</table>
	


</body>
</html>