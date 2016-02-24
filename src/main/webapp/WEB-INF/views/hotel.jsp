<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<link rel="stylesheet" type="text/css" href="resources/css/bootstrap.min.css"/>
<link rel="stylesheet" type="text/css" href="resources/css/common.css"/>
 <script type="text/javascript" src="resources/js/jquery-1.12.0.min.js"></script> 
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</head>
<!--End Head Tag-->
<style>
  .bg-1 { 
      background-color: #1abc9c;
      color: #ffffff;
  }
  </style>
</head>
<body>

<div class="bg-1">
  <div class="container-fluid text-center">
    <img src="resources/pic/hotelrating.jpg" class="img-circle" alt="hotel" width="150" height="150">
  </div>
  </div>
	<div class="container-fluid">
	<div class="row">
		<div class="col-md-12">
		<nav class="navbar navbar-inverse">
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand" href="index">HotelReview.com</a>
			</div>
			<ul class="nav navbar-nav">
				<li class="active"><a href="index">Home</a></li>
				<li><a href="profile">Profile</a></li>
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
				<li><a href="#">Change Password</a></li>
				<li><a href="#">Add New Admin</a></li>
			</ul>
			<ul class="nav navbar-nav navbar-right">
				<li><a href="index"><span
						class="glyphicon glyphicon-user"></span><%out.println(session.getAttribute("userName"));%></a></li>
				<li><a href="logout"><span
						class="glyphicon glyphicon-log-out"></span> Logout</a></li>
			</ul>
		</div>
	</nav>
		</div>
	</div>
	<div class="row">
		<div class="col-md-4">
		</div>
		<div class="col-md-4">
		    <h5 style="color:green;">${status}</h5>
			<form:form action="adminAction" method="POST" modelAttribute="hotelData">
				<div class="form-group">
					 
				<label>Hotel Name:</label>
				<form:input path="hotelName" class="form-control" placeholder="Enter hotel Name.." />
				</div>
				<div class="form-group">
					 
					<label>Hotel Website:</label>
					<form:input path="hotelWebsite" cssClass="form-control" id="exampleInputPassword1" placeholder="Hotel Website.." />
					
				</div>
				<div class="form-group">
					 
					<label>Hotel Location:</label>
					<form:input path="hotelLocation" cssClass="form-control" id="exampleInputPassword1"  placeholder="Enter Hotel Location." />
					
				</div>
				<div class="form-group">
					 
					<label>Hotel Description:</label>
				 <form:textarea path="hotelDescription" cssClass="form-control" rows="5" id="description" placeholder="Enter Hotel Description"/>
					
				</div>
				 <div class="form-group">
  						<label for="sel1">Select list:</label>
  						<form:select class="form-control" path="hotelCategory">
  							<option value="">Select Category:</option>
  							<option value="Three-Star">Three-Star</option>
  						    <option value="Four-star">Four-Star</option>
   						    <option value="Five-star">Five-Star</option>
  						</form:select>
				</div>
				<div class="form-group">
					 
					<label>Upload Hotel Image:</label>
					<form:input path="hotelImage" id="exampleInputFile" type="file" />
					
				</div>
				<button type="submit" class="btn btn-default">
					Submit
				</button>
				<button type="reset" class="btn btn-default">
					Reset
				</button>
			</form:form>
		</div>
		<div class="col-md-4">
		</div>
	</div>
</div>
</body>
</html>