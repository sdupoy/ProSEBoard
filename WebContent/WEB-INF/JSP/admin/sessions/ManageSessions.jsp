<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>

<t:main>
	<div class="row">
		<div class="col-xs-12">
			<h2>Gestion des sessions</h2>
			<div class="row">
				<div class="col-xs-12">
					<div class="alert alert-danger">
						Une seule session est ouverte à la fois. Ouvrir une session ferme la précédente.
					</div>					
				</div>
			</div>

			<div class="row">
				<c:forEach items="${sessions}" var="session">
					<div class="col-sm-12 col-md-6 col-lg-4">
						<div class="panel panel-default">
							<div class="panel-body">
								<div class="pull-right">
									<c:choose>
										<c:when test="${session.isOpen()}">
											<span class="fa fa-circle fa-fw text-success" aria-hidden="true"></span>											
										</c:when>
										<c:otherwise>
											<span class="fa fa-circle fa-fw" aria-hidden="true"></span>
										</c:otherwise>
									</c:choose>
								</div>
								<h4><b>${session.getName()}</b></h4>
								<p><b>${session.getNbTeam()}</b> équipes du <b>${session.getSlashStartDate()}</b> au <b>${session.getSlashEndDate()}</b></p>
								<div class="btn-group" role="group" aria-label="actions">
									<a href="${pageContext.request.contextPath}/ManageTeams?idSession=${session.getId()}" class="btn btn-default">équipes</a>
									<a href="#" class="btn btn-default disabled">planning</a>
									<c:choose>
										<c:when test="${session.isOpen()}">
											<a href="${pageContext.request.contextPath}/session/fermer?id=${session.getId()}" class="btn btn-danger">Fermer</a>
										</c:when>
										<c:otherwise>
											<a href="${pageContext.request.contextPath}/session/ouvrir?id=${session.getId()}" class="btn btn-primary">Ouvrir</a>
										</c:otherwise>
									</c:choose>
						    	</div>
							</div>
						</div>
			    	</div>
				</c:forEach>
			</div>
			<a href="CreateSession" class="btn btn-primary">Créer une session</a>		
		</div>
	</div>
</t:main>