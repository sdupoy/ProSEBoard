<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<t:main>

	<jsp:attribute name="payTeam">en</jsp:attribute>
	<jsp:body>
		<div class="row">
			<div class="col-sm-20 col-md-16 col-lg-12">
			<h1>Membres de l'équipe à payer</h1>
			
			<table class="table table-hover table-striped">
				<thead>
					<tr>
						<th>Membre</th>
						<th>Nombre d'heures</th>
						<th>Salaire horaire</th>
						<th>Nombre d'heures sup'</th>
						<th>Salaire horaire majoré</th>
					</tr>				
				</thead>
				
				<c:forEach items="${myTeams}" var="team">
					<c:forEach items="${team.getMembers()}" var="member">			
						<form method="post" name="Salaire" action="${pageContext.request.contextPath}/PayMembers">
						<tr>
							<td>${member.getFirstName()} ${member.getLastName()}</td>
							<td>
							<input class="form-control" type="number" name="nbRegHours" min="0"  required>
							</td>
							<td>
							<input class="form-control" type="number" name="regWage" min="0"  required>
							</td>
							<td>
							<input class="form-control" type="number" name="nbXtraHours" min="0">
							</td>
							<td>
							<input class="form-control" type="number" name="xtraWage" min="0">
							</td>
							<td>
								<input type="hidden" name="membAccount" value="${member.getIdAccount()}"> 
								<input type="hidden" name="teamAccount" value="${team.getIdAccount()}"> 
								<button class="btn btn-primary" type="submit"><i class="fa fa-euro fa-fw"></i> Rémunérer</button>
							</td>
						</tr>
						</form>
					</c:forEach>
				</c:forEach>
			</table>
			
			</div>
		</div>
		<form action="${pageContext.request.contextPath}/">
		<button class="btn btn-primary" type="submit"><i class="fa fa-long-arrow-left fa-fw"></i> Annuler</button>
		</form>	
		
	</jsp:body>
</t:main>