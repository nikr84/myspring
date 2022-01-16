<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<body>
<h2>yoyoyoy</h2>
<p>
	User: <security:authentication property="principal.username" />
	<br>
	Role(s): <security:authentication property="principal.authorities" />
</p>
	<security:authorize access="hasRole('MANAGER')">
		<hr>
		<p>
			<a href="${pageContext.request.contextPath}/home/leaders">Leaders only update</a>
		</p>
	</security:authorize>
<hr>
<a href="hello/showForm">Hello World Form</a>
<br><br>
<a href="student/showForm">Student Form</a>
<br><br>
<form:form action="${pageContext.request.contextPath}/logout" method="POST">
	<input type="submit" value="Logout" />
</form:form>
</body>
</html>