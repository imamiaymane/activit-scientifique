<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Contacts</title>
    <meta charset="utf-8">
    <meta name="format-detection" content="telephone=no"/>
    <link rel="icon" href="assets/img/favicon.png">
    <link rel="stylesheet" href="css/grid.css">
    <link rel="stylesheet" href="css/style.css">
    <link rel="stylesheet" href="css/contact-form.css"/>
    <script src="js/jquery.js"></script>
    <script src="js/jquery-migrate-1.2.1.js"></script>
    <script src="js/jquery.equalheights.js"></script>
    <script src='js/modal.js'></script>
    <script src='js/TMForm.js'></script>
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
                                <li><a href="index.jsp">Home</a></li>
                                
                                <li class="current"><a href="contacts.jsp">Contacts</a></li>
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
        <div class="bg_1 wrap_17">
            <div class="container">
                <div class="row">
                    <div class="grid_6">
                        <div class="">
                            <h2 class="header_2 indent_5">
                                Contact Info
                            </h2>
                            <address>
                                <p class="text_7 color_6">
                                    Université Moulay Ismaïl, <br/>
                                </p>
                                <p class="text_8">
                                    notre espace : <a href="http://www.umi.ac.ma/" rel="nofollow"> umi.ac.ma</a><br/>
                                    <br/>
                                    Si vous avez des questions sur le fonctionnement du site, address <br/>
                                    <br/>
                                    Présidence, Marjane 2, BP:298, Meknes, MAROC<br/>								
									Tél : 0535 467 306 / 05 35 467 307<br/>								
									Fax :0535 467 305<br/>
									E-mail : presidence@umi.ac.ma<br/>
                                </p>
                            </address>
                        </div>
                    </div>
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