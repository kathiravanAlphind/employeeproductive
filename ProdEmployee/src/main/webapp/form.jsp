<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
	isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%-- <%@ page import="java.util.List"%> --%>
<%@ page import="com.alphind.controller.EmployeeController"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Productive Hours</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<!-- <link rel="stylesheet" href="table.css"> -->
<link rel="stylesheet" href="menu.css">
<script src="menu.js"></script>
</head>
<body>
<jsp:include page="sidemenu.jsp"></jsp:include>
<!-- 	<div id="mySidenav" class="sidenav">
		<a href="javascript:void(0)" class="closebtn" onclick="closeNav()">&times;</a>
		<a href="/ProdEmployee/dashboard">DashBoard</a> <a
			class="btn btn-primary" href="/ProdEmployee/home" role="button">Productive
			Hours</a>
	</div>
	<span style="font-size: 30px; cursor: pointer" onclick="openNav()">&#9776;
		Menu</span> -->
	<form action=select method="post">
		<input name="date" type="month" value="${date }"> <input
			type="submit" value="Select">
	</form>
	<table class="table table-striped table-bordered">
		<thead class="dataHead">
			<tr>
				<th>Week</th>
				<th>Projects</th>
				<c:forEach items="${ TeamLeader }" var="tl">
					<th>${ tl.fname }</th>
				</c:forEach>
			</tr>
		</thead>

		<tbody>
			<c:forEach items="${ listOfWeeks }" var="week">
				<tr>
					<td>${ week.weekString }</td>
					<td>
						<table class="table table-striped table-bordered">
							<c:forEach items="${ week.prolist }" var="project">
								<tr>
									<td>${ project.pname }</td>
								</tr>
							</c:forEach>
						</table>
					</td>
					<c:forEach items="${ week.tl_list }" var="tl">
						<td>
							<table class="table table-striped table-bordered">
								<c:forEach items="${ tl.projects }" var="project">
									<tr>
										<td>${ project.prod_hours }</td>
									</tr>
								</c:forEach>
							</table>
						</td>
					</c:forEach>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>