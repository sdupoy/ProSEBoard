<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<t:main>
<jsp:attribute name="publish_competences">en</jsp:attribute>
<jsp:body>
	<div class="row">
		<div class="col-sm-10 col-md-8 col-lg-6">
			<h1>Mes compétences</h1>
			<br><br>
			<div class="list-group">
			  <a class="list-group-item" href="${pageContext.request.contextPath}/NewCompetences"><i class="fa fa-plus"></i>&nbsp; Nouvelle compétence</a>
			  <a class="list-group-item" href="${pageContext.request.contextPath}/MyCompetences"><i class="fa fa-briefcase"></i>&nbsp; Mes compétences</a>
			</div>
			
		</div>
	</div>
</jsp:body>	
</t:main>