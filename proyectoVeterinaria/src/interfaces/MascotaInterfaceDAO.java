package interfaces;

import java.util.ArrayList;


import entidad.Mascota;

public interface MascotaInterfaceDAO {
	public int registrarMascota(Mascota m);
	public int actualizarMascota(Mascota m);
	public int eliminarMascota(int codigo);
	public Mascota buscarMascota(int codigo);
	public ArrayList<Mascota> listarMascota();
}
