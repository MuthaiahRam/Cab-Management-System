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
<CENTER><h2>VIEW VEHICLE</h2></CENTER>
<form:form method="post" action="viewVehicle.html" modelAttribute="viewVehicle">
<table align="center" bgcolor="cyan"  border="5">
<tr><td>SELECT VEHICLE ID:<form:select path="vehicleID" items="${vehicleIDs}" multiple="false">
</form:select></td></tr>
</table>
<CENTER><input type="submit" value="view"/></CENTER>
</form:form>
</body>
</html>