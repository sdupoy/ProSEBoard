<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:main>
	<jsp:attribute name="manage_user">en</jsp:attribute>
	<jsp:body>
		<div class="col-md-12 col-lg-10">
		<h2>Modification du compte de l'équipe</h2>
	
			<form method="get" action="${pageContext.request.contextPath}/EditAccountTeam">
			<br>
				<h4>Solde actuel</h4>	
				${account.getBalance()} €
				<br><br>
			</form>
			<form method="post" action="${pageContext.request.contextPath}/EditAccountTeam">
			<h4>Montant du nouveau solde</h4>	
				<input type="text" name="balance" class="form-control" placeholder="montant du solde" required>
			<!-- Envoi du formulaire -->
			<br>
			<div class="form-group">
				<button class="btn btn-primary pull-right" type="submit">modifier compte</button>
			</div>
			</form>
		</div>
	</jsp:body>
</t:main>