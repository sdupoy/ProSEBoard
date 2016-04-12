<%@ page language="java" contentType="text/html;"
	pageEncoding="UTF-8"%>


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


	<div class="jumbotron">
		<div class="container">
			<h3>Inserting Audit in Data Base sucessfull</h3>
			<p>Thank you</p>
			<p>
				<a class="btn btn-primary btn-lg" href="#" role="button">Next&raquo;</a>
			</p>
		</div>
			
	</div>
	<br>
	<br>
</body>
</html>

