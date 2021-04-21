<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="CSS/registerform.css" rel="stylesheet" id="bootstrap-css">
</head>
<body>
<!--
 <div align="center">
  <h1>Employee Register Form</h1>
  <form action="<%= request.getContextPath() %>/register" method="post">
   <table style="with: 80%">
    <tr>
     <td>Last Name</td>
     <td><input type="text" name="lastName" /></td>
    </tr>
    <tr>
     <td>First Name</td>
     <td><input type="text" name="firstName" /></td>
    </tr>
    <tr>
     <td>Birth Date</td>
     <td><input type="text" name="birthDate" /></td>
    </tr>
    <tr>
     <td>Sex</td>
     <td><input type="text" name="sex" /></td>
    </tr>
    <tr>
     <td>Phone Number</td>
     <td><input type="text" name="phone" /></td>
    </tr>
    <tr>
     <td>Email</td>
     <td><input type="text" name="email" /></td>
    </tr>
    <tr>
     <td>Company Name</td>
     <td><input type="text" name="company" /></td>
    </tr>
    <tr>
     <td>Password</td>
     <td><input type="password" name="password" /></td>
    </tr>
   </table>
   <input type="submit" value="Submit" />
  </form>
 </div>
--> 
 
<div style="font-family: Verdana, sans-serif; font-size: 20px; text-shadow: 1px 1px 1px #d9d8d8; margin-left: 25px; margin-top: 25px;"><b>
TheTaskDispatcherApp
</b></div>
 
 <div style="margin-top: 50px;" align="center" class="wrapper fadeInDown">
  <div id="formContent">
    <!-- Tabs Titles -->
 
    <!-- Icon -->
    <div class="fadeIn first">
      <h1>Register Form</h1>
    </div>
    <!-- Login Form -->
    <form action="<%= request.getContextPath() %>/register" method="post">
    <table style="with: 80%">
    <tr>
      <td style="text-align:right;padding-right:10px;">Last Name</td>
      <td><input type="text" class="fadeIn second" name="lastName"></td>
    </tr>
    <tr>
     <td style="text-align:right;padding-right:10px;">First Name</td>
     <td><input type="text" class="fadeIn second" name="firstName" /></td>
    </tr>
    <tr>
     <td style="text-align:right;padding-right:10px;">Birth Date</td>
     <td><input type="date" class="fadeIn second" name="birthDate"></td>
    </tr>
    <tr>
     <td style="text-align:right;padding-right:10px;">Gender</td>
     <td><input type="radio" name="sex" value="M" required>Male
         <input type="radio" name="sex" value="F" required>Female
         <input type="radio" name="sex" value="O" required>Other
     </td>
    </tr>
    <tr>
     <td style="text-align:right;padding-right:10px;">Phone Number</td>
     <td><input type="text" class="fadeIn second" name="phone" /></td>
    </tr>
    <tr>
     <td style="text-align:right;padding-right:10px;">Email</td>
     <td><input type="text" class="fadeIn second" name="email" /></td>
    </tr>
    <tr>
     <td style="text-align:right;padding-right:10px;">Company Name</td>
     <td><input type="text" class="fadeIn second" name="company" /></td>
    </tr>
    <tr>
      <td style="text-align:right;padding-right:10px;">Password</td>  
      <td><input type="password" class="fadeIn second" name="password"></td>
    </tr>
    </table>
      <input type="submit" class="fadeIn third" value="Submit">
    </form>
  <p style="color:black; text-align:left; margin-left: 20px; margin-bottom: 30px; margin-top: 0px;">Already have an account? <a href="Login.jsp">Login here</a>.</p>
  </div>
</div>
 
</body>
</html>