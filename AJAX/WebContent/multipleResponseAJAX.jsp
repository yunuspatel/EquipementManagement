<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>DDL FILL AJAX</title>
</head>
<Script type="text/javascript">

	function filldata()
	{
		var xmlhttp;
		var url = "<%= request.getContextPath() %>/DDLController";

		if (window.XMLHttpRequest) {
			xmlhttp = new XMLHttpRequest();
		} else {
			xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
		}
		
		xmlhttp.onreadystatechange = function() {
			if(xmlhttp.readyState == 4 && xmlhttp.status == 200) {
				var z=(1*1)-1;
				
				var cus=xmlhttp.responseXML.documentElement;
				var cusname=cus.getElementsByTagName("customername")[z].childNodes[0].nodeValue;
				var cusid=cus.getElementsByTagName("customerid")[z].childNodes[0].nodeValue;
				while(cusname!=null)
				{
					addoptions(cusid,cusname);
					z++;
					var cusid=cus.getElementsByTagName("customerid")[z].childNodes[0].nodeValue;
					var cusname=cus.getElementsByTagName("customername")[z].childNodes[0].nodeValue;
				}
			}
			
			function addoptions(cusid,cusname)
			{
				var opt=document.createElement("OPTION");
				opt.text=cusname;
				opt.value=cusid;
				document.getElementById("data").add(opt);
			}
		}
		
		xmlhttp.open("POST",url,true);
		xmlhttp.send();
	}

</Script>
<body onload="filldata()">
<input type="submit" name=sbmt id="sbmt" onclick="filldata()" value="FILL"><br>
<form name=frm method="post" action="DDLController">
<input type=hidden name="flag" value="display">
<select id="data" name="data">
	<option>Select</option>
</select>
<input type=submit name=sbmt value="Send">
</form>
</body>
</html>