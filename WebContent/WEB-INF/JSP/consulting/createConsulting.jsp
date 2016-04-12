<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<t:main>
<jsp:attribute name="head">
<script
	src="${pageContext.request.contextPath}/resources/js/jquery.chained.min.js"
	type="text/javascript">
</script>
</jsp:attribute>
	<jsp:attribute name="create_consultingReport">en</jsp:attribute>
	
	<jsp:body>
		<div class="row">
			<div class="col-sm-10 col-md-8 col-lg-6">
				<h1>Rapport de consultation</h1>
				<h2>Insérer les informations suivantes</h2>
				<form method="post" name="creerRapportConsultant"
					action="${pageContext.request.contextPath}/consultation/creer">
					<div class="form-group">
						<div class="row">
							<div class="col-xs-6">
								Session
								<div class="form-group">
									 <select class="form-control" name="idSession" id="idSession">
										<c:forEach items="${sessions}" var="session">
											<option value="${session.getId()}">${session.getName()}</option>
										</c:forEach>
									</select>
								</div>
								Equipe
								<div class="form-group">
									<select class="form-control" name="idTeam" id="idTeam">
										<c:forEach items="${teams}" var="team">
											<option value="${team.getId()}" class="${team.getSession(team.getId())}">${team.getTeamName()} - ${team.getProjectName()}</option>
										</c:forEach>
									</select> 
								</div>
								Séance de consulting concernée
								<div class="form-group">
									<select class="form-control" name="idConsult" id="idConsult"> 
										<c:forEach items="${consults}" var="consult">
											
												<option value="${consult.getId()}" class="${consult.getIdTeamByIdConsult(consult.getId())}">${consult.getEvent().getDescription()}
													<c:if test="${not consult.isCharged()}">
														 - Séance non facturée !
													</c:if>
												</option>	
											
										</c:forEach>
									</select> 
								</div>
							</div>
						</div>
						<br>
						
						</div>
				
					<div class="form-group">
						<TEXTAREA name="report" rows="8" cols="80" id="report" required></textarea>
                    </div>
					
					<div class="form-group">
						<button class="btn btn-primary pull-right" type="submit">Créer</button>
					</div>
				</form>
				<form action="${pageContext.request.contextPath}/">
				<button class="btn btn-primary" type="submit"><i class="fa fa-long-arrow-left fa-fw"></i> Annuler</button>
				</form>
			</div>
				
		</div>
		<script type="text/javascript">
	$( document ).ready(function() {
		$("#idTeam").chained("#idSession");	
		$("#idConsult").chained("#idTeam");	
	});
	</script>
	</jsp:body>
</t:main>