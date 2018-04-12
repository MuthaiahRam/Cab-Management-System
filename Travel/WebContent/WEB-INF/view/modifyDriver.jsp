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
<CENTER><h2>MODIFY DRIVER</h2></CENTER>
<form:form method="post" action="modifyDriver.html" modelAttribute="driverIds">
<table align="center" bgcolor="cyan"  border="5">
<tr><th>Driver Id</th><th>Driver Name</th><th>Street</th><th>Location</th><th>City</th><th>State</th><th>Pin code</th><th>License Number</th><th>Mobile Number</th></tr>
<c:forEach var="id" varStatus="driver" items="${driverIds.driverList}">
<tr><td><form:input type="hidden" path="driverList[${driver.index}].driverID"/>${id.driverID}</td>
<td><form:input type="hidden" path="driverList[${driver.index}].name"/>${id.name}</td>

<td><form:input type="hidden" path="driverList[${driver.index}].street"/>${id.street}</td>
<td><form:input type="hidden" path="driverList[${driver.index}].location"/>${id.location}</td>
<td><form:input type="hidden" path="driverList[${driver.index}].city"/>${id.city}</td>
<td><form:input type="hidden" path="driverList[${driver.index}].state"/>${id.state}</td>
<td><form:input type="hidden" path="driverList[${driver.index}].pincode"/>${id.pincode} </td>
<td><form:input type="hidden" path="driverList[${driver.index}].licenseNumber"/>${id.licenseNumber}</td>
<td><form:input type="hidden" path="driverList[${driver.index}].mobileNo"/>${id.mobileNo}</td>
<td><form:radiobutton path="driverBean.driverID" value="${id.driverID}" /></td></tr>

</c:forEach>
</table>
<CENTER><input type="submit" value="Modify Driver"/></CENTER>
</form:form>

</body>
</html>