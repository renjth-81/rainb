<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<!-- use meta tags "_csrf" and "_csrf_header" to add csrf token within HTTP header for ajax requests -->
<meta name="_csrf" content="${_csrf.token}" />
<!-- default header name is X-CSRF-TOKEN -->
<meta name="_csrf_header" content="${_csrf.headerName}" />
<script type="text/javascript" src="<%=request.getContextPath() %>/js/jquery-3.1.1.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/js/register.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/js/csrf.js"></script>
<title>register</title>
</head>
<body>
<input type="hidden" id="context_path" value="<%=request.getContextPath() %>" />
<!-- 	<form> -->
		username: <input type="text" name="username" id="username" /> <br> 
		password: <input type="password" name="password" id="password"/> <br> 
		<!-- for form submit, use hidden field with parameter name "_csrf " -->
<%-- 		<input type="hidden" name="_csrf" value="${_csrf.token}" /> --%>
		<button id="register_btn">sign up</button>
<!-- 	</form> -->
</body>
</html>