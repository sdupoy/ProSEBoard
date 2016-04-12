<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<t:main>
<jsp:attribute name="manage_consultingReport">en</jsp:attribute>
	<jsp:body>
	<div class="row">
		<div class="col-md-12 col-lg-10">
			<h1>Rapports de consulting</h1>
			<table class="table table-hover table-striped">
				<thead>
					<tr>
						<th>Consultant :</th>
						<th>Equipe :</th>
						<th>Date du consulting:</th>
						<th>Rapport :</th>
						<th>Facturation</th>
					</tr>
				</thead>
				<c:forEach items="${consulting}" var="consulting">
					<tr>
						<td>${consulting.getConsultant().getFirstName() } ${consulting.getConsultant().getLastName() }</td>
						<td>${consulting.getTeam().getTeamName() } - ${consulting.getTeam().getProjectName() }</td>
						<td>Du ${consulting.getEvent().getStartDateString()} <br/>
							au ${consulting.getEvent().getEndDateString()}</td>
						<td>
							<c:if test="${empty consulting.getReport()  and consulting.getIdConsultant()==user.getId()}">
								<a href="${pageContext.request.contextPath}/consultation/creer" class="sb-btn">
								<button class="btn btn-primary" type="submit"><i class="fa  fa-pencil fw"></i> Rédiger le rapport</button>
								</a>
							</c:if>
							<c:if test="${not empty consulting.getReport()}">${consulting.getReport() }</c:if>
							<c:if test="${empty consulting.getReport() and consulting.getIdConsultant()!=user.getId()}">Rapport non rédigé</c:if>
						</td>
						<td>
							<c:if test="${not consulting.isCharged() and consulting.getIdConsultant()==user.getId()}">
								<a href="${pageContext.request.contextPath}/chargeConsultingSession" class="sb-btn">
								<button class="btn btn-primary" type="submit"><i class="fa fa-euro fw"></i> Facturer</button>
								</a>
							</c:if>
							<c:if test="${consulting.isCharged()}">Facturation réalisée</c:if>
							<c:if test="${not consulting.isCharged() and consulting.getIdConsultant()!=user.getId()}">Facturation non réalisée</c:if>
						</td>
					</tr>


				</c:forEach>
			</table>
		</div>
	</div>
	</jsp:body>
</t:main>