package DAO;

import java.util.List;

import Metier.Chercheur;
import Metier.Equipe;

public interface IEquipeDao {
	public List<Equipe> equipeParMC(String mc);
	public void  addEquipe(Equipe e);
	public Equipe getEquipe(int id);
	public Equipe updateEquipe(int id,Equipe e);
	public void deleteChercheurFromEquipe(int id);
	public int getIdEquipe(String nom);
	public List<Equipe> listEquipe();
	public List<Equipe> listEquipeDansLabo(int id);
	public List<Chercheur> listChercheurparEq(int idEq);
	public List<Chercheur> listNewChef(int idEq);
	public void SetnullChercheur(int id);
	public void DeleteEquipe(int id);
	public void DeleteFromAssociationAxe(int ideq);
}
