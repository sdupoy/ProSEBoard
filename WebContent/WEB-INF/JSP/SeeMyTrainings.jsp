<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<t:main>
	<jsp:body>
		<div class="row">
			<div class="col-sm-10 col-md-8 col-lg-6">
				<h1>Liste de mes sessions d'entraînement </h1> <br>
				<h3><font color="green">Présent </font></h3>
				<table class="table table-hover table-striped">
				   <thead> <!-- En-tête du tableau -->
				       <tr>
						   <th>Date de début </th>
				           <th>Date de fin </th>
				           <th>Sujet </th>
				           <th>Rapport</th>
				           <th>Etat</th>
				       </tr>
				   </thead>
						<c:forEach items="${trainings}" var="training">
							<c:forEach items="${events}" var="event">
									<tbody>
										<c:if test="${event.getId()==training.getIdEvent() }"> 
												<tr>
											           <td>
															${event.getStartDateString()}
											           </td>
											           <td>
															${event.getEndDateString()}
											           </td>
											           <td>
															${training.getSubject()}
											           </td>
											           <td>
															${training.getReport()}
											           </td>
											           <td>
											           		<c:if test="${training.isCharged() eq 'false'}">
																<font color="red"> Non payé </font>
															</c:if>
															<c:if test="${training.isCharged() eq 'true'}">
																<font color="green"> Payé </font>
															</c:if>
											           </td>
										      	 </tr>
										      </c:if>
							     	</tbody>
						     </c:forEach>
						</c:forEach>
				</table>
				
				<h3><font color="red">Absent </font></h3>
				
				<table class="table table-hover table-striped">
				   <thead> <!-- En-tête du tableau -->
				       <tr>
						   <th>Date de début </th>
				           <th>Date de fin </th>
				           <th>Sujet </th>
				           <th>Rapport</th>
				           <th>Etat</th>
				       </tr>
				   </thead>
						<c:forEach items="${trainings2}" var="training">
							<c:forEach items="${events2}" var="event">
									<tbody>
										<c:if test="${event.getId()==training.getIdEvent() }"> 
												<tr>
											           <td>
															${event.getStartDateString()}
											           </td>
											           <td>
															${event.getEndDateString()}
											           </td>
											           <td>
															${training.getSubject()}
											           </td>
											           <td>
															${training.getReport()}
											           </td>
											           <td>
											           		<c:if test="${training.isCharged() eq 'false'}">
																<font color="red"> Non payé </font>
															</c:if>
															<c:if test="${training.isCharged() eq 'true'}">
																<font color="green"> Payé </font>
															</c:if>
											           </td>
										      	 </tr>
										      </c:if>
							     	</tbody>
						     </c:forEach>
						</c:forEach>
				</table>
			</div>
		</div>
	</jsp:body>
</t:main>