<%@tag description="Overall Page template" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@attribute name="head" fragment="true"%>
<%@attribute name="updateTraining" fragment="true"%>
<%@attribute name="completeTraining" fragment="true"%>
<%@attribute name="end_script" fragment="true"%>
<%@attribute name="header_bar" fragment="true"%>
<%@attribute name="manage_user" fragment="true"%>
<%@attribute name="create_user" fragment="true"%>
<%@attribute name="create_session" fragment="true"%>
<%@attribute name="create_audit" fragment="true"%>
<%@attribute name="create_consultingReport" fragment="true" %>
<%@attribute name="create_trainingReport" fragment="true" %>
<%@attribute name="chargeTrainingSession" fragment="true" %>
<%@attribute name="chargeConsultingSession" fragment="true" %>
<%@attribute name="view_planning" fragment="true" %>
<%@attribute name="see_all_audits" fragment="true" %>
<%@attribute name="publicate_audit" fragment="true" %>
<%@attribute name="book_consultationOrTraining" fragment="true" %>
<%@attribute name="view_consultationOrTraining" fragment="true" %>
<%@attribute name="accept_consultationOrTraining" fragment="true" %>
<%@attribute name="see_team_audits" fragment="true" %>
<%@attribute name="team" fragment="true" %>
<%@attribute name="manage_consultingReport" fragment="true"%>
<%@attribute name="view_TrainingAbsents" fragment="true"%>
<%@attribute name="manage_trainingReport" fragment="true"%>
<%@attribute name="publish_absents" fragment="true"%>
<%@attribute name="view_account" fragment="true"%>
<%@attribute name="edit_account" fragment="true"%>
<%@attribute name="payTeam" fragment="true"%>
<%@attribute name="see_my_audits" fragment="true"%>
<%@attribute name="see_my_auditsTL" fragment="true"%>
<%@attribute name="seeTeamInfos" fragment="true"%>
<%@attribute name="compare_audits" fragment="true"%>
<%@attribute name="see_audits_client" fragment="true"%>
<%@attribute name="payMembers" fragment="true"%>
<%@attribute name="create_training" fragment="true"%>
<%@attribute name="publish_training" fragment="true"%>
<%@attribute name="planifier_audit" fragment="true"%>
<%@attribute name="publish_competences" fragment="true"%>
<%@attribute name="see_request_team" fragment="true"%>
<%@attribute name="publish_available" fragment="true"%>
<%@attribute name="see_training" fragment="true"%>
<%@attribute name="manage_bills" fragment="true"%>
<%@attribute name="my_account" fragment="true"%>
<%@attribute name="template" fragment="true"%>
<%@attribute name="timesolt" fragment="true"%>


<!doctype html>
<html lang="fr">
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<title>ProSEBoard</title>
<script
	src="${pageContext.request.contextPath}/resources/js/jquery-1.11.2.min.js"
	type="text/javascript"></script>
<script
	src="${pageContext.request.contextPath}/resources/bootstrap/js/bootstrap.min.js"
	type="text/javascript"></script>
<script
	src="${pageContext.request.contextPath}/resources/js/min/perfect-scrollbar.jquery.min.js"
	type="text/javascript"></script>
<link
	href="${pageContext.request.contextPath}/resources/css/sidebar.css"
	rel="stylesheet">
<link
	href="${pageContext.request.contextPath}/resources/css/font-awesome.min.css"
	rel="stylesheet">
<link
	href="${pageContext.request.contextPath}/resources/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">
<link
	href="${pageContext.request.contextPath}/resources/css/perfect-scrollbar.min.css"
	rel="stylesheet">
<script type="text/javascript">
	$(window).load(function() {
		$("body").removeClass("preload");
	});
</script>
<jsp:invoke fragment="head" />
</head>
<body class="preload">
	<button type="button" class="btn btn-menu" style="position:absolute;z-index:9999; margin-left:2px; margin-top:22px;">
        <i class="fa fa-bars fa-2x"></i>
	</button>
	<div id="wrapper">
		<div id="sidebar-wrapper">
			<ul class="sidebar-nav">
				<li class="sidebar-brand">
					<a href="${pageContext.request.contextPath}/" class="sb-btn text-center" style="margin-left:30px;">ProSEboard</a>
				</li>
			</ul>
			<ul class="sidebar-nav sb-user text-right" id="left-content">
				<li class="sb-username">
					<p class="text-center">${user.getFirstName()} ${user.getLastName()}</p>
				</li>
				<li>
					<div class="text-center" style="height: 45px; position:relative;">
						<a href="${pageContext.request.contextPath}/ServletMessagerie"
							class="col-xs-4 sb-tool"> <i class="fa fa-comments fa-lg"></i>
							<c:if test="${count != null and count != 0}">
								<span class="count-container"> <span class="badge count">${count }</span></span>
							</c:if>
						</a>
						<a href="${pageContext.request.contextPath}/planning"
							class="col-xs-4 sb-tool"> <i
							class="fa fa-calendar fa-lg"></i>
						</a>
						<a href="${pageContext.request.contextPath}/notifications" class="col-xs-4 sb-tool">
						<i class="fa fa-bell fa-lg"></i>
							<c:if test="${notifCount != null and notifCount != 0}">
								<span class="count-container"> <span class="badge count">${notifCount}</span></span>
							</c:if>
						</a>
					</div>
				</li>
				<li class="text-center"><br />
				<a class="btn btn-danger btn-xs"
					href="${pageContext.request.contextPath}/logout">Déconnexion</a></li>
			</ul>
			<ul class="sidebar-nav text-right" id="accordion" role="tablist" aria-multiselectable="true">

				<!-- My Infos Panel Menu -->
				<c:if test="${user.hasMyInfosPanel()}">
					<li class="entry sb-btn" role="tab">
						<a href="#myinfos" data-toggle="collapse" data-parent="#accordion" aria-expanded="false" aria-controls="myinfos">
							Mes infos
						</a>
						<ul id="myinfos" class="collapse">
							<c:if test="${user.hasPermission('my_account')}">
								<li>
									<a href="${pageContext.request.contextPath}/MyAccount">
										Mon solde
									</a>
								</li>
							</c:if>	
							<c:if test="${user.hasPermission('publish_competences')}">
								<li>
									<a href="${pageContext.request.contextPath}/Competences">
										Mes compétences
									</a>
								</li>
							</c:if>
							<c:if test="${user.hasPermission('publish_available')}">
								<li>
									<a href="${pageContext.request.contextPath}/Available">
										Mes disponiblilités
									</a>
								</li>
							</c:if>						
						</ul>
					</li>
				</c:if>
				
				<!-- Admin Panel Menu -->
				<c:if test="${user.hasAdminPanel()}">
					<li class="entry sb-btn" role="tab">
						<a href="#administration" data-toggle="collapse" data-parent="#accordion" aria-expanded="false" aria-controls="administration">
							Administration
						</a>
						<ul id="administration" class="collapse">
							<c:if test="${user.hasPermission('manage_users')}">
								<li>
									<a href="${pageContext.request.contextPath}/utilisateur/gerer">
										Gérer les utilisateurs
									</a>
								</li>
							</c:if>
							<c:if test="${user.hasPermission('create_user')}">
								<li>
									<a href="${pageContext.request.contextPath}/utilisateur/creer">
										Créer un utilisateur
									</a>
								</li>
							</c:if>
							<c:if test="${user.hasPermission('create_session')}">
								<li>
									<a href="${pageContext.request.contextPath}/ManageSessions">Gérer les sessions</a>
								</li>
							</c:if>
							<c:if test="${user.hasPermission('template')}">
								<li>
									<a href="${pageContext.request.contextPath}/Templates">Templates</a>
								</li>
							</c:if>
						</ul>
					</li>
				</c:if>
				
				<!-- Team Panel Menu -->
				<c:if test="${user.hasTeamPanel()}">
					<li class="entry sb-btn" role="tab">
						<a href="#team" data-toggle="collapse" data-parent="#accordion" aria-expanded="false" aria-controls="team">
							Mon équipe
						</a>
						<ul id="team" class="collapse">
							<c:if test="${user.hasStatus('team_member')}">
								<li>
									<a href="${pageContext.request.contextPath}/team">
										Résumé
									</a>
								</li>
							</c:if>
							<c:if test="${user.hasPermission('book_consultationOrTraining')}">
								<li>
									<a href="${pageContext.request.contextPath}/TeamLeader/ReservationConsultation">
										Demander une consultation ou un cours
									</a>
								</li>	
							</c:if>
							<c:if test="${user.hasPermission('validate_consultationOrTraining')}">
								<li>
									<a href="${pageContext.request.contextPath}/TeamLeader/ValidateConsultationOrTrainingForm">
										Valider les demandes
									</a>
								</li>	
							</c:if>
							<c:if test="${user.hasPermission('pay_members')}">
								<li>
									<a href="${pageContext.request.contextPath}/PayMembers">
										Payer les membres
									</a>
								</li>
							</c:if>
							<c:if test="${user.hasPermission('edit_account')}">
								<li>
									<a href="${pageContext.request.contextPath}/EditAccountTeam">
										Modifier le budget
									</a>
								</li>
							</c:if>
							<c:if test="${user.hasStatus('team_leader')}">
								<li>
									<a href="${pageContext.request.contextPath}/ManageBills">
										Gérer les factures
									</a>
								</li>
							</c:if>
						</ul>
					</li>
				</c:if>
				
				<!-- Audit Panel Menu -->
				<c:if test="${user.hasAuditPanel()}">
					<li class="entry sb-btn" role="tab">
						<a href="#audit" data-toggle="collapse" data-parent="#accordion" aria-expanded="false" aria-controls="audit">
							Audits
						</a>
						<ul id="audit" class="collapse">
							<c:if test="${user.hasPermission('planifier_audit')}">
								<li>
									<a href="${pageContext.request.contextPath}/PlanifierAudit">
										Planifier un audit
									</a>
								</li>	
							</c:if>
							
							<c:if test="${user.hasPermission('create_audit')}">
								<li>
									<a href="${pageContext.request.contextPath}/audit/creer">
										Rédiger un rapport
									</a>
								</li>
							</c:if>
							
							<c:if test="${user.hasPermission('see_all_audits')}">
								<li>
									<a href="${pageContext.request.contextPath}/ServletVoirAudit">
										Voir tous les audits
									</a>
								</li>
							</c:if>
							
							<c:if test="${user.hasPermission('publicate_audit')}">
								<li>
									<a href="${pageContext.request.contextPath}/ServletPublierAudit">
										Voir tous mes audits
									</a>
								</li>
							</c:if>
							
							<c:if test="${user.hasPermission('see_team_audits')}">
								<li>
									<a href="${pageContext.request.contextPath}/ServletPrecedentAudit">
										Voir audits précédents
									</a>
								</li>
							</c:if>
							
							<c:if test="${user.hasPermission('see_my_audits')}">
								<li>
									<a href="${pageContext.request.contextPath}/SeeMyAudits">
										Voir mes audits
									</a>
								</li>	
							</c:if>
							
							<c:if test="${user.hasPermission('see_audits_client')}">
								<li>
									<a href="${pageContext.request.contextPath}/SeeAuditClient">
										Voir les audits d'une équipe
									</a>
								</li>	
							</c:if>
							
							<c:if test="${user.hasPermission('compare_audits')}">
								<li>
									<a href="${pageContext.request.contextPath}/CompareAudits">
										Comparer des équipes
									</a>
								</li>	
							</c:if>
							
							<c:if test="${user.hasPermission('view_account')}">
								<li>
									<a href="${pageContext.request.contextPath}/ServletPublishAccountTeam">
										Voir compte
									</a>
								</li>
							</c:if>
							
						</ul>
					</li>
				</c:if>

				<!-- Consulting Panel Menu -->
				<c:if test="${user.hasConsultingPanel()}">
					<li class="entry sb-btn" role="tab">
						<a href="#consulting" data-toggle="collapse" data-parent="#accordion" aria-expanded="false" aria-controls="consulting">
							Consultings
						</a>
						<ul id="consulting" class="collapse">
							<c:if test="${user.hasPermission('accept_consultationOrTraining')}">
								<li>
									<a href="${pageContext.request.contextPath}/AcceptConsultationOrTrainingForm">
										Accepter les demandes
									</a>
								</li>
							</c:if>
							<c:if test="${user.hasPermission('see_request_team')}">
								<li>
									<a href="${pageContext.request.contextPath}/VoirRequetesEquipe">
										Voir les requêtes d'une équipe
									</a>
								</li>	
							</c:if>
							<c:if test="${user.hasPermission('create_consulting_report') }">
								<li>
									<a href="${pageContext.request.contextPath}/consultation/creer">
										Rédiger un rapport de consultation
									</a>
								</li>
							</c:if>
							<c:if test="${user.hasPermission('manage_consulting_report')}">
								<li>
									<a href="${pageContext.request.contextPath}/consultation/manager">
										Voir les rapports de consultation
									</a>
								</li>
							</c:if>
							<c:if test="${user.hasPermission('charge_team_consulting')}">
								<li>
									<a href="${pageContext.request.contextPath}/chargeConsultingSession">
										Facturer une session de consulting
									</a>
								</li>
							</c:if>
						</ul>
					</li>
				</c:if>

				<!-- Training Panel Menu -->
				<c:if test="${user.hasTrainingPanel()}">
					<li class="entry sb-btn" role="tab">
						<a href="#training" data-toggle="collapse" data-parent="#accordion" aria-expanded="false" aria-controls="training">
							Formations
						</a>
						<ul id="training" class="collapse">
							<c:if test="${user.hasPermission('accept_consultationOrTraining')}">
								<li>
									<a href="${pageContext.request.contextPath}/AcceptConsultationOrTrainingForm">
										Accepter les demandes
									</a>
								</li>
							</c:if>
							<c:if test="${user.hasPermission('see_request_team')}">
								<li>
									<a href="${pageContext.request.contextPath}/VoirRequetesEquipe">
										Voir les requêtes d'une équipe
									</a>
								</li>	
							</c:if>
							<c:if test="${user.hasPermission('create_training')}">
								<li>
									<a href="${pageContext.request.contextPath}/Educator/CreateTraining">
										Proposer une formation
									</a>
								</li>	
							</c:if>
							<c:if test="${user.hasPermission('publish_training')}">
								<li>
									<a href="${pageContext.request.contextPath}/Educator/PublishTrainingForm">
										Proposer une séance ou modifier les formations
									</a>
								</li>	
							</c:if>
							<c:if test="${user.hasPermission('create_training_report')}">
								<li>
									<a href="${pageContext.request.contextPath}/CreateTrainingReport">
										Rédiger un rapport de formation
									</a>
								</li>
							</c:if>
							<c:if test="${user.hasPermission('see_training_report')}">
								<li>
									<a href="${pageContext.request.contextPath}/training/manager">
										Voir les rapports de formation
									</a>
								</li>
							</c:if>
							<c:if test="${user.hasPermission('charge_team_training')}"> 
								<li>
									<a href="${pageContext.request.contextPath}/chargeTrainingSession">
										Facturer une session de formation
									</a>
								</li>
							</c:if>
						</ul>
					</li>
				</c:if>


				
				<c:if test="${user.hasPermission('pay_team')}"> 
					<li class="entry">
						<a href="${pageContext.request.contextPath}/payTeam" class="sb-btn">
							Rémunérer une équipe
						</a>
					</li>
				</c:if>
				
				
				<c:if test="${user.hasStatus('client') and user.hasPermission('pay_team')}">
					<li class="entry">
						<a href="${pageContext.request.contextPath}/ManageBills"  class="sb-btn">
							Gérer les factures
						</a>
					</li>
				</c:if>

				<c:if test="${user.hasPermission('see_team_infos')}">
					<li class="entry">
						<a href="${pageContext.request.contextPath}/SeeTeamInfos" class="sb-btn">
							Voir les informations de mes équipes
						</a>
					</li>
				</c:if>
				
				
				
				
			
			</ul>
		</div>

		<jsp:invoke fragment="header_bar"/>
		<div id="page-content-wrapper">
			<div class="container-fluid">
				<div id="body">
					<c:if test="${errorMessage != null}">
						<div class="alert alert-danger">
							${errorMessage }
						</div>
						<c:remove var="errorMessage" scope="session" />
					</c:if>
					<c:if test="${successMessage != null}">
						<div class="alert alert-success">
							${successMessage }
						</div>
						<c:remove var="successMessage" scope="session" />
					</c:if>
					<jsp:doBody />
				</div>
			</div>
		</div>
	</div>
	<script type="text/javascript">
		$('.btn-menu').click(function() {
			$("#wrapper").toggleClass("toggled");
			$(this).blur();
		});
		
		$('#administration, #team, #audit, #myinfos, #consulting, #training').on('show.bs.collapse', function () {
			$(this).parent().addClass("opened");
		}).on('hide.bs.collapse', function () {
			$(this).parent().removeClass("opened");
		});
		
		$("#accordion").perfectScrollbar();
	</script>
	<jsp:invoke fragment="end_script"/>
</body>