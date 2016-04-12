<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:main>

	<jsp:attribute name="head">
		<script
			src="${pageContext.request.contextPath}/resources/js/summernote.min.js"
			type="text/javascript">
		</script>
		<link href="${pageContext.request.contextPath}/resources/css/summernote.css"
			rel="stylesheet">
	</jsp:attribute>
	<jsp:body>
		<div class="row">
			<div class="col-sm-10 col-md-8 col-lg-6">
				<h1>Nouveau Message</h1>
	
				<form method="post" action="${pageContext.request.contextPath}/ResponseMessage">
					<div class="form-group">
						${message.getMailEmetter()}
					</div>
					<div class="form-group">
						<textarea name="content" rows=30 id="summernote" class="form-control"></textarea>
					</div>
					<div class="form-group">
						<input type="hidden" value="${message.getMailEmetter()}" name = "idMailE">
						<input type="hidden" value="${message.getMailReceiver()}" name = "idMailR">
						<input type="hidden" value="${message.getIdEmetter()}" name = "idE">
						<input type="hidden" value="${message.getIdReceiver()}" name = "idR">
						<button class="btn btn-primary btn-lg pull-right" type="submit">Envoyer</button>
					</div>
				</form>
			</div>
		</div>
		<script type="text/javascript">
			$(document).ready(function() {
				$('#summernote').summernote({
					height: 300,
					toolbar: [
					          ['style', ['bold', 'italic', 'underline', 'clear']],
					          ['para', ['ul', 'ol', 'paragraph']],
					          ]
				});
			});
		</script>
	</jsp:body>
</t:main>