<%@page isELIgnored="false" import="java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:if test="${!empty empinfo}" >
	<b>Employee information:: ${empinfo.eno}, ${empinfo.ename}, ${empinfo.salary}, ${empinfo.isVaccinated} </b>
</c:if>