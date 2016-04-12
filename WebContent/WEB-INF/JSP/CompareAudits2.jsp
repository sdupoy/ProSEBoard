<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<t:main>
<jsp:attribute name="compare_audits">en</jsp:attribute>
<jsp:body>
	<div class="row">
		<div class="col-sm-10 col-md-8 col-lg-6">
			<h1>Comparaison des deux audits </h1>
			<br>
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
							       </tr>
							   </thead>
							   <tbody> <!-- Corps du tableau -->
							       <tr>
						
							       	   <td> <font color="red"> ${audit.getDate()} </font> </td>
							           <td> <font color="red">${audit.getTeamName(idTeam)} </font></td>
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
							            <td> <c:if test="${color1==1 }"> 
												<img src="${pageContext.request.contextPath}/resources/Images/Rond-vert.jpg"/>
											</c:if>
											<c:if test="${color1==2 }">
												<img src="${pageContext.request.contextPath}/resources/Images/Rond-orange.jpg"/>
											</c:if>
											<c:if test="${color1==3 }">
												<img src="${pageContext.request.contextPath}/resources/Images/Rond-rouge.jpg"/>
											</c:if>
									</td>
							           <td>
												${audit.getNote()}
									</td>
							           <td> ${audit.getReport()}</td>
							           <td> ${audit.getComment()}</td>
						       </tr>
						        <tr>
						
							       	   <td> <font color="red"> ${audit2.getDate()} </font> </td>
							           <td> <font color="red">${audit2.getTeamName(idTeam2)} </font></td>
							           <td> 
												<c:if test="${audit2.getColor1()==1 }"> 
													<img src="${pageContext.request.contextPath}/resources/Images/Rond-vert.jpg"/>
												</c:if>
												<c:if test="${audit2.getColor1()==2 }">
												<img src="${pageContext.request.contextPath}/resources/Images/Rond-orange.jpg"/>
												</c:if>
												<c:if test="${audit2.getColor1()==3 }">
												<img src="${pageContext.request.contextPath}/resources/Images/Rond-rouge.jpg"/>
												</c:if>
									  </td>
							           <td> 
												<c:if test="${audit2.getColor2()==1 }"> 
													<img src="${pageContext.request.contextPath}/resources/Images/Rond-vert.jpg"/>
												</c:if>
												<c:if test="${audit2.getColor2()==2 }">
												<img src="${pageContext.request.contextPath}/resources/Images/Rond-orange.jpg"/>
												</c:if>
												<c:if test="${audit2.getColor2()==3 }">
												<img src="${pageContext.request.contextPath}/resources/Images/Rond-rouge.jpg"/>
												</c:if>
									 </td>
							           <td> 
												<c:if test="${audit2.getColor3()==1 }"> 
													<img src="${pageContext.request.contextPath}/resources/Images/Rond-vert.jpg"/>
												</c:if>
												<c:if test="${audit2.getColor3()==2 }">
												<img src="${pageContext.request.contextPath}/resources/Images/Rond-orange.jpg"/>
												</c:if>
												<c:if test="${audit2.getColor3()==3 }">
												<img src="${pageContext.request.contextPath}/resources/Images/Rond-rouge.jpg"/>
												</c:if>
									 </td>
							           <td> <c:if test="${color2==1 }"> 
												<img src="${pageContext.request.contextPath}/resources/Images/Rond-vert.jpg"/>
											</c:if>
											<c:if test="${color2==2 }">
												<img src="${pageContext.request.contextPath}/resources/Images/Rond-orange.jpg"/>
											</c:if>
											<c:if test="${color2==3 }">
												<img src="${pageContext.request.contextPath}/resources/Images/Rond-rouge.jpg"/>
											</c:if>
									</td>
							           <td>
												${audit2.getNote()}
									</td>
							           <td> ${audit2.getReport()}</td>
							           <td> ${audit2.getComment()}</td>
						       </tr>
					     	</tbody>

				</table>
				<a href="${pageContext.request.contextPath}/CompareAudits" class="btn btn-primary"><i class="fa fa-reply"></i></a>				
		</div>
	</div>
	</jsp:body>
</t:main>