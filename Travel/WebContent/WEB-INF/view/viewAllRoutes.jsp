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
<CENTER><h2>VIEW ALL ROUTES</h2></CENTER>
<form:form method="post" action="viewAllRoutes.html" modelAttribute="RouteIds">
<table align="center" bgcolor="cyan"   border="5"> 
<tr><th>Route Id</th><th>Source</th><th>Destination</th><th>Travel Duration</th></tr>
<c:forEach var="id" varStatus="route" items="${RouteIds.routeList}">
<tr><td>${id.routeID}</td>
<td>${id.source}</td>

<td>${id.destination}</td>

<td>${id.travelDuration}</td>

</tr>

</c:forEach>
</table>

</form:form>
</body>
</html>