<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>

<t:main>
	<div class="row">
		<div class="col-sm-10 col-md-10 col-lg-10">	
			<h1>Voulez-vous vraiment supprimer la session <c:out value="${sessionName}"/> ?</h1>		
			<br><form method="post" action="DeleteSession"><button name="delete" class="btn btn-lg btn-danger" value="${sessionId}" type="submit">Supprimer</button></form>			
			<br><a href="ManageSessions"><button class="btn btn-lg btn-danger" type="submit">Revenir aux sessions</button></a>		
		</div>
	</div>
</t:main>