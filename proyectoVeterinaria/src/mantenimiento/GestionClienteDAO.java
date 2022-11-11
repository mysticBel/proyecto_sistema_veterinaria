package mantenimiento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entidad.Cliente;
import interfaces.ClienteInterfaceDAO;
import utils.MySQLConexion8;

public class GestionClienteDAO implements ClienteInterfaceDAO {

	@Override
	public int registrarCliente(Cliente c) {
		int res = 0;
		Connection con = null; //si cambia d evalor, indica que la conexion fue exitosa,importar connection
		PreparedStatement pstm = null; 
		try {
			// PASO 1 :  Establecer la conexion a la BD, instancias de getConnection
			con = MySQLConexion8.getConexion();
			// PASO 2 : Registro ->Definir la instruccion SQL 
			//			insert into cliente values ('CLI04','44444444','Pablito','Backyardigans','666666666','narnia','DIS03'); 
			String sql = "insert into cliente values (null, ?, ?, ?, ?, ?, ?)";
			// PASO 3 : Obtener los comandos QL -->Preparar la instruccion
			pstm = con.prepareStatement(sql);
			// PASO 4 : Obtener los parametros
			//pstm.setInt(1,  c.getId_cliente());
			pstm.setString(1,  c.getDni_cliente());
			pstm.setString(2,  c.getNom_cliente());
			pstm.setString(3,  c.getApe_cliente());
			pstm.setString(4,  c.getTel_cliente());
			pstm.setString(5,  c.getDir_cliente());
			pstm.setInt(6,  c.getId_distrito());
			
			// PASO 5 : ejecucion de la instruccion
			res = pstm.executeUpdate();   //retorna int
			
		} catch (Exception e) {
			System.out.println(">>>> Error en la instrucción del registro " + e.getMessage());
		} finally {   //para cerrar la conexion por buenas prï¿½cticas
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

	@Override
	public int actualizarCliente(Cliente c) {
		// Declaracion de Variables
				int res = 0 ; 
				Connection con = null; //si cambia d evalor, indica que la conexion fue exitosa,importar connection
				PreparedStatement pstm = null; //importar . defino el objeto pstm, permite ejecutar los comandos SQL
				try {
					// PASO 1 :  Establecer la conexion a la BD, instancias de getConnection
					con = MySQLConexion8.getConexion();
					// PASO 2 : Actualizar ->Definir la instruccion SQL update cliente set dni_cliente = "45658975", nom_cliente = 'Pablo', ape_cliente = "uwuwuwu", tel_cliente = "901522871", direccion ="la mejor casa", id_distrito = 'DIS02' where id_cliente = 'CLI04';			
					String sql = "update cliente set dni_cliente = ?, nom_cliente = ?, ape_cliente = ? , tel_cliente = ? , direccion = ? , id_distrito = ? where id_cliente = ?";
					// PASO 3 : Obtener los comandos QL -->Preparar la instruccion
					pstm = con.prepareStatement(sql);
					// PASO 4 : Obtener los parametros
					pstm.setString(1,  c.getDni_cliente());
					pstm.setString(2,  c.getNom_cliente());
					pstm.setString(3,  c.getApe_cliente());
					pstm.setString(4,  c.getTel_cliente());
					pstm.setString(5,  c.getDir_cliente());
					pstm.setInt(6,  c.getId_distrito());
					pstm.setInt(7,  c.getId_cliente());
					
					// PASO 5 : ejecucion de la instruccion
					res = pstm.executeUpdate();   //retorna int
					
				} catch (Exception e) {
					System.out.println(">>>> Error en la instrucción de actualizar " + e.getMessage());
				} finally {   //para cerrar la conexion por buenas prï¿½cticas
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

	@Override
	public int eliminarCliente(int codigo) {
		int res = 0;
		Connection con = null;
		PreparedStatement pstm = null;
		try {
			//paso 1: conectarse a la Bd ciberfarma
			con = MySQLConexion8.getConexion();
			//paso 2: Establecer la instruccion SQL--> ELIMINAR --> delete from cliente	where id_cliente = 'CLI04';	
			String sql = "delete from cliente where id_cliente =?";
			//paso 3: Enviar la instruccion al objeto pstm
			pstm = con.prepareStatement(sql);
			//paso 4: obtener parÃ¡metro
			pstm.setInt(1, codigo);
			//paso 5: ejecutar la instrucciÃ³n
			res = pstm.executeUpdate();
			
		} catch (Exception e) {
			System.out.println("Error en la instaruccion SQL - Eliminar"+e.getMessage());
		}finally {
			try {
				if(pstm != null)pstm.close();
				if(con != null)con.close();
				
			} catch (SQLException e2) {
				System.out.println("Error al cerrar la BD" + e2.getMessage());
			}
		}
		return res;
	}

	@Override
	public Cliente buscarCliente(int codigo) {
		Cliente cli = null;
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet res = null;
		try {
			//establecer conexion
			con = MySQLConexion8.getConexion();
			//paso 2: Establecer la instruccion SQL--> CONSULTA
			String sql = "select * from cliente where id_cliente =?";
			//paso 3: Enviar la instruccion al objeto pstm
			pstm = con.prepareStatement(sql);
			//paso 4: obtener parÃ¡metros
			pstm.setInt(1, codigo);
			//paso 5: ejecutar la instrucción
			res = pstm.executeQuery();
			//
			if(res.next()) {
				cli = new Cliente(res.getInt(1),
								   res.getString(2),
								   res.getString(3),
								   res.getString(4),
								   res.getString(5),
								   res.getString(6),
								   res.getInt(7));

			}
						
		} catch (Exception e) {
			System.out.println("Error en la instrucción SQL - Consultar Usuario"+e.getMessage());
		}finally {
			try {
				if(pstm != null)pstm.close();
				if(res != null)res.close();
				if(con != null)con.close();
				
			} catch (SQLException e2) {
				System.out.println("Error al cerrar la BD"+e2.getMessage());
			}
		}
		return cli;
	}

	@Override
	public ArrayList<Cliente> listarCliente() {
		//Variable de tipo ArrayList usuario
				//Un arralist declarado es inicializado por default como null,almacenara lista de usuarios
				//new ArrayList<Usuario>=significa igual a null, este sera contenedor de usuario
				ArrayList<Cliente> listaCliente=new ArrayList<Cliente>();
				//objeto de tipo conexion para conectarme, si con es diferente de null entonces si se establecio conexion, si es null es error
				Connection con=null;
				//Para poder preparar la instrucción es decir obtener los comandos sql insert,etc
				PreparedStatement pstm=null;
				//objeto resultSet, almacena resultado de mi consulta, cada vez q hacemos consulta se trabaja con ResultSet				
				ResultSet res=null;
				//Creamos variable user, que almacenara usuario y manda al contenedor arralist q almacena usuarios
				Cliente clie=null;
				//Try catch en caso hubiese error , de instruccion incorrecto, error en comando, tabla incorrecta
				try {
					//Paso 1:Establecer la conexion de la BD, donde ya esta creado en utils MySQLConexion 8 con el metodo getConexion
					con = MySQLConexion8.getConexion();
					//Paso 2:Definir la instrucción SQL-CONSULTA en este caso CONSULTAR
					//aca lee la instruccion como cadena o solo texto
					String sql ="SELECT * FROM cliente";
					//Paso 3: preparar la instrucción --> obtener los comandos SQL,AQUI YA Lo que esta arriba en text se reconocera como comando en MySQL
					pstm = con.prepareStatement(sql);
					//Paso 4- obtener parametros- NO HAY PARAMETRO
					//paso 5: ejecutar la instruccion
					//res  aca con consulta se trabajara execute.Query, res tiene la informacion obtenida por el select de arriba
					res=pstm.executeQuery();
					//Paso 6 pasar informacion obtenido del select a la tabla de mi GUI
					//con bucle metodo next ---> para realizar el recorrido al objeto res
					//next da true solo si puede avanzar a la derecha de columna en columna
					while(res.next()) {
						//constructor con todos los campos , res.getInt o getString y 1 y 2 son las columnas
						//columna 1 es codigo, columna 2 es nombre y asi sucesivamente---- getInt 7 y getInt 8 son tip y estado
						//creamos objeto de tipo Usuario
						clie=new Cliente();
								//Setear--> asignar los valores obtenido del objeto "res" a los atributos privados
						//asignamos valor y con getInt 1 es decir en la primeraa columna se encuentra codigo q es de tipo Int por eso getInt
						clie.setId_cliente(res.getInt(1));
						clie.setDni_cliente(res.getString(2));
						clie.setNom_cliente(res.getString(3));
						clie.setApe_cliente(res.getString(4));
						clie.setTel_cliente(res.getString(5));
						clie.setDir_cliente(res.getString(6));
						clie.setId_distrito(res.getInt(7));
						//Enviar a arraylist una vez q user tenga la informacion
						//añadir el objeto a la lista
						listaCliente.add(clie);
					}
					
				}
				catch(Exception e){
					System.out.println("Error en la instrucción SQL-Lista de Cliente"+e.getMessage());
				}
				//Bloque finally que siempre se ejecutará
				finally{
					try {
						//aca cerramos conexion
						if(pstm!=null) pstm.close();
						//objeto res de tipo ResulSet cuando vamos a consultar
						if(res!=null)res.close();
						if(con !=null)con.close(); 
						
					}catch(SQLException e2){
						System.out.println("Error al cerrar la BD" + e2.getMessage());
					}
				}
				return listaCliente;
	}
	

}
