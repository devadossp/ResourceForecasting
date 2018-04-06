<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link  rel="stylesheet" type="text/css" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
<link href="//code.jquery.com/ui/1.11.0/themes/smoothness/jquery-ui.min.css" rel="stylesheet" type="text/css" />
<link href="css/userMgmtStyles.css" rel="stylesheet" type="text/css" />
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script src="//code.jquery.com/jquery-1.12.4.js"></script>
<script src="//code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<form:form name="userDetails" method="POST" action="leaveDetails" modelAttribute="userDetails">
<div class="rowClass">
<label class="fieldName">Project ID:</label> HMH Incremental-DS
</div>
<div class="rowClass" >
<label class="fieldName">Location:</label>
<form:select id="location" path="location">
	<form:option value="">Select a location</form:option>
	<c:forEach items="${location_list}" var="element">
		<form:option value="${element.id}">${element.value}</form:option>
	</c:forEach>
</form:select>	 
</div>
<div class="rowClass">
<div id="indLoc">
<label class="fieldName">India Location:</label>
<form:radiobutton style="margin-left: 0px;" path="indiaLocation" id="chennai"/>
<label class="fieldName radioLabel" for="chennai">Chennai</label>
<form:radiobutton style="margin-left: 0px;" path="indiaLocation" id="bangalore"/>
<label class="fieldName radioLabel" for="bangalore">Bangalore</label>
<form:radiobutton style="margin-left: 0px;" path="indiaLocation" id="hyderabad"/>
<label class="fieldName radioLabel" for="hyderabad">Hyderabad</label>
</div>
</div>
<div class="rowClass">
<label class="fieldName">Current Assignment: </label>
<form:select  id="assignment" path="assignment">
	<form:option value="">Select a Assignment</form:option>
	<c:forEach items="${assignment_list}" var="element">
		<form:option value="${element.id}">${element.value}</form:option>
	</c:forEach>
</form:select>
</div>
<div class="rowClass" style="padding-top:20px;">
<input type="button" class="button" value="Next" name="next" onClick="showDiv()" />
</div>
<div id="showLeaveDetails" style="display:none">
<table  class="table table-hover small-text" id="tb">
<tr class="tr-header">
<th>Associate Name</th>
<th>Associate ID</th>
<th>No of Days</th>
<th>Month</th>
<th>From Date</th>
<th>To Date</th>
<th>Total Hrs</th>
<th>Working Hrs</th>
<th><a href="javascript:void(0);" style="font-size:18px;" id="addMore" title="Add More Rows"><span class="glyphicon glyphicon-plus"></span></a></th>
<tr>
<td><input type="text" name="fullname" ></td>
<td><input type="text" name="empID"></td>
<td><input type="text" name="noOfDays" ></td>
<td><select name="month" >
  <option value="" selected>Select Month</option>
    <option value="0">Jan</option>
    <option value="1">Feb</option>
    <option value="2">Mar</option>
    <option value="3">Apr</option>
    <option value="4">May</option>
    <option value="5">June</option>
    <option value="6">July</option>
    <option value="7">Aug</option>
    <option value="8">Sep</option>
    <option value="9">Oct</option>
    <option value="10">Nov</option>
    <option value="11">Dec</option>
</select></td>
<td><input type="text" name="fromDate"  id="fromdatepicker" class="fromdatepicker"></td>
<td><input type="text" name="toDate" id="todatepicker" class="todatepicker"></td>
<td><input type="text" name="totalHrs" ></td>
<td><input type="text" name="workingHrs" ></td>
<td><a href='javascript:void(0);'  class='remove'><span class='glyphicon glyphicon-remove'></span></a></td>
</tr>
</table>
</div>
</form:form>

<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
<script type="text/javascript">

	$('.location').on('click', function () {
		var locname=$('select#locate option:selected').val();
		
	    if (locname == 'india') {
	       
	            $('#indLoc').show();
	           
	        
	    } else {
	        $('#indLoc').hide();
	    }
	});
	
	$(function(){
	    $('#addMore').on('click', function() {    
	              var data = $("#tb tr:eq(1)").clone(true).appendTo("#tb");
	              data.find("input").val('');
	     });
	     $(document).on('click', '.remove', function() {
	         var trIndex = $(this).closest("tr").index();
	            if(trIndex>1) {
	             $(this).closest("tr").remove();
	           } else {
	             alert("Sorry!! Can't remove first row!");
	           }
	      });
	}); 

	$(document).ready(function() {
	$( ".fromdatepicker" ).datepicker({
		stepMonths: 0,
	});

	$( ".todatepicker" ).datepicker({
		stepMonths: 0,
	});
	});
	
	function showDiv() {
		   document.getElementById('showLeaveDetails').style.display = "block";
		}

    </script>
    
    <style type="text/css">
.rowClass{
padding-top:20px;
padding-left:95px;
}
.button{
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
.fieldName{text-align: left;font-size: 16px;}
</style>