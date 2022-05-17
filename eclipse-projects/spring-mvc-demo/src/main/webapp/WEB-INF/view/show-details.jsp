<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student Details</title>
</head>
<body>

<h2>Student Details</h2>
student name: ${student.name}
<br><br>
student phone No: ${student.phone}
<br><br>
student's age: ${student.age}
<br><br>
Country: ${student.country}
<br><br>
Gender: ${student.gender}
<br><br>
Programming Languages:
<ul>
	<c:forEach var="lang" items="${student.progLanguages}">
		<li>${lang}</li>
	</c:forEach>
</ul>

</body>
</html>