<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register Page</title>
</head>
<body>
<h3>Give your Registration Details</h3>
 <form:form action="InsertUser.obj" method="post" modelAttribute="reg">
            FirstName:<form:input path="firstName"/><form:errors path="firstName"/><br>
            LastName:<form:input path="lastName"/><br>
            UserName:<form:input path="uname"/><br>
            Password:<form:password path="pwd"/><br>
            Confirm Password:<<form:password path="confirmPassword"/><br>
            Gender:<form:radiobutton path="gender" value="M" label="Male"/>
            <form:radiobutton path="gender" value="F" label="Female"/><br>
            EmailId:<form:input path="email"/><form:errors path="email"/><br>
            SkillSet:<form:checkboxes items="${skillList}" path="skillSet"/><br>
            City:<form:select path="city">
            <form:option value="Select City"/>
            <form:options items="${cList}"/>
            </form:select>
            <form:errors path="city"/><br>
            <input type="submit" name="btnReg" value="Register"/>
    </form:form>
</body>
</html>