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
	<form:form name="rateCardDetailsVO" method="POST"
		action="rateCardMaster" modelAttribute="rateCardDetailsVO">
		
		
		<div id="rateCardDetails">
			<table class="table table-hover small-text" id="tb">
				<tr class="tr-header">
					<th><spring:message code="skill" /></th>
					<th><spring:message code="geo" /></th>
					<th><spring:message code="department" /></th>
					<th><spring:message code="ratePerHour" /></th>
					<th><spring:message code="effective.from" /></th>
					<th><spring:message code="effective.to" /></th>
					
					<th><a href="javascript:void(0);" style="font-size: 18px;"
						id="addMore" title="Add More Rows"><span
							class="glyphicon glyphicon-plus"></span></a></th>
					<th>&nbsp;</th>
					<th>&nbsp;</th>
				<tr>
				<td>
						<form:select id="skillId" path="skillName" class="skillName" style="width:150px;height:26.5px">
							<c:forEach items="${rateCardDetailsVO.skillList}" var="element">
								<form:option value="${element.skill_id}">${element.skill_name}</form:option>
							</c:forEach>
						</form:select>
					</td>
					<td>
						<form:select id="geographyId" path="geography" class="geography" style="width:150px;height:26.5px">
							<c:forEach items="${rateCardDetailsVO.location_list}" var="element">
								<form:option value="${element.location_id}">${element.locationName}</form:option>
							</c:forEach>
						</form:select>
					</td>
					<td>
						<form:select id="deptId" path="department" class="department" style="width:150px;height:26.5px">
							<c:forEach items="${rateCardDetailsVO.deptList}" var="element">
								<form:option value="${element.dept_id}">${element.dept_name}</form:option>
							</c:forEach>
						</form:select>
					</td>
					<td>
					<form:input path="ratePerHour" maxlength="10" id="ratePerHour"
							class="ratePerHour" />
					</td>
					
					<td><form:input path="fromDate" maxlength="10" id="fromdatepicker"
							class="fromdatepicker" /></td>
					<td><form:input path="toDate" maxlength="10" id="todatepicker"
							class="todatepicker" /></td>
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
	</form:form>
</body>
 <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
 <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script type="text/javascript">

$( "#fromdatepicker,#todatepicker" ).datepicker();
	// Regex to check whether the given text having any number
	var regex = /^(.+?)(\d+)$/i;

	
	$('#noofdaysId').on('input', function (event) { 
	    this.value = this.value.replace(/[^0-9]/g, '');
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
		
		/*  var emp_leave_details = { 
		  		associate_id: $associate_id,
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
		  	        alert(data.associate_id + " " + data.workinghours);
		  	    },
		  	    error:function(data,status,er) { 
		  	        alert("error: "+data+" status: "+status+" er:"+er);
		  	    }
		  	});*/
	});

	
	jQuery(document).ready(
			function() {
				$("#geographyId").change(
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
</style>
</html>