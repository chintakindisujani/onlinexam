<!-- 
	Document	: home.jsp
	Created on	: Dec 7th,2014, 1:00AM
	Author     	: anji@iwinner.com
 -->
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
			response.sendRedirect("startUp.do");

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
			<li><a href="logout.do">Logout</a></li>
		</ul>
	</div>

                <table border="0" width="950">
                    <tr>
                        <td align ="center">
        <form action="startExamID.do" method="post">

        <h2 style="color: #4778e3">Active Exams Directory</h2>  
        Please select an exam below and click Remove Exam to clear Examination Data<br/><br/>
        <%
        String deleteExam=(String)request.getAttribute("removeExamSelect");
        if(deleteExam!=null){
        	out.println("<h3><font color='red'>"+deleteExam+"</font><h3>");
        }
        %>
        
        	<table cellspacing="0" cellpadding="10" width="900" align="center"		border="0">
        	<c:forEach items="${examList}" var="exam">
							<tr colspan="2">
							<td colspan="2" align="center"><input type="radio"	id="examIdSelection" name="examIdSelection"	value='<c:out value='${exam.examId}'/>'></td>
							<td><b>
							  <c:out value="${exam.examName}"></c:out></b>
							 <br> <c:out value="${exam.examDescription}"/>	
							 </td>
						</tr>
			</c:forEach>
			</table>
			  <input  type="submit" name ="Submit"/>
     </form>
<%
String message=(String)request.getAttribute("deleteExamId");
if(message!=null){
	out.println("<h3><font color='red'>"+message+"</font><h3>");
}
%>
</script>

	<%
		}
	%>
</body>
</html>
