<!-- 
	Document	: home.jsp
	Created on	: Dec 7th,2014, 1:00AM
	Author     	: anji@iwinner.com
 -->
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Home - Online Examination Portal</title>
<style type="text/css">
#navigation {
	width: 950px;
	height: 50px;
	margin: 0;
	padding: 0;
	background: url("${pageContext.request.contextPath}/images/navigation-bg.jpg") no-repeat left top;
}

#navigation ul {
	list-style: none;
	margin: 0;
	padding: 0;
}

#navigation ul li {
	display: inline;
	margin: 0px;
}

#navigation ul li a {
	height: 33px;
	display: block;
	float: left;
	padding: 17px 15px 0 15px;
	font: bold 12px Arial;
	color: #FFF;
	text-decoration: none;
	background: url(images/navigation-separator.png) no-repeat right center;
}

#navigation ul li a:hover {
	color: #134264;
	background: url("${pageContext.request.contextPath}/images/navigation-hover.png") repeat-x left top;
}

#navigation ul li#active a {
	color: #134264;
	background: url("${pageContext.request.contextPath}/images/navigation-hover.png"") repeat-x left top;
}

.Page-Heading {
	padding: 0;
	margin: 0;
	color: #4778e3;
	font: bold 38px "Calibri", Arial;
}

.show {
	display: block;
}

.hide {
	display: none;
}
</style>
</head>
<body>
	<%
		HttpSession Usersession = request.getSession(false);
		if (Usersession.getAttribute("username_") == null|| Usersession.getAttribute("ROLE") == null) {
			response.sendRedirect("loginPage.do");

} else {%>

	<h2 class="Page-Heading">Online Examination Portal</h2>
	<%
		out.println("<b>Welcome "
					+ Usersession.getAttribute("username_") + "...</b>");
	%>
	<div id="navigation">
		<ul>
			<li id="active"><a href="landingPage.do">Home</a></li>
			<%
				if (Usersession.getAttribute("ROLE").toString().contains("ADMIN")) {
						out.println("<li><a href = 'adminConsole.do'>Administration Console</a></li>");
					}
			%>
			
			<a href="main.jsp">
			<li><a href="avaiableExams.do">Available Exams</a></li>
			<li><a href="PreviousResults.jsp">Previous Results</a></li>
			<li><a href="ContactUs.jsp">Contact Us</a></li>
			<li><a href="Logout.jsp">Logout</a></li>
		</ul>
	</div>

                <table border="0" width="950">
                    <tr>
                        <td align ="center">
                          <form action="removeExamId.do" id="RemoveExamForm" method="post">

        <h2 style="color: #4778e3">Registered User Accounts</h2>  
        Please select a User Account below and click Remove User to clear User Data<br/><br/>
        <%
        String deleteExam=(String)request.getAttribute("removeExamSelect");
        if(deleteExam!=null){
        	out.println("<h3><font color='red'>"+deleteExam+"</font><h3>");
        }
        %>
        <form action="removeUserE.do"> 
         <table cellspacing="0" cellpadding="15" border="0" width="600" >
             <tr style="background-color: #a9a8f0; font-size: 20px; font-weight: bold">
                 <td></td>
             <td><b>Name</b></td>
             <td><b>Email</b></td>
             </tr>
	<c:forEach items="${listOfUsers}" var="exam">
		<tr>
		<td><input type="radio" id="ExamIdToRemoveRadio" name="ExamIdToRemoveRadio" value="<c:out value="${exam.username}"/>"/>
		<td><c:out value="${exam.username}"></c:out></td>
		<td><c:out value="${exam.emailId}"></c:out></td>
		</tr>
</c:forEach>

<tr>
        <td></td>
        <td>
            <b style="padding-left: 55px;padding-top: 5px; padding-bottom: 15px"><% 
            if(Usersession.getAttribute("ExamCreationError")!= null)
             out.print(Usersession.getAttribute("ExamCreationError")); %></b><br/>
              <input class="submit" type="image" src="${pageContext.request.contextPath}/images/Remove-User.png"  
              width="160" height="42" style="margin-top:10px;; border: 0" onsubmit="validateForm();"/>
		        <a href="AdminConsoleHome.jsp">
                        <img src="${pageContext.request.contextPath}/images/Cancel-Exam-Registration-btn.png" width="160" height="42" style="margin-top:10px; border: 0" /></a>
         </td>
    </tr> 
</table>
</form>
<%
String message=(String)request.getAttribute("deleteExamId");
if(message!=null){
	out.println("<h3><font color='red'>"+message+"</font><h3>");
}
%>
<script type="text/javascript">
function validateForm(){
	var val=document.getElementById("ExamIdToRemoveRadio").value();
	alert(val);
	
	
}
</script>

	<%
		}
	%>
</body>
</html>
