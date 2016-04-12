<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="col-xs-12" style="border-left:solid 5px #7FFFD4">
	<h4>
		<c:if test="${notif.getObject().getValidation() == 1}">	
			<a href="${pageContext.request.contextPath}/AcceptConsultationOrTrainingForm"> <i class="fa fa-eye"></i> </a>
				Nouvelle demande de session d'entraînement d'une équipe
				 <small> pour ${notif.getObject().getDescription()} programmé de 
				 ${notif.getObject().getStartDateString()} à  ${notif.getObject().getEndDateString()}</small> 
		</c:if>
		<c:if test="${notif.getObject().getValidation() ==  2}">	
			<a href="${pageContext.request.contextPath}/planning"> <i class="fa fa-calendar"></i> </a>
				Demande  de session de training  <FONT color="green"> acceptée </FONT>
				 <small> pour ${notif.getObject().getDescription()} programmé de 
				 ${notif.getObject().getStartDateString()} à  ${notif.getObject().getEndDateString()}</small> 
		</c:if>	 
		<c:if test="${notif.getObject().getValidation() ==  3}">	
			<a href="${pageContext.request.contextPath}/planning"> <i class="fa fa-calendar"></i> </a>
				Demande  de session de training  <FONT color="red"> refusée </FONT>
				 <small> pour ${notif.getObject().getDescription()} programmé de 
				 ${notif.getObject().getStartDateString()} à  ${notif.getObject().getEndDateString()}</small> 
		</c:if>
		</h4>
</div>