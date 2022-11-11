package entidad;

public class Cliente {
	private int id_cliente;
	private String dni_cliente;
	private String nom_cliente;
	private String ape_cliente;
	private String tel_cliente;
	private String dir_cliente;
	private int id_distrito;
	public Cliente() {
		
	}
	public Cliente(int id_cliente, String dni_cliente, String nom_cliente, String ape_cliente, String tel_cliente,
			String dir_cliente, int id_distrito) {
		
		this.id_cliente = id_cliente;
		this.dni_cliente = dni_cliente;
		this.nom_cliente = nom_cliente;
		this.ape_cliente = ape_cliente;
		this.tel_cliente = tel_cliente;
		this.dir_cliente = dir_cliente;
		this.id_distrito = id_distrito;
	}
	public int getId_cliente() {
		return id_cliente;
	}
	public void setId_cliente(int id_cliente) {
		this.id_cliente = id_cliente;
	}
	public String getDni_cliente() {
		return dni_cliente;
	}
	public void setDni_cliente(String dni_cliente) {
		this.dni_cliente = dni_cliente;
	}
	public String getNom_cliente() {
		return nom_cliente;
	}
	public void setNom_cliente(String nom_cliente) {
		this.nom_cliente = nom_cliente;
	}
	public String getApe_cliente() {
		return ape_cliente;
	}
	public void setApe_cliente(String ape_cliente) {
		this.ape_cliente = ape_cliente;
	}
	public String getTel_cliente() {
		return tel_cliente;
	}
	public void setTel_cliente(String tel_cliente) {
		this.tel_cliente = tel_cliente;
	}
	public String getDir_cliente() {
		return dir_cliente;
	}
	public void setDir_cliente(String dir_cliente) {
		this.dir_cliente = dir_cliente;
	}
	public int getId_distrito() {
		return id_distrito;
	}
	public void setId_distrito(int dis) {
		this.id_distrito = dis;
	}
	
	
	
}
