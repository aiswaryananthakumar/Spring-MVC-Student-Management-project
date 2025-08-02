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

<h2>Submitted Student Details:</h2>

<h3>Id: ${student.id}</h3>
<h3>Name: ${student.name}</h3>
<h3>Email: ${student.email}</h3>
<h3>Department: ${student.dept}</h3>
<h3>Gender: ${student.gender}</h3>
<h3>Phone: ${student.phone}</h3>
<h3>Address: ${student.address}</h3>
<h3>Date of Birth: ${student.dob}</h3>
<h3>Blood Group: ${student.bloodGroup}</h3>
<h3>Nationality: ${student.nationality}</h3>

</body>
</html>