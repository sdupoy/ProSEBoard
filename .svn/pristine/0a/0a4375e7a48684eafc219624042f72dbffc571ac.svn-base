<%@page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:main>
	<jsp:attribute name="manage_user">en</jsp:attribute>
	<jsp:body>
		<div class="col-md-12 col-lg-10">
			<h1>Liste des absences de ${user1.getLastName()}</h1>
			<table class="table table-hover table-striped">
				<tr>
        	 		<td>cours</td> 
         	   		<td>heure début</td>
         	   		<td>heure fin</td>
	      		</tr>  
	      		<c:forEach items="${allEvent}" var="allEvent">				
					<tr>
						<td>${allEvent.getName()}</td>
        	    		<td>${allEvent.getStartDate()}</td>
        	    		<td>${allEvent.getEndDateString()}</td>
					</tr>
				</c:forEach> 	   									
			</table>
		</div>
	</jsp:body>
</t:main>