<%@page import="dao.CustomerDao"%>
<%@page import="vo.CustomerVo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<script>
	function loadData() {

		var xmlhttp;
		var custName = document.getElementById("custName").value;
		var url ="<%=request.getContextPath()%>/CustomerController?name="+custName;
		
		if (window.XMLHttpRequest) {
			xmlhttp = new XMLHttpRequest();
		} else {
			xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
		}

		xmlhttp.onreadystatechange = function() {
			if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
				document.getElementById("dataDiv").innerHTML = xmlhttp.responseText;
			}
		}

		xmlhttp.open("POST", url, true);
		xmlhttp.send();
	}
	function loadFinal(){
		var xmlhttp;
		var custNum=document.getElementById("custNo").value;
		var url="<%=request.getContextPath()%>/CustomerController?num="+custNum;
		
		if (window.XMLHttpRequest) {
			xmlhttp = new XMLHttpRequest();
		} else {
			xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
		}

		xmlhttp.onreadystatechange = function() {
			if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
				document.getElementById("dataDiv").innerHTML = xmlhttp.responseText;
			}
		}
		xmlhttp.open("POST",url,true);
		xmlhttp.send();
	}
</script>
</head>
<body>
	<%
		CustomerDao customerDao = new CustomerDao();
		List<CustomerVo> customerVos = customerDao.getAllCustomers();
	%>
	<div id="myDiv">
		<select id="custName" onchange="loadData()">
			<%
				for (CustomerVo customerVo : customerVos) {
			%>
			<option value="<%=customerVo.getCustomerName()%>"><%=customerVo.getCustomerName()%></option>
			<%
				}
			%>
		</select>
	</div>
	<div id="dataDiv"></div>
</body>
</html>