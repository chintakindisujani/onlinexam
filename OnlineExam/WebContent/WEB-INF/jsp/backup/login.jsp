<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><spring:message code="TITLE"></spring:message></title>
<script type="text/javascript">
	function validate() {
		var username = document.getElementById("username").value;
		if (username.length == 0) {
			alert("Please Enter Email Id");
			document.getElementById("username").focus();
			return false;
		}
		if(username=="null"||username=="NULL"){
			alert("UserName Can Not be Null");
			document.getElementById("username").focus();
			return false;
			
		}
		var password = document.getElementById("password").value;
		if (password.length == 0) {
			alert("Please Enter Password ");
			document.getElementById("password").focus();
			return false;
		}
		return true;
	}
</script>
</head>
<body>
<form name="loginPage" id="loginPage" action="loginPage.do" name="form"  method="POST"	style="margin-top: 200px; margin-left: 300px">
	<h2>
		<p style="color: blue">
			<spring:message code="login.header.message"></spring:message>
		</p>
	</h2>
	<table>
		<tr>
			<td><spring:message code="login.label.username"></spring:message></td>
			<td><input type="text" name="username" id="username" maxlength="100" /></td>
		</tr>
		<tr>
			<td><spring:message code="login.label.password"></spring:message></td>
			<td><input type="password" name="password" id="password" maxlength="16" /></td>
			</tr>
	</table>
	<input type="submit" name="OnlineExam"		value='<spring:message code="LOGIN"/>' onclick="return validate();" />&nbsp;&nbsp; 
	<input	type="submit" name="OnlineExam"		value='<spring:message code="REGISTER"/>'>&nbsp;&nbsp;
	<input	type="submit" name="OnlineExam"		value='<spring:message code="MANAGER"/>'>&nbsp;&nbsp;

</form>
</body>
</html>
