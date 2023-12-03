<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Success</title>
</head>
<body>
<h2>User saved successfully</h2>
<p>Name: ${savedUser.name}</p>
<p>Email: ${savedUser.email}</p>
<p>Age: ${savedUser.age}</p>
<p>Birthday: ${savedUser.birthday}</p>
<p>Role: ${savedUser.role}</p>
<p>Profile Image: <img alt="dog" src="<spring:url value='/resources/images/${savedUser.profileImage.originalFilename}'></spring:url>"></p>
<p><b>Address Info</b></p>
<p>Street: ${savedUser.addr.street}</p>
<p>State: ${savedUser.addr.state}</p>
<p>Zipcode: ${savedUser.addr.zipCode}</p>
</body>
</html>