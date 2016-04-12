<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>

<t:main>
	<jsp:attribute name="head">
		<script src="${pageContext.request.contextPath}/resources/js/moment.js" type="text/javascript"></script>
		<script src="${pageContext.request.contextPath}/resources/js/moment-fr.js" type="text/javascript"></script>
		<script src="${pageContext.request.contextPath}/resources/js/bootstrap-datetimepicker.min.js" type="text/javascript"></script>
		<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap-datetimepicker.min.css" type="text/css">
	</jsp:attribute>
	<jsp:body>
		<div class="row">
			<div class="col-sm-10 col-md-8 col-lg-6">
				<h2>Créer une session</h2>
				<c:if test="${ !empty errorMsg }">
	            	<div class="alert alert-danger" role="alert">${errorMsg}</div>       
	            </c:if>
				<form method="post" action="${pageContext.request.contextPath}/CreateSession">
					<div class="form-group">
						<input type="text" class="form-control" name="sessionName" placeholder="Nom" required>
					</div>
					<div class="form-group">
						<div class="row">
							<div class="col-lg-6">
								<div class='input-group date' id='datetimepicker1'>
									<span class="input-group-addon"><i class="fa fa-calendar fa-fw"></i></span>
									<input type='text' class="form-control" name="startDate" placeholder="Date de début" required />
								</div>
							</div>
							<div class="col-lg-6">
								<div class='input-group date' id='datetimepicker2'>
									<span class="input-group-addon"><i class="fa fa-calendar fa-fw"></i></span>
									<input type='text' class="form-control" name="endDate" placeholder="Date de fin" required />
								</div>
							</div>
						</div>
					</div>
					<div class="form-group">
						<div class="btn-group" role="group" aria-label="actions">
							<a href="${pageContext.request.contextPath}/ManageSessions" class="btn btn-default">Revenir aux sessions</a>
							<button name="buttonCreateSession" value="createSession" class="btn btn-primary" type="submit">Créer la session</button>
						</div>
					</div>
				</form>
			</div>
		</div>
		<script type="text/javascript">
			$(function() {
				
				$('#datetimepicker1').datetimepicker({
					locale: 'fr',
					format: 'L'
				}).on("dp.change", function (e) {
		            $('#datetimepicker2').data("DateTimePicker").minDate(e.date);
		        });
				$('#datetimepicker2').datetimepicker({
					locale : 'fr',
					format: 'L'
				}).on("dp.change", function (e) {
		            $('#datetimepicker1').data("DateTimePicker").maxDate(e.date);
		        });
				$('#datetimepicker1 input').focus(function(){
					$(this).parent().find('.input-group-addon').click();
				});
				$('#datetimepicker2 input').focus(function(){
					$(this).parent().find('.input-group-addon').click();
				});
			});
		</script>
	</jsp:body>
</t:main>