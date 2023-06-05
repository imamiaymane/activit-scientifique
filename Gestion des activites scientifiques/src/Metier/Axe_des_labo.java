package Metier;
import java.io.Serializable;
public class Axe_des_labo implements Serializable {
	
	private int idlabo;
	private int idaxlabo;
	
	
	public Axe_des_labo() {
		super();
	}
	public int getIdlabo() {
		return idlabo;
	}
	public void setIdlabo(int idlabo) {
		this.idlabo = idlabo;
	}
	public int getIdaxlabo() {
		return idaxlabo;
	}
	public void setIdaxlabo(int idaxlabo) {
		this.idaxlabo = idaxlabo;
	}
	@Override
	public String toString() {
		return "Axe_des_labo [idlabo=" + idlabo + ", idaxlabo=" + idaxlabo + "]";
	}
	
	
	
	

}
