<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<CENTER><h2>VIEW ROUTE</h2></CENTER>
<table align="center" bgcolor="cyan"  border="5">
<tr><th>RouteId</th><th>Destination</th><th>Source</th><th>Distance</th><th>Travel Duration<tr>
<td>${route.routeID}</td>
<td>${route.source}</td>
<td>${route.destination}</td>
<td>${route.distance}</td>
<td>${route.travelDuration}</td>

<tr>
</table>
<center><a href="viewRoute.html">View Another Route</a></center>
</body>
</html>