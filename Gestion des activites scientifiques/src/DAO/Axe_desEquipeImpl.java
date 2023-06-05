package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Metier.Axe_des_Equipe;
import Metier.Axe_des_labo;

public class Axe_desEquipeImpl implements IAxe_des_equipeDao{
	Connection conn=SingletonConnection.getConnection();
	@Override
	public void addAxe_des_equipe(int idAxe, int idequipe) {
		// TODO Auto-generated method stub
		try {
			PreparedStatement ps= conn.prepareStatement("INSERT INTO axe_des_equipe(idequipe,idaxeequipe) VALUES(?,?)");
			ps.setInt(1, idequipe);
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
	
	public List<Axe_des_Equipe> getAxe_des_Eq(int idEq) {
		// TODO Auto-generated method stub
		List<Axe_des_Equipe> listaxe=new ArrayList<Axe_des_Equipe>();
		System.out.println(0);
		try {
			PreparedStatement ps= conn.prepareStatement("select * from axe_des_equipe where idequipe = ?");
			ps.setInt(1, idEq);
			System.out.println("Equipe :"+idEq);
			ResultSet rs = ps.executeQuery();
			while  (rs.next()) {
				Axe_des_Equipe axe=new Axe_des_Equipe();
				axe.setIdequipe(rs.getInt("idequipe"));
				axe.setIdaxeequipe(rs.getInt("idaxeequipe"));
				System.out.println("test "+rs.getInt("idequipe"));
				System.out.println("test "+rs.getInt("idaxeequipe"));
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
	public boolean getAxe_des_equipe(int idaxeequipe, int idequipe) {
		// TODO Auto-generated method stub
		boolean res=false;
		try {
			PreparedStatement ps= conn.prepareStatement("select * from axe_des_equipe where idequipe = ? and idaxeequipe=?");
			ps.setInt(1, idaxeequipe);
			ps.setInt(2, idequipe);
			System.out.println("Axe Equipe :"+idaxeequipe);
			System.out.println("Equipe :"+idequipe);
			ResultSet rs = ps.executeQuery();
			while  (rs.next()) {
				res=true;
				System.out.println("valide");
			}
			
		}
		catch (SQLException e) {
			 e.printStackTrace();
		}
		
		return res;
	}
	@Override
	public void deleteAxe(int ideq,int idaxe) {
		// TODO Auto-generated method stub
		try {
			PreparedStatement ps= conn.prepareStatement("DELETE FROM axe_des_equipe WHERE idequipe = ? and idaxeequipe = ?");
			ps.setInt(1, ideq);
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
