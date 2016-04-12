<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<t:main>
<jsp:attribute name="head">
	<script src="${pageContext.request.contextPath}/resources/js/bootstrap-combobox.js"
			type="text/javascript"></script>
	<link rel="stylesheet"
			href="${pageContext.request.contextPath}/resources/css/bootstrap-combobox.css"
			type="text/css">
	<script src="${pageContext.request.contextPath}/resources/js/jquery.chained.min.js"
			type="text/javascript"></script>
</jsp:attribute>

<jsp:attribute name="view_account">en</jsp:attribute>
	<jsp:body>
	<div class="row">
		<div class="col-sm-10 col-md-8 col-lg-6">

		<h2>Compte des équipes</h2>
		<form method="post" action="${pageContext.request.contextPath}/ServletPublishAccountTeam">

			<br>
			<h4>Choix de la session</h4>		
			<select class="form-control" id="idSession" name="idSession">
				<option value="">--</option>
				<c:forEach items="${sessionAll}" var="session">
					<option value="${session.getId()}"> ${session.getName()}</option>
				</c:forEach>
			</select><br>

			<h4>Choix de la team</h4>	
			<select class="form-control" id="idTeam" name="Team">
				<option value="">--</option>
				<c:forEach items="${teamAll}" var="team">
					<option value="${team.getId()}" class="${team.getSession(team.getId())}"> ${team.getTeamName()} - ${team.getProjectName()}</option>
				</c:forEach>
			</select><br>

			<br>
			
			<div class="form-group">
				<button class="btn btn-primary pull-right" type="submit">Voir le solde du compte</button>
			</div>
			
			<script type="text/javascript">
				$(function() {
					
					$("#idTeam").chained("#idSession");
				});
			</script>
		</form>	
	</div>
	</div>
	</jsp:body>
</t:main>