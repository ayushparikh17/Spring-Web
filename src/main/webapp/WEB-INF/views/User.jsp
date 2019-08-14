<%@ page language="java" isELIgnored="false" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table border="1">
	<tr>
	<td>UserId</td>
	<td>FirstName</td>
	<td>LastName</td>
	<td>Gender</td>
	<td>Hobby</td>
	<td>City</td>
	<td>File_Path</td>
	<td>Action</td>
	</tr>
	<c:forEach items="${users}" var="users">
	<tr>
	<td>${users.userId}</td>
	<td>${users.firstName}</td>
	<td>${users.lastName}</td>
	<td>${users.gender}</td>
	<td>${users.hobby}</td>
	<td>${users.city}</td>
	<td>${users.filePath}</td>
	<td><a href="edituser/${users.userId}">Edit</a>|<a href="deleteuser/${users.userId}">Delete</a>
	</tr>
	
	
	</c:forEach>
</table>

</body>
</html>