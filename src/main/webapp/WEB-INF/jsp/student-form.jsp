<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<!DOCTYPE html>
<html>
	<head>
		<title>Student Registration Form</title>
	</head>
	<body>
		<i>Fill out form. Asterisk (*) means required</i>
		<form:form action="processForm" modelAttribute="studentObject" >
		First Name: <form:input path="firstName"/>
		<br><br>
		Last Name (*): <form:input path="lastName" />
		<form:errors path="lastName" cssClass="error" />
		<br><br>
		Attendance (*): <form:input path="attendance" />
		<form:errors path="attendance" cssClass="error" />
		<br><br>
		PIN (*): <form:input path="postalCode" />
		<form:errors path="postalCode" cssClass="error" />
		<br><br>
		Course Code: <form:input path="courseCode" />
		<form:errors path="courseCode" cssClass="error" />
		<br><br>
		<form:select path="country">
			<form:options items="${theCountryOptions}" />
		</form:select>
		<br><br>
			<form:radiobuttons path="favLang" items="${theLanguageOptions}" />
		<br><br>
			<form:checkboxes path="opSystems" items="${theOSOptions}" />
		<br><br>
		<input type="submit" value="Submit" />
		</form:form>
	</body>
</html>