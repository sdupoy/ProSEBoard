<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<t:main>
	<jsp:body>
		<div class="row">
			<div class="col-sm-10 col-md-8 col-lg-6">
				<h1>Liste de mes consulting  </h1>
				<h4><small>
					<table class="table table-hover table-striped">
					   <thead> <!-- En-tête du tableau -->
					       <tr>
							   <th>Date de début </th>
					           <th>Date de fin </th>
					           <th>Description </th>
					           <th>Rapport</th>
					           <th>Etat</th>
					       </tr>
					   </thead>
						<c:forEach items="${consultings}" var="consulting">
							<c:forEach items="${events}" var="event">
								<tbody>
									<c:if test="${event.getId()==consulting.getIdEvent() }"> 
									      <tr>
									           <td>
													${event.getStartDateString()}
									           </td>
									           <td>
													${event.getEndDateString()}
									           </td>
									           <td>
													${event.getDescription()}
									           </td>
									           <td>
													${consulting.getReport()}
									           </td>
									           <td>
									           		<c:if test="${consulting.isCharged() eq 'false'}">
														<font color="red"> Non payé </font>
													</c:if>
													<c:if test="${consulting.isCharged() eq 'true'}">
														<font color="green"> Payé </font>
													</c:if>
									           </td>
								      	 </tr>
								      </c:if>
						     	</tbody>
						     </c:forEach>
						</c:forEach>
					</table>
				</small></h4>
			</div>
		</div>
	</jsp:body>
</t:main>