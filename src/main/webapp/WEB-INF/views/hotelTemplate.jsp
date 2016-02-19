<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<!--title of the page-->
<title>Hotel Review</title>
<!--Adding CSS and javaScript file from bootstrap-->
<script src="resources/js/common.js"></script>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js">
	
</script>
<script src="${pageContext.request.contextPath}/resources/js/star-rating.min.js"></script>
<!--linking one anothe external CSS for styling-->
<link rel="stylesheet" type="text/css"
	href=" ${pageContext.request.contextPath}/resources/css/bootstrap.css"></link>
<link rel="stylesheet" type="text/css" href=" ${pageContext.request.contextPath}/resources/css/common.css"></link>
<link rel="stylesheet" type="text/css"
	href=" ${pageContext.request.contextPath}/resources/css/star-rating.min.css"></link>
<!--Close head tag-->
</head>
<body>
	<header>
		<%@include file="/WEB-INF/views/header.jsp"%>
	</header>
	<div class="container-fluid">
		<div class="row content">
			<!--This one is used for left side column-->
			<div class="col-sm-3 sidenav">
				<h4> <c:out value="${hotelById.hotelName }" />
				</h4>
				<ul class="nav nav-pills nav-stacked">
					<li class="active"><a href="#section1">Hotel Branch</a></li>
					<li><a href="#section2"> <c:out value="${hotelById.hotelLocation }" /></a></li>
					<li><a href="#section3">Kolkata</a></li>
					<li><a href="#section3">Mumbai</a></li>
				
				</ul>
				<br>
				<div class="input-group">
					<input type="text" class="form-control"
						placeholder="Search Hotel.." > <span
						class="input-group-btn">
						<button class="btn btn-default" type="button">
							<span class="glyphicon glyphicon-search"></span>
						</button>
					</span>
				</div>
			</div>
			<!--close left side colums-->

			<div class="col-sm-9">
				<!--Start right side column space for hotel image slide and comment-->
				<div class="ImageSlide">
					<div id="myCarousel" class="carousel slide" data-ride="carousel">
						<!-- Indicators -->
						<ol class="carousel-indicators">
							<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
							<li data-target="#myCarousel" data-slide-to="1"></li>
							<li data-target="#myCarousel" data-slide-to="2"></li>
							<li data-target="#myCarousel" data-slide-to="3"></li>
						</ol>

						<!-- Wrapper for slides -->
						<!--images for sliding-->
						<div class="carousel-inner" role="listbox">
							<div class="item active">
								<img src="${pageContext.request.contextPath}/resources/pic/prideHotel4.jpg" height="400"
									width="960" alt="HayatHotel">
							</div>

							<div class="item">
								<img src="${pageContext.request.contextPath}/resources/pic/hotel1.jpeg" height="400" width="960"
									alt="Delhi">
							</div>

							<div class="item">
								<img src="${pageContext.request.contextPath}/resources/pic/hotel2.jpeg" height="400" width="960"
									alt="Kolkata">
							</div>

							<div class="item">
								<img src="${pageContext.request.contextPath}/resources/pic/hotel3.jpg" alt="Mumbai">
							</div>
						</div>

						<!-- Left and right controls -->
						<a class="left carousel-control" href="#myCarousel" role="button"
							data-slide="prev"> <span
							class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
							<span class="sr-only">Previous</span>
						</a> <a class="right carousel-control" href="#myCarousel"
							role="button" data-slide="next"> <span
							class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
							<span class="sr-only">Next</span>
						</a>
					</div>
				</div>
				

				<form:form action="${pageContext.request.contextPath}/reviewAction" method="POST" modelAttribute="reviewData">
					<!--This div is used for textarea and button for post the review-->
					
					<% if(session.getAttribute("user") == null || session.getAttribute("user").equals("")){ %>
					<h4>Rating And Comments:</h4>
					<div id="emptyDiv"></div>
					<%} else { %>
					<h4>Leave a Comment:</h4>
					<%out.println(session.getAttribute("userName")); %>
					<div class="form-group">
						 <form:textarea path="reviewComment" cssClass="form-control" 
						 rows="5" cols="30" placeholder="Enter Comment.." required="required"/>
					</div>
					
					 <form:hidden path="hotelId" value="${hotelById.id }"/>
				     <form:hidden path="userId" value="${sessionScope.userId }"/>
					   
					<button type="submit" class="btn btn-success" >Submit</button>
					<button type="reset" class="btn btn-default" >Clear</button>
					<!-- This Div Is Used For checking Purpose for rating Value -->
				    <div class="col-sm-10">
						<input id="rating-system" type="number" class="rating" name="ratingValue" min="1"
							max="5" step="1" >
					</div>
					<%} %>
				</form:form>
				<br>
				<!-- for Posting the Review-->
				<div class="comment">
					<p id="cmnt"></p>
				</div>
				<!-- End -->

				<!--for number of comment-->
			
				<div class="badge"></div>



				<div class="row">
				<c:forEach var="reviews" items="${reviews}">
					<div class="col-sm-2 text-center">
<!-- 						this one is used for users profile pic -->
						<img src="${pageContext.request.contextPath}/resources/pic/hotel2.jpeg" class="img-circle"
							height="65" width="65" alt="hotelPic">
					</div>
					<div class="col-sm-10">
						<h4>
							<c:out value="${(reviews.userId).userName}" /> 
						</h4>
					</div>
					 <div class="panel-body">
					<c:out value="${reviews.reviewComment}" /><br/>
					</div>
					<hr/>
				</c:forEach>

				</div>
			</div>
		</div>
	</div>

	<!--Footer Section-->
	<footer class="container-fluid">
		<p>Footer Text</p>
	</footer>

</body>
</html>
