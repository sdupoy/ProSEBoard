<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<t:main>
<jsp:attribute name="publicate_audit">en</jsp:attribute>
<jsp:body>
	<div class="row">
		<div class="col-sm-10 col-md-8 col-lg-6">
			<h1>Publication Personnalisée pour les étudiants </h1>
			<h4><small>
				<table class="table table-hover table-striped">
				   <thead> <!-- En-tête du tableau -->
				       <tr>
						   <th>Pack</th>
				           <th>Date</th>
				           <th>Equipe</th>
				           <th>Fond</th>
				           <th>Forme</th>
				           <th>Attitude</th>
				           <th>Note finale</th>
				           <th>Note finale (couleur)</th>
				           <th>Commentaire</th>
				           <th>Commentaire caché</th>
				       </tr>
				   </thead>
				
				   <tbody> <!-- Corps du tableau -->
				       <tr>
				       	   <td> 1 </td>
				           <td> <i class="fa fa-check fa-fw"></i></td>
				           <td> <i class="fa fa-check fa-fw"></i></td>
				           <td> - </td>
				           <td> - </td>
				           <td> - </td>
				           <td> - </td>
				           <td> <i class="fa fa-check fa-fw"></i></td>
				           <td> <i class="fa fa-check fa-fw"></i></td>
				           <td> - </td>
				       </tr>
				       
				       <tr>
				           <td> 2 </td>
				           <td> <i class="fa fa-check fa-fw"></i></td>
				           <td> <i class="fa fa-check fa-fw"></i></td>
				           <td> - </td>
				           <td> - </td>
				           <td> - </td>
				           <td> <i class="fa fa-check fa-fw"></i></td>
				           <td> <i class="fa fa-check fa-fw"></i></td>
				           <td> <i class="fa fa-check fa-fw"></i></td>
				           <td> - </td>
				       </tr>
				       <tr>
				       	   <td> 3 </td>
				           <td> <i class="fa fa-check fa-fw"></i></td>
				           <td> <i class="fa fa-check fa-fw"></i></td>
				           <td> <i class="fa fa-check fa-fw"></i></td>
				           <td> <i class="fa fa-check fa-fw"></i></td>
				           <td> <i class="fa fa-check fa-fw"></i></td>
				           <td> - </td>
				           <td> <i class="fa fa-check fa-fw"></i></td>
				           <td> <i class="fa fa-check fa-fw"></i></td>
				           <td> - </td>
				       </tr>
				   </tbody>
				</table>
				 <br>
				 <br>
				 <U>Choix du pack :</U>
				 <br> 
				 <form method="post" action="${pageContext.request.contextPath}/ServletSelectionPublierAudit">
				 <br>
				 1. <input type="radio" name="publicate"  value="2" required checked>
				 <br>  
				 2. <input type="radio" name="publicate" value="3">
				 <br> 
				 3. <input type="radio" name="publicate" value="4">
				 <br> 
				 <input type="hidden" value="${id}" name = "id">
				 <br>
				 <button class="btn btn-primary" type="submit">Publication</button>
				 </form>
			</small></h4>
		</div>
	</div>
</jsp:body>
</t:main>