<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<CENTER><h2>VIEW VEHICLE</h2></CENTER>
<table align="center" bgcolor="cyan"  border="5">
<tr><th>VehicleId</th><th>VehicleName</th><th>Type</th><th>seating capacity</th><th>Registration Number</th><th>Fare/KM</th></tr>
<tr>
<td>${vehicle.vehicleID}</td>
<td>${vehicle.name}</td>
<td>${vehicle.type}</td>
<td>${vehicle.seatingCapacity}</td>
<td>${vehicle.registrationNumber}</td>
<td>${vehicle.farePerKM}</td>
<tr>
</table>
<center><a href="viewVehicle.html">View Another Vehicle</a></center>
</body>
</html>