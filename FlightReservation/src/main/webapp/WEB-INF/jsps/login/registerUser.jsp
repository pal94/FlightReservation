<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register User</title>
</head>
<body>

<form action="registerUser", method="post">
<pre>
<h2>User Registration : </h2>
FirstName: <input type="text" name="firstName"/>
LastName: <input type="text" name="lastName"/>
UserName: <input type="text" name="email"/>
Password: <input type="password" name="password"/>
Confirm Password: <input type="password" name="confirmPassword"/>
<input type="submit" value="register"/>
</pre>
</form>


</body>
</html>