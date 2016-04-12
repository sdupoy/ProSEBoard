<%@ page language="java" contentType="text/html;" pageEncoding="UTF-8"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<title>Publishing Audit</title>

<!-- Bootstrap core CSS -->
<link
	href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">

<!-- Custom styles for this template -->
<link href="../styleBootStrap.css" rel="stylesheet">

</head>

<body>


	<!-- Barre de navigation  -->


	<div class="container">
		<form class="form-navBar">
			<nav class="navbar navbar-inverse navbar-fixed-top">
			<div class="container">
				<div class="navbar-header">
					<button type="button" class="navbar-toggle collapsed"
						data-toggle="collapse" data-target="#navbar" aria-expanded="false"
						aria-controls="navbar">
						<span class="sr-only">Toggle navigation</span> <span
							class="icon-bar"></span> <span class="icon-bar"></span> <span
							class="icon-bar"></span>
					</button>
					<a class="navbar-brand" href="#">Project name</a>
				</div>
				<div id="navbar" class="collapse navbar-collapse">
					<ul class="nav navbar-nav">
						<li class="active"><a href="#">Home</a></li>
						<li><a href="#about">About</a></li>
						<li><a href="#contact">Contact</a></li>
						<li><a
							href="${pageContext.request.contextPath}/JSP/signInExemple.jsp">Sign
								in</a></li>
					</ul>
				</div>

			</div>
			</nav>
		</form>
	</div>
	<!-- /barre de navigation -->
	<br>
	<br>
	<br>


	<!--Formulaire -->

	<div class="container">
		<h2>Audit Report</h2>

		<!-- Zone de texte pour remplir le rapport -->

		<form class="form-horizontal" role="form"
			action="../PublishReportServlet" method="post">
			<TEXTAREA name="report" rows="8" cols="80" id="report" value="report"
				required>
			
                      </textarea>
			<br>

			<!-- Couleur : actuellement gérée de facon à avoir rouge=1 / orange=2 / vert=3. -->

			<div class="row">
				<div class="col-sm-1"><input class="form-control" type="radio" name="color" value="1"required>Red</div>
				<div class="col-sm-1"><input class="form-control" type="radio" name="color" value="2">Orange</div>
				<div class="col-sm-1"><input class="form-control" type="radio" name="color" value="3">Green</div>
			</div>

			<!-- Id team -->

			<br>
			<h4>Team Id</h4>
			<div class="row">
				<div class="col-lg-2">
					<input class="form-control" type="number" name="id_team" min="1" step="1" required>
					<br>
				</div>
			</div>

			<!-- Note -->

			<br>
			<h4>Mark :</h4>
			<input class="form-control" type="number" name="mark" min="0" max="20" step="0.1" required> <br>

			<!-- Envoi du formulaire -->

			<br>
			<button class="btn btn-default btn-sm" type="submit">Submit</button>
		</form>
	</div>
</body>
</html>

