<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.io.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>classBOOK</title>
<link rel="stylesheet" href="css/bootstrap.min.css">
<meta name="viewport" content="width=device-width, initial-scale=1">
<script language='javascript' src='js/jquery-3.1.1.min.js'></script>
<script language='javascript' src='js/bootstrap.min.js'></script>
<script>
$(document).ready(function() {
	$('#sem').change(function(event) {
        var sem = $("select#sem").val();
        var branch = $("select#branch").val();
        $.get('JsonServlet', {
                semName : sem,
                branchName : branch
        }, function(response) {
        var select = $('#subject');
        select.find('option').remove();
          $.each(response, function(index, value) {
          $('<option>').val(value).text(value).appendTo(select);
      	});
      });
    });	
	$('#branch').change(function(event) {
        var sem = $("select#sem").val();
        var branch = $("select#branch").val();
        $.get('JsonServlet', {
                semName : sem,
                branchName : branch
        }, function(response) {
        var select = $('#subject');
        select.find('option').remove();
          $.each(response, function(index, value) {
          $('<option>').val(value).text(value).appendTo(select);
      	});
      });
    });
});
</script>


<style>
.left{
height:430px;
width:265px;
background-color:white;
border-radius:5px;
position:relative;
top:32px;
}
.pic{
height:200px;
width:200px;
background-color:grey;
position:relative;
top:30px;
left:30px;
}
.chat
{
height:492px;
width:940px;
background-color:white;
position:relative;
top:30px;
border-radius:5px;
}
.m
{
height:160px;
width:940px;
position:relative;
top:2px;
background-color:white;
}

.box
{
height:330px;
width:940px;
background-color:#000122;
}
.box1{
height:40px;
width:940;
background-color:orange;
}
.m1{
background-color:orange;
height:40px;
width:940;
}
</style>

</head>
<body >
<div class="container-fluid" style="height:100%;  background-color:#000122;">

<%     
		if(session.getAttribute("user")==null){
			%>
			<div class="row bg-primary">
			<span style="position:relative; bottom:0px; left:60px"><font size="5em" face="Leelawadee">Session Expired. You are logged out </font></span>
			</div>
		<% }
		else{
			String user=String.valueOf(session.getAttribute("user"));
			%>
			<div class="row bg-primary">
			<span style="position:relative; bottom:0px; left:20px;"><font size="10em" face="Leelawadee">classBOOK</font></span>
			<span style="position:relative; bottom:13px; left:40px;"><a href="Logout"><button class="btn btn-success">Logout</button></a></span>
			<span style="position:relative; bottom:0px; left:60px"><font size="5em" face="Leelawadee">Welcome ${user} </font></span>
			</div>
			<div class="row">
			<div class="col-sm-3">
			<div class="left">
			<div class="pic">
			</div>
			<div style="position:relative; left:20px; top:65px;">
			<a href="upload.jsp" class="btn btn-info" style="width:220px; height:40px;">Upload File</a>
			</div>
			<div style="position:relative; left:20px; top:80px;">
			<a href="download.jsp"class="btn btn-info" style="width:220px; height:40px;">Download File</a>
			</div>
			</div>
			</div>
			<div class="col-sm-9">
			<div class="chat">
			<div class="box1">
			<form action="Download" enctype="multipart/form-data">
			<center><h1>Download File</h1>
            Select Semester:
	        <select id="sem" name="sem">
	                <option>Select Semester</option>
	                <option value="1">1</option>
					<option value="2">2</option>
					<option value="3">3</option>
					<option value="4">4</option>
					<option value="5">5</option>
					<option value="6">6</option>
					<option value="7">7</option>
					<option value="8">8</option>        
			</select>
	        <br /> <br /> 
	        Select Branch:
	        <select id="branch" name="branch">
	                <option>Select Branch</option>
	                <option value="civil">CIVIL</option>
	                <option value="cse">CSE</option>
	                <option value="ece">ECE</option>
	                <option value="eee">EEE</option>
	                <option value="it">IT</option>
	                <option value="mechanical">ME</option>
	        </select>
	        <br /> <br />
	        Select Subject
	        <select id="subject" name="subject">
	                <option>Select branch and semester first</option>
	        </select>
	        <br /><br/>
            <input class="btn btn-info"type="submit" value="submit"></center>
       		</form>
			</div>
			</div>
			</div>
			<%	
		}
		
%>		

</div>
</body>
</html>