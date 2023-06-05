package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Metier.Chercheur;
import Metier.User;

public class UserDaoImpl implements IUserDao{
	Connection conn=SingletonConnection.getConnection();

	@Override
	public List<User> listeUser() {
		// TODO Auto-generated method stub
		List<User> us=new ArrayList<User>();
		try {
			PreparedStatement ps= conn.prepareStatement("select * from umi_user");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				User u = new User();
				u.setId(rs.getInt("id"));
				u.setNom(rs.getString("nom"));
				u.setPrenom(rs.getString("prenom"));
				u.setEmail(rs.getString("email"));
				us.add(u);	
				System.out.println("valide");
			}
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		return us;
	}

	@Override
	public User getUser(int id) {
		// TODO Auto-generated method stub
		User u=new User();
		try {
			PreparedStatement ps= conn.prepareStatement("select * from umi_user where id = ?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if  (rs.next()) {

				u.setId(rs.getInt("id"));
				u.setNom(rs.getString("nom"));
				u.setPrenom(rs.getString("prenom"));
				u.setPrenom(rs.getString("email"));
				System.out.println("valide");
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return u;
	}

	@Override
	public void deleteUser(int id) {
		// TODO Auto-generated method stub
		try {
			PreparedStatement ps= conn.prepareStatement("DELETE FROM umi_user WHERE id = ?");
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
	public void addUser(User u) {
		// TODO Auto-generated method stub
		try {
			PreparedStatement ps= conn.prepareStatement("INSERT INTO umi_user(nom,prenom,email) VALUES(?,?,?)");
			ps.setString(1, u.getNom());
			ps.setString(2, u.getPrenom());
			ps.setString(3, u.getEmail());
			ps.executeUpdate();
			ps.close();
			System.out.println("valide");
		}
		catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public boolean verifier(String email) throws ClassNotFoundException {
		// TODO Auto-generated method stub
		boolean status = false;
		Class.forName("com.mysql.jdbc.Driver");
		try {
			PreparedStatement preparedStatement = conn.prepareStatement("select * from umi_user where email = ?"); 
			preparedStatement.setString(1,email);
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
		return status;

	}

	@Override
	public List<User> userParMC(String mc) {
		// TODO Auto-generated method stub
		List<User> users=new ArrayList<User>();
		try {
			
			PreparedStatement ps= conn.prepareStatement("select * from umi_user where nom LIKE ?");
			ps.setString(1, "%"+mc+"%");
			ResultSet rs = ps.executeQuery();
			System.out.println(rs);
			while (rs.next()) {
				System.out.println("0000");
				User u = new User();
				u.setId(rs.getInt("id"));	
				u.setNom(rs.getString("nom"));
				u.setPrenom(rs.getString("prenom"));
				u.setEmail(rs.getString("email"));
				users.add(u);	
				System.out.println("valide");
			}
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		return users;
	}


}
