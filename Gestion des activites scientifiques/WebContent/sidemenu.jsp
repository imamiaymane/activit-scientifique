
<%if(session.getAttribute("profile")==null){
	response.sendRedirect("index.jsp");
}
%>

<div class="profile clearfix">
              <div class="profile_pic">
                <img src="images/img.jpg" alt="..." class="img-circle profile_img">
              </div>
              <div class="profile_info">
                <span>Welcome,</span>
                <h2>${sessionScope.nom}</h2>
              </div>
            </div>
            <!-- /menu profile quick info -->

            <br />
<div id="sidebar-menu" class="main_menu_side hidden-print main_menu">
              <div class="menu_section">
                <h3>General</h3>
                <ul class="nav side-menu">
                  <li><a href="index_admin.jsp"><i class="fa fa-home"></i> Home</a></li>
                  <li><a><i class="fa fa-edit"></i>Gestion de chercheurs<span class="fa fa-chevron-down"></span></a>
                    <ul class="nav child_menu">
                      <li><a href="form_ajouterchercheur.jsp">Ajouter chercheur</a></li>
                      <li><a href="listechercheur">Gérer chercheurs</a></li>
                      <li><a href="form_ajouteruser.jsp">Ajouter user</a></li>
                      <li><a href="listeuser">Gérer users</a></li>
                    </ul>
                  </li>
                  <li><a><i class="fa fa-edit"></i>Gestion d'équipes<span class="fa fa-chevron-down"></span></a>
                    <ul class="nav child_menu">
                      <li><a href="gestion_eq">Gérer les équipes</a></li>
                    </ul>
                  </li>
                  <li><a><i class="fa fa-edit"></i>Gestion des laboratoires<span class="fa fa-chevron-down"></span></a>
                    <ul class="nav child_menu">
                      <li><a href="preAddlabo">créer laboratoire</a></li>
                      <li><a href="ListLabo">Gérer les laboratoires</a></li>
                    </ul>
                  </li>
                  <li><a><i class="fa fa-edit"></i>Gestion des Axes<span class="fa fa-chevron-down"></span></a>
                    <ul class="nav child_menu">
                      <li><a href="form_creerAxe.jsp">créer axes</a></li>
                      <li><a href="listAxe">liste des axes</a></li>
                    </ul>
                  </li>
                  
                  <li><a><i class="fa fa-edit"></i>Gestion d'activites scientifiques <span class="fa fa-chevron-down"></span></a>
                    <ul class="nav child_menu">
                      <li><a href="listEncadAdmin">Encadrement</a></li>
                      <li><a href="listSoutAdmin">Soutenance</a></li>
                      <li><a href="listConfAdmin">conférence</a></li>
                      <li><a href="listProAdmin">projet de recherche</a></li>
                      <li><a href="listPubAdmin">publication</a></li>
                      
                    </ul>
                  </li>
                  <li><a><i class="fa fa-edit"></i>Activites scientifiques <span class="fa fa-chevron-down"></span></a>
                    <ul class="nav child_menu">
                      <li><a href="RapportEtat">Rapport</a></li>
                    </ul>
                  </li>
                  
                </ul>
              </div>
              

            </div>
