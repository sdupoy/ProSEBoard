<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<t:main>

	<jsp:attribute name="payTeam">en</jsp:attribute>
	<jsp:body>
		<div class="row">
			<div class="col-sm-20 col-md-16 col-lg-12">
			<h1>Equipes à rémunérer</h1>
			
			<table class="table table-hover table-striped">
				<thead>
					<tr>
						<th>Nom d'équipe - Projet</th>
						<th>Chef d'équipe</th>
						<th>Montant</th>
					</tr>				
				</thead>
				<c:forEach items="${teams}" var="team">				
					<tr>
						<form method="post" name="Remuneration" action="${pageContext.request.contextPath}/payTeam">
						<td>${team.getTeamName()} - ${team.getTeam().getProjectName()}</td>
						<td>${team.getTeamLeader().getFirstName()} ${team.getTeamLeader().getLastName()} </td>					
						<td>
						<input class="form-control" type="number" name="amount" min="0" step="100" required>
						</td>
						<td> 
							
							<input type="hidden" name="idTeamToPay" value="${team.getIdTeam()}"> 
							<button class="btn btn-primary" type="submit"><i class="fa fa-euro fa-fw"></i> Rémunérer</button>
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