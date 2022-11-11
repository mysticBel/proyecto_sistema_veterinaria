package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import entidad.Veterinario;
import mantenimiento.GestionVeterinarioDAO;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;

public class FrmVeterinario extends JFrame implements ActionListener, KeyListener, MouseListener {

	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JTextField txtCodVeterinario;
	private JLabel lblNewLabel_2;
	private JTextField txtDNI;
	private JLabel lblNewLabel_3;
	private JTextField txtNombre;
	private JLabel lblNewLabel_4;
	private JTextField txtApellido;
	private JLabel lblNewLabel_5;
	private JTextField txtTelefono;
	private JButton btnRegistrar;
	private JButton btnActualizar;
	private JButton btnEliminar;
	private JTable tblVeterinario;
	private JScrollPane scrollPane;
	//Instanciar un objeto para el modelamiento o estructura de la tabla
	DefaultTableModel model=new DefaultTableModel();
	//Instanciamos
	GestionVeterinarioDAO gVet=new GestionVeterinarioDAO();

	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmVeterinario frame = new FrmVeterinario();
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
	public FrmVeterinario() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 648, 493);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblNewLabel = new JLabel("Gesti\u00F3n de Veterinario");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 19));
		lblNewLabel.setBounds(222, 11, 223, 69);
		contentPane.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("ID_Veterinario");
		lblNewLabel_1.setBounds(10, 63, 128, 14);
		contentPane.add(lblNewLabel_1);
		
		txtCodVeterinario = new JTextField();
		txtCodVeterinario.setBounds(90, 60, 122, 20);
		contentPane.add(txtCodVeterinario);
		txtCodVeterinario.setColumns(10);
		
		lblNewLabel_2 = new JLabel("DNI");
		lblNewLabel_2.setBounds(10, 100, 46, 14);
		contentPane.add(lblNewLabel_2);
		
		txtDNI = new JTextField();
		txtDNI.setBounds(90, 97, 128, 20);
		contentPane.add(txtDNI);
		txtDNI.setColumns(10);
		
		lblNewLabel_3 = new JLabel("Nombre");
		lblNewLabel_3.setBounds(10, 137, 67, 14);
		contentPane.add(lblNewLabel_3);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(90, 134, 128, 20);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);
		
		lblNewLabel_4 = new JLabel("Apellido");
		lblNewLabel_4.setBounds(10, 174, 67, 14);
		contentPane.add(lblNewLabel_4);
		
		txtApellido = new JTextField();
		txtApellido.setBounds(90, 171, 128, 20);
		contentPane.add(txtApellido);
		txtApellido.setColumns(10);
		
		lblNewLabel_5 = new JLabel("Tel\u00E9fono");
		lblNewLabel_5.setBounds(10, 205, 46, 14);
		contentPane.add(lblNewLabel_5);
		
		txtTelefono = new JTextField();
		txtTelefono.setBounds(90, 202, 128, 20);
		contentPane.add(txtTelefono);
		txtTelefono.setColumns(10);
		
		btnRegistrar = new JButton("Registrar");
		btnRegistrar.addActionListener(this);
		btnRegistrar.setBounds(343, 59, 89, 23);
		contentPane.add(btnRegistrar);
		
		btnActualizar = new JButton("Actualizar");
		btnActualizar.addActionListener(this);
		btnActualizar.setBounds(343, 133, 89, 23);
		contentPane.add(btnActualizar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(this);
		btnEliminar.setBounds(343, 201, 89, 23);
		contentPane.add(btnEliminar);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 244, 612, 199);
		contentPane.add(scrollPane);
		
		tblVeterinario = new JTable();
		tblVeterinario.addMouseListener(this);
		tblVeterinario.addKeyListener(this);
		tblVeterinario.setFillsViewportHeight(true);
		scrollPane.setViewportView(tblVeterinario);
		//Agregando columnas a la tabla
		model.addColumn("Código Veterinario");
		model.addColumn("DNI");
		model.addColumn("NOMBRE");
		model.addColumn("APELLIDO");
		model.addColumn("TELÉFONO");
		
		//asociar tabla con objeto model
		tblVeterinario.setModel(model);
		//cargar data
		cargarDataVeterinario();
		//deshabilitar caja
		txtCodVeterinario.setEnabled(false);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnEliminar) {
			actionPerformedBtnEliminar(e);
		}
		if (e.getSource() == btnActualizar) {
			actionPerformedBtnActualizar(e);
		}
		if (e.getSource() == btnRegistrar) {
			actionPerformedBtnRegistrar(e);
		}
	}
	protected void actionPerformedBtnRegistrar(ActionEvent e) {
		//Variables
				String dniVet,nomVet,apeVet,tel_vet;
				//idVet=getIdVeterinario();
				dniVet=getDNIVeterinario();
				nomVet=getNombVeterinario();
				apeVet=getApeVeterinario();
				tel_vet=getTeleVeterinario();
				//validar
						if(  dniVet==null || nomVet==null || apeVet==null || tel_vet==null) {
							//vuelve al proceso anterior
							return;
						}
						//caso contrario
						else {
							//creamos objeto de tipo usuario, a este objeto le asignamos los valores, el objeto u tiene todo nombre apellido etc
							Veterinario v= new Veterinario();
							//Setear --> asignar valores obtenidos de la gui a los atributos privados
							v.setDni_vet(dniVet);
							v.setNom_vet(nomVet);
							v.setApe_vet(apeVet);
							v.setTel_vet(tel_vet);
							//Llamar al proceso de registro, q es de tipo int , agregamos 1 registro exitoso 1 es int
							int res=gVet.registrarVeterinario(v);
							//validar el resultado del proceso de registro
							if(res==0) {
								mensajeError("Error en el registro");
							}
							else {
								mensajeExitoso("Veterinario registrado");
								//luego de registro , actualiza lista
								cargarDataVeterinario();
								limpiar();
								}
				
						}
	}
	private int getIdVeterinario() {
		return Integer.parseInt(txtCodVeterinario.getText().trim());
	}

	private String getDNIVeterinario() {
		return txtDNI.getText().trim();
		
	}

	private String getNombVeterinario() {
		return txtNombre.getText().trim();
	}

	private String getApeVeterinario() {
		return txtApellido.getText().trim();
	}

	private String getTeleVeterinario() {
		return txtTelefono.getText().trim();
	}

	private void mensajeError(String msj) {
		JOptionPane.showMessageDialog(this, msj,"Error...",0);
		
	}
	private void mensajeExitoso(String msj) {
		JOptionPane.showMessageDialog(this, msj,"Sistema",1);
	}
	
	protected void actionPerformedBtnActualizar(ActionEvent e) {
		//Variables
		String dniVet,nomVet,apeVet,tel_vet;
		int idVet;
		idVet=getIdVeterinario();
		dniVet=getDNIVeterinario();
		nomVet=getNombVeterinario();
		apeVet=getApeVeterinario();
		tel_vet=getTeleVeterinario();
		//validar
				if(idVet ==-1 || dniVet==null || nomVet==null || apeVet==null || tel_vet==null) {
					//vuelve al proceso anterior
					return;
				}
				//caso contrario
				else {
					//creamos objeto de tipo usuario, a este objeto le asignamos los valores, el objeto u tiene todo nombre apellido etc
					Veterinario v= new Veterinario();
					//Setear --> asignar valores obtenidos de la gui a los atributos privados
					v.setId_vet(idVet);
					v.setDni_vet(dniVet);
					v.setNom_vet(nomVet);
					v.setApe_vet(apeVet);
					v.setTel_vet(tel_vet);
					//Llamar al proceso de registro, q es de tipo int , agregamos 1 registro exitoso 1 es int
					int res=gVet.actualizarVeterinario(v);
					//validar el resultado del proceso de registro
					if(res==0) {
						mensajeError("Error en la actualización");
					}
					else {
						mensajeExitoso("Actualización exitosa");
						//luego de registro , actualiza lista
						cargarDataVeterinario();
						limpiar();
						}
		
				}
		
	}
	protected void actionPerformedBtnEliminar(ActionEvent e) {
		//Obtener codigo ingreso a partir de donde se eliminara
		//variable opcion para validar si le dio click en si
		
		int opcion,cod;
		cod=getIdVeterinario();
		//validar que si existe codigo, si no existe q es -1 volver a hacer el proceso con return
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
				int ok=gVet.eliminarVeterinario(cod);
				//Validar resultado del proceso
				//si ok que es llamado al metodo eliminar usuario es 0 es decir no se eliminó
				if(ok==0) {
					mensajeError("Codigo inexistente");
				}
				//si ok que es llamado al metodo eliminar usuario fuera 1 es decir q si elimino
				else {
					mensajeExitoso("Veterinaro eliminado");
					//cargar data actualizada luego de hacer la accion
					cargarDataVeterinario();
					limpiar();
				}
				
			}
			
		}
	}
	//metodo cargar datos a la tabla
	private void cargarDataVeterinario() {
		model.setRowCount(0);
		ArrayList<Veterinario>list=gVet.listarVeterinario();
		for(Veterinario v:list) {
			Object fila[]= {
					//solo estos campos se veran en la tabla, las otras no
				v.getId_vet(),
				v.getDni_vet(),
				v.getNom_vet(),
				v.getApe_vet(),
				v.getTel_vet(),
			
			};
			//añadir fila a la tabla
			model.addRow(fila);
			
	}
	}
	//Metodo mostrar datos a partir de mouse o tecla en cajas de TEXTO
	private void mostrarDatosApartirdeMousetecla(int fila) {
		String id,dni,nom,ape,tel;
		id=tblVeterinario.getValueAt(fila, 0).toString();
		dni=tblVeterinario.getValueAt(fila, 1).toString();
		nom=tblVeterinario.getValueAt(fila, 2).toString();
		ape=tblVeterinario.getValueAt(fila, 3).toString();
		tel=tblVeterinario.getValueAt(fila, 4).toString();
		txtCodVeterinario.setText(id);
		txtDNI.setText(dni);
		txtNombre.setText(nom);
		txtApellido.setText(ape);
		txtTelefono.setText(tel);
	}
	
	public void keyPressed(KeyEvent e) {
	}
	public void keyReleased(KeyEvent e) {
		if (e.getSource() == tblVeterinario) {
			keyReleasedTblVeterinario(e);
		}
	}
	public void keyTyped(KeyEvent e) {
	}
	protected void keyReleasedTblVeterinario(KeyEvent e) {
		int fila;
		fila=tblVeterinario.getSelectedRow();
		mostrarDatosApartirdeMousetecla(fila);
	}
	public void mouseClicked(MouseEvent e) {
	}
	public void mouseEntered(MouseEvent e) {
	}
	public void mouseExited(MouseEvent e) {
	}
	public void mousePressed(MouseEvent e) {
	}
	public void mouseReleased(MouseEvent e) {
		if (e.getSource() == tblVeterinario) {
			mouseReleasedTblVeterinario(e);
		}
	}
	protected void mouseReleasedTblVeterinario(MouseEvent e) {
		int fila;
		fila=tblVeterinario.getSelectedRow();
		mostrarDatosApartirdeMousetecla(fila);
	}
	private void limpiar() {
		txtCodVeterinario.setText("");
		txtDNI.setText("");
		txtNombre.setText("");
		txtApellido.setText("");
		txtTelefono.setText("");
		
	}
}
