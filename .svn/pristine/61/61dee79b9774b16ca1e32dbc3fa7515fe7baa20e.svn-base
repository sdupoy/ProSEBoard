<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<t:main>
	<jsp:attribute name="head">
		<script
			src="${pageContext.request.contextPath}/resources/js/moment.js"
			type="text/javascript"></script>
		<script
			src="${pageContext.request.contextPath}/resources/js/moment-fr.js"
			type="text/javascript"></script>
		<script
			src="${pageContext.request.contextPath}/resources/js/bootstrap-datetimepicker.min.js"
			type="text/javascript"></script>
   		<link rel="stylesheet"
			href="${pageContext.request.contextPath}/resources/css/bootstrap-datetimepicker.min.css"
			type="text/css">
	</jsp:attribute>
	<jsp:attribute name="view_planning">en</jsp:attribute>
	<jsp:body>
		<h1>Ajouter un évènement au planning</h1>
		<form method="post">
			<div class="row">
				<div class="col-sm-6">
					<div class='col-sm-12'>
				        <div class="form-group">
			                <input type='text' class="form-control" placeholder="Nom" name="name" />
				        </div>
				    </div>
					<div class='col-sm-6'>
				        <div class="form-group">
				            <div class='input-group date' id='datetimepicker'>
				                <input type='text' class="form-control" placeholder="Début" name="start"/>
				                <span class="input-group-addon">
				                    <i class="fa fa-calendar fa-fw"></i>
				                </span>
				            </div>
				        </div>
				    </div>
				    <div class='col-sm-6'>
				        <div class="form-group">
				            <div class='input-group date' id='datetimepicker2'>
				                <input type='text' class="form-control" placeholder="Fin" name="end"/>
				                <span class="input-group-addon">
				                    <i class="fa fa-calendar fa-fw"></i>
				                </span>
				            </div>
				        </div>
				    </div>
				    <div class='col-sm-12'>
				        <div class="form-group">
			                <textarea class="form-control" name="description" placeholder="Description" style="resize: vertical"></textarea>
				        </div>
				    </div>
				</div>
		    </div>
		    <div class="row">
		    	<div class="col-xs-4 col-xs-offset-2">
		    		<button class="btn btn-primary btn-block btn-lg">Envoyer</button>
		    	</div>
		    </div>
	    </form>
		<script type="text/javascript">
		    $(function () {
		        $('#datetimepicker').datetimepicker({
		        	locale: 'fr'
		        });
		        $('#datetimepicker2').datetimepicker({
		        	locale: 'fr'
		        });
		        $("#datetimepicker").on("dp.change", function (e) {
		            $('#datetimepicker2').data("DateTimePicker").minDate(e.date);
		        });
		        $("#datetimepicker2").on("dp.change", function (e) {
		            $('#datetimepicker').data("DateTimePicker").maxDate(e.date);
		        });
		    });
	    </script>
	</jsp:body>
</t:main>