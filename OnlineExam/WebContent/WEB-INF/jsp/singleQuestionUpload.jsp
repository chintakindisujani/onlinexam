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
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.js"></script>
<script type="text/javascript"	src="${pageContext.request.contextPath}/js/jquery.query-2.1.7.js"></script>
<script>
$(document).ready(
		function(){
			$("#userRole").focus();
			$("#postQues").click(	function() {
				var userRole=$.trim($("#userRole").val());
				         if (userRole==-1) {
							alert("Please select ExamID");
							return false;
				         }
						});	
			
		});
</script>

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
			<li><a href="logout.do">Logout</a></li>
		</ul>
	</div>
<%
List<ExamList> examList=(List)session.getAttribute("examList");
%>
                          <form action="singleUpdate.do" id="RemoveExamForm" method="post" >
            <h2 style="color: #4778e3">Single  Question</h2>  
    			    Please select an examID below <br/><br/>
        <table border="0" width="400">
                			<tr>
				<td><h3>ExamID</h3></td>
					<td><select style="width:89px;" name="userRole" id="userRole" >
						<option value="-1">Please Select</option>
						<%
						for(ExamList examListI:examList){ %>
						<option value="<%=examListI.getExamId()%>"><%=examListI.getExamId()%></option>
						<%}
						%>
					</select>
					</td>
			</tr>
			<tr>
			<td>QuestionName</td>
			<td><input type="text" name="questionName" style="width: 300px;" size="35" ></td>
			</tr>
        	<tr>
			<td>OptionA</td>
			<td><input type="text" name="optionA" style="width: 300px;" size="35" ></td>
			</tr>
        
        	<tr>
			<td>OptionB</td>
			<td><input type="text" name="optionB" style="width: 300px;" size="35"></td>
			</tr>
        
        	<tr>
			<td>OptionC</td>
			<td><input type="text" name="optionC" style="width: 300px;" size="35"></td>
			</tr>
        
        	<tr>
			<td>OptionD</td>
			<td><input type="text" name="optionD" style="width: 300px;" size="35"></td>
			</tr>
        
        
        	<tr>
			<td>Answer</td>
			<td><input type="text" name="answer" style="width: 300px;" size="35"></td>
			</tr>

           <tr>
           <td><input type="submit" name="SubmitQuestion" id="postQues"/></td>
           </tr>        
        </form>
        </td>
        </tr>
        </table>
        
        
        
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
