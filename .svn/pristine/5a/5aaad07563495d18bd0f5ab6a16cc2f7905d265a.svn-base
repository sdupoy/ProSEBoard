<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<t:main>
<jsp:attribute name="see_audits_client">en</jsp:attribute>
<jsp:body>
	<div class="row">
		<div class="col-sm-10 col-md-8 col-lg-6">
			<h1>Liste Audits de mes équipes </h1>
			<h4><small>
			<form method="get" action = "${pageContext.request.contextPath}/SeeAuditClient">
					<input type="hidden" value="${user.getId()}" name = "id"> 
			</form>
						<table class="table table-hover table-striped">
					   <thead> <!-- En-tête du tableau -->
					       <tr>
							   <th>Date</th>
					           <th>Equipe</th>
					           <th>Fond</th>
					           <th>Forme</th>
					           <th>Attitude</th>
					           <th>Note finale (couleur)</th>
					           <th>Note finale </th>
					           <th>Commentaire</th>
					           <th>Commentaire caché</th>
					           <th>Pack</th>
					       </tr>
					   </thead>
						<c:forEach items="${audits}" var="audit">
			 				<c:if test="${audit.getPublicate()!=0 }">
					   <tbody> <!-- Corps du tableau -->
					       <tr>
					       	   <td> <font color="red"> ${audit.getDate()} </font> </td>
					           <td> <font color="red">${audit.getTeamName(audit.getIdTeam())} </font></td>
					           <td>
										<c:if test="${audit.getColor1()==1 }"> 
											<img src="${pageContext.request.contextPath}/resources/Images/Rond-vert.jpg"/>
										</c:if>
										<c:if test="${audit.getColor1()==2 }">
										<img src="${pageContext.request.contextPath}/resources/Images/Rond-orange.jpg"/>
										</c:if>
										<c:if test="${audit.getColor1()==3 }">
										<img src="${pageContext.request.contextPath}/resources/Images/Rond-rouge.jpg"/>
										</c:if>
							</td>
					           <td> 
										<c:if test="${audit.getColor2()==1 }"> 
											<img src="${pageContext.request.contextPath}/resources/Images/Rond-vert.jpg"/>
										</c:if>
										<c:if test="${audit.getColor2()==2 }">
										<img src="${pageContext.request.contextPath}/resources/Images/Rond-orange.jpg"/>
										</c:if>
										<c:if test="${audit.getColor2()==3 }">
										<img src="${pageContext.request.contextPath}/resources/Images/Rond-rouge.jpg"/>
										</c:if>
							 </td>
					           <td> 
										<c:if test="${audit.getColor3()==1 }"> 
											<img src="${pageContext.request.contextPath}/resources/Images/Rond-vert.jpg"/>
										</c:if>
										<c:if test="${audit.getColor3()==2 }">
										<img src="${pageContext.request.contextPath}/resources/Images/Rond-orange.jpg"/>
										</c:if>
										<c:if test="${audit.getColor3()==3 }">
										<img src="${pageContext.request.contextPath}/resources/Images/Rond-rouge.jpg"/>
										</c:if>
							 </td>
					           <td> <c:if test="${audit.getFinalColor()==1 }"> 
										<img src="${pageContext.request.contextPath}/resources/Images/Rond-vert.jpg"/>
									</c:if>
									<c:if test="${audit.getFinalColor()==2 }">
										<img src="${pageContext.request.contextPath}/resources/Images/Rond-orange.jpg"/>
									</c:if>
									<c:if test="${audit.getFinalColor()==3 }">
										<img src="${pageContext.request.contextPath}/resources/Images/Rond-rouge.jpg"/>
									</c:if>
							</td>
					           <td> ${audit.getNote()} </td>
					           <td> ${audit.getReport()} </td>
					           <td> ${audit.getComment()} </td>
					           <td> <c:if test="${audit.getPublicate()==1 }">
					           			standard
					           		</c:if>
					           		<c:if test="${audit.getPublicate()==2 }">
					           			1
					           		</c:if>
					           		<c:if test="${audit.getPublicate()==3 }">
					           			2
					           		</c:if>
					           		<c:if test="${audit.getPublicate()==4 }">
					           			3
					           		</c:if>
					           </td>
				       </tr>
			     	</tbody>
			     	</c:if>
				</c:forEach>
				</table>
			</small></h4>
		</div>
	</div>
</jsp:body>
</t:main>