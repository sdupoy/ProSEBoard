<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<t:main>
<jsp:attribute name="head">

</jsp:attribute>
	<jsp:attribute name="publish_absents">en</jsp:attribute>
	
	<jsp:body>
		<div class="row">
			<div class="col-sm-10 col-md-8 col-lg-6">
				<h1>Rapport de formation - Gestion des absences</h1>
				<h2>Insérer les informations suivantes</h2>
				<form method="post" name="publierAbsences" action="${pageContext.request.contextPath}/training/manageAbsents">
					<div class="form-group">
						<div class="row">
							<div class="col-xs-6">
								
								<h4>Etudiants inscrits :</h4>
								<div class="form-group">
									<label for="absents">Selectionner les absents</label><br />
									<c:forEach items="${attenders}" var="attender">
										<c:if test="${attender.getId()!=user.getId()}">
											<input type=checkbox  name=absent[] value="${attender.getId() }" > ${attender.getFirstName()} ${attender.getLastName() }<br />
										</c:if>
									</c:forEach>
								</div>
							</div>
						</div>
					</div>
					
					<div class="form-group">
					<input type=hidden name="idTraining" value="${idTraining}">
						<button class="btn btn-primary pull-right" type="submit">Terminer la création du rapport de formation</button>
					</div>
					
				</form>
				
				<form action="${pageContext.request.contextPath}/">
				<button class="btn btn-primary" type="submit"><i class="fa fa-long-arrow-left fa-fw"></i> Annuler</button>
				</form>
			</div>
				
		</div>
	</jsp:body>
</t:main>