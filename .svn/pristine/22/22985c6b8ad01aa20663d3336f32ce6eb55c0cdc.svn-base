<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:main>
<jsp:attribute name="see_request_team">en</jsp:attribute>
	<jsp:body>
		<div class="row">
			<div class="col-md-12 col-lg-10">
			<h1> Historique des demandes de l'équipe</h1>
				<c:if test="${events != null }">
				<table class="table table-hover table-striped">
				<thead> <!-- En-tête du tableau -->
							       <tr>
									   <th> Titre</th>
							           <th> Description</th>
							           <th> Date de début</th>
							           <th> Date de fin </th>
							       </tr>
							   </thead>
					<c:forEach items="${events}" var="event">	
						<c:if test="${event.getValidation()!=0 }">
							<tbody>	
								<tr>
									<td> ${event.getName()} </td>
									<td> ${event.getDescription()} </td>
									<td> ${event.getStartDateString()} </td>
									<td> ${event.getEndDateString()} </td>
								</tr>
							<tbody>
						</c:if>
					</c:forEach>
				</table>
				</c:if>
			</div>
		</div>
	</jsp:body>
</t:main>