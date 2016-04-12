<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>

<t:main>
	<div class="row">
		<div class="col-sm-10 col-md-10 col-lg-10">	
			<h1>Voulez-vous vraiment supprimer l'equipe <c:out value="${team.getTeamNumber()}"/> ?</h1>		
			<br><form method="post" action="DeleteTeam"><button name="idTeam" class="btn btn-lg btn-danger" value="${team.getId()}" type="submit">Supprimer</button></form>						
			<br><form method="get" action="ManageTeams"><button name="idSession" class="btn btn-lg btn-danger" value="${team.getIdSession()}" type="submit">Revenir à la gestion des équipes</button></form>
		</div>
	</div>
</t:main>