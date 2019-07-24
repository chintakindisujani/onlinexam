<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<head>
<script type="text/javascript">
function validatorForm(){
	if(instrtForm.agree.checked==false){
		alert("To register yourself you must agree to licence of this software!");
		return false;
	}
	return true;
}
</script>
</head>
<br/><br/>
<form action="processingOPeration.do" name="instrtForm" id="instrtForm" onsubmit="return validatorForm()" method="post">
<h3><p align="center"><font color="red"><u><b><spring:message code="instr.instructions"/></b></u></font></p></h3>
<br/><br/>
<h3><spring:message code="instr.one"/></h3>
<h3><spring:message code="instr.two"/></h3>
<h3><spring:message code="instr.threee"/></h3>
<h3><spring:message code="instr.four"/></h3>
<h3><spring:message code="instr.five"/></h3>
<h3><spring:message code="instr.six"/></h3>
<h3><spring:message code="instr.seven"/></h3>
<h3><spring:message code="instr.eight"/></h3>
<h3><p align="right"><font color="red"><spring:message code="instr.wish"/></font></p></h3>
<input type="checkbox" id="agree" style="color: blue;size: 10px"/><spring:message code="register.terms.condtions" />
<br/><br/>
<p align="center"><input class="submit" type="image" src="${pageContext.request.contextPath}/images/proceed.jpg" /></p>
</form>