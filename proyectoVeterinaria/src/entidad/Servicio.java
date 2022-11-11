package entidad;

public class Servicio {
	private int id_servicio;
	private String nom_servicio;
	private Double costo_servicio;
	public Servicio() {
		
	}
	public Servicio(int id_servicio, String nom_servicio, Double costo_servicio) {
		this.id_servicio = id_servicio;
		this.nom_servicio = nom_servicio;
		this.costo_servicio = costo_servicio;
	}
	public int getId_servicio() {
		return id_servicio;
	}
	public void setId_servicio(int id_servicio) {
		this.id_servicio = id_servicio;
	}
	public String getNom_Servicio() {
		return nom_servicio;
	}
	public void setNom_servicio(String nom_servicio) {
		this.nom_servicio = nom_servicio; 
	}
	public Double getCosto_servicio() {
		return costo_servicio;
	}
	public void setCosto_servicio(Double costo_servicio) {
		this.costo_servicio = costo_servicio;
	}
	
	
}
