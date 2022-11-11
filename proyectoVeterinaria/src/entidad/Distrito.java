package entidad;

public class Distrito {
	private int id_distrito;
	private String nom_distrito;
	public Distrito() {
		
	}
	public Distrito(int id_distrito, String nom_distrito) {
		this.id_distrito = id_distrito;
		this.nom_distrito = nom_distrito;
	}
	public int getId_distrito() {
		return id_distrito;
	}
	public void setId_distrito(int id_distrito) {
		this.id_distrito = id_distrito;
	}
	public String getNom_distrito() {
		return nom_distrito;
	}
	public void setNom_distrito(String nom_distrito) {
		this.nom_distrito = nom_distrito;
	}
	
	
	
}
