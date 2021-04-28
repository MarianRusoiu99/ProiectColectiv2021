<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="CSS/registerform.css" rel="stylesheet" id="bootstrap-css">
<link href="CSS/content.css" rel="stylesheet" id="bootstrap-css">
<link href="CSS/footer.css" rel="stylesheet" id="bootstrap-css">
</head>
<body style="position:relative; margin: 0;">

<div class="applogo"><b>
TheTaskDispatcherApp
</b></div>

 <div style="margin-top: 50px;" align="center" class="wrapper fadeInDown">
  <div id="formContent">

    <div class="fadeIn first">
      <h1>Register Form</h1>
    </div>

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
     <td style="text-align:right;padding-right:10px;">Your job</td>
     <td><input type="text" class="fadeIn second" name="job" /></td>
    </tr>
    <tr>
      <td style="text-align:right;padding-right:10px;">Password</td>  
      <td><input type="password" class="fadeIn second" name="password"></td>
    </tr>
    </table>
      <input type="submit" class="fadeIn third" value="Submit">
    </form>
  <p style="color:black; text-align:left; margin-left: 20px; margin-bottom: 30px; margin-top: 0px;">Already have an account? <a href="login.jsp">Login here</a>.</p>
  </div>
</div>

<div class="footer">
<TABLE align="center"> 
<TR> 
	<TD>
	<TD>
	<TD>
	<TD align="right"><b><font size="+2">Have a question?</font></b>
<TR> 
	<TD>
	<TD>
	<TD>
	<TD> Everywhere, but especially, close to you.
<TR> 
	<TD>
	<TD>
	<TD>
	<TD>You want to be a part of the team? Go ahead, contact us!
<TR> 
	<TD>
	<TD>
	<TD>
	<TD><A HREF = "mailto:indreivalentinaandreea@gmail.com" style="color:black">indreivalentinaandreea@gmail.com</A>
</TABLE>
</div>
</body>
</html>