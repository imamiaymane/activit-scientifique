package Web;

import java.io.BufferedWriter;

import java.io.FileWriter;
import java.io.IOException;


import java.io.InputStream;
import java.sql.Blob;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import DAO.ActiviteDaoImpl;
import DAO.Axe_desEquipeImpl;
import DAO.Axe_des_LaboImpl;
import DAO.Axe_equipeDaoImpl;
import DAO.Axe_laboratoireDaoImpl;
import DAO.ChercheurDaoImpl;
import DAO.EquipeDaoImpl;
import DAO.LaboratoireDaoImpl;
import DAO.Logindao;
import DAO.UserDaoImpl;
import Metier.Activite;
import Metier.Axe_des_Equipe;
import Metier.Axe_des_labo;
import Metier.Axe_equipe;
import Metier.Axe_laboratoire;
import Metier.Chercheur;
import Metier.ChercheurPDF;
import Metier.Equipe;
import Metier.Laboratoire;
import Metier.User;
import Web.model;

/**
 * Servlet implementation class ServletGestion
 */
@WebServlet(urlPatterns = {"/login","/registration_home","/Admin_ajouterchercheur","/logout","/listechercheur",
		"/descriptionChercheur","/DeleteChercheur","/Adduser","/listeuser","/DeleteUser","/modifierChercheur",
		"/upDateChercheur","/ChercheurParMc","/UserParMc","/addEquipe","/addAxe"
		,"/listAxe","/Addlabo","/preAddlabo","/DeleteAxe","/ListLabo","/DeleteLabo","/AxeLabo",
		"/DeleteAxeparLabo","/addNewAxe","/ListEquipeLabo","/descriptionLabo","/updatelabo","/gestion_eq"
		,"/AxeEquipe","/addNewAxeEq","/DeleteAxeparEq","/ListCHercheurEq","/AddChToEq","/DescriptionEq","/DeleteChercheurfromEq"
		,"/updateEq","/SupEqFromLabo","/EquipeParMc","/laboParMc","/pdf","/pdfChEq","/EspaceCh","/AddConference","/ListConf",
		"/ShowConf","/GetJustif","/AddSout","/ListSout","/ShowSout","/AddEncad","/ListEncad","/ShowEncad","/AddPub"
		,"/ListPub","/ShowPub","/AddProjet","/ListProjet","/ShowPro","/listEncadAdmin","/GetEncadAdmin","/DeleteACT"
		,"/DeleteACTCh","/listSoutAdmin","/DeleteACTSout","/GetSoutAdmin","/listConfAdmin","/DeleteACTConf","/GetConfAdmin"
		,"/listProAdmin","/DeleteACTPro","/GetProAdmin","/listPubAdmin","/DeleteACTPub","/GetPubAdmin","/PubParMc","/addActivite"
		,"/listActivite","/RapportEtat"})
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
maxFileSize = 1024 * 1024 * 10, // 10MB
maxRequestSize = 1024 * 1024 * 50) // 50MB
public class ServletGestion extends HttpServlet {
	private Logindao logindao;		
	private ChercheurDaoImpl chercheurdao;
	private EquipeDaoImpl equipedao;
	private UserDaoImpl userdao;
	model md =new model();
	private LaboratoireDaoImpl labodao;
	private Axe_laboratoireDaoImpl axelabodao;
	private Axe_des_LaboImpl axeDesLabo;
	private Axe_equipeDaoImpl axeequipe;
	private Axe_desEquipeImpl axeDesEquipe;
	private ActiviteDaoImpl activitedao;
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletGestion() {
		super();
		// TODO Auto-generated constructor stub
	}
	public void init() {
		logindao =new Logindao();
		chercheurdao = new ChercheurDaoImpl();
		equipedao = new EquipeDaoImpl();
		userdao=new UserDaoImpl();
		labodao=new LaboratoireDaoImpl();
		axelabodao=new Axe_laboratoireDaoImpl();
		axeDesLabo=new Axe_des_LaboImpl();
		axeequipe=new Axe_equipeDaoImpl();
		axeDesEquipe=new Axe_desEquipeImpl();
		activitedao=new ActiviteDaoImpl();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.print("Path : " + request.getServletPath());
		System.out.println();




		/***********    login      **************/
		if (request.getServletPath().equals("/login")) {
			String email = request.getParameter("email");
			String pass = request.getParameter("pass");
			System.out.println("email :" + email);
			System.out.println("pass :" + pass);
			Chercheur loginC = new Chercheur();
			loginC.setEmail(email);
			loginC.setPass(pass);
			try {
				if (logindao.login(loginC)) {
					if(logindao.role(loginC).equals("admin")) {
						HttpSession session = request.getSession();
						System.out.println("session created");
						Chercheur c2=new Chercheur();
						c2=chercheurdao.getChercheurEmail(email);
						System.out.println("nom :"+c2.getNom());
						session.setAttribute("nom",c2.getNom());
						session.setAttribute("prenom",c2.getPrenom());
						session.setAttribute("profile",c2.getProfile());
						System.out.println("session ok");
						response.sendRedirect("index_admin.jsp");
					}
					else {
						HttpSession session = request.getSession();
						System.out.println("session created");
						Chercheur c2=new Chercheur();
						c2=chercheurdao.getChercheurEmail(email);
						System.out.println("nom :"+c2.getNom());
						session.setAttribute("nom",c2.getNom());
						session.setAttribute("email",c2.getEmail());
						session.setAttribute("prenom",c2.getPrenom());
						session.setAttribute("profile",c2.getProfile());
						session.setAttribute("id",c2.getId_chercheur());
						md.setIdSession(c2.getId_chercheur());
						session.setAttribute("ideq",c2.getId_equipe());
						System.out.println("ideeeeeeq :"+c2.getId_equipe());
						System.out.println(c2.getEmail());
						session.setAttribute("tele",c2.getTelephone());
						System.out.println("session ok");
						if(logindao.role(loginC).equals("docteur"))
							request.getRequestDispatcher("index.jsp").forward(request, response);
						else {
							if(logindao.role(loginC).equals("doctorant")) {
								request.getRequestDispatcher("index.jsp").forward(request, response);
							}
							else {
								request.getRequestDispatcher("index.jsp").forward(request, response);
							}
						}
					}
				}
				else {
					request.setAttribute("msg2", "email ou mot de passe incorrect ");
					this.getServletContext().getRequestDispatcher("/login_c.jsp").forward(request, response);
				}
			}catch (ClassNotFoundException e) {
				response.sendRedirect("page_404.jsp");
				e.printStackTrace();
			}

		}


		else /****************************** home registration    *************************/ 

			if(request.getServletPath().equals("/registration_home")){
				String email=request.getParameter("email");
				System.out.println("email :"+email);
				System.out.println("0");
				String nom=request.getParameter("nom");
				if(!email.matches("(.*)edu.umi.ac.ma")){
					request.setAttribute("msg1", "saisir un email academique");
					this.getServletContext().getRequestDispatcher("/registration_home.jsp").forward(request, response);
					//response.sendRedirect("registration_home.jsp");
				}
				else {
						if(!chercheurdao.verifierChercheur(email, nom)){ //verifier que le chercheur est un membre de umi	
							response.sendRedirect("page403.jsp");
						}
						else {
							if(chercheurdao.verifierInscription(email, nom)){  //verifier que le chercheur n'a pas du compte
								response.sendRedirect("deja_inscrit.jsp");
							}
							else {
								System.out.println("1");
								String prenom=request.getParameter("prenom");
								String pass=request.getParameter("pass");
								String telephone=request.getParameter("telephone");
								System.out.println("2");
								Part photo = request.getPart("photo");
								String profile=request.getParameter("profile");
								InputStream   photoInputStream=null;
								if (photo != null) {
									photoInputStream = photo.getInputStream();
								}
								System.out.println("prenom :"+prenom);
								System.out.println("nom :"+nom);
								System.out.println("telephone :"+telephone);
								System.out.println("profile :"+profile);
								System.out.println("photo :"+photo);
								System.out.println("3");
								Chercheur addC = new Chercheur();	
								addC.setNom(nom);
								addC.setPrenom(prenom);
								addC.setEmail(email);
								addC.setPass(pass);
								addC.setTelephone(telephone);
								addC.setPhoto(photoInputStream);
								addC.setProfile(profile);

								chercheurdao.addChercheur(addC);
								System.out.println("yap");
								response.sendRedirect("index.jsp");


							}
						}

				}

			}
			else
				if(request.getServletPath().equals("/Admin_ajouterchercheur")){
					String email=request.getParameter("email");
					System.out.println("email :"+email);
					System.out.println("0");
					String nom=request.getParameter("nom");
					if(!email.matches("(.*)edu.umi.ac.ma")){
						request.setAttribute("msg1", "saisir un email academique");
						System.out.println("test");
						this.getServletContext().getRequestDispatcher("/form_ajouterchercheur.jsp").forward(request, response);
					}
					else {
						try {
							if(!chercheurdao.verifierChercheur(email, nom)){
								response.sendRedirect("page403.jsp");
							}
							else {
								if(chercheurdao.verifierInscription(email, nom)){  //verifier que le chercheur n'a pas du compte
									response.sendRedirect("deja_inscrit.jsp");
								}
								else {
									System.out.println("1");
									String prenom=request.getParameter("prenom");
									String pass=request.getParameter("pass");
									String telephone=request.getParameter("telephone");
									System.out.println("2");
									Part photo = request.getPart("photo");
									String profile=request.getParameter("profile");
									InputStream   photoInputStream=null;
									if (photo != null) {
										photoInputStream = photo.getInputStream();
									}
									System.out.println("prenom :"+prenom);
									System.out.println("nom :"+nom);
									System.out.println("telephone :"+telephone);
									System.out.println("profile :"+profile);				
									System.out.println("photo :"+photo);
									System.out.println("3");
									Chercheur addC = new Chercheur();	
									addC.setNom(nom);
									addC.setPrenom(prenom);
									addC.setEmail(email);
									addC.setPass(pass);
									addC.setTelephone(telephone);
									addC.setPhoto(photoInputStream);
									addC.setProfile(profile);
									try {
										chercheurdao.addChercheur(addC);
										request.setAttribute("ajch", "Chercheur ajoutée");
										this.getServletContext().getRequestDispatcher("/form_ajouterchercheur.jsp").forward(request, response);

									}
									catch (Exception e) {
										response.sendRedirect("page_404.jsp");
										e.printStackTrace();
									}
								}	

							}
						}
						catch(Exception e){
							response.sendRedirect("page_404.jsp");
							e.getMessage();
						}

					}

				}
				else 
					if(request.getServletPath().equals("/logout")) {
						HttpSession session=request.getSession();  
						session.invalidate();  
						response.sendRedirect("/Gestion_des_activites_scientifiques/");
					}
					else 	
						if(request.getServletPath().equals("/listechercheur")){
							List<Chercheur> chercheurs=chercheurdao.listeChercheur();
							request.setAttribute("equipedao", equipedao);
							request.setAttribute("Chercheurs", chercheurs);
							request.getRequestDispatcher("gestion_chercheurs.jsp").forward(request, response);
						}else 
							if (request.getServletPath().equals("/descriptionChercheur")) { 
								int idChercheur = Integer.parseInt(request.getParameter("idChercheur"));
								System.out.println("idChercheur : " + idChercheur);
								Chercheur chercheur = chercheurdao.getChercheur(idChercheur);
								System.out.println(chercheur);
								request.setAttribute("chercheur", chercheur);
								request.setAttribute("equipedao", equipedao);
								request.getRequestDispatcher("description_chercheurs.jsp").forward(request, response);
							}
							else 
								if(request.getServletPath().equals("/DeleteChercheur")){
									int idChercheur = Integer.parseInt(request.getParameter("idChercheur"));
									chercheurdao.deleteActivitesCh(idChercheur);
									chercheurdao.deleteChercheur(idChercheur);
									System.out.println("idChercheur : " + idChercheur);
									request.getRequestDispatcher("/listechercheur").forward(request, response);
								}
								else
									if(request.getServletPath().equals("/Adduser")){
										String email=request.getParameter("email");
										System.out.println("email :"+email);
										String nom=request.getParameter("nom");
										if(!email.matches("(.*)edu.umi.ac.ma")){
											request.setAttribute("msg1", "saisir un email academique");
											this.getServletContext().getRequestDispatcher("/form_ajouteruser.jsp").forward(request, response);
										}
										else {
											try {
												if(userdao.verifier(email)){  //verifier que le user est un membre de umi
													request.setAttribute("msg0", "user déja ajoute");
													this.getServletContext().getRequestDispatcher("/form_ajouteruser.jsp").forward(request, response);
												}
												else {
													System.out.println("1");
													String prenom=request.getParameter("prenom");
													System.out.println("prenom :"+prenom);
													System.out.println("nom :"+nom);
													System.out.println("email :"+email);
													System.out.println("3");
													User usr = new User();	
													usr.setNom(nom);
													usr.setPrenom(prenom);
													usr.setEmail(email);
													try {
														userdao.addUser(usr);
														request.setAttribute("ajch", "user ajoutée");
														this.getServletContext().getRequestDispatcher("/form_ajouteruser.jsp").forward(request, response);

													}
													catch (Exception e) {
														response.sendRedirect("page_404.jsp");
														e.printStackTrace();
													}
												}	

											}
											catch(ClassNotFoundException e){
												response.sendRedirect("page_404.jsp");
												e.getMessage();
											}

										}
									}
									else 
										if(request.getServletPath().equals("/listeuser")) {
											List<User> users=userdao.listeUser();
											request.setAttribute("Users", users);
											request.getRequestDispatcher("gestion_users.jsp").forward(request, response);

										}
										else
											if(request.getServletPath().equals("/DeleteUser")){
												int idUser = Integer.parseInt(request.getParameter("idUser"));
												userdao.deleteUser(idUser);
												System.out.println("idUser : " + idUser);
												request.getRequestDispatcher("/listeuser").forward(request, response);
											}
											else
												if(request.getServletPath().equals("/modifierChercheur")){
													int idChercheur = Integer.parseInt(request.getParameter("idChercheur"));
													System.out.println("idChercheur : " + idChercheur);
													Chercheur chercheur = chercheurdao.getChercheur(idChercheur);
													System.out.println(chercheur);
													md.setCptch(idChercheur);
													System.out.println("teeeessst 0"+ md.getCptch());
													request.setAttribute("chercheur", chercheur);
													request.setAttribute("equipedao", equipedao);
													request.getRequestDispatcher("modifier_chercheur.jsp").forward(request, response);
												}
												else
													if(request.getServletPath().equals("/upDateChercheur")){
														String nom=request.getParameter("nom");
														String prenom=request.getParameter("prenom");
														String telephone=request.getParameter("telephone");
														String profile=request.getParameter("profile");

														System.out.println("prenom :"+prenom);
														System.out.println("nom :"+nom);
														System.out.println("telephone :"+telephone);
														System.out.println("profile :"+profile);
														System.out.println("3");
														Chercheur addC = new Chercheur();	
														addC.setNom(nom);
														addC.setPrenom(prenom);
														addC.setTelephone(telephone);
														addC.setProfile(profile);
														System.out.println("teeeessst"+ md.getCptch());
														try {
															chercheurdao.updateChercheur(md.getCptch(),addC);
															this.getServletContext().getRequestDispatcher("/listechercheur").forward(request, response);
														}
														catch (Exception e) {
															response.sendRedirect("page_404.jsp");
															e.printStackTrace();
														}
													}
													else
														if(request.getServletPath().equals("/ChercheurParMc")){
															String mc=request.getParameter("mc");
															System.out.println(mc);
															if(equipedao.getIdEquipe(mc)!=0) {
																mc=String.valueOf(equipedao.getIdEquipe(mc));
															}
															List<Chercheur> chercheurs=chercheurdao.chercheurParMC(mc);
															request.setAttribute("equipedao", equipedao);
															request.setAttribute("Chercheurs", chercheurs);
															System.out.println(chercheurs);
															System.out.println(equipedao);
															System.out.println("nana");
															request.getRequestDispatcher("gestion_chercheurs.jsp").forward(request, response);
														}
														else
															if(request.getServletPath().equals("/UserParMc")) {
																String mcUser=request.getParameter("mcUser");
																System.out.println(mcUser);
																List<User> Users=userdao.userParMC(mcUser);
																request.setAttribute("Users", Users);
																System.out.println(Users);
																request.getRequestDispatcher("gestion_users.jsp").forward(request, response);
															}
															else
																if(request.getServletPath().equals("/addEquipe")) {
																	try {
																		int res=0;
																		String nom=request.getParameter("nom_eq");
																		System.out.println(111);
																		//int idlabo = Integer.parseInt(request.getParameter("idlabo"));
																		System.out.println(222);
																		String AX[]=request.getParameterValues("Axeseq");
																		System.out.println(333);
																		int idChef_eq = Integer.parseInt(request.getParameter("Chef_eq"));
																		System.out.println(444);
																		String CH[]=request.getParameterValues("chercheurs");
																		System.out.println(555);
																		System.out.println(nom);
																		System.out.println(md.getIdlabo());
																		System.out.println(idChef_eq);
																		for(int i=0;i<AX.length;i++) {
																			System.out.println(AX[i]);
																		}
																		System.out.println(666);
																		for(int i=0;i<CH.length;i++) {
																			System.out.println(CH[i]);
																		}
																		System.out.println(777);
																		for(int i=0;i<CH.length;i++) {
																			if(idChef_eq==Integer.parseInt(CH[i])){
																				res=1;
																			}
																		}
																		System.out.println(888);
																		if(res==1) {
																			request.setAttribute("Chef_ch", "le chef d'equipe ne peux pas etre sélectionné comme un simple membre");
																			this.getServletContext().getRequestDispatcher("/gestion_equipe_par_labo.jsp").forward(request, response);
																		}
																		else {
																			if(CH.length<3) {
																				request.setAttribute("minCH", "vous devez donner au moins 3 chercherus");
																				this.getServletContext().getRequestDispatcher("/gestion_equipe_par_labo.jsp").forward(request, response);
																			}
																			else {
																				List<Equipe> listEq=equipedao.listEquipe();
																				for(int i=0;i<listEq.size();i++) {
																					if(nom.equalsIgnoreCase(listEq.get(i).getNom_equipe())) {
																						res=2;
																					}
																				}
																				System.out.println(123);
																				if(res==2) {
																					request.setAttribute("nomEq","Nom d'équipe déja utilisé");
																					this.getServletContext().getRequestDispatcher("/gestion_equipe_par_labo.jsp").forward(request, response);
																				}
																				else {
																					System.out.println(000);
																					Equipe eq=new Equipe();
																					System.out.println(345);
																					eq.setNom_equipe(nom);
																					eq.setChef_equipe(idChef_eq);
																					eq.setId_laboratoire(md.getIdlabo());
																					System.out.println(456);
																					equipedao.addEquipe(eq);
																					System.out.println(010);
																					int id_eq=equipedao.getIdEquipe(nom);
																					for(int i=0;i<AX.length;i++) {
																						String nomAx=axeequipe.nomAxe(Integer.parseInt(AX[i]));
																						if(!axeequipe.axeEquipe(nomAx)){
																							Axe_equipe axeeq=new Axe_equipe();
																							axeeq.setNom_axe_equipe(nomAx);
																							axeequipe.addAxe_equipe(axeeq);
																							System.out
																							.println(axeeq);
																							int a=axeequipe.getIdAxeEquipe(nomAx);
																							System.out
																							.println(a);
																							axeDesEquipe.addAxe_des_equipe(a, id_eq);
																						}
																						else {
																							int a=axeequipe.getIdAxeEquipe(nomAx);
																							System.out
																							.println(a);
																							axeDesEquipe.addAxe_des_equipe(a, id_eq);
																						}
																					}
																					Chercheur ch=chercheurdao.getChercheur(idChef_eq);
																					ch.setId_equipe(id_eq);
																					chercheurdao.updateChercheurEquipe(idChef_eq, ch);
																					System.out.println(101);
																					for(int i=0;i<CH.length;i++){
																						Chercheur c=chercheurdao.getChercheur(Integer.parseInt(CH[i]));
																						c.setId_equipe(id_eq);
																						System.out.println("id :"+Integer.parseInt(CH[i]));
																						System.out.println("chercheurs :"+c);	
																						chercheurdao.updateChercheurEquipe(Integer.parseInt(CH[i]), c);
																					}
																					System.out.println(109);
																					request.getRequestDispatcher("/ListLabo").forward(request, response);																						
																				}
																			}
																		}
																	}
																	catch (Exception e) {
																		// TODO: handle exception
																		response.sendRedirect("page_404.jsp");
																		e.printStackTrace();

																	}
																}
																else
																	if(request.getServletPath().equals("/addAxe")) {//ok
																		boolean res=true;
																		String nom=request.getParameter(("nom_axe"));
																		System.out.println(nom);
																		List<Axe_laboratoire> listaxe =axelabodao.listeAxes();
																		System.out.println("la taille "+listaxe.size());
																		for(int i=0;i<listaxe.size();i++) {
																			if(nom.equalsIgnoreCase(listaxe.get(i).getNom_axe_laboratoire())) {
																				System.out.println(listaxe.get(i).getNom_axe_laboratoire());
																				System.out.println(res);
																				res=false;
																			}
																		}
																		if(!res) {
																			request.setAttribute("nomAxe","Nom d'Axe de recherche est déja utilisé");
																			this.getServletContext().getRequestDispatcher("/form_creerAxe.jsp").forward(request, response);
																		}
																		else {
																			axelabodao.addAxe_laboratoireDao(nom);
																			request.getRequestDispatcher("/listAxe").forward(request, response);
																		}
																	}
																	else
																		if(request.getServletPath().equals("/listAxe")){//ok
																			List<Axe_laboratoire> axes=axelabodao.listeAxes();
																			request.setAttribute("Axes", axes);
																			request.getRequestDispatcher("gestion_axes.jsp").forward(request, response);

																		}
																		else
																			if(request.getServletPath().equals("/preAddlabo")) {//ok
																				List<Axe_laboratoire> listaxe =axelabodao.listeAxes();
																				List<Chercheur> chercheurEns = chercheurdao.listeEns();
																				request.setAttribute("listaxes", listaxe);
																				request.setAttribute("chercheurEns", chercheurEns);
																				request.getRequestDispatcher("form_ajouterlabo.jsp").forward(request, response);


																			}
																			else
																				if(request.getServletPath().equals("/Addlabo")) {
																					boolean res=true;
																					String nom=request.getParameter(("nom_labo"));
																					int chef_labo=Integer.parseInt(request.getParameter(("Chef_labo")));
																					String listAxes[]=request.getParameterValues("axedelabo");
																					System.out.println("nom "+nom);
																					System.out.println("chef "+chef_labo);
																					List<Laboratoire> listlabo=labodao.listlabo();
																					for(int i=0;i<listlabo.size();i++) {
																						if(nom.equalsIgnoreCase(listlabo.get(i).getNom_labo())) {
																							res=false;
																						}
																					}
																					if(!res) {
																						request.setAttribute("nomlabo","Nom du laboratoire est déja utilisé");
																						this.getServletContext().getRequestDispatcher("/form_ajouterlabo.jsp").forward(request, response);
																					}
																					else {
																						Laboratoire l=new Laboratoire();
																						l.setNom_labo(nom);
																						l.setChef_labo(chef_labo);
																						labodao.addLaboratoire(l);
																						System.out.println("okok");
																						Laboratoire lb=labodao.getId_Laboratoire(nom);
																						System.out.println("id labo"+lb.getId_laboratoire());
																						for(int i=0;i<listAxes.length;i++) {
																							axeDesLabo.addAxe_des_labo(Integer.parseInt(listAxes[i]), lb.getId_laboratoire());

																						}
																						request.getRequestDispatcher("/ListLabo").forward(request, response);// 
																					}
																				}
																				else
																					if(request.getServletPath().equals("/DeleteAxe")) { //ok
																						int idAxe = Integer.parseInt(request.getParameter("idAxe"));
																						axelabodao.deleteAxe_laboratoireDao(idAxe);
																						System.out.println("idAxe : " + idAxe);
																						request.getRequestDispatcher("/listAxe").forward(request, response);
																					}
																					else 
																						if(request.getServletPath().equals("/ListLabo")) { //ok
																							List<Laboratoire> labos=labodao.listlabo();
																							System.out.println(labos);
																							request.setAttribute("labos", labos);
																							request.setAttribute("chercheurdao", chercheurdao);
																							request.getRequestDispatcher("gestion_labo.jsp").forward(request, response);
																						}
																						else
																							if(request.getServletPath().equals("/DeleteLabo")) {
																								int idLabo = Integer.parseInt(request.getParameter("idLabo"));
																								List<Equipe> listeEq=equipedao.listEquipeDansLabo(idLabo);
																								for(int i=0;i<listeEq.size();i++) {
																									equipedao.SetnullChercheur(listeEq.get(i).getId_equipe());
																									equipedao.DeleteFromAssociationAxe(listeEq.get(i).getId_equipe());
																									equipedao.DeleteEquipe(listeEq.get(i).getId_equipe());
																								}
																								labodao.DeleteFromAssociationaAxe(idLabo);
																								labodao.deleteLaboratoire(idLabo);
																								System.out.println("idUser : " + idLabo);
																								request.getRequestDispatcher("/ListLabo").forward(request, response);	
																							}
																							else
																								if(request.getServletPath().equals("/AxeLabo")){
																									System.out
																									.println(1);
																									int idLabo = Integer.parseInt(request.getParameter("idlabo"));
																									md.setIdlabo(idLabo);
																									List<Axe_des_labo> listaxe=axeDesLabo.getAxe_des_labo(idLabo);
																									List<Axe_laboratoire> listnewAxe=axelabodao.listnewAxes(idLabo); 
																									System.out.println(listaxe);
																									System.out.println(2);
																									System.out
																									.println(listnewAxe);
																									String nom=labodao.getNom_Laboratoire(idLabo);
																									request.setAttribute("listaxes", listaxe);
																									request.setAttribute("axelabodao", axelabodao);
																									request.setAttribute("listnewAxe", listnewAxe);
																									request.setAttribute("nom", nom);
																									System.out
																									.println("nom de labo :"+nom);
																									System.out.println(3);
																									request.getRequestDispatcher("gestion_axe_par_labo.jsp").forward(request, response);
																								}
																								else
																									if(request.getServletPath().equals("/DeleteAxeparLabo")){
																										int idAxe = Integer.parseInt(request.getParameter("idAxe"));
																										axeDesLabo.deleteFromlabo(md.getIdlabo(), idAxe);
																										request.setAttribute("idlabo", md.getIdlabo());
																										request.getRequestDispatcher("/ListLabo").forward(request, response);
																									}
																									else
																										if(request.getServletPath().equals("/addNewAxe")) {
																											int newAxe=Integer.parseInt(request.getParameter(("newAxe")));
																											axeDesLabo.addAxe_des_labo(newAxe,md.getIdlabo());
																											request.getRequestDispatcher("/ListLabo").forward(request, response);
																										}
																										else
																											if(request.getServletPath().equals("/ListEquipeLabo")) {
																												int idlabo=Integer.parseInt(request.getParameter("idlabo"));
																												System.out
																												.println("labooooo :"+idlabo);
																												md.setIdlabo(idlabo);
																												List<Equipe> listeqLabo=equipedao.listEquipeDansLabo(idlabo);
																												System.out
																												.println(listeqLabo);
																												List<Chercheur> chercheurEns = chercheurdao.listeEns();
																												System.out.println(chercheurEns);
																												List<Chercheur> chercheurSansEquipe=chercheurdao.listsansEq();
																												List<Axe_laboratoire> listAxeDequipe=axeequipe.axelaboDequipe(idlabo);
																												request.setAttribute("listAxeDequipe", listAxeDequipe);
																												request.setAttribute("equipes", listeqLabo);
																												request.setAttribute("chercheurdao", chercheurdao);
																												request.setAttribute("ChercheursEns", chercheurEns);
																												request.setAttribute("ChercheursSansEq", chercheurSansEquipe);
																												request.getRequestDispatcher("gestion_equipe_par_labo.jsp").forward(request, response);
																											}
																											else
																												if(request.getServletPath().equals("/descriptionLabo")) {
																													int idlabo=Integer.parseInt(request.getParameter(("idLabo")));
																													System.out
																													.println(idlabo);																													
																													md.setUpdatelabo(idlabo);
																													Laboratoire lb=labodao.getLaboratoire(idlabo);
																													List<Chercheur> listChef=labodao.listNewChef(lb.getId_laboratoire());
																													System.out
																													.println(listChef);
																													Chercheur Chef=chercheurdao.getChercheur(lb.getChef_labo());
																													request.setAttribute("laboratoire", lb);
																													request.setAttribute("listChef", listChef);
																													request.setAttribute("Chef", Chef);
																													request.getRequestDispatcher("descriptionlabo.jsp").forward(request, response);
																												}
																												else
																													if(request.getServletPath().equals("/updatelabo")) {
																														String nom_labo=request.getParameter(("nom_labo"));
																														Laboratoire lb=labodao.getLaboratoire(md.getUpdatelabo());
																														boolean res=true;
																														List<Laboratoire> listlabo=labodao.listlabo();
																														for(int i=0;i<listlabo.size();i++) {
																															if(nom_labo.equalsIgnoreCase(listlabo.get(i).getNom_labo())) {
																																res=false;
																															}
																														}
																														if(!res) {
																															request.setAttribute("nomlabo","Nom du laboratoire est déja utilisé");
																															this.getServletContext().getRequestDispatcher("/descriptionlabo.jsp").forward(request, response);
																														}
																														else {
																															lb.setNom_labo(nom_labo);
																															int idchef=Integer.parseInt(request.getParameter(("Chef_labo")));
																															lb.setChef_labo(idchef);
																															labodao.updateLaboratoire(lb, md.getUpdatelabo());
																															request.getRequestDispatcher("/ListLabo").forward(request, response);
																														}

																													}
																													else
																														if(request.getServletPath().equals("/gestion_eq")) {
																															List<Equipe> equipes=equipedao.listEquipe();
																															System.out.println(equipes);
																															request.setAttribute("equipes", equipes);
																															request.setAttribute("chercheurdao", chercheurdao);
																															request.setAttribute("labodao", labodao);
																															request.getRequestDispatcher("gestion_equipe.jsp").forward(request, response);
																														}
																														else
																															if(request.getServletPath().equals("/AxeEquipe")) {
																																int idEquipe = Integer.parseInt(request.getParameter("idEq"));
																																md.setIdEq(idEquipe);
																																List<Axe_des_Equipe> listaxe=axeDesEquipe.getAxe_des_Eq(idEquipe);
																																System.out
																																.println(listaxe);
																																int idlabo=labodao.id_labo(idEquipe);
																																List<Axe_laboratoire> listAxeDequipe=axeequipe.axelaboDequipe(idlabo);
																																request.setAttribute("listaxe", listaxe);
																																request.setAttribute("listAxeDequipe", listAxeDequipe);
																																request.setAttribute("axeequipe", axeequipe);
																																request.setAttribute("axelabodao", axelabodao);
																																String NomEqu=equipedao.getEquipe(idEquipe).getNom_equipe();
																																request.setAttribute("NomEqu", NomEqu);
																																request.setAttribute("chercheurdao", chercheurdao);
																																request.getRequestDispatcher("gestion_axe_par_equipe.jsp").forward(request, response);
																															}
																															else
																																if(request.getServletPath().equals("/addNewAxeEq")) {
																																	int idAxeLabo=Integer.parseInt(request.getParameter("newAxe"));
																																	Axe_laboratoire axelb=axelabodao.getAxe_laboratoireDao(idAxeLabo);
																																	boolean res=axeequipe.axeEquipe(axelb.getNom_axe_laboratoire());
																																	if(res) {
																																		int idaxe_eq=axeequipe.getIdAxeEquipe(axelb.getNom_axe_laboratoire());
																																		if(axeDesEquipe.getAxe_des_equipe(idaxe_eq, md.getIdEq())) {
																																			request.getRequestDispatcher("/gestion_eq").forward(request, response);
																																		}
																																		else {
																																			axeDesEquipe.addAxe_des_equipe(idaxe_eq, md.getIdEq());
																																			request.getRequestDispatcher("/gestion_eq").forward(request, response);
																																		}
																																	}
																																	else {
																																		Axe_equipe axeq=new Axe_equipe();
																																		axeq.setNom_axe_equipe(axelb.getNom_axe_laboratoire());
																																		axeequipe.addAxe_equipe(axeq);
																																		int idaxeq=axeequipe.getIdAxeEquipe(axelb.getNom_axe_laboratoire());
																																		axeDesEquipe.addAxe_des_equipe(idaxeq, md.getIdEq());
																																		request.getRequestDispatcher("/gestion_eq").forward(request, response);
																																	}
																																}
																																else
																																	if(request.getServletPath().equals("/DeleteAxeparEq")) {
																																		int idAxe=Integer.parseInt(request.getParameter("idAxe"));
																																		System.out
																																		.println("idAxe :"+idAxe);
																																		System.out
																																		.println("ideq :"+md.getIdEq());
																																		axeDesEquipe.deleteAxe(md.getIdEq(),idAxe);
																																		request.getRequestDispatcher("/gestion_eq").forward(request, response);
																																	}
																																	else
																																		if(request.getServletPath().equals("/ListCHercheurEq")) {
																																			int idEq=Integer.parseInt(request.getParameter("idEq"));
																																			md.setPdfChEq(idEq);
																																			List<Chercheur> listCHEq =equipedao.listChercheurparEq(idEq);
																																			System.out
																																			.println(listCHEq);
																																			md.setIdEqCH(idEq);
																																			List<Chercheur> listChSansEq= chercheurdao.listsansEq();
																																			request.setAttribute("listCHEq", listCHEq);
																																			request.setAttribute("listChSansEq", listChSansEq);
																																			request.getRequestDispatcher("gestio_chercheur_par_eq.jsp").forward(request, response);
																																		}
																																		else
																																			if(request.getServletPath().equals("/AddChToEq")) {
																																				int idChercheur=Integer.parseInt(request.getParameter("idChercheur"));
																																				Chercheur ch=new Chercheur();
																																				ch.setId_equipe(md.getIdEqCH());
																																				chercheurdao.updateChercheurEquipe(idChercheur, ch);
																																				request.getRequestDispatcher("/gestion_eq").forward(request, response);
																																			}
																																			else
																																				if(request.getServletPath().equals("/DescriptionEq")) {
																																					int idEq=Integer.parseInt(request.getParameter("idEq"));
																																					md.setUpdateEq(idEq);
																																					List<Chercheur> listChefNew=equipedao.listNewChef(idEq);
																																					Equipe equ=equipedao.getEquipe(idEq);
																																					Chercheur ch=chercheurdao.getChercheur(equ.getChef_equipe());
																																					request.setAttribute("listChefNew", listChefNew);
																																					request.setAttribute("equ", equ);
																																					request.setAttribute("ch", ch);
																																					request.getRequestDispatcher("descriptionEq.jsp").forward(request, response);
																																				}
																																				else
																																					if(request.getServletPath().equals("/DeleteChercheurfromEq")) {
																																						int idChercheur=Integer.parseInt(request.getParameter("idChercheur"));
																																						equipedao.deleteChercheurFromEquipe(idChercheur);
																																						request.getRequestDispatcher("/gestion_eq").forward(request, response);
																																					}
																																					else
																																						if(request.getServletPath().equals("/updateEq")) {
																																							String nom_eq=request.getParameter(("nom_eq"));
																																							Equipe equ=equipedao.getEquipe(md.getUpdateEq());
																																							boolean res=true;
																																							List<Equipe> listeq=equipedao.listEquipe();
																																							for(int i=0;i<listeq.size();i++) {
																																								if(nom_eq.equalsIgnoreCase(listeq.get(i).getNom_equipe())) {
																																									res=false;
																																								}
																																							}
																																							if(!res) {
																																								request.setAttribute("nom_eq","Nom d'equipe est déja utilisé");
																																								this.getServletContext().getRequestDispatcher("/descriptionEq.jsp").forward(request, response);
																																							}
																																							else {
																																								equ.setNom_equipe(nom_eq);
																																								int chef_eq=Integer.parseInt(request.getParameter(("Chef_eq")));
																																								equ.setChef_equipe(chef_eq);
																																								equipedao.updateEquipe(md.getUpdateEq(), equ);
																																								request.getRequestDispatcher("/gestion_eq").forward(request, response);
																																							}
																																						}
																																						else
																																							if(request.getServletPath().equals("/SupEqFromLabo")) {
																																								int idEq=Integer.parseInt(request.getParameter(("ideq")));
																																								equipedao.SetnullChercheur(idEq);
																																								equipedao.DeleteFromAssociationAxe(idEq);
																																								equipedao.DeleteEquipe(idEq);
																																								request.getRequestDispatcher("/ListLabo").forward(request, response);
																																							}
																																							else
																																								if(request.getServletPath().equals("/EquipeParMc")) {
																																									String mc=request.getParameter("mc");
																																									System.out.println(mc);
																																									List<Equipe> listEq=equipedao.equipeParMC(mc);
																																									request.setAttribute("chercheurdao", chercheurdao);
																																									request.setAttribute("labodao", labodao);
																																									request.setAttribute("equipes", listEq);
																																									System.out.println(listEq);
																																									System.out.println("nana");
																																									request.getRequestDispatcher("/gestion_equipe.jsp").forward(request, response);
																																								}
																																								else
																																									if(request.getServletPath().equals("/laboParMc")) {
																																										String mc=request.getParameter("mc");
																																										System.out.println(mc);
																																										List<Laboratoire> listlabo=labodao.laboratoireParMC(mc);
																																										request.setAttribute("chercheurdao", chercheurdao);
																																										request.setAttribute("labodao", labodao);
																																										request.setAttribute("labos", listlabo);
																																										System.out.println(listlabo);
																																										System.out.println("nana");
																																										request.getRequestDispatcher("/gestion_labo.jsp").forward(request, response);
																																									}
																																									else
																																										if(request.getServletPath().equals("/pdf")) {
																																											try {
																																												response.setContentType("application/pdf");
																																												DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-ddHH:mm:ss");
																																												String currentDateTime = dateFormatter.format(new java.util.Date());
																																												String headerKey = "Content-Disposition";
																																												String headerValue = "attachment; filename=liste " + currentDateTime + ".pdf";
																																												response.setHeader(headerKey, headerValue);
																																												List<Chercheur> listUsers = chercheurdao.listeChercheur();
																																												ChercheurPDF exporter = new ChercheurPDF(listUsers);
																																												exporter.export(response);
																																											}
																																											catch(Exception e) {
																																												response.sendRedirect("page_404.jsp");
																																												e.printStackTrace();
																																											}
																																										}
																																										else
																																											if(request.getServletPath().equals("/pdfChEq")) {
																																												try {
																																													response.setContentType("application/pdf");
																																													DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-ddHH:mm:ss");
																																													String currentDateTime = dateFormatter.format(new java.util.Date());
																																													String headerKey = "Content-Disposition";
																																													String nom=equipedao.getEquipe(md.getPdfChEq()).getNom_equipe();
																																													String headerValue = "attachment; filename=chercheur d'equipe "+nom+" " + currentDateTime + ".pdf";
																																													response.setHeader(headerKey, headerValue);
																																													List<Chercheur> listCHEq =equipedao.listChercheurparEq(md.getPdfChEq());
																																													ChercheurPDF exporter = new ChercheurPDF(listCHEq);
																																													exporter.export(response);
																																												}
																																												catch(Exception e) {
																																													response.sendRedirect("page_404.jsp");
																																													e.printStackTrace();
																																												}
																																											}
																																											else
																																												if(request.getServletPath().equals("/EspaceCh")) {// §§§§
																																													List<Activite> listProjet =activitedao.listProjet(md.getIdSession());
																																													System.out
																																													.println(listProjet);
																																													request.setAttribute("listProjet", listProjet);
																																													request.setAttribute("chercheurdao", chercheurdao);
																																													request.setAttribute("equipedao", equipedao);
																																													request.getRequestDispatcher("/profile.jsp").forward(request, response);
																																												}
																																												else
																																													if(request.getServletPath().equals("/AddConference")) {
																																														String initule=request.getParameter("initule");
																																														String Jour=request.getParameter("Jour");
																																														String Mois=request.getParameter("Mois");
																																														String Annee=request.getParameter("Annee");
																																														String lieu=request.getParameter("lieu");
																																														Part Justificatif = request.getPart("Justificatif");
																																														InputStream   JustificatifInputStream=null;
																																														if (Justificatif != null) {
																																															JustificatifInputStream = Justificatif.getInputStream();
																																														}
																																														Activite ac=new Activite();
																																														ac.setInitule(initule);
																																														ac.setJour(Jour);
																																														ac.setMois(Mois);
																																														ac.setAnnee(Annee);
																																														ac.setLieu(lieu);
																																														ac.setJustificatif(JustificatifInputStream);
																																														ac.setType_ac("conference");
																																														ac.setIdchercheur(md.getIdSession());
																																														activitedao.addActivite(ac);
																																														request.getRequestDispatcher("/ListConf").forward(request, response);
																																													}
																																													else
																																														if(request.getServletPath().equals("/ListConf")) {
																																															List<Activite> listConf =	activitedao.listConf(md.getIdSession());
																																															System.out
																																															.println(listConf);
																																															request.setAttribute("listConf", listConf);
																																															request.getRequestDispatcher("listConference.jsp").forward(request, response);
																																														}
																																														else
																																															if(request.getServletPath().equals("/ShowConf")) {
																																																int idConf=Integer.parseInt(request.getParameter(("idConf")));
																																																Activite Conf=activitedao.getActivite(idConf);
																																																System.out
																																																.println(Conf);
																																																request.setAttribute("Conf", Conf);
																																																request.getRequestDispatcher("Form_showConf.jsp").forward(request, response);
																																															}
																																															else
																																																if(request.getServletPath().equals("/GetJustif")) {
																																																	int id = Integer.parseInt(request.getParameter("idConf"));
																																																	ServletOutputStream sos;
																																																	response.setContentType("application/pdf");
																																																	response.setHeader("Content-disposition","inline; filename="+id+".pdf" );
																																																	sos = response.getOutputStream();
																																																	byte[] bytes = activitedao.getJust(id);
																																																	sos.write(bytes);
																																																	sos.close();
																																																}
																																																else
																																																	if(request.getServletPath().equals("/AddSout")) {
																																																		String type=request.getParameter("type");
																																																		String initule=request.getParameter("initule");
																																																		String Jour=request.getParameter("Jour");
																																																		String Mois=request.getParameter("Mois");
																																																		String Annee=request.getParameter("Annee");
																																																		String lieu=request.getParameter("lieu");
																																																		String jury=request.getParameter("jury");
																																																		Part Justificatif = request.getPart("Justificatif");
																																																		InputStream   JustificatifInputStream=null;
																																																		if (Justificatif != null) {
																																																			JustificatifInputStream = Justificatif.getInputStream();
																																																		}
																																																		Activite ac=new Activite();
																																																		ac.setType_par_sou(type);
																																																		ac.setInitule(initule);
																																																		ac.setJour(Jour);
																																																		ac.setMois(Mois);
																																																		ac.setAnnee(Annee);
																																																		ac.setLieu(lieu);
																																																		ac.setJury(jury);
																																																		ac.setJustificatif(JustificatifInputStream);
																																																		ac.setType_ac("soutenance");
																																																		ac.setIdchercheur(md.getIdSession());
																																																		activitedao.addActivite(ac);
																																																		request.getRequestDispatcher("/ListSout").forward(request, response);
																																																	}
																																																	else
																																																		if(request.getServletPath().equals("/ListSout")) {
																																																			List<Activite> listSout =activitedao.listSout(md.getIdSession());
																																																			System.out
																																																			.println(listSout);
																																																			request.setAttribute("listSout", listSout);
																																																			request.getRequestDispatcher("listSout.jsp").forward(request, response);
																																																		}
																																																		else
																																																			if(request.getServletPath().equals("/ShowSout")) {
																																																				int idSout=Integer.parseInt(request.getParameter(("idSout")));
																																																				Activite Sout=activitedao.getActivite(idSout);
																																																				System.out
																																																				.println(Sout);
																																																				request.setAttribute("Sout", Sout);
																																																				request.getRequestDispatcher("ShowSout.jsp").forward(request, response);									
																																																			}
																																																			else
																																																				if(request.getServletPath().equals("/AddEncad")) {

																																																					String Niveau=request.getParameter("Niveau");
																																																					String Jour=request.getParameter("Jour");
																																																					String Mois=request.getParameter("Mois");
																																																					String Annee=request.getParameter("Annee");
																																																					String Type_enca=request.getParameter("Type_enca");
																																																					String sous=request.getParameter("sous");
																																																					Part Justificatif = request.getPart("Justificatif");
																																																					InputStream   JustificatifInputStream=null;
																																																					if (Justificatif != null) {
																																																						JustificatifInputStream = Justificatif.getInputStream();
																																																					}
																																																					Activite ac=new Activite();

																																																					ac.setNiveau(Niveau);
																																																					ac.setJour(Jour);
																																																					ac.setMois(Mois);
																																																					ac.setAnnee(Annee);
																																																					ac.setSous(sous);
																																																					ac.setType_enc(Type_enca);
																																																					ac.setJustificatif(JustificatifInputStream);
																																																					ac.setType_ac("encadrement");
																																																					ac.setIdchercheur(md.getIdSession());
																																																					activitedao.addActivite(ac);
																																																					request.getRequestDispatcher("/ListEncad").forward(request, response);
																																																				}
																																																				else
																																																					if(request.getServletPath().equals("/ListEncad")) {
																																																						List<Activite> listEncad =activitedao.listEncad(md.getIdSession());
																																																						System.out
																																																						.println(listEncad);
																																																						request.setAttribute("listEncad", listEncad);
																																																						request.getRequestDispatcher("listEncad.jsp").forward(request, response);
																																																					}
																																																					else
																																																						if(request.getServletPath().equals("/ShowEncad")) {
																																																							int idEncad=Integer.parseInt(request.getParameter(("idEncad")));
																																																							Activite Encad=activitedao.getActivite(idEncad);
																																																							System.out
																																																							.println(Encad);
																																																							request.setAttribute("Encad", Encad);
																																																							request.getRequestDispatcher("ShowEncad.jsp").forward(request, response);									
																																																						}
																																																						else
																																																							if(request.getServletPath().equals("/AddPub")) {
																																																								String Type=request.getParameter("Type");
																																																								String titre=request.getParameter("titre");
																																																								String Abstract=request.getParameter("abstract");
																																																								String auteur=request.getParameter("auteur");
																																																								String auteur2=request.getParameter("auteur2");
																																																								String auteur3=request.getParameter("auteur3");
																																																								String Jour=request.getParameter("Jour");
																																																								String Mois=request.getParameter("Mois");
																																																								String Annee=request.getParameter("Annee");
																																																								Part Justificatif = request.getPart("Justificatif");
																																																								InputStream   JustificatifInputStream=null;
																																																								if (Justificatif != null) {
																																																									JustificatifInputStream = Justificatif.getInputStream();
																																																								}
																																																								Activite ac=new Activite();
																																																								ac.setType_pub(Type);
																																																								ac.setTitre(titre);
																																																								ac.setA_bstract(Abstract);
																																																								ac.setAuteur1(auteur);
																																																								ac.setAuteur2(auteur2);
																																																								ac.setAuteur3(auteur3);
																																																								ac.setJour(Jour);
																																																								ac.setMois(Mois);
																																																								ac.setAnnee(Annee);
																																																								ac.setJustificatif(JustificatifInputStream);
																																																								ac.setType_ac("publication");
																																																								ac.setIdchercheur(md.getIdSession());
																																																								activitedao.addActivite(ac);
																																																								request.getRequestDispatcher("/ListPub").forward(request, response);
																																																							}
																																																							else
																																																								if(request.getServletPath().equals("/ListPub")) {
																																																									List<Activite> listPub =activitedao.listPub(md.getIdSession());
																																																									System.out
																																																									.println(listPub);
																																																									request.setAttribute("listPub", listPub);
																																																									request.getRequestDispatcher("listPub.jsp").forward(request, response);
																																																								}
																																																								else
																																																									if(request.getServletPath().equals("/ShowPub")) {
																																																										int idPub=Integer.parseInt(request.getParameter(("idPub")));
																																																										Activite Pub=activitedao.getActivite(idPub);
																																																										System.out
																																																										.println(Pub);
																																																										request.setAttribute("Pub", Pub);
																																																										request.getRequestDispatcher("ShowPub.jsp").forward(request, response);
																																																									}
																																																									else
																																																										if(request.getServletPath().equals("/AddProjet")) {
																																																											String titre=request.getParameter("titre");
																																																											String Description=request.getParameter("Description");
																																																											String Budget=request.getParameter("Budget");
																																																											String Duree=request.getParameter("Durée");

																																																											String Jour=request.getParameter("Jour");
																																																											String Mois=request.getParameter("Mois");
																																																											String Annee=request.getParameter("Annee");
																																																											Part Justificatif = request.getPart("Justificatif");
																																																											InputStream   JustificatifInputStream=null;
																																																											if (Justificatif != null) {
																																																												JustificatifInputStream = Justificatif.getInputStream();
																																																											}
																																																											Activite ac=new Activite();
																																																											ac.setTitre(titre);
																																																											ac.setDescription_projet(Description);
																																																											ac.setBudget(Budget);
																																																											ac.setDuree(Duree);
																																																											ac.setJour(Jour);
																																																											ac.setMois(Mois);
																																																											ac.setAnnee(Annee);
																																																											ac.setJustificatif(JustificatifInputStream);
																																																											ac.setType_ac("projet");
																																																											ac.setIdchercheur(md.getIdSession());
																																																											activitedao.addActivite(ac);
																																																											request.getRequestDispatcher("/ListProjet").forward(request, response);
																																																										}
																																																										else
																																																											if(request.getServletPath().equals("/ListProjet")){
																																																												List<Activite> listProjet =activitedao.listProjet(md.getIdSession());
																																																												System.out
																																																												.println(listProjet);
																																																												request.setAttribute("listProjet", listProjet);
																																																												request.getRequestDispatcher("listProjet.jsp").forward(request, response);
																																																											}
																																																											else
																																																												if(request.getServletPath().equals("/ShowPro")) {
																																																													int idPro=Integer.parseInt(request.getParameter(("idPro")));
																																																													Activite pro=activitedao.getActivite(idPro);
																																																													System.out
																																																													.println(pro);
																																																													request.setAttribute("pro", pro);
																																																													request.getRequestDispatcher("ShowProjer.jsp").forward(request, response);

																																																												}
																																																												else
																																																													if(request.getServletPath().equals("/listEncadAdmin")) {
																																																														List<Activite> listEncad =activitedao.listAllEncad();
																																																														System.out
																																																														.println(listEncad);
																																																														request.setAttribute("listEncad", listEncad);
																																																														request.setAttribute("chercheurdao", chercheurdao);

																																																														request.getRequestDispatcher("gestion_encad.jsp").forward(request, response);
																																																													}
																																																													else
																																																														if(request.getServletPath().equals("/GetEncadAdmin")) {
																																																															int idEncad=Integer.parseInt(request.getParameter(("idEncad")));
																																																															Activite Encad=activitedao.getActivite(idEncad);
																																																															System.out
																																																															.println(Encad);
																																																															request.setAttribute("Encad", Encad);
																																																															request.getRequestDispatcher("ShowEncadAdmin.jsp").forward(request, response);
																																																														}
																																																														else
																																																															if(request.getServletPath().equals("/DeleteACT")) {
																																																																int id=Integer.parseInt(request.getParameter(("idAct")));
																																																																activitedao.deleteActivite(id);
																																																																request.getRequestDispatcher("/listEncadAdmin").forward(request, response);
																																																															}
																																																															else
																																																																if(request.getServletPath().equals("/DeleteACTCh")) {
																																																																	int id=Integer.parseInt(request.getParameter(("idAct")));
																																																																	activitedao.deleteActivite(id);
																																																																	request.getRequestDispatcher("/EspaceCh").forward(request, response);
																																																																}
																																																																else
																																																																	if(request.getServletPath().equals("/listSoutAdmin")) {
																																																																		List<Activite> listSout =activitedao.listAllSout();
																																																																		System.out
																																																																		.println(listSout);
																																																																		request.setAttribute("listSout", listSout);
																																																																		request.setAttribute("chercheurdao", chercheurdao);

																																																																		request.getRequestDispatcher("gestion_sout.jsp").forward(request, response);
																																																																	}
																																																																	else
																																																																		if(request.getServletPath().equals("/DeleteACTSout")) {
																																																																			int id=Integer.parseInt(request.getParameter(("idAct")));
																																																																			activitedao.deleteActivite(id);
																																																																			request.getRequestDispatcher("/listSoutAdmin").forward(request, response);
																																																																		}
																																																																		else
																																																																			if(request.getServletPath().equals("/GetSoutAdmin")) {
																																																																				int idEncad=Integer.parseInt(request.getParameter(("idEncad")));
																																																																				Activite Encad=activitedao.getActivite(idEncad);
																																																																				System.out
																																																																				.println(Encad);
																																																																				request.setAttribute("Sout", Encad);
																																																																				request.getRequestDispatcher("ShowSoutAdmin.jsp").forward(request, response);
																																																																			}
																																																																			else
																																																																				if(request.getServletPath().equals("/listConfAdmin")) {
																																																																					List<Activite> listConf =activitedao.listAllConf();
																																																																					System.out
																																																																					.println(listConf);
																																																																					request.setAttribute("listConf", listConf);
																																																																					request.setAttribute("chercheurdao", chercheurdao);
																																																																					request.getRequestDispatcher("gestion_Conf.jsp").forward(request, response);
																																																																				}
																																																																				else
																																																																					if(request.getServletPath().equals("/DeleteACTConf")) {
																																																																						int id=Integer.parseInt(request.getParameter(("idAct")));
																																																																						activitedao.deleteActivite(id);
																																																																						request.getRequestDispatcher("/listConfAdmin").forward(request, response);
																																																																					}
																																																																					else
																																																																						if(request.getServletPath().equals("/GetConfAdmin")) {
																																																																							int idEncad=Integer.parseInt(request.getParameter(("idEncad")));
																																																																							Activite Encad=activitedao.getActivite(idEncad);
																																																																							System.out
																																																																							.println(Encad);
																																																																							request.setAttribute("Conf", Encad);
																																																																							request.getRequestDispatcher("ShowConfAdmin.jsp").forward(request, response);
																																																																						}
																																																																						else
																																																																							if(request.getServletPath().equals("/listProAdmin")) {
																																																																								List<Activite> listPro =activitedao.listAllPro();
																																																																								System.out
																																																																								.println(listPro);
																																																																								request.setAttribute("listPro", listPro);
																																																																								request.setAttribute("chercheurdao", chercheurdao);
																																																																								request.getRequestDispatcher("gestion_Pro.jsp").forward(request, response);
																																																																							}
																																																																							else
																																																																								if(request.getServletPath().equals("/DeleteACTPro")) {
																																																																									int id=Integer.parseInt(request.getParameter(("idAct")));
																																																																									activitedao.deleteActivite(id);
																																																																									request.getRequestDispatcher("/listProAdmin").forward(request, response);
																																																																								}
																																																																								else
																																																																									if(request.getServletPath().equals("/GetProAdmin")) {
																																																																										int idEncad=Integer.parseInt(request.getParameter(("idEncad")));
																																																																										Activite Encad=activitedao.getActivite(idEncad);
																																																																										System.out
																																																																										.println(Encad);
																																																																										request.setAttribute("pro", Encad);
																																																																										request.getRequestDispatcher("ShowProAdmin.jsp").forward(request, response);
																																																																									}
																																																																									else
																																																																										if(request.getServletPath().equals("/listPubAdmin")) {
																																																																											List<Activite> listPub =activitedao.listAllPub();
																																																																											System.out
																																																																											.println(listPub);
																																																																											request.setAttribute("listPub", listPub);
																																																																											request.setAttribute("chercheurdao", chercheurdao);
																																																																											request.getRequestDispatcher("gestion_Pub.jsp").forward(request, response);
																																																																										}
																																																																										else
																																																																											if(request.getServletPath().equals("/DeleteACTPub")) {
																																																																												int id=Integer.parseInt(request.getParameter(("idAct")));
																																																																												activitedao.deleteActivite(id);
																																																																												request.getRequestDispatcher("/listPubAdmin").forward(request, response);
																																																																											}
																																																																											else
																																																																												if(request.getServletPath().equals("/GetPubAdmin")) {
																																																																													int idEncad=Integer.parseInt(request.getParameter(("idEncad")));
																																																																													Activite Encad=activitedao.getActivite(idEncad);
																																																																													System.out
																																																																													.println(Encad);
																																																																													request.setAttribute("Pub", Encad);
																																																																													request.getRequestDispatcher("ShowPubAdmin.jsp").forward(request, response);
																																																																												}
																																																																												else
																																																																													if(request.getServletPath().equals("/PubParMc")) {
																																																																														String mc=request.getParameter("mc");
																																																																														System.out.println(mc);
																																																																														List<Activite> listPub =activitedao.listAllPubMc(mc);
																																																																														request.setAttribute("listPub", listPub);
																																																																														request.getRequestDispatcher("AllPub.jsp").forward(request, response);
																																																																													}
																																																																													else
																																																																														if(request.getServletPath().equals("/addActivite")) {
																																																																															String Activite=request.getParameter("Activite");
																																																																															Part Justificatif = request.getPart("Justificatif");
																																																																															InputStream   JustificatifInputStream=null;
																																																																															if (Justificatif != null) {
																																																																																JustificatifInputStream = Justificatif.getInputStream();
																																																																															}
																																																																															Chercheur c=new Chercheur();
																																																																															c.setActivite_pedagogique(Activite);
																																																																															c.setJustificatif(JustificatifInputStream);
																																																																															chercheurdao.updateChercheurAC(md.getIdSession(), c);
																																																																															request.getRequestDispatcher("/listActivite").forward(request, response);
																																																																														}
																																																																														else
																																																																															if(request.getServletPath().equals("/listActivite")) {
																																																																																Chercheur ch=chercheurdao.getChercheur(md.getIdSession());
																																																																																request.setAttribute("peda", ch);
																																																																																request.getRequestDispatcher("Active.jsp").forward(request, response);
																																																																															}
																																																																															else
																																																																																if(request.getServletPath().equals("/RapportEtat") ) {
																																																																																	try {
																																																																																		FileWriter fstream = new FileWriter("C:/Rapport_d'activites_general.doc");
																																																																																		BufferedWriter out = new BufferedWriter(fstream);
																																																																																		String str = "" +
																																																																																				"<meta http-equiv='Content-Type' content='text/html; charset=ISO-8859-1' />" +
																																																																																				"<center>" + "<br><hr width='700' ><br>" +  "<table border='0' width='700' height='100' cellpadding='3' style='border-collapse:collapse;' bgcolor='F1AB81'>" +
																																																																																				"<tr>" +   "<td align='center' style='border:1px solid black'><b><h1>Rapport de tous les activites du Laboratoire de Recherche</h1></b></td>" +
																																																																																				"</tr>" + "</table>" +  "<br><hr width='700' ><br><br>" +  
																																																																																				"<img src=\"PFE/WebContent/images/logo2.png\" alt=\"\" />" +
																																																																																				" "+"<table border='0' width='700' height='100' cellpadding='3' style='border-collapse:collapse;'  >" +
																																																																																				"<tr>" +   "<td align='left' style='border:0px solid white'><p style='font-size:14px;' >&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" +
																																																																																				"Les activités scientifiques prenez un rôle important pour les chercheurs (doctorants, docteur, enseignant) dans le laboratoire scientifiques, " +
																																																																																				"et parmi les éléments de ses activités que peut être gérer par chercheurs: <br>" +
																																																																																				"Une thèse de doctorat est une épreuve que vous permet d’obtenir un diplôme de doctorant, " +
																																																																																				"et Le Projet de Fin d'Etudes (PFE) est un projet final qui se fait à la fin d'un cycle d'études académiques." +
																																																																																				"</p></td>" +
																																																																																				"</tr>" + "</table>"+" <br><br> ";


																																																																																		// affichage les equipes    
																																																																																		String str1 = "" + "<table border='0' width='700' cellpadding='3' style='border-collapse:collapse;' bgcolor='D4D5CF'>" +
																																																																																				"<tr>" +   "<td align='center' style='border:1px solid black'><b><h2>Les equipes</h2></b></td>" +  "</tr>" + "</table>" +
																																																																																				"" + "<table border='0' width='700' cellpadding='3' style='border-collapse:collapse;'>" +  "<tr bgcolor='#F4FB91' align='center'>" +
																																																																																				"<td style='border:1px solid black'><b>ID d'equipe</b></td>" +  
																																																																																				"<td style='border:1px solid black'><b>Nom d'Equipe</b></td>" +  "</tr>" ;
																																																																																		// affichage projets de recherches
																																																																																		String str2 = "" + "<table border='0' width='700' cellpadding='3' style='border-collapse:collapse;' bgcolor='D4D5CF'>" +
																																																																																				"<tr>" +   "<td align='center' style='border:1px solid black'><b><h2>Les Projets de Recherches</h2></b></td>" +  "</tr>" + "</table>" +
																																																																																				"<table border='0' width='700' cellpadding='3' style='border-collapse:collapse;'>" +  "<tr bgcolor='#F4FB91' align='center'>" +
																																																																																				"<td style='border:1px solid black'><b>Intitule de Projet</b></td>" +  
																																																																																				"<td style='border:1px solid black'><b>Duree</b></td>" +  "</tr>" ;
																																																																																		// affichage des Publications scientifiques
																																																																																		String str3 = "" + "<table border='0' width=700'  cellpadding='3' style='border-collapse:collapse;' bgcolor='D4D5CF'>" +
																																																																																				"<tr>" +   "<td align='center' style='border:1px solid black'><b><h2>Les Publications scientifiques</h2> </b></td>" +  "</tr>" + "</table>" +
																																																																																				"" + "<table border='0' width='700' cellpadding='3' style='border-collapse:collapse;'>" +  "<tr bgcolor='#F4FB91' align='center'>" +
																																																																																				"<td style='border:1px solid black'><b>Intitule de Publications </b></td>" +  
																																																																																				"<td style='border:1px solid black'><b>Auteurs </b></td>" +  
																																																																																				"<td style='border:1px solid black'><b>Abstract</b></td>" +  "</tr>" ;        
																																																																																		// affichage Theses soutenues
																																																																																		String str5 = "" + "<table border='0' width='700' cellpadding='3' style='border-collapse:collapse;' bgcolor='D4D5CF'>" +
																																																																																				"<tr>" +   "<td align='center' style='border:1px solid black'><b><h2>Les Theses soutenues</h2> </b></td>" +  "</tr>" + "</table>" +
																																																																																				"" + "<table border='0' width='700' cellpadding='3' style='border-collapse:collapse;'>" +  "<tr bgcolor='#F4FB91' align='center'>" +
																																																																																				"<td style='border:1px solid black'><b>Intitule de Projet</b></td>" +  
																																																																																				"<td style='border:1px solid black'><b>ccccc</b></td>" +  "</tr>" ;
																																																																																		// affichage les Membres
																																																																																		String str4 = "" + "<table border='0' width='700' cellpadding='3' style='border-collapse:collapse;' bgcolor='D4D5CF'>" +
																																																																																				"<tr>" +   "<td align='center' style='border:1px solid black'><b><h2>Les Membres</h2> </b></td>" +  "</tr>" + "</table>" +
																																																																																				"" + "<table border='0' width='700' cellpadding='3' style='border-collapse:collapse;'>" +  "<tr bgcolor='#F4FB91' align='center'>" +
																																																																																				"<td style='border:1px solid black'><b>Nom & Prenom </b></td>" +  
																																																																																				"<td style='border:1px solid black'><b>Profil</b></td>" +
																																																																																				"<td style='border:1px solid black'><b>Adresse </b></td>" + "</tr>" ;

																																																																																		String str15 = ""  +
																																																																																				"<table border='0' width='700' cellpadding='3' style='border-collapse:collapse;'>" +  "<tr>" +  
																																																																																				"<td align='left'><input type='submit' value='Previous' id='modifPrevious'/></td>" +  
																																																																																				"<td align='right'><input type='submit' value='  Next  ' id='modifNext'/></td>" +  "</tr>" +
																																																																																				"</table>" + "<br/>" + "</center>";

																																																																																		String s = ""  + "</table>" + "<br/>" ;

																																																																																		out.write(str);
																																																																																		// affichage des membres
																																																																																		List<Chercheur> D = chercheurdao.listeChercheur();
																																																																																		out.write(str4);
																																																																																		for(Chercheur d:D) {
																																																																																			out.write(  "" +
																																																																																					"<tr>" +   "<td style='border:1px solid black'>" +  d.getNom() + d.getPrenom() + "</td>" +  
																																																																																					"<td style='border:1px solid black'> " + d.getProfile() +" </td>" +
																																																																																					"<td style='border:1px solid black'>" +  d.getEmail() + "</td>" + "</tr>"  );
																																																																																		}out.write(s);

																																																																																		// affichage les equipes
																																																																																		List<Equipe> A=equipedao.listEquipe();
																																																																																		out.write(str1);
																																																																																		for(Equipe x:A) {
																																																																																			out.write(  "" +
																																																																																					"<tr>" +   "<td style='border:1px solid black'>" +  x.getId_equipe() + "</td>" +  
																																																																																					"<td style='border:1px solid black'> " + x.getNom_equipe() +" </td>" +  "</tr>"   );
																																																																																		}out.write(s);

																																																																																		// affichage projets de recherches
																																																																																		List<Activite> B=activitedao.listAllPro();
																																																																																		out.write(str2);
																																																																																		for(Activite b:B) {
																																																																																			out.write(  "" +
																																																																																					"<tr>" +   "<td style='border:1px solid black'>" +  b.getTitre() + "</td>" +  
																																																																																					"<td style='border:1px solid black'> "+ b.getDuree() +" </td>" +  "</tr>"  );
																																																																																		}out.write(s);


																																																																																		// affichage des Publications
																																																																																		List<Activite> C=activitedao.listAllPub();
																																																																																		out.write(str3);
																																																																																		for(Activite c:C) {
																																																																																			out.write(  "" +
																																																																																					"<tr>" +   "<td style='border:1px solid black'>" +  c.getTitre() + "</td>" +  
																																																																																					"<td style='border:1px solid black'> " + c.getAuteur1() +" </td>"  +
																																																																																					"<td style='border:1px solid black'>" +  c.getA_bstract() + "</td>" + "</tr>"  );
																																																																																		}out.write(s);

																																																																																		// affichage Theses soutenues
																																																																																		List<Activite> E = activitedao.listAllSout();
																																																																																		out.write(str5);
																																																																																		for(Activite c:E) {
																																																																																			out.write(  "" +
																																																																																					"<tr>" +   "<td style='border:1px solid black'>" +  c.getTitre() + "</td>" +  
																																																																																					"<td style='border:1px solid black'> " + c.getTitre() +" </td>" +  "</tr>"  );
																																																																																		}out.write(s);

																																																																																		out.write(str15);
																																																																																		out.close(); }
																																																																																	catch (Exception e) {  System.err.println("Error: " + e.getMessage()); }  

																																																																																	// request.setAttribute("msg", "Le Telechargement doit terminer avec succes (voir dans votre disque local D)");

																																																																																}
















	}


}
