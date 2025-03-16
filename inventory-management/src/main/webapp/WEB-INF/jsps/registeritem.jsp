<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Item Registration </title>
</head>
<body>

<form action = "item"  method = "post">
	<table>
	<tr> 
			<td> id </td>
			<td> <input name ="id" id ="id" value="0"/></td>
		
		</tr>
		<tr> 
			<td> name </td>
			<td> <input name ="name" id ="name"/></td>
		
		</tr>
		<tr> 
			<td> description </td>
			<td> <input name ="description" id ="description"/></td>
		
		</tr>
		<tr> 
			<td> quantity </td>
			<td> <input name ="quantity" id ="quantity"/></td>
		
		</tr>
		<tr> 
			<td> reorderQuantity </td>
			<td> <input name ="reorderQuantity" id ="reorderQuantity"/></td>
		
		</tr>
		<tr> 
			<td> maxQuantity </td>
			<td> <input name ="maxQuantity" id ="maxQuantity"/></td>
		
		</tr>
		<tr>
			<td> <input name = "submit"  type ="submit" value="submit"/></td>
			<td> <input name = "cancel" type="submit" value="cancel"/></td>
		</tr>
	
	</table>
	
	
	
	
	

	</form>
</body>
</html>