<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Change Password</title>
</head>
<body>
<CENTER><h2>CANCEL BOOKING</h2></CENTER>
<form:form action="changepassword.html" modelAttribute="credentials" method="post" target="_top">
<table align="center" bgcolor="cyan"  border="5">

<tr><td>Old password:</td><td> <form:password path="password"/></td></tr>
<tr><td>New Password</td><td><form:password path="newPassword"/></td></tr>


</table>
<center>
<input type="Submit" value="Change Password"></center>

</form:form>
</body>
</html>