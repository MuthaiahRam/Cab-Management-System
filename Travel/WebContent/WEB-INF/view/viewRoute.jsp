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
<CENTER><h2>VIEW ROUTE</h2></CENTER>
<form:form method="post" action="viewRoute.html" modelAttribute="viewRoute">
<table align="center" bgcolor="cyan"  border="5">
<tr><td>SELECT ROUTE ID:<form:select path="routeID" items="${routeIDs}">
</form:select></td></tr>
</table>
<center><input type="submit" value="view"/></center>
</form:form>
</table>
</body>
</html>