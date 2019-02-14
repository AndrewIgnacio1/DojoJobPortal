<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 

<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>Dojo Job Portal | Login</title>
<link rel="stylesheet" type="text/css" media="screen" href="css/style.css" />
</head>

<body>

	<div class="header">
		<h1>Dojo Job Portal</h1>
	</div>
	
	<div class="box_contain">
				
<!------------------------------------- Login Form ------------------------------------->		
			
			<div class="login_box">
				<h3>Login</h3>
				
				<form:form action="/process_login" method="post" modelAttribute="user">
				
					<form:errors class="errors" path="email"></form:errors>
					<form:input path="email" placeholder="email"></form:input>
						
					<form:errors class="errors" path="password"></form:errors>
					<form:input path="password" placeholder="password"></form:input>		
						
					<input class="submit" type="submit">
					
					</br>
					</br>
					<div class="acenter">
						<a href="/registration_page">Not a User? Register here.</a>
					</div>
					
				</form:form>
			</div>
	</div>
	
</body>

</html>