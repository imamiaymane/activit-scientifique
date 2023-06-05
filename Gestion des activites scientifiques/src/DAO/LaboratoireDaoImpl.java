package DAO;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Metier.Chercheur;
import Metier.Equipe;
import Metier.Laboratoire;

public class LaboratoireDaoImpl implements ILaboratoireDao{
	Connection conn=SingletonConnection.getConnection();
	
	@Override
	public List<Laboratoire> laboratoireParMC(String mc) {
		// TODO Auto-generated method stub
		List<Laboratoire> labo=new ArrayList<Laboratoire>();
		try {
			
			PreparedStatement ps= conn.prepareStatement("select * from laboratoire where nom_labo LIKE ?");
			ps.setString(1, "%"+mc+"%");
			ResultSet rs = ps.executeQuery();
			System.out.println(rs);
			while (rs.next()) {
				System.out.println("0000");
				Laboratoire lab = new Laboratoire();
				lab.setId_laboratoire(rs.getInt("id_laboratoire"));	
				lab.setNom_labo(rs.getString("nom_labo"));
				lab.setChef_labo(rs.getInt("chef_labo"));
				labo.add(lab);	
				System.out.println("valide");
				
			}
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		return labo;	
	}

	@Override
	public void addLaboratoire(Laboratoire l) {
		// TODO Auto-generated method stub
		try {
			PreparedStatement ps= conn.prepareStatement("INSERT INTO laboratoire(nom_labo,chef_labo) VALUES(?,?)");
			ps.setString(1, l.getNom_labo());
			ps.setInt(2, l.getChef_labo());
			ps.executeUpdate();
			ps.close();
			System.out.println("valide");
		}
		catch (SQLException ex) {
			 ex.printStackTrace();
		}
		
	}

	@Override
	public Laboratoire getLaboratoire(int id) {
		// TODO Auto-generated method stub
		Laboratoire l=new Laboratoire();
		try {
			PreparedStatement ps= conn.prepareStatement("select * from laboratoire where id_laboratoire = ?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if  (rs.next()) {
				l.setId_laboratoire(rs.getInt("id_laboratoire"));
				l.setNom_labo(rs.getString("nom_labo"));
				l.setChef_labo(rs.getInt("chef_labo"));
				System.out.println("valide");
			}
		}
		catch (SQLException e) {
			 e.printStackTrace();
		}
		return l;
	}

	@Override
	public void updateLaboratoire(Laboratoire c, int id) {
		// TODO Auto-generated method stub
		try{
			PreparedStatement ps= conn.prepareStatement("UPDATE laboratoire SET nom_labo=?,chef_labo=? WHERE id_laboratoire=?");
			ps.setString(1, c.getNom_labo());
			ps.setInt(2, c.getChef_labo());
			ps.setInt(3, id);
			ps.executeUpdate();
			ps.close();
			System.out.println("valide");
		}
		catch (SQLException e) {
			 e.printStackTrace();
		}
	}

	@Override
	public void deleteLaboratoire(int id) {
		// TODO Auto-generated method stub
		try {
			PreparedStatement ps= conn.prepareStatement("DELETE FROM laboratoire WHERE id_laboratoire = ?");
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
	
	/***************************list des labo **************************/
	public List<Laboratoire> listlabo() {
		// TODO Auto-generated method stub
		List<Laboratoire> labos=new ArrayList<Laboratoire>();
		try {
			PreparedStatement ps= conn.prepareStatement("select * from laboratoire");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Laboratoire l = new Laboratoire();
				l.setId_laboratoire(rs.getInt("id_laboratoire"));
				l.setNom_labo(rs.getString("nom_labo"));
				l.setChef_labo(rs.getInt("chef_labo"));
				labos.add(l);	
				System.out.println("valide");
			}
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		return labos;
	}

	@Override
	public Laboratoire getId_Laboratoire(String nom) {
		// TODO Auto-generated method stub
		Laboratoire l=new Laboratoire();
		try {
			PreparedStatement ps= conn.prepareStatement("select * from laboratoire where nom_labo = ?");
			ps.setString(1, nom);
			ResultSet rs = ps.executeQuery();
			if  (rs.next()) {
				
				l.setId_laboratoire(rs.getInt("id_laboratoire"));
				l.setNom_labo(rs.getString("nom_labo"));
				l.setChef_labo(rs.getInt("chef_labo"));
				System.out.println("valide");
			}
		}
		catch (SQLException e) {
			 e.printStackTrace();
		}
		return l;
	}
	public String getNom_Laboratoire(int id) {
		// TODO Auto-generated method stub
		String nom=null;
		try {
			PreparedStatement ps= conn.prepareStatement("select * from laboratoire where id_laboratoire = ?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if  (rs.next()) {
				nom=rs.getString("nom_labo");
				System.out.println(nom);
				System.out.println("valide");
			}
		}
		catch (SQLException e) {
			 e.printStackTrace();
		}
		return nom;
	}

	@Override
	public List<Chercheur> listNewChef(int id) {
		// TODO Auto-generated method stub
		System.out.println("iiiiiiiiiiid" +id);
		List<Chercheur> Chefs=new ArrayList<Chercheur>();
		try {
			PreparedStatement ps= conn.prepareStatement("select distinct A.* from  chercheur A, equipe B where id_chercheur in (select id_chercheur from chercheur where idequipe in (select id_equipe from equipe where idlabo=?) and profile='enseignant' )");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Chercheur c = new Chercheur();
				c.setId_chercheur(rs.getInt("id_chercheur"));
				System.out.println("id :"+rs.getInt("id_chercheur"));
				c.setNom(rs.getString("nom"));
				System.out.println("nom :"+rs.getString("nom"));
				c.setPrenom(rs.getString("prenom"));
				System.out.println("id :"+rs.getString("prenom"));
				Chefs.add(c);	
				System.out.println("valide");
			}
			System.out.println(Chefs);
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		return Chefs;
	}

	@Override
	public int id_labo(int idEq) {
		// TODO Auto-generated method stub
		int a=0;
		try {
			PreparedStatement ps= conn.prepareStatement("select idlabo from equipe where id_equipe = ?");
			ps.setInt(1, idEq);
			ResultSet rs = ps.executeQuery();
			if  (rs.next()) {
				a=rs.getInt("idlabo");
				System.out.println("id labo "+a);
				System.out.println("valide");
			}
		}
		catch (SQLException e) {
			 e.printStackTrace();
		}
		return a;
	}

	@Override
	public void DeleteFromAssociationaAxe(int idlabo) {
		// TODO Auto-generated method stub
		try {
			PreparedStatement ps= conn.prepareStatement("DELETE FROM axe_des_labo WHERE idlabo = ?");
			ps.setInt(1, idlabo);
			ps.executeUpdate();
			ps.close();
			System.out.println("valide");
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}
	
	



}
