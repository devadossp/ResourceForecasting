<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<link href="<c:url value="/resources/css/menu_styles.css" />"
	rel="stylesheet" type="text/css" />
<script src="http://code.jquery.com/jquery-latest.min.js"
	type="text/javascript"></script>
<title></title>
<script type="text/javascript">
$(function () {
    var url = window.location.pathname; //sets the variable "url" to the pathname of the current window
    var activePage = url.substring(url.lastIndexOf('/') + 1); //sets the variable "activePage" as the substring after the last "/" in the "url" variable
        $('#cssmenu li a').each(function () { //looks in each link item within the primary-nav list
            var linkPage = this.href.substring(this.href.lastIndexOf('/') + 1); //sets the variable "linkPage" as the substring of the url path in each &lt;a&gt;
            if(activePage == 'login')
           	{
            	activePage = 'home';
           	}
            if (activePage == linkPage) { //compares the path of the current window to the path of the linked page in the nav item
                $(this).parent().addClass('active'); //if the above is true, add the "active" class to the parent of the &lt;a&gt; which is the &lt;li&gt; in the nav list
            }
        });
})
</script>
</head>
<body>
	<div id='cssmenu'>
		<ul>
			<li><a href='home'>Home</a></li>
			<li><a href='leaveplans'>Leave Plans</a></li>
			<li><a href='#'>Resource Master</a></li>
			<li><a href='#'>Location Master</a></li>
			<li><a href='#'>Rate Card Master</a></li>
			<li><a href='#'>Reports</a></li>
			<li><a href="logout" alt="Logout">Log Out</a></li>
		</ul>
	</div>
</body>
</html>