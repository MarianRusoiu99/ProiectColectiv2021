<%@ page import="java.sql.*" %> 
<%
String name = request.getParameter("email").toString();
System.out.println(name);
String data ="";
try{
Class.forName("com.mysql.jdbc.Driver");
Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3307/task-manager", "root", "admin");
Statement st=con.createStatement();
ResultSet rs=st.executeQuery("select * from employee where email ='"+ name +"'");
int count=0;
while(rs.next())
{
count++;
}
if(count>0)
{
data="Email-ID already exists!";
}
else
{
//data="You can register now!!!!";
//data="";
}
out.println(data);
System.out.println(data);
}
catch (Exception e) {
System.out.println(e);
}
%>