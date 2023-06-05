package DAO;
import java.util.List;

import Metier.Chercheur;
public interface IChercheurDao {
	public List<Chercheur> chercheurParMC(String mc);
	public void  addChercheur(Chercheur c);
	public Chercheur getChercheur(int id);
	public void updateChercheur(int id,Chercheur c);
	public void deleteChercheur(int id);
	public boolean verifierChercheur(String email,String nom) ;
	public Chercheur getChercheurEmail(String email);
	public boolean verifierInscription(String email,String nom);
	public List<Chercheur> listeChercheur();
	public List<Chercheur> listeEns();
	public List<Chercheur> listsansEq();
	public void updateChercheurEquipe(int id,Chercheur c);
	public void deleteActivitesCh(int id);
	public void updateChercheurAC(int id,Chercheur c);
}
