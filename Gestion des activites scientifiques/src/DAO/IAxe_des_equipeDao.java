package DAO;

import java.util.List;

import Metier.Axe_des_Equipe;

public interface IAxe_des_equipeDao {
	public void addAxe_des_equipe(int idAxe, int idequipe);
	public boolean getAxe_des_equipe(int idAxe, int idequipe);
	List<Axe_des_Equipe> getAxe_des_Eq(int idEq);
	public void deleteAxe(int ideq,int idAxe);

}
