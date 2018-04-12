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
<CENTER><h2>ADD DRIVER</h2></CENTER>
<form:form action="addDriver.html" modelAttribute="addDriver" method="post" target="action">
<table align="center" bgcolor="cyan"  border="5">
<tr><td>DriverName :</td><td> <form:input path="name"/></td>
<td><form:errors path="name" cssClass="error" /></td></tr>

<tr><td>Street : </td><td><form:input path="street"/></td>
<td><form:errors path="street" cssClass="error" /></td></tr>
<tr><td>Location : </td><td><form:input path="location"/></td>
<td><form:errors path="location" cssClass="error" /></td></tr>
<tr><td>City : </td><td><form:input path="city"/></td>
<td><form:errors path="city" cssClass="error" /></td></tr>
<tr><td>State : </td><td><form:input path="state"/></td>
<td><form:errors path="state" cssClass="error" /></td></tr>
<tr><td>Pin code : </td><td><form:input path="pincode"/></td>
<td><form:errors path="pincode" cssClass="error" /></td></tr>
<tr><td> Mobile No : </td><td><form:input path="mobileNo"/></td>
<td><form:errors path="mobileNo" cssClass="error" /></td></tr>
<tr><td>LicenseNumber : </td><td><form:input path="licenseNumber"/></td>
<td><form:errors path="licenseNumber" cssClass="error" /></td></tr>

</table>
<center>
<input type="Submit" value="Add"></center>

</form:form>
</body>
</html>

