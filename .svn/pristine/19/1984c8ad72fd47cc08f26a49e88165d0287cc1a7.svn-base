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
  	</jsp:attribute>
	<jsp:attribute name="planifier_audit">en</jsp:attribute>
	<jsp:body>
		<div class="row">
			<div class="col-sm-10 col-md-8 col-lg-6">
				<h2>Planification d'un Audit</h2>
				<form method="get" action = "${pageContext.request.contextPath}/PlanifierAudit">
			
				</form>
				<form method="post" name="expertise"
					action="${pageContext.request.contextPath}/PlanifierAudit">
					<select class="form-control" name="idTeam" >
							<c:forEach items="${teams}" var="team">
									<option value="${team.getId()}">${team.getTeamName()}</option>
							</c:forEach>
				</select>
						<br>
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
						<button class="btn btn-primary pull-right" type="submit">Planifier</button>
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

					});
				</script>
			</div>
		</div>
	</jsp:body>
</t:main>
