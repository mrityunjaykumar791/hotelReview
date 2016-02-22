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
<title>SignIn</title>
<link rel="stylesheet" type="text/css" href="resources/css/bootstrap.min.css">
</head>
<body>
<header>
<%@include file="/WEB-INF/views/header.jsp" %>
</header>
	
		<div class="row">
			<div class="col-md-4"></div>

			<div class="col-md-4">
				<!--to make the form in the center of the page-->
					<h2>SignIn</h2>
					<form:form action="signInAction" method="post" modelAttribute="signInData">
					<div class="form-group has-feedback">
						<form:input path="userName" class="form-control" placeholder="UserName" /> <i
							class="glyphicon glyphicon-user form-control-feedback"></i>
					</div>
					<div class="form-group has-feedback">
						<form:password path="password" class="form-control" placeholder="Password" /> <i
							class="glyphicon glyphicon-lock form-control-feedback"></i>
					</div>

					<div class="row">
						<span class="col-md-6"> <!--sign in button-->
						 <input type="submit"
								class="btn btn-primary custom-but  btn-signin" value="Login" />
								<button type="reset" class="btn btn-default">
					    		Reset
				       			</button>
						</span>

					</div>
					</form:form>
					<!--row-->
					<!--forgot password-->
					<form action="signUp">
					<div>
						<label>New User:Click Here<a href="signUp" class="graycolor">Click Here</a></label>
					</div>
					</form>
					<form:form action="forgotAction">
					<div>
						<label>Forgot your password:<a href="#" class="graycolor">Click Here</a></label>
					</div>
					</form:form>
		
			</div>
			<div class="col-md-4"></div>
		</div>

	<!--Close Body-->
</body>
</html>
