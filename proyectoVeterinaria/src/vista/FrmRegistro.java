package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import com.toedter.calendar.JDateChooser;

import entidad.Usuario;
import mantenimiento.GestionUsuarioDAO;
import utils.Validaciones;

import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;

public class FrmRegistro extends JInternalFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtUsuario;
	private JPasswordField txtClave;
	private JDateChooser txtFecha;
	
	//instanciamos
	GestionUsuarioDAO gUser = new GestionUsuarioDAO();
	
	private JButton btnNuevo;
	private JTextField txtCodigo;
	private JButton btnActualizar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmRegistro frame = new FrmRegistro();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FrmRegistro() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblRegistroDeUsuario = new JLabel("Registro de Usuario");
		lblRegistroDeUsuario.setBounds(28, 11, 224, 32);
		contentPane.add(lblRegistroDeUsuario);
		
		JLabel lblCdigo = new JLabel("C\u00F3digo:");
		lblCdigo.setBounds(28, 65, 46, 14);
		contentPane.add(lblCdigo);
		
		JLabel lblAutogenerado = new JLabel("Autogenerado");
		lblAutogenerado.setBounds(189, 65, 92, 14);
		contentPane.add(lblAutogenerado);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(28, 94, 74, 14);
		contentPane.add(lblNombre);
		
		JLabel lblApellido = new JLabel("Apellido:");
		lblApellido.setBounds(28, 121, 74, 14);
		contentPane.add(lblApellido);
		
		JLabel lblUsuario = new JLabel("Usuario:");
		lblUsuario.setBounds(28, 146, 74, 14);
		contentPane.add(lblUsuario);
		
		JLabel lblClave = new JLabel("Clave:");
		lblClave.setBounds(28, 176, 74, 14);
		contentPane.add(lblClave);
		
		JLabel lblFecha = new JLabel("Fecha:");
		lblFecha.setBounds(28, 206, 74, 14);
		contentPane.add(lblFecha);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(112, 90, 130, 20);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);
		
		txtApellido = new JTextField();
		txtApellido.setColumns(10);
		txtApellido.setBounds(112, 118, 130, 20);
		contentPane.add(txtApellido);
		
		txtUsuario = new JTextField();
		txtUsuario.setColumns(10);
		txtUsuario.setBounds(111, 143, 68, 20);
		contentPane.add(txtUsuario);
		
		txtClave = new JPasswordField();
		txtClave.setBounds(112, 173, 71, 20);
		contentPane.add(txtClave);
		
		JButton btnRegistrar = new JButton("Registrar");
		btnRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				registrarDatos();
			}
		});
		btnRegistrar.setBounds(288, 78, 103, 23);
		contentPane.add(btnRegistrar);
		
		txtFecha = new JDateChooser();
		txtFecha.setDateFormatString("dd-MM-yyyy");
		txtFecha.setBounds(112, 204, 95, 20);
		contentPane.add(txtFecha);
		
		btnNuevo = new JButton("Nuevo Usuario");
		btnNuevo.addActionListener(this);
		btnNuevo.setBounds(288, 117, 103, 23);
		contentPane.add(btnNuevo);
		
		btnActualizar = new JButton("Actualizar");
		btnActualizar.addActionListener(this);
		btnActualizar.setBounds(288, 151, 103, 23);
		contentPane.add(btnActualizar);
		
		txtCodigo = new JTextField();
		txtCodigo.setColumns(10);
		txtCodigo.setBounds(111, 62, 68, 20);
		contentPane.add(txtCodigo);
	}
	
	void registrarDatos(){
		// VARIABLES		
		String nomb, ape, user, clave, fecha;
		// ENTRADAS
		nomb = getNombre();
		ape =  getApellido();
		user = getUsuario();
		clave = getClave();
		fecha = getFecha();
		
		// VALIDAR
		if(nomb == null || ape == null || user == null || clave == null || fecha== null) {
			return; // no se ejecuta
		} else {
			//Paso 1 : Crear un objeto de la clase Usuario - instanciamos de la clase Usuario
			Usuario u = new Usuario();
			//Paso 2: setear --> asignar los valores obtenidos desde la GUI a los atributos privados
			u.setNombre(nomb);
			u.setApellido(ape);
			u.setUsuario(user);
			u.setClave(clave);
			u.setFecha(fecha);
			//Paso 3 : Llamar al proceso de registro - gestionUsuarioDAO, lo hemos instanciado en el constructor
			int res = gUser.registrarUsuario(u);
			//Validar el resultado del proceso de registro
			if(res == 0) {
				mensajeError(":( Hubo un error en el registro");
			}else {
				mensajeExitoso("Usuario registrado con éxito !");
			}
						
		}
		
		
		// PROCESOS
		// SALIDAS
	}

	private void mensajeExitoso(String msj) {
		JOptionPane.showMessageDialog(this, msj, "Sistema", 1);
	}

	private String getFecha() {
		//Completar
		String fecha = null;
		// Se debe definir el formato de la fecha
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); //formato que coincide con  la bd, por defecto, siempre usado en bd
		fecha = sdf.format(txtFecha.getDate());	
		return fecha;
	}

	private String getClave() {
		//completar
		String pass = null;
		pass = encriptado(String.valueOf(txtClave.getPassword()));
		return pass;
	}
	
	// agregando metodo encriptado para clave
	private String encriptado(String clave) {
		StringBuilder encriptado = new StringBuilder();
		//Agregar el texto a la variable
		encriptado.append(clave);
		//Reemplazar las vocales
		for (int i = 0; i < encriptado.length(); i++) {
			switch (encriptado.charAt(i)){ 
			case 'a':
				encriptado.setCharAt(i, 'e');
				break;
			case 'e':
				encriptado.setCharAt(i, 'i');
				break;
			case 'i':
				encriptado.setCharAt(i, 'o');
				break;
			case 'o':
				encriptado.setCharAt(i, 'u');
				break;
			case 'u':
				encriptado.setCharAt(i, 'a');
				break;			
			}
		}

		return encriptado.reverse().toString(); 

	}

	private String getUsuario() {
		String user = null;
		if(txtUsuario.getText().trim().length() == 0) {
			mensajeError("Ingresar el codigo de Usuario");
			txtUsuario.requestFocus();
		}else if (txtUsuario.getText().trim().matches(Validaciones.USUARIO)){
			user = txtUsuario.getText().trim();
		}else {
			mensajeError("Formato incorrecto. Ejem U003");
			txtUsuario.setText("");
			txtUsuario.requestFocus();
		}
		return user;
	}

	private String getApellido() {
		String ape = null;
		if(txtApellido.getText().trim().length() == 0) {
			mensajeError("Ingresar el apellido");
			txtApellido.requestFocus();
		}else if (txtApellido.getText().trim().matches(Validaciones.APELLIDO_USUARIO)){
			ape = txtApellido.getText().trim();
		}else {
			mensajeError("Formato incorrecto, ingresar de 4 a 35 letras");
			txtApellido.setText("");
			txtApellido.requestFocus();
		}
		return ape;

	}

	private String getNombre() {
		String nomb = null;
		if(txtNombre.getText().trim().length() == 0) {
			mensajeError("Ingresar el nombre");
			txtNombre.requestFocus();
		}else if (txtNombre.getText().trim().matches(Validaciones.NOM_USUARIO)){
			nomb = txtNombre.getText().trim();
		}else {
			mensajeError("Formato incorrecto, ingresar de 4 a 20 letras");
			txtNombre.setText("");
			txtNombre.requestFocus();
		}
		return nomb;
	}

	private void mensajeError(String msj) {
		JOptionPane.showMessageDialog(this, msj, "Error ! !", 0);
		
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnActualizar) {
			actionPerformedBtnActualizar(e);
		}
		if (e.getSource() == btnNuevo) {
			actionPerformedBtnNuevo(e);
		}
	}
	protected void actionPerformedBtnNuevo(ActionEvent e) {
		nuevoUsuario();
	}

	private void nuevoUsuario() {
		txtNombre.setText("");
		txtApellido.setText("");
		txtUsuario.setText("");
		txtClave.setText("");
		txtFecha.setDate(null);
		txtNombre.requestFocus();
		
	}
	protected void actionPerformedBtnActualizar(ActionEvent e) {
		actualizarUsuario();
	}

	private void actualizarUsuario() {
		String nomb, ape, user, clave, fecha;
		int codigo;
		// ENTRADAS
		nomb = getNombre();
		ape =  getApellido();
		user = getUsuario();
		clave = getClave();
		fecha = getFecha();
		codigo = getCodigo();
		
		// VALIDAR
		if(nomb == null || ape == null || user == null || clave == null || fecha== null || codigo == -1) {
			return; // no se ejecuta
		} else {
			//Paso 1 : Crear un objeto de la clase Usuario - instanciamos de la clase Usuario
			Usuario u = new Usuario();
			//Paso 2: setear --> asignar los valores obtenidos desde la GUI a los atributos privados
			u.setNombre(nomb);
			u.setApellido(ape);
			u.setUsuario(user);
			u.setClave(clave);
			u.setFecha(fecha);
			u.setCodigo(codigo);
			
			//Paso 3 : Llamar al proceso de ACTUALIZAR - gestionUsuarioDAO, lo hemos instanciado en el constructor
			int res = gUser.actualizarUsuario(u);
			//Validar el resultado del proceso de actualizar
			if(res == 0) {
				mensajeError(":( Hubo un error en la actualización");
			}else {
				mensajeExitoso("Usuario ACTUALIZADO");
			}
						
		}
		
		
	}

	private int getCodigo() {
		
		int cod= -1;  //completar la validacion		
		cod = Integer.parseInt(txtCodigo.getText());
		return cod;
	}
}
