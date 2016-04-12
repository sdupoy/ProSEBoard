<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<t:main>

	<jsp:attribute name="chargeTrainingSession">en</jsp:attribute>
	<jsp:body>
		<div class="row">
			<div class="col-sm-20 col-md-16 col-lg-12">
			<h1>Sessions facturables</h1>
			
			<table class="table table-hover table-striped">
				<thead>
					<tr>
						<th>N°</th>
						<th>Période de formation</th>
						<th>Nom de la formation</th>
						<th>Tarif horaire</th>
						<th>Heures de formation</th>
					</tr>				
				</thead>
				<c:forEach items="${sessions}" var="session">				
					<tr>
						<form method="post" name="Facturation" action="${pageContext.request.contextPath}/chargeTrainingSession">
							
						<td>${session.getId()}</td>
						<td>Du ${session.getEventBis().getStartDateString()} <br/>
							au ${session.getEventBis().getEndDateString()}</td>
						<td>${session.getSubject()}</td>
						<th>${session.getHourCost() } €</th>
						<td>
						<input class="form-control" type="number" name="nbHours" min="0.25" step="0.25" required>
						</td>
						<td> 
							<input type="hidden" name="idEventToCharge" value="${session.getId()}">
							<input type="hidden" name="hourCost" value="${session.getHourCost()}">
							<button class="btn btn-primary" type="submit"><i class="fa fa-euro fa-fw"></i> Facturer</button>	
						</td>
						</form>
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