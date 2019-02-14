<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 

<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>Dojo Job Portal | Registration</title>
<link rel="stylesheet" type="text/css" media="screen" href="css/style.css" />
</head>

<body>

	<div class="header">
		<h1>Dojo Job Portal</h1>
	</div>
	
	<div class="box_contain">		
			
<!------------------------------------- Registration Form ------------------------------------->
			
		<div class="login_box">
			<h3>Register</h3>
					
			<form:form action="/process_registration" method="post" modelAttribute="user">		
				
				<form:errors class="errors" path="username"></form:errors>
				<form:input path="username" placeholder="username"></form:input>
					
				<form:errors class="errors" path="email"></form:errors>
				<form:input path="email" placeholder="email"></form:input>
						
				<form:errors class="errors" path="password"></form:errors>
				<form:input path="password" placeholder="password"></form:input>
						
				<form:errors class="errors" path="confirmation"></form:errors>
				<form:input path="confirmation" placeholder="confirm password"></form:input>
				
				<form:errors class="errors" path="secret_question"></form:errors>
				<form:input path="secret_question" placeholder="secret question"></form:input>
				
				<form:errors class="errors" path="secret_answer"></form:errors>
				<form:input path="secret_answer" placeholder="secret answer"></form:input>
					
				<input class="submit" type="submit">

				</br>
				</br>
				<div class="acenter">
					<a href="/">Already a User? Sign in here.</a>
				</div>
					
			</form:form>
		</div>
				
	</div>
	
</body>

</html>