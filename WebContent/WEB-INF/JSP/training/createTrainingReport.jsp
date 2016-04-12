<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<t:main>
<jsp:attribute name="head">

</jsp:attribute>
	<jsp:attribute name="create_trainingReport">en</jsp:attribute>
	
	<jsp:body>
		<div class="row">
			<div class="col-sm-10 col-md-8 col-lg-6">
				<h1>Rapport de formation</h1>
				<h2>Insérer les informations suivantes</h2>
				<form method="post" name="creerRapportFormateur" action="${pageContext.request.contextPath}/CreateTrainingReport">
					<div class="form-group">
						<div class="row">
							<div class="col-xs-6">
								<h4>Séance de formation concernée</h4>
								<div class="form-group">
									<select class="form-control" name="idTraining" id="idTraining"> 
										<c:forEach items="${trainings}" var="training">
												<option value="${training.getId()}">${training.getSubject()}
													<c:if test="${not training.isCharged()}">
														 - Séance non facturée !
													</c:if>
												</option>	
										</c:forEach>
									</select> 
								</div>
							</div>
						</div>
					</div>
					<h4>Rapport de la séance</h4>
					<div class="form-group">
						<textarea class="form-control" name="report" rows="8" cols="80" id="report" required></textarea>
                    </div>
					
					<div class="form-group">
						<button class="btn btn-primary pull-right" type="submit">Créer le rapport et passer à la gestion des absents</button>
					</div>
					
				</form>
				
				<form action="${pageContext.request.contextPath}/">
					<div class="form-group">
						<button class="btn btn-primary pull-left" type="submit"><i class="fa fa-long-arrow-left fa-fw"></i> Annuler</button>
					</div>
				</form>
			</div>
				
		</div>
	</jsp:body>
</t:main>