<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student Form</title>

<style type="text/css">
	.error{	
		color: red;
	}
</style>
</head>
<body>

<form:form action="processForm" modelAttribute="student">

Name: <form:input path="name"/>
<form:errors path="name" cssClass="error"/>

<br><br>

phone: <form:input path="phone"/>
<form:errors path="phone" cssClass="error"/>

<br><br>

age: <form:input path="age"/>
<form:errors path="age" cssClass="error"/>

<br><br>

country: 
<form:select path="country">
<form:options items="${student.countryOptions}"/>
</form:select>

<%-- 
<form:select path="country">
	<form:option value="India">India</form:option>
	<form:option value="USA">USA</form:option>
	<form:option value="China">China</form:option>
</form:select> 
--%>

<br><br>

<form:radiobutton path="gender" value="Male"/>Male
<form:radiobutton path="gender" value="Female"/>Female
<form:errors path="gender" cssClass="error"/>

<br><br>

<form:checkbox path="progLanguages" value="Java"/>Java
<form:checkbox path="progLanguages" value="Python"/>Python
<form:checkbox path="progLanguages" value="C#"/>C#
<form:checkbox path="progLanguages" value="JavaScript"/>JavaScript

<br><br>
<input type="submit" value="Submit Data" />

</form:form>

</body>
</html>