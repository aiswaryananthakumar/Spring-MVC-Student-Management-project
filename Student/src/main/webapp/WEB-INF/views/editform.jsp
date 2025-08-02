<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Student Details</title>
</head>
<body>

<h2>Edit Student</h2>

<form:form action="${pageContext.request.contextPath}/update" modelAttribute="student" method="post">

    ID: <form:input path="id" /><br/>
    Name: <form:input path="name"/><br/>
    Email: <form:input path="email"/><br/>
    Dept: <form:input path="dept"/><br/>
    Gender: <form:input path="gender"/><br/>
    Phone: <form:input path="phone"/><br/>
    Address: <form:input path="address"/><br/>
    DOB: <form:input path="dob"/><br/>
    Blood Group: <form:input path="bloodGroup"/><br/>
    Nationality: <form:input path="nationality"/><br/>

    <input type="submit" value="Update Student"/>
</form:form>

</body>
</html>