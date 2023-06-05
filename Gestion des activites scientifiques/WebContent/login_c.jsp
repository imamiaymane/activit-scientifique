<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<html lang="en" class="fullscreen-bg">
<head>
	<title>Espace Scientifique</title>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0">
	<!-- VENDOR CSS -->
	<link rel="stylesheet" href="assets/css/bootstrap.min.css">
	<link rel="stylesheet" href="assets/vendor/font-awesome/css/font-awesome.min.css">
	<link rel="stylesheet" href="assets/vendor/linearicons/style.css">
	<!-- MAIN CSS -->
	<link rel="stylesheet" href="assets/css/main.css">
	<!-- FOR DEMO PURPOSES ONLY. You should remove this in your project -->
	<link rel="stylesheet" href="assets/css/demo.css">
	<!-- GOOGLE FONTS -->
	<link href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600,700" rel="stylesheet">
	<!-- ICONS -->
	<!--  -->
	<link rel="apple-touch-icon" sizes="76x76" href="assets/img/apple-icon.png">
	<link rel="icon" type="image/png" sizes="96x96" href="assets/img/favicon.png">
</head>

<body>
	<!-- WRAPPER -->
	<div id="wrapper">
		<div class="vertical-align-wrap">
			<div class="vertical-align-middle">
				<div class="auth-box ">
					<div class="left">
						<div class="content">
							<div class="header">
								<div class="logo text-center"><img src="assets/img/test.jpg" alt="Logo"></div>
									<p class="lead">Accéder à votre compte</p>
								</div>
								<p style="color:red;"><c:out value="${msg2}"/></p>
								<form class="form-auth-small" action="<%=request.getContextPath()%>/login" method="post">
									<div class="form-group">
										<label for="signin-email" class="control-label sr-only">Email</label>
										<input type="email" class="form-control" id="signin-email" placeholder="Email académique" name="email" required>
									</div>
									<div class="form-group">
										<label for="signin-password" class="control-label sr-only">Password</label>
										<input type="password" pattern=".{8,30}" class="form-control" id="signin-password" placeholder="Password" name="pass" required>
									</div>
									<button type="submit" class="btn btn-primary btn-lg btn-block">LOGIN</button>
									<div class="bottom">
										<span class="helper-text"> <a href="registration_home.jsp">S'inscrire</a></span>
									</div>
								</form>
							</div>
						</div>
					<div class="right"></div>
					<div class="clearfix"></div>
				</div>
			</div>	
		</div>
	</div>
	<!-- END WRAPPER -->
</body>

</html>
