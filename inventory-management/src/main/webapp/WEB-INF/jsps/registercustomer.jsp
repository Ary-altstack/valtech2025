<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Customer Registration</title>
</head>
<body>

<form action="customer" method="post">
	<table>
	
		<tr> 
			<td> name </td>
			<td> <input name ="name"" id="name"/></td>
		</tr>
		<tr> 
			<td> age </td>
			<td> <input name ="age"" id="age"/></td>
		</tr>
		<tr> 
			<td> Address </td>
			<td> <input name ="address"" id="address"/></td>
		</tr>
		<tr> 
			<td> permanentAddress </td>
			<td> <input name ="permanentAddress"" id="permanentAddress"/></td>
		</tr>
		<tr>
			<td> <input name = "submit"  type ="submit" value="submit"/></td>
			<td> <input name = "cancel" type="submit" value="cancel"/></td>
		</tr>
		
	</table>
	
	


</form>

</body>
</html>