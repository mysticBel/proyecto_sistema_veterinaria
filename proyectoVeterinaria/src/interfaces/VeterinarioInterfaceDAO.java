package interfaces;

import java.util.ArrayList;

import entidad.Veterinario;

public interface VeterinarioInterfaceDAO {
	public int registrarVeterinario(Veterinario v);
	public int actualizarVeterinario(Veterinario v);
	public int eliminarVeterinario(int codigo);
	public Veterinario buscarVeterinario(int codigo);
	public ArrayList<Veterinario> listarVeterinario();
}
