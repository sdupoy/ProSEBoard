<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:main>
<jsp:attribute name="publish_available">en</jsp:attribute>
	<jsp:body>
		<div class="row">
			<div class="col-md-12 col-lg-10">
			<h1>Mes disponibilités</h1>
			<form method="get" action="${pageContext.request.contextPath}/MyCompetences">
					<input type="hidden" value="${user.getId()}" name = "id"> 
				<table class="table table-hover table-striped">
					<c:forEach items="${availables}" var="available">				
							<tr>
								<td> ${available.getDateStartString()}</td>
								<td> ${available.getDateEndString()}</td>
							</tr>
					</c:forEach>
				</table>
			</form>
			</div>
		</div>
	</jsp:body>
</t:main>