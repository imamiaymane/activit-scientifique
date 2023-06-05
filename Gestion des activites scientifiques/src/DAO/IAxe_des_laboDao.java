package DAO;

import java.util.List;

import Metier.Axe_des_labo;

public interface IAxe_des_laboDao {
	public void addAxe_des_labo(int idAxe,int idLabo);
	public List<Axe_des_labo> getAxe_des_labo(int idLabo);
	public void deleteFromlabo(int idlabo,int idaxe);
}
