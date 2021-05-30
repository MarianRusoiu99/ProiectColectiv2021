<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="CSS/registerform.css" rel="stylesheet" id="bootstrap-css">
<link href="CSS/content.css" rel="stylesheet" id="bootstrap-css">
<link href="CSS/footer.css" rel="stylesheet" id="bootstrap-css">

<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>

<script>
function checkPass()
{
    var pass1 = document.getElementById('password');
    var pass2 = document.getElementById('password2');
    var message = document.getElementById('error-nwl');
    var goodColor = "#66cc66";
    var badColor = "#ff6666";
 	
    if(pass1.value.length > 5)
    {
        pass1.style.backgroundColor = goodColor;
        message.style.color = goodColor;
        message.innerHTML = "character number ok!"
    }
    else
    {
        pass1.style.backgroundColor = badColor;
        message.style.color = badColor;
        message.innerHTML = " you have to enter at least 6 digit!"
        return;
    }
  
    if(pass1.value == pass2.value)
    {
        pass2.style.backgroundColor = goodColor;
        message.style.color = goodColor;
        message.innerHTML = "ok!"
    }
	else
    {
        pass2.style.backgroundColor = badColor;
        message.style.color = badColor;
        message.innerHTML = " These passwords don't match"
    }
}
		
</script>


</head>


<body style="position:relative; margin: 0;">

<div class="applogo"><b>
TheTaskDispatcherApp
</b></div>

<table style="table-layout: fixed; width: 66%; margin-top:200px; margin-left:250px; margin-right:250px; line-height: 20px;">
<tr>
	<td width="50%">Name: <%=request.getAttribute("nume") %></td>
	<td></td>
</tr>
<tr>
	<td>Job: <%=request.getAttribute("job") %></td>
	<td></td>
</tr>
<tr>
	<td>User type: <%=request.getAttribute("tip_user") %></td>
	<td align="right"><b>Company name: <%=request.getAttribute("companie") %> </b></td>
</tr>
</table>

<div style="width: 100%; margin-top:20px;">
<div id="formContent" style="float:left; left:250px; position:relative;">
<ul>
  <li style="border-bottom: 1px solid #555;"><form action="<%=request.getContextPath()%>/Profile" method="post"><button type="submit" name="button" value="profil">Profile</button></form></li>
  <li style="border-bottom: 1px solid #555;"><form action="<%=request.getContextPath()%>/userTask" method="post"><button type="submit" name="button" value="taskuri">Tasks</button></form></li>
  <li style="border-bottom: 1px solid #555;"><form action="<%=request.getContextPath()%>/echipa" method="post"><button type="submit" name="button" value="echipa">Team</button></form></li>
  <li style="border-bottom: 1px solid #555;"><form action="<%=request.getContextPath()%>/task" method="post"><button type="submit" name="button" value="task_suplim">Extra tasks</button></form></li>
 <c:set var = "userType" scope = "session" value = '${requestScope["tip_user"]}'/>
  <c:choose>
    <c:when test= "${userType == 'employee'}" >    
  <li style="border-bottom: none;"><form action="login.jsp" method="post"><button type="submit" name="button" value="profil">Log Out</button></form></li>  
    </c:when>
<c:otherwise>
    <li style="border-bottom: 1px solid #555;"><form action="<%=request.getContextPath()%>/upperInfo" method="post"><button type="submit" name="button" value="task_manag">Tasks management</button></form></li>
  <li style="border-bottom: 1px solid #555;"><form action="<%=request.getContextPath()%>/upperInfo" method="post"><button type="submit" name="button" value="employees_management">Employees management</button></form></li>
  <li style="border-bottom: 1px solid #555;"><form action="<%=request.getContextPath()%>/upperInfo" method="post"><button type="submit" name="button" value="teams_manag">Teams management</button></form></li>
  <li style="border-bottom: none;"><form action="login.jsp" method="post"><button type="submit" name="button" value="profil">Log Out</button></form></li>  
 
</c:otherwise>
</c:choose>
</ul>
</div>

<!--  
<div style="background-color: white; /* For browsers that do not support gradients */ opacity:0.98; width:50%; padding:40px; margin-right:auto;margin-left: auto; margin-bottom:100px; font-family:calibri;">
-->

<div class="content" align="center" style="min-height: 350px;">
		<!-- <h1>You have logged in successfully</h1>
		Welcome <%=request.getAttribute("id2") %>
		<a href="login.jsp">Log out</a>  -->
		
		
<div align="left">
  <h1>Change your password</h1>		
		
<form action="<%=request.getContextPath() %>/changePassword" method="post" align="center">

  
<table align="left">
    
    <tr>
      <td style="text-align:left;padding-right:10px;">Password</td>  
      <td><input type="password" name="password" id="password" onkeyup="checkPass(); return false;"></td>
    </tr>
    <tr>
      <td style="text-align:left;padding-right:10px;">Confirm password</td>  
      <td><input type="password" name="password2" id="password2" onkeyup="checkPass(); return false;">
      <div id="error-nwl"></div></td>
    </tr>
    </table>
	<form action="<%=request.getContextPath()%>/Profile" method="post">
    	<input type="submit" value="Change password" />
	</form>
  </form>
</div>
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
	<TD><A HREF = "mailto:task.dispatcher00@gmail.com" style="color:blue">task.dispatcher00@gmail.com</A>
</TABLE>
</div>
</body>
</html>