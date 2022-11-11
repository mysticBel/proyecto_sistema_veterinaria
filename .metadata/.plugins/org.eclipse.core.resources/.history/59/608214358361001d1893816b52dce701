package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;

import entidad.Mascota;
import mantenimiento.GestionMascotaDAO;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;

public class FrmMascota extends JFrame implements ActionListener, KeyListener, MouseListener {

	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JTextField txtCodMascota;
	private JLabel lblNewLabel_2;
	private JTextField txtNomMascota;
	private JTextField txtTipoMascota;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JTextField txtIDCliente;
	private JDateChooser txtFecha;
	private JButton btnBuscarCliente;
	private JButton btnRegistrar;
	private JButton btnActualizar;
	private JButton btnEliminar;
	private JTable tblMascotas;
	private JScrollPane scrollPane;
	//Instanciamos
	GestionMascotaDAO GMas=new GestionMascotaDAO();
	//Instanciar un objeto para el modelamiento o estructura de la tabla
		DefaultTableModel model=new DefaultTableModel();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmMascota frame = new FrmMascota();
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
	public FrmMascota() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 651, 476);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblNewLabel = new JLabel("REGISTRO DE MASCOTAS");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 19));
		lblNewLabel.setBounds(171, 11, 362, 41);
		contentPane.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("C\u00F3digo de Mascota:");
		lblNewLabel_1.setBounds(10, 65, 124, 14);
		contentPane.add(lblNewLabel_1);
		
		txtCodMascota = new JTextField();
		txtCodMascota.setBounds(117, 63, 100, 20);
		contentPane.add(txtCodMascota);
		txtCodMascota.setColumns(10);
		
		lblNewLabel_2 = new JLabel("Nombre de mascota:");
		lblNewLabel_2.setBounds(366, 63, 124, 14);
		contentPane.add(lblNewLabel_2);
		
		txtNomMascota = new JTextField();
		txtNomMascota.setBounds(480, 63, 100, 20);
		contentPane.add(txtNomMascota);
		txtNomMascota.setColumns(10);
		
		txtTipoMascota = new JTextField();
		txtTipoMascota.setBounds(117, 104, 100, 20);
		contentPane.add(txtTipoMascota);
		txtTipoMascota.setColumns(10);
		
		lblNewLabel_3 = new JLabel("Tipo de mascota:");
		lblNewLabel_3.setBounds(10, 107, 108, 14);
		contentPane.add(lblNewLabel_3);
		
		lblNewLabel_4 = new JLabel("Fecha Nacimiento");
		lblNewLabel_4.setBounds(366, 107, 108, 14);
		contentPane.add(lblNewLabel_4);
		
		lblNewLabel_5 = new JLabel("ID_CLIENTE");
		lblNewLabel_5.setBounds(10, 147, 86, 14);
		contentPane.add(lblNewLabel_5);
		
		txtIDCliente = new JTextField();
		txtIDCliente.setBounds(117, 144, 100, 20);
		contentPane.add(txtIDCliente);
		txtIDCliente.setColumns(10);
		
		txtFecha = new JDateChooser();
		txtFecha.setDateFormatString("dd-MM-yyyy");
		txtFecha.setBounds(480, 104, 100, 20);
		contentPane.add(txtFecha);
		
		btnBuscarCliente = new JButton("Buscar Cliente");
		btnBuscarCliente.addActionListener(this);
		btnBuscarCliente.setBounds(227, 143, 116, 23);
		contentPane.add(btnBuscarCliente);
		
		btnRegistrar = new JButton("Registrar");
		btnRegistrar.addActionListener(this);
		btnRegistrar.setBounds(117, 403, 89, 23);
		contentPane.add(btnRegistrar);
		
		btnActualizar = new JButton("Actualizar");
		btnActualizar.addActionListener(this);
		btnActualizar.setBounds(277, 403, 89, 23);
		contentPane.add(btnActualizar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(this);
		btnEliminar.setBounds(416, 403, 89, 23);
		contentPane.add(btnEliminar);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 178, 615, 212);
		contentPane.add(scrollPane);
		
		tblMascotas = new JTable();
		tblMascotas.addMouseListener(this);
		tblMascotas.addKeyListener(this);
		tblMascotas.setFillsViewportHeight(true);
		scrollPane.setViewportView(tblMascotas);
		//Agregando columnas a la tabla
				model.addColumn("Código Mascota");
				model.addColumn("Nombre");
				model.addColumn("Tipo mascota");
				model.addColumn("Fecha Nacimiento");
				model.addColumn("IdCliente");
				
				//asociar tabla con objeto model
				tblMascotas.setModel(model);
				//deshabilitar caja
				txtCodMascota.setEnabled(false);
				//cargar la tabla
				cargarMascotaTabla();
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnBuscarCliente) {
			actionPerformedBtnBuscarCliente(e);
		}
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
		String nomMas,tipoMas,fecNac;
		int idCli;
		nomMas=getNomMascota();
		tipoMas=getTipoMascota();
		fecNac=getFechaNaciMascota();
		idCli=getCliente();
		//validar
				if( nomMas==null || tipoMas==null || fecNac==null || idCli==-1) {
					//vuelve al proceso anterior
					return;
				}
				//caso contrario
				else {
					//creamos objeto de tipo usuario, a este objeto le asignamos los valores, el objeto u tiene todo nombre apellido etc
					Mascota m= new Mascota();
					//Setear --> asignar valores obtenidos de la gui a los atributos privados
					m.setNom_mascota(nomMas);
					m.setTipo_mascota(tipoMas);
					m.setFec_nac_Mascota(fecNac);
					m.setId_cliente(idCli);
					//Llamar al proceso de registro, q es de tipo int , agregamos 1 registro exitoso 1 es int
					int res=GMas.registrarMascota(m);
					//validar el resultado del proceso de registro
					if(res==0) {
						mensajeError("Error en el registro");
					}
					else {
						mensajeExitoso("Mascota registrado");
						//luego de registro , actualiza lista
						cargarMascotaTabla();
						}
		
				}
	}

	private int getIdMascota() {
		return Integer.parseInt(txtCodMascota.getText().trim());
	}

	private String getNomMascota() {
		return txtNomMascota.getText().trim();
	}

	private String getFechaNaciMascota() {
		String fecha=null;
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		fecha=sdf.format(txtFecha.getDate());
		return fecha;
	}

	private String getTipoMascota() {
		return txtTipoMascota.getText().trim();
	}

	private int getCliente() {
		int cliente=-1;
		 cliente=Integer.parseInt(txtIDCliente.getText().trim());
		 return cliente;
	}
	private void mensajeError(String msj) {
		JOptionPane.showMessageDialog(this, msj,"Error...",0);
		
	}
	private void mensajeExitoso(String msj) {
		JOptionPane.showMessageDialog(this, msj,"Sistema",1);
		
	}
	protected void actionPerformedBtnActualizar(ActionEvent e) {
		//Variables
				String nomMas,tipoMas,fecNac;
				int idMasc,idCli;
				idMasc=getIdMascota();
				idMasc=getIdMascota();
				nomMas=getNomMascota();
				tipoMas=getTipoMascota();
				fecNac=getFechaNaciMascota();
				idCli=getCliente();
				//validar
						if(idMasc ==-1 || nomMas==null || tipoMas==null || fecNac==null || idCli==-1) {
							//vuelve al proceso anterior
							return;
						}
						//caso contrario
						else {
							//creamos objeto de tipo usuario, a este objeto le asignamos los valores, el objeto u tiene todo nombre apellido etc
							Mascota m= new Mascota();
							//Setear --> asignar valores obtenidos de la gui a los atributos privados
							m.setId_mascota(idMasc);
							m.setNom_mascota(nomMas);
							m.setTipo_mascota(tipoMas);
							m.setFec_nac_Mascota(fecNac);
							m.setId_cliente(idCli);
							//Llamar al proceso de registro, q es de tipo int , agregamos 1 registro exitoso 1 es int
							int res=GMas.actualizarMascota(m);
							//validar el resultado del proceso de registro
							if(res==0) {
								mensajeError("Error en la actualización");
							}
							else {
								mensajeExitoso("Actualización exitosa");
								//luego de registro , actualiza lista
								cargarMascotaTabla();
								}
				
						}
			}
	
	protected void actionPerformedBtnEliminar(ActionEvent e) {
		//Obtener codigo ingreso a partir de donde se eliminara
				//variable opcion para validar si le dio click en si
				 
				int opcion,cod;
				cod=getIdMascota();
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
						int ok=GMas.eliminarMascota(cod);
						//Validar resultado del proceso
						//si ok que es llamado al metodo eliminar usuario es 0 es decir no se eliminó
						if(ok==0) {
							mensajeError("Codigo inexistente");
						}
						//si ok que es llamado al metodo eliminar usuario fuera 1 es decir q si elimino
						else {
							mensajeExitoso("Mascota eliminada");
							//cargar data actualizada luego de hacer la accion
							cargarMascotaTabla();
						}
						
					}
					
				}
	}
	protected void actionPerformedBtnBuscarCliente(ActionEvent e) {
		DlgBuscarCliente dlg=new DlgBuscarCliente();
		dlg.setVisible(true);
		dlg.setLocationRelativeTo(this);
	}
	//Metodo mostrar datos a partir de mouse o tecla en cajas de TEXTO
		private void mostrarDatosApartirdeMousetecla(int fila) {
			String id,nom,tipo,fech,idclien;
			id=tblMascotas.getValueAt(fila, 0).toString();
			nom=tblMascotas.getValueAt(fila, 1).toString();
			tipo=tblMascotas.getValueAt(fila, 2).toString();
			fech=tblMascotas.getValueAt(fila, 3).toString();
			idclien=tblMascotas.getValueAt(fila, 4).toString();
			txtCodMascota.setText(id);
			txtNomMascota.setText(nom);
			txtTipoMascota.setText(tipo);
			txtIDCliente.setText(idclien);
			try {
				txtFecha.setDate(new SimpleDateFormat("yyyy-MM-dd").parse(fech));
			} catch (ParseException e) {
				System.out.println("Error en el formato de la fecha"+e.getMessage());
			}
		}
	public void keyPressed(KeyEvent e) {
	}
	public void keyReleased(KeyEvent e) {
		if (e.getSource() == tblMascotas) {
			keyReleasedTblMascotas(e);
		}
	}
	public void keyTyped(KeyEvent e) {
	}
	protected void keyReleasedTblMascotas(KeyEvent e) {
		int fila;
		fila=tblMascotas.getSelectedRow();
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
		if (e.getSource() == tblMascotas) {
			mouseReleasedTblMascotas(e);
		}
	}
	protected void mouseReleasedTblMascotas(MouseEvent e) {
		int fila;
		fila=tblMascotas.getSelectedRow();
		mostrarDatosApartirdeMousetecla(fila);
	}
	//cargar data MASCOTA
	private void cargarMascotaTabla() {
		model.setRowCount(0);
		ArrayList<Mascota>list=GMas.listarMascota();
		for(Mascota m:list) {
			Object fila[]= {
					//solo estos campos se veran en la tabla, las otras no
				m.getId_mascota(),
				m.getNom_mascota(),
				m.getTipo_mascota(),
				m.getFec_nac_mascota(),
				m.getId_cliente(),
				
			};
			//añadir fila a la tabla
			model.addRow(fila);
			
		}
		
	}
}
