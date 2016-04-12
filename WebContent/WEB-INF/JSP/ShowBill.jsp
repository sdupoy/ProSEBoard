<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>

<t:main>
	<div class="row">
		<div class="col-sm-10 col-md-10 col-lg-10">
			<h1>Consulter</h1><br>
			
			<div class="panel panel-info">
				<div class="panel-heading"><h2 class="panel-title">Sujet</h2></div>
				<div class="panel-footer"><b><c:out value="${bill.getSubject()}"/></b></div>
			</div>
			
			<div class="panel panel-info">
				<div class="panel-heading"><h2 class="panel-title">Montant</h2></div>
				<div class="panel-footer"><b><c:out value="${bill.getAmount()} €"/></b></div>
			</div>
			
			<div class="panel panel-info">
				<div class="panel-heading"><h2 class="panel-title">Date</h2></div>
				<div class="panel-footer"><b><c:out value="${bill.getSimpleDate()}"/></b></div>
			</div>
			
			<div class="panel panel-info">
				<div class="panel-heading"><h2 class="panel-title">Commentaires</h2></div>
				<div class="panel-footer"><b><c:out value="${bill.getComments()}"/></b></div>
			</div>
			
			<a href="ManageBills"><button class="btn btn-lg btn-primary pull-left">Revenir à la gestion des factures</button></a>
		</div>
	</div>
</t:main>