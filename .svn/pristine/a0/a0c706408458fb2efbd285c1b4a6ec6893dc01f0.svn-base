<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:main>
	<jsp:attribute name="view_consultationOrTraining">en</jsp:attribute>
	<jsp:body>
		<div class="row">
			<div class="col-md-12 col-lg-10">
				<h2>Demandes faites par les étudiants</h2>
				<div class="form-group">
					<div class="table-responsive">
						<table class="table table-striped table-hover">
							<c:if test="${eventAll.size()>0}">	
								<tr>
									<th>Nom<th>
							        <th>Description<th>
							        <th>Date de début<th>
							        <th>Date de fin<th>
							        <th width="5%"><th>
							        <th width="5%"><th>
								</tr>
							</c:if>
							<c:forEach items="${eventAll}" var="current">
								<tr>
									<c:if test="${current.getValidation()!=3}">
						            <td><c:out value="${current.name}" /><td>
							        <td><c:out value="${current.description}" /><td>
							        <td><c:out value="${current.getStartDateString()}" /><td>
							        <td><c:out value="${current.getEndDateString()}" /><td>
							        <td>
							        	<a href="${pageContext.request.contextPath}/AcceptConsultationOrTraining?name=accept&id=${current.id}" class="btn btn-primary pull-right" >Accepter</a><p>
							        <td>
							        <td>
							        	<a href="${pageContext.request.contextPath}/AcceptConsultationOrTraining?name=refuse&id=${current.id}" class="btn btn-primary pull-right" >Refuser</a>
							        <td>
							        </c:if>
						        </tr>
						    </c:forEach>  
				        </table>
					</div>
				    
					<h4>
						<c:if test="${eventAll.size()==0}">
							<c:out value="Aucune demande à accepter" />
						</c:if>
					</h4>
				</div>
			</div>
		</div>
	</jsp:body>
</t:main>