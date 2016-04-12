<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>

<t:main>
<jsp:attribute name="head">
		<script src="${pageContext.request.contextPath}/resources/js/bootstrap-combobox.js" type="text/javascript"></script>
		<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap-combobox.css" type="text/css">
	</jsp:attribute>
	<jsp:body>
		<h2>Choisir un modèle de session pour ${session.getName() }</h2>
		<div class="row">
			<div class="col-xs-12">
				<div class="row">
					<form method="post" action="${pageContext.request.contextPath}/session/create/template">
						<div class="col-xs-6">
							<select class="combobox form-control" name="idTemplate">
								<c:forEach items="${templates}" var="template">
									<option value="${template.getTemplateId()}">${template.getTemplateName()}</option>
								</c:forEach>
							</select>
						</div>
						<div class="col-xs-6">
							<button type="submit" class="btn btn-primary">Envoyer</button>
							<a class="btn btn-default">Non merci, la suite <i class="fa fa-arrow-right"></i></a>					
						</div>
					</form>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-xs-12">
				<h3>Modèles disponibles</h3>
				<div class="row">
					<c:forEach items="${templates}" var="template">
						<div class="col-sm-12 col-md-6 col-lg-4">
							<div class="panel panel-default">
								<div class="panel-body">
									<h4>
										<b>${template.getTemplateName()}</b>
									</h4>
									<ul>
										<c:forEach items="${template.getTimeslots()}" var="timeslot">
											<li>
												<b>${getQuantity()}</b> 
												heures de <b>${timeslot.getTimeslotName()}</b> 
												avec <b>${timeslot.getTeacher.getFirstName()} ${timeslot.getTeacher.getLastName()}</b>
											</li>
										</c:forEach>
									</ul>
								</div>
							</div>
						</div>
					</c:forEach>
				</div>
			</div>
		</div>
		<script type="text/javascript">
			$(document).ready(function() {
				$('.combobox').combobox();
			});
		</script>
	</jsp:body>
</t:main>