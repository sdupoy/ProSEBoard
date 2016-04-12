<%@page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:main>
	<jsp:attribute name="manage_user">en</jsp:attribute>
	<jsp:body>
		<div class="col-md-12 col-lg-10">
			<h1>Modification réussi!</h1>		
			
			<table class="table table-hover table-striped">
				<tr>
        	 		<td>Identifiant de l'équipe</td> 
         	   		<td>nom de l'équipe</td>
         	   		<td>Solde du compte</td>
	      		</tr>   	   									
				<tr>
    	        	<td>${account.getIdAccount()}</td>
        	    	<td>${team.getTeamName()}</td>
        	    	<td>${account.getBalance()}</td>
        		</tr>
			</table>
		</div>
	</jsp:body>
</t:main>

