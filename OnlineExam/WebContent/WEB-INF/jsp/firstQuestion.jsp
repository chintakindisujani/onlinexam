<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style type="text/css">
p.ex1 {
    margin-left: 1cm;
    color: red;
}
table, tr, td {
    border: 1px solid black;
    width:20%;
    height:60px
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><spring:message code="TITLE"></spring:message></title>
</head>
<form action="firstQuestion.do">
<p class="ex1"><c:out value="${question.questionId}"/>.&nbsp;&nbsp;<c:out value="${question.questionName}"></c:out></p>
<input type="radio" name="questionAns"><c:out value="${question.optionA}"></c:out>&nbsp;&nbsp;&nbsp;&nbsp;
<input type="radio" name="questionAns"><c:out value="${question.optionB}"></c:out>&nbsp;&nbsp;&nbsp;&nbsp;<br/><br/>
<input type="radio" name="questionAns"><c:out value="${question.optionC}"></c:out>&nbsp;&nbsp;&nbsp;&nbsp;
<input type="radio" name="questionAns"><c:out value="${question.optionD}"></c:out>&nbsp;&nbsp;&nbsp;&nbsp;<br/><br/>
<input type="submit" name="Process" value="Process"/>
<table border="4" align="right" height="20">
<tr>
<td><a href='questionNum.do?id=1'>1</a></td><td><a href='questionNum.do?id=2'>2</a></td><td><a href='questionNum.do?id=3'>3</a></td><td><a href='questionNum.do?id=4'>4</a></td>
</tr>
<tr>
<td><a href='questionNum.do?id=5'>5</a></td><td><a href='questionNum.do?id=6'>6</a></td><td><a href='questionNum.do?id=7'>7</a></td><td><a href='questionNum.do?id=8'>8</a></td>
</tr>
<tr>
<td><a href='questionNum.do?id=9'>9</a></td><td><a href='questionNum.do?id=10'>10</a></td><td><a href='questionNum.do?id=11'>11</a></td><td><a href='questionNum.do?id=12'>12</a></td>
</tr>
<tr>
<td><a href='questionNum.do?id=13'>13</a></td><td><a href='questionNum.do?id=14'>14</a></td><td><a href='questionNum.do?id=15'>15</a></td><td><a href='questionNum.do?id=16'>16</a></td>
</tr>
<tr>
<td><a href='questionNum.do?id=17'>17</a></td><td><a href='questionNum.do?id=18'>18</a></td><td><a href='questionNum.do?id=19'>19</a></td><td><a href='questionNum.do?id=20'>20</a></td>
</tr>
</table>
</form>