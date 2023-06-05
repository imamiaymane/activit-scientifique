package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Metier.Activite;
import Metier.Chercheur;

public class ActiviteDaoImpl implements IActiviteDao {
	Connection conn=SingletonConnection.getConnection();

	@Override
	public List<Activite> activiteParMC(String mc) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addActivite(Activite c) {
		// TODO Auto-generated method stub
		try {
			PreparedStatement ps= conn.prepareStatement("INSERT INTO activite(justificatif,type_ac,abstract,auteur1,auteur2,auteur3,annee,mois,jour,titre,type_pub,type_par_sou,budget,initule,jury,lieu,niveau,type_enc,idchercheur,description_projet,duree) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			ps.setBlob(1, c.getJustificatif());
			ps.setString(2, c.getType_ac());
			ps.setString(3, c.getA_bstract());
			ps.setString(4, c.getAuteur1());
			ps.setString(5,c.getAuteur2());
			ps.setString(6, c.getAuteur3());
			ps.setString(7, c.getAnnee());
			ps.setString(8, c.getMois());
			ps.setString(9, c.getJour());
			ps.setString(10, c.getTitre());
			ps.setString(11, c.getType_pub());
			ps.setString(12, c.getType_par_sou());
			ps.setString(13, c.getBudget());
			ps.setString(14, c.getInitule());
			ps.setString(15, c.getJury());
			ps.setString(16, c.getLieu());
			ps.setString(17, c.getNiveau());
			ps.setString(18, c.getType_enc());
			ps.setInt(19, c.getIdchercheur());
			ps.setString(20, c.getDescription_projet());
			ps.setString(21, c.getDuree());
			ps.executeUpdate();
			ps.close();
			System.out.println("valide");
		}
		catch (SQLException e) {
			 e.printStackTrace();
		}
		
	}

	@Override
	
	public Activite getActivite(int id) {
		// TODO Auto-generated method stub
		Activite ac=new Activite();
		try {
			PreparedStatement ps= conn.prepareStatement("select * from activite where id_activite =?");
			ps.setInt(1,id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				
				ac.setId_activite(rs.getInt("id_activite"));
				ac.setJour(rs.getString("jour"));
				ac.setMois(rs.getString("mois"));
				ac.setAnnee(rs.getString("annee"));
				ac.setInitule(rs.getString("initule"));
				ac.setLieu(rs.getString("lieu"));
				ac.setJury(rs.getString("jury"));
				ac.setType_par_sou(rs.getString("type_par_sou"));
				ac.setNiveau(rs.getString("niveau"));
				ac.setSous(rs.getString("sous_sup"));
				ac.setType_enc(rs.getString("type_enc"));
				ac.setType_pub(rs.getString("type_pub"));
				ac.setA_bstract(rs.getString("abstract"));
				ac.setAuteur1(rs.getString("auteur1"));
				ac.setAuteur2(rs.getString("auteur2"));
				ac.setAuteur3(rs.getString("auteur3"));
				ac.setTitre(rs.getString("titre"));
				ac.setDescription_projet(rs.getString("description_projet"));
				ac.setBudget(rs.getString("budget"));
				ac.setDuree(rs.getString("duree"));
				ac.setIdchercheur(rs.getInt("idchercheur"));
				System.out.println("valide");
			}
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		return ac;
	}

	@Override
	public Activite updateActivite(Activite c) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteActivite(int id) {
		// TODO Auto-generated method stub
		try {
			PreparedStatement ps= conn.prepareStatement("DELETE FROM activite WHERE id_activite = ?");
			ps.setInt(1, id);
			ps.executeUpdate();
			ps.close();
			System.out.println("valide");
		}
		catch (SQLException e) {
			 e.printStackTrace();
		}
		
	}

	

	

	@Override
	public List<Activite> listConf(int idchercheur) {
		// TODO Auto-generated method stub
		List<Activite> listConf=new ArrayList<Activite>();
		try {
			PreparedStatement ps= conn.prepareStatement("select * from activite where idchercheur =? and type_ac='conference'");
			ps.setInt(1,idchercheur);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Activite ac = new Activite();
				ac.setId_activite(rs.getInt("id_activite"));
				ac.setJour(rs.getString("jour"));
				ac.setMois(rs.getString("mois"));
				ac.setAnnee(rs.getString("annee"));
				ac.setInitule(rs.getString("initule"));
				ac.setLieu(rs.getString("lieu"));
				listConf.add(ac);	
				System.out.println("valide");
			}
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		return listConf;
	}

	@Override
	public byte[] getJust(int id) {
		// TODO Auto-generated method stub
		ResultSet rset=null;
		byte[] bytes=null;
		try {
			PreparedStatement ps = conn.prepareStatement("Select justificatif from activite where id_activite=?");
			ps.setInt(1, id);
			rset = ps.executeQuery();
			if (rset.next()) {
				bytes =  rset.getBytes("justificatif");

			}
			else return null;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return bytes;  

	}

	@Override
	public List<Activite> listSout(int idchercheur) {
		// TODO Auto-generated method stub
		List<Activite> listConf=new ArrayList<Activite>();
		try {
			PreparedStatement ps= conn.prepareStatement("select * from activite where idchercheur =? and type_ac='soutenance'");
			ps.setInt(1,idchercheur);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Activite ac = new Activite();
				ac.setId_activite(rs.getInt("id_activite"));
				ac.setJour(rs.getString("jour"));
				ac.setMois(rs.getString("mois"));
				ac.setAnnee(rs.getString("annee"));
				ac.setInitule(rs.getString("initule"));
				ac.setLieu(rs.getString("lieu"));
				ac.setJury(rs.getString("jury"));
				ac.setType_par_sou(rs.getString("type_par_sou"));
				System.out.println("type_par_sou :"+rs.getString("type_par_sou"));
				listConf.add(ac);	
				System.out.println("valide");
			}
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		return listConf;
		
	}

	@Override
	public List<Activite> listEncad(int idchercheur) {
		// TODO Auto-generated method stub
		List<Activite> listEncad=new ArrayList<Activite>();
		try {
			PreparedStatement ps= conn.prepareStatement("select * from activite where idchercheur =? and type_ac='encadrement'");
			ps.setInt(1,idchercheur);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Activite ac = new Activite();
				ac.setId_activite(rs.getInt("id_activite"));
				ac.setJour(rs.getString("jour"));
				ac.setMois(rs.getString("mois"));
				ac.setAnnee(rs.getString("annee"));
				ac.setNiveau(rs.getString("niveau"));
				ac.setSous(rs.getString("sous_sup"));
				ac.setType_enc(rs.getString("type_enc"));
				listEncad.add(ac);	
				System.out.println("valide");
			}
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		return listEncad;
	}

	@Override
	public List<Activite> listPub(int idchercheur) {
		// TODO Auto-generated method stub
		List<Activite> listPub=new ArrayList<Activite>();
		try {
			PreparedStatement ps= conn.prepareStatement("select * from activite where idchercheur =? and type_ac='publication'");
			ps.setInt(1,idchercheur);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Activite ac = new Activite();
				ac.setId_activite(rs.getInt("id_activite"));
				ac.setJour(rs.getString("jour"));
				ac.setMois(rs.getString("mois"));
				ac.setAnnee(rs.getString("annee"));
				ac.setA_bstract(rs.getString("abstract"));
				ac.setAuteur1(rs.getString("auteur1"));
				ac.setAuteur2(rs.getString("auteur2"));
				ac.setAuteur3(rs.getString("auteur3"));
				ac.setTitre(rs.getString("titre"));
				
				
				
				listPub.add(ac);	
				System.out.println("valide");
			}
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		return listPub;
		
	}

	@Override
	public List<Activite> listProjet(int idchercheur) {
		// TODO Auto-generated method stub
		List<Activite> listProjet=new ArrayList<Activite>();
		try {
			PreparedStatement ps= conn.prepareStatement("select * from activite where idchercheur =? and type_ac='projet'");
			ps.setInt(1,idchercheur);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Activite ac = new Activite();
				ac.setId_activite(rs.getInt("id_activite"));
				ac.setJour(rs.getString("jour"));
				ac.setMois(rs.getString("mois"));
				ac.setAnnee(rs.getString("annee"));
				
				ac.setTitre(rs.getString("titre"));
				
				ac.setDescription_projet(rs.getString("description_projet"));
				ac.setBudget(rs.getString("budget"));
				ac.setDuree(rs.getString("duree"));
				
				
				
				listProjet.add(ac);	
				System.out.println("valide");
			}
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		return listProjet;
	}

	@Override
	public List<Activite> listAllEncad() {
		// TODO Auto-generated method stub
		List<Activite> listEncad=new ArrayList<Activite>();
		try {
			PreparedStatement ps= conn.prepareStatement("select * from activite where type_ac='encadrement'");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Activite ac = new Activite();
				ac.setId_activite(rs.getInt("id_activite"));
				ac.setJour(rs.getString("jour"));
				ac.setMois(rs.getString("mois"));
				ac.setAnnee(rs.getString("annee"));
				ac.setNiveau(rs.getString("niveau"));
				ac.setSous(rs.getString("sous_sup"));
				ac.setType_enc(rs.getString("type_enc"));
				ac.setIdchercheur(rs.getInt("idchercheur"));
				listEncad.add(ac);	
				System.out.println("valide");
			}
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		return listEncad;
		
	}

	@Override
	public List<Activite> listAllSout() {
		// TODO Auto-generated method stub
		List<Activite> listConf=new ArrayList<Activite>();
		try {
			PreparedStatement ps= conn.prepareStatement("select * from activite where type_ac='soutenance'");
			
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Activite ac = new Activite();
				ac.setId_activite(rs.getInt("id_activite"));
				ac.setJour(rs.getString("jour"));
				ac.setMois(rs.getString("mois"));
				ac.setAnnee(rs.getString("annee"));
				ac.setInitule(rs.getString("initule"));
				ac.setLieu(rs.getString("lieu"));
				ac.setJury(rs.getString("jury"));
				ac.setType_par_sou(rs.getString("type_par_sou"));
				System.out.println("type_par_sou :"+rs.getString("type_par_sou"));
				ac.setIdchercheur(rs.getInt("idchercheur"));
				listConf.add(ac);	
				System.out.println("valide");
			}
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		return listConf;
		
	}

	@Override
	public List<Activite> listAllConf() {
		// TODO Auto-generated method stub
		List<Activite> listConf=new ArrayList<Activite>();
		try {
			PreparedStatement ps= conn.prepareStatement("select * from activite where type_ac='conference'");
			
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Activite ac = new Activite();
				ac.setId_activite(rs.getInt("id_activite"));
				ac.setJour(rs.getString("jour"));
				ac.setMois(rs.getString("mois"));
				ac.setAnnee(rs.getString("annee"));
				ac.setInitule(rs.getString("initule"));
				ac.setLieu(rs.getString("lieu"));
				ac.setIdchercheur(rs.getInt("idchercheur"));
				listConf.add(ac);	
				System.out.println("valide");
			}
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		return listConf;
		
	}

	@Override
	public List<Activite> listAllPro() {
		// TODO Auto-generated method stub
		List<Activite> listProjet=new ArrayList<Activite>();
		try {
			PreparedStatement ps= conn.prepareStatement("select * from activite where type_ac='projet'");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Activite ac = new Activite();
				ac.setId_activite(rs.getInt("id_activite"));
				ac.setJour(rs.getString("jour"));
				ac.setMois(rs.getString("mois"));
				ac.setAnnee(rs.getString("annee"));
				
				ac.setTitre(rs.getString("titre"));
				
				ac.setDescription_projet(rs.getString("description_projet"));
				ac.setBudget(rs.getString("budget"));
				ac.setDuree(rs.getString("duree"));
				
				ac.setIdchercheur(rs.getInt("idchercheur"));
				
				listProjet.add(ac);	
				System.out.println("valide");
			}
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		return listProjet;
		
	}

	@Override
	public List<Activite> listAllPub() {
		// TODO Auto-generated method stub
		List<Activite> listPub=new ArrayList<Activite>();
		try {
			PreparedStatement ps= conn.prepareStatement("select * from activite where type_ac='publication'");
			
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Activite ac = new Activite();
				ac.setId_activite(rs.getInt("id_activite"));
				ac.setJour(rs.getString("jour"));
				ac.setMois(rs.getString("mois"));
				ac.setAnnee(rs.getString("annee"));
				ac.setA_bstract(rs.getString("abstract"));
				ac.setAuteur1(rs.getString("auteur1"));
				ac.setAuteur2(rs.getString("auteur2"));
				ac.setAuteur3(rs.getString("auteur3"));
				ac.setTitre(rs.getString("titre"));
				ac.setIdchercheur(rs.getInt("idchercheur"));
				ac.setType_pub(rs.getString("type_pub"));
				
				listPub.add(ac);	
				System.out.println("valide");
			}
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		return listPub;
		
	}

	@Override
	public List<Activite> listAllPubMc(String mc) {
		// TODO Auto-generated method stub
		List<Activite> listPub=new ArrayList<Activite>();
		try {
			
			PreparedStatement ps= conn.prepareStatement("select * from activite where type_ac='publication' and annee LIKE ? or auteur1 LIKE ? or auteur2 LIKE ? or auteur3 LIKE ?");
			ps.setString(1, "%"+mc+"%");
			ps.setString(2, "%"+mc+"%");
			ps.setString(3, "%"+mc+"%");
			ps.setString(4, "%"+mc+"%");
			ResultSet rs = ps.executeQuery();
			System.out.println(rs);
			while (rs.next()) {
				System.out.println("0000");
				Activite ac = new Activite();
				ac.setId_activite(rs.getInt("id_activite"));
				ac.setJour(rs.getString("jour"));
				ac.setMois(rs.getString("mois"));
				ac.setAnnee(rs.getString("annee"));
				ac.setA_bstract(rs.getString("abstract"));
				ac.setAuteur1(rs.getString("auteur1"));
				ac.setAuteur2(rs.getString("auteur2"));
				ac.setAuteur3(rs.getString("auteur3"));
				ac.setTitre(rs.getString("titre"));
				ac.setIdchercheur(rs.getInt("idchercheur"));
				listPub.add(ac);	
				System.out.println("valide");
			}
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		return listPub;
		
	}
	

}
