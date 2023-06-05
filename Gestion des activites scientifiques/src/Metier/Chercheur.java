package Metier;

import java.io.InputStream;


import java.io.Serializable;
import java.util.ArrayList;



public class Chercheur implements Serializable{
	
	private int id_chercheur;
	private String nom;
	private String prenom;
	private String email;
	private String pass;
	private String telephone;
	private String profile;
	private String activite_pedagogique;
	private String responsabilite;
	private InputStream photo;
	private InputStream justificatif;
	private ArrayList<Activite> activite_sc; 
	private int Id_equipe;
	
	
	
	public Chercheur() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Chercheur(int id_chercheur, String nom, String prenom, String email, String pass, String telephone,
			String profile, String activite_pedagogique, String responsabilite, InputStream photo,
			InputStream justificatif, ArrayList<Activite> activite_sc, int Id_equipe) {
		super();
		this.id_chercheur = id_chercheur;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.pass = pass;
		this.telephone = telephone;
		this.profile = profile;
		this.activite_pedagogique = activite_pedagogique;
		this.responsabilite = responsabilite;
		this.photo = photo;
		this.justificatif = justificatif;
		this.activite_sc = activite_sc;
		this.Id_equipe = Id_equipe;
	}
	public int getId_chercheur() {
		return id_chercheur;
	}
	public void setId_chercheur(int id_chercheur) {
		this.id_chercheur = id_chercheur;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getProfile() {
		return profile;
	}
	public void setProfile(String profile) {
		this.profile = profile;
	}
	public String getActivite_pedagogique() {
		return activite_pedagogique;
	}
	public void setActivite_pedagogique(String activite_pedagogique) {
		this.activite_pedagogique = activite_pedagogique;
	}
	public String getResponsabilite() {
		return responsabilite;
	}
	public void setResponsabilite(String responsabilite) {
		this.responsabilite = responsabilite;
	}
	public InputStream getPhoto() {
		return photo;
	}
	public void setPhoto(InputStream photo) {
		this.photo = photo;
	}
	public InputStream getJustificatif() {
		return justificatif;
	}
	public void setJustificatif(InputStream justificatif) {
		this.justificatif = justificatif;
	}
	public ArrayList<Activite> getActivite_sc() {
		return activite_sc;
	}
	public void setActivite_sc(ArrayList<Activite> activite_sc) {
		this.activite_sc = activite_sc;
	}
	public int getId_equipe() {
		return Id_equipe;
	}
	public void setId_equipe(int l_equipe) {
		this.Id_equipe = l_equipe;
	}
	@Override
	public String toString() {
		return "Chercheur [id_chercheur=" + id_chercheur + ", nom=" + nom + ", prenom=" + prenom + ", email=" + email
				+ ", pass=" + pass + ", telephone=" + telephone + ", profile=" + profile + ", activite_pedagogique="
				+ activite_pedagogique + ", responsabilite=" + responsabilite + ", photo=" + photo + ", justificatif="
				+ justificatif + ", activite_sc=" + activite_sc + ", l_equipe=" + Id_equipe + "]";
	}

	
	

}
