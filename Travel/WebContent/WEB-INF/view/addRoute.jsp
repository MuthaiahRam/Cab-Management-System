<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<CENTER><h2>ADD ROUTE</h2></CENTER>
<form:form action="addRoute.html" modelAttribute="addRoute" method="post" target="action">
<table align="center" bgcolor="cyan"  border="5">
<tr><td>Source : </td><td><form:input path="source"/></td>
<td><form:errors path="source" cssClass="error" /></td></tr>
<tr><td>Destination:</td><td> <form:input path="destination"/></td>
<td><form:errors path="destination" cssClass="error" /></td></tr>
<tr><td>Distance(in Kms) :</td><td><form:input path="distance"/></td>
<td><form:errors path="distance" cssClass="error" /></td></tr>
<tr><td>TravelDuration(in hours) : </td><td><form:input path="travelDuration"/></td>
<td><form:errors path="travelDuration" cssClass="error" /></td></tr>

</table>
<center>
<input type="Submit" value="Add Route"></center>
</form:form>
</body>
</html>