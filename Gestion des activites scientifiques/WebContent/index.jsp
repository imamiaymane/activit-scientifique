<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Home</title>
    <meta charset="utf-8">
    <meta name="format-detection" content="telephone=no"/>
    <link rel="icon" type="image/png" sizes="96x96" href="assets/img/favicon.png">
    <link rel="stylesheet" href="css/grid.css">
    <link rel="stylesheet" href="css/style.css">
    <link rel="stylesheet" href="css/camera.css"/>
    <link rel="stylesheet" href="css/owl.carousel.css"/>
    <script src="js/jquery.js"></script>
    <script src="js/jquery-migrate-1.2.1.js"></script>
    <script src="js/jquery.equalheights.js"></script>
    <!--[if (gt IE 9)|!(IE)]><!-->
    <script src="js/jquery.mobile.customized.min.js"></script>
    <!--<![endif]-->
    <script src="js/camera.js"></script>
    <script src="js/owl.carousel.js"></script>
    <!--[if lt IE 9]>
    <div style=' clear: both; text-align:center; position: relative;'>
        <a href="http://windows.microsoft.com/en-US/internet-explorer/products/ie/home?ocid=ie6_countdown_bannercode">
            <img src="http://storage.ie6countdown.com/assets/100/images/banners/warning_bar_0000_us.jpg" border="0"
                 height="42" width="820"
                 alt="You are using an outdated browser. For a faster, safer browsing experience, upgrade for free today."/>
        </a>
    </div>
    <script src="js/html5shiv.js"></script>
    <link rel="stylesheet" type="text/css" media="screen" href="css/ie.css">
    <![endif]-->
</head>
<body>
<div class="page">
<!--========================================================
                          HEADER
=========================================================-->
<header id="header">
    <div id="stuck_container">
        <div class="container">
            <div class="row">
                <div class="grid_12">
                    <div class="brand put-left">
                        <h1>
                            <a href="index.jsp">
                                <img src="images/umi_logo.png" alt="Logo"/>
                            </a>
                        </h1>
                    </div>
                    <nav class="nav put-right">
                        <ul class="sf-menu">
                            <li class="current"><a href="index.jsp">Home</a></li>	
                            
                            <li><a href="contacts.jsp">Contacts</a></li>
                            <c:if test="${empty sessionScope.nom}">
                            <li>
                                <a >Se connecter</a>
                                <ul>
                                    <li><a href="login.jsp">Admin</a></li>
                                    <li><a href="login_c.jsp">Chercheur</a></li>
                                </ul>
                            </li>
                            </c:if>
                            <c:if test="${sessionScope.nom ne null}">
                            <li>
                            	<a href="EspaceCh">Espace Chercheur</a>
                            	<a href="logout">Deconnecter</a>
                            </li>
                            </c:if>
                        </ul>
                    </nav>
                </div>
            </div>
        </div>
    </div>
</header>
<!--========================================================
                          CONTENT
=========================================================-->
<section id="content">
<div class="camera-wrapper">
    <div id="camera">
        <div data-src="images/index_slide01.jpg">
            <div class="fadeIn camera_caption">
                <h2 class="text_1 color_1">l'espace scientifique parfait</h2>
                <c:if test="${empty sessionScope.nom}">
                	<a class="btn_1" href="registration_home.jsp">S'inscrire</a>
                </c:if>
            </div>
        </div>
        <div data-src="images/index_slide02.jpg">
            <div class="fadeIn camera_caption">
                <h2 class="text_1 color_1">l'espace scientifique parfait</h2>
                <c:if test="${empty sessionScope.nom}">
                	<a class="btn_1" href="registration_home.jsp">S'inscrire</a>
                </c:if>
            </div>
        </div>
    </div>
</div>
<div class="container">
    <div class="row wrap_1 wrap_5">
        <div class="grid_3">
            <div class="box_1">
                <div class="icon_1"></div>
                <h3 class="text_2 color_2 maxheight1">laboratoire</h3>
                <p class="text_3 color_2 maxheight">
                    département de recherches contient des équipe de recherches.
                </p>
                <c:if test="${empty sessionScope.nom}">
                	<a href="#"></a>
                </c:if>
                <c:if test="${!empty sessionScope.nom}">
                	<a href="#"></a>
                </c:if>
                </div>
                
        </div>
        <div class="grid_3">
            <div class="box_1">
                <div class="icon_2"></div>
                <h3 class="text_2 color_2 maxheight1"><a href="#">Equipe</a></h3>
                <p class="text_3 color_2 maxheight">
                    unitée de laboratoire contient des chercheurs.
                </p>
                <a href="#"></a></div>
        </div>
        <div class="grid_3">
            <div class="box_1">
                <div class="icon_3"></div>
                <h3 class="text_2 color_2 maxheight1"><a href="#">Chercheur</a></h3>
                <p class="text_3 color_2 maxheight">
                    des enseignants, docteurs et doctorants de la faculte des sciences
                </p>
                <a  href="#"></a></div>
        </div>
        <div class="grid_3">
            <div class="box_1">
                <div class="icon_4"></div>
                <h3 class="text_2 color_2 maxheight1"><a href="#">Activites Scientifiques</a></h3>
                <p class="text_3 color_2 maxheight">
                   	publications, conférances, projets de recherches..
                </p>
                <a href="#"></a></div>
        </div>
    </div>
</div>
   <div class="container">
            <div class="row  wrap_10">
                <div class="grid_12">
                    <div class="header_1 wrap_3 color_3">
                        rester en contact
                    </div>
                    <div class="box_3">
                        <ul class="list_1">
                            <li><a class="fa fa-twitter" href="https://twitter.com/umi_meknes"></a></li>
                            <li><a class="fa fa-facebook" href="https://www.facebook.com/umi.meknes"></a></li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </section>
</div>
<!--========================================================
                          FOOTER
=========================================================-->
<footer id="footer" class="color_9">
    <div class="container">
        <div class="row">
            <div class="grid_12">
                <p class="info text_4 color_4">
                    © <span id="copyright-year"></span> | <a href="#">Privacy Policy</a> <br/>
                </p>
            </div>
        </div>
    </div>
</footer>
<script src="js/script.js"></script>
</body>
</html>