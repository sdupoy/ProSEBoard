<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:main>
<jsp:attribute name="publish_available">en</jsp:attribute>
<jsp:body>
	<div class="row">
		<div class="col-sm-10 col-md-8 col-lg-6">
			<h1>Contrat</h1>
			<br><br>
			<p class="p1"><span class="s1">Entre les soussignés :</span></p>
			<p class="p1"><span class="s1">Monsieur, Madame<span style="font-weight: bold; font-style: italic;"> <span style="text-decoration: underline;">${user.getFirstName()} ${user.getLastName()} </span></span>, 49300 ANGERS</span></p>
			<p class="p1"><span class="s1">D'une part,</span></p>
			<p class="p1"><span class="s1">&nbsp;</span></p>
			<p class="p1"><span class="s1">Et,</span></p><p class="p1"><span class="s1"><br></span><span style="font-size: 14px; line-height: 1.42857143; background-color: rgb(255, 255, 255);">La société </span><span style="font-size: 14px; line-height: 1.42857143; font-weight: bold; font-style: italic; text-decoration: underline; background-color: rgb(255, 255, 255);">ESEO</span><span style="font-size: 14px; line-height: 1.42857143; background-color: rgb(255, 255, 255);"> (</span><span style="font-size: 14.6666669845581px; line-height: 26.6666660308838px; background-color: rgb(255, 255, 255);">10 boulevard&nbsp;</span><span style="font-size: 14px; line-height: 1.42857143; background-color: rgb(255, 255, 255);">Jean Jeanneteau)&nbsp;</span><span style="font-size: 14px; line-height: 1.42857143; background-color: rgb(255, 255, 255);">représentée par</span><span style="font-size: 14px; line-height: 1.42857143; text-decoration: underline; font-style: italic; font-weight: bold; background-color: rgb(255, 255, 255);"> ${team.getTeamName()} </span><span style="font-size: 14px; line-height: 1.42857143; background-color: rgb(255, 255, 255);"> par le projet </span><span style="font-size: 14px; line-height: 1.42857143; text-decoration: underline; font-style: italic; font-weight: bold; background-color: rgb(255, 255, 255);">${team.getProjectName()}</span><span style="font-size: 14px; line-height: 1.42857143; background-color: rgb(255, 255, 255);"> en sa qualité de travail en SE.</span></p><p class="p1"><span class="s1">
</span></p><p class="p1"><span class="s1"><br></span></p><ul><li><span class="s1">Le présent contrat est conclu du <span style="text-decoration: underline; font-style: italic; font-weight: bold;">${sess.getStartDatePrintf()}</span> au <span style="text-decoration: underline; font-style: italic; font-weight: bold;">${sess.getEndDatePrintf()}</span></span></li><li><span style="font-size: 14px; line-height: 1.42857143; background-color: rgb(255, 255, 255);">Le Prestataire considerera comme strictement confidentiels, et s'interdit de divulguer, toute information, document, donnée ou concept, dont il pourra avoir connaissance à  l'occasion du présent contrat.</span></li><li><span class="s1">
<p class="p1"><span class="s1">Le Prestataire, toutefois, ne saurait être tenu pour responsable d'aucune divulgation si les éléments divulgués étaient dans le domaine public à  la date de la divulgation, ou s'il en avait connaissance, ou les obtenait de tiers par des moyens légitimes.</span></p></span></li></ul>



		<br><br>
		<a href="${pageContext.request.contextPath}/"> retour</a>
		</div>
	</div>
</jsp:body>	
</t:main>