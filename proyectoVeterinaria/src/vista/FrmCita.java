package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.jvnet.substance.SubstanceLookAndFeel;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JComboBox;
import com.toedter.calendar.JDateChooser;

import entidad.Cliente;
import mantenimiento.GestionClienteDAO;
import mantenimiento.GestionMascotaDAO;
import mantenimiento.GestionVeterinarioDAO;
import utils.Validaciones;

import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.border.CompoundBorder;

public class FrmCita extends JInternalFrame implements ActionListener {

	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JTextField txtCodeCita;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_6;
	private JTextField txtCodeCliente;
	private JLabel lblDireccion;
	private JTextField txtNombresCli;
	private JTextField txtApellidosCli;
	private JTextField txtDNICli;
	private JTextField txtCelCLI;
	private JTextField txtCliDirec;
	private JComboBox cboDistrito;
	private JLabel lblNewLabel_7;
	private JLabel lblNewLabel_8;
	private JLabel lblNewLabel_9;
	private JLabel lblNewLabel_10;
	private JTextField txtCodigo;
	private JTextField txtNombre;
	private JTextField txtFechaNac;
	private JTextField txtTipoMascota;
	private JLabel lblNewLabel_11;
	private JLabel lblNewLabel_12;
	private JLabel lblNewLabel_13;
	private JComboBox cboServicio;
	private JLabel lblNewLabel_14;
	private JLabel lblNewLabel_15;
	private JTextField txtCosto;
	private JLabel lblNewLabel_17;
	private JDateChooser txtFecha;
	private JLabel lblNewLabel_18;
	private JComboBox cboVeterinario;
	private JLabel lblNewLabel_16;
	private JTextField txtDetalles;
	private JButton btnRegistrar;
	private JButton btnCancelar;
	private JButton btnBuscarCliente;
	private JButton btnBuscarMascota;

	
	//Instanciar
	GestionClienteDAO gCli=new GestionClienteDAO();
	GestionMascotaDAO gMas=new GestionMascotaDAO();
	GestionVeterinarioDAO gVet=new GestionVeterinarioDAO();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmCita frame = new FrmCita();
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
	public FrmCita() {
		setClosable(true);
		setMaximizable(true);
		setIconifiable(true);
		setTitle("Registro de Citas");
		try {
			//look and feel
			//UIManager.setLookAndFeel("com.jtattoo.plaf.smart.SmartLookAndFeel");
			JFrame.setDefaultLookAndFeelDecorated(true);
			SubstanceLookAndFeel.setSkin("org.jvnet.substance.skin.OfficeSilver2007Skin");
		}catch(Exception e){
			e.printStackTrace();
		}
		setBounds(100, 100, 695, 422);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblNewLabel = new JLabel("C\u00F3digo de cita");
		lblNewLabel.setBounds(21, 14, 80, 14);
		contentPane.add(lblNewLabel);
		
		txtCodeCita = new JTextField();
		txtCodeCita.setBounds(102, 11, 46, 20);
		contentPane.add(txtCodeCita);
		txtCodeCita.setColumns(10);
		
		lblNewLabel_1 = new JLabel("CLIENTE");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 17));
		lblNewLabel_1.setBounds(10, 71, 80, 14);
		contentPane.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("C\u00F3digo:");
		lblNewLabel_2.setBounds(10, 98, 46, 14);
		contentPane.add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("Nombres:");
		lblNewLabel_3.setBounds(10, 123, 46, 14);
		contentPane.add(lblNewLabel_3);
		
		lblNewLabel_4 = new JLabel("Apellidos:");
		lblNewLabel_4.setBounds(10, 148, 46, 14);
		contentPane.add(lblNewLabel_4);
		
		lblNewLabel_5 = new JLabel("DNI:");
		lblNewLabel_5.setBounds(10, 173, 46, 14);
		contentPane.add(lblNewLabel_5);
		
		lblNewLabel_6 = new JLabel("Celular:");
		lblNewLabel_6.setBounds(250, 98, 46, 14);
		contentPane.add(lblNewLabel_6);
		
		txtCodeCliente = new JTextField();
		txtCodeCliente.setBounds(66, 95, 86, 20);
		contentPane.add(txtCodeCliente);
		txtCodeCliente.setColumns(10);
		
		lblDireccion = new JLabel("Direcci\u00F3n");
		lblDireccion.setBounds(250, 123, 57, 14);
		contentPane.add(lblDireccion);
		
		txtNombresCli = new JTextField();
		txtNombresCli.setBounds(66, 120, 86, 20);
		contentPane.add(txtNombresCli);
		txtNombresCli.setColumns(10);
		
		txtApellidosCli = new JTextField();
		txtApellidosCli.setBounds(66, 145, 86, 20);
		contentPane.add(txtApellidosCli);
		txtApellidosCli.setColumns(10);
		
		txtDNICli = new JTextField();
		txtDNICli.setBounds(66, 170, 86, 20);
		contentPane.add(txtDNICli);
		txtDNICli.setColumns(10);
		
		txtCelCLI = new JTextField();
		txtCelCLI.setBounds(314, 95, 86, 20);
		contentPane.add(txtCelCLI);
		txtCelCLI.setColumns(10);
		
		txtCliDirec = new JTextField();
		txtCliDirec.setBounds(314, 120, 86, 20);
		contentPane.add(txtCliDirec);
		txtCliDirec.setColumns(10);
		
		cboDistrito = new JComboBox();
		cboDistrito.setModel(new DefaultComboBoxModel(new String[] {"Seleccione...", "1", "2", "3"}));
		cboDistrito.setBounds(314, 144, 86, 22);
		contentPane.add(cboDistrito);
		
		lblNewLabel_7 = new JLabel("Distrito:");
		lblNewLabel_7.setBounds(250, 148, 46, 14);
		contentPane.add(lblNewLabel_7);
		
		lblNewLabel_8 = new JLabel("MASCOTA");
		lblNewLabel_8.setFont(new Font("Times New Roman", Font.BOLD, 17));
		lblNewLabel_8.setBounds(448, 71, 93, 14);
		contentPane.add(lblNewLabel_8);
		
		lblNewLabel_9 = new JLabel("C\u00F3digo:");
		lblNewLabel_9.setBounds(448, 98, 46, 14);
		contentPane.add(lblNewLabel_9);
		
		lblNewLabel_10 = new JLabel("Nombre:");
		lblNewLabel_10.setBounds(448, 123, 46, 14);
		contentPane.add(lblNewLabel_10);
		
		txtCodigo = new JTextField();
		txtCodigo.setBounds(504, 95, 86, 20);
		contentPane.add(txtCodigo);
		txtCodigo.setColumns(10);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(504, 120, 86, 20);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);
		
		txtFechaNac = new JTextField();
		txtFechaNac.setBounds(504, 145, 86, 20);
		contentPane.add(txtFechaNac);
		txtFechaNac.setColumns(10);
		
		txtTipoMascota = new JTextField();
		txtTipoMascota.setBounds(504, 170, 86, 20);
		contentPane.add(txtTipoMascota);
		txtTipoMascota.setColumns(10);
		
		lblNewLabel_11 = new JLabel("Fec.Nac");
		lblNewLabel_11.setBounds(448, 148, 46, 14);
		contentPane.add(lblNewLabel_11);
		
		lblNewLabel_12 = new JLabel("ATENCI\u00D3N");
		lblNewLabel_12.setFont(new Font("Times New Roman", Font.BOLD, 17));
		lblNewLabel_12.setBounds(288, 213, 125, 14);
		contentPane.add(lblNewLabel_12);
		
		lblNewLabel_13 = new JLabel("Servicio:");
		lblNewLabel_13.setBounds(21, 254, 46, 14);
		contentPane.add(lblNewLabel_13);
		
		cboServicio = new JComboBox();
		cboServicio.setBounds(85, 250, 147, 22);
		contentPane.add(cboServicio);
		
		lblNewLabel_14 = new JLabel("Costo:");
		lblNewLabel_14.setBounds(261, 254, 46, 14);
		contentPane.add(lblNewLabel_14);
		
		lblNewLabel_15 = new JLabel("Tipo ");
		lblNewLabel_15.setBounds(448, 173, 99, 14);
		contentPane.add(lblNewLabel_15);
		
		txtCosto = new JTextField();
		txtCosto.setBounds(316, 251, 132, 20);
		contentPane.add(txtCosto);
		txtCosto.setColumns(10);
		
		lblNewLabel_17 = new JLabel("Fecha cita:");
		lblNewLabel_17.setBounds(259, 287, 68, 14);
		contentPane.add(lblNewLabel_17);
		
		txtFecha = new JDateChooser();
		txtFecha.setBounds(316, 282, 132, 20);
		contentPane.add(txtFecha);
		
		lblNewLabel_18 = new JLabel("Veterinario");
		lblNewLabel_18.setBounds(21, 287, 69, 14);
		contentPane.add(lblNewLabel_18);
		
		cboVeterinario = new JComboBox();
		cboVeterinario.setBounds(85, 283, 147, 22);
		contentPane.add(cboVeterinario);
		
		lblNewLabel_16 = new JLabel("Detalles:");
		lblNewLabel_16.setBounds(479, 236, 46, 14);
		contentPane.add(lblNewLabel_16);
		
		txtDetalles = new JTextField();
		txtDetalles.setBounds(473, 254, 195, 48);
		contentPane.add(txtDetalles);
		txtDetalles.setColumns(10);
		
		btnRegistrar = new JButton("Registrar");
		btnRegistrar.setBounds(480, 337, 89, 23);
		contentPane.add(btnRegistrar);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(579, 337, 89, 23);
		contentPane.add(btnCancelar);
		
		btnBuscarCliente = new JButton("");
		btnBuscarCliente.addActionListener(this);
		btnBuscarCliente.setIcon(new ImageIcon(FrmCita.class.getResource("/img/Symbol Search.png")));
		btnBuscarCliente.setBounds(166, 94, 56, 34);
		contentPane.add(btnBuscarCliente);
		
		btnBuscarMascota = new JButton("");
		btnBuscarMascota.setIcon(new ImageIcon(FrmCita.class.getResource("/img/Symbol Search.png")));
		btnBuscarMascota.setBounds(600, 98, 68, 34);
		contentPane.add(btnBuscarMascota);
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnBuscarCliente) {
			actionPerformedBtnBuscarCliente(e);
		}
	}
	protected void actionPerformedBtnBuscarCliente(ActionEvent e) {
		//Para rellenar las cajas de texto
				int codigo;
				//Obtener el codigo ingresado
				codigo=leerCodigo();
				//validar que si existe codigo, si no existe q es -1 volver a hacer el proceso con return
				if(codigo==-1) {
					return;
				}
				//si existe codigo
				else {
					//llamar al proceso e instanciamos y llamamos al metodo buscar
					Cliente cl=gCli.buscarCliente(codigo);
					//validar el resultado del proceso
					//es decir q el usuario no existe en base al codigo q no existe
					if(cl==null) {
						mensajeError("Id de producto no existe");
					}
					//caso contrario si existe el codigo
					else {
						//llenar las cajas
						txtNombresCli.setText(cl.getNom_cliente());
						cboDistrito.setSelectedItem(cl.getId_distrito());
						txtApellidosCli.setText("" +cl.getApe_cliente());
						txtDNICli.setText(""+ cl.getDni_cliente());
						txtCelCLI.setText(""+cl.getTel_cliente());
						txtCliDirec.setText(cl.getDir_cliente());
					}
				}
	}
	//de cliente
	private int leerCodigo() {
		//completar validacion
		int cod=-1;
		//cod=Integer.parseInt(txtCodigo.getText());
		
		//validar si esta vacio
		if(txtCodeCliente.getText().trim().length()==0) {
			mensajeError("Ingresar el codigo, el cual es n�merico");
			txtCodeCliente.requestFocus();
		}else if(txtCodeCliente.getText().trim().matches(Validaciones.CODIGOCLI)) {
			//si cumple la validacion almacena lo q esta en la caja de texto
			cod=Integer.parseInt(txtCodeCliente.getText());
		}
		//Caso contrario 
		else {
			mensajeError("Formato incorrecto,solo se admite n�meros");
			txtCodeCliente.setText("");
			txtCodeCliente.requestFocus();
		}
		return cod;
	}
	private void mensajeExitoso(String msj) {
		JOptionPane.showMessageDialog(this, msj,"Sistema",1);
		
	}
	private void mensajeError(String msj) {
		JOptionPane.showMessageDialog(this, msj,"Error...",0);
		
	}

}
