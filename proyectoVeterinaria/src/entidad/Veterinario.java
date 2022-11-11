package entidad;

public class Veterinario {
	private int id_vet;
	private String dni_vet;
	private String nom_vet;
	private String ape_vet;
	private String tel_vet;
	public Veterinario() {
	
	}
	public Veterinario(int id_vet, String dni_vet, String nom_vet, String ape_vet, String tel_vet) {
		
		this.id_vet = id_vet;
		this.dni_vet = dni_vet;
		this.nom_vet = nom_vet;
		this.ape_vet = ape_vet;
		this.tel_vet = tel_vet;
	}
	public int getId_vet() {
		return id_vet;
	}
	public void setId_vet(int id_vet) {
		this.id_vet = id_vet;
	}
	public String getDni_vet() {
		return dni_vet;
	}
	public void setDni_vet(String dni_vet) {
		this.dni_vet = dni_vet;
	}
	public String getNom_vet() {
		return nom_vet;
	}
	public void setNom_vet(String nom_vet) {
		this.nom_vet = nom_vet;
	}
	public String getApe_vet() {
		return ape_vet;
	}
	public void setApe_vet(String ape_vet) {
		this.ape_vet = ape_vet;
	}
	public String getTel_vet() {
		return tel_vet;
	}
	public void setTel_vet(String tel_vet) {
		this.tel_vet = tel_vet;
	}
	
	
}
