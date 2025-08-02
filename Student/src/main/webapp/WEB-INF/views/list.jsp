<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student List</title>

<style>
    body {
        text-align: center;
        font-family: Arial, sans-serif;
    }
    table {
        margin: auto;
        border-collapse: collapse;
        width: 90%;
    }
    table, th, td {
        border: 1px solid black;
        padding: 8px;
    }
    a.add-link {
        font-weight: bold;
        display: inline-block;
        margin-bottom: 20px;
        text-decoration: none;
        font-size: 18px;
        color: blue;
    }
    h2 {
        margin-top: 20px;
    }
</style>

</head>
<body>

 <h2>All Registered Students</h2>
 <a class="add-link" href="${pageContext.request.contextPath}/add">Add New Student</a><br/><br/>
    <table border="1">
        <tr>
            <th>ID</th><th>Name</th><th>Email</th><th>Dept</th>
            <th>Gender</th><th>Phone</th><th>Address</th>
            <th>DOB</th><th>Blood Group</th><th>Nationality</th>
        </tr>
        <c:forEach var="student" items="${students}">
            <tr>
                <td>${student.id}</td>
                <td>${student.name}</td>
                <td>${student.email}</td>
                <td>${student.dept}</td>
                <td>${student.gender}</td>
                <td>${student.phone}</td>
                <td>${student.address}</td>
                <td>${student.dob}</td>
                <td>${student.bloodGroup}</td>
                <td>${student.nationality}</td>
                <td><a href="edit/${student.id}">Edit</a>
                <a href="delete/${student.id}" onclick="return confirm('Are you sure?')">Delete</a>
                </td>      
            </tr>
        </c:forEach>
         </table>

</body>
</html>