package interfaces;

import java.util.ArrayList;

import entidad.Cliente;

public interface ClienteInterfaceDAO {
	public int registrarCliente(Cliente c);
	public int actualizarCliente(Cliente c);
	public int eliminarCliente(int codigo);
	public Cliente buscarCliente(int codigo);
	public ArrayList<Cliente> listarCliente();

}
