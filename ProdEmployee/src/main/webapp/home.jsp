 <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.alphind.model.Projects"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Production Hours</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="menu.css">
</head>

<script src="menu.js"></script>
<body>
	<div id="mySidenav" class="sidenav">
		<a href="javascript:void(0)" class="closebtn" onclick="closeNav()">&times;</a>
		<a href="/ProdEmployee/dashboard">DashBoard</a>
		<a href="/ProdEmployee/home">Productive Hours</a>
	</div>
	<span style="font-size: 30px; cursor: pointer" onclick="openNav()">&#9776;
		Menu</span>
	<form action="submit" method="get">

		<table class="table table-striped table-bordered">

			<thead class="dataHead">
				<tr>
					<th>Projects</th>
					<th>Employees</th>
					<th>Productive Hours</th>
				</tr>
			</thead>

			<tbody>
				<c:forEach items="${listProject }" var="projects">
					<tr>
						<td rowspan="${projects.empSize+1}">${projects.pname}</td>
					</tr>
					<c:forEach items="${projects.employees}" var="employees">
						<tr>
							<td>${employees.fname}</td>
							<td><input name='${employees.htmlname}' type="number"></td>
						</tr>
					</c:forEach>
				</c:forEach>
			</tbody>
		</table>
		<input type="submit" value="Submit">
	</form>
</body>
</html>