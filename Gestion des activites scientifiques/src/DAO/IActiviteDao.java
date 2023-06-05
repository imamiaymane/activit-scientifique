package DAO;

import java.util.List;

import Metier.Activite;

public interface IActiviteDao {
	public List<Activite> activiteParMC(String mc);
	public void  addActivite(Activite c);
	public Activite getActivite(int id);
	public Activite updateActivite(Activite c);
	public void deleteActivite(int id);
	public List<Activite> listConf(int idchercheur);
	public byte[] getJust(int id);
	public List<Activite> listSout(int idchercheur);
	public List<Activite> listEncad(int idchercheur);
	public List<Activite> listPub(int idchercheur);
	public List<Activite> listProjet(int idchercheur);
	public List<Activite> listAllEncad();
	public List<Activite> listAllSout();
	public List<Activite> listAllConf();
	public List<Activite> listAllPro();
	public List<Activite> listAllPub();
	public List<Activite> listAllPubMc(String mc);

}
