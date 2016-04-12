<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>

<t:main>

	<script src="${pageContext.request.contextPath}/resources/js/moment.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/resources/js/moment-fr.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/resources/js/bootstrap-combobox.js" type="text/javascript"></script>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap-combobox.css" type="text/css">

	<script type="text/javascript">	
	$(function() {
		$(document).ready(function() {
			$('.combobox').combobox();
		});		
	});
	</script>
	
	<div class="row">
		<div class="col-sm-10 col-md-10 col-lg-10">
			<h1>Soumettre une facture</h1><br>
			
			<c:if test="${ !empty errorMsg }">
            	<div class="alert alert-danger" role="alert">${errorMsg}</div>       
            </c:if> 
            
			<form method="post" action="SendBill">

				<label style="font-size:20px">Indiquez la personne à facturer</label>
				<div class="form-group">
					<select class="combobox input-large form-control" name="idBillReceiver" required>
							<option></option>
							<c:forEach items="${potentialBillReceivers}" var="potentialBillReceiver">
								<option value="${potentialBillReceiver.getId()}"><c:out value="${potentialBillReceiver.getLastName()} ${potentialBillReceiver.getFirstName()}"/></option>
							</c:forEach>
					</select>
				</div>
				
				<label style="font-size:20px">Indiquez le sujet de la facturation</label>
				<div class="input-group input-group-lg">
					<span class="input-group-addon" id="sizing-addon1">Sujet</span> 
					<input type="text" class="form-control" name="subject" aria-describedby="sizing-addon1" placeholder="???" required>
				</div><br>
				
				<label style="font-size:20px">Indiquez le montant</label>
				<div class="input-group input-group-lg">
					<span class="input-group-addon" id="sizing-addon1">Montant en euros</span> 
					<input type="text" class="form-control" name="amount" aria-describedby="sizing-addon1" placeholder="0.00" required>
				</div><br>
				
				<label style="font-size:20px">Ajoutez des commentaires</label>
				<div class="form-group">
  					<textarea name="comments" class="form-control" rows="5" id="comment"></textarea>
				</div><br>
				
				<button class="btn btn-lg btn-primary pull-left" type="submit">Soumettre la facture</button>
				
			</form>		
			<a href="ManageBills"><button class="btn btn-lg btn-primary pull-left" style="margin-left:10px" type="submit">Revenir à la gestion des factures</button></a>	
		</div>
	</div>
</t:main>