<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
</head>
<body>
<h3>Welcome :${compNameObj }</h3>
<hr color="red" size="3"/>
<form:form action="ValidateUser.obj" modelAttribute="log">
UserName:<form:input  path="username"/><br>
<form:errors path="username"/>
Password:<form:input  path="password"/><br>
<form:errors path="password"/><br>
<input type="submit" name="btnLogin" value="Login"/><br>
</form:form>
</body>
</html>