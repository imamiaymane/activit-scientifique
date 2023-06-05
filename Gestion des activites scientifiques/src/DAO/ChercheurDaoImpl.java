package DAO;
import java.util.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Metier.Chercheur;

public class ChercheurDaoImpl implements IChercheurDao{
	Connection conn=SingletonConnection.getConnection();
	@Override
	
	/***************************list des chercheurs par mc **************************/
	
	public List<Chercheur> chercheurParMC(String mc) { //ok
		// TODO Auto-generated method stub
		
		List<Chercheur> cherchs=new ArrayList<Chercheur>();
		try {
			
			PreparedStatement ps= conn.prepareStatement("select * from chercheur where profile!='admin' and nom LIKE ? or idequipe LIKE ?");
			ps.setString(1, "%"+mc+"%");
			ps.setString(2, "%"+mc+"%");
			ResultSet rs = ps.executeQuery();
			System.out.println(rs);
			while (rs.next()) {
				System.out.println("0000");
				Chercheur c = new Chercheur();
				c.setId_chercheur(rs.getInt("id_chercheur"));	
				c.setNom(rs.getString("nom"));
				c.setPrenom(rs.getString("prenom"));
				c.setEmail(rs.getString("email"));
				c.setPass(rs.getString("pass"));
				c.setTelephone(rs.getString("telephone"));
				c.setProfile(rs.getString("profile"));
				c.setActivite_pedagogique(rs.getString("activite_pedagogique"));
				c.setResponsabilite(rs.getString("responsabilite"));
				c.setId_equipe(rs.getInt("idequipe"));
				cherchs.add(c);	
				System.out.println("valide");
				
			}
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		return cherchs;
	}
	
	/***************************ajouter chercheurs **************************/

	@Override
	public void addChercheur(Chercheur c) { //ok
		// TODO Auto-generated method stub
		
		try {
			PreparedStatement ps= conn.prepareStatement("INSERT INTO chercheur(nom,prenom,email,pass,telephone,profile,photo) VALUES(?,?,?,?,?,?,?)");
			ps.setString(1, c.getNom());
			ps.setString(2, c.getPrenom());
			ps.setString(3, c.getEmail());
			ps.setString(4, c.getPass());
			ps.setString(5,c.getTelephone());
			ps.setString(6, c.getProfile());
			ps.setBlob(7,c.getPhoto());
			ps.executeUpdate();
			ps.close();
			System.out.println("valide");
		}
		catch (SQLException e) {
			 e.printStackTrace();
		}
	}
	
	/************************** get chercheur **************************/

	@Override
	public Chercheur getChercheur(int id) {  //ok
		// TODO Auto-generated method stub
		Chercheur c=new Chercheur();
		try {
			PreparedStatement ps= conn.prepareStatement("select * from chercheur where id_chercheur = ?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if  (rs.next()) {
				
				c.setId_chercheur(rs.getInt("id_chercheur"));
				c.setNom(rs.getString("nom"));
				System.out.println("nom :"+rs.getString("nom"));
				c.setPrenom(rs.getString("prenom"));
				c.setEmail(rs.getString("email"));
				c.setPass(rs.getString("pass"));
				c.setTelephone(rs.getString("telephone"));
				c.setProfile(rs.getString("profile"));
				c.setActivite_pedagogique(rs.getString("activite_pedagogique"));
				c.setResponsabilite(rs.getString("responsabilite"));
					
				
				c.setId_equipe(rs.getInt("idequipe"));
				System.out.println("valide");
			}
		}
		catch (SQLException e) {
			 e.printStackTrace();
		}
		return c;
	}
	
	/***************************update chercheur **************************/

	@Override
	public void updateChercheur(int id,Chercheur c) { //ok
		// TODO Auto-generated method stub
		try{
			PreparedStatement ps= conn.prepareStatement("UPDATE chercheur SET nom=?,prenom=?,telephone=?,profile=? WHERE Id_chercheur=?");
			ps.setString(1, c.getNom());
			ps.setString(2, c.getPrenom());
			ps.setString(3,c.getTelephone());
			ps.setString(4, c.getProfile());
			
			ps.setInt(5, id);
			ps.executeUpdate();
			ps.close();
			System.out.println("valide");
		}
		catch (SQLException e) {
			 e.printStackTrace();
		}
	}
	/***************************delete chercheur **************************/

	@Override
	public void deleteChercheur(int id) { 
		// TODO Auto-generated method stub
		try {
			PreparedStatement ps= conn.prepareStatement("DELETE FROM chercheur WHERE Id_chercheur = ?");
			ps.setInt(1, id);
			ps.executeUpdate();
			ps.close();
			System.out.println("valide");
		}
		catch (SQLException e) {
			 e.printStackTrace();
		}
	}

	/***************************verifier chercheur **************************/
	@Override
	public boolean verifierChercheur(String email, String nom){
		// TODO Auto-generated method stub
			
			boolean status = false;
	        
	        try {
	            PreparedStatement preparedStatement = conn.prepareStatement("select * from umi_user where email = ? and nom = ? "); 
	            preparedStatement.setString(1,email);
	            preparedStatement.setString(2,nom);
	            System.out.println(preparedStatement);
	            ResultSet rs = preparedStatement.executeQuery();
	            while(rs.next()) {
	            	System.out.println("email Rs : " + rs.getString("email"));
	            	status = true;
	            }
	        } 
	         catch (Exception e) {
	            // process sql exception
	            e.getMessage();
	        }
	        System.out.println(status);
		return status;
	}
	
	
	

	@Override
	public Chercheur getChercheurEmail(String email) {
		// TODO Auto-generated method stub
				Chercheur c=new Chercheur();
				try {
					PreparedStatement ps= conn.prepareStatement("select * from chercheur where email = ?");
					ps.setString(1, email);
					ResultSet rs = ps.executeQuery();
					if  (rs.next()) {
						c.setId_chercheur(rs.getInt("id_chercheur"));
						c.setNom(rs.getString("nom"));
						c.setPrenom(rs.getString("prenom"));
						c.setEmail(rs.getString("email"));
						c.setPass(rs.getString("pass"));
						c.setTelephone(rs.getString("telephone"));
						c.setProfile(rs.getString("profile"));
						c.setActivite_pedagogique(rs.getString("activite_pedagogique"));
						c.setResponsabilite(rs.getString("responsabilite"));
						c.setPhoto(rs.getBinaryStream("photo"));	
						c.setJustificatif(rs.getBinaryStream("justificatif"));	
						c.setId_equipe(rs.getInt("idequipe"));
						System.out.println("valide");
					}
				}
				catch (SQLException e) {
					 e.printStackTrace();
				}
				return c;
		
	}
			/**************************  verifier si le chercheur a deja un compte *********************/
	@Override
	public boolean verifierInscription(String email, String nom) {
		// TODO Auto-generated method stub
		
		boolean status = false;
        
        try {
            PreparedStatement preparedStatement = conn.prepareStatement("select * from chercheur where email = ? and nom = ? "); 
            preparedStatement.setString(1,email);
            preparedStatement.setString(2,nom);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()) {
            	System.out.println("email Rs : " + rs.getString("email"));
            	status = true;
            }
        } 
         catch (Exception e) {
            // process sql exception
            e.getMessage();
        }
        System.out.println(status);
        return status;
	}

	/**************************  liste des chercheurs *********************/
	@Override
	public List<Chercheur> listeChercheur() {
		// TODO Auto-generated method stub
		List<Chercheur> cherchs=new ArrayList<Chercheur>();
		try {
			PreparedStatement ps= conn.prepareStatement("select * from chercheur where profile!='admin'");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Chercheur c = new Chercheur();
				c.setId_chercheur(rs.getInt("id_chercheur"));
				c.setNom(rs.getString("nom"));
				c.setPrenom(rs.getString("prenom"));
				c.setEmail(rs.getString("email"));
				c.setPass(rs.getString("pass"));
				c.setTelephone(rs.getString("telephone"));
				c.setProfile(rs.getString("profile"));
				c.setActivite_pedagogique(rs.getString("activite_pedagogique"));
				c.setResponsabilite(rs.getString("responsabilite"));
				c.setPhoto(rs.getBinaryStream("photo"));
				c.setJustificatif(rs.getBinaryStream("justificatif"));
				c.setId_equipe(rs.getInt("idequipe"));
				cherchs.add(c);	
				System.out.println("valide");
			}
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		return cherchs;
	}
	/**************************  liste des chercheurs ens *********************/
	@Override
	public List<Chercheur> listeEns() {
		// TODO Auto-generated method stub
		List<Chercheur> cherchs=new ArrayList<Chercheur>();	
		try {
			PreparedStatement ps= conn.prepareStatement("select * from chercheur where idequipe is null and profile='enseignant'");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Chercheur c = new Chercheur();
				c.setId_chercheur(rs.getInt("id_chercheur"));
				c.setNom(rs.getString("nom"));
				c.setPrenom(rs.getString("prenom"));
				c.setEmail(rs.getString("email"));
				c.setPass(rs.getString("pass"));
				c.setTelephone(rs.getString("telephone"));
				c.setProfile(rs.getString("profile"));
				c.setActivite_pedagogique(rs.getString("activite_pedagogique"));
				c.setResponsabilite(rs.getString("responsabilite"));
				c.setPhoto(rs.getBinaryStream("photo"));
				c.setJustificatif(rs.getBinaryStream("justificatif"));
				c.setId_equipe(rs.getInt("idequipe"));
				cherchs.add(c);	
				System.out.println("valide");
			}
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		return cherchs;
	}
	/**************************  liste des chercheurs sans eq *********************/
	@Override
	public List<Chercheur> listsansEq() {
		// TODO Auto-generated method stub
		List<Chercheur> cherchs=new ArrayList<Chercheur>();
		try {
			PreparedStatement ps= conn.prepareStatement("select * from chercheur where idequipe is null and profile!='admin'");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Chercheur c = new Chercheur();
				c.setId_chercheur(rs.getInt("id_chercheur"));
				c.setNom(rs.getString("nom"));
				c.setPrenom(rs.getString("prenom"));
				c.setEmail(rs.getString("email"));
				c.setPass(rs.getString("pass"));
				c.setTelephone(rs.getString("telephone"));
				c.setProfile(rs.getString("profile"));
				c.setActivite_pedagogique(rs.getString("activite_pedagogique"));
				c.setResponsabilite(rs.getString("responsabilite"));
				c.setPhoto(rs.getBinaryStream("photo"));
				c.setJustificatif(rs.getBinaryStream("justificatif"));
				c.setId_equipe(rs.getInt("idequipe"));
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
	public void updateChercheurEquipe(int id, Chercheur c) {
		// TODO Auto-generated method stub
		try{
			PreparedStatement ps= conn.prepareStatement("UPDATE chercheur SET idequipe=? WHERE Id_chercheur=?");
			ps.setInt(1, c.getId_equipe());
			ps.setInt(2, id);
			ps.executeUpdate();
			ps.close();
			System.out.println("valide");
		}
		catch (SQLException e) {
			 e.printStackTrace();
		}
		
	}

	@Override
	public void deleteActivitesCh(int id) {
		// TODO Auto-generated method stub
		try {
			PreparedStatement ps= conn.prepareStatement("DELETE FROM activite WHERE idchercheur = ?");
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
	public void updateChercheurAC(int id, Chercheur c) {
		// TODO Auto-generated method stub
		try{
			PreparedStatement ps= conn.prepareStatement("UPDATE chercheur SET justificatif=?,activite_pedagogique=? WHERE Id_chercheur=?");
			ps.setBlob(1,c.getJustificatif());
			ps.setString(2,c.getActivite_pedagogique());
			ps.setInt(3, id);
			ps.executeUpdate();
			ps.close();
			System.out.println("valide");
		}
		catch (SQLException e) {
			 e.printStackTrace();
		}
		
	}
}	
	
