package interfaces;

import entidad.Usuario;

public interface UsuarioInterfacesDAO {
	// 1. Definimos los procesos
	public int registrarUsuario(Usuario u); //importamos de la capa entidad, es int poque en sql sale 1 si el registro es exitoso
	public int actualizarUsuario(Usuario u);
	
}
