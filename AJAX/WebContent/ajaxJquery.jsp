<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>AJAX JQuery</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
		
		$('#sbmt').click(function(){
			var fullname = $('#fullname').val();
			$.ajax({
				type : 'POST',
				data : {
					fullname : fullname,
					action : 'Demo1'
				},
				url : 'AJAXServletController',
				success : function(result){
					$('#result1').html(result);
				}
			});
		});
		
		$('#btn2').click(function(){
			var number1 = $('#number1').val();
			var number2 = $('#number2').val();
			$.ajax({
				type : 'POST',
				url : 'AJAXServletController',
				data : {
					action : 'Demo2',
					number1 : <%= 7 %>,
					number2 : number2
				},
				success : function(result){
					$('#plusresult').html(result);
				}
			});
		});
	});
</script>
</head>
<body>
Enter Name:-<input type=text id="fullname" name="fullname"><input type=submit id="sbmt" name=sbmt value="Go">
<span id="result1"></span>
<fieldset>
<legend>Hey</legend>
<form name="frm" method="post">
<table>
	<tr>
		<td>Enter Number1:-</td>
		<td><input type=text id="number1" name="number1"></td>
	</tr>
	<tr>
		<td>Enter Number2:-</td>
		<td><input type=text name="number2" id="number2"></td>
	</tr>
	<tr>
		<td colspan=2 align=center><input type=button id="btn2" name=sbmt value="Go"></td>
	</tr>
</table>
</form>
<div id="plusresult"></span>
</fieldset>
</body>
</html>