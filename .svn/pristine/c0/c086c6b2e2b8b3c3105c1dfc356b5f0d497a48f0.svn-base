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
				<h1>Choisir un membre de l'équipe</h1>
				<br><br>
				<c:if test="${choix == 'audits' }">
					<form method="post" action="${pageContext.request.contextPath}/SeeAuditsTL">
						<div class="form-group">
							<select class="form-control" name="user" >
								<c:forEach items="${users}" var="user">
									<c:if test="${user.getId() != idTL }">
										<option value="${user.getId()}">${user.getFirstName()} ${user.getLastName()}</option>
									</c:if>
								</c:forEach>
							</select>
						</div>
						<br><br>
						<div class="form-group">
							<button class="btn btn-primary btn-lg pull-left" type="submit">Chercher</button>
						</div>
					</form>	
				</c:if>
				<c:if test="${choix == 'consultations' }">
					<form method="post" action="${pageContext.request.contextPath}/SeeConsultings">
						<div class="form-group">
							<select class="form-control" name="user" >
								<c:forEach items="${users}" var="user">
									<c:if test="${user.getId() != idTL }">
										<option value="${user.getId()}">${user.getFirstName()} ${user.getLastName()}</option>
									</c:if>
								</c:forEach>
							</select>
						</div>
						<br><br>
						<div class="form-group">
							<button class="btn btn-primary btn-lg pull-left" type="submit">Chercher</button>
						</div>
					</form>	
				</c:if>
				<c:if test="${choix == 'trainings' }">
					<form method="get" action="${pageContext.request.contextPath}/SeeTrainings">
						<div class="form-group">
							<select class="form-control" name="user" >
								<c:forEach items="${users}" var="user">
									<c:if test="${user.getId() != idTL }">
										<option value="${user.getId()}">${user.getFirstName()} ${user.getLastName()}</option>
									</c:if>
								</c:forEach>
							</select>
						</div>
						<br><br>
						<div class="form-group">
							<button class="btn btn-primary btn-lg pull-left" type="submit">Chercher</button>
						</div>
					</form>	
				</c:if>			
			</div>
		</div>
		<script type="text/javascript">
				$(document).ready(function() {
					$('.combobox').combobox();
				});
		</script>
	</jsp:body>
</t:main>