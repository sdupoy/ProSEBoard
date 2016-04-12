<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>

<t:main>
	<jsp:attribute name="head">
		<script src="${pageContext.request.contextPath}/resources/js/bootstrap-combobox.js" type="text/javascript"></script>
		<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap-combobox.css" type="text/css">
	</jsp:attribute>
	
	<jsp:body>	
		<div class="row">
			<div class="col-sm-10 col-md-10 col-lg-10">
				<h1>Créer une équipe</h1><br>
				<c:if test="${ !empty errorMsg }">
	            	<div class="alert alert-danger" role="alert">${errorMsg}</div>       
	            </c:if> 
				<form method="post" action="CreateTeam">
					<div class="form-group">
						<div class="row">
							<div class="col-sm-6">
								<label>Client de l'équipe</label>
								<select class="combobox form-control" name="idClient" required>
									<c:forEach items="${clients}" var="client">
										<option></option>
										<option value="${client.getId()}"><c:out value="${client.getLastName()} ${client.getFirstName()}"/></option>
									</c:forEach>
								</select>
							</div>
							<div class="col-sm-6">
								<label>Chef de projet</label>
								<select class="combobox form-control" name="idTeamLeader" required>
									<c:forEach items="${students}" var="student">
										<option></option>
										<option value="${student.getId()}"><c:out value="${student.getLastName()} ${student.getFirstName()}"/></option>
									</c:forEach>
								</select>
							</div>
						</div>
					</div>
					<div class="form-group">
						<div class="input-group">
							<span class="input-group-addon">Nom d'équipe</span> 
							<input type="text" class="form-control" name="teamName" aria-describedby="sizing-addon1" placeholder="Nom d'équipe" required>
						</div>
					</div>
					<div class="form-group">
						<div class="input-group">
							<span class="input-group-addon">Solde initial accordé en euros</span> 
							<input type="text" class="form-control" name="balance" placeholder="0.00" required>
						</div>
					</div>
					<div class="form-group">
						<div class="btn-group" role="group" aria-label="actions">
							<a href="${pageContext.request.contextPath}/ManageTeams?idSession=${idSession}" class="btn btn-default"><i class="fa fa-arrow-left fa-fw"></i> Revenir à la gestion des équipes</a>
							<button name="idSession" value="${idSession}" class="btn btn-primary" type="submit">Créer l'équipe</button>
						</div>
					</div>
				</form>
			</div>
		</div>
		<script type="text/javascript">	
		$(function() {
			$(document).ready(function() {
				$('.combobox').combobox();
			});		
		});
		</script>
	</jsp:body>
</t:main>