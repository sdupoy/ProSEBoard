<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:main>
	<jsp:attribute name="head">
	<script
	src="${pageContext.request.contextPath}/resources/js/moment.js"
			type="text/javascript"></script>
		<script
			src="${pageContext.request.contextPath}/resources/js/moment-fr.js"
			type="text/javascript"></script>
		<script
			src="${pageContext.request.contextPath}/resources/js/bootstrap-datetimepicker.min.js"
			type="text/javascript"></script>
   		<link rel="stylesheet"
			href="${pageContext.request.contextPath}/resources/css/bootstrap-datetimepicker.min.css"
			type="text/css">
		<script
			src="${pageContext.request.contextPath}/resources/js/bootstrap-combobox.js"
			type="text/javascript"></script>
		<link rel="stylesheet"
			href="${pageContext.request.contextPath}/resources/css/bootstrap-combobox.css"
			type="text/css">
		<script
			src="${pageContext.request.contextPath}/resources/js/jquery.chained.min.js"
			type="text/javascript"></script>
	</jsp:attribute>
	<jsp:attribute name="completeTraining">en</jsp:attribute>
	<jsp:body>
		<div class="row">
			<div class="col-sm-10 col-md-8 col-lg-6">
				<h1>Veuillez compléter les informations de la formation</h1>
				<form method="post" name="validation" action="${pageContext.request.contextPath}/training/CompleteTraining">
				<div class="form-group">
					<p>Type de demande : </p>
					<input type="text" class="form-control" name="eventType" value="Formation" disabled="disabled"/>
					<br>
					<p>Sujet : </p>
					<input type="text" class="form-control" name="subject" value="${training.getSubject()}" disabled="disabled"/>
					<br>
					<p>Ressources : </p>
					<input type="text" class="form-control" name="ressources" placeholder="Ressources" />
					<br>
					<p>Prix horaire :</p> 
					<input type="number" name="hourCost" class="form-control" required/>
					<br>
					<button class="btn btn-primary pull-right" type="submit">Valider la demande</button>
				</div>
				</form>
			</div>
		</div>
		</jsp:body>
</t:main>