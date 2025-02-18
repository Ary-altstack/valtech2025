<%@page import="dao.Employee"%>
<%@page import="dao.EmployeeDAO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>



Search By:
<form action="employees" method="GET">
    <select name="searchOption" id="searchOption">
        <option value="select" selected>--Select--</option>
        <option value="name">Name</option>
        <option value="salary">Salary (>=)</option>
        <option value="level">Level</option>
        <option value="age">Age</option>
        <option value="exp">Experience</option>
    </select>
    
    <input type = "text" name = "search_value" value=""/>
    <input type="submit" value="Search">
</form>
    

	<%
		String sortOrder = (String) request.getAttribute("sortOrder");
		String newSortOrder = "ascending".equals(sortOrder) ? "descending": "ascending";
	%>
	
	
	
<table>
<tr>
	<th><a href = "employees?sortOrder=<%=newSortOrder%>&sortBy=byId">Id </a></th>
	<th><a href = "employees?sortOrder=<%=newSortOrder%>&sortBy=byName ">Name </a></th>
	<th><a href = "employees?sortOrder=<%=newSortOrder%>&sortBy=byAge">Age</a></th>
	<th><a href = "employees?sortOrder=<%=newSortOrder%>&sortBy=byGender">Gender</a></th>
	<th><a href = "employees?sortOrder=<%=newSortOrder%>&sortBy=bySalary">Salary</a></th>
	<th><a href = "employees?sortOrder=<%=newSortOrder%>&sortBy=byExperience">Experience </a></th>
	<th><a href = "employees?sortOrder=<%=newSortOrder%>&sortBy=byLevel">Level</a></th>
	<th> Actions</th>
</tr>
<c:forEach items="${emps}" var="e">
	<tr>
		<td>${e.id}</td>
		<td>${e.name}</td>
		<td>${e.age}</td>
		<td>${e.gender}</td>
		<td>${e.salary}</td>
		<td>${e.exp}</td>
		<td>${e.level}</td>
		<td>
	<a href ="employees?operation=Update&id=${e.id}">Update</a>
	<a href ="employees?operation=Delete&id=${e.id}">Delete</a>
	
	    </td>
	</tr>
</c:forEach>
<tr> 
	<td colspan="7">
		<a href="employees?operation=new"> New Employee </a>
	</td>
</table>
<hr> </hr>
<table>
<tr>
	<th>Id</th>
	<th>Name</th>
	<th>Age</th>
	<th>Gender</th>
	<th>Salary</th>
	<th>Experience</th>
	<th>Level</th>
	
</tr>

<% 
	List<Employee> emps = (List<Employee>) request.getAttribute("emps");
	for(Employee e : emps){
	
%>

	<tr>
		<td> 
			<%= e.getId() %>
		</td>
	
	<td> 
			<%= e.getName() %>
		</td>
		<td> 
			<%= e.getAge() %>
		</td>
		<td> 
			<%= e.getGender() %>
		</td>
		<td> 
			<%= e.getSalary() %>
		</td>
		<td> 
			<%= e.getExp() %>
		</td>
		<td> 
			<%= e.getLevel() %>
		</td>
	</tr>

<%} %>

</table>

</body>
</html>