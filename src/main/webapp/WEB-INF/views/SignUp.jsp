<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
.error{
	color: red;

}
</style>
</head>
<body>
	<f:form action="userdata" commandName="user" method="post" enctype="multipart/form-data">
		Firstname:<f:input path="firstName"/><f:errors cssClass="error" path="firstName"></f:errors>
		<br>
		Lastname:<f:input path="lastName"/><f:errors cssClass="error" path="lastName"></f:errors>
		<br>
		Gender:<input type="radio" name="gender" value="Male">Male
				<input type="radio" name="gender" value="Female">Female
				<f:errors cssClass="error" path="gender"></f:errors>
		<br>
		Hobby:<input type="checkbox" name="hobby" value="Swimming">Swimming
		<input type="checkbox" name="hobby" value="Singing">Singing
		<input type="checkbox" name="hobby" value="Reading">Reading
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
		<f:errors cssClass="error" path="file"></f:errors>
		<br>
		<input type="submit" value="SignUp">
	</f:form>
</body>
</html>