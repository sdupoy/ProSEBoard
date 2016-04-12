<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<t:main>
<jsp:body>
	<div class="row">
		<div class="col-sm-10 col-md-8 col-lg-6">
			<h1> Inserer un nouveau template </h1>
			<form method="post" action = "${pageContext.request.contextPath}/NewTemplate">
			<h4><small>	
				<br>		
					<input type="text" name="template"  value="--" ><br> 
				<br><br>
				<button class="btn btn-primary" type="submit">Ajouter</button>
			</small></h4>
			</form>
		</div>
	</div>
</jsp:body>	
</t:main>