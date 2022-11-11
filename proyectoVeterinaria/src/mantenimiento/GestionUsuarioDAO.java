package mantenimiento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import entidad.Usuario;
import interfaces.UsuarioInterfacesDAO;
import utils.MySQLConexion8;

public class GestionUsuarioDAO implements UsuarioInterfacesDAO{  //importamos desde interfaces
	//Logica de Negocio
	// REGISTRO -  INSERT
	
	public int registrarUsuario(Usuario u) {
		int res = 0;
		Connection con = null; //si cambia d evalor, indica que la conexion fue exitosa,importar connection
		PreparedStatement pstm = null; 
		try {
			// PASO 1 :  Establecer la conexion a la BD, instancias de getConnection
			con = MySQLConexion8.getConexion();
			// PASO 2 : Registro ->Definir la instruccion SQL 
			//			insert into tb_usuarios values (null, "Mario", "Perez", "U004", "1004", "2020-08-22", default, default);
			String sql = "insert into tb_usuarios values (null, ?, ?, ?, ?, ?, default, default)";
			// PASO 3 : Obtener los comandos QL -->Preparar la instruccion
			pstm = con.prepareStatement(sql);
			// PASO 4 : Obtener los parametros
			pstm.setString(1,  u.getNombre());
			pstm.setString(2,  u.getApellido());
			pstm.setString(3,  u.getUsuario());
			pstm.setString(4,  u.getClave());
			pstm.setString(5,  u.getFecha());
			
			// PASO 5 : ejecucion de la instruccion
			res = pstm.executeUpdate();   //retorna int
			
		} catch (Exception e) {
			System.out.println(">>>> Error en la instrucción del registro " + e.getMessage());
		} finally {   //para cerrar la conexion por buenas prácticas
			try {
				if(pstm !=null) {
					pstm.close();
				}
				if(con !=null) {
					pstm.close();
				}
			} catch (SQLException e2) {  //importar
				System.out.println(">>>> Error al cerrar la BD" + e2.getMessage());
			}
		}
		
		return res;
	}
	
	
	// ACTUALIZAR - UPDATE
	public int actualizarUsuario(Usuario u) {
		// Declaracion de Variables
		int res = 0 ; 
		Connection con = null; //si cambia d evalor, indica que la conexion fue exitosa,importar connection
		PreparedStatement pstm = null; //importar . defino el objeto pstm, permite ejecutar los comandos SQL
		try {
			// PASO 1 :  Establecer la conexion a la BD, instancias de getConnection
			con = MySQLConexion8.getConexion();
			/* PASO 2 : Actualizar ->Definir la instruccion SQL update tb_usuarios set nombre = "Carmen", 
					   																   apellido = "Acoy", 
                       															       usuario = "U006", 
                       																   clave = "12345", 
					   																   fnacim ="2022-12-19" 
																					where codigo = 12;*/
			//			
			String sql = "update tb_usuarios set nombre = ?, apellido = ?, usuario = ? , clave = ? , fnacim = ? where codigo = ?";
			// PASO 3 : Obtener los comandos QL -->Preparar la instruccion
			pstm = con.prepareStatement(sql);
			// PASO 4 : Obtener los parametros
			pstm.setString(1,  u.getNombre());
			pstm.setString(2,  u.getApellido());
			pstm.setString(3,  u.getUsuario());
			pstm.setString(4,  u.getClave());
			pstm.setString(5,  u.getFecha());
			pstm.setInt(6,  u.getCodigo());
			
			// PASO 5 : ejecucion de la instruccion
			res = pstm.executeUpdate();   //retorna int
			
		} catch (Exception e) {
			System.out.println(">>>> Error en la instrucción de actualizar " + e.getMessage());
		} finally {   //para cerrar la conexion por buenas prácticas
			try {
				if(pstm !=null) {
					pstm.close();
				}
				if(con !=null) {
					pstm.close();
				}
			} catch (SQLException e2) {  //importar
				System.out.println(">>>> Error al cerrar la BD" + e2.getMessage());
			}
		}
		
		return res; //si cambia a 1, la conexion fue exitosa / 2 , retorna nothing
	}
	
	
}
