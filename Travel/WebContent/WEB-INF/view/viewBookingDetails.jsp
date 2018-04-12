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
<CENTER><h2>BOOKING DETAILS</h2></CENTER>
<div align="center"><b><i>LIST OF AVAILABLE ROUTES</i></b></div>
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
<form:form method="post" action="viewBookingDetails.html" modelAttribute="viewBookingDetails">
<table align="center" bgcolor="cyan"   border="5">
<tr><td>Select Source Point</td><td><form:select path="source" items="${source}" multiple="false"/></td></tr>
<tr><td>Select Destination Point</td><td><form:select path="destination" items="${destination}" multiple="false"/></td></tr>
<tr><td rowspan="2">Journey date(DD-MMM-YYYY)<br>(MM/DD/YYYY)</td><td rowspan="2"><form:input path="journeyDate"/></td></tr>
<tr></tr>

</table>
<center>
<input type="submit" value="view"/></center>
</form:form>
</body>
</html>