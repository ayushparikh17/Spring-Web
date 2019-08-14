<%@ page language="java" isELIgnored="false" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<f:form action="../updateuser" enctype="multipart/form-data" modelAttribute="userById">
FirstName:<f:input path="firstName"/>
<br>
LastName:<f:input path="lastName"/>
<br>
Gender:<f:radiobutton path="gender" value="Male"/>Male
		<f:radiobutton path="gender" value="Female"/>Female
				<f:errors cssClass="error" path="gender"></f:errors>
		<br>
		Hobby:<f:checkbox path="hobby" value="Swimming"/>Swimming
		<f:checkbox path="hobby" value="Singing"/>Singing
		<f:checkbox path="hobby" value="Reading"/>Reading
				<f:errors cssClass="error" path="hobby"></f:errors>
		<br>
		City:<f:select path="city">
				<f:option value=" ">Select City</f:option>
				<f:option value="Ahmedabad">Ahmedabad</f:option>
				<f:option value="Rajkot">Rajkot</f:option>
				<f:option value="Baroda">Baroda</f:option>
				</f:select>
				<f:errors cssClass="error" path="city"></f:errors>
		<br>
File: <input type="file" name="file" multiple>
<br>
<f:hidden path="userId"/>
<br>
<input type="submit" value="Update">
</f:form>
</body>
</html>