<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<link rel="stylesheet" type="text/css"
	href="resources/css/bootstrap.min.css" />
<link rel="stylesheet" type="text/css" href="resources/css/common.css" />
<style>
.bg-1 {
	background-color: #1abc9c;
	color: #ffffff;
}
</style>
</head>
<!--End Head Tag-->
<body>
	<header>
		<%@include file="/WEB-INF/views/header.jsp"%>
	</header>
	<div class="container">
		<!--Dividing in Col -->

		<div class="row">


			<div class="imageDiv">
				<!--This Section is Used For Searching the Hotel And Displaying them-->
				<section class="col-sm-8">
					<form:form action="indexAction" method="POST"
						modelAttribute="searchByNameData">
						<div class="searchDiv">
							<!--Input SearchBox-->
							<div class="input-group">
								<form:input path="hotelName" cssClass="form-control"
									placeholder="Search Hotel.." />
								<div class="input-group-btn">
									<!--For searchButton-->
									<div class="searchBtn">
										<button class="btn btn-default" type="submit">
											<span class="glyphicon glyphicon-search"></span>
										</button>
										<!--Close SearchButton-->
									</div>
								</div>
							</div>
						</div>
					</form:form>

				<!-- This container is used for Displaying the hotel List -->
					<div class="container-fluid">
						<div class="row">
						<h2 style="color:red;">${status}</h2>
							<c:forEach var="hotelsDetails" items="${hotelsList}">

								<div class="col-md-6">
									<div class="panel panel-default">
										<div class="panel-heading">
											<h3 class="panel-title">
												<c:out value="${hotelsDetails.hotelName}" />
											</h3>
										</div>
										<div class="panel-body">
											<img src="resources/pic/hotel1.jpeg" height="150" width="300"
												class="img-rectangle" />
										</div>
										<div class="panel-footer">
											<c:out value="${hotelsDetails.hotelDescription}" />
											<br />
											<b>Hotel Category:</b>
											<c:out value="${hotelsDetails.hotelCategory }" /><br/>
											<a href="#"><c:out value="${hotelsDetails.hotelWebsite}" /></a>
											<p>
												<a class="btn"
													href="hotelTemplate/<c:out value="${hotelsDetails.id }" />">View
													details »</a>
											</p>
										</div>
									</div>
								</div>
							</c:forEach>

						</div>
					</div>
				</section>
				<!--Right side column is used for displaying the popular hotel-->
				<aside class="col-sm-4">
					<h3>POPULAR HOTEL</h3>
					<div class="descriptionDiv">
						<div class="row">
							<div class="popHotel">
								<div class="col-sm-4">
									<aside>
										<a href="#"><img src="resources/pic/hotel1.jpeg"
											height="100" width="100" class="img-circle" /> <img
											src="resources/pic/five-stars.jpg" height="50" width="80" /></a>
									</aside>
								</div>
								<div class="col-sm-8">
									<aside>
										<a href="#"><b>Hotel Royal Palace..</b></a><br /> Hotel Royal
										Jaipur Palace Jaipur | Book Online Hotel Royal Jaipur Palace
										hotel rooms at best rates. Check hotels rooms, amenities,
										photos, reviews, deals, and ... <br /> <b>Style:</b>
										Boutique/Design. ...<br />
									</aside>
								</div>
							</div>
						</div>
						<div class="row">
							<div class="popHotel">
								<div class="col-sm-4">
									<aside>
										<a href="#"><img src="resources/pic/hotel2.jpeg"
											height="100" width="100" class="img-circle" /> <img
											src="resources/pic/five-stars.jpg" height="50" width="80" /></a>
									</aside>
								</div>
								<div class="col-sm-8">
									<aside>
										<a href="#"><b>Hotel Royal Palace..</b></a><br /> Hotel Royal
										Jaipur Palace Jaipur | Book Online Hotel Royal Jaipur Palace
										hotel rooms at best rates. Check hotels rooms, amenities,
										photos, reviews, deals, and ... <br /> <b>Style:</b>
										Boutique/Design. ...<br />
									</aside>
								</div>
							</div>
						</div>
						<div class="row">
							<div class="popHotel">
								<div class="col-sm-4">
									<aside>
										<a href="#"><img src="resources/pic/hotel3.jpg"
											height="100" width="100" class="img-circle" /> <img
											src="resources/pic/five-stars.jpg" height="50" width="80" /></a>
									</aside>
								</div>
								<div class="col-sm-8">
									<aside>
										<a href="#"><b>Hotel Royal Palace..</b></a><br /> Hotel Royal
										Jaipur Palace Jaipur | Book Online Hotel Royal Jaipur Palace
										hotel rooms at best rates. Check hotels rooms, amenities,
										photos, reviews, deals, and ... <br /> <b>Style:</b>
										Boutique/Design. ...<br />
									</aside>
								</div>
							</div>

						</div>
					</div>

				</aside>
				<!--Close aside tag here-->
			</div>
		</div>
	</div>
	<!--Footer Section-->
	<footer>
		<div class="footerDiv">
			Our address is mancheshwar industerial state mindfire solutions. <br />
			All Site Content is copy Copyright.<br /> This page as generated on
			13/01/2016 <br /> Developed By: mindfiresolutions.
		</div>
	</footer>
	<!--Close Footer tag-->
</body>
</html>
