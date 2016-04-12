<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<title>Connexion</title>

<link href="${pageContext.request.contextPath}/resources/bootstrap/css/bootstrap.min.css" rel="stylesheet">

</head>
<body style="background:#381322">
	<div class="container" style="margin-top:20vh;">
		<div class="row">
			<div class="col-xs-8 col-xs-offset-2 col-sm-6 col-sm-offset-3 col-md-4 col-md-offset-4">
				<h1 style="color:rgba(255, 0, 43, .8);font-size:5em;" class="text-center">ProSEboard</h1>
				<h2 style="color:#FFF;">Bienvenue!<br/> </font> <small style="color:rgba(255,255,255,.5);">Pour accéder aux outils, veuillez vous connecter.</small></h2>
				<c:if test="${not empty loginError}">
					<div class="alert alert-danger">
						${loginError}
					</div>
				</c:if>
				<form method="post">
					<div class="form-group">
						<input type="text" name="login" class="form-control input-lg" placeholder="Identifiant" required autofocus>
					</div>
					<div class="form-group">
						<input type="password" name="password" class="form-control input-lg" placeholder="Mot de passe" required>
					</div>
					<div class="form-group">
						<button class="btn btn-lg btn-primary btn-block" name="submit" type="submit">Connexion</button>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>