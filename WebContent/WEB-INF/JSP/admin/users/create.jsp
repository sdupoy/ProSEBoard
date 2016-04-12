<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:main>
	<jsp:attribute name="create_user">en</jsp:attribute>
	<jsp:body>
		<div class="row">
			<div class="col-sm-10 col-md-9 col-lg-7">
				<h1>Création d'un utilisateur</h1>
				<h2>Insérer les informations suivantes</h2>
	
				<form method="post" name="creeruser" action="${pageContext.request.contextPath}/utilisateur/creer">
					<div class="form-group">
						<div class="row">
							<div class="col-xs-6">
								<input type="text" name="user_first_name" class="form-control" placeholder="Prenom" required>
							</div>
							<div class="col-xs-6">
								<input type="text" name="user_name" class="form-control" placeholder="Nom" required autofocus>
							</div>
						</div>
					</div>
					<c:if test="${errorMail != null}">
						<div class="alert alert-danger">
							${errorMail}
						</div>
						<c:remove var="errorMail" scope="session" />
					</c:if>
					<div class="form-group">
						<input type="email" name="user_mail" class="form-control" placeholder="Email" required>
					</div>
					<c:if test="${errorPassword != null}">
						<div class="alert alert-danger">
							${errorPassword }
						</div>
						<c:remove var="errorPassword" scope="session" />
					</c:if>
					<div class="form-group">
						<div class="row">
							<div class="col-xs-6">
								<input type="password" name="user_password" class="form-control" placeholder="Mot de passe" required>
							</div>
							<div class="col-xs-6">
								<input type="password" name="user_password_bis" class="form-control" placeholder="Répétez mot de passe" required>
							</div>
						</div>
					</div>
					<div class="form-group text-center">
						<div class="btn-group" role="group" data-toggle="buttons">
							<c:forEach items="${statuses}" var="status">
								<c:choose>
  									<c:when test="${status.getName() eq 'admin'}">
  										<label class="btn btn-danger">
											<input type="checkbox" name="statuses" autocomplete="off" value="${status.getId()}">${status.getName()}
										</label>
  									</c:when>
  									<c:when test="${status.getName() eq 'student'}">
  										<label class="btn btn-default active">
											<input type="checkbox" name="statuses" autocomplete="off" value="${status.getId()}" checked>${status.getName()}
										</label>
  									</c:when>
  									<c:otherwise>
  										<label class="btn btn-default">
											<input type="checkbox" name="statuses" autocomplete="off" value="${status.getId()}">${status.getName()}
										</label>
  									</c:otherwise>
								</c:choose>
							</c:forEach>
						</div>
					</div>
					<div class="form-group text-center">
						<button class="btn btn-primary btn-lg" type="submit">Créer</button>
					</div>
				</form>
			</div>
		</div>
	</jsp:body>
</t:main>