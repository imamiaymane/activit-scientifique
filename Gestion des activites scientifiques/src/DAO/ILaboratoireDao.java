package DAO;

import java.util.List;

import Metier.Chercheur;
import Metier.Laboratoire;

public interface ILaboratoireDao {
	public List<Laboratoire> laboratoireParMC(String mc);
	public void  addLaboratoire(Laboratoire c);
	public Laboratoire getLaboratoire(int id);
	public void updateLaboratoire(Laboratoire c,int id);
	public void deleteLaboratoire(int id);
	public List<Laboratoire> listlabo();
	public Laboratoire getId_Laboratoire(String nom);
	public String getNom_Laboratoire(int id);
	public List<Chercheur> listNewChef(int id); 
	public int id_labo(int idEq);
	public void DeleteFromAssociationaAxe(int idlabo);
	
	
}
