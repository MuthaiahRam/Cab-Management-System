<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
</head>
<body >
<h3>${error}</h3>
<br></br>
<form:form action="login.html" modelAttribute="credential" method="post" target="_top" >
<table align="center" bgcolor="cyan"   border="5">
<tr><td colspan="2" align="center"><strong>LOGIN</strong></td></tr>
<tr><td>UserName :</td><td> <form:input path="userID"/></td></tr>
<tr><td>Password :</td><td><form:password path="password"/></td></tr>
</table><br>
<center>
<input type="Submit" value="Login"></center>
<center><h2>New User? <a href="register.html" >Register here</a></h2></center>
</form:form>
</body>
</html>