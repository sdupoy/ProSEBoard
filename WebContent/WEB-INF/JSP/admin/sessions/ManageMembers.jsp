<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>

<t:main>
	<jsp:attribute name="head">
		<script src="${pageContext.request.contextPath}/resources/js/bootstrap-combobox.js" type="text/javascript"></script>
		<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap-combobox.css" type="text/css">
	</jsp:attribute>
	<jsp:body>
		<div class="row">
			<div class="col-xs-12">
				<h1>Gestion des membres de ${editTeam.getTeamName()} de ${editTeam.getSession().getName()}</h1>
				<c:if test="${ !empty errorMsg }">
	           		<div class="alert alert-danger" role="alert">${errorMsg}</div>       
	           	</c:if>
	           	<table class="table table-striped table-hover">
	           		<c:forEach items="${editTeam.getMembers()}" var="member">
	           			<tr>
	           				<td>
	           					${member.getFirstName()} ${member.getLastName()}
	           					<c:if test="${editTeam.getIdTeamLeader() eq member.getId()}"><i class="fa fa-star"></i></c:if>
	           				</td>
	           				<td>
	           					<form method="post" action="${pageContext.request.contextPath}/ManageMembers">
	           						<input type="hidden" name="idTeam" value="${editTeam.getId()}"/>
	           						<input type="hidden" name="idMember" value="${member.getId()}"/>
	           						<input type="hidden" name="idSession" value="${editTeam.getIdSession()}"/>
	           						<input type="hidden" name="delete" value="1"/>
				  					<button class="btn btn-danger" type="submit"><i class="fa fa-times"></i></button>
								</form>
	           				</td>
	           				<td>
	           					<c:if test="${member.getId() eq editTeam.getId()}">Chef d'équipe</c:if>
	           				</td>
           				</tr>
		  			</c:forEach>
	           	</table>
				<form method="post" action="${pageContext.request.contextPath}/ManageMembers">
					<label>Sélectionnez un étudiant à ajouter</label>
					<div class="form-group">
						<div class="row">
							<div class="col-xs-8 col-sm-4">
								<select class="combobox form-control" name="idMember" required>
									<option></option>
									<c:forEach items="${students}" var="student">
										<option value="${student.getId()}">${student.getLastName()} ${student.getFirstName()}</option>
									</c:forEach>
								</select>
							</div>
							<div class="col-xs-2 col-sm-3">
								<input type="hidden" name="idTeam" value="${editTeam.getId()}"/>
								<input type="hidden" name="idSession" value="${editTeam.getIdSession()}"/>
								<button class="btn btn-primary" type="submit">Ajouter à l'équipe</button>
							</div>
						</div>
					</div>
				</form>
			</div>
		</div>
		<div class="row">
			<div class="col-xs-12">
				<p><a href="${pageContext.request.contextPath}/ManageTeams?idSession=${editTeam.getIdSession()}" class="btn btn-default">Revenir à la gestion des équipes</a></p>
			</div>
		</div>
		<script type="text/javascript">	
		$(function() {
			$(document).ready(function() {
				$('.combobox').combobox().focus(function(){
					$(this).parent().find(".input-group-addon .dropdown-toggle").click();
				});
			});
		});
		</script>
	</jsp:body>
</t:main>
