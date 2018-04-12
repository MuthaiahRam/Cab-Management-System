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
<CENTER><h2>ALLOT DRIVER</h2></CENTER>
<form:form action="allotDriverAction.html" modelAttribute="modifyBean" method="post" target="action">
<table border="5" align="center" bgcolor="cyan"  border="5">
<tr><td>Boarding Point :</td><td> ${modifyBean.boardingPoint} </td></tr>
<tr><td>Drop Point :</td><td>${modifyBean.dropPoint}</td></tr>
<tr><td>Booking date :</td><td>${bookingDate}</td></tr>
<tr><td>Reservation ID : </td><td><form:input   path="reservationID"  value="${modifyBean.reservationID}"/></td></tr>
<tr><td>Vehicle ID: </td><td>${modifyBean.vehicleID}</td></tr>
<tr><td>Journey Date: </td><td>${journeyDate}</td></tr>
<tr><td>Driver ID</td><td><form:select path="driverID" items="${driverIds}"/></td></tr>

</table>
<center>
<input type="Submit" value="Allot"></center>
</form:form>

</body>
</html>