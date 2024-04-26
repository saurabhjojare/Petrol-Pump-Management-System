<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Sign Up</title>
<link rel="stylesheet" type="text/css" href="css/registrationStyle.css">
</head>
<body>
<div class="container">
        <h2>Sign Up</h2>
        <form action="registration" method="post">
            <label for="firstname">First Name</label>
            <input type="text" id="firstname" name="firstname" required>

            <label for="lastname">Last Name</label>
            <input type="text" id="lastname" name="lastname" required>

            <label for="email">Email</label>
            <input type="email" id="email" name="email" required>

            <label for="phone">Phone</label>
            <input type="tel" id="phone" name="phone" required>

            <label for="password">Password</label>
            <input type="password" id="password" name="password" required>

            <label for="repassword">Re-enter Password</label>
            <input type="password" id="repassword" name="repassword" required>

            <input type="submit" value="Sign Up">
        </form>
        <div class="signup-link">
            Have an account? <a href="login.jsp">Log In</a>
        </div>
    </div>
</body>
</html>
