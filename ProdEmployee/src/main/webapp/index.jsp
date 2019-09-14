<html>
<head>
<!-- Compiled and minified CSS -->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css">

<!-- Compiled and minified JavaScript -->
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js"></script>

<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script
	src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">


<title>Login Page</title>

<!--Custom styles-->
<link rel="stylesheet" href="index.css">

<script type="text/javascript">
	$(document).ready(function() {
		M.updateTextFields();
	});
</script>

</head>
<body>
	<form action="login" method="post">
		<div class="container">
			<div class="d-flex justify-content-center h-80">
				<div class="card">
					<div class="card-header">
						<img src="ALPHIND_Logo1.png" class="image">
					</div>
					<div class="card-body">
						<div class="input-field">
							<i class="material-icons prefix">account_circle</i><input
								id="icon_prefix" type="text" class="validate input-field"
								placeholder="username" name="uname" required="required"
								autocomplete="off">
						</div>
						<div class="input-field">
							<i class="material-icons prefix">vpn_key</i> <input
								type="password" class="validate" placeholder="password"
								name="pass" required="required">
						</div>
					</div>
					<div class="form-group card-footer">
						<input type="submit" value="Login"
							class="btn float-right login_btn">
					</div>
				</div>
			</div>
		</div>
	</form>
</body>
</html>
