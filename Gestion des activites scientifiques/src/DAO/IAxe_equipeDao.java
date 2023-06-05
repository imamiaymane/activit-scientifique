package DAO;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import Metier.Axe_equipe;
import Metier.Axe_laboratoire;

public interface IAxe_equipeDao {
	public List<Axe_equipe> Axe_equipeParMC(String mc);
	public void  addAxe_equipe(Axe_equipe a);
	public Axe_equipe getAxe_equipe(int id);
	public Axe_equipe updateAxe_equiper(int id,Axe_equipe a);
	public void deleteAxe_equipe(int id);
	public List<Axe_laboratoire> axelaboDequipe(int id);
	public boolean axeEquipe(String nom);
	public String nomAxe(int id);
	public int getIdAxeEquipe(String nom);
	
}

