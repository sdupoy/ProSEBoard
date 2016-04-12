<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<t:main>
<jsp:attribute name="head">
<script
	src="${pageContext.request.contextPath}/resources/js/jquery.chained.min.js"
	type="text/javascript">
</script>
</jsp:attribute>
<jsp:attribute name="compare_audits">en</jsp:attribute>
<jsp:body>
	<div class="row">
		<div class="col-sm-10 col-md-8 col-lg-6">
			<h1>Choisir deux équipes à comparer </h1>
			<form method="get" action = "${pageContext.request.contextPath}/CompareAudits">
			
			</form>
			<form method="post" action = "${pageContext.request.contextPath}/CompareAudits">
			<font color="red">Audit 1</font> <br>
				<div class="form-group">
					 <select class="form-control" name="idSession2" id="idSession">
						<c:forEach items="${sessions}" var="session">
								<option value="${session.getId()}">${session.getName()}</option>
						</c:forEach>
					</select>
				</div>
				<div class="form-group">
					<select class="form-control" name="idTeam" id="idTeam">
						<c:forEach items="${teams}" var="team">
								<option value="${team.getId()}" class="${team.getSession(team.getId())}">${team.getTeamName()}</option>
						</c:forEach>
					</select> 
				</div>
				<div class="form-group">
					<select class="form-control" name="idAudit" id="idAudit">
						<c:forEach items="${audits}" var="audit">
								<option value="${audit.getId()}" class="${audit.getTeam2(audit.getId())}">${audit.getDate(audit.getId())}</option>
						</c:forEach>
					</select> 
				</div>
				<br><br><br>
				
				<font color="red">Audit 2</font>
				<div class="form-group">
					 <select class="form-control" name="idSession2" id="idSession2">
						<c:forEach items="${sessions}" var="session">
								<option value="${session.getId()}">${session.getName()}</option>
						</c:forEach>
					</select>
				</div>
				<div class="form-group">
					<select class="form-control" name="idTeam2" id="idTeam2">
						<c:forEach items="${teams}" var="team">
								<option value="${team.getId()}" class="${team.getSession(team.getId())}">${team.getTeamName()}</option>
						</c:forEach>
					</select> 
				</div>
				<div class="form-group">
					<select class="form-control" name="idAudit2" id="idAudit2">
						<c:forEach items="${audits}" var="audit">
								<option value="${audit.getId()}" class="${audit.getTeam2(audit.getId())}">${audit.getDate(audit.getId())}</option>
						</c:forEach>
					</select> 
				</div>
				<br><br>
				
				<h4><small>
				<button class="btn btn-primary" type="submit">Comparer</button>
			</small></h4>
			</form>
		</div>
	</div>
	<script type="text/javascript">
	$( document ).ready(function() {
		$("#idTeam").chained("#idSession");
		$("#idAudit").chained("#idTeam");
		$("#idTeam2").chained("#idSession2");
		$("#idAudit2").chained("#idTeam2");
					
	});
	</script>
</jsp:body>	
</t:main>