<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<t:main>
	<jsp:attribute name="head">
	<head>
		<meta charset="utf-8" />
		<script src="${pageContext.request.contextPath}/resources/js/Chart.min.js"></script>
	</head>
	</jsp:attribute>
	<jsp:body>
		<h2>Mon équipe</h2>
		<div class="row">
			<div class="col-sm-6 col-md-6 col-lg-4">
				<div class="panel panel-default">
					<div class="panel-heading">
						<h3 class="panel-title">Infos</h3>
					</div>
					<div class="panel-body">
						<p>Nom: <b>${team.getTeamName()}</b></p>
						<p>Projet: <b>${team.getProjectName()}</b></p>
						<c:if test="${user.hasStatus('team_leader')}">
							<p>Solde: <b>
								<c:if test="${account.getBalance() < 0}">
									<font color="red"> ${account.getBalance()} € </font>
								</c:if>
								<c:if test="${account.getBalance() > 0}">
									<font color="green"> ${account.getBalance()} € </font>
								</c:if></b>
							</p>
						</c:if>
					</div>
				</div>
			</div>
			<div class="col-xs-12 col-sm-8">
				<div class="panel panel-default">
					<div class="panel-heading">
						<h3 class="panel-title">Membres</h3>
					</div>
					<div class="table-responsive">
						<table class="table table-striped table-hover">
							<c:forEach items="${team.getMembers()}" var="member">
								<tr>
									<td>
										<c:if test="${member.getId() eq team.getIdTeamLeader() }">
											&nbsp;<i class="fa fa-star fa-fw"></i>
										</c:if>
									</td>
									<td>${member.getFirstName()} ${member.getLastName()}</td>
									<td>${member.getMail() }</td>
									<td>&nbsp;<a href="${pageContext.request.contextPath}/planning?user=${member.getId()}"><i class="fa fa-calendar fa-fw"></i></a></td>
								</tr>
							</c:forEach>
						</table>
					</div>
				</div>
			</div>
			<div class="col-sm-6 col-md-6 col-lg-4">
				<div class="panel panel-default">
					<div class="panel-heading">
						<h3 class="panel-title">Mes rapports</h3>
					</div>
					<div class="panel-body">
						<p><a href="${pageContext.request.contextPath}/SeeMyAudits" class="btn btn-default">Mes audits précédents</a></p>
						<p><a href="${pageContext.request.contextPath}/SeeMyConsultations" class="btn btn-default">Mes consultations précédentes</a></p>
						<p><a href="${pageContext.request.contextPath}/SeeMyTrainings" class="btn btn-default">Mes sessions d'entraînement précédentes</a></p>
					</div>
				</div>
			</div>
			<c:if test="${user.hasStatus('team_leader')}">
				<div class="col-sm-6 col-md-6 col-lg-4">
					<div class="panel panel-default">
						<div class="panel-heading">
							<h3 class="panel-title">Rapports de mon équipe</h3>
						</div>
						<div class="panel-body">
  							<p><a href="${pageContext.request.contextPath}/SeeAuditsTL?choix=audits" class="btn btn-default">Les audits précédents</a></p>
							<p><a href="${pageContext.request.contextPath}/SeeAuditsTL?choix=consultations" class="btn btn-default">Les consultations précédentes</a></p>
							<p><a href="${pageContext.request.contextPath}/SeeAuditsTL?choix=trainings" class="btn btn-default">Les sessions d'entraînement précédentes</a></p>
						</div>
					</div>
				</div>
			</c:if>
		</div>
		<c:if test="${user.hasStatus('team_leader')}">	
			<div class="row">
				<div class="col-xs-11">
					<h3>Evolution du budget de l'équipe</h3>
					<canvas id="buyers" style="width:100%;height:400px;"></canvas>
				</div>
			</div>
			 <script>
				 var buyerData = {
		 				labels : [""],
		 				datasets : [
		 					{
		 						fillColor : "rgba(161,35,79,0.4)",
		 						strokeColor : "#381322",
		 						pointColor : "#fff",
		 						pointStrokeColor : "#381322",
		 						data : [0]
		 					}
		 				]
		 		}
				 
	    		var buyers = document.getElementById('buyers').getContext('2d');
	    		var graph = new Chart(buyers).Line(buyerData, {
	    		        bezierCurve: false,
	    		});
	    		<c:forEach items="${accountHistorys}" var="acc">
						graph.addData([${acc.getSolde()}],"${acc.getDatePrintf()}");
				</c:forEach>
			
    		
		</script>
		</c:if>
	</jsp:body>
</t:main>