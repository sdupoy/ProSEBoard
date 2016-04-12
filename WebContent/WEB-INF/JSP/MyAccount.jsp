<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<t:main>
	<head>
		<meta charset="utf-8" />
		<script src="${pageContext.request.contextPath}/resources/js/Chart.min.js"></script>
	</head>
	<body>
		<h2>Mon compte</h2>
		<div class="row">
			<div class="col-sm-10">
				<div class="col-sm-6">
					<div class="panel panel-default">
						<div class="panel-heading">
							<h3 class="panel-title">Solde actuel</h3>
						</div>
						<div class="panel-body">
							<c:if test="${account.getBalance() < 0}">
								<font color="red"> ${account.getBalance()} € </font>
							</c:if>
							<c:if test="${account.getBalance() > 0}">
								<font color="green"> ${account.getBalance()} € </font>
							</c:if>
						</div>
			</div>	
		</div>
		<div class="row">
			<div class="col-sm-12">
				<h3>Evolution de mon solde</h3>
				<canvas id="buyers" style="width:100%;height:400px"></canvas>
			</div>
		</div>
		
		 <script>
			 var buyerData = {
	 				labels : [""],
	 				datasets : [
	 					{
	 						fillColor : "rgba(161,35,79,0.4)",
	 						strokeColor : "#381322",
	 						pointColor : "#fff",
	 						pointStrokeColor : "#381322",
	 						data : [0]
	 					}
	 				]
	 		}
			 
    		var buyers = document.getElementById('buyers').getContext('2d');
			var graph = new Chart(buyers).Line(buyerData, {
 		        bezierCurve: false,
 			});
    		<c:forEach items="${accountHistorys}" var="acc">
					graph.addData([${acc.getSolde()}], "${acc.getDatePrintf()}");
			</c:forEach>
    		
    		
    		
		</script>
	</body>
</t:main>