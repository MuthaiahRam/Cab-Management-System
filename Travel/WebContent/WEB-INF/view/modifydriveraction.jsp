<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
    
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form:form action="modifydriveraction.html" modelAttribute="modifyBean" method="post" target="action">
<table border="5" align="center">
<tr><td>DriverID :</td><td> <form:input path="driverID" value="${modifyBean.driverID}" readonly="true"/></td></tr>
<tr><td>DriverName :</td><td> <form:input path="name" value="${modifyBean.name}" readonly="true"/></td></tr>
<tr><td>Street :</td><td><form:input path="street" value="${modifyBean.street}"/></td>
<td><form:errors path="street" cssClass="error" /></tr>
<tr><td>Location : </td><td><form:input path="location" value="${modifyBean.location}"/></td>
<td><form:errors path="location" cssClass="error" /></td></tr>
<tr><td>City: </td><td><form:input path="city" value="${modifyBean.city}"/></td>
<td><form:errors path="city" cssClass="error" /></td></tr>
<tr><td>State: </td><td><form:input path="state" value="${modifyBean.state}"/></td>
<td><form:errors path="state" cssClass="error" /></td></tr>
<tr><td>Pincode: </td><td><form:input path="pincode" value="${modifyBean.pincode}"/></td>
<td><form:errors path="pincode" cssClass="error" /></td>
<tr><td>license Number: </td><td><form:input path="licenseNumber" value="${modifyBean.licenseNumber}"/></td>
<td><form:errors path="licenseNumber" cssClass="error" /></td>
</tr>
<tr><td>Mobile Number: </td><td><form:input path="mobileNo" value="${modifyBean.mobileNo}"/></td>
<td><form:errors path="mobileNo" cssClass="error" /></td>
</tr>


</table>
<center>
<input type="Submit" value="Modify"></center>
</form:form>
</body>
</html>