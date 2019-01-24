<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript">
	
	function checkemail(){
		var mail=document.getElementById("email").value;
		var url="<%=request.getContextPath()%>/EmailController?mail=" + mail;
		var xmlhttp;

		if (window.XMLHttpRequest) {
			xmlhttp = new XMLHttpRequest();
		} else {
			xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
		}
		
		xmlhttp.onreadystatechange = function() {
			if(xmlhttp.readyState == 4 && xmlhttp.status == 200) {
				document.getElementById("result").innerHTML = xmlhttp.responseText;
			}
		}
		
		xmlhttp.open("POST", url, true);
		xmlhttp.send();
	}
</script>
</head>
<body>
	Enter Email:-
	<input type=email id="email" name="email" onkeyup="checkemail()">
	<div id="result"></div>
</body>
</html>