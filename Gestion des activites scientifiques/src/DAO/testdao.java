package DAO;
import java.sql.Connection;


import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Blob;

import Metier.Axe_equipe;
import Metier.Axe_laboratoire;
import Metier.Chercheur;
import DAO.ChercheurDaoImpl;

public class testdao {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Axe_laboratoireDaoImpl axe=new Axe_laboratoireDaoImpl();
		Connection conn=SingletonConnection.getConnection();
		//Axe_laboratoire aa=new Axe_laboratoire("hihi");
		//axe.updateAxe_laboratoireDao(2, aa);
		//System.out.println(axe.getAxe_equipe(2));
		//axe.deleteAxe_equipe(1);
		//axe.addAxe_laboratoireDao(aa);
//		axe.deleteAxe_laboratoireDao(1);
//		List<Axe_laboratoire> axela=axe.axe_laboratoireDaoParMC("hihi");
//		for(Axe_laboratoire a:axela) {
//			System.out.println(a);
//		}
		
		
		
		
		

		
		
	}
}
	