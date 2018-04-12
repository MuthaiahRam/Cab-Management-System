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
<CENTER><h2>ADD VEHICLE</h2></CENTER>
<form:form action="addVehicle.html" modelAttribute="addVehicle" method="post" target="action">
<table align="center" bgcolor="cyan"  border="5">
<tr><td>VehicleName :</td><td> <form:input path="name"/></td>
<td><form:errors path="name" cssClass="error" /></td></tr>
<tr><td>Vehicle Type :</td><td><form:input path="type"/></td>
<td><form:errors path="type" cssClass="error" /></td></tr>
<tr><td>Registration Number : </td><td><form:input path="registrationNumber"/></td>
<td><form:errors path="registrationNumber" cssClass="error" /></td></tr>
<tr><td>Seating Capacity: </td><td><form:input path="seatingCapacity"/></td>
<td><form:errors path="seatingCapacity" cssClass="error" /></td></tr>
<tr><td>Fare/KM </td><td><form:input path="farePerKM"/></td>
<td><form:errors path="farePerKM" cssClass="error" /></td></tr>

</table>
<center>
<input type="Submit" value="Add"></center>
</form:form>
</body>
</html>