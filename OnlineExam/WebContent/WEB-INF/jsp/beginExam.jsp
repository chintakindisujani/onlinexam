<!-- 
	Document	: home.jsp
	Created on	: Dec 7th,2014, 1:00AM
	Author     	: anji@iwinner.com
 -->
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.*" %>
<%@page import="com.iwinner.store.model.*" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
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
	<% 
	
	
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

<% ExamResult examRes=(ExamResult)session.getAttribute("examResult"); %>
    <table border="0" width="950">
        <tr>
            <td align ="center">
        <form name="testSummary" id="testSummary" action="startNewExam.do" method="POST">
        <table cellpadding ="10" cellspacing="0" border ="0" width="600" style="padding-top: 40px; border: none">
            <th colspan ="3" style="background-color: #a9a8f0"><h2>Examination Details</h2></th>
            <tr style="background-color: #e1e1f0">
                <td style="font-size:20px;">
                    Exam Code
                </td>
                <td>:</td>
                <td><% 
                String exa=examRes.getExamId();
                out.println(exa);
                %>
		<input type="hidden" id="ExamCodeID" name="ExamCodeID" value='<c:out value='${exmIdI}'/>'/>                    
<%--<input type="hidden" id="ExamName" name="ExamNamePassOn" value='<c:out value='${examRes.getExamName()}'/>'/>
 --%>                </td>
            </tr>
            <tr style="background-color: #e1e1f0">
                <td style="font-size:20px;">
                    Duration
                </td>
                <td>:</td>
                <td>
		<% String duration=examRes.getDuration(); out.println(duration);%>
                </td>
            </tr>
            <tr style="background-color: #e1e1f0">
                <td style="font-size:20px;">
                    Total no. of Questions
                </td>
                <td>:</td>
                <td>
        <% Integer examNoOF=examRes.getNoOfQuestions();out.println(examNoOF);%>
                </td>
            </tr>
            <tr style="background-color: #e1e1f0">
                <td style="font-size:20px;">
                    Maximum Marks
                </td>
                <td>:</td>
                <td>
                    <% String getTotalMar=examRes.getTotalMarks();out.println(getTotalMar);%>
                </td>
            </tr>
            <tr style="background-color: #a9a8f0">
                <td colspan="3" align ="center">
                    
                         <input class="submit" type="image"  src="${pageContext.request.contextPath}/images/Start-Test.png" width="160" height="42" style="margin-top:10px; border: 0" />
	                    <a href="avaiableExams.do">
                        <img src="${pageContext.request.contextPath}/images/Cancel-Exam-Start.png" width="160" height="42" style="margin-top:10px; border: 0; padding-left: 30px" /></a>
                </td>
            </tr>
        </table>         
        </form>  
            </td>
        </tr>
    </table>
    <input type="hidden" id="ExamCodeID" name="ExamCodeID" value='<c:out value='${exmIdI}'/>'/>
<h3>Exam Instructions <a href="examInstructionsPage.do"/>Here</h3>

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
