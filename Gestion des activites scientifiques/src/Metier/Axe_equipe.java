package Metier;

import java.io.Serializable;

import java.util.ArrayList;

public class Axe_equipe implements Serializable {
	private int id_axe_equipe;
	private String nom_axe_equipe;
	private ArrayList<Equipe> les_equipes_c;
	
	public Axe_equipe() {
		super();
	}
	
	public Axe_equipe(String nom_axe_equipe) {
		super();
		this.nom_axe_equipe = nom_axe_equipe;
	}

	public int getId_axe_equipe() {
		return id_axe_equipe;
	}

	public void setId_axe_equipe(int id_axe_equipe) {
		this.id_axe_equipe = id_axe_equipe;
	}

	public String getNom_axe_equipe() {
		return nom_axe_equipe;
	}

	public void setNom_axe_equipe(String nom_axe_equipe) {
		this.nom_axe_equipe = nom_axe_equipe;
	}
	
	public ArrayList<Equipe> getLes_equipes() {
		return les_equipes_c;
	}

	public void setLes_equipes(ArrayList<Equipe> les_equipes_c) {
		this.les_equipes_c = les_equipes_c;
	}

	@Override
	public String toString() {
		return "Axe_equipe [id_axe_equipe=" + id_axe_equipe + ", nom_axe_equipe=" + nom_axe_equipe + ", les_equipes="
				+ les_equipes_c + "]";
	}
	
}
