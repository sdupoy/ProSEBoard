<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:main>
<jsp:attribute name="book_consultationOrTraining">en</jsp:attribute>
	<jsp:body>
		<div class="row">
			<div class="col-md-12 col-lg-10">
			<h1>Les Disponiblités</h1>
			<br><br>	
				<form method="get" action="${pageContext.request.contextPath}/SeeAvailable">
					<table class="table table-hover table-striped">
						<c:forEach items="${availables}" var="available">
							<c:forEach items="${users}" var="user">
								<c:if test="${user.getId() == available.getIdUser()}">			
									<tr>
										<td> ${user.getFirstName()} ${user.getLastName()}</td>
										<td> ${available.getDateStartString()}</td>
										<td> ${available.getDateEndString()}</td>
									</tr>
								</c:if>
							</c:forEach>
						</c:forEach>
					</table>
				</form>
			</div>
		</div>
		<br>
		<a href="${pageContext.request.contextPath}/TeamLeader/ReservationConsultation" class="btn btn-primary pull-left" ><i class="fa fa-reply"></i></a>
	</jsp:body>
</t:main>