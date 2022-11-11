package utils;

public class Validaciones {
	public static final String COD_PRODUCTO ="[pP]\\d{4}";
	public static final String NOM_PRODUCTO ="[a-zA-Z\\s]{3,20}";
	public static final String NOM_USUARIO ="[a-zA-Z\\s]{4,20}";
	public static final String APELLIDO_USUARIO ="[a-zA-Z\\s]{4,35}";
	public static final String USUARIO ="U[0-9]{3}";  
	
	//VALIDACIONES CLIENTE
	public static final String COD_CLIENTE ="[Cc][Ll]\\d{3}"; //cl001 o CL001
	public static final String DNI_CLIENTE ="\\d{8}";         //8 digitos del 0 al 9
	public static final String  NOMBRE_CLIENTE="[a-zA-Z\\\\s]{3,15}";  
	public static final String APELLIDO_CLIENTE ="[a-zA-Z\\\\s]{3,30}";
	public static final String TELEF_CLIENTE ="[0][1]-\\d{3}\\s\\d{5}";
	public static final String CORREO_CLIENTE ="[\\w] + [0-9]@[\\w]+\\.[a-z]{3}\\.[a-z][2]"; //jl12_5@cibertec.edu.pe
	
	// [\\w] --> [a-zA-Z_0-9]
 }
