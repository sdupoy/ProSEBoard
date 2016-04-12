<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:main>
	<jsp:body>
		<div class="row">
			<div class="col-md-12 col-lg-10">
			<h1>Boîte de Reception</h1>
				<table class="table table-hover table-striped">
					<c:forEach items="${messages}" var="message">						
						<c:if test="${message.getTrashReceiver()==0}">				
							<tr>
								<td><form method="post" action="${pageContext.request.contextPath}/ServletBoiteReception">
								<input type="hidden" value="${message.getIdMessage()}" name = "id">
								<button class="btn btn-primary" type="submit"> <i class="fa fa-trash fa-fw"></i></button>
							</form></td>
								<td><form method="get" action="${pageContext.request.contextPath}/ResponseMessage">
								<input type="hidden" value="${message.getIdMessage()}" name = "id">
								<input type="hidden" value="${message.getMailEmetter()}" name = "idMailE">
								<input type="hidden" value="${message.getMailReceiver()}" name = "idMailR">
								<input type="hidden" value="${message.getIdEmetter()}" name = "idE">
								<input type="hidden" value="${message.getIdReceiver()}" name = "idR">
								<button class="btn btn-primary" type="submit"> <i class="fa fa-edit fa-fw"></i></button>
							</form></td>
								<td>${message.getMailEmetter()}</td>
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