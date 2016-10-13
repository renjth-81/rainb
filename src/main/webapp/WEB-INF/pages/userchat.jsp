<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script type="text/javascript" src="<%=request.getContextPath() %>/js/jquery-3.1.1.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/js/home.js"></script>
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/stomp.js/2.3.3/stomp.min.js"></script>
<title>Insert title here</title>
</head>
<body>
	<p id="msg"></p>
	<br>
	<br>
	<button id="ws_connect_btn">connect</button>
	<br>
	<br>
	<textarea rows="1" cols="5" id="chat_msg"></textarea>
	<button id="send_btn">send</button>
	<br>
	<br>
	<div id="chat_div">
	</div>
</body>
<script>

</script>
</html>