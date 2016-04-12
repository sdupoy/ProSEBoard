<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:main>
	<jsp:attribute name="publish_training">en</jsp:attribute>
	<jsp:body>
		<div class="row">
			<div class="col-md-12 col-lg-10">
				<h2>Formations à valider ou modifier</h2>
				<div class="form-group">
					<div class="table-responsive">
						<table class="table table-striped table-hover">
							<c:if test="${eventAll.size()>0}">	
								<tr>
									<th><th>
							        <th><th>
							        <th><th>
							        <th><th>
								</tr>
							</c:if>
							<c:forEach items="${allTraining}" var="current">
								<tr>
						            <td><c:out value="${current.subject}" /><td>
						            <c:if test="${current.getEvent().getValidation()==0}">
							        	<td >
									        <h5>Non publié</h5>
								        </td>
								        <td>
							        		<a href="${pageContext.request.contextPath}/Educator/PublishTraining?name=publish&id=${current.getEvent().getId()}" class="btn btn-primary pull-right" >Publier</a><p>
							        	<td>
								    </c:if>
								    <c:if test="${current.getEvent().getValidation()!=0}">
							        	<td >
									        <h5>Publié</h5>
								        </td>
								        <td><td>
								    </c:if>
							        <td>
							        	<a href="${pageContext.request.contextPath}/Educator/PublishTraining?name=modify&eventId=${current.getEvent().getId()}" class="btn btn-primary pull-right" >Modifier</a>
							        <td>
						        </tr>
						    </c:forEach>  
				        </table>
					</div>
				    
					<h4>
						<c:if test="${allTraining.size()==0}">Aucun training</c:if>
					</h4>
				</div>
			</div>
		</div>
	</jsp:body>
</t:main>