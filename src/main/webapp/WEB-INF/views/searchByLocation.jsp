<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<!-- Adding CSS file -->
<link rel="stylesheet" type="text/css" href="resources/css/bootstrap.min.css"/>
<link rel="stylesheet" type="text/css" href="resources/css/common.css"/>
<!-- Finish adding tags -->
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

		<form:form action="searchAction" method="POST" modelAttribute="searchData">
			<div class="imageDiv">
				<!--This Section is Used For Searching the Hotel And Displaying them-->
				<section class="col-sm-8">
					<div class="searchDiv">
						<!--Input SearchBox-->
						<div class="input-group">
							<form:input path="hotelLocation" cssClass="form-control"
								placeholder="Enter Location.."/> <div
								class="input-group-btn"> <!--For searchButton-->
								<div class="searchBtn">
									<button class="btn btn-default" type="submit">
										<span class="glyphicon glyphicon-search"></span>
									</button>
									<!--Close SearchButton-->
								</div>
							</div>
						</div>
					</div>
				</section>
			</div>
			</form:form>
		</div>
	</div>
	<br/>
	<br/>
	
	<div class="container-fluid">
	
	<div class="row">
	<c:forEach var="hotelBasedOnLocation" items="${hotels}">
		<div class="col-md-4">
			<div class="panel panel-default">
				<div class="panel-heading">
					<h3 class="panel-title">
						<c:out value="${hotelBasedOnLocation.hotelName}" />
					</h3>
				</div>
				<div class="panel-body">
					  <img src="resources/pic/hotel1.jpeg" height="150"
											width="370" class="img-rectangle" />
				</div>
				<div class="panel-footer">
					<c:out value="${hotelBasedOnLocation.hotelDescription}" /><br/>
					<c:out value="${hotelBasedOnLocation.hotelWebsite}" />
					<p>
				      <a class="btn" href="hotelTemplate/<c:out value="${hotelBasedOnLocation.id}" />">View details »</a>
			       </p>
				</div>
			</div>
		</div>
		</c:forEach>
		
	</div>

</div>
	
</body>
</html>