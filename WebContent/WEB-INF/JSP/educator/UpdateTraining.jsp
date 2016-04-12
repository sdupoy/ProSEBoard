<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<t:main>
	<jsp:attribute name="head">
	<script src="${pageContext.request.contextPath}/resources/js/moment.js"
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
	<jsp:attribute name="updateTraining">en</jsp:attribute>
	<jsp:body>
		<div class="row">
			<div class="col-sm-10 col-md-8 col-lg-6">
				<h2>Modifier une formation</h2>
				<br>
				<h4>Insérer les informations suivantes</h4>
				<br>
				<form method="post" name="training"
					action="${pageContext.request.contextPath}/training/UpdateTraining">
					<div class="form-group">
						
						<p>Description de la demande : </p>
				        <div id="description">
				        	<input type='text' class="form-control" name="description"
								value="${training.getSubject() }" required />
				        </div>
						<br>
						<p>Ressources nécessaires : </p>
				        <div id="ressources">
				        	<input type='text' class="form-control" name="ressources"
								value="${training.getRessources() }" required />
				        </div>
				        <br>
						<p>Coût Horaire : </p>
				        <div id="hourCost">
				        	<input type='number' class="form-control"
								value="${training.getHourCost() }" name="hourCost" required />
				        </div>
				        <br>
						<button class="btn btn-primary pull-right" type="submit">Modifier</button>
					</div>
				</form>
			</div>
		</div>
		</jsp:body>
</t:main>