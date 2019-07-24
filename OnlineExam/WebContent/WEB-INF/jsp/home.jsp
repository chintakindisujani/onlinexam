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
			<td>

				<h1 class="Page-Heading" style="font-size: 34px; padding-top: 20px">
					Welcome . . . .</h1>
				<p>Welcome to the Online Examination Portal. Here, we take
					pride in providing an environment for students to enjoy and enhance
					their learning experience.Online Examination portal aims to be a
					leading Global Talent Development Platform for testing your
					knowledge and to enhance your skills by means of an assortment of
					well thought out tests.
				<p>
				<h4 style="color: #4778e3">
					<font size="5"><b> Assessments</b></font>
				</h4>

				<p>On the online examination portal, we provide students and
					teachers with a collaborative environment to conduct knowledge
					assessment tests that are quality assured by a dedicated moderating
					committee. The environment also provides provisions for creating
					custom examinations by authorized users.</p>




				<h4 style="color: #4778e3">
					<font size="5"><b>Performance Level Descriptions &
							Content Standards</b></font>
				</h4>

				<ul>
					<li style="padding: 5px">Test scoring criteria is based on the
						performance of the user</li>

					<li style="padding: 5px">All tests currently registered at the
						portal is available to the user at any time</li>

					<li style="padding: 5px">There is no moderation of marks, all
						results are generated purely on the basis of merit.</li>

					<li style="padding: 5px">The test consist of 25 objective type
						questions that relate to the domain of the selected test</li>

					<li style="padding: 5px">There is no negative marking for
						wrong answers</li>
				</ul>
				</p>

			</td>
		</tr>
	</table>
	<%
		}
	%>
</body>
</html>
