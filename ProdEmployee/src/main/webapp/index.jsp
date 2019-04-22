<html>
<head>
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script
	src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<title>Login Page</title>
<!--Bootsrap 4 CDN-->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">

<!--Fontawesome CDN-->
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.3.1/css/all.css">

<!--Custom styles-->
<link rel="stylesheet" href="main1.css">

</head>
<body>
	<header>
		<h1 style="color: darkorange;">Full Time Equivalents</h1>
	</header>
	<form action="login" method="post">
		<div class="container">
			<div class="d-flex justify-content-center h-80">
				<div class="card">
					<div class="card-header">
						<center>
							<img src="ALPHIND_Logo1.png" width="60%">
						</center>
					</div>
					<div class="card-body">

						<div class="input-group form-group">
							<div class="input-group-prepend">
								<span class="input-group-text"><i class="fas fa-user"></i></span>
							</div>
							<input type="text" class="form-control" placeholder="username"
								name="uname">

						</div>
						<div class="input-group form-group">
							<div class="input-group-prepend">
								<span class="input-group-text"><i class="fas fa-key"></i></span>
							</div>
							<input type="password" class="form-control"
								placeholder="password" name="pass">
						</div>
						<div class="form-group">
							<input type="submit" value="Login"
								class="btn float-right login_btn">
							<!-- <button class="btn float-left login_btn"><a href="register.jsp">Register</a></button> -->
						</div>

					</div>
				</div>
			</div>
		</div>
	</form>
</body>
</html>
