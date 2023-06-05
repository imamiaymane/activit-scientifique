package DAO;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Metier.Chercheur;
import Metier.Equipe;

public class EquipeDaoImpl implements IEquipeDao {
	Connection conn=SingletonConnection.getConnection();

	@Override
	public List<Equipe> equipeParMC(String mc) {
		// TODO Auto-generated method stub
		List<Equipe> Equipes=new ArrayList<Equipe>();
		try {
			
			PreparedStatement ps= conn.prepareStatement("select * from equipe where nom_equipe LIKE ?");
			ps.setString(1, "%"+mc+"%");
			ResultSet rs = ps.executeQuery();
			System.out.println(rs);
			while (rs.next()) {
				System.out.println("0000");
				Equipe equ = new Equipe();
				equ.setId_equipe(rs.getInt("id_equipe"));	
				equ.setNom_equipe(rs.getString("nom_equipe"));
				equ.setChef_equipe(rs.getInt("chef_equipe"));
				equ.setId_laboratoire(rs.getInt("idlabo"));
				Equipes.add(equ);	
				System.out.println("valide");
				
			}
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		return Equipes;		
	}

	@Override
	public void addEquipe(Equipe e) {
		// TODO Auto-generated method stub
		try {
			PreparedStatement ps= conn.prepareStatement("INSERT INTO equipe(nom_equipe,chef_equipe,idlabo) VALUES(?,?,?)");
			ps.setString(1, e.getNom_equipe());
			ps.setInt(2, e.getChef_equipe());
			ps.setInt(3, e.getId_laboratoire());
			ps.executeUpdate();
			ps.close();
			System.out.println("valide");
		}
		catch (SQLException ex) {
			 ex.printStackTrace();
		}
		
	}

	@Override
	public Equipe getEquipe(int id) {
		// TODO Auto-generated method stub
		Equipe eq=new Equipe();
		try {
			PreparedStatement ps= conn.prepareStatement("select * from equipe where id_equipe = ?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if  (rs.next()) {
				eq.setId_equipe(rs.getInt("id_equipe"));
				eq.setNom_equipe(rs.getString("nom_equipe"));
				eq.setChef_equipe(rs.getInt("chef_equipe"));	
				System.out.println("in");
			}
		}
		catch (SQLException e) {
			 e.printStackTrace();
		}
		return eq;
	}

	@Override
	public Equipe updateEquipe(int id,Equipe c) {
		// TODO Auto-generated method stub
		try{
			PreparedStatement ps= conn.prepareStatement("UPDATE equipe SET nom_equipe=?,chef_equipe=? WHERE id_equipe=?");
			ps.setString(1, c.getNom_equipe());
			ps.setInt(2, c.getChef_equipe());
			ps.setInt(3, id);
			ps.executeUpdate();
			ps.close();
			System.out.println("valide");
		}
		catch (SQLException e) {
			 e.printStackTrace();
		}
		return null;
	}

	@Override
	public void deleteChercheurFromEquipe(int id) {
		// TODO Auto-generated method stub
		try{
			PreparedStatement ps= conn.prepareStatement("UPDATE chercheur SET idequipe=NULL WHERE Id_chercheur=?");
			ps.setInt(1, id);
			ps.executeUpdate();
			ps.close();
			System.out.println("valide");
		}
		catch (SQLException e) {
			 e.printStackTrace();
		}
	}

	
	/************************** id equipe par nom ****************************************/
	@Override
	public int getIdEquipe(String nom) {
		// TODO Auto-generated method stub
		int eq=0;
		try {
			PreparedStatement ps= conn.prepareStatement("select id_equipe from equipe where nom_equipe = ?");
			ps.setString(1, nom);
			ResultSet rs = ps.executeQuery();
			if  (rs.next()) {
				eq=rs.getInt("id_equipe");
				System.out.println("in");
			}
		}
		catch (SQLException e) {
			 e.printStackTrace();
		}
		return eq;
	}

	@Override
	public List<Equipe> listEquipe() {
		// TODO Auto-generated method stub
		List<Equipe> equipe=new ArrayList<Equipe>();
		try {
			PreparedStatement ps= conn.prepareStatement("select * from equipe");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Equipe eq = new Equipe();
				eq.setId_equipe(rs.getInt("id_equipe"));
				eq.setNom_equipe(rs.getString("nom_equipe"));
				eq.setChef_equipe(rs.getInt("chef_equipe"));
				eq.setId_laboratoire(rs.getInt("idlabo"));
				equipe.add(eq);	
				System.out.println("valide");
			}
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		return equipe;
	}

	@Override
	public List<Equipe> listEquipeDansLabo(int id) {
		List<Equipe> equipe=new ArrayList<Equipe>();
		try {
			PreparedStatement ps= conn.prepareStatement("select * from equipe where idlabo = ?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Equipe eq = new Equipe();
				eq.setId_equipe(rs.getInt("id_equipe"));
				eq.setNom_equipe(rs.getString("nom_equipe"));
				eq.setChef_equipe(rs.getInt("chef_equipe"));
				equipe.add(eq);	
				System.out.println("valide");
			}
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		return equipe;
	}

	@Override
	public List<Chercheur> listChercheurparEq(int idEq) {
		// TODO Auto-generated method stub
		List<Chercheur> cherchs=new ArrayList<Chercheur>();
		try {
			PreparedStatement ps= conn.prepareStatement("select * from chercheur where profile!='admin' and idequipe=?");
			ps.setInt(1, idEq);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Chercheur c = new Chercheur();
				c.setId_chercheur(rs.getInt("id_chercheur"));
				c.setNom(rs.getString("nom"));
				c.setPrenom(rs.getString("prenom"));
				c.setEmail(rs.getString("email"));
				c.setProfile(rs.getString("profile"));
				cherchs.add(c);	
				System.out.println("valide");
			}
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		return cherchs;
	}

	@Override
	public List<Chercheur> listNewChef(int idEq) {
		// TODO Auto-generated method stub
		List<Chercheur> cherchs=new ArrayList<Chercheur>();
		try {
			PreparedStatement ps= conn.prepareStatement("select * from chercheur where profile!='admin' and profile='enseignant' and idequipe=?");
			ps.setInt(1, idEq);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Chercheur c = new Chercheur();
				c.setId_chercheur(rs.getInt("id_chercheur"));
				c.setNom(rs.getString("nom"));
				c.setPrenom(rs.getString("prenom"));
				c.setEmail(rs.getString("email"));
				c.setProfile(rs.getString("profile"));
				cherchs.add(c);	
				System.out.println("valide");
			}
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		return cherchs;
	}

	@Override
	public void SetnullChercheur(int id) {
		// TODO Auto-generated method stub
		try{
			PreparedStatement ps= conn.prepareStatement("UPDATE chercheur SET idequipe=NULL WHERE idequipe=?");
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
	public void DeleteEquipe(int id) {
		// TODO Auto-generated method stub
		try {
			PreparedStatement ps= conn.prepareStatement("DELETE FROM equipe WHERE id_equipe = ?");
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
	public void DeleteFromAssociationAxe(int ideq) {
		// TODO Auto-generated method stub
		try {
			PreparedStatement ps= conn.prepareStatement("DELETE FROM axe_des_equipe WHERE idequipe = ?");
			ps.setInt(1, ideq);
			ps.executeUpdate();
			ps.close();
			System.out.println("valide");
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	

}
