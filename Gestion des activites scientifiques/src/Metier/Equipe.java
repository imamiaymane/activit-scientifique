package Metier;

import java.io.Serializable;
import java.util.ArrayList;

public class Equipe implements Serializable{
	private int id_equipe;
	private String nom_equipe;
	private int chef_equipe;
	private ArrayList<Axe_equipe> les_axes_equipes;
	private int id_laboratoire;
	private ArrayList<Chercheur> les_chercheeurs;
	
	public Equipe() {
		super();
	}

	
	public Equipe(String nom_equipe, int chef_equipe) {
		super();
		this.nom_equipe = nom_equipe;
		this.chef_equipe = chef_equipe;
	}

	public int getId_equipe() {
		return id_equipe;
	}

	public void setId_equipe(int id_equipe) {
		this.id_equipe = id_equipe;
	}

	public String getNom_equipe() {
		return nom_equipe;
	}

	public void setNom_equipe(String nom_equipe) {
		this.nom_equipe = nom_equipe;
	}

	public int getChef_equipe() {
		return chef_equipe;
	}

	public void setChef_equipe(int chef_equipe) {
		this.chef_equipe = chef_equipe;
	}
	

	public ArrayList<Axe_equipe> getLes_axes_equipes() {
		return les_axes_equipes;
	}


	public void setLes_axes_equipes(ArrayList<Axe_equipe> les_axes_equipes) {
		this.les_axes_equipes = les_axes_equipes;
	}
	

	public int getId_laboratoire() {
		return id_laboratoire;
	}


	public void setId_laboratoire(int id_laboratoire) {
		this.id_laboratoire = id_laboratoire;
	}


	public ArrayList<Chercheur> getLes_chercheeurs() {
		return les_chercheeurs;
	}


	public void setLes_chercheeurs(ArrayList<Chercheur> les_chercheeurs) {
		this.les_chercheeurs = les_chercheeurs;
	}


	@Override
	public String toString() {
		return "Equipe [id_equipe=" + id_equipe + ", nom_equipe=" + nom_equipe + ", chef_equipe=" + chef_equipe
				+ ", les_axes_equipes=" + les_axes_equipes + ", le_laboratoire=" + id_laboratoire + ", les_chercheeurs="
				+ les_chercheeurs + "]";
	}

}
