<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>

<t:main>
	<div class="row">
		<div class="col-sm-10 col-md-10 col-lg-10">
			<h1>Gestion des factures</h1><br>
			<div class="list-group">		
  				<div class="list-group-item active"><b><label style="font-size:24px">Mes factures</label></b></div>		
  				<c:if test="${ empty bills }">
            		<div class="list-group-item" style="height: 70px">  				
            			<label style="font-size:20px">&nbsp;<c:out value="Aucune"/></label>		
	  				</div>     
           		 </c:if> 		
	  			<c:forEach items="${bills}" var="bill" varStatus="loop">  			
	  				<div class="list-group-item" style="height: 70px"> 		
	  					<form method="post" action="ManageBills">
	  						<button type="button" class="btn btn-danger pull-right" style="margin-left:25px" type="submit" name="billId" value="${bill.getIdBill()}">
			 					 <span class="glyphicon glyphicon-remove" aria-hidden="true" style="font-size:15px"></span>
							</button>
						</form>	
						<form method="get" action="${pageContext.request.contextPath}/payTeam">
							<button type="button" class="btn btn-success pull-right" type="submit" style="margin-left:25px">
								<span class="glyphicon glyphicon-ok" aria-hidden="true" style="font-size:15px"></span>
							</button>				
						</form>					
						<form method="get" action="ShowBill">
							<button class="btn btn-primary pull-left" type="submit" style="margin-right:15px" name="billId" value="${bill.getIdBill()}">
			 					 <span class="glyphicon glyphicon-plus" aria-hidden="true" style="font-size:15px"></span>
							</button>
						</form>
						<span class="label label-info label-as-badge pull-right" style="font-size:14px">&nbsp;Montant: <c:out value="${bill.getAmount()} €"/>&nbsp;</span><b>
		  				<label style="font-size:20px">&nbsp;<c:out value="${bill.getSubject()}"/></label></b>  				
	  				</div>	  				
	  			</c:forEach>
			</div><br>
			<c:if test="${user.hasStatus('team_leader')}">
				<a href="SendBill"><button class="btn btn-lg btn-primary pull-left" type="submit">Soumettre une facture</button></a>
			</c:if>	
		</div>
	</div>
</t:main>