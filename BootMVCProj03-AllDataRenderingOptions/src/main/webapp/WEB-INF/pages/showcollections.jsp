<%@page isELIgnored="false" import="java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<h1>Model Attribute Values are</h1>
<b>Fav colors</b>
<c:forEach var="color" items="${favColors }">${color},</c:forEach>
<br>
<b>Nick Names are::</b>
<c:forEach var="names" items="${nickNames}">${names},</c:forEach>
<br>
<b>Phone Numbers are::</b>
<c:forEach var="phones" items="${phonenumbers}">${phones},</c:forEach>
<br>
<b>Id details are::</b>
<c:forEach var="id" items="${iddetails}">${id.key},${id.value},</c:forEach>
<br>
<c:if test="${!empty empinfo}" >
	<b>Employee information:: ${empinfo.eno}, ${empinfo.ename}, ${empinfo.salary}, ${empinfo.isVaccinated} </b>
</c:if>