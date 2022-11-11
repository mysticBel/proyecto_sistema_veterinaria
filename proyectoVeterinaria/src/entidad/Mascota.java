package entidad;

public class Mascota {
	private int id_mascota;
	private String nom_mascota;
	private String tipo_mascota;
	private String fec_nac_mascota;
	private int id_cliente;
	public Mascota() {
		
	}
	public Mascota(int id_mascota, String nom_mascota, String tipo_mascota, String fec_nac_mascota,
			int id_cliente) {
		this.id_mascota = id_mascota;
		this.nom_mascota = nom_mascota;
		this.tipo_mascota = tipo_mascota;
		this.fec_nac_mascota = fec_nac_mascota;
		this.id_cliente = id_cliente;
	}
	public int getId_mascota() {
		return id_mascota;
	}
	public void setId_mascota(int id_mascota) {
		this.id_mascota = id_mascota;
	}
	public String getNom_mascota() {
		return nom_mascota;
	}
	public void setNom_mascota(String nom_mascota) {
		this.nom_mascota = nom_mascota;
	}
	public String getTipo_mascota() {
		return tipo_mascota;
	}
	public void setTipo_mascota(String tipo_mascota) {
		this.tipo_mascota = tipo_mascota;
	}
	public String getFec_nac_mascota() {
		return fec_nac_mascota;
	}
	public void setFec_nac_Mascota(String fec_nac_mascota) {
		this.fec_nac_mascota = fec_nac_mascota;
	}
	public int getId_cliente() {
		return id_cliente;
	}
	public void setId_cliente(int id_cliente) {
		this.id_cliente = id_cliente;
	}
	
	
}
