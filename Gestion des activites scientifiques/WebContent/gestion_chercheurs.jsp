<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- Meta, title, CSS, favicons, etc. -->
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">

<title>Administration |</title>
<link rel="icon" type="image/png" sizes="96x96" href="assets/img/favicon.png">

<!-- Bootstrap -->	
<link href="vendors/bootstrap/dist/css/bootstrap.min.css"
	rel="stylesheet">
<!-- Font Awesome -->
<link href="vendors/font-awesome/css/font-awesome.min.css"
	rel="stylesheet">
<!-- NProgress -->
<link href="vendors/nprogress/nprogress.css" rel="stylesheet">
<!-- iCheck -->
<link href="vendors/iCheck/skins/flat/green.css" rel="stylesheet">

<!-- Custom Theme Style -->
<link href="build/css/custom.min.css" rel="stylesheet">
</head>

<body class="nav-md">
	<div class="container body">
		<div class="main_container">
			<div class="col-md-3 left_col">
				<div class="left_col scroll-view">
					<div class="navbar nav_title" style="border: 0;">
						<a href="index.html" class="site_title"><i class="fa fa-paw"></i>
							<span>Administration!</span></a>
					</div>

					<div class="clearfix"></div>

					<!-- menu profile quick info -->
					

					<!-- sidebar menu -->
					<%@ include file="/sidemenu.jsp" %>
					<!-- /sidebar menu -->

					<!-- /menu footer buttons -->
					<div class="sidebar-footer hidden-small">
						<a data-toggle="tooltip" data-placement="top" title="Settings">
							<span class="glyphicon glyphicon-cog" aria-hidden="true"></span>
						</a> <a data-toggle="tooltip" data-placement="top" title="FullScreen">
							<span class="glyphicon glyphicon-fullscreen" aria-hidden="true"></span>
						</a> <a data-toggle="tooltip" data-placement="top" title="Lock"> <span
							class="glyphicon glyphicon-eye-close" aria-hidden="true"></span>
						</a> <a data-toggle="tooltip" data-placement="top" title="Logout"
							href="login.html"> <span class="glyphicon glyphicon-off"
							aria-hidden="true"></span>
						</a>
					</div>
					<!-- /menu footer buttons -->
				</div>
			</div>

			<!-- top navigation -->
			<%@ include file="/top_nav.jsp" %>
			<!-- /top navigation -->

			<!-- page content -->
			<div class="right_col" role="main">
				<div class="">
					<div class="page-title">
						<div class="title_left">
							<h3>
								Gestion <small>Chercheurs</small>
							</h3>
						</div>
						
						<div class="title_right">
							<div class="col-md-5 col-sm-5   form-group pull-right top_search">
								<form action="<%=request.getContextPath()%>/ChercheurParMc" method="post" enctype="multipart/form-data">
									<div class="input-group">
										<input type="text" name="mc" class="form-control"
											placeholder="Chercher..."> <span
											class="input-group-btn">
											<button class="btn btn-secondary" type="submit">Go!</button>
										</span>
									</div>
								</form>
							</div>
						</div>
						
					</div>

					<div class="clearfix"></div>
					
						<div class="row">
							<div class="col-md-12">
								<div class="x_panel">
									<div class="x_title">
										<h2>Gestion</h2>
										<ul class="nav navbar-right panel_toolbox">
											<li><a class="collapse-link"><i
													class="fa fa-chevron-up"></i></a></li>
										</ul>
										<div class="clearfix"></div>
									</div>
									<div class="x_content">
										<!-- start project list -->
										<table class="table table-striped projects">
											<thead>
												<tr>
													<th style="width: 5% scope="row">Num</th>
													<th style="width: 20%">Nom</th>
													<th style="width: 20%">Prenom</th>
													<th style="width: 30%">Email</th>
													<th>profile</th>
													<th style="width: 20%">Nom équipe</th>
													<th>Supprimer</th>
													
												</tr>
											</thead>
											<tbody>
												
												<c:forEach items="${Chercheurs}" var="Chercheurs">
												<c:set var="count" value="${count + 1}" scope="page"/>
													<tr>
														<td>${count}</td>
														<td><a href="descriptionChercheur?idChercheur=${Chercheurs.getId_chercheur() }">${Chercheurs.getNom()}</a></td>
														<td>${Chercheurs.getPrenom()}</td>
														<td>${Chercheurs.getEmail()}</td>
														<td>${Chercheurs.getProfile()}</td>
														<td>${equipedao.getEquipe(Chercheurs.getId_equipe()).getNom_equipe()}</td>
														<td><a href="DeleteChercheur?idChercheur=${Chercheurs.getId_chercheur()}" class="btn btn-danger btn-xs"><i
																class="fa fa-trash-o"></i></a></td>
													</tr>
												</c:forEach>
											</tbody>
										</table>
										<!-- end project list -->
										
									
									</div>
									<a href="pdf" class="btn btn-secondary btn-xs"><i
																class="fa fa-file-pdf-o"></i></a>
								</div>
							</div>
						</div>


				
				</div>
			</div>
			<!-- /page content -->

			<!-- footer content -->
			<footer>
				<div class="pull-right">
					Gentelella - Bootstrap Admin Template by <a
						href="https://colorlib.com">Colorlib</a>
				</div>
				<div class="clearfix"></div>
			</footer>
			<!-- /footer content -->
		</div>
	</div>

	<!-- jQuery -->
	<script src="vendors/jquery/dist/jquery.min.js"></script>
	<!-- Bootstrap -->
	<script src="vendors/bootstrap/dist/js/bootstrap.bundle.min.js"></script>
	<!-- FastClick -->
	<script src="vendors/fastclick/lib/fastclick.js"></script>
	<!-- NProgress -->
	<script src="vendors/nprogress/nprogress.js"></script>
	<!-- bootstrap-progressbar -->
	<script
		src="vendors/bootstrap-progressbar/bootstrap-progressbar.min.js"></script>

	<!-- Custom Theme Scripts -->
	<script src="build/js/custom.min.js"></script>
</body>
</html>