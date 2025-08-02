<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student Details</title>
</head>
<body>

<form:form action="${pageContext.request.contextPath}/save" modelAttribute="student" method="post">

    <label>Id: </label>
    <form:input path="id" type="text"/><br>

    <label>Name: </label>
    <form:input path="name" type="text"/><br>

    <label>Email: </label>
    <form:input path="email" type="text"/><br>

    <label>Department: </label>
    <form:input path="dept" type="text"/><br>

    <label>Gender: </label>
    <form:input path="gender" type="text"/><br>

    <label>Phone: </label>
    <form:input path="phone" type="text"/><br>

    <label>Address: </label>
    <form:input path="address" type="text"/><br>

    <label>Date of Birth: </label>
    <form:input path="dob" type="date"/><br>

    <label>Blood Group: </label>
    <form:input path="bloodGroup" type="text"/><br>

    <label>Nationality: </label>
    <form:input path="nationality" type="text"/><br>

    <input type="submit" value="Save Student"/>
</form:form>

<a href="${pageContext.request.contextPath}/">Back to Student List</a>


</body>
</html>