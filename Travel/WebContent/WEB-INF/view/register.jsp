<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form:form action="register.html" modelAttribute="register" method="post" target="login" bgcolor="cyan">
<table bgcolor="cyan" align="center"  border="5">
<tr><td></td><td><strong>REGISTER</strong></td></tr>
<tr><td>FirstName :</td><td><form:input path="firstName"/></td>
<td><form:errors path="firstName" cssClass="error" /></td></tr>
<tr><td>LastName</td><td> <form:input path="lastName"/></td>
<td><form:errors path="lastName" cssClass="error" /></td></tr>
<tr><td>DateOfBirth : </td><td><form:input path="dateOfBirth"/></td>
<td><form:errors path="dateOfBirth" cssClass="error" /></td></tr>
<tr><td>Gender : </td><td><form:radiobutton path="gender" value="Male"/>Male 
<form:radiobutton path="gender" value="Female"/>Female </td></tr>
<tr><td>Street : </td><td><form:input path="street"/></td>
<td><form:errors path="street" cssClass="error" /></td></tr>
<tr><td>Location : </td><td><form:input path="location"/></td>
<td><form:errors path="location" cssClass="error" /></td></tr>
<tr><td>City: </td><td><form:input path="city"/></td>
<td><form:errors path="city" cssClass="error" /></td></tr>
<tr><td>State : </td><td><form:input path="state"/></td>
<td><form:errors path="state" cssClass="error" /></td></tr>
<tr><td>Pincode : </td><td><form:input path="pincode"/></td>
<td><form:errors path="pincode" cssClass="error" /></td></tr>
<tr><td>MobileNo: </td><td><form:input path="mobileNo"/></td>
<td><form:errors path="mobileNo" cssClass="error" /></td></tr>
<tr><td>EmailID : </td><td><form:input path="emailID"/>
<td><form:errors path="emailID" cssClass="error" /></td></td></tr>
<tr><td>Password : </td><td><form:password path="password"/></td>
<td><form:errors path="password" cssClass="error" /></td></tr>
<tr><td>ConfirmPassword : </td><td><form:password path="confirmPassword"/></td>
<td><form:errors path="confirmPassword" cssClass="error" /></td></tr>
</table>
<center><input type="Submit" value="Register"></center>
</form:form>
</body>
</html>