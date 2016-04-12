<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>

<t:main>
	<div class="row">
		<div class="col-xs-12">
			<h2>Mes TimeSlots</h2>
			<div class="row">
				<c:forEach items="${timeslots}" var="timeslot">
					<c:forEach items="${users}" var="user">
						<c:forEach items="${templates}" var="template">
							<c:if test="${user.getId()==timeslot.getTeacherId()}"> 
								<c:if test="${template.getTemplateId()==timeslot.getTemplateId()}">
									<div class="col-sm-12 col-md-6 col-lg-4">
										<div class="panel panel-default">
											<div class="pull-right">
												<font color="#A1234F"><span> <i class="fa fa-file-o"></i></span></font>
											</div>
											<div class="panel-body">
												<h4><b>${timeslot.getTimeslotName()}</b></h4>
												<p>Du template <b>${template.getTemplateName()}</b></p>
												<p>Cours de <b>${user.getFirstName()} ${user.getLastName()}</b> de <b>${timeslot.getQuantity()}</b> heures</p>
												<div class="btn-group" role="group" aria-label="actions">
													<a href="${pageContext.request.contextPath}/DeleteTimeslot?id=${timeslot.getTemplateTimeslotId()}"> <i class="fa fa-times"></i> </a>
										    	</div>
											</div>
										</div>
							    	</div>
							 	</c:if>
							 </c:if>
					    </c:forEach>
					</c:forEach>
				</c:forEach>
			</div>
		</div>
	</div>
</t:main>