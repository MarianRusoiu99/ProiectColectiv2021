<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="CSS/navbar.css" rel="stylesheet" id="bootstrap-css">
<link href="CSS/content.css" rel="stylesheet" id="bootstrap-css">
<link href="CSS/footer.css" rel="stylesheet" id="bootstrap-css">
<style>
img {
  border-radius: 50%;
}
</style>
<title>Insert title here</title>
</head>
<% //In case, if Admin session is not set, redirect to Login page
if((request.getSession(false).getAttribute("id1")== null))
{
%>
<jsp:forward page="/Login.jsp"></jsp:forward>
<%} %>



<body style="position:relative; margin: 0;">

<div class="applogo"><b>
TheTaskDispatcherApp
</b></div>

<table style="table-layout: fixed; width: 66%; margin-top:200px; margin-left:250px; margin-right:250px; line-height: 20px;">
<tr>
	<td width="50%">Nume: <%=request.getAttribute("nume") %></td>
	<td></td>
</tr>
<tr>
	<td>Job: <%=request.getAttribute("job") %></td>
	<td></td>
</tr>
<tr>
	<td>Tip user: <%=request.getAttribute("tip_user") %></td>
	<td align="right"><b>Numele firmei: <%=request.getAttribute("companie") %> </b></td>
</tr>
</table>

<div style="width: 100%; margin-top:20px;">
<div id="formContent" style="float:left; left:250px; position:relative;">
<ul>
  <li style="border-bottom: 1px solid #555;"><form action="<%=request.getContextPath()%>/Profile" method="post"><button type="submit" name="button" value="profil">Profil</button></form></li>
  <li style="border-bottom: 1px solid #555;"><form action="<%=request.getContextPath()%>/userTask" method="post"><button type="submit" name="button" value="taskuri">Taskuri</button></form></li>
  <li style="border-bottom: 1px solid #555;"><form action="<%=request.getContextPath()%>/echipa" method="post"><button type="submit" name="button" value="echipa">Echipa</button></form></li>
  <li style="border-bottom: 1px solid #555;"><form action="<%=request.getContextPath()%>/task" method="post"><button type="submit" name="button" value="task_suplim">Taskuri suplimentare</button></form></li>
  <li style="border-bottom: 1px solid #555;"><form action="<%=request.getContextPath()%>/upperInfo" method="post"><button type="submit" name="button" value="task_manag">Tasks management</button></form></li>
  <li style="border-bottom: 1px solid #555;"><form action="<%=request.getContextPath()%>/upperInfo" method="post"><button type="submit" name="button" value="employees_management">Employees management</button></form></li>
  <li style="border-bottom: 1px solid #555;"><form action="<%=request.getContextPath()%>/upperInfo" method="post"><button type="submit" name="button" value="teams_manag">Teams management</button></form></li>
  <li style="border-bottom: 1px solid #555;"><form action="<%=request.getContextPath()%>/upperInfo" method="post"><button type="submit" name="button" value="date_contact">Date de contact</button></form></li>
  <li style="border-bottom: none;"><form action="login.jsp" method="post"><button type="submit" name="button" value="profil">Log Out</button></form></li>
</ul>
</div>
<!--  
<div style="background-color: white; /* For browsers that do not support gradients */ opacity:0.98; width:50%; padding:40px; margin-right:auto;margin-left: auto; margin-bottom:100px; font-family:calibri;">
-->

<div class="content" align="center" style="min-height: 350px;">
		<!-- <h1>You have logged in successfully</h1>
		Welcome <%=request.getAttribute("id2") %>
		<a href="login.jsp">Log out</a>  -->
		
		
		
		
<form action="<%=request.getContextPath() %>/changePassword" method="post">

<table>


	<td>
   

<%
if((request.getAttribute("sex")=="F"))
{
%>
<img src="poze/woman-profile-cartoon_18591-58477.jpg" alt="Avatar1" align="left" style="width:250px">
<%} else {%>
<img src="poze/man-profile-cartoon_18591-58482.jpg" alt="Avatar2" align="left" style="width:250px">
<%} %>


   </td>


	<td>

   <table style="with: 80%">
   
   
  <tr></tr>
  <tr></tr>
    <tr>
     <td align="left"><b>Last Name: </b><%=request.getAttribute("last_name")%></td>
    </tr>
    <tr>
     <td align="left"><b>First Name: </b><%=request.getAttribute("first_name")%></td>
    </tr>
    <tr>
     <td align="left"><b>Job: </b><%=request.getAttribute("job2")%></td>
    </tr>
    <tr>
     <td align="left"><b>Sex: </b><%=request.getAttribute("sex")%></td>
    </tr>
    <tr>
     <td align="left"><b>Birth Date: </b><%=request.getAttribute("birth_date")%></td>
    </tr>
    <tr>
     <td align="left"><b>Email: </b><%=request.getAttribute("email")%></td>
    </tr>
    <tr>
     <td align="left"><b>Phone: </b><%=request.getAttribute("phone")%></td>
    </tr>
   </table>
   <p>
   <div id="formFooter" align="left">
      <a class="underlineHover" href="changePassword.jsp">Change your Password</a>
    </div>
 	</td>   
</table>
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
	<TD align="center"><b><font size="+2">Have a question?</font></b>
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
	<TD><A HREF = "mailto:indreivalentinaandreea@gmail.com" style="color:blue">indreivalentinaandreea@gmail.com</A>
</TABLE>
</div>

</body>
</html>