<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<title>Student Confirmation</title>
	</head>
	<body>
		The student is confirmed: <b>${studentObject.firstName} ${studentObject.lastName}</b>
		<br><br>
		Attendance: ${studentObject.attendance}
		<br><br>
		PIN: ${studentObject.postalCode}
		<br><br>
		Course Code: ${studentObject.courseCode}
		<br><br>
		Country: <b>${studentObject.country}</b>
		<br><br>
		Favorite Language: <b>${studentObject.favLang}</b>
		<br><br>
		Operating Systems:
		<ul>
			<c:forEach var="tmp" items="${studentObject.opSystems}">
				<li>${tmp}</li>
			</c:forEach>
		</ul>
	</body>
</html>