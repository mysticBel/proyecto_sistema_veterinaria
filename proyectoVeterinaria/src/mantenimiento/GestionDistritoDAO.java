package mantenimiento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entidad.Distrito;
import interfaces.DistritoInterfacesDAO;
import utils.MySQLConexion8;

public class GestionDistritoDAO implements DistritoInterfacesDAO {

	@Override
	public ArrayList<Distrito> listarDistrito() {
		//Variable de tipo ArrayList usuario
		//Un arralist declarado es inicializado por default como null,almacenara lista de usuarios
		//new ArrayList<Usuario>=significa igual a null, este sera contenedor de usuario
		ArrayList<Distrito> lista=new ArrayList<Distrito>();
		//objeto de tipo conexion para conectarme, si con es diferente de null entonces si se establecio conexion, si es null es error
		Connection con=null;
		//Para poder preparar la instrucción es decir obtener los comandos sql insert,etc
		PreparedStatement pstm=null;
		//objeto resultSet, almacena resultado de mi consulta, cada vez q hacemos consulta se trabaja con ResultSet				
		ResultSet res=null;
		//Creamos variable Tipuser, que almacenara tipos y manda al contenedor arraylist q almacena los tipos de usuarios
		Distrito tipDist=null;
		try {
			//Paso 1:Establecer la conexion de la BD, donde ya esta creado en utils MySQLConexion 8 con el metodo getConexion
			con = MySQLConexion8.getConexion();
			//Paso 2:Definir la instrucción SQL-CONSULTA en este caso CONSULTAR
			//aca lee la instruccion como cadena o solo texto
			String sql ="SELECT * FROM distrito";
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
				tipDist=new Distrito();
						//Setear--> asignar los valores obtenido del objeto "res" a los atributos privados
				//asignamos valor y con getInt 1 es decir en la primeraa columna se encuentra idTipo q es de tipo Int por eso getInt
				tipDist.setId_distrito(res.getInt(1));
				tipDist.setNom_distrito(res.getString(2));
				//Enviar a arraylist una vez q user tenga la informacion
				//añadir el objeto a la lista
				lista.add(tipDist);
			}
			
			
		} catch (Exception e) {
			//Error en linea de codigo
			System.out.println("Error en la instrucción SQL-LlenarCombobox"+e.getMessage());
		}//Bloque finally que siempre se ejecutará
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
			return lista;
	}
	

}
