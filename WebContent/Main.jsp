<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.sql.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>classBOOK</title>
<link rel="stylesheet" href="css/bootstrap.min.css">
<meta name="viewport" content="width=device-width, initial-scale=1">
<script language='javascript' src='js/jquery-3.1.1.min.js'></script>
<script language='javascript' src='js/bootstrap.min.js'></script>
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
			String text="";
			try{
				String url="jdbc:mysql://localhost:3306/classbook";
				Class.forName("com.mysql.jdbc.Driver");
				Connection con=DriverManager.getConnection(url,"root","parv1608");
				PreparedStatement pstmt1=con.prepareStatement("select * from chat");
				ResultSet rs=pstmt1.executeQuery();
				while(rs.next()){
					text = text+"\n"+rs.getString("user")+": "+rs.getString("message");
				}
				System.out.println(text);
			}
			catch(Exception e){
				e.printStackTrace();
			}
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
			<div class="box">
			<div class="box1">
			<center><font size="6em" face="Calibri (Body)">CHATBOX</font><center>
			</div>
			<textarea readonly class="form-control" cols="120" rows="13" style="overflow-y:scroll; position:relative; left:0px;">
			<% out.println(text); %>
			</textarea>
			</div>
			<div class="m">
			<div class="m1">
			<center><font size="5em" face="Calibri (Body)">Enter Your Message Here</font><center>
			</div>
			<form action="Send" method="post">
			<input readonly type="text" name="user" value="${user}">
			<textarea name="message" class="form-control" cols="140" rows="2" style="overflow-y:scroll; position:relative; left:0px;"></textarea><br>
			<input type="submit" value="Send" class="btn btn-info" style="width:100px; height:45px; position:relative; left:430px; top:-20px;">
			</form>
			</div>
			</div>
			</div>	
			</div>
			<%
		}
		
%>		

</div>
</body>
</html>