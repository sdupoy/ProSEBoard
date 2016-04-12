<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<t:main>
	<jsp:body>
		<h2>Mes notifications</h2>
		<div class="row">
			<div class="col-md-8">
				<table class="table table-hover">
					<c:forEach items="${notifications}" var="notification">
					<c:set var="notif" value="${notification}" scope="request" />
						<tr><td>
							<c:choose>
					    		<c:when test="${notification.getType() eq 'audit_application'}">
					       			<jsp:include page="/WEB-INF/JSP/notifications/audit_application.jsp"/>
			    				</c:when>
				       			<c:when test="${notification.getType() eq 'consulting_application'}">
					       			<jsp:include page="/WEB-INF/JSP/notifications/consulting_application.jsp"/>
			    				</c:when>
			    				<c:when test="${notification.getType() eq 'training_application'}">
					       			<jsp:include page="/WEB-INF/JSP/notifications/training_application.jsp"/>
			    				</c:when>
			    				<c:when test="${notification.getType() eq 'default'}">
					       			<jsp:include page="/WEB-INF/JSP/notifications/default.jsp"/>
			    				</c:when>
				    			<c:otherwise>
				    				Pas de template pour ${notification.getType()}
				    			</c:otherwise>
							</c:choose>
						</td></tr>	
					</c:forEach>
				</table>
			</div>
		</div>
	</jsp:body>
</t:main>