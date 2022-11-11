package entidad;

public class Cita {
	public int id_cita;
	public String det_cita;
	public int id_cliente;
	public int id_mascota;
	public int id_vet;
	public int id_servicio;
	
	public Cita() {
	}
	
	public Cita(int id_cita, String det_cita, int id_cliente, int id_mascota, int id_vet,
			int id_servicio) {
		this.id_cita = id_cita;
		this.det_cita = det_cita;
		this.id_cliente = id_cliente;
		this.id_mascota = id_mascota;
		this.id_vet = id_vet;
		this.id_servicio = id_servicio;
	}
	
	public int getId_cita() {
		return id_cita;
	}
	public void setId_cita(int id_cita) {
		this.id_cita = id_cita;
	}
	public String getDet_cita() {
		return det_cita;
	}
	public void setDet_cita(String det_cita) {
		this.det_cita = det_cita;
	}
	public int getId_cliente() {
		return id_cliente;
	}
	public void setId_cliente(int id_cliente) {
		this.id_cliente = id_cliente;
	}
	public int getId_mascota() {
		return id_mascota;
	}
	public void setId_mascota(int id_mascota) {
		this.id_mascota = id_mascota;
	}
	public int getId_vet() {
		return id_vet;
	}
	public void setId_vet(int id_vet) {
		this.id_vet = id_vet;
	}
	public int getId_servicio() {
		return id_servicio;
	}
	public void setId_servicio(int id_servicio) {
		this.id_servicio = id_servicio;
	}
	
	
	
}
