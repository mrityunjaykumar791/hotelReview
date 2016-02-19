<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<!--tell the IE to use the latest rendering engine-->
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<!--set the page width to size of the device and zoom level to 1-->
<meta name="viewport" content="width=device-width,initial-scale=1">
<title>Sign Up</title>
<link rel="stylesheet" type="text/css"
	href="resources/css/bootstrap.min.css"/>
<script src="resources/js/common.js"></script>
</head>
<body>
	<header>
		<%@include file="/WEB-INF/views/header.jsp"%>
	</header>
	
		<div class="row">
		
			<div class="col-md-4"></div>

			<div class="col-md-4">
			<form:form action="signUpAction" method="post" modelAttribute="signUpData">
				<!--to make the form in the center of the page-->
				
				<h2>SignUp</h2>
				<div class="form-group has-feedback">
					<form:input path="firstName" cssClass="form-control" placeholder="FirstName" required="required"/> <i
						class="glyphicon glyphicon-user form-control-feedback"></i>
				</div>
				<div class="form-group has-feedback">
					<form:input path="lastName" cssClass="form-control" placeholder="LastName" required="required"/> <i
						class="glyphicon glyphicon-user form-control-feedback"></i>
				</div>
				
				<div class="form-group has-feedback">
					<form:input path="userName" cssClass="form-control" placeholder="UserName" required="required"/> <i
						class="glyphicon glyphicon-user form-control-feedback"></i>
				</div>
				
				<div class="form-group has-feedback">
					<form:input path="userEmail" type="email" cssClass="form-control" placeholder="Enter Email" required="required"/> <i
						class="glyphicon glyphicon-envelope form-control-feedback"></i>
				</div>

				<div class="form-group has-feedback">
					<form:password path="password" cssClass="form-control" id="password" placeholder="Password" required="required"/> <i
						class="glyphicon glyphicon-lock form-control-feedback"></i>
				</div>

				<div class="form-group has-feedback">
					<input type="password" class="form-control"
						placeholder="Confirm Password" name="cnfPassword" id="cnfPassword" onblur="passValidate()" required="required"/>
					<i class="glyphicon glyphicon-lock form-control-feedback"></i>
				</div>

				<div class="row">
					<span class="col-md-6"> <input
						type="submit" class="btn btn-primary custom-but  btn-signin"
						value="Submit" />
						<button type="reset" class="btn btn-default">
					    Reset
				       </button>
					</span>
				</div>
	</form:form>
		
	<!--row-->
	<!--forgot password-->
	<form action="signIn">
		<div>
			<label>Already Registered:<a href="signIn" class="graycolor">Click
					Here</a></label>
		</div>
	</form>
	</div>
	</div>
	<div class="col-md-4"></div>

	<!--Close Body-->
</body>
</html>
