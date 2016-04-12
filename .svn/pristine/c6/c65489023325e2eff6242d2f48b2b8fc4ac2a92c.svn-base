<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<t:main>

	<jsp:attribute name="chargeConsultingSession">en</jsp:attribute>
	<jsp:body>
		<div class="row">
			<div class="col-sm-20 col-md-16 col-lg-12">
			<h1>Sessions facturables</h1>
			
			<table class="table table-hover table-striped">
				<thead>
					<tr>
						<th>N°</th>
						<th>Date</th>
						<th>Equipe concernée</th>
						<th>Nombre d'heures</th>
						<th>Tarif horaire </th>
					</tr>				
				</thead>
				<c:forEach items="${sessions}" var="session">				
					<tr>
						<form method="post" name="Facturation" action="${pageContext.request.contextPath}/chargeConsultingSession">
						<td>${session.getId()}</td>
						<td>Du ${session.getEvent().getStartDateString()} <br/>
							au ${session.getEvent().getEndDateString()}</td>
						<td>${session.getTeam().getTeamName()} - ${session.getTeam().getProjectName()}</td>
						<td>
							<input class="form-control" type="number" name="nbSpentHours" min="0"  required>
						</td>
						<td>
							<input class="form-control" type="number" name="hourCost" min="0"  required>
						</td>
						<td> 
							<input type="hidden" name="idSessionToCharge" value="${session.getId()}"> 
							<button class="btn btn-primary" type="submit"><i class="fa fa-euro fa-fw"></i> Facturer</button>
						</td>
						</form>
					</tr>
				</c:forEach>
			</table>
			
			</div>
		</div>
		<form action="${pageContext.request.contextPath}/">
		<button class="btn btn-primary" type="submit"><i class="fa fa-long-arrow-left fa-fw"></i> Annuler</button>
		</form>	
	</jsp:body>
</t:main>