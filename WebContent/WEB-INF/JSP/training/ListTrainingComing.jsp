<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<t:main>
	<jsp:attribute name="see_training">en</jsp:attribute>
	<jsp:body>
		<div class="row">
			<div class="col-sm-20 col-md-16 col-lg-12">
				<h2>Listes des sessions de formation à venir</h2>
				<div class="form-group">
					<div class="table-responsive">
						<table class="table table-striped table-hover">
							<c:if test="${allTraining.size()>0}">	
								<tr>
									<th>Sujet</th>
									
									<th>Formateur</th>
																		
									<th>Ressources nécessaires</th>
									
									<th>État</th>
									
									<th>Participants</th>
									
									<th>Date début</th>
									
									<th>Date fin</th>
								
								</tr>
							</c:if>
							<c:forEach items="${allTraining}" var="current">
								<tr>
						        	<td>
								        <h5>${current.getSubject()}</h5>
							        </td>
							        <td>
							        	<h5>${current.getEducator().getFirstName()} ${current.getEducator().getLastName()}</h5>
							        </td>
							        <td>
								        <c:if test="${current.getRessources()!=null}"><h5>${current.getRessources()}</h5></c:if>
								        <c:if test="${current.getRessources()==null}"><h5>Pas de ressources nécessaires</h5></c:if>
							        </td>
							        <td>
							        	<c:if test="${current.attendTo(user)==true}"><h5>Inscrit</h5></c:if>
								        <c:if test="${current.attendTo(user)==false}"><h5>Non Inscrit</h5></c:if>
								        
							        </td>
							        <td>
							        	<h5>
								        	<c:forEach items="${current.getAttendersFromTeam(user)}" var="attender" varStatus="status">
								        		${attender.getFirstName()} ${attender.getLastName()} <c:if test="${!status.last}"> / </c:if> 
								        	</c:forEach>
								        </h5>
							        </td>
							        <td>
								        <h5>${current.getEvent().getStartDateString()}</h5>
							        </td>
							        <td>
								        <h5>${current.getEvent().getEndDateString()}</h5>
							        </td>
						        </tr>
						    </c:forEach>  
				        </table>
					</div>
				    
					<h4>
						<c:if test="${allTraining.size()==0}">Aucune session de formation</c:if>
					</h4>
				</div>
			</div>
		</div>
	</jsp:body>
</t:main>