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
<CENTER><h2>DELETE VEHICLE</h2></CENTER>
<form:form method="post" action="deleteVehicle.html" modelAttribute="VehicleIds">
<table align="center" bgcolor="cyan"  border="5">
<tr><th>Vehicle Id</th><th>Vehicle Name</th><th>Type</th><th>Registration Number</th><th>Seating Capacity</th><th>Fare/KM</th></tr>
<c:forEach var="id" varStatus="vehicle" items="${VehicleIds.vehicleList}">
<tr><td><form:input type="hidden" path="vehicleList[${vehicle.index}].vehicleID"/>${id.vehicleID}</td>
<td><form:input type="hidden" path="vehicleList[${vehicle.index}].name"/>${id.name}</td>
<td><form:input type="hidden" path="vehicleList[${vehicle.index}].type"/>${id.type}</td>
<td><form:input type="hidden" path="vehicleList[${vehicle.index}].registrationNumber"/>${id.registrationNumber}</td>
<td><form:input type="hidden" path="vehicleList[${vehicle.index}].seatingCapacity"/>${id.seatingCapacity}</td>
<td><form:input type="hidden" path="vehicleList[${vehicle.index}].farePerKM"/>${id.farePerKM}</td>
<td><form:checkbox path="vehicleList[${vehicle.index}].checked" value="${id.vehicleID}" /></td></tr>

</c:forEach>
</table>
<CENTER><input type="submit" value="Delete Vehicle(s)"/></CENTER>
</form:form>
</body>
</html>