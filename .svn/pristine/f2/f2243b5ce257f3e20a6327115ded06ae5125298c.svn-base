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
		<script
			src="${pageContext.request.contextPath}/resources/js/jquery.chained.min.js"
			type="text/javascript"></script>
		<style>
		.visible{
			display:visible;
		}
		
		.hidden{
			display:none;
		}
		</style>
  	</jsp:attribute>
	<jsp:attribute name="book_consultationOrTraining">en</jsp:attribute>
	<jsp:body>
		<div class="row">
			<div class="col-sm-10 col-md-8 col-lg-6">
				<h2>Chercher les consultations possibles</h2>
				<form method="post" name="expertise"
					action="${pageContext.request.contextPath}/TeamLeader/ReservationConsultation">
					<div class="form-group">
						<h4>Type de consultation</h4>
				        <select class="form-control" id="mark"
							name="eventType">
				        	<option value="">--</option>
				        	<option value="3">Consulting</option>
				        	<option value="7">Cours</option>
						</select>
						
						<h4>Enseignant</h4>
						<select class="form-control" id="series" name="idUser">
							<option value="">--</option>
							<c:forEach items="${userTeacher}" var="teacher">
								<option value="${teacher.getId()}" class="3">${teacher.getFirstName()} ${teacher.getLastName()}</option>
							</c:forEach>
							<c:forEach items="${userConsultant}" var="consultant">
								<option value="${consultant.getId()}" class="7">${consultant.getFirstName()} ${consultant.getLastName()}</option>
							</c:forEach>
						</select>
						 

						
						
						
						<h4>Domaine d'expertise</h4>
						<select class="form-control" id="idExpertise"
							name="idExpertise">
							<option value="">--</option>
							<c:forEach items="${expertiseAll}" var="expertise">
								<c:forEach items="${users}" var="user">
									<c:forEach items="${expertiseUser}" var="expUser">
										<c:if test="${user.getId()==expUser.getIdUser()}">
											<c:if test="${expertise.getIdExp()==expUser.getIdExp()}">
												<option value="${expertise.getIdExp()}" class="${user.getId()}">${expertise.getName()}</option>
											</c:if>
										</c:if>
									</c:forEach>
								</c:forEach>
							</c:forEach>
						</select>
						
				        
				        <h4>Description de la demande</h4>
				        <div id="description">
				        	<textarea class="form-control" name="description"
								required></textarea>
				        </div>
				        <div class="row">
				        	<div class="col-xs-12">
				        		<h4>Date</h4>
			        		</div>
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
						<br>
						<button class="btn btn-primary pull-right"  type="submit">Créer</button>
					</div>
				</form>
				<br><br>
				<form method="get" action="${pageContext.request.contextPath}/SeeAvailable">
							<button class="btn btn-primary dropdown-toggle" type="submit">
    							<i class="fa fa-info-circle fa-fw"></i> Voir les disponiblités mises à disposition
							</button>
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
						

						// chained select
						//$("#idUser").chained("#eventType");
						//$("#eventType2").chained("#eventType");
						$("#series").chained("#mark");
						$("#idExpertise").chained("#series");
						/*
						// sort list
						var my_options = $(".sort option");
						my_options.sort(function(a,b) {
						    if (a.text > b.text) return 1;
						    else if (a.text < b.text) return -1;
						    else return 0
						})
						$(".sort").empty().append(my_options);

						// run chosen plugin
						$(".sort").chosen({no_results_text: "No results matched"});
						 */
					});
				</script>
			</div>
		</div>
	</jsp:body>
</t:main>

