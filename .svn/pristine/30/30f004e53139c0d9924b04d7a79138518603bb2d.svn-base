<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
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
  	</jsp:attribute>
	<jsp:attribute name="create_training">en</jsp:attribute>
	<jsp:body>
		<div class="row">
			<div class="col-sm-10 col-md-8 col-lg-6">
				<h2>Créer un training</h2>
				<h4>Insérer les informations suivantes</h4>
				<form method="post" name="expertise"
					action="${pageContext.request.contextPath}/Educator/CreateTraining">
					<div class="form-group">
						<p>Domaine d'expertise: </p>
						<select class="combobox form-control" id="idExpertise"
							name="idExpertise">
							<option value="">--</option>
							<c:forEach items="${expertiseTeacher}" var="expertise">
								<option value="${expertise.getIdExp()}">${expertise.getName()}</option>
							</c:forEach>
						</select><br>
						<p>Description de la formation : </p>
				        <div id="description">
				        	<input type='text' class="form-control" name="description"
								required />
				        </div>
						<br>
						<p>Ressources nécessaires : </p>
				        <div id="description">
				        	<input type='text' class="form-control" name="ressources"
								required />
				        </div>
				        <br>
						<p>Coût Horaire : </p>
				        <div id="description">
				        	<input type='number' class="form-control" name="ressources"
								required />
				        </div>
				        <br>
						<p>Date : </p>
						<div class='col-sm-6'>
					        <div class="form-group">
					            <div class='input-group date' id='datetimepicker'>
					                <input type='text' class="form-control"
										placeholder="Début" name="start" required />
					                <span class="input-group-addon">
					                    <i class="fa fa-calendar fa-fw"></i>
					                </span>
					            </div>
					        </div>
					    </div>
					    <div class='col-sm-6'>
					        <div class="form-group">
					            <div class='input-group date' id='datetimepicker2'>
					                <input type='text' class="form-control"
										placeholder="Fin" name="end" required />
					                <span class="input-group-addon">
					                    <i class="fa fa-calendar fa-fw"></i>
					                </span>
					            </div>
					        </div>
					    </div>
						<br>
						<button class="btn btn-primary pull-right" type="submit">Créer</button>
					</div>
				</form>
				<script type="text/javascript">
					$(function() {

						$('#datetimepicker').datetimepicker({
							locale : 'fr'
						});
						$('#datetimepicker2').datetimepicker({
							locale : 'fr'
						});
						$("#datetimepicker").on(
								"dp.change",
								function(e) {
									$('#datetimepicker2')
											.data("DateTimePicker").minDate(
													e.date);
								});
						$("#datetimepicker2").on(
								"dp.change",
								function(e) {
									$('#datetimepicker').data("DateTimePicker")
											.maxDate(e.date);
								});

						$(document).ready(function() {
							$('.combobox').combobox();
						});
					});
				</script>
			</div>
		</div>
	</jsp:body>
</t:main>

