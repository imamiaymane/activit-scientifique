<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <!-- Required meta tags-->
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="Colorlib Templates">
    <meta name="author" content="Colorlib">
    <meta name="keywords" content="Colorlib Templates">

    <!-- Title Page-->
    <title>Inscription</title>
	<link rel="icon" type="image/png" sizes="96x96" href="assets/img/favicon.png">
    <!-- Icons font CSS-->
    <link href="vendor/mdi-font/css/material-design-iconic-font.min.css" rel="stylesheet" media="all">
    <link href="vendor/font-awesome-4.7/css/font-awesome.min.css" rel="stylesheet" media="all">
    <!-- Font special for pages-->
    <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i,800,800i" rel="stylesheet">

    <!-- Vendor CSS-->
    <link href="vendor/select2/select2.min.css" rel="stylesheet" media="all">
    <link href="vendor/datepicker/daterangepicker.css" rel="stylesheet" media="all">

    <!-- Main CSS-->
    <link href="css/main.css" rel="stylesheet" media="all">
</head>

<body>
    <div class="page-wrapper bg-gra-03 p-t-45 p-b-50">
        <div class="wrapper wrapper--w790">
            <div class="card card-5">
                <div class="card-heading">
                    <h2 class="title">Inscription dans l'espace scientifique</h2>
                </div>
                <div class="card-body">
                    <form action="<%=request.getContextPath()%>/registration_home" method="post"
                    enctype="multipart/form-data">
                        <div class="form-row m-b-55">
                            <div class="name">Nom et prenom:*</div>
                            <div class="value">
                                <div class="row row-space">
                                    <div class="col-2">
                                        <div class="input-group-desc">
                                            <input class="input--style-5" type="text" name="nom" required>
                                            <label class="label--desc" >nom:</label>
                                        </div>
                                    </div>
                                    <div class="col-2">
                                        <div class="input-group-desc">
                                            <input class="input--style-5" type="text" name="prenom" required>
                                            <label class="label--desc">prenom:</label>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <p style="color:red;"><c:out value="${msg1}"/></p>
                        <div class="form-row">
                            <div class="name">Email académique:*</div>
                            <div class="value">
                                <div class="input-group">
                                    <input class="input--style-5" type="email" name="email" required>
                                </div>
                            </div>
                        </div>
                        <div class="form-row">
                            <div class="name">Password:*</div>
                            <div class="value">
                                <div class="input-group">
                                    <input class="input--style-5" type="Password" pattern=".{8,30}" name="pass" splaceholder="Au moins 8 caractères" required>
                                </div>
                            </div>
                        </div>
                        <div class="form-row m-b-55">
                            <div class="name">téléphone:</div>
                            <div class="value">
                                <div class="row row-refine">
                                    <div class="col-9">
                                        <div class="input-group-desc">
                                            <input class="input--style-5" type="text" minlength="10" maxlength="10" name="telephone">
                                            <label class="label--desc">(+212)</label>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="form-row">
                            <div class="name">Photo personnelle:</div>
                            <div class="value">
                                <div class="input-group">
                                    <input class="input--style-5"  type="file"  name="photo">
                                </div>
                            </div>
                        </div>
                        <div class="form-row">
                            <div class="name">Profile:*</div>
                            <div class="value">
                                <div class="input-group">
                                    <div class="rs-select2 js-select-simple select--no-search">
                                        <select name="profile" class="input--style-5 col-9" required>
                                        	<option disabled="disabled" selected="selected">Profile</option>
                                            <option>doctorant</option>
                                            <option>docteur</option>
                                            <option>enseignant</option>
                                        </select>
                                        <div class="select-dropdown"></div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="form-row p-t-20">
                            <label class="label label--block"> <a href="login_c.jsp">déjà  inscrit</a></label>
                        </div>
                        <div>
                            <button class="btn btn--radius-2 btn--red" type="submit">S'inscrire</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>

    <!-- Jquery JS-->
    <script src="vendor/jquery/jquery.min.js"></script>
    <!-- Vendor JS-->
    <script src="vendor/select2/select2.min.js"></script>
    <script src="vendor/datepicker/moment.min.js"></script>
    <script src="vendor/datepicker/daterangepicker.js"></script>

    <!-- Main JS-->
    <script src="js/global.js"></script>

</body><!-- This templates was made by Colorlib (https://colorlib.com) -->

</html>
<!-- end document-->