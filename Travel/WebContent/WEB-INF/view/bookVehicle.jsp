<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>${error}</h1>
<div align="center"><b><i>FIND YOUR ROUTE HERE</i></b></div>
<table align="center" bgcolor="cyan" border="5">
<tr><th>Route Id</th><th>Source</th><th>Destination</th><th>Travel Duration</th></tr>
<c:forEach var="id" items="${routeList}">
<tr><td>${id.routeID}</td>
<td>${id.source}</td>

<td>${id.destination}</td>

<td>${id.travelDuration}</td>

</tr>

</c:forEach>
</table><br /><br />
<div align="center"><b><i>Find Your cab ID here</i></b></div>
<table border="2" align="center" bgcolor="cyan">
	<tr>
		<th>Vehicle ID</th>
		<th>Vehicle Type</th>
	</tr>

	<c:forEach var="id" items="${freevehicles.vehicleList}">
		<tr>
			<td>${id.vehicleID}</td>
			<td>${id.name}</td>



		</tr>

	</c:forEach>
</table><br /><br />
<div align="center"><b><i>BOOK YOUR VEHICLE</i></b></div>
<form:form method="post" action="bookVehicle.html"
	modelAttribute="bookVehicle">
<table align="center" bgcolor="cyan" border="5">
	<tr><td>Boarding point</td><td><form:select path="boardingPoint" items="${boardingPoints}">
	</form:select></td>
</tr>
	<tr><td>Drop point</td><td><form:select path="dropPoint" items="${dropPoints}">
	</form:select></td>
</tr>
	<tr><td>Journey Date(DD-MMM-YYYY)</td><td><form:input path="journeyDate" /></td>
</tr>
	<tr><td>Choose Vehicle</td><td><form:select path="vehicleID" items="${vehicleIDs}">
	</form:select></td>
</tr>
</table>
<center>
	<input type="submit" value="GetFare" /></center>
</form:form>



</body>

</html>