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
<title>Home - Online Examination Portal</title>
<style type="text/css">
#navigation {
	width: 950px;
	height: 50px;
	margin: 0;
	padding: 0;
	background:
		url("${pageContext.request.contextPath}/images/navigation-bg.jpg")
		no-repeat left top;
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
	background:
		url("${pageContext.request.contextPath}/images/navigation-hover.png")
		repeat-x left top;
}

#navigation ul li#active a {
	color: #134264;
	background: url("${pageContext.request.contextPath}/images/navigation-hover.png" ")
		repeat-x left top;
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
		if (Usersession.getAttribute("username_") == null
				|| Usersession.getAttribute("ROLE") == null) {
			response.sendRedirect("startUp.do");

		} else {
	%>

	<h2 class="Page-Heading">Online Examination Portal</h2>
	<%
		out.println("<b>Welcome "
					+ Usersession.getAttribute("username_") + "...</b>");
	%>
	<div id="navigation">
		<ul>
			<li id="active"><a href="landingPage.do">Home</a></li>
			<%
				if (Usersession.getAttribute("ROLE").toString()
							.contains("ADMIN")) {
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
<br/>
	<H3>
		<a href="addExamNavigation.do">ADD EXAM</a>
	</H3>
<br/>
	<H3>
		<a href="removeExam.do">REMOVE EXAM</a>
	</H3>
<br/>
	<H3>
		<a href="removeUser.do">REMOVE USER</a>
	</H3>
<br/>
	<H3>
		<a href="userPrivilagesNa.do">USER PRIVILAGES</a>
	</H3>
<br/>
	<H3>
		<a href="singleUpdateNav.do">Single Question Upload Question</a>
	</H3>

<br/>
	<H3>
		<a href="bulkUpdateNav.do">Bulk QuestionUpload</a>
	</H3>

<br/>



	<%
		}
	%>
</body>
</html>
