<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<t:main>
<jsp:attribute name="see_all_audits">en</jsp:attribute>
<jsp:body>
	<div class="row">
		<div class="col-sm-10 col-md-8 col-lg-6">
			<h1>Liste Audits</h1>
			<h4><small>
						<table class="table table-hover table-striped">
					   <thead> <!-- En-tête du tableau -->
					       <tr>
							   <th><form method="post" action="${pageContext.request.contextPath}/ServletVoirAudit">
								<input type="hidden" value="1" name = "order">
								<button class="btn btn-primary" type="submit"> <i class="fa fa-calendar fa-fw"></i> date</button>
							</form></th>
					           <th><form method="post" action="${pageContext.request.contextPath}/ServletVoirAudit">
								<input type="hidden" value="2" name = "order">
								<button class="btn btn-primary" type="submit"> <i class="fa fa-users"></i> Equipe</button>
							</form></th>
					           <th><form method="post" action="${pageContext.request.contextPath}/ServletVoirAudit">
								<input type="hidden" value="3" name = "order">
								<button class="btn btn-primary" type="submit"> <i class="fa fa-graduation-cap"></i> Fond</button>
							</form></th>
					           <th><form method="post" action="${pageContext.request.contextPath}/ServletVoirAudit">
								<input type="hidden" value="4" name = "order">
								<button class="btn btn-primary" type="submit"> <i class="fa fa-graduation-cap"></i> Forme</button>
							</form></th>
					           <th><form method="post" action="${pageContext.request.contextPath}/ServletVoirAudit">
								<input type="hidden" value="5" name = "order">
								<button class="btn btn-primary" type="submit"> <i class="fa fa-graduation-cap"></i> Attitude</button>
							</form></th>
					           <th><form method="post" action="${pageContext.request.contextPath}/ServletVoirAudit">
								<input type="hidden" value="6" name = "order">
								<button class="btn btn-primary" type="submit"> <i class="fa fa-graduation-cap"></i> Note</button>
							</form></th>
					           <th><form method="post" action="${pageContext.request.contextPath}/ServletVoirAudit">
								<input type="hidden" value="7" name = "order">
								<button class="btn btn-primary" type="submit"> <i class="fa fa-graduation-cap"></i> Note</button>
							</form></th>
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