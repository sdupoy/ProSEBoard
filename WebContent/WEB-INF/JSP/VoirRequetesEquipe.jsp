<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<t:main>
<jsp:attribute name="head">
<script
	src="${pageContext.request.contextPath}/resources/js/jquery.chained.min.js"
	type="text/javascript">
</script>
</jsp:attribute>
<jsp:attribute name="see_request_team">en</jsp:attribute>
<jsp:body>
	<div class="row">
		<div class="col-sm-10 col-md-8 col-lg-6">
			<h1>Choisir l'historique d'une équipe</h1>
			<form method="get" action = "${pageContext.request.contextPath}/VoirRequetesEquipe">
			
			</form>
			<form method="post" action = "${pageContext.request.contextPath}/VoirRequetesEquipe">
				<div class="form-group">
					 <select class="form-control" name="idSession" id="idSession">
						<c:forEach items="${sessions}" var="session">
								<option value="${session.getId()}">${session.getName()}</option>
						</c:forEach>
					</select>
				</div>
				<div class="form-group">
					<select class="form-control" name="idTeam" id="idTeam">
						<c:forEach items="${teams}" var="team">
								<option value="${team.getIdTeamLeader()}" class="${team.getSession(team.getId())}">${team.getTeamName()}</option>
						</c:forEach>
					</select> 
				</div>
				<h4><small>
				<button class="btn btn-primary" type="submit">Chercher</button>
			</small></h4>
			</form>
		</div>
	</div>
	<script type="text/javascript">
	$( document ).ready(function() {
		$("#idTeam").chained("#idSession");
					
	});
	</script>
</jsp:body>	
</t:main>