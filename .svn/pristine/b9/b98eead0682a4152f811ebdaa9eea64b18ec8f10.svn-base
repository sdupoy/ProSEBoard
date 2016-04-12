<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:main>
	<jsp:attribute name="view_consultationOrTraining">en</jsp:attribute>
	<jsp:body>
		<div class="row">
			<div class="col-xs-12">
				<h2>Demandes des membres de l'équipe</h2>
				<div class="form-group">
					<div class="table-responsive">
						<table class="table table-striped table-hover">
							<c:if test="${eventAll.size()>0}">	
								<tr>
									<th>Nom</th>
							        <th>Description</th>
							        <th>Date début</th>
							        <th>Date fin</th>
							        <th>Etat</th>
							        <th style="min-width:50px;">Action</th>
								</tr>
							</c:if>
							<c:forEach items="${eventAll}" var="current">
								<tr>
						            <td >${current.name}</td>
							        <td >${current.description}</td>
							        <td >${current.getStartDateString()}</td>
							        <td >${current.getEndDateString()}</td>
							        <c:if test="${current.validation==0}">
							        	<td>
									        <h5>Non validé</h5>
								        </td>
								        <td>
								        	<div class="btn-group" role="group">
								        		<a href="${pageContext.request.contextPath}/TeamLeader/ValidateConsultationOrTraining?name=accept&id=${current.id}" class="btn btn-primary pull-left" ><span class="hidden-xs">Accepter</span><i class="visible-xs fa fa-check"></i></a>
								        		<a href="${pageContext.request.contextPath}/TeamLeader/ValidateConsultationOrTraining?name=refuse&id=${current.id}" class="btn btn-primary pull-left" ><span class="hidden-xs">Refuser</span><i class="visible-xs fa fa-close"></i></a>
								        	</div>
								        </td>
								    </c:if>
							        <c:if test="${current.validation==1}">
								        <td >
									        <h5><FONT color="orange">Validé</FONT></h5>
								        </td>
								        <td>
								        </td>
							        </c:if>
							        <c:if test="${current.validation==2}">
								        <td >
									        <h5><FONT color="green"> Acceptée </FONT></h5>
								        </td>
								        <td>
								        </td>
							        </c:if>
							        <c:if test="${current.validation==3}">
								        <td >
									        <h5><FONT color="red">Refusée</FONT></h5>
								        </td>
								        <td>
								        </td>
							        </c:if>
						        </tr>
						    </c:forEach>  
				        </table>
					</div>
					<c:if test="${eventAll.size()==0}">
						<h4>Aucune demande à valider</h4>
					</c:if>
				</div>
			</div>
		</div>
	</jsp:body>
</t:main>