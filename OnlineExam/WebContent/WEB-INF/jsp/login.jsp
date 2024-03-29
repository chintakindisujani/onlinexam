<%@ page language="java" contentType="text/html; charset=ISO-8859-1"	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.*" %>
<%@page import="com.iwinner.store.model.UserRole" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style type="text/css">
body{
margin-left: auto
width: 500px;
background-color: #EEEEEE
}
</style>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.js"></script>
<script type="text/javascript"	src="${pageContext.request.contextPath}/js/jquery.query-2.1.7.js"></script>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><spring:message code="TITLE"></spring:message></title>
<script>
	$(document).ready(
			function() {
				$("#username").focus();
				$("#login").click(
						function() {if ($.trim($("#username").val()) == '') {
								alert("UserName is can't be empty ");
								return false;
							}
							if ($.trim($("#password").val()) == '') {
								alert("Password is Not Empty");
								return false;
							}
							console.log($("#password").val().length)
							if ($("#password").val().length >= 6) {
								alert("Please Enter Above 6 Chaaracters");
								return false;
							}
							if ($("#password").val() == 'NULL'
									|| $("#password").val() == 'null') {
								alert("Password Can't be Null or null");
								// alert($(this).val());
								$("#password").focus();
								return false;
							}
						});
			});
</script>
</head>
<%
List<UserRole> listOfRoles=(List)session.getAttribute("userRol");
%>
<body>
	<form name="loginPage" id="loginPage" action="loginPage.do" name="form"
		method="POST" style="margin-top: 200px; margin-left: 300px">
		<h2>
			<p style="color: blue">
				<spring:message code="login.header.message"></spring:message>
			</p>
		</h2>
		<table>
			<tr>
				<td><spring:message code="login.label.username"></spring:message></td>
				<td><input type="text" name="username" id="username"
					maxlength="100" /></td>
			</tr>
			<tr>
				<td><spring:message code="login.label.password"></spring:message></td>
				<td><input type="password" name="password" id="password"
					maxlength="16" /></td>
			</tr>
			
			<tr>
				<td><spring:message code="login.role"></spring:message></td>
				
				<td>
					<select style="width:145px;" name="userRole" id="userRole">
						<option value="-1">Please Select</option>
						<%
						for(UserRole userRole:listOfRoles){ %>

						<option value="<%=userRole.getId()%>"><%=userRole.getRoleName()%></option>

						<%}
						%>
					</select>
					</td>
			</tr>
		</table>
		<input type="submit" name="OnlineExam" id="login"
			value='<spring:message code="LOGIN"/>' />&nbsp;&nbsp; <input
			type="submit" name="OnlineExam"
			value='<spring:message code="REGISTER"/>'>&nbsp;&nbsp; <input
			type="submit" name="OnlineExam"
			value='<spring:message code="MANAGER"/>'>&nbsp;&nbsp;

	</form>
</body>
</html>
