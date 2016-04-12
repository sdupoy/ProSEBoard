<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<t:main>
	<jsp:attribute name="view_planning">en</jsp:attribute>
	<jsp:attribute name="head">
		<script
			src="${pageContext.request.contextPath}/resources/planning/dhtmlxscheduler.js"
			type="text/javascript"></script>
   		<link rel="stylesheet"
			href="${pageContext.request.contextPath}/resources/planning/dhtmlxscheduler.css"
			type="text/css">
		<script src="${pageContext.request.contextPath}/resources/planning/locale/locale_fr.js" charset="utf-8"></script>
		<script src="${pageContext.request.contextPath}/resources/planning/ext/dhtmlxscheduler_readonly.js" charset="utf-8"></script>
		<script src="${pageContext.request.contextPath}/resources/planning/ext/dhtmlxscheduler_quick_info.js" charset="utf-8"></script>
		<style>
			.dhx_now div{
				background:#d0d0d0 !important;
			}
			
			.dhx_cal_event_clear {
    			color: #FFF !important;
    			height: 26px !important;
				padding-left: 9px !important;
				line-height: 26px !important;
			}
			
			.dhx_cal_event_line_end {
    			border-top-right-radius: 13px !important;
    			border-bottom-right-radius: 13px !important;
			}
			.dhx_cal_event_line_start {
    			border-top-left-radius: 13px !important;
    			border-bottom-left-radius: 13px !important;
			}
			.dhx_cal_event_line{
				/*background:#A1234F !important;*/
			}
			.dhx_scale_holder_now{
				background-image: url(${pageContext.request.contextPath}/resources/Images/databg_now.png) !important;
			}
			.dhx_header, .dhx_body, .dhx_footer, .dhx_title{
				/*background:#A1234F !important;*/
			}
			.dhx_cal_quick_info{
				background: #381322;
				border:none;
				border-radius:6px;
				transition: none;
			}
			.dhx_cal_qi_content{
				background:#381322;
				border:none;
				color: #DBCCD1;
			}
			#page-content-wrapper{
				padding:0;
			}
		</style>
	</jsp:attribute>
	<jsp:body>
		<h2>Planning de ${owner.getFirstName()} ${owner.getLastName()}</h2>
		<div class="row" style="height:100%;">
			<div id="scheduler_here" class="col-xs-12 dhx_cal_container" style='width:100%; height:calc(100vh - 109px); padding: 10px;'>
	   			<div class="dhx_cal_navline">
	       			<div class="dhx_cal_prev_button">&nbsp;</div>
	       			<div class="dhx_cal_next_button">&nbsp;</div>
	       			<div class="dhx_cal_today_button"></div>
			        <div class="dhx_cal_date"></div>
	       			<div class="dhx_cal_tab" name="day_tab"></div>
	       			<div class="dhx_cal_tab" name="week_tab"></div>
	       			<div class="dhx_cal_tab" name="month_tab"></div>
	   			</div>
	   			<div class="dhx_cal_header"></div>
	   			<div class="dhx_cal_data"></div>
			</div>
		</div>
		<script type="text/javascript" charset="UTF-8">
			scheduler.config.readonly = true;
			scheduler.config.first_hour = 8;
			scheduler.config.last_hour = 21;
			scheduler.config.separate_short_events = true;
			scheduler.config.icons_select = [];
			scheduler.config.hour_size_px = 88;
			scheduler.attachEvent("onTemplatesReady", function(){
			    scheduler.templates.event_text=function(start,end,event){
			        return "<b>" + event.text + "</b>&nbsp;&nbsp;<i>" + event.description + "</i>";
			    }
			}); 
			
			var k = 0;
			var events = [
							<c:forEach items="${events}" var="event">
								{
									id:k++, text:"${event.getName()}",
									start_date:"${event.getStartDateString()}",
									end_date:"${event.getEndDateString()}",
									<c:choose>
							    		<c:when test="${event.getType() eq 'audit'}">
							       			color:"#FF0051",
					    				</c:when>
						       			<c:when test="${event.getType() eq 'consulting'}">
						       				color:"#B51CED",
						    			</c:when>
						       			<c:when test="${event.getType() eq 'training'}">
						       				color:"#13EDA8",
					    				</c:when>
						    			<c:otherwise>
						    				color:"#41BBE0",
						    			</c:otherwise>
									</c:choose>
									description:"${event.getDescription()}"
								},
							</c:forEach>
							<c:forEach items="${redmineEvents}" var="event">
								{
									id:k++,
									text:"${event.getSubject()}",
									start_date:"${event.getStartDateString()}",
									end_date:"${event.getClosedDateString()}",
									description:"${event.getDescription()}",
									color:"#FF6666"
								},
							</c:forEach>
			              ];
			
			function initScheduler() {
				scheduler.init('scheduler_here', new Date(), "week");
				scheduler.parse(events, "json");//takes the name and format of the data source
			}
			scheduler.templates.quick_info_content = function(start, end, ev){ 
			       return ev.description || ev.text;
			};
			initScheduler();
		</script>
	</jsp:body>
</t:main>