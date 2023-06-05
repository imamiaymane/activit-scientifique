package Metier;

import java.io.Serializable;


import java.util.ArrayList;

public class Axe_laboratoire implements Serializable {
	private int id_axe_laboratoire;
	private String nom_axe_laboratoire;
	private ArrayList<Laboratoire> les_labo_c;
	
	public Axe_laboratoire() {
		super();
	}
	
	public Axe_laboratoire(String nom_axe_laboratoire) {
		super();
		this.nom_axe_laboratoire = nom_axe_laboratoire;
	}
	
	public int getId_axe_laboratoire() {
		return id_axe_laboratoire;
	}
	
	public void setId_axe_laboratoire(int id_axe_laboratoire) {
		this.id_axe_laboratoire = id_axe_laboratoire;
	}
	
	public String getNom_axe_laboratoire() {
		return nom_axe_laboratoire;
	}
	
	public void setNom_axe_laboratoire(String nom_axe_laboratoire) {
		this.nom_axe_laboratoire = nom_axe_laboratoire;
	}
	
	public ArrayList<Laboratoire> getLes_labo_c() {
		return les_labo_c;
	}
	
	public void setLes_labo_c(ArrayList<Laboratoire> les_labo_c) {
		this.les_labo_c = les_labo_c;
	}

	@Override
	public String toString() {
		return "Axe_laboratoire [id_axe_laboratoire=" + id_axe_laboratoire + ", nom_axe_laboratoire="
				+ nom_axe_laboratoire + ", les_labo_c=" + les_labo_c + "]";
	}
	
}
