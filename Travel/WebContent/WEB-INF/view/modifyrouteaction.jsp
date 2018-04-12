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
<CENTER><h2>MODIFY ROUTE</h2></CENTER>
<form:form action="modifyrouteaction.html" modelAttribute="modifyBean" method="post" target="action">
<table align="center" bgcolor="cyan"  border="5">
<tr><td>RouteID:</td><td> <form:input path="routeID" value="${modifyBean.routeID}" readonly="true"/></td></tr>
<tr><td>Destination :</td><td> <form:input path="destination" value="${modifyBean.destination}"/></td>
<td><form:errors path="destination" cssClass="error" /></td></tr>
<tr><td>Source :</td><td><form:input path="source" value="${modifyBean.source}"/></td>
<td><form:errors path="source" cssClass="error" /></td></tr>
<tr><td>Distance : </td><td><form:input path="distance" value="${modifyBean.distance}"/></td>
<td><form:errors path="distance" cssClass="error" /></td></tr>
<tr><td>Travel Duration : </td><td><form:input path="travelDuration" value="${modifyBean.travelDuration}"/></td>
<td><form:errors path="travelDuration" cssClass="error" /></td></tr>


</table>
<center>
<input type="Submit" value="Modify"></center>
</form:form>
</body>
</html>