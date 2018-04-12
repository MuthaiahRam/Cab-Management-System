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
<CENTER><h2>CANCEL BOOKING</h2></CENTER>
<form:form method="post" action="cancelBooking.html" modelAttribute="reservationIDs">
<table border="5" bgcolor="cyan">
<tr><th>ReservationID</th><th>BoardingPoint</th><th>DropPoint</th><th>JourneyDate</th><th>BookingDate</th><th>VehicleID</th><th>DriverID</th><th>BookingStatus</th></tr>
<%ArrayList<String> journeydates=(ArrayList<String>)request.getAttribute("journeydates"); %>
<%ArrayList<String> bookingdates=(ArrayList<String>)request.getAttribute("bookingdates"); %>
<%int i=0; %>
<c:forEach var="id" items="${reservationIDs.reservationList}">
<tr><td>${id.reservationID}</td>
<td>${id.boardingPoint}</td>
<td>${id.dropPoint}</td>
<td><%=journeydates.get(i) %></td>
<td><%=bookingdates.get(i) %></td><%i++; %>
<td>${id.vehicleID} </td>
<td>${id.driverID}</td>
<td>${id.bookingStatus}</td>
<td><form:radiobutton path="reservationBean.reservationID" value="${id.reservationID}" /></td></tr>

</c:forEach>

</table>
<center>
<input type="submit" value="cancel Booking"/></center>
</form:form>
</body>
</html>