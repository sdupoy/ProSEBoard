<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<t:main>

	<jsp:attribute name="seeTeamInfos">en</jsp:attribute>
	<jsp:body>
		<div class="row">
			<div class="col-sm-20 col-md-16 col-lg-12">
			<h1>Equipes affiliées</h1>
			
			<table class="table table-hover table-striped">
				<thead>
					<tr>
						<th>Session</th>
						<th>Nom de l'equipe</th>
						<th>Nom du projet </th>
						<th>Membres </th>
						<th>Solde bancaire </th>
					</tr>				
				</thead>
				<c:forEach items="${teams}" var="team">				
					<tr>
						<td>${team.getSession().getName()}</td>
						<td>${team.getTeamName()}</td>
						<td>${team.getProjectName()}</td>
						<td>
							<table>
								<c:forEach items="${team.getMembers()}" var="member">
									<tr>
										<td>
											<c:if test="${member.getId() eq team.getIdTeamLeader() }">
												&nbsp;<i class="fa fa-star fa-fw"></i>
											</c:if>
										</td>
										<td>${member.getFirstName()} ${member.getLastName()}</td>
									</tr>
								</c:forEach>
							</table>
						</td>
						<td>${team.getAccount().getBalance()}</td>
						<td>
						<a href="${pageContext.request.contextPath}/AfficherContrat?id=${team.getId()}">Contrat</a><p>
						</td>
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