package DAO;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

import java.sql.ResultSet;
import java.sql.SQLException;

import Metier.Axe_equipe;
import Metier.Axe_laboratoire;

public class Axe_equipeDaoImpl implements IAxe_equipeDao {
	Connection conn=SingletonConnection.getConnection();

	@Override
	public List<Axe_equipe> Axe_equipeParMC(String mc) {
		// TODO Auto-generated method stub
		List<Axe_equipe> axe_equipes=new ArrayList<Axe_equipe>();
		try {
			PreparedStatement ps= conn.prepareStatement("select * from axe_equipe where nom_axe_equipe LIKE ?");
			ps.setString(1, "%"+mc+"%");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Axe_equipe axe_eq=new Axe_equipe();
				axe_eq.setId_axe_equipe(rs.getInt("Id_axe_equipe"));
				axe_eq.setNom_axe_equipe(rs.getString("nom_axe_equipe"));
				axe_equipes.add(axe_eq);	
				System.out.println("valide");
			}
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		return axe_equipes;
	}

	@Override
	public void addAxe_equipe(Axe_equipe a) { //ok
		// TODO Auto-generated method stub
		try {
			PreparedStatement ps= conn.prepareStatement("INSERT INTO axe_equipe(nom_axe_equipe) VALUES(?)");
			ps.setString(1, a.getNom_axe_equipe());
			ps.executeUpdate();
			ps.close();
			System.out.println("valide");
		}
		catch (SQLException e) {
			 e.printStackTrace();
		}
	}

	@Override
	public Axe_equipe getAxe_equipe(int id) { //ok
		// TODO Auto-generated method stub
		Axe_equipe axe_eq=new Axe_equipe();
		try {
			PreparedStatement ps= conn.prepareStatement("select * from axe_equipe where id_axe_equipe = ?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if  (rs.next()) {
				axe_eq.setId_axe_equipe(rs.getInt("id_axe_equipe"));
				axe_eq.setNom_axe_equipe(rs.getString("nom_axe_equipe"));
				System.out.println("valideeee");
			}
		}
		catch (SQLException e) {
			 e.printStackTrace();
		}
		return axe_eq;
	}

	@Override
	public Axe_equipe updateAxe_equiper(int id,Axe_equipe a) { //ok
		// TODO Auto-generated method stub
		try {
			PreparedStatement ps= conn.prepareStatement("UPDATE axe_equipe SET nom_axe_equipe=? WHERE id_axe_equipe=?");
			ps.setString(1,a.getNom_axe_equipe());
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
	public void deleteAxe_equipe(int id) { //ok
		// TODO Auto-generated method stub
		try {
			PreparedStatement ps= conn.prepareStatement("DELETE FROM axe_equipe WHERE id_axe_equipe=?");
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
	public List<Axe_laboratoire> axelaboDequipe(int id) {
		// TODO Auto-generated method stub
		List<Axe_laboratoire> ax=new ArrayList<Axe_laboratoire>();
		try {
			PreparedStatement ps= conn.prepareStatement("select distinct T.* from  axe_laboratoire T, axe_des_labo B where B.idlabo =? and T.id_axe_laboratoire=B.idaxelabo");
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

	@Override
	public boolean axeEquipe(String nom) {
		// TODO Auto-generated method stub
		boolean res=false;
		try {
			PreparedStatement ps= conn.prepareStatement("select * from axe_equipe where nom_axe_equipe = ?");
			ps.setString(1, nom);
			ResultSet rs = ps.executeQuery();
			if  (rs.next()) {
				res=true;			
			}
		}
		catch (SQLException e) {
			 e.printStackTrace();
		}
		return res;
	}

	@Override
	public String nomAxe(int id) {
		// TODO Auto-generated method stub
		String nom=null;
		try {
			PreparedStatement ps= conn.prepareStatement("select nom_axe_laboratoire from axe_laboratoire where id_axe_laboratoire = ?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if  (rs.next()) {
				nom=rs.getString("nom_axe_laboratoire");
				System.out.println("nom :"+nom);
				System.out.println("valideeee");
			}
		}
		catch (SQLException e) {
			 e.printStackTrace();
		}
		return nom;
	}

	@Override
	public int getIdAxeEquipe(String nom) {
		// TODO Auto-generated method stub
		int a=0;
		try {
			PreparedStatement ps= conn.prepareStatement("select id_axe_equipe from axe_equipe where nom_axe_equipe = ?");
			ps.setString(1, nom);
			ResultSet rs = ps.executeQuery();
			if  (rs.next()) {
				a=rs.getInt("id_axe_equipe");
				System.out.println("id :"+a);
				System.out.println("valideeee");
			}
		}
		catch (SQLException e) {
			System.out.println("!!!valideeee");
			 e.printStackTrace();
		}
		return a;
	}

	
}
