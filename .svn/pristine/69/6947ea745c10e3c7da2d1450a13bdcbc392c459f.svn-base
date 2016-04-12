<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>

<t:main>
	<div class="row">
		<div class="col-xs-12">
			<h2>Mes templates</h2>
			<div class="alert alert-danger">
				Attention si vous supprimez un modèle, les entrées qu'il contient le seront aussi.
			</div>
			<div class="row">
				<c:forEach items="${templates}" var="template">
					<div class="col-sm-12 col-md-6 col-lg-4">
						<div class="panel panel-default">
							<div class="panel-body">
								<div class="pull-right">
									<i class="fa fa-connectdevelop"></i>
								</div>
								<h4><b>${template.getTemplateName()}</b></h4>
								<p>Fait le <b>${template.getUpdateAtPrintf()}</b></p>
								<div class="btn-group" role="group" aria-label="actions">
									<a class="btn btn-default" href="${pageContext.request.contextPath}/template/timeslots?id=${template.getTemplateId()}"> <i class="fa fa-cubes"></i> Gérer les Modules</a>
									<a class="btn btn-danger" href="${pageContext.request.contextPath}/DeleteTemplate?id=${template.getTemplateId()}"> <i class="fa fa-times"></i></a>
						    	</div>
							</div>
						</div>
			    	</div>
			</c:forEach>
			</div>
		</div>
	</div>
</t:main>