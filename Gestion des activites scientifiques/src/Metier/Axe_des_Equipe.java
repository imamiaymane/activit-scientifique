package Metier;

import java.io.Serializable;

public class Axe_des_Equipe implements Serializable{
	private int idequipe;
	private int idaxeequipe;
	
	public Axe_des_Equipe() {
		super();
	}
	public int getIdequipe() {
		return idequipe;
	}
	public void setIdequipe(int idequipe) {
		this.idequipe = idequipe;
	}
	public int getIdaxeequipe() {
		return idaxeequipe;
	}
	public void setIdaxeequipe(int idaxeequipe) {
		this.idaxeequipe = idaxeequipe;
	}
	@Override
	public String toString() {
		return "Axe_des_Equipe [idequipe=" + idequipe + ", idaxeequipe=" + idaxeequipe + "]";
	}
}
