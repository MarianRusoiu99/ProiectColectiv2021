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
<!--<jsp:forward page="/Login.jsp"></jsp:forward>-->
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
  <li style="border-bottom: 1px solid #555;"><form action="<%=request.getContextPath()%>/upperInfo" method="post"><button type="submit" name="button" value="profil">Profil</button></form></li>
  <li style="border-bottom: 1px solid #555;"><form action="<%=request.getContextPath()%>/upperInfo" method="post"><button type="submit" name="button" value="taskuri">Taskuri</button></form></li>
  <li style="border-bottom: 1px solid #555;"><a href="echipa.jsp">Echipa</a></li>
  <li style="border-bottom: 1px solid #555;"><a href="task_suplim.jsp">Taskuri suplimentare</a></li>
  <li style="border-bottom: 1px solid #555;"><a href="tasks_management.jsp">Tasks management</a></li>
  <li style="border-bottom: 1px solid #555;"><form action="<%=request.getContextPath()%>/upperInfo" method="post"><button type="submit" name="button" value="employees_management">Employees management</button></form></li>
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


<table style="width: 110%">	
		
<!--  PRIMA COLOANA -->	

<td style="width:45%">	
 <div align="center">
  <h1>Add Employee</h1>
  
<!--  CHOOSE A FILE -->	


<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>

<main class="main_full">
	<div class="container">
		<div class="panel">
			<div class="button_outer">
				<div class="btn_upload">
					Profile photo: 
					<input type="file" id="upload_file" name="">
				</div>
				<div class="processing_bar"></div>
				<div class="success_box"></div>
			</div>
		</div>
		<div class="error_msg"></div>
		<div class="uploaded_file_view" id="uploaded_view">
			<button class="file_remove">x</button>
		</div>
	</div>
</main>

<!--  PANA AICI  -->


  <form action="<%= request.getContextPath() %>/addEmployee" method="post">
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
     <td><input type="date" class="fadeIn second" name="birthDate"></td>
    </tr>
    <tr>
     <td>Gender</td>
     <td><input type="radio" name="sex" value="M" required>Male
         <input type="radio" name="sex" value="F" required>Female
         <input type="radio" name="sex" value="O" required>Other
     </td>
    </tr>
    <tr>
     <td>Job</td>
     <td><input type="text" name="job" /></td>
    </tr>
    <tr>
     <td>Skills</td>
     <td><input type="text" name="skills" /></td>
    </tr>
    <tr>
     <td>Email</td>
     <td><input type="text" name="email" /></td>
    </tr>
    <tr>
     <td>Phone</td>
     <td><input type="text" name="phone" /></td>
    </tr>
   </table>
   <input type="submit" value="Add employee" />
  </form>
 </div>
</td>
 
<!-- A DOUA COLOANA -->
<td>

 <div align="center">
  <h1>Update Employee</h1>
  
  
  <!--  CHOOSE A FILE -->	
 
<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
<main class="main_full">
	<div class="container">
		<div class="panel">
			<div class="button_outer">
				<div class="btn_upload">
					Profile photo: 
					<input type="file" id="upload_file" name="">
				</div>
				<div class="processing_bar"></div>
				<div class="success_box"></div>
			</div>
		</div>
		<div class="error_msg"></div>
		<div class="uploaded_file_view" id="uploaded_view">
			<button class="file_remove">x</button>
		</div>
	</div>
</main>

<!--  PANA AICI  -->


  <form action="<%= request.getContextPath() %>/editEmployee" method="post">
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
     <td><input type="date" class="fadeIn second" name="birthDate"></td>
    </tr>
    <tr>
     <td>Gender</td>
     <td><input type="radio" name="sex" value="M" required>Male
         <input type="radio" name="sex" value="F" required>Female
         <input type="radio" name="sex" value="O" required>Other
     </td>
    </tr>
    <tr>
     <td>Job</td>
     <td><input type="text" name="job" /></td>
    </tr>
    <tr>
     <td>Skills</td>
     <td><input type="text" name="skills" /></td>
    </tr>
    <tr>
     <td>Email</td>
     <td><input type="text" name="email" /></td>
    </tr>
    <tr>
     <td>Phone</td>
     <td><input type="text" name="phone" /></td>
    </tr>
   </table>
   <input type="submit" value="Update employee" />
  </form>
 </div>
 </td>
</table> 
 
 <!--  ---------------------------------------------------  -->
 
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