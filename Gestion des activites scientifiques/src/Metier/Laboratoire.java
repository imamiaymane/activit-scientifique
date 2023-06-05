package Metier;

import java.io.Serializable;
import java.util.ArrayList;

public class Laboratoire implements Serializable{
	private int id_laboratoire;
	private String nom_labo;
	private int chef_labo;
	private ArrayList<Equipe> les_equipes;
	private ArrayList<Axe_laboratoire> les_axes_labo;
	
	public Laboratoire() {
		super();
	}

	public Laboratoire(String nom_labo, int chef_labo) {
		super();
		this.nom_labo = nom_labo;
		this.chef_labo = chef_labo;
	}

	public int getId_laboratoire() {
		return id_laboratoire;
	}

	public void setId_laboratoire(int id_laboratoire) {
		this.id_laboratoire = id_laboratoire;
	}

	public String getNom_labo() {
		return nom_labo;
	}

	public void setNom_labo(String nom_labo) {
		this.nom_labo = nom_labo;
	}

	public int getChef_labo() {
		return chef_labo;
	}

	public void setChef_labo(int chef_labo) {
		this.chef_labo = chef_labo;
	}
	

	public ArrayList<Equipe> getLes_equipes() {
		return les_equipes;
	}

	public void setLes_equipes(ArrayList<Equipe> les_equipes) {
		this.les_equipes = les_equipes;
	}

	public ArrayList<Axe_laboratoire> getLes_axes_labo() {
		return les_axes_labo;
	}

	public void setLes_axes_labo(ArrayList<Axe_laboratoire> les_axes_labo) {
		this.les_axes_labo = les_axes_labo;
	}

	@Override
	public String toString() {
		return "Laboratoire [id_laboratoire=" + id_laboratoire + ", nom_labo=" + nom_labo + ", chef_labo=" + chef_labo
				+ ", les_equipes=" + les_equipes + ", les_axes_labo=" + les_axes_labo + "]";
	}
	
}
