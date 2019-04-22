<!DOCTYPE html>
<html>
<head>
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="menu.css">
<script src="menu.js"></script>
<title>Menu</title>
</head>
<body>
	<div id="mySidenav" class="sidenav">
		<img src="download.png" class="img-responsive" title="<%= request.getAttribute("user") %>"> <a
			href="javascript:void(0)" class="closebtn" onclick="closeNav()">&times;</a>
		<a href="/ProdEmployee/dashboard">DashBoard</a> <a
			href="/ProdEmployee/home">Productive Hours</a>
	</div>
	<span style="font-size: 30px; cursor: pointer" onclick="openNav()">&#9776;
		Alphind</span>
</body>
</html>
