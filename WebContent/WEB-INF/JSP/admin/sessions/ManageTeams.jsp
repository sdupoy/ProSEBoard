<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>

<t:main>
	<div class="row">
		<div class="col-xs-12">
			<h2>Gestion des équipes de ${sessionName}</h2>
			<div class="row">
				<c:forEach items="${teams}" var="team">
					<div class="col-sm-12 col-md-6 col-lg-4">
						<div class="panel panel-default">
							<div class="panel-body">
								<span class="label label-success pull-right">${team.getMembers().size()}</span>
								<h4><b>${team.getTeamName()}</b></h4>
								<c:if test="${team.getMembers().size() > 0}">
									<ul>
										<c:forEach items="${team.members}" var="member">
					  						<li>${member.getFirstName()} ${member.getLastName()}</li>
					  					</c:forEach>
									</ul>
								</c:if>
					  			<div class="btn-group" role="group" aria-label="actions">
					  				<a href="${pageContext.request.contextPath}/ManageMembers?idTeam=${team.getId()}" class="btn btn-default"><i class="fa fa-edit fa-fw"></i> Modifier</a>
					  				<a href="${pageContext.request.contextPath}/DeleteTeam?idTeam=${team.getId()}" class="btn btn-danger"><i class="fa fa-trash fa-fw"></i> Supprimer</a>
								</div>	
				  			</div>
			  			</div>
		  			</div>
	  			</c:forEach>
			</div>
			<div class="btn-group" role="group" aria-label="actions">
				<a href="${pageContext.request.contextPath}/ManageSessions" class="btn btn-default"><i class="fa fa-arrow-left fa-fw"></i> Revenir aux sessions</a>
				<a href="${pageContext.request.contextPath}/CreateTeam?idSession=${idSession}" class="btn btn-primary">Créer une nouvelle équipe</a>
			</div>
		</div>
	</div>
</t:main>