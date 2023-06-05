package DAO;

import java.util.List;


import Metier.Axe_laboratoire;

public interface IAxe_laboratoireDao {
	public List<Axe_laboratoire> axe_laboratoireDaoParMC(String mc);
	public void  addAxe_laboratoireDao(String c);
	public Axe_laboratoire getAxe_laboratoireDao(int id);
	public Axe_laboratoire updateAxe_laboratoireDao(int id,Axe_laboratoire c);
	public void deleteAxe_laboratoireDao(int id);
	public List<Axe_laboratoire> listeAxes();
	public List<Axe_laboratoire> listnewAxes(int id);
}
