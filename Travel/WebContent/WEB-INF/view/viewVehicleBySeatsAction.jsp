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
<CENTER><h2>VIEW VEHICLE BY SEATS</h2></CENTER>
<table align="center" bgcolor="cyan"   border="5">
<tr><th>Vehicle Name</th><th>Type</th><th>Fare/KM</th></tr>
<c:forEach var="seats"  items="${seats.vehicleList}">
<tr><td>${seats.name}</td>
<td>${seats.type}</td>
<td>${seats.farePerKM}</td>
</tr>

</c:forEach>
</table>
</body>
</html>