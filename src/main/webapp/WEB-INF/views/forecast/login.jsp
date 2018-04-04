<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
	<head>
	    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	    <link href="<c:url value="/resources/css/styles.css" />" rel="stylesheet" type="text/css" />
	    <title>Login Form2</title>
	</head>
	<body>
		<div class="login">
			<form:form name="login" method="POST" action="login" modelAttribute="loginBean">
				<form:input placeholder="Username" id="username" path="userName"/>
				<form:password placeholder="password" id="password" path="password"/>
					<input type="submit" value="Sign In">
			</form:form>	
		</div>
		<div class="shadow"></div>
		<p>${msg}</p>
	</body>
</html>