<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>User Detail</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/bootstrap.css"></link>
</head>
<body>
	<div>
		<%@include file="/WEB-INF/views/header.jsp"%>
	</div>

	<div class="container-fluid">
		<div class="row">
			<div class="col-md-2"></div>
			<div class="col-md-8">
				<!-- This table is used for displaying user details in tabular form -->
				<table class="table">
					<thead>
						<tr>
							<th>UserId</th>
							<th>FirstName</th>
							<th>LastName</th>
							<th>UserName</th>
							<th>Email</th>
						</tr>
					</thead>
					<tbody>
						<tr class="success">
							<td><c:out value="${userInfo.id}" /></td>
							<td><c:out value="${userInfo.firstName}" /></td>
							<td><c:out value="${userInfo.lastName}" /></td>
							<td><c:out value="${userInfo.userName}" /></td>
							<td><c:out value="${userInfo.userEmail}" /></td>
						</tr>

					</tbody>
				</table>
			</div>
			<div class="col-md-2"></div>
		</div>
	</div>


</body>
</html>