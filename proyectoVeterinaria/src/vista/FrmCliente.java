package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import com.toedter.calendar.JDateChooser;

import entidad.Cliente;
import entidad.Distrito;
import entidad.Mascota;
import mantenimiento.GestionClienteDAO;
import mantenimiento.GestionDistritoDAO;
import utils.Validaciones;

import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.ImageIcon;

public class FrmCliente extends JInternalFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField txtDni;
	private JTextField txtNombre;
	private JTextField txtApellido;
	
	//instanciamos
	GestionClienteDAO gCli = new GestionClienteDAO();
	//Instanciar Distrito
	GestionDistritoDAO GDist=new GestionDistritoDAO();
	//Instanciar un objeto para el modelamiento o estructura de la tabla
			DefaultTableModel model=new DefaultTableModel();
		
	
	private JButton btnEliminar;
	private JTextField txtCodigo;
	private JButton btnActualizar;
	private JTextField txtDireccion;
	private JLabel lblDistrito;
	private JTextField txtTelefono;
	private JComboBox cboDistrito;
	private JTable tblCliente;
	private JButton btnEncenderCaja;
	private JScrollPane scrollPane;
	private JButton btnNuevo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmCliente frame = new FrmCliente();
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
	public FrmCliente() {
		setTitle("Mantenimiento de Clientes");
		setMaximizable(true);
		setIconifiable(true);
		setClosable(true);
		setBounds(100, 100, 746, 349);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblRegistroDeUsuario = new JLabel("Mantenimiento de Clientes");
		lblRegistroDeUsuario.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblRegistroDeUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		lblRegistroDeUsuario.setBounds(148, 0, 414, 32);
		contentPane.add(lblRegistroDeUsuario);
		
		JLabel lblCodigo = new JLabel("Cod. Cliente:");
		lblCodigo.setBounds(10, 43, 74, 14);
		contentPane.add(lblCodigo);
		
		JLabel lblDni = new JLabel("DNI:");
		lblDni.setBounds(10, 147, 74, 14);
		contentPane.add(lblDni);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(10, 82, 74, 14);
		contentPane.add(lblNombre);
		
		JLabel lblApellido = new JLabel("Apellido:");
		lblApellido.setBounds(10, 118, 74, 14);
		contentPane.add(lblApellido);
		
		JLabel lblTelefono = new JLabel("Tel\u00E9fono:");
		lblTelefono.setBounds(10, 172, 74, 14);
		contentPane.add(lblTelefono);
		
		JLabel lblDireccion = new JLabel("Direcci\u00F3n");
		lblDireccion.setBounds(10, 231, 74, 14);
		contentPane.add(lblDireccion);
		
		txtDni = new JTextField();
		txtDni.setBounds(94, 141, 130, 20);
		contentPane.add(txtDni);
		txtDni.setColumns(10);
		
		txtNombre = new JTextField();
		txtNombre.setColumns(10);
		txtNombre.setBounds(94, 79, 130, 20);
		contentPane.add(txtNombre);
		
		txtApellido = new JTextField();
		txtApellido.setColumns(10);
		txtApellido.setBounds(94, 110, 130, 20);
		contentPane.add(txtApellido);
		
		JButton btnRegistrar = new JButton("Registrar");
		btnRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				registrarDatos();
			}
		});
		btnRegistrar.setBounds(372, 263, 103, 23);
		contentPane.add(btnRegistrar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(this);
		btnEliminar.setBounds(598, 263, 103, 23);
		contentPane.add(btnEliminar);
		
		btnActualizar = new JButton("Actualizar");
		btnActualizar.addActionListener(this);
		btnActualizar.setBounds(485, 263, 103, 23);
		contentPane.add(btnActualizar);
		
		txtCodigo = new JTextField();
		txtCodigo.setColumns(10);
		txtCodigo.setBounds(94, 43, 87, 20);
		contentPane.add(txtCodigo);
		
		txtDireccion = new JTextField();
		txtDireccion.setBounds(94, 228, 153, 20);
		contentPane.add(txtDireccion);
		txtDireccion.setColumns(10);
		
		lblDistrito = new JLabel("Distrito:");
		lblDistrito.setBounds(10, 201, 74, 14);
		contentPane.add(lblDistrito);
		
		txtTelefono = new JTextField();
		txtTelefono.setBounds(94, 169, 130, 20);
		contentPane.add(txtTelefono);
		txtTelefono.setColumns(10);
		
		cboDistrito = new JComboBox();
		cboDistrito.setBounds(94, 197, 153, 22);
		contentPane.add(cboDistrito);
		//Agregando columnas a la tabla
		model.addColumn("Código Cliente");
		model.addColumn("DNI");
		model.addColumn("Nombre");
		model.addColumn("Apellido");
		model.addColumn("Teléfono");
		model.addColumn("Dirección");
		model.addColumn("idDistrito");
		//deshabilitar caja
		txtCodigo.setEnabled(false);
		
		btnEncenderCaja = new JButton("");
		btnEncenderCaja.addActionListener(this);
		btnEncenderCaja.setIcon(new ImageIcon(FrmCliente.class.getResource("/img/Bulb Idea.png")));
		btnEncenderCaja.setBounds(191, 28, 36, 41);
		contentPane.add(btnEncenderCaja);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(270, 43, 427, 189);
		contentPane.add(scrollPane);
		
		tblCliente = new JTable();
		scrollPane.setViewportView(tblCliente);
		tblCliente.setFillsViewportHeight(true);
		//asociar tabla con objeto model
		tblCliente.setModel(model);
		
		btnNuevo = new JButton("Nuevo");
		btnNuevo.setBounds(259, 263, 103, 23);
		contentPane.add(btnNuevo);
		
		//
		cargarDataComboDistrito();
		//
		cargarClienteData();
	}
	
	void registrarDatos(){
		// VARIABLES		
		String  dni, nom, ape, tel, dir,LeerNombredis;
		int dis;
		// ENTRADAS
		//cod = getCodigo();
		dni = getDni();
		nom = getNombre();
		ape =  getApellido();
		tel = getTelefono();
		dir = getDireccion();
		LeerNombredis = getDistrito();
		dis=getDis();
		
		
		// VALIDAR, la caja de combobox con el leerNombreDist
		if( dni == null || nom == null || ape == null || tel== null || dir == null || LeerNombredis==null) {
			return; // no se ejecuta
		} else {
			//Paso 1 : Crear un objeto de la clase Usuario - instanciamos de la clase Usuario
			Cliente c = new Cliente();
			//Paso 2: setear --> asignar los valores obtenidos desde la GUI a los atributos privados
			c.setDni_cliente(dni);
			c.setNom_cliente(nom);
			c.setApe_cliente(ape);
			c.setTel_cliente(tel);
			c.setDir_cliente(dir);
			//esto coge el numero de la GUI y lo manda a BD como numero
			c.setId_distrito(dis);
			
			
			//Paso 3 : Llamar al proceso de registro - gestionUsuarioDAO, lo hemos instanciado en el constructor
			int res = gCli.registrarCliente(c);
			//Validar el resultado del proceso de registro
			if(res == 0) {
				mensajeError(":( Hubo un error en el registro");
			}else {
				mensajeExitoso("Usuario registrado con exito !");
				cargarClienteData();
				txtCodigo.setEnabled(false);
				limpiar();
			}
						
		}

	}
	
//Obtiene del combo el numero
private int getDis() {
	//selecciona número
	return cboDistrito.getSelectedIndex();
	}

//	String enTextoDistrito(int i) {
//	return cboDistrito.getItemAt();	
//	}
	//leerNombreDistrito
	private String getDistrito() {
		if(getDis()==0) {
			mensajeError("Elige una opción válida");
		}else {
			//cogera el item del combo
			return cboDistrito.getSelectedItem().toString();
		}
		return null;
	}

	private String getApellido() {
		
		return txtApellido.getText().trim();
	}

	private String getNombre() {
		
		return txtNombre.getText().trim();

	}
	private String getDireccion() {
		
		return txtDireccion.getText().trim();
	}

	private String getTelefono() {
		
		return txtTelefono.getText().trim();
	}

	private String getDni() {
		
		return txtDni.getText().trim();
	}

	private void mensajeExitoso(String msj) {
		JOptionPane.showMessageDialog(this, msj, "Sistema", 1);
	}

	private int getCodigo() {		
		int cod= -1;  //completar la validacion		
		cod = Integer.parseInt(txtCodigo.getText().trim());
		return cod;
	}

	private void mensajeError(String msj) {
		JOptionPane.showMessageDialog(this, msj, "Error ! !", 0);
		
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnEncenderCaja) {
			actionPerformedBtnEncenderCaja(e);
		}
		if (e.getSource() == btnActualizar) {
			actionPerformedBtnActualizar(e);
		}
		if (e.getSource() == btnEliminar) {
			actionPerformedBtnNuevo(e);
		}
	}
	//btnEliminar
	protected void actionPerformedBtnNuevo(ActionEvent e) {
		
				 
				int opcion,cod;
				cod=getCodigo();
				if(cod==-1) {
					return;
				}
				//caso contrario si existe codigo
				else {
					//Mensaje de confirmaciónm JOPTION PANE YES NO sale cuadro de si o no 
					opcion =JOptionPane.showConfirmDialog(this, "¿Estas Seguro de eliminar?","Sistema",JOptionPane.YES_NO_OPTION);
					//si eligio si q es 0 y 1 es no
					if(opcion ==0) {
						//ejecutar el proceso
						int ok=gCli.eliminarCliente(cod);
						//Validar resultado del proceso
						//si ok que es llamado al metodo eliminar usuario es 0 es decir no se eliminó
						if(ok==0) {
							mensajeError("Codigo inexistente");
						}
						//si ok que es llamado al metodo eliminar usuario fuera 1 es decir q si elimino
						else {
							mensajeExitoso("Usuario eliminado");
							//cargar data actualizada luego de hacer la accion
							//cargarDataUsuario();
							cargarClienteData();
							txtCodigo.setEnabled(false);
							limpiar();
						}
						
					}
					
				}
	}

	private void nuevoUsuario() {
		txtDni.setText("");
		txtNombre.setText("");
		txtApellido.setText("");
		txtTelefono.setText("");
		txtDni.requestFocus();
		
	}
	protected void actionPerformedBtnActualizar(ActionEvent e) {
		actualizarUsuario();
	}

	private void actualizarUsuario() {
		// VARIABLES		
				String  dni, nom, ape, tel, dir,LeerNombredis;
				int cod,dis;
				// ENTRADAS
				cod = getCodigo();
				dni = getDni();
				nom = getNombre();
				ape =  getApellido();
				tel = getTelefono();
				dir = getDireccion();
				LeerNombredis = getDistrito();
				dis=getDis();
				
				// VALIDAR
				if(cod == -1 || dni == null || nom == null || ape == null || tel== null || dir == null || LeerNombredis==null) {
					return; // no se ejecuta
				} else {
					//Paso 1 : Crear un objeto de la clase Usuario - instanciamos de la clase Usuario
					Cliente c = new Cliente();
					//Paso 2: setear --> asignar los valores obtenidos desde la GUI a los atributos privados
					c.setId_cliente(cod);
					c.setDni_cliente(dni);
					c.setNom_cliente(nom);
					c.setApe_cliente(ape);
					c.setTel_cliente(tel);
					c.setDir_cliente(dir);
					c.setId_distrito(dis);
					
					
					//Paso 3 : Llamar al proceso de registro - gestionUsuarioDAO, lo hemos instanciado en el constructor
					int res = gCli.actualizarCliente(c);
					//Validar el resultado del proceso de registro
					if(res == 0) {
						mensajeError(":( Error en la actualización)");
					}else {
						mensajeExitoso("Actualización exitosa");
						cargarClienteData();
						txtCodigo.setEnabled(false);
						limpiar();
					}
								
				}

	}
	private void cargarDataComboDistrito() {
		ArrayList<Distrito> distr=GDist.listarDistrito();
		if(distr.size()==0) {
			mensajeError("Lista vacia , falta llenar datos");
		}
		else {
			cboDistrito.addItem("Selecione...");
			for(Distrito d:distr) {
				cboDistrito.addItem(d.getId_distrito()+" .- "+d.getNom_distrito());
				//cboDistrito.addItem(d.getId_distrito());
			}
		}
	}
	private void cargarClienteData() {
		model.setRowCount(0);
		ArrayList<Cliente>list=gCli.listarCliente();
		for(Cliente c:list) {
			Object fila[]= {
					//solo estos campos se veran en la tabla, las otras no
				c.getId_cliente(),
				c.getDni_cliente(),
				c.getNom_cliente(),
				c.getApe_cliente(),
				c.getTel_cliente(),
				c.getDir_cliente(),
				c.getId_distrito(),
				
			};
			//añadir fila a la tabla
			model.addRow(fila);
			
		}
	}
	protected void actionPerformedBtnEncenderCaja(ActionEvent e) {
		txtCodigo.setEnabled(true);
	}
	//Metodo limpiar cajas
	private void limpiar() {
		txtApellido.setText("");
		txtCodigo.setText("");
		txtDni.setText("");
		txtNombre.setText("");
		txtTelefono.setText("");
		txtDireccion.setText("");
	    cboDistrito.setSelectedIndex(0);
		
	}
}
