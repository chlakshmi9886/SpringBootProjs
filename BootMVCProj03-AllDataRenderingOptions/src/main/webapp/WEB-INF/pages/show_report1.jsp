<%@page isELIgnored="false" import="java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:choose>
	<c:when test="${!empty empinfo}">
		<table border="1" bgcolor="cyan" align="center">
			<tr>
			<th>eno</th>
			<th>ename</th>
			<th>salary</th>
			<th>vaccinated</th>
			</tr>
			<c:forEach var="emp" items="${empinfo}">
				<tr>
					<td>${emp.eno}</td>
					<td>${emp.ename}</td>
					<td>${emp.salary}</td>
					<td>${emp.isVaccinated}</td>
				</tr>
			</c:forEach>
		</table>
	</c:when>
	<c:otherwise>
		<h1 style="color:red; text-align:center"> Employee not found</h1>
	</c:otherwise>
</c:choose>