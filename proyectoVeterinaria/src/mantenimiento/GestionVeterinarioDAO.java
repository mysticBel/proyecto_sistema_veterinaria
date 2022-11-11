package mantenimiento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entidad.Cliente;
import entidad.Veterinario;
import interfaces.VeterinarioInterfaceDAO;
import utils.MySQLConexion8;

public class GestionVeterinarioDAO implements VeterinarioInterfaceDAO{

	@Override
	public int registrarVeterinario(Veterinario v) {
		int res = 0;
		Connection con = null; //si cambia d evalor, indica que la conexion fue exitosa,importar connection
		PreparedStatement pstm = null; 
		try {
			// PASO 1 :  Establecer la conexion a la BD, instancias de getConnection
			con = MySQLConexion8.getConexion();
			// PASO 2 : Registro ->Definir la instruccion SQL 
			//			insert into cliente values ('CLI04','44444444','Pablito','Backyardigans','666666666','narnia','DIS03'); 
			String sql = "insert into veterinario values (null, ?, ?, ?,?)";
			// PASO 3 : Obtener los comandos QL -->Preparar la instruccion
			pstm = con.prepareStatement(sql);
			// PASO 4 : Obtener los parametros
			//pstm.setInt(1,  v.getId_vet());
			pstm.setString(1,  v.getDni_vet());
			pstm.setString(2,  v.getNom_vet());
			pstm.setString(3,  v.getApe_vet());
			pstm.setString(4,  v.getTel_vet());
			
			// PASO 5 : ejecucion de la instruccion
			res = pstm.executeUpdate();   //retorna int
			
		} catch (Exception e) {
			System.out.println(">>>> Error en la instrucción del registro " + e.getMessage());
		} finally {   //para cerrar la conexion por buenas practicas
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
	public int actualizarVeterinario(Veterinario v) {
		// Declaracion de Variables
		int res = 0 ; 
		Connection con = null; //si cambia d evalor, indica que la conexion fue exitosa,importar connection
		PreparedStatement pstm = null; //importar . defino el objeto pstm, permite ejecutar los comandos SQL
		try {
			// PASO 1 :  Establecer la conexion a la BD, instancias de getConnection
			con = MySQLConexion8.getConexion();
			// PASO 2 : Actualizar ->Definir la instruccion SQL update cliente set dni_cliente = "45658975", nom_cliente = 'Pablo', ape_cliente = "uwuwuwu", tel_cliente = "901522871", direccion ="la mejor casa", id_distrito = 'DIS02' where id_cliente = 'CLI04';			
			String sql = "update veterinario set dni_vet = ?, nom_vet = ?, ape_vet = ? , tel_vet = ?  where id_vet = ?";
			// PASO 3 : Obtener los comandos QL -->Preparar la instruccion
			pstm = con.prepareStatement(sql);
			// PASO 4 : Obtener los parametros
			pstm.setString(1,  v.getDni_vet());
			pstm.setString(2,  v.getNom_vet());
			pstm.setString(3,  v.getApe_vet());
			pstm.setString(4,  v.getTel_vet());
			pstm.setInt(5,  v.getId_vet());
			
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
	public int eliminarVeterinario(int codigo) {
		int res = 0;
		Connection con = null;
		PreparedStatement pstm = null;
		try {
			//paso 1: conectarse a la Bd ciberfarma
			con = MySQLConexion8.getConexion();
			//paso 2: Establecer la instruccion SQL--> ELIMINAR --> delete from cliente	where id_cliente = 'CLI04';	
			String sql = "delete from veterinario where id_vet =?";
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
	public Veterinario buscarVeterinario(int codigo) {
		Veterinario vet = null;
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet res = null;
		try {
			//establecer conexion
			con = MySQLConexion8.getConexion();
			//paso 2: Establecer la instruccion SQL--> CONSULTA
			String sql = "select * from veterinario where id_vet =?";
			//paso 3: Enviar la instruccion al objeto pstm
			pstm = con.prepareStatement(sql);
			//paso 4: obtener parÃ¡metros
			pstm.setInt(1, codigo);
			//paso 5: ejecutar la instrucciÃ³n
			res = pstm.executeQuery();
			//
			if(res.next()) {
				vet = new Veterinario(res.getInt(1),
								   res.getString(2),
								   res.getString(3),
								   res.getString(4),
								   res.getString(5));

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
		return vet;
	}

	@Override
	public ArrayList<Veterinario> listarVeterinario() {
	
		ArrayList<Veterinario> listaVeterinario=new ArrayList<Veterinario>();
		//objeto de tipo conexion para conectarme, si con es diferente de null entonces si se establecio conexion, si es null es error
		Connection con=null;
		//Para poder preparar la instrucción es decir obtener los comandos sql insert,etc
		PreparedStatement pstm=null;
		//objeto resultSet, almacena resultado de mi consulta, cada vez q hacemos consulta se trabaja con ResultSet				
		ResultSet res=null;
		//Creamos variable user, que almacenara usuario y manda al contenedor arralist q almacena usuarios
		Veterinario ver=null;
		//Try catch en caso hubiese error , de instruccion incorrecto, error en comando, tabla incorrecta
		try {
			//Paso 1:Establecer la conexion de la BD, donde ya esta creado en utils MySQLConexion 8 con el metodo getConexion
			con = MySQLConexion8.getConexion();
			//Paso 2:Definir la instrucción SQL-CONSULTA en este caso CONSULTAR
			//aca lee la instruccion como cadena o solo texto
			String sql ="SELECT * FROM veterinario";
			//Paso 3: preparar la instrucción --> obtener los comandos SQL,AQUI YA Lo que esta arriba en text se reconocera como comando en MySQL
			pstm = con.prepareStatement(sql);
			//Paso 4- obtener parametros- NO HAY PARAMETRO
			//paso 5: ejecutar la instruccion
			//res  aca con consulta se trabajara execute.Query, res tiene la informacion obtenida por el select de arriba
			res=pstm.executeQuery();
			//Paso 6 pasar informacion obtenido del select a la tabla de mi GUI
			while(res.next()) {

				ver=new Veterinario();
						//Setear--> asignar los valores obtenido del objeto "res" a los atributos privados
				//asignamos valor y con getInt 1 es decir en la primeraa columna se encuentra codigo q es de tipo Int por eso getInt
				ver.setId_vet(res.getInt(1));
				ver.setDni_vet(res.getString(2));
				ver.setNom_vet(res.getString(3));
				ver.setApe_vet(res.getString(4));
				ver.setTel_vet(res.getString(5));
				//Enviar a arraylist una vez q user tenga la informacion
				//añadir el objeto a la lista
				listaVeterinario.add(ver);
			}
			
		}
		catch(Exception e){
			System.out.println("Error en la instrucción SQL-Lista de veterinario"+e.getMessage());
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
		return listaVeterinario;
	}

}
