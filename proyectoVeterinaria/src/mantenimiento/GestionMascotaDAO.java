package mantenimiento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entidad.Cliente;
import entidad.Mascota;
import interfaces.MascotaInterfaceDAO;
import utils.MySQLConexion8;

public class GestionMascotaDAO implements MascotaInterfaceDAO {

	@Override
	public int registrarMascota(Mascota m) {
		int res = 0;
		Connection con = null; //si cambia de valor, indica que la conexion fue exitosa,importar connection
		PreparedStatement pstm = null; 
		try {
			// PASO 1 :  Establecer la conexion a la BD, instancias de getConnection
			con = MySQLConexion8.getConexion();
			// PASO 2 : Registro ->Definir la instruccion SQL 
			//			insert into mascota values ('PET05','Fu','Gato','2015-04-04','CLI01'); 
			String sql = "insert into mascota values (null, ?, ?, ?, ?)";
			// PASO 3 : Obtener los comandos QL -->Preparar la instruccion
			pstm = con.prepareStatement(sql);
			// PASO 4 : Obtener los parametros
			//pstm.setInt(1,  m.getId_mascota());
			pstm.setString(1,  m.getNom_mascota());
			pstm.setString(2,  m.getTipo_mascota());
			pstm.setString(3,  m.getFec_nac_mascota());
			pstm.setInt(4,  m.getId_cliente());

			
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
	public int actualizarMascota(Mascota m) {
		// Declaracion de Variables
		int res = 0 ; 
		Connection con = null; //si cambia de valor, indica que la conexion fue exitosa,importar connection
		PreparedStatement pstm = null; //importar . defino el objeto pstm, permite ejecutar los comandos SQL
		try {
			// PASO 1 :  Establecer la conexion a la BD, instancias de getConnection
			con = MySQLConexion8.getConexion();
			// PASO 2 : Actualizar ->Definir la instruccion SQL update mascota set nom_mascota ='Fufu',tipo_mascota='Gatita',fec_nac_mascota='2015-04-04',id_cliente ='CLI01' where id_mascota ='PET05';			
			String sql = "update mascota set nom_mascota =?,tipo_mascota=?,fec_nac_mascota=?,id_cliente =? where id_mascota =?";
			// PASO 3 : Obtener los comandos QL -->Preparar la instruccion
			pstm = con.prepareStatement(sql);
			// PASO 4 : Obtener los parametros
			pstm.setString(1,  m.getNom_mascota());
			pstm.setString(2,  m.getTipo_mascota());
			pstm.setString(3,  m.getFec_nac_mascota());
			pstm.setInt(4,  m.getId_cliente());
			pstm.setInt(5,  m.getId_mascota());

			
			// PASO 5 : ejecucion de la instruccion
			res = pstm.executeUpdate();   //retorna int
			
		} catch (Exception e) {
			System.out.println(">>>> Error en la instrucciï¿½n de actualizar " + e.getMessage());
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
	public int eliminarMascota(int codigo) {
		int res = 0;
		Connection con = null;
		PreparedStatement pstm = null;
		try {
			//paso 1: conectarse a la Bd ciberfarma
			con = MySQLConexion8.getConexion();
			//paso 2: Establecer la instruccion SQL--> ELIMINAR --> delete from cliente	where id_cliente = 'PET06';	
			String sql = "delete from mascota where id_mascota =?";
			//paso 3: Enviar la instruccion al objeto pstm
			pstm = con.prepareStatement(sql);
			//paso 4: obtener parÃ¡metro
			pstm.setInt(1, codigo);
			//paso 5: ejecutar la instrucciÃ³n
			res = pstm.executeUpdate();
			
		} catch (Exception e) {
			System.out.println("Error en la instruccion SQL - Eliminar"+e.getMessage());
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
	public Mascota buscarMascota(int codigo) {
		Mascota mas = null;
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet res = null;
		try {
			//establecer conexion
			con = MySQLConexion8.getConexion();
			//paso 2: Establecer la instruccion SQL--> CONSULTA
			String sql = "select * from mascota where id_mascota =?";
			//paso 3: Enviar la instruccion al objeto pstm
			pstm = con.prepareStatement(sql);
			//paso 4: obtener parÃ¡metros
			pstm.setInt(1, codigo);
			//paso 5: ejecutar la instrucciÃ³n
			res = pstm.executeQuery();
			//
			if(res.next()) {
				mas = new Mascota(res.getInt(1),
								  res.getString(2),
								  res.getString(3),
								  res.getString(4),
								  res.getInt(5));

			}
						
		} catch (Exception e) {
			System.out.println("Error en la instrucción SQL - Consultar Mascota"+e.getMessage());
		}finally {
			try {
				if(pstm != null)pstm.close();
				if(res != null)res.close();
				if(con != null)con.close();
				
			} catch (SQLException e2) {
				System.out.println("Error al cerrar la BD"+e2.getMessage());
			}
		}
		return mas;
	}

	@Override
	public ArrayList<Mascota> listarMascota() {
		//Variable de tipo ArrayList usuario
		//Un arralist declarado es inicializado por default como null,almacenara lista de usuarios
		//new ArrayList<Usuario>=significa igual a null, este sera contenedor de usuario
		ArrayList<Mascota> listaMasc=new ArrayList<Mascota>();
		//objeto de tipo conexion para conectarme, si con es diferente de null entonces si se establecio conexion, si es null es error
		Connection con=null;
		//Para poder preparar la instrucción es decir obtener los comandos sql insert,etc
		PreparedStatement pstm=null;
		//objeto resultSet, almacena resultado de mi consulta, cada vez q hacemos consulta se trabaja con ResultSet				
		ResultSet res=null;
		//Creamos variable user, que almacenara usuario y manda al contenedor arralist q almacena usuarios
		Mascota mas=null;
		//Try catch en caso hubiese error , de instruccion incorrecto, error en comando, tabla incorrecta
		try {
			//Paso 1:Establecer la conexion de la BD, donde ya esta creado en utils MySQLConexion 8 con el metodo getConexion
			con = MySQLConexion8.getConexion();
			//Paso 2:Definir la instrucción SQL-CONSULTA en este caso CONSULTAR
			//aca lee la instruccion como cadena o solo texto
			String sql ="SELECT * FROM mascota";
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
				mas=new Mascota();
						//Setear--> asignar los valores obtenido del objeto "res" a los atributos privados
				//asignamos valor y con getInt 1 es decir en la primeraa columna se encuentra codigo q es de tipo Int por eso getInt
				mas.setId_mascota(res.getInt(1));
				mas.setNom_mascota(res.getString(2));
				mas.setTipo_mascota(res.getString(3));
				mas.setFec_nac_Mascota(res.getString(4));
				mas.setId_cliente(res.getInt(5));
				//Enviar a arraylist una vez q user tenga la informacion
				//añadir el objeto a la lista
				listaMasc.add(mas);
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
		return listaMasc;
	}
	
	

}
