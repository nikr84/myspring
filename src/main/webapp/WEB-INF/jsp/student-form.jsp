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