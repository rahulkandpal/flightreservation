<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>
<form action="logincheck" method="POST">
<pre>
	
	<h2>User Login</h2>
	
	username : <input type="text" name="email"/>
	Password : <input type="password" name="password"/>
	<input type="submit" value="login"/>
	</pre>
</form>
	${msg }
</body>
</html>