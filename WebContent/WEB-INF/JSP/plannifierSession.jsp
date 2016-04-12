<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>planification d'une session</title>

<!-- Bootstrap core CSS -->
<link
	href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">

<!-- Custom styles for this template -->
<link href="styleBootStrap.css" rel="stylesheet">

</head>
<body>
 
		Choisir la date de début:  
		<input class="form-control" type="date" name="dateDebutSession" class="form-control" placeholder="2015-03-21" equired autofocus>
		Choisir la scéance:<br>
		AM:<input type="radio" name="sceance" value="1"><br>
		PM:<input type="radio" name="sceance" value="2"><br>
		
		<a href="/TestTraining/JSP/Plannification.jsp">
				<button type="button" class="btn btn-default" aria-label="Left Align">Retour à la page précédente</button>
			</a>
</body>
</html>