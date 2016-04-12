<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:main>
<jsp:attribute name="create_audit">en</jsp:attribute>
<jsp:body>
	<div class="row">
		<div class="col-sm-10 col-md-8 col-lg-6">
			<h1>Rapport d'Audit</h1>
			<form method="post" action="${pageContext.request.contextPath}/audit/creer">
				<h4><small>
					<br>
						<select class="form-control" name="idTeam" >
							<c:forEach items="${teams}" var="team">
									<option value="${team.getId()}">${team.getTeamName()}</option>
							</c:forEach>
						</select>
					<br>
					Fond : &nbsp; &nbsp; &nbsp;        
					<input type="radio" name="color1" value="1"required>
					<img src="${pageContext.request.contextPath}/resources/Images/Rond-vert.jpg"/>
					<input type="radio" name="color1" value="2" checked = "checked">
					<img src="${pageContext.request.contextPath}/resources/Images/Rond-orange.jpg" />
					<input type="radio" name="color1" value="3"> 
					<img src="${pageContext.request.contextPath}/resources/Images/Rond-rouge.jpg"/> <br>
					Forme : &nbsp; &nbsp;        
					<input type="radio" name="color2" value="1"required>
					<img src="${pageContext.request.contextPath}/resources/Images/Rond-vert.jpg"/>
					<input type="radio" name="color2" value="2" checked = "checked">
					<img src="${pageContext.request.contextPath}/resources/Images/Rond-orange.jpg"/>
					<input type="radio" name="color2" value="3"> 
					<img src="${pageContext.request.contextPath}/resources/Images/Rond-rouge.jpg"/> <br>
					Attitude : &nbsp;
					<input type="radio" name="color3" value="1"required>
					<img src="${pageContext.request.contextPath}/resources/Images/Rond-vert.jpg"/>
					<input type="radio" name="color3" value="2" checked = "checked">
					<img src="${pageContext.request.contextPath}/resources/Images/Rond-orange.jpg"/>
					<input type="radio" name="color3" value="3"> 
					<img src="${pageContext.request.contextPath}/resources/Images/Rond-rouge.jpg"/> <br>
					<br> <br>
					Note finale : &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<input type="radio" name="final_color" value="1"required>
					<img src="${pageContext.request.contextPath}/resources/Images/Rond-vert.jpg"/>
					<input type="radio" name="final_color" value="2" checked = "checked">
					<img src="${pageContext.request.contextPath}/resources/Images/Rond-orange.jpg"/>
					<input type="radio" name="final_color" value="3"> 
					<img src="${pageContext.request.contextPath}/resources/Images/Rond-rouge.jpg"/> <br>
					<br> <br>
					Note finale : 
					<input class="form-control" type="number" name="note" min="0" max ="20" step="0.1" required value ="10"><br>
					<br><br>
					Commentaires : <br>
					<TEXTAREA name="report" rows="8" cols="80"required autofocus ></TEXTAREA>
					<br><br> 
					Commentaires cachés :<br>
					<TEXTAREA name="comment" rows="8" cols="80"required></TEXTAREA>
					<br><br>
					<button class="btn btn-primary" type="submit">Créer</button>
				</small></h4>
			</form>
		</div>
	</div>
</jsp:body>
</t:main>

