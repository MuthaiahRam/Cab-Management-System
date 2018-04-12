<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
    
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@page import="java.text.DateFormat"%>
<%@page import="java.text.SimpleDateFormat"%><html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<CENTER><h2>BOOK VEHICLE</h2></CENTER>
<form:form method="post" action="bookVehicleAction.html" modelAttribute="bookVehicle">
<table align="center" bgcolor="cyan"  border="5">
<tr><td>Boarding Point:</td><td><form:input  path="boardingPoint" value="${reservation.boardingPoint}"/></td></tr>
<tr><td>Drop Point:</td><td><form:input   path="dropPoint" value="${reservation.dropPoint}"/></td></tr>

<tr><td>Journey Date:</td><td><form:input   path="journeyDate" value="${journeydate}"/></td></tr>
 
<tr><td>Total Fare:</td><td><form:input   path="totalFare"  value="${reservation.totalFare}"/></td></tr>
<tr><td>Vehicle ID:</td><td><form:input path="vehicleID"  value="${reservation.vehicleID}"/></td></tr>
<tr><td>UserID:</td><td><form:input  path="userID"  value="${loginName}"/></td></tr>
<hr>
<h3>Please Make Payment to confirm Booking</h3>
<tr><td>CardNumber</td><td><form:input  path="cardNumber"/></td></tr>
<tr><td></td><td><input type="submit" value="Book Vehicle"/></td></tr>

</form:form>
</body>
</html>