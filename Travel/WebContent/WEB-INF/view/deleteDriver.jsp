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
<CENTER><h2>DELETE DRIVER</h2></CENTER>
<form:form method="post" action="deleteDriver.html" modelAttribute="DriverIds">
<table align="center" bgcolor="cyan"  border="5">
<tr><th>Driver Id</th><th>Driver Name</th><th>Address</th><th>License Number</th><th>Mobile Number</th></tr>
<c:forEach var="id" varStatus="driver" items="${DriverIds.driverList}">
<tr><td><form:input type="hidden" path="driverList[${driver.index}].driverID"/>${id.driverID}</td>
<td><form:input type="hidden" path="driverList[${driver.index}].name"/>${id.name}</td>

<td><form:input type="hidden" path="driverList[${driver.index}].street"/>${id.street} ,
<form:input type="hidden" path="driverList[${driver.index}].location"/>${id.location} ,
<form:input type="hidden" path="driverList[${driver.index}].city"/>${id.city} ,
<form:input type="hidden" path="driverList[${driver.index}].pincode"/>${id.pincode} </td>
<td><form:input type="hidden" path="driverList[${driver.index}].licenseNumber"/>${id.licenseNumber}</td>
<td><form:input type="hidden" path="driverList[${driver.index}].mobileNo"/>${id.mobileNo}</td>
<td><form:checkbox path="driverList[${driver.index}].checked" value="${id.driverID}" /></td></tr>

</c:forEach>
</table>
<CENTER><input type="submit" value="Delete Driver(s)"/></CENTER>
</form:form>
</body>
</html>