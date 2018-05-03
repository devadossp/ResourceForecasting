<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<link rel="stylesheet" type="text/css"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
<link
	href="//code.jquery.com/ui/1.11.0/themes/smoothness/jquery-ui.min.css"
	rel="stylesheet" type="text/css" />
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
<script src="//code.jquery.com/jquery-1.9.1.js"></script>
</head>
<body>
	<jsp:include page="menu.jsp" />
	<form:form name="userDetailsScreenVO" method="POST"
		action="leaveDetails" modelAttribute="userDetailsScreenVO">
		<div class="rowClass">
			<label class="fieldName"><spring:message code="project.name" /></label>
			<c:out value="${userDetailsScreenVO.projectId}" />
		</div>
		<div class="rowClass">
			<label class="fieldName"><spring:message
					code="associate.name" /></label>
			<c:out value="${userDetailsScreenVO.fullname}" />
		</div>
		<div class="rowClass">
			<label class="fieldName"><spring:message code="associate.id" /></label>
			<c:out value="${userDetailsScreenVO.empID}" />
		</div>

		<div class="rowClass">
			<label class="fieldName"><spring:message
					code="current.assignment" /></label>
			<c:out value="${userDetailsScreenVO.assignment}" />
		</div>
		<div class="rowClass" style="padding-top: 20px;">
			<input type="button" class="button" value="Next" name="next"
				onClick="showDiv()" />
		</div>

		<ul id="tabs">
			<li><a id="tab1">Forecasting</a></li>
			<li><a id="tab2">Actuals</a></li>
		</ul>

		<div class="container" id="tab1C">
			<div id="leaveForecast" style="display: none">
				<table class="table table-hover small-text" id="tb">
					<tr class="tr-header">
						<th><spring:message code="location" /></th>
						<th><spring:message code="month" /></th>
						<th><spring:message code="from.date" /></th>
						<th><spring:message code="to.date" /></th>
						<th><spring:message code="no.of.days" /></th>
						<th><spring:message code="total.hours" /></th>
						<th><spring:message code="working.hours" /></th>
						<th><a href="javascript:void(0);" style="font-size: 18px;"
							id="addMore" title="Add More Rows"><span
								class="glyphicon glyphicon-plus"></span></a></th>
						<th>&nbsp;</th>
						<th>&nbsp;</th>
					
					<c:if test="${not empty leaveDetailsList[0]}">				
				<c:forEach var="leaveDetailsList" items="${leaveDetailsList[0]}">
				<tr>
					<td>
						<form:select id="locationId" path="location" class="location" style="width:150px;height:26.5px">
							<c:forEach items="${userDetailsScreenVO.location_list}" var="element">							
								<c:choose>
								<c:when test="${element.location_id eq leaveDetailsList.locationid}">
								<form:option value="${element.location_id}" selected="selected">${element.locationName}</form:option>
								</c:when>
								<c:otherwise>
								<form:option value="${element.location_id}" >${element.locationName}</form:option>
								</c:otherwise>
								</c:choose>
							</c:forEach>
						</form:select>
					</td>
					
					<td class="rowClass"><form:select id="monthId"
							path="selectedMonth" class="month"
							style="width:120px;height:26.5px">
							<c:forEach items="${userDetailsScreenVO.month_list}"
								var="element">
								<form:option value="${element.month_id}">${element.month_name}</form:option>
							</c:forEach>
						</form:select></td>
					<td><form:input path="fromDate" maxlength="10" id="fromdatepicker"
							class="fromdatepicker" value="${leaveDetailsList.fromdate}"/></td>
					<td><form:input path="toDate" maxlength="10" id="todatepicker"
							class="todatepicker" value="${leaveDetailsList.todate}"/></td>		
					<td><form:input id="noofdaysId" path="noOfDays" maxlength="3"
							style="width:50px" value="${leaveDetailsList.noofdays}"/></td>
					<td><span id="tothrsId" lang="hours">${leaveDetailsList.totalhours}</span></td>
					<td><span id="worhrsId" lang="hours">${leaveDetailsList.workinghours}</span></td>
					<td><a href='javascript:void(0);' class='remove'><span
							class='glyphicon glyphicon-remove'></span></a></td>
					<td><a href="javascript:void(0);" style="font-size: 16px;"
							id="addRowdata" title="Save"><span
								class="glyphicon glyphicon-ok-sign"></span></a></td>
					<td><a href='javascript:void(0);' class='save'><span
							class='glyphicon glyphicon-edit'></span></a></td>
				</tr>
				</c:forEach>				
				</c:if>
				<tr>
						<td><form:select id="locationId" path="location"
								class="location" style="width:150px;height:26.5px">
								<c:forEach items="${userDetailsScreenVO.location_list}"
									var="element">
									<form:option value="${element.location_id}">${element.locationName}</form:option>
								</c:forEach>
							</form:select></td>
						<td class="rowClass"><form:select id="monthId"
								path="selectedMonth" class="month"
								style="width:120px;height:26.5px">
								<c:forEach items="${userDetailsScreenVO.month_list}"
									var="element">
									<form:option value="${element.month_id}">${element.month_name}</form:option>
								</c:forEach>
							</form:select></td>
						<td><form:input path="fromDate" maxlength="10"
								id="fromdatepicker" class="fromdatepicker" /></td>
						<td><form:input path="toDate" maxlength="10"
								id="todatepicker" class="todatepicker" /></td>
						<td><form:input id="noofdaysId" path="noOfDays" maxlength="2"
								style="width:50px" /></td>
						<td><span id="tothrsId" lang="hours"></span></td>
						<td><span id="worhrsId" lang="hours"></span></td>
						<td><a href='javascript:void(0);' class='remove'><span
								class='glyphicon glyphicon-remove'></span></a></td>
						<td><a href="javascript:void(0);" style="font-size: 16px;"
							id="addRowdata" title="Save"><span
								class="glyphicon glyphicon-ok-sign"></span></a></td>
						<td><a href='javascript:void(0);' class='save'><span
								class='glyphicon glyphicon-edit'></span></a></td>
					</tr>
				</table>
			</div>
		</div>

		<div class="container" id="tab2C">
			<div id="leaveForecast">
				<table class="table table-hover small-text" id="tb2">
					<tr class="tr-header">
						<th><spring:message code="location" /></th>
						<th><spring:message code="month" /></th>
						<th><spring:message code="from.date" /></th>
						<th><spring:message code="to.date" /></th>
						<th><spring:message code="no.of.days" /></th>
						<th><spring:message code="total.hours" /></th>
						<th><spring:message code="working.hours" /></th>
						<th><a href="javascript:void(0);" style="font-size: 18px;"
							id="addMore" title="Add More Rows"><span
								class="glyphicon glyphicon-plus"></span></a></th>
						<th>&nbsp;</th>
						<th>&nbsp;</th>
					
					<c:if test="${not empty leaveDetailsList[1]}">				
				<c:forEach var="leaveDetailsList" items="${leaveDetailsList[1]}">
				<tr>
					<td>
						<form:select id="locationId" path="location" class="location" style="width:150px;height:26.5px">
							<c:forEach items="${userDetailsScreenVO.location_list}" var="element">							
								<c:choose>
								<c:when test="${element.location_id eq leaveDetailsList.locationid}">
								<form:option value="${element.location_id}" selected="selected">${element.locationName}</form:option>
								</c:when>
								<c:otherwise>
								<form:option value="${element.location_id}" >${element.locationName}</form:option>
								</c:otherwise>
								</c:choose>
							</c:forEach>
						</form:select>
					</td>
					
					<td class="rowClass"><form:select id="monthId"
							path="selectedMonth" class="month"
							style="width:120px;height:26.5px">
							<c:forEach items="${userDetailsScreenVO.month_list}"
								var="element">
								<form:option value="${element.month_id}">${element.month_name}</form:option>
							</c:forEach>
						</form:select></td>
					<td><form:input path="fromDate" maxlength="10" id="fromdatepicker"
							class="fromdatepicker" value="${leaveDetailsList.fromdate}"/></td>
					<td><form:input path="toDate" maxlength="10" id="todatepicker"
							class="todatepicker" value="${leaveDetailsList.todate}"/></td>		
					<td><form:input id="noofdaysId" path="noOfDays" maxlength="3"
							style="width:50px" value="${leaveDetailsList.noofdays}"/></td>
					<td><span id="tothrsId" lang="hours">${leaveDetailsList.totalhours}</span></td>
					<td><span id="worhrsId" lang="hours">${leaveDetailsList.workinghours}</span></td>
					<td><a href='javascript:void(0);' class='remove'><span
							class='glyphicon glyphicon-remove'></span></a></td>
					<td><a href="javascript:void(0);" style="font-size: 16px;"
							id="addRowdata" title="Save"><span
								class="glyphicon glyphicon-ok-sign"></span></a></td>
					<td><a href='javascript:void(0);' class='save'><span
							class='glyphicon glyphicon-edit'></span></a></td>
				</tr>
				</c:forEach>				
				</c:if>
				<tr>
						<td><form:select id="locationId" path="location"
								class="location" style="width:150px;height:26.5px">
								<c:forEach items="${userDetailsScreenVO.location_list}"
									var="element">
									<form:option value="${element.location_id}">${element.locationName}</form:option>
								</c:forEach>
							</form:select></td>
						<td class="rowClass"><form:select id="monthId"
								path="selectedMonth" class="month"
								style="width:120px;height:26.5px">
								<c:forEach items="${userDetailsScreenVO.month_list}"
									var="element">
									<form:option value="${element.month_id}">${element.month_name}</form:option>
								</c:forEach>
							</form:select></td>
						<td><form:input path="fromDate" maxlength="10"
								id="fromdatepicker" class="fromdatepicker" /></td>
						<td><form:input path="toDate" maxlength="10"
								id="todatepicker" class="todatepicker" /></td>
						<td><form:input id="noofdaysId" path="noOfDays" maxlength="2"
								style="width:50px" /></td>
						<td><span id="tothrsId" lang="hours"></span></td>
						<td><span id="worhrsId" lang="hours"></span></td>
						<td><a href='javascript:void(0);' class='remove'><span
								class='glyphicon glyphicon-remove'></span></a></td>
						<td><a href="javascript:void(0);" style="font-size: 16px;"
							id="addRowdata" title="Save"><span
								class="glyphicon glyphicon-ok-sign"></span></a></td>
						<td><a href='javascript:void(0);' class='save'><span
								class='glyphicon glyphicon-edit'></span></a></td>
					</tr>
					
				</table>
			</div>
		</div>
	</form:form>
</body>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script src="//code.jquery.com/jquery-1.12.4.js"></script>
<script src="//code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script type="text/javascript">
	// Regex to check whether the given text having any number
	var regex = /^(.+?)(\d+)$/i;

	
	$('#noofdaysId').on('input', function (event) { 
	    this.value = this.value.replace(/[^0-9]/g, '');
	});
	
	$('.location').on('click', function () {
		var locname=$('#location').val();
		 if (locname == '3') {
	       
	            $('#indLoc').show();
	           
	        
	    } else {
	        $('#indLoc').hide();
	    }
	});
	
	function getIdValue($row)
	{
		var $att_id = $row.find("select").attr('id');
		// To Check any number in the id attribute value 
		var match = $att_id.match(regex);
		var id_val = "";
		if (match != null) {
			id_val = $att_id
					.substring(($att_id.indexOf("Id") + 2),
							$att_id.length);

		}
		return id_val;
	}
	
	$('#locationId').on('change', function () {
		var $row = $(this).closest("tr");
		var id_val = getIdValue($row);
		var $location_id = $row.find(
				".location option:selected").val();
		var location_details = $location_id.split("|");
		var $sel_month_index = $("#monthId" + id_val).prop(
		'selectedIndex');
		if ($sel_month_index == 0) {
			$("#tothrsId" + id_val).text(
					location_details[1] * location_details[2]);
		} else {
			$("#tothrsId" + id_val).text(
					location_details[1] * location_details[3]);
		}
	});
	
	$('#monthId').on('change', function () {
		var $row = $(this).closest("tr");
		var id_val = getIdValue($row);
		var $location_id = $row.find(
				".location option:selected").val();
		var location_details = $location_id.split("|");
		var $sel_month_index = $("#monthId" + id_val).prop(
		'selectedIndex');
		if ($sel_month_index == 0) {
			$("#tothrsId" + id_val).text(
					location_details[1] * location_details[2]);
		} else {
			$("#tothrsId" + id_val).text(
					location_details[1] * location_details[3]);
		}
	});
	
	// Function add/remove the dynamic rows
	$(function() {
		var count = 1;
		// Adding new rows
		$('#addMore').on('click', function() {
			var data = $("#tb tr:eq(1)").clone(true).appendTo("#tb");
			data.find("input").val('');
			data.find('select').attr('id', function(i, val) {
				return val + count;
			});
			data.find('span[lang="hours"]').attr('id', function(i, val) {
				return val + count;
			});
			data.find('span[lang="hours"]').text('');	
			count++;
		});
		// Deleting new rows
		$(document).on('click', '.remove', function() {
			var trIndex = $(this).closest("tr").index();
			if (trIndex > 1) {
				$(this).closest("tr").remove();
			} else {
				alert("Sorry!! Can't remove first row!");
			}
		});
	});
	$( ".fromdatepicker" ).datepicker({
		stepMonths: 0,
	});

	$( ".todatepicker" ).datepicker({
		stepMonths: 0,
	});

	function showDiv() {
		$('#tabs').show();
		$('#tab1C').show();
		$('#leaveForecast').show();
	}

	$("#addRowdata").click(function() {
		var $row = $(this).closest("tr"); // Find the row
		var id_val = getIdValue($row);
		var $location_id = $row.find("#locationId"+id_val+" option:selected").val();
		var location_details = $location_id.split("|");

		var $associate_id = <c:out value="${userDetailsScreenVO.empID}" />;
		var $location = $row.find("#locationId"+id_val+" option:selected").text();
		var $noofdays = $row.find("#noofdaysId").val();
		var $month = $row.find("#monthId"+id_val+" option:selected").text();
		var $fromdate = $row.find("#fromdatepicker").val();
		var $todate = $row.find("#todatepicker").val();
		var $tothrs = $row.find("#tothrsId"+id_val).text();
		var working_hrs = $tothrs-($noofdays*location_details[1]);
		$("#worhrsId" + id_val).text(working_hrs);
		var $worhrs = $row.find("#worhrsId"+id_val).text();
		
		  var emp_leave_details = { 
		  		associate_id: $associate_id,
		  		leave_type: 'F',
		  		noofdays: $noofdays,
		  		month_name: $month,
		  		fromdate: $fromdate,
		  		todate: $todate,
		  		totalhours: $tothrs,
		  		workinghours: $worhrs
			};
		$.ajax({ 
		  	    url: "saveLeaves", 
		  	    type: 'POST', 
		  	    dataType: 'json', 
		  	    data: JSON.stringify(emp_leave_details),
		  	    contentType: 'application/json',
		  	    mimeType: 'application/json',
		  	    success: function(data) { 
		  	        alert(data.associate_id + " " + data.leave_id);
		  	    },
		  	    error:function(data,status,er) { 
		  	        alert("error: "+data+" status: "+status+" er:"+er);
		  	    }
		  	});
	});

	function validateLeave(myform) {
		myform.action = "leaveDetails?method=applyLeaveDetails";
		myform.submit();
	}

	jQuery(document).ready(
			function() {
				$("#location").change(
						function() {
							$assignment = $("select[name='assignment']");
							if ($(this).val() == "0") {
								$("select[name='assignment'] option").remove();
								$("<option>Select a Assignment</option>")
										.appendTo($assignment);
							} else if ($(this).val() == 3) {
								$("select[name='assignment'] option").remove();
								$("<option value='Offshore'>Offshore</option>")
										.appendTo($assignment);
							} else {
								$("select[name='assignment'] option").remove();
								$("<option value='Onsite'>Onsite</option>")
										.appendTo($assignment);
							}
						});
				
				$('#tabs li a:not(:first)').addClass('inactive');
				$('.container').hide();
				$('.container:first').show();
				    
				$('#tabs li a').click(function(){
				    var t = $(this).attr('id');
				  if($(this).hasClass('inactive')){ //this is the start of our condition 
				    $('#tabs li a').addClass('inactive');           
				    $(this).removeClass('inactive');
				    
				    $('.container').hide();
				    $('#'+ t + 'C').fadeIn('slow');
				 }
				});
				$('.container').hide();
				$('#tabs').hide();
			});
</script>

<style type="text/css">
.rowClass {
	padding-top: 20px;
	padding-left: 95px;
}

.button {
	background-color: #47c9af;
	border: none;
	color: white;
	padding: 10px 15px 10px 15px;
	text-align: center;
	text-decoration: none;
	display: inline-block;
	font-size: 16px;
	margin: 4px 70px;
	cursor: pointer;
	border-radius: 14px;
}

.fieldName {
	text-align: left;
	font-size: 16px;
}

#tabs {
	width: 100%;
	height: 30px;
	border-bottom: solid 1px #CCC;
	padding-right: 2px;
	margin-top: 30px;
}

a {
	cursor: pointer;
}

#tabs li {
	float: left;
	list-style: none;
	border-top: 1px solid #ccc;
	border-left: 1px solid #ccc;
	border-right: 1px solid #ccc;
	margin-right: 5px;
	border-top-left-radius: 3px;
	border-top-right-radius: 3px;
	outline: none;
}

#tabs li a {
	font-family: Arial, Helvetica, sans-serif;
	font-size: small;
	font-weight: bold;
	color: #5685bc;;
	padding-top: 5px;
	padding-left: 7px;
	padding-right: 7px;
	padding-bottom: 8px;
	display: block;
	background: #FFF;
	border-top-left-radius: 3px;
	border-top-right-radius: 3px;
	text-decoration: none;
	outline: none;
}

#tabs li a.inactive {
	padding-top: 5px;
	padding-bottom: 8px;
	padding-left: 8px;
	padding-right: 8px;
	color: #666666;
	background: #EEE;
	outline: none;
	border-bottom: solid 1px #CCC;
}

#tabs li a:hover, #tabs li a.inactive:hover {
	color: #5685bc;
	outline: none;
}

.container {
	clear: both;
	width: 100%;
	border-left: solid 1px #CCC;
	border-right: solid 1px #CCC;
	border-bottom: solid 1px #CCC;
	text-align: left;
	padding-top: 20px;
}

.container h2 {
	margin-left: 15px;
	margin-right: 15px;
	margin-bottom: 10px;
	color: #5685bc;
}

.container p {
	margin-left: 15px;
	margin-right: 15px;
	margin-top: 10px;
	margin-bottom: 10px;
	line-height: 1.3;
	font-size: small;
}

.container ul {
	margin-left: 25px;
	font-size: small;
	line-height: 1.4;
	list-style-type: disc;
}

.container li {
	padding-bottom: 5px;
	margin-left: 5px;
}
</style>
</html>