<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<t:main>
<jsp:attribute name="manage_trainingReport">en</jsp:attribute>
	<jsp:body>
	<div class="row">
		<div class="col-md-12 col-lg-10">
			<h1>Rapports de formation</h1>
			<table class="table table-hover table-striped">
				<thead>
					<tr>
						<th>Formateur</th>
						<th>Sujet</th>
						<th>Date de la formation</th>
						<th>Participants</th>
						<th>Rapport</th>
						<th>Facturation</th>
					</tr>
				</thead>
				<c:forEach items="${training}" var="training">
					<tr>
						<td>${training.getEducator().getFirstName()} ${training.getEducator().getLastName() } </td>
						<td>${training.getSubject() }</td>
						<td>Du ${training.getEventBis().getStartDateString()} <br/>
							au ${training.getEventBis().getEndDateString()}
						</td>
						<td>
							<form method="get" name="Facturation" action="${pageContext.request.contextPath}/ViewTrainingAbsents">
								<input type="hidden" name="idTraining" value="${training.getId()}">
								<button class="btn btn-primary" type="submit"><i class="fa  fa-users fw"></i> Voir les participants</button>
							</form>
						</td>
						<td>
							<c:if test="${empty training.getReport()  and training.getIdEducator()==user.getId()}">
								<a href="${pageContext.request.contextPath}/CreateTrainingReport" class="sb-btn">
									<button class="btn btn-primary" type="submit"><i class="fa  fa-pencil fw"></i> Rédiger le rapport</button>
								</a>
							</c:if>
							<c:if test="${not empty training.getReport()}">${training.getReport() }</c:if>
							<c:if test="${empty training.getReport() and training.getIdEducator()!=user.getId()}">Rapport non rédigé</c:if>
						</td>
						<td>
							<c:if test="${not training.isCharged() and training.getIdEducator()==user.getId()}">
								<a href="${pageContext.request.contextPath}/chargeTrainingSession" class="sb-btn">
								<button class="btn btn-primary" type="submit"><i class="fa fa-euro fw"></i> Facturer</button>
								</a>
							</c:if>
							<c:if test="${training.isCharged()}">Facturation réalisée</c:if>
							<c:if test="${not training.isCharged() and training.getIdEducator()!=user.getId()}">Facturation non réalisée</c:if>
						</td>
					</tr>


				</c:forEach>
			</table>
		</div>
	</div>
	</jsp:body>
</t:main>