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

function allLetter(inputtxt)
{ 
	//var firstname = document.getElementById('firstName');
	var message2 = document.getElementById('error-firstName');
	var goodColor = "#66cc66";
    var badColor = "#ff6666";
	//var letters = /^[A-Za-z]+$/;
	//var letters = /^[A-Z]'?[- a-zA-Z]+$/;
	var letters = /^(?![ .]+$)[a-zA-Z .]*$/;
	if(inputtxt.value.match(letters))
	{
		/*
		//message2.style.color = goodColor;
		//message2.innerHTML = ""
		if(inputtxt.value.match(""))
			{
			message2.style.color = badColor;
			//message2.innerHTML = "Please enter your first name."
			return false
			}
		else {
			message2.innerHTML = ""
			return true;
		}
		*/
		message2.innerHTML = "";
		return true;
	}
	else
	{
		message2.style.color = badColor;
		message2.innerHTML = "Please input alphabet characters only"
		return false;
	}
}

function allLetter2(inputtxt)
{ 
	//var lastname = document.getElementById('lastName');
	var message3 = document.getElementById('error-lastName');
	var goodColor = "#66cc66";
    var badColor = "#ff6666";
	//var letters = /^[A-Za-z]+$/;
	var letters = /^(?![ .]+$)[a-zA-Z .]*$/;
	if(inputtxt.value.match(letters))
	{
		/*
		//message3.style.color = goodColor;
		if(inputtxt.value.match(""))
			{
			message3.style.color = badColor;
			//message3.innerHTML = "Please enter your last name."
			return false
			}
		else {
			message3.innerHTML = ""
			return true;
		}
		*/
		message3.innerHTML = "";
		return true;
	}
	else
	{
		message3.style.color = badColor;
		message3.innerHTML = "Please input alphabet characters only"
		return false;
	}
}

function phonenumber(inputtxt)
{
  var phoneno = /^\(?([0-9]{3})\)?[-. ]?([0-9]{3})[-. ]?([0-9]{4})$/;
  var message4 = document.getElementById('error-phone');
  var goodColor = "#66cc66";
  var badColor = "#ff6666";
  if(inputtxt.value.match(phoneno))
     {
	  // message4.style.color = goodColor;
	   message4.innerHTML = ""
	   return true;
	 }
   else
     {
	   message4.style.color = badColor;
	   message4.innerHTML = "Not a valid Phone Number";
	   return false;
     }
}



function checkEmail(){ 
	xmlHttp=GetXmlHttpObjectEmail()
	//var value = document.getElementById('email');
	var value = document.getElementById("email").value;
	var url="_checkajaxEmail.jsp";
	url=url+"?email="+value;
	xmlHttp.onreadystatechange=stateChangedEmail 
	//document.getElementById("raspuns").innerHTML = stateChanged();
	xmlHttp.open("GET",url,true)
	xmlHttp.send(null)
	//document.getElementById("raspuns").innerHTML = stateChanged();
	//document.getElementById("raspuns").innerHTML = document.getElementById("mydiv").innerText;
	//document.getElementById("raspuns").innerHTML = div;
	//var div = document.getElementById("raspuns").innerHTML;
	if(document.getElementById("mydiv").innerText == "Email-ID already exists!")
		return false;
	else return true;
}
	
function stateChangedEmail(){ 
	if(xmlHttp.readyState==4 || xmlHttp.readyState=="complete"){ 
	var showdata = xmlHttp.responseText; 
	document.getElementById("mydiv").innerHTML= showdata;
	//document.getElementById("raspuns").innerHTML = document.getElementById("mydiv").innerText;
	} 
}
	
function GetXmlHttpObjectEmail(){
	var xmlHttp=null;
	try{
	xmlHttp=new XMLHttpRequest();
	}
	catch (e) {
	try {
	xmlHttp=new ActiveXObject("Msxml2.XMLHTTP");
	}
	catch (e){
	xmlHttp=new ActiveXObject("Microsoft.XMLHTTP");
	}
	}
	return xmlHttp;
}

function checkCompany(){ 
	xmlHttp=GetXmlHttpObjectCompany()
	//var value = document.getElementById('email');
	var value = document.getElementById("company").value;
	var url="_checkajaxCompany.jsp";
	url=url+"?company="+value;
	xmlHttp.onreadystatechange=stateChangedCompany
	//document.getElementById("raspuns").innerHTML = stateChanged();
	xmlHttp.open("GET",url,true)
	xmlHttp.send(null)
	//document.getElementById("raspuns").innerHTML = stateChanged();
	//document.getElementById("raspuns").innerHTML = document.getElementById("mydiv").innerText;
	//document.getElementById("raspuns").innerHTML = div;
	//var div = document.getElementById("raspuns").innerHTML;
	if(document.getElementById("mydiv2").innerText == "Company already exists!")
		return false;
	else return true;
}
	
function stateChangedCompany(){ 
	if(xmlHttp.readyState==4 || xmlHttp.readyState=="complete"){ 
	var showdata = xmlHttp.responseText; 
	document.getElementById("mydiv2").innerHTML= showdata;
	//document.getElementById("raspuns").innerHTML = document.getElementById("mydiv").innerText;
	} 
}
	
function GetXmlHttpObjectCompany(){
	var xmlHttp=null;
	try{
	xmlHttp=new XMLHttpRequest();
	}
	catch (e) {
	try {
	xmlHttp=new ActiveXObject("Msxml2.XMLHTTP");
	}
	catch (e){
	xmlHttp=new ActiveXObject("Microsoft.XMLHTTP");
	}
	}
	return xmlHttp;
}

	
	var Days = [31,28,31,30,31,30,31,31,30,31,30,31];// index => month [0-11]
	$(document).ready(function(){
	    var option = '<option value="day">day</option>';
	    var selectedDay="day";
	    for (var i=1;i <= Days[0];i++){ //add option days
	        option += '<option value="'+ i + '">' + i + '</option>';
	    }
	    $('#day').append(option);
	    $('#day').val(selectedDay);

	    var option = '<option value="month">month</option>';
	    var selectedMon ="month";
	    for (var i=1;i <= 12;i++){
	        option += '<option value="'+ i + '">' + i + '</option>';
	    }
	    $('#month').append(option);
	    $('#month').val(selectedMon);

	    var option = '<option value="month">month</option>';
	    var selectedMon ="month";
	    for (var i=1;i <= 12;i++){
	        option += '<option value="'+ i + '">' + i + '</option>';
	    }
	    $('#month2').append(option);
	    $('#month2').val(selectedMon);
	  
	    var d = new Date();
	    var option = '<option value="year">year</option>';
	    selectedYear ="year";
	    for (var i=1930;i <= d.getFullYear();i++){// years start i
	        option += '<option value="'+ i + '">' + i + '</option>';
	    }
	    $('#year').append(option);
	    $('#year').val(selectedYear);
	});
	function isLeapYear(year) {
	    year = parseInt(year);
	    if (year % 4 != 0) {
		      return false;
		  } else if (year % 400 == 0) {
		      return true;
		  } else if (year % 100 == 0) {
		      return false;
		  } else {
		      return true;
		  }
	}

	function change_year(select)
	{
	    if( isLeapYear( $(select).val() ) )
		  {
			    Days[1] = 29;
			    
	    }
	    else {
	        Days[1] = 28;
	    }
	    if( $("#month").val() == 2)
			    {
				       var day = $('#day');
				       var val = $(day).val();
				       $(day).empty();
				       var option = '<option value="day">day</option>';
				       for (var i=1;i <= Days[1];i++){ //add option days
					         option += '<option value="'+ i + '">' + i + '</option>';
	             }
				       $(day).append(option);
				       if( val > Days[ month ] )
				       {
					          val = 1;
				       }
				       $(day).val(val);
			     }
	  }

	function change_month(select) {
	    var day = $('#day');
	    var val = $(day).val();
	    $(day).empty();
	    var option = '<option value="day">day</option>';
	    var month = parseInt( $(select).val() ) - 1;
	    for (var i=1;i <= Days[ month ];i++){ //add option days
	        option += '<option value="'+ i + '">' + i + '</option>';
	    }
	    $(day).append(option);
	    if( val > Days[ month ] )
	    {
	        val = 1;
	    }
	    $(day).val(val);
	}
	
	
	function checkforblank(inputday,inputmonth,inputyear) {
	    //var day = document.getElementById('dd');
	    //var month = document.getElementById('mm');
	    //var year = document.getElementById('yyyy');
	    //var invalid = location.value == "Please Select";
	    var day = "day";
	    var month = "month";
	    var year = "year";
	    var message5 = document.getElementById('error-birthday');
	    var goodColor = "#66cc66";
	    var badColor = "#ff6666";
	    //if(input=="day" || input=="month" || input=="year")
	    if(inputday.value.match(day) || inputmonth.value.match(month) || inputyear.value.match(year))
	     {
	    	 message5.style.color = badColor;
		  	 message5.innerHTML = "Please choose a date";
		  	 return false;
	  	 }
	     else
	       {
	    	 //message5.style.color = goodColor;
		  	 message5.innerHTML = ""
		  	 return true;
	       }
	}
	
	 function validateEmail(email) {
		  const re = /^(([^<>()[\]\\.,;:\s@\"]+(\.[^<>()[\]\\.,;:\s@\"]+)*)|(\".+\"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
		  return re.test(email);
		}

		function validate() {
		  const $result = $("#result");
		  const email = $("#email").val();
		  $result.text("");

		  if (validateEmail(email)) {
		    $result.text("");
		    //$result.css("color", "green");
		    return true;
		  } else {
		    $result.text(email + " is not valid :(");
		    $result.css("color", "red");
		    return false;
		  }
		  //return false;
		}
		
		function validateForm() {
		    var a = document.forms["Form"]["answer_a"].value;
		    var b = document.forms["Form"]["answer_b"].value;
		    var c = document.forms["Form"]["answer_c"].value;
		    var d = document.forms["Form"]["answer_d"].value;
		    if (a == null || a == "", b == null || b == "", c == null || c == "", d == null || d == "") {
		      alert("Please Fill All Required Field");
		      return false;
		    }
		  }
</script>


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

    <form name="form1" onsubmit="return (checkforblank(document.form1.dd,document.form1.mm,document.form1.yyyy) && phonenumber(document.form1.phone) && checkCompany() && allLetter2(document.form1.lastName) && allLetter(document.form1.firstName) && validate() && checkEmail())" action="<%= request.getContextPath() %>/register" method="post">
    <table style="with: 80%">
    <tr>
      <td style="text-align:right;padding-right:10px;">Last Name</td>
      <td><input type="text" class="fadeIn second" name="lastName" onchange="allLetter2(document.form1.lastName)" >
      <div id="error-lastName"></div></td>
    </tr>
    <tr>
     <td style="text-align:right;padding-right:10px;">First Name</td>
     <td><input type="text" class="fadeIn second" name="firstName" onchange="allLetter(document.form1.firstName)"/>
     <div id="error-firstName"></div></td>
    </tr>
    <tr>
    
    
    <!-- 
    ON 
    SUBMIT 
    checkforblank(document.form1.dd,document.form1.mm,document.form1.yyyy) && phonenumber(document.form1.phone) && 
     && checkCompany()
     allLetter2(document.form1.lastName) && allLetter(document.form1.firstName) && checkforblank(document.form1.dd,document.form1.mm,document.form1.yyyy) && phonenumber(document.form1.phone) && validate() && checkEmail()
    -->
    
    
     <td style="text-align:right;padding-right:10px;">Birth Date</td>
     <td style="padding:8px"><SELECT style="padding:5px" id ="day" name = "dd">
    </SELECT>
    <SELECT style="padding:5px"  id ="month" name = "mm" onchange="change_month(this);">
    </SELECT>
    <SELECT style="padding:5px" id ="year" name = "yyyy" onchange="change_year(this);">
    </SELECT>
    <div id="error-birthday"></div></td>
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
     <td><input type="text" class="fadeIn second" name="phone" onchange="phonenumber(document.form1.phone)"/>
     <div id="error-phone"></div></td>
    </tr>
    <tr>
     <td style="text-align:right;padding-right:10px;">Email</td>
     <td><input type="text" class="fadeIn second" name="email" id="email" onkeyup="validate();checkEmail()" ><font color="red"><div id="mydiv"></div></font>
     <h2 id="result" style="color: red;"></h2>
     <p id="raspuns"></p>
    </tr>
    <tr>
     <td style="text-align:right;padding-right:10px;">Company Name</td>
     <td><input type="text" class="fadeIn second" name="company" id="company" onkeyup="checkCompany()"/><font color="red"><div id="mydiv2"></div></font>
    </tr>
    <tr>
     <td style="text-align:right;padding-right:10px;">Your job</td>
     <td><input type="text" class="fadeIn second" name="job" /></td>
    </tr>
    <tr>
      <td style="text-align:right;padding-right:10px;">Password</td>  
      <td><input type="password" class="fadeIn second" name="password" id="password" onkeyup="checkPass(); return false;"></td>
    </tr>
    <tr>
      <td style="text-align:right;padding-right:10px;">Confirm password</td>  
      <td><input type="password" class="fadeIn second" name="password2" id="password2" onkeyup="checkPass(); return false;">
      <div id="error-nwl"></div></td>
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