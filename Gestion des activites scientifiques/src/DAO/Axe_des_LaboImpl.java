package DAO;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Metier.Axe_des_labo;

public class Axe_des_LaboImpl implements IAxe_des_laboDao{
	Connection conn=SingletonConnection.getConnection();

	@Override
	public void addAxe_des_labo(int idAxe, int idLabo) {
		// TODO Auto-generated method stub
		try {
			PreparedStatement ps= conn.prepareStatement("INSERT INTO axe_des_labo(idlabo,idaxelabo) VALUES(?,?)");
			ps.setInt(1, idLabo);
			ps.setInt(2, idAxe);
			ps.executeUpdate();
			ps.close();
			System.out.println("valide");
		}
		catch (SQLException e) {
			 e.printStackTrace();
		}
	}

	@Override
	public List<Axe_des_labo> getAxe_des_labo(int idLabo) {
		// TODO Auto-generated method stub
		List<Axe_des_labo> listaxe=new ArrayList<Axe_des_labo>();
		System.out.println(0);
		try {
			PreparedStatement ps= conn.prepareStatement("select * from axe_des_labo where idlabo = ?");
			ps.setInt(1, idLabo);
			System.out.println("labo :"+idLabo);
			ResultSet rs = ps.executeQuery();
			while  (rs.next()) {
				Axe_des_labo axe=new Axe_des_labo();
				axe.setIdlabo(rs.getInt("idlabo"));
				axe.setIdaxlabo(rs.getInt("idaxelabo"));
				System.out.println("test "+rs.getInt("idlabo"));
				System.out.println("test "+rs.getInt("idaxelabo"));
				listaxe.add(axe);
				System.out.println("valide");
			}
			System.out.println(listaxe);
		}
		catch (SQLException e) {
			 e.printStackTrace();
		}
		return listaxe;
		
	}

	@Override
	public void deleteFromlabo(int idlabo,int idaxe) {
		// TODO Auto-generated method stub
		try {
			PreparedStatement ps= conn.prepareStatement("DELETE FROM axe_des_labo WHERE idlabo = ? and idaxelabo = ?");
			ps.setInt(1, idlabo);
			ps.setInt(2, idaxe);
			ps.executeUpdate();
			ps.close();
			System.out.println("valide");
		}
		catch (SQLException e) {
			 e.printStackTrace();
		}
		
	}
	
	

}
