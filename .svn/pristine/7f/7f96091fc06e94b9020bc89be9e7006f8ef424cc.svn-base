<%@page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:main>
	<jsp:attribute name="manage_user">en</jsp:attribute>
	<jsp:body>
		<div class="col-md-12 col-lg-10">
			<h1>Gestion des comptes</h1>
			<table class="table table-hover table-striped">
				<tr>
        	 		<td>Equipe</td> 
         	   		<td>Solde du compte</td>
	      		</tr>   	   									
				<tr>
    	        	<td>${teamName} - ${project}</td>
        	    	<td>${account.getBalance()}</td>
        		</tr>
			</table>
		</div>
	</jsp:body>
</t:main>