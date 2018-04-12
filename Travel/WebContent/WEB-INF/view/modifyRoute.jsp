`<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
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
<CENTER><h2>MODIFY ROUTE</h2></CENTER>
<form:form method="post" action="modifyRoute.html" modelAttribute="routeIds">
<table align="center" bgcolor="cyan"  border="5">
<tr><th>Route Id</th><th>Destination</th><th>Source</th><th>Distance</th><th>Travel Duration</th></tr>
<c:forEach var="id" varStatus="route" items="${routeIds.routeList}">
<tr><td><form:input type="hidden" path="routeList[${route.index}].routeID"/>${id.routeID}</td>
<td><form:input type="hidden" path="routeList[${route.index}].destination"/>${id.destination}</td>

<td><form:input type="hidden" path="routeList[${route.index}].source"/>${id.source}</td>

<td><form:input type="hidden" path="routeList[${route.index}].distance"/>${id.distance}</td>
<td><form:input type="hidden" path="routeList[${route.index}].travelDuration"/>${id.travelDuration}</td>
<td><form:radiobutton path="routeBean.routeID" value="${id.routeID}" /></td></tr>

</c:forEach>
</table>
<CENTER><input type="submit" value="Modify Route"/></CENTER>
</form:form>
</body>
</html>