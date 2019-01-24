<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript">
	function checkdata()
	{
		var xmlhttp;
		var cname=document.getElementById("name").value;
		var cemail=document.getElementById("email").value;
		var url="<%= request.getContextPath() %>/CheckController?name="+cname+"&email="+cemail;
		if (window.XMLHttpRequest) {
			xmlhttp = new XMLHttpRequest();
		} else {
			xmlhttp = new ActiveXObject();
		}
		
		xmlhttp.onreadystatechange = function() {
			if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
				var z=(1*1)-1;
				
				var cus=xmlhttp.responseXML.documentElement;
				var cusname=cus.getElementsByTagName("name")[z].childNodes[0].nodeValue;
				var cusemail=cus.getElementsByTagName("email")[z].childNodes[0].nodeValue;
				
				document.getElementById("nameresult").innerHTML=cusname;
				document.getElementById("emailresult").innerHTML=cusemail;
			}
		}
		
		xmlhttp.open("POST",url,true);
		xmlhttp.send();
	}
</script>
</head>
<body>
Enter Name:-<input type=text onkeyup="checkdata()" id="name" name="name">
<div id="nameresult"></div>
Enter Email:-<input type="text" onkeyup="checkdata()" id="email" name="email">
<div id="emailresult"></div>
</body>
</html>