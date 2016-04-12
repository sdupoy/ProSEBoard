<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<t:main>
	<jsp:attribute name="head">
		<script	src="${pageContext.request.contextPath}/resources/js/moment.js"	type="text/javascript"></script>
		<script	src="${pageContext.request.contextPath}/resources/js/moment-fr.js" type="text/javascript"></script>
		<script src="${pageContext.request.contextPath}/resources/js/bootstrap-datetimepicker.min.js" type="text/javascript"></script>
   		<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap-datetimepicker.min.css" type="text/css">
	</jsp:attribute>
	<jsp:attribute name="publish_available">en</jsp:attribute>
	<jsp:body>
		<div class="row">
			<div class="col-sm-10 col-md-8 col-lg-6">
				<h2>Ajouter une disponibilité</h2>
				<form method="post" action="${pageContext.request.contextPath}/NewAvailable">
					<div class="row">
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
					</div>
					<div class="row">
						<div class="col-xs-12">
							<button class="btn btn-primary" type="submit">Ajouter</button>
						</div>
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
								$('#datetimepicker2').data("DateTimePicker").minDate(e.date);
							}
						);
						$("#datetimepicker2").on(
							"dp.change",
							function(e) {
								$('#datetimepicker').data("DateTimePicker").maxDate(e.date);
							}
						);
					});
				</script>
			</div>
		</div>
	</jsp:body>
</t:main>