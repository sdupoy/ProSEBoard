<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:main>
	<jsp:body>
		<div class="row">
			<div class="col-md-12 col-lg-10">
			<h1>Boîte d'envoi</h1>
					<table class="table table-hover table-striped">
						<c:forEach items="${messages}" var="message">
							<c:if test="${message.getTrashEmetter()==0}"> 				
								<tr>
								<td><form method="post" action="${pageContext.request.contextPath}/ServletBoiteEnvoi">
								<input type="hidden" value="${message.getIdMessage()}" name = "id">
								<button class="btn btn-primary" type="submit"> <i class="fa fa-trash fa-fw"></i></button>
							</form></td>
								<td>${message.getMailReceiver()}</td>
								<td>${message.getContain()}</td>
								<td>${message.getDatePrintf()}</td>
							</tr>
							</c:if>
						</c:forEach>
					</table>
			</div>
		</div>
	</jsp:body>
</t:main>


							