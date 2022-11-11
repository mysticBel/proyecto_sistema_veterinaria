package vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import entidad.Cliente;
import mantenimiento.GestionClienteDAO;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class DlgBuscarCliente extends JDialog implements ActionListener {

	private final JPanel contentPanel = new JPanel();
	////Creamos tabla
	DefaultTableModel model=new DefaultTableModel();
	//Instanciamos
	GestionClienteDAO gCli=new GestionClienteDAO();
	private JButton btnBuscar;
	private JTable tblClientes;
	private JScrollPane scrollPane;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgBuscarCliente dialog = new DlgBuscarCliente();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgBuscarCliente() {
		setBounds(100, 100, 676, 493);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblCliente = new JLabel("Relaci\u00F3n de CLIENTES");
			lblCliente.setBounds(63, 32, 177, 14);
			contentPanel.add(lblCliente);
		}
		{
			btnBuscar = new JButton("Listar");
			btnBuscar.addActionListener(this);
			btnBuscar.setBounds(352, 28, 89, 23);
			contentPanel.add(btnBuscar);
		}
		{
			scrollPane = new JScrollPane();
			scrollPane.setBounds(10, 79, 640, 364);
			contentPanel.add(scrollPane);
			{
				tblClientes = new JTable();
				tblClientes.setFillsViewportHeight(true);
				scrollPane.setViewportView(tblClientes);
				//Agregando columnas a la tabla
				model.addColumn("Código Cliente");
				model.addColumn("DNI");
				model.addColumn("Nombre");
				model.addColumn("Apellido");
				model.addColumn("Teléfono");
				model.addColumn("Dirección");
				model.addColumn("Cod_Distrito");
				//asociar tabla con objeto model
				tblClientes.setModel(model);
			}
		}	
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnBuscar) {
			actionPerformedBtnBuscar(e);
		}
	}
	protected void actionPerformedBtnBuscar(ActionEvent e) {
		//Limpiamos
				model.setRowCount(0);
				//paso 2 obtener el resultado de la consulta , antes creada en gestionProductoDAO de tipo ArrayList listarProductos
				ArrayList<Cliente>list=gCli.listarCliente();
					for(Cliente cl:list) {
						Object fila[]= {
								//solo estos campos se veran en la tabla, las otras no, solo campos que quiero se ponen
							cl.getId_cliente(),
							cl.getDni_cliente(),
							cl.getNom_cliente(),
							cl.getApe_cliente(),
							cl.getTel_cliente(),
							cl.getDir_cliente(),
							cl.getId_distrito()
					
					};
						//añadir fila a la tabla
						model.addRow(fila);
					}
	}
}
