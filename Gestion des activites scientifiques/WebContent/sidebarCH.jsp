<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<%if(session.getAttribute("profile")==null){
	response.sendRedirect("index.jsp");
}
%>
<!-- menu profile quick info -->
            <div class="profile clearfix">
              <div class="profile_pic">
                <img src="images/img.jpg" alt="..." class="img-circle profile_img">
              </div>
              <div class="profile_info">
                <span>Welcome,</span>
                <h2>${sessionScope.nom} ${sessionScope.prenom}</h2>
              </div>
            </div>
            <!-- /menu profile quick info -->

            <br />

            <!-- sidebar menu -->
            <div id="sidebar-menu" class="main_menu_side hidden-print main_menu">
              <div class="menu_section">
                <h3>General</h3>
                <ul class="nav side-menu">
                  <li><a href="index.jsp"><i class="fa fa-home"></i> Home </a>
                  </li>
                  <li><a href="EspaceCh"><i class="fa fa-home"></i> Profile </a>
                  </li>
                  
                  <c:if test="${sessionScope.ideq!=0}">
                  <li><a><i class="fa fa-edit"></i>Gestion de publication <span class="fa fa-chevron-down"></span></a>
                    <ul class="nav child_menu">
                      <li><a href="AddPub.jsp">Ajouter publication</a></li>
                      <li><a href="ListPub">liste des publications</a></li>
                    </ul>
                  </li>
                  
                  
                  
                  
                  <c:if test="${sessionScope.profile eq 'doctorant'}">
                  <li><a><i class="fa fa-edit"></i> Gestion Soutenances <span class="fa fa-chevron-down"></span></a>
                    <ul class="nav child_menu">
                      <li><a href="form_addSout.jsp">Ajouter Soutenance</a></li>
                      <li><a href="ListSout">liste des Soutenances</a></li>
                    </ul>
                  </li>
                  </c:if>
                  <c:if test="${sessionScope.profile eq 'docteur'}">
                  <li><a><i class="fa fa-edit"></i> Gestion Soutenances <span class="fa fa-chevron-down"></span></a>
                    <ul class="nav child_menu">
                      <li><a href="form_addSout.jsp">Ajouter Soutenance</a></li>
                      <li><a href="ListSout">liste des Soutenances</a></li>
                    </ul>
                  </li>
                  </c:if>
                  <c:if test="${sessionScope.profile eq 'enseignant'}">
                  <li><a><i class="fa fa-edit"></i> Gestion Soutenances <span class="fa fa-chevron-down"></span></a>
                    <ul class="nav child_menu">
                      <li><a href="form_addSout.jsp">Ajouter Soutenance</a></li>
                      <li><a href="ListSout">liste des Soutenances</a></li>
                    </ul>
                  </li>
                  </c:if>
                  
                  
                  
                  <c:if test="${sessionScope.profile eq 'doctorant'}">
                  <li><a><i class="fa fa-edit"></i> Gestion Conférence <span class="fa fa-chevron-down"></span></a>
                    <ul class="nav child_menu">
                      <li><a href="Form_ajouterConferences.jsp">Ajouter Conférence</a></li>
                      <li><a href="ListConf">liste des Conférence</a></li>
                    </ul>
                  </li>
                  </c:if>
                  <c:if test="${sessionScope.profile eq 'docteur'}">
                  <li><a><i class="fa fa-edit"></i> Gestion Conférence <span class="fa fa-chevron-down"></span></a>
                    <ul class="nav child_menu">
                      <li><a href="Form_ajouterConferences.jsp">Ajouter Conférence</a></li>
                      <li><a href="ListConf">liste des Conférence</a></li>
                    </ul>
                  </li>
                  </c:if>
                  <c:if test="${sessionScope.profile eq 'enseignant'}">
                  <li><a><i class="fa fa-edit"></i> Gestion Conférence <span class="fa fa-chevron-down"></span></a>
                    <ul class="nav child_menu">
                      <li><a href="Form_ajouterConferences.jsp">Ajouter Conférence</a></li>
                      <li><a href="ListConf">liste des Conférence</a></li>
                    </ul>
                  </li>
                  </c:if>
                  
                  
                  
                  
                  <c:if test="${sessionScope.profile eq 'docteur'}">
                  <li><a><i class="fa fa-edit"></i> Gestion Encadrement <span class="fa fa-chevron-down"></span></a>
                    <ul class="nav child_menu">
                      <li><a href="AddEncadrement.jsp">Ajouter Encadrement</a></li>
                      <li><a href="ListEncad">liste des Encadrement</a></li>
                    </ul>
                  </li>
                  </c:if>
                  <c:if test="${sessionScope.profile eq 'enseignant'}">
                  <li><a><i class="fa fa-edit"></i> Gestion Encadrement <span class="fa fa-chevron-down"></span></a>
                    <ul class="nav child_menu">
                      <li><a href="AddEncadrement.jsp">Ajouter Encadrement</a></li>
                      <li><a href="ListEncad">liste des Encadrement</a></li>
                    </ul>
                  </li>
                  </c:if>
                  
                  
                  <c:if test="${sessionScope.profile eq 'enseignant'}">
                  <li><a><i class="fa fa-edit"></i> Gestion Projet de recherche <span class="fa fa-chevron-down"></span></a>
                    <ul class="nav child_menu">
                      <li><a href="AddProjet.jsp">Ajouter Projet de recherche</a></li>
                      <li><a href="ListProjet">liste des Projets de recherche</a></li>
                    </ul>
                  </li>
                  </c:if>
                  </c:if>
                  
                  
                  <li><a><i class="fa fa-edit"></i>Activité pédagogique et Responsabilité<span class="fa fa-chevron-down"></span></a>
                    <ul class="nav child_menu">
                      <li><a href="Addactivite.jsp">Ajouter Activité pédagogique</a></li>
                      <li><a href="listActivite">Gérer Activité</a></li>
                      
                    </ul>
                  </li>
                  
                  <c:if test="${sessionScope.ideq!=0}">
                  <li><a><i class="fa fa-edit"></i>publication publique<span class="fa fa-chevron-down"></span></a>
                    <ul class="nav child_menu">
                      
                      <li><a href="AllPub.jsp">liste des publications</a></li>
                    </ul>
                  </li>
                  </c:if>
                  <c:if test="${sessionScope.ideq!=0}">
                  <li><a><i class="fa fa-edit"></i>Génerer Rapport<span class="fa fa-chevron-down"></span></a>
                    <ul class="nav child_menu">
                      
                      <li><a href="RapportEtat">Rappot</a></li>
                    </ul>
                  </li>
                  </c:if>
                  
                  
                  
                  
                 
                  
                  
                  
                  
                </ul>
              </div>
              

            </div>
            <!-- /sidebar menu -->
