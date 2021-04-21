<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
        pageEncoding="ISO-8859-1"%>
 
<!DOCTYPE html>
<html>
<head>
<link href="CSS/loginform.css" rel="stylesheet" id="bootstrap-css">
</head>
<!------ Include the above in your HEAD tag ---------->
<body>
 
<div style="font-family: Verdana, sans-serif; font-size: 20px; text-shadow: 1px 1px 1px #d9d8d8; margin-left: 25px; margin-top: 25px;"><b>
TheTaskDispatcherApp
</b></div>
 
<div style="background-color: #1fc8db; background-image: linear-gradient(to bottom, rgba(245, 246, 252, 0.52), rgba(117, 19, 93, 0.73)); color: white; height: 400px; opacity: 0.98; margin-top: 50px; margin-bottom: 50px; margin-left: 0px; margin-right: 0px; font-family: calibri; width: 100%;">
<img src="poze/home2.jpg" align="right" height="400">
<p style="color:white; font-size: 40px;">	Nu ai cont? <a href="Register.jsp">Register here</a>.</p>
</div>
 
<div align="center" class="wrapper fadeInDown">
  <div id="formContent">
    <!-- Tabs Titles -->
 
    <!-- Icon -->
    <div class="fadeIn first">
      <h1>Login Form</h1>
    </div>
 
    <!-- Login Form -->
    <form action="<%=request.getContextPath()%>/login" method="post">
      <input type="text" class="fadeIn second" name="email" placeholder="email">
      <input type="password" class="fadeIn third" name="password" placeholder="password">
      <input type="submit" class="fadeIn fourth" value="Submit">
    </form>
 
    <!-- Remind Passowrd -->
    <div id="formFooter">
      <a class="underlineHover" href="#">Forgot Password?</a>
    </div>
 
  </div>
</div>
</body>
</html>
