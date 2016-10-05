<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>user home</title>
</head>
<body>
	<form action="${pageContext.request.contextPath}/j_spring_security_logout" method="post">
		<input type="hidden" name="_csrf" value="${_csrf.token}" />
		<input type="submit" name="submit" value="logout" />
	</form>
	<br>
	<br>
	<p>USER HOME</p>
</body>
</html>