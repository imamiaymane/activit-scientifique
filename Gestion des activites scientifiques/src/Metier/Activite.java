package Metier;

import java.io.InputStream;
import java.io.Serializable;

import java.time.Year;
import java.sql.Blob;

public class Activite implements Serializable {
	private int id_activite;	/*id de l'activite scientifique */
	private InputStream justificatif; 			/* justificatif de tous les activites */
	private String type_ac;	/*type de activites */
	private String a_bstract;	/*pub*/
	private String auteur1;		/* pub*/
	private String auteur2;		/* pub*/
	private String auteur3; 	/* pub*/
	private String annee;	/*pub /par aux sou/par aux conf */
	private String mois;
	private String jour;
	private String titre;	/*pub / projet */
	private String type_pub;	/*type de publication */
	private String type_par_sou;	/*type de participation aux soutenance */
	private String budget;	/* projet*/
	private String description_projet;	/*projet */
	private String duree;	/*projet */
	private String initule;	/*par aux sou/par aux conf/encadrement */
	private String jury;	/*par aux sou */
	private String lieu;	/*par aux conf */
	private String niveau;	/*encadrement */
	private String type_enc;	/*type d'encadrement*/
	private String type_par_conf; 	/*type de participation aux conference */
	private Blob piece_pub; /*pub */
	private int Idchercheur;
	private String sous;
	public Activite() {
		super();
	}
	
	
	public Activite(InputStream justificatif, String type_ac, String a_bstract, String auteur1, String auteur2,
			String auteur3, String annee, String mois, int jour, String titre, String type_pub, String type_par_sou,
			String budget, String description_projet, String duree, String initule, String jury, String lieu,
			String niveau, String type_enc, String type_par_conf, Blob piece_pub) {
		super();
		this.id_activite = id_activite;
		this.justificatif = justificatif;
		this.type_ac = type_ac;
		this.a_bstract = a_bstract;
		this.auteur1 = auteur1;
		this.auteur2 = auteur2;
		this.auteur3 = auteur3;
		this.annee = annee;
		
		
		this.titre = titre;
		this.type_pub = type_pub;
		this.type_par_sou = type_par_sou;
		this.budget = budget;
		this.description_projet = description_projet;
		this.duree = duree;
		this.initule = initule;
		this.jury = jury;
		this.lieu = lieu;
		this.niveau = niveau;
		this.type_enc = type_enc;
		this.type_par_conf = type_par_conf;
		
	}



	public int getId_activite() {
		return id_activite;
	}

	public void setId_activite(int id_activite) {
		this.id_activite = id_activite;
	}

	public InputStream getJustificatif() {
		return justificatif;
	}

	public void setJustificatif(InputStream justificatif) {
		this.justificatif = justificatif;
	}

	public String getType_ac() {
		return type_ac;
	}

	public void setType_ac(String type_ac) {
		this.type_ac = type_ac;
	}
	
	public void setA_bstract(String a_bstract) {
		this.a_bstract = a_bstract;
	}

	public String getA_bstract() {
		return a_bstract;
	}

	

	public String getAuteur1() {
		return auteur1;
	}

	public void setAuteur1(String auteur1) {
		this.auteur1 = auteur1;
	}

	public String getAuteur2() {
		return auteur2;
	}

	public void setAuteur2(String auteur2) {
		this.auteur2 = auteur2;
	}

	public String getAuteur3() {
		return auteur3;
	}

	public void setAuteur3(String auteur3) {
		this.auteur3 = auteur3;
	}

	public String getAnnee() {
		return annee;
	}

	public void setAnnee(String annee) {
		this.annee = annee;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public String getType_pub() {
		return type_pub;
	}

	public void setType_pub(String type_pub) {
		this.type_pub = type_pub;
	}

	public String getType_par_sou() {
		return type_par_sou;
	}

	public void setType_par_sou(String type_par_sou) {
		this.type_par_sou = type_par_sou;
	}

	public String getBudget() {
		return budget;
	}

	public void setBudget(String budget) {
		this.budget = budget;
	}

	public String getDescription_projet() {
		return description_projet;
	}

	public void setDescription_projet(String description_projet) {
		this.description_projet = description_projet;
	}

	public String getDuree() {
		return duree;
	}

	public void setDuree(String duree) {
		this.duree = duree;
	}

	public String getInitule() {
		return initule;
	}

	public void setInitule(String initule) {
		this.initule = initule;
	}

	public String getJury() {
		return jury;
	}

	public void setJury(String jury) {
		this.jury = jury;
	}

	public String getLieu() {
		return lieu;
	}

	public void setLieu(String lieu) {
		this.lieu = lieu;
	}

	public String getNiveau() {
		return niveau;
	}

	public void setNiveau(String niveau) {
		this.niveau = niveau;
	}

	public String getType_enc() {
		return type_enc;
	}

	public void setType_enc(String type_enc) {
		this.type_enc = type_enc;
	}

	public String getType_par_conf() {
		return type_par_conf;
	}

	public void setType_par_conf(String type_par_conf) {
		this.type_par_conf = type_par_conf;
	}

	public Blob getPiece_pub() {
		return piece_pub;
	}

	public void setPiece_pub(Blob piece_pub) {
		this.piece_pub = piece_pub;
	}
	public int getIdchercheur() {
		return Idchercheur;
	}

	public void setIdchercheur(int Idchercheur) {
		this.Idchercheur = Idchercheur;
	}
	

	public String getMois() {
		return mois;
	}


	public void setMois(String mois) {
		this.mois = mois;
	}


	public String getJour() {
		return jour;
	}


	public void setJour(String jour) {
		this.jour = jour;
	}


	
	


	public String getSous() {
		return sous;
	}


	public void setSous(String sous) {
		this.sous = sous;
	}


	@Override
	public String toString() {
		return "Activite [id_activite=" + id_activite + ", justificatif=" + justificatif + ", type_ac=" + type_ac
				+ ", a_bstract=" + a_bstract + ", auteur1=" + auteur1 + ", auteur2=" + auteur2 + ", auteur3=" + auteur3
				+ ", annee=" + annee + ", mois=" + mois + ", jour=" + jour + ", titre=" + titre + ", type_pub="
				+ type_pub + ", type_par_sou=" + type_par_sou + ", budget=" + budget + ", description_projet="
				+ description_projet + ", duree=" + duree + ", initule=" + initule + ", jury=" + jury + ", lieu=" + lieu
				+ ", niveau=" + niveau + ", type_enc=" + type_enc + ", type_par_conf=" + type_par_conf + ", piece_pub="
				+ piece_pub + ", Lechercheur=" + Idchercheur + "]";
	}
	

}
