<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:main>
	<jsp:attribute name="manage_user">en</jsp:attribute>
	<jsp:body>
		<div class="row">
			<div class="col-md-12 col-lg-10">
			<h1>Gestion des utilisateurs</h1>
			<table class="table table-hover table-striped">
				<thead>
					<tr>
						<th>N°</th>
						<th>Nom</th>
						<th>Mail</th>
						<th>Status</th>
						<th>Permissions</th>
					</tr>				
				</thead>
				<c:forEach items="${users}" var="user">				
					<tr>
						<td>${user.getId() }</td>
						<td>${user.getFirstName()} ${user.getLastName()}</td>
						<td>${user.getMail()}</td>
						<td>
							<c:forEach items="${user.getStatuses()}" var ="status">
								${status.getName()}, 
							</c:forEach>
						</td>
						<td>
							<c:forEach items="${user.getPermissions()}" var ="permission">
								${permission.getName()}, 
							</c:forEach>
						</td>
					</tr>
				</c:forEach>
			</table>
			</div>
		</div>
	</jsp:body>
</t:main>