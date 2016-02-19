<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Header</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
  <style>
  .bg-1 { 
      background-color: #1abc9c;
      color: #ffffff;
  }
  </style>
</head>
<body>

<div class="bg-1">
  <div class="container text-center">
    <img src=" ${pageContext.request.contextPath}/resources/pic/hotelrating.jpg" class="img-circle" alt="hotel" width="150" height="150">
  </div>
<!--For Navigation Bar-->
	<nav class="navbar navbar-inverse">
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand" href="${pageContext.request.contextPath}/index">HotelReview.com</a>
			</div>
			<ul class="nav navbar-nav">
				<li class="active"><a href="${pageContext.request.contextPath}/index">Home</a></li>
				<li class="dropdown">
							 <a href="#" class="dropdown-toggle" data-toggle="dropdown">SearchByCategory<strong class="caret"></strong></a>
							<ul class="dropdown-menu">
								<li>
									<a href="${pageContext.request.contextPath}/threeStar">Three-Star</a>
								</li>
								<li class="divider">
								</li>
								<li>
									<a href="${pageContext.request.contextPath}/fourStar">Four-Star</a>
								</li>
								<li class="divider">
								</li>
								<li>
									<a href="${pageContext.request.contextPath}/fiveStar">Five-Star</a>
								</li>
				            </ul>
				    </li>
				<li><a href="${pageContext.request.contextPath}/searchByLocation">SearchByLocation</a></li>
				<%if(session.getAttribute("user") == null || session.getAttribute("user").equals("") || session.getAttribute("user").equals("user")){ %>
				<li></li>
				<%} else { %>
				<li><a href="${pageContext.request.contextPath}/hotel">AddHotel</a></li>
				<%} %>
				
			</ul>
			<ul class="nav navbar-nav navbar-right">
				
				<% if(session.getAttribute("user") == null || session.getAttribute("user").equals("")){ %>
				<li><a href="${pageContext.request.contextPath}/signUp"><span
						class="glyphicon glyphicon-user"></span> Sign Up</a></li>
				<li><a href="${pageContext.request.contextPath}/signIn"><span
						class="glyphicon glyphicon-log-in"></span> Login</a></li>
						<%} else { %>
						<li><a href="${pageContext.request.contextPath}/index"><span
						class="glyphicon glyphicon-user"></span> <%out.println(session.getAttribute("userName")); %></a></li>
						
						<li><a href="${pageContext.request.contextPath}/logout"><span
						class="glyphicon glyphicon-log-out"></span> Logout</a></li>
						<%} %>
			</ul>
			
		</div>
	</nav>
	<!--End Navigation Bar-->
</div>
<div id="siteloader">
</div>
</body>
</html>
