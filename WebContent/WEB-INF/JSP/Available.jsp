<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<t:main>
<jsp:attribute name="publish_available">en</jsp:attribute>
<jsp:body>
	<div class="row">
		<div class="col-sm-10 col-md-8 col-lg-6">
			<h1>Mes disponibilités</h1>
			<br><br>
			<div class="list-group">
			  <a class="list-group-item" href="${pageContext.request.contextPath}/NewAvailable"><i class="fa fa-plus"></i>&nbsp; Nouvelle disponiblité</a>
			  <a class="list-group-item" href="${pageContext.request.contextPath}/MyAvailable"><i class="fa fa-calendar"></i>&nbsp; Mes disponibilités</a>
			</div>
			
		</div>
	</div>
</jsp:body>	
</t:main>