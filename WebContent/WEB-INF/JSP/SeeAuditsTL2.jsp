<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:main>
	<jsp:body>
		<div class="row">
			<div class="col-sm-10 col-md-8 col-lg-6">
				<h1>Liste des audits des différentes sessions</h1>	
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
					       </tr>
					   </thead>
						<c:forEach items="${audits}" var="audit">
			 				<c:if test="${audit.getPublicate()!=0 }">
					   <tbody> <!-- Corps du tableau -->
					       <tr>
					       	   <td> <font color="red"> ${audit.getDate()} </font> </td>
					           <td> <font color="red">${audit.getTeamName(audit.getIdTeam())} </font></td>
					           <td> <c:if test="${audit.getPublicate()==4}">  
										<c:if test="${audit.getColor1()==1 }"> 
											<img src="${pageContext.request.contextPath}/resources/Images/Rond-vert.jpg"/>
										</c:if>
										<c:if test="${audit.getColor1()==2 }">
										<img src="${pageContext.request.contextPath}/resources/Images/Rond-orange.jpg"/>
										</c:if>
										<c:if test="${audit.getColor1()==3 }">
										<img src="${pageContext.request.contextPath}/resources/Images/Rond-rouge.jpg"/>
										</c:if>
									</c:if>
									<c:if test="${audit.getPublicate()==1}">  
										<c:if test="${audit.getColor1()==1 }"> 
											<img src="${pageContext.request.contextPath}/resources/Images/Rond-vert.jpg"/>
										</c:if>
										<c:if test="${audit.getColor1()==2 }">
										<img src="${pageContext.request.contextPath}/resources/Images/Rond-orange.jpg"/>
										</c:if>
										<c:if test="${audit.getColor1()==3 }">
										<img src="${pageContext.request.contextPath}/resources/Images/Rond-rouge.jpg"/>
										</c:if>
									</c:if>
							</td>
					           <td> <c:if test="${audit.getPublicate()==4}">  
										<c:if test="${audit.getColor2()==1 }"> 
											<img src="${pageContext.request.contextPath}/resources/Images/Rond-vert.jpg"/>
										</c:if>
										<c:if test="${audit.getColor2()==2 }">
										<img src="${pageContext.request.contextPath}/resources/Images/Rond-orange.jpg"/>
										</c:if>
										<c:if test="${audit.getColor2()==3 }">
										<img src="${pageContext.request.contextPath}/resources/Images/Rond-rouge.jpg"/>
										</c:if>
									</c:if>
									<c:if test="${audit.getPublicate()==1}">  
										<c:if test="${audit.getColor2()==1 }"> 
											<img src="${pageContext.request.contextPath}/resources/Images/Rond-vert.jpg"/>
										</c:if>
										<c:if test="${audit.getColor2()==2 }">
										<img src="${pageContext.request.contextPath}/resources/Images/Rond-orange.jpg"/>
										</c:if>
										<c:if test="${audit.getColor2()==3 }">
										<img src="${pageContext.request.contextPath}/resources/Images/Rond-rouge.jpg"/>
										</c:if>
									</c:if>
							 </td>
					           <td> <c:if test="${audit.getPublicate()==4}">  
										<c:if test="${audit.getColor3()==1 }"> 
											<img src="${pageContext.request.contextPath}/resources/Images/Rond-vert.jpg"/>
										</c:if>
										<c:if test="${audit.getColor3()==2 }">
										<img src="${pageContext.request.contextPath}/resources/Images/Rond-orange.jpg"/>
										</c:if>
										<c:if test="${audit.getColor3()==3 }">
										<img src="${pageContext.request.contextPath}/resources/Images/Rond-rouge.jpg"/>
										</c:if>
									</c:if>
									<c:if test="${audit.getPublicate()==1}">  
										<c:if test="${audit.getColor3()==1 }"> 
											<img src="${pageContext.request.contextPath}/resources/Images/Rond-vert.jpg"/>
										</c:if>
										<c:if test="${audit.getColor3()==2 }">
										<img src="${pageContext.request.contextPath}/resources/Images/Rond-orange.jpg"/>
										</c:if>
										<c:if test="${audit.getColor3()==3 }">
										<img src="${pageContext.request.contextPath}/resources/Images/Rond-rouge.jpg"/>
										</c:if>
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
					           <td> <c:if test="${audit.getPublicate()==3 }"> 
										${audit.getNote()}
									</c:if>
									<c:if test="${audit.getPublicate()==1 }"> 
										${audit.getNote()}
									</c:if>
							</td>
					           <td> ${audit.getReport()}</td>
				       </tr>
			     	</tbody>
			     	</c:if>
				</c:forEach>
			</table>	
			<form action="${pageContext.request.contextPath}/">
				<button class="btn btn-primary" type="submit"><i class="fa fa-long-arrow-left fa-fw"></i> retour</button>
			</form>				
			</div>
		</div>
	</jsp:body>
</t:main>