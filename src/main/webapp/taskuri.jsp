<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
		<!-- <h1>pagina TASKURI USER</h1>
		Welcome <%=request.getAttribute("id2") %>
		<a href="login.jsp">Log out</a> -->
		
		
<!-- TABEL -->

<form action="<%= request.getContextPath() %>/userTask" method="post">
<h1> Active tasks </h1>

<div align="left">
<h2>Individual tasks:</h2> 
</div>

<table id="t01" align="center" style="width: 100%">
  <tr>
    <th> Task Name </th>
    <th> Description </th> 
    <th> Technologies </th>
    <th> Deadline </th>
    <th> Type </th>
    <th> Contact </th>
  </tr>
  <tbody>
         <!--   for (Todo todo: todos) {  -->
         <c:forEach var="task" items="${taskList}">
         
            <tr>
               <td>
                  <c:out value="${task.numeTask}" />
               </td>
               <td>
                  <c:out value="${task.descriereTask}" />
               </td>
               <td>
                  <c:out value="${task.tehnologiiTask}" />
               </td>
               <td>
                  <c:out value="${task.deadlineTask}" />
               </td>               
               <td>
                  <c:out value="${task.tipTask}" />
               </td>
               <td>
                  <c:out value="${task.contactTask}" />
               </td>
               <td><a href="DoneServlet?id=<c:out value='${task.idTask}' />&amp;type=<c:out value='${task.tipTask}' />">Done</a></td>
             </tr>
          </c:forEach>
          <!-- } -->
  </tbody>
</table>

<div align="left">
<h2>Team tasks:</h2> 
</div>
 
<table id="t01" align="center" style="width: 100%">
  <tr>
    <th> Task Name </th>
    <th> Description </th> 
    <th> Technologies </th>
    <th> Deadline </th>
    <th> Type </th>
    <th> Contact </th>
  </tr>
  <tbody>
         <!--   for (Todo todo: todos) {  -->
         <c:forEach var="task" items="${teamTask}">
         
            <tr>
               <td>
                  <c:out value="${task.numeTask}" />
               </td>
               <td>
                  <c:out value="${task.descriereTask}" />
               </td>
               <td>
                  <c:out value="${task.tehnologiiTask}" />
               </td>
               <td>
                  <c:out value="${task.deadlineTask}" />
               </td>
               <td>
                  <c:out value="${task.tipTask}" />
               </td>
               <td>
                  <c:out value="${task.contactTask}" />
               </td>               
               <td><a href="DoneServlet?id=<c:out value='${task.idTask}' />&amp;type=<c:out value='${task.tipTask}' />">Done</a></td>
             </tr>
          </c:forEach>
          <!-- } -->
  </tbody>
</table>

<div align="left">
<h2>Completed tasks:</h2> 
</div>
 
<table id="t01" align="center" style="width: 100%">
  <tr>
    <th> Task Name </th>
    <th> Description </th> 
    <th> Technologies </th>
    <th> Deadline </th>
    <th> Type </th>
    <th> Contact </th>
  </tr>
  <tbody>
         <!--   for (Todo todo: todos) {  -->
         <c:forEach var="task" items="${completeTask}">
         
            <tr>
               <td>
                  <c:out value="${task.numeTask}" />
               </td>
               <td>
                  <c:out value="${task.descriereTask}" />
               </td>
               <td>
                  <c:out value="${task.tehnologiiTask}" />
               </td>
               <td>
                  <c:out value="${task.deadlineTask}" />
               </td>
               <td>
                  <c:out value="${task.tipTask}" />
               </td>
               <td>
                  <c:out value="${task.contactTask}" />
               </td>               
               
             </tr>
          </c:forEach>
          <!-- } -->
  </tbody>
</table>

</div>
</form>




<!-- PANA AICI -->		
		
		
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
	<TD><A HREF = "mailto:task.dispatcher00@gmail.com" style="color:blue">task.dispatcher00@gmail.com</A>
</TABLE>
</div>

</body>
</html>