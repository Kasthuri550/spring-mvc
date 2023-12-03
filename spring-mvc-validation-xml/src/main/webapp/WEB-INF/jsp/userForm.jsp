<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    <%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Registration</title>
<style type="text/css">
.error
{
color:red;
}
</style>
</head>
<body>
<p>${name}</p>
<h2><spring:message code="userform.title"></spring:message></h2>
<form:form action="add" modelAttribute="newUser" enctype="multipart/form-data">
<form:errors path="*" cssClass="error"/>
<p><spring:message code="user.name"></spring:message><form:input path="name"/><form:errors path="name" cssClass="error"></form:errors></p>
<p><spring:message code="user.email"></spring:message><form:input path="email"/><form:errors path="email" cssClass="error"></form:errors></p>
<p>Age: <form:input path="age"/><form:errors path="age" cssClass="error"></form:errors></p>
<p>Birthday: <form:input path="birthday"/><form:errors path="birthday" cssClass="error"></form:errors></p>
<p>Role: <form:select path="role">
<form:option value="">Select role</form:option>
<form:options items="${roles}"/></form:select><form:errors path="role" cssClass="error"></form:errors></p>
<p>Profile Image: <form:input path="profileImage" type="file"/></p>
<p>Address Info: </p>
<p>Street: <form:input path="addr.street"/><form:errors path="addr.street" cssClass="error"></form:errors></p>
<p>State: <form:input path="addr.state"/><form:errors path="addr.state" cssClass="error"></form:errors></p>
<p>Zipcode: <form:input path="addr.zipCode"/><form:errors path="addr.zipCode" cssClass="error"></form:errors></p>
<input type="submit" value="Add">
</form:form>
</body>
</html>