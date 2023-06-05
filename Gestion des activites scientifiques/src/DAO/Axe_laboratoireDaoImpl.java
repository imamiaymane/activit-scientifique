package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import Metier.Axe_laboratoire;
import Metier.User;

public class Axe_laboratoireDaoImpl implements IAxe_laboratoireDao { //ok
	Connection conn=SingletonConnection.getConnection();

	@Override
	public List<Axe_laboratoire> axe_laboratoireDaoParMC(String mc) {
		// TODO Auto-generated method stub
		List<Axe_laboratoire> axe_labo=new ArrayList<Axe_laboratoire>();
		try {
			PreparedStatement ps= conn.prepareStatement("select * from axe_laboratoire where nom_axe_laboratoire LIKE ?");
			ps.setString(1, "%"+mc+"%");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Axe_laboratoire axe_la=new Axe_laboratoire();
				axe_la.setId_axe_laboratoire(rs.getInt("id_axe_laboratoire"));
				axe_la.setNom_axe_laboratoire(rs.getString("nom_axe_laboratoire"));
				axe_labo.add(axe_la);	
				System.out.println("valide");
			}
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		return axe_labo;
	}

	@Override
	public void addAxe_laboratoireDao(String nom) {	//ok
		// TODO Auto-generated method stub
		try {
			PreparedStatement ps= conn.prepareStatement("INSERT INTO axe_laboratoire(nom_axe_laboratoire) VALUES(?)");
			ps.setString(1, nom);
			ps.executeUpdate();
			ps.close();
			System.out.println("valide");
		}
		catch (SQLException e) {
			 e.printStackTrace();
		}
	}

	@Override
	public Axe_laboratoire getAxe_laboratoireDao(int id) {	//ok
		// TODO Auto-generated method stub
		Axe_laboratoire axe_labo=new Axe_laboratoire();
		try {
			PreparedStatement ps= conn.prepareStatement("select * from axe_laboratoire where id_axe_laboratoire = ?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if  (rs.next()) {
				axe_labo.setId_axe_laboratoire(rs.getInt("id_axe_laboratoire"));
				axe_labo.setNom_axe_laboratoire(rs.getString("nom_axe_laboratoire"));
				System.out.println("valideeee");
			}
		}
		catch (SQLException e) {
			 e.printStackTrace();
		}
		return axe_labo;
	}

	@Override
	public Axe_laboratoire updateAxe_laboratoireDao(int id,Axe_laboratoire a) {	//ok
		// TODO Auto-generated method stub
		try {
			PreparedStatement ps= conn.prepareStatement("UPDATE axe_laboratoire SET nom_axe_laboratoire=? WHERE id_axe_laboratoire=?");
			ps.setString(1,a.getNom_axe_laboratoire());
			ps.setInt(2, id);
			ps.executeUpdate();
			ps.close();
			System.out.println("valide");
		}
		catch (SQLException e) {
			 e.printStackTrace();
		}
		return a;
	}

	@Override
	public void deleteAxe_laboratoireDao(int id) {	//ok
		// TODO Auto-generated method stub
		try {
			PreparedStatement ps= conn.prepareStatement("DELETE FROM axe_laboratoire WHERE id_axe_laboratoire=?");
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
	public List<Axe_laboratoire> listeAxes() {
		// TODO Auto-generated method stub
		List<Axe_laboratoire> ax=new ArrayList<Axe_laboratoire>();
		try {
			PreparedStatement ps= conn.prepareStatement("select * from axe_laboratoire");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Axe_laboratoire a = new Axe_laboratoire();
				a.setId_axe_laboratoire(rs.getInt("id_axe_laboratoire"));
				a.setNom_axe_laboratoire(rs.getString("nom_axe_laboratoire"));
				ax.add(a);	
				System.out.println("valide");
			}
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		return ax;
	}

	@Override
	public List<Axe_laboratoire> listnewAxes(int id) {
		List<Axe_laboratoire> ax=new ArrayList<Axe_laboratoire>();
		try {
			PreparedStatement ps= conn.prepareStatement("select distinct A.* from  axe_laboratoire A, axe_des_labo B where id_axe_laboratoire not in (select idaxelabo from axe_des_labo where idlabo=?)");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Axe_laboratoire a = new Axe_laboratoire();
				a.setId_axe_laboratoire(rs.getInt("id_axe_laboratoire"));
				a.setNom_axe_laboratoire(rs.getString("nom_axe_laboratoire"));
				ax.add(a);	
				System.out.println("valide");
			}
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		return ax;
	}
	

}
