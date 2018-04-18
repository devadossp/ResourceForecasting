<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<link href="<c:url value="/resources/css/menu_styles.css" />" rel="stylesheet" type="text/css" />
	<script src="http://code.jquery.com/jquery-latest.min.js" type="text/javascript"></script>
	<script src="script.js"></script>
<title></title>
</head>
<body>
	<div id='cssmenu'>
	<ul>
		<li class='active'><a href='#'>Home</a></li>
	    <li><a href='leaveplans'>Leave Plans</a></li>
	    <li><a href='#'>Resource Master</a></li>
	    <li><a href='#'>Location Master</a></li>
	</ul>
	</div>
	<a href="logout" alt="Logout">Log Out</a>
</body>
</html>