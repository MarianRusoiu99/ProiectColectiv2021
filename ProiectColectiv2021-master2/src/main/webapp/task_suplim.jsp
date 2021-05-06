<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="CSS/navbar.css" rel="stylesheet" id="bootstrap-css">
<link href="CSS/content.css" rel="stylesheet" id="bootstrap-css">
<link href="CSS/footer.css" rel="stylesheet" id="bootstrap-css">

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
  <li style="border-bottom: 1px solid #555;"><a id="firstnavbar" href="profile.jsp">Profil</a></li>
  <li style="border-bottom: 1px solid #555;"><a href="taskuri.jsp">Taskuri</a></li>
  <li style="border-bottom: 1px solid #555;"><a href="echipa.jsp">Echipa</a></li>
  <li style="border-bottom: 1px solid #555;"><a class="active" href="#task_suplim">Taskuri suplimentare</a></li>
  <li style="border-bottom: 1px solid #555;"><a href="tasks_management.jsp">Tasks management</a></li>
  <li style="border-bottom: 1px solid #555;"><a href="employees_management.jsp">Employees management</a></li>
  <li style="border-bottom: 1px solid #555;"><a href="teams_management.jsp">Teams management</a></li>
  <li style="border-bottom: 1px solid #555;"><a href="organigrama.jsp">Organigrama</a></li>
  <li style="border-bottom: 1px solid #555;"><a href="date_de_contact.jsp">Date de contact</a></li>
  <li style="border-bottom: none;"><a id="lastnavbar" href="login.jsp">Log Out</a></li>
</ul>
</div>
<!--  
<div style="background-color: white; /* For browsers that do not support gradients */ opacity:0.98; width:50%; padding:40px; margin-right:auto;margin-left: auto; margin-bottom:100px; font-family:calibri;">
-->

<div class="content" align="center" style="min-height: 350px;">
		<h1>pagina TASKURI SUPLIMENTARE</h1>
		Welcome <%=request.getAttribute("id2") %>
		<a href="login.jsp">Log out</a>
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