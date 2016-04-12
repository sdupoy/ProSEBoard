<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<t:main>
<jsp:attribute name="publicate_audit">en</jsp:attribute>
<jsp:body>
	<div class="row">
		<div class="col-sm-10 col-md-8 col-lg-6">
			<h1>Liste Audits</h1>
			<form method="get" action = "${pageContext.request.contextPath}/ServletPublierAudit">
					<input type="hidden" value="${user.getId()}" name = "id"> 
			</form>
			<h4><small>
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
					           <th>Modifier</th>
					           <th>Publier</th>
					           <th>Publier+</th>
					       </tr>
					   </thead>
						<c:forEach items="${audits}" var="audit">
			 				<c:if test="${audit.getPublicate()==0 }">
			 				<c:if test="${user.getId()==audit.getIdAuditor()}">   
					   <tbody> 
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
					           
							<td> <form method="get" action="${pageContext.request.contextPath}/ServletModifierAudit">
								<input type="hidden" value="${audit.getId()}" name = "id">
								<input type="hidden" value="${audit.getIdTeam()}" name = "idTeam">
								<button class="btn btn-primary" type="submit"> <i class="fa fa-pencil fa-fw"></i></button>
							</form> </td>
							
							<td> <form method="post" action="${pageContext.request.contextPath}/ServletPublierAudit">
								<input type="hidden" value="${audit.getId()}" name = "id"> 
								<button class="btn btn-primary" type="submit"> <i class="fa fa-check-circle-o fa-fw"></i></button>
					          	</form> </td>
					          	
					        <td> <form method="get" action="${pageContext.request.contextPath}/ServletSelectionPublierAudit">
								<input type="hidden" value="${audit.getId()}" name = "id">
								<input type="hidden" value="${audit.getIdTeam()}" name = "idTeam">
								<button class="btn btn-primary" type="submit"> <i class="fa fa-check-circle-o fa-fw"> </i><i class="fa fa-gear fa-fw"></i></button>
							</form> </td>
				       </tr>
			     	</c:if>
			     	</c:if>
						<c:if test="${audit.getPublicate()!=0 }">
						<c:if test="${user.getId()==audit.getIdAuditor()}">   
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
					           <td></td>
					           <td></td>
					           <td></td>
						</tr>
					</c:if>
					</c:if>
					</tbody>
				</c:forEach>
				</table>
			</small></h4>
		</div>
	</div>
	</jsp:body>
</t:main>