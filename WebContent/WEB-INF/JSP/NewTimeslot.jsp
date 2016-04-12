<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:main>
	<jsp:attribute name="head">
		<script
			src="${pageContext.request.contextPath}/resources/js/bootstrap-combobox.js"
			type="text/javascript"></script>
		<link rel="stylesheet"
			href="${pageContext.request.contextPath}/resources/css/bootstrap-combobox.css"
			type="text/css">
	
	</jsp:attribute>
	<jsp:body>
		<div class="row">
			<div class="col-sm-10 col-md-8 col-lg-6">
				<h2>Nouveau Timeslot</h2>
	
				<form method="post" action="${pageContext.request.contextPath}/NewTimeslot">
					<div class="form-group">
						<h4>Nom du Timeslot</h4>
						<input class="form-control" type="text" name="name" value ="--"><br><br>
						<h4>Choisir le Timeslot associé</h4>
						<select class="combobox form-control" name="template" >
							<c:forEach items="${templates}" var="template">
									<option value="${template.getTemplateId()}">${template.getTemplateName()} </option>
							</c:forEach>
						</select>
						<br>
						<h4>Choisir le Professeur</h4>
						<select class="combobox form-control" name="user" >
							<c:forEach items="${users}" var="user">
									<option value="${user.getId()}">${user.getFirstName()} ${user.getLastName()} </option>
							</c:forEach>
						</select>
						<br>
						<h4>Nombre d'heure associé</h4>
						<input class="form-control" type="number" name="quantity" min="1"step="1" required value ="1"><br>
						<br>
					</div>
					<div class="form-group">
						<button class="btn btn-primary btn-lg pull-right" type="submit">Créer</button>
					</div>
				</form>
			</div>
		</div>
		<script type="text/javascript">
				
				$(document).ready(function() {
					$('.combobox').combobox();
				});

		</script>
	</jsp:body>
</t:main>