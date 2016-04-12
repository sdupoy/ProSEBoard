<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<t:main>
<jsp:attribute name="publish_competences">en</jsp:attribute>
<jsp:body>
	<div class="row">
		<div class="col-sm-10 col-md-8 col-lg-6">
			<h1> Inserer une nouvelle compétence </h1>
			<form method="post" action = "${pageContext.request.contextPath}/NewCompetences">
				<div class="form-group">
					<input type="text" name="comp" placeholder="Nom de la compétence" class="form-control">
				</div>
				<div class="form-group">
					<button class="btn btn-primary" type="submit">Ajouter</button>
					<input type="hidden" value="${user.getId()}" name = "id">
				</div>
			</form>
		</div>
	</div>
</jsp:body>	
</t:main>