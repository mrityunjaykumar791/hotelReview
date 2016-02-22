<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
</head>
<body>
	<header>
		<%@include file="/WEB-INF/views/header.jsp"%>
	</header>
	
	
	<div class="container-fluid">
		<div class="row">
	<c:forEach var="categoryHotel" items="${categoryHotels}">
		
		<div class="col-md-4">
			<div class="panel panel-default">
				<div class="panel-heading">
					<h3 class="panel-title">
						<c:out value="${categoryHotel.hotelName}" />
					</h3>
				</div>
				<div class="panel-body">
					  <img src="resources/pic/hotel1.jpeg" height="150"
											width="370" class="img-rectangle" />
				</div>
				<div class="panel-footer">
					<c:out value="${categoryHotel.hotelDescription}" /><br/>
					<a>
					<c:out value="${categoryHotel.hotelWebsite}" />
					</a>
					<p>
				      <a class="btn" href="hotelTemplate/<c:out value="${categoryHotel.id }" />">View details »</a>
			       </p>
				</div>
			</div>
		</div>
		</c:forEach>
		
	</div>
</div>	
	
</body>
</html>