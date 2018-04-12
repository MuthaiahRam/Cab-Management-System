<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
    
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@page import="java.util.ArrayList"%><html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<CENTER><h2>BOOKING DETAILS</h2></CENTER>
<form:form method="post" action="modifyDriver.html" modelAttribute="driverIds">
<table align="center" bgcolor="cyan"  border="5" >
<tr><th>ReservationID</th><th>BoardingPoint</th><th>DropPoint</th><th>JourneyDate</th><th>BookingDate</th><th>VehicleID</th><th>DriverID</th><th>BookingStatus</th></tr>
<%ArrayList<String> journeydates=(ArrayList<String>)request.getAttribute("journeydates"); %>
<%ArrayList<String> bookingdates=(ArrayList<String>)request.getAttribute("bookingdates"); %>
<%int i=0; %>
<c:forEach var="reservation"  items="${reservations.reservationList}" >
<tr><td>${reservation.reservationID}</td>
<td>${reservation.boardingPoint}</td>

<td>${reservation.dropPoint}</td>
<td><%=journeydates.get(i) %></td>
<td><%=bookingdates.get(i) %></td><%i++; %>
<td>${reservation.vehicleID}</td>
<td>${reservation.driverID} </td>
<td>${reservation.bookingStatus}</td>


</c:forEach>

</table>

</form:form>
</body>
</html>