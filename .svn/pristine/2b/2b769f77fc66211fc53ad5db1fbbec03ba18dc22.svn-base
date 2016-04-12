<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<t:main>
<jsp:attribute name="view_TrainingAbsents">en</jsp:attribute>
	<jsp:body>
	<div class="row">
		<div class="col-md-12 col-lg-10">
			<h1>Voir les participants</h1>
			<table class="table table-hover table-striped">
				
				<c:forEach items="${attenders}" var="attender">
					<c:if test="${attender.getId()!=id}">
						${attender.getFirstName() } ${attender.getLastName() } <c:if test="${attender.isAbsent() }"> (abs.)</c:if><br />
					</c:if>
				</c:forEach>
			</table>
		</div>
	</div>
	<form action="${pageContext.request.contextPath}/">
		<button class="btn btn-primary pull-left" type="submit"><i class="fa fa-long-arrow-left fa-fw"></i> Annuler</button>
	</form>
	<form action="${pageContext.request.contextPath}/training/manager">
		<button class="btn btn-primary pull-left" type="submit"><i class="fa fa-search fa-fw"></i> Retour aux détails des rapports</button>
	</form>
	
	</jsp:body>
</t:main>
</body>
</html>