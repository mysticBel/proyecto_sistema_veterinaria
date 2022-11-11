package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.jvnet.substance.SubstanceLookAndFeel;

import utils.HiloReloj;
import utils.HiloTiempo;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.ImageIcon;
import javax.swing.KeyStroke;
import javax.swing.UIManager;

import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.InputEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JDesktopPane;
import java.awt.SystemColor;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import java.awt.Cursor;

public class FrmPrincipal extends JFrame implements ActionListener {
	private JMenuBar menuBar;
	private JMenu mnSistema;
	private JMenuItem mntmSalir;
	private JMenu mnMantenimiento;
	private JMenu mnReportes;
	private JMenuItem mntmClientesReporte;
	private JMenuItem mntmVentasReporte;
	private JMenuItem mntmClientes;
	private JMenuItem mntmMascotas;
	private JDesktopPane escritorio;
	public static JLabel lblHora;
	private JMenu mnRegistro;
	private JMenuItem mntmRegistroCita;
	private JLabel lblPortada;
	private JMenuItem mntmVeterinarios;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmPrincipal frame = new FrmPrincipal();
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
	public FrmPrincipal() {
		try {
			//look and feel
			//UIManager.setLookAndFeel("com.jtattoo.plaf.smart.SmartLookAndFeel");
			JFrame.setDefaultLookAndFeelDecorated(true);
			SubstanceLookAndFeel.setSkin("org.jvnet.substance.skin.OfficeSilver2007Skin");
		}catch(Exception e){
			e.printStackTrace();
		}
		
		setFont(new Font("Tahoma", Font.PLAIN, 12));
		setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 836, 510);
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mnSistema = new JMenu("Sistema");
		mnSistema.setMnemonic('S');
		menuBar.add(mnSistema);
		
		mntmSalir = new JMenuItem("Salir");
		mntmSalir.addActionListener(this);
		mntmSalir.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F5, InputEvent.ALT_DOWN_MASK));
		mnSistema.add(mntmSalir);
		
		mnMantenimiento = new JMenu("Mantenimiento");
		mnMantenimiento.setMnemonic('M');
		menuBar.add(mnMantenimiento);
		
		mntmClientes = new JMenuItem("Clientes");
		mntmClientes.addActionListener(this);
		mnMantenimiento.add(mntmClientes);
		
		mntmMascotas = new JMenuItem("Mascotas");
		mntmMascotas.addActionListener(this);
		mnMantenimiento.add(mntmMascotas);
		
		mntmVeterinarios = new JMenuItem("Veterinarios");
		mntmVeterinarios.addActionListener(this);
		mnMantenimiento.add(mntmVeterinarios);
		
		mnRegistro = new JMenu("Registro");
		menuBar.add(mnRegistro);
		
		mntmRegistroCita = new JMenuItem("Nueva Cita");
		mntmRegistroCita.addActionListener(this);
		mnRegistro.add(mntmRegistroCita);
		
		mnReportes = new JMenu("Reportes");
		mnReportes.setMnemonic('R');
		menuBar.add(mnReportes);
		
		mntmClientesReporte = new JMenuItem("Clientes");
		mnReportes.add(mntmClientesReporte);
		
		mntmVentasReporte = new JMenuItem("Ventas");
		mntmVentasReporte.addActionListener(this);
		mntmVentasReporte.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_T, InputEvent.CTRL_DOWN_MASK));
		mnReportes.add(mntmVentasReporte);
		
		escritorio = new JDesktopPane();
		escritorio.setBackground(new Color(245, 245, 245));
		getContentPane().add(escritorio, BorderLayout.CENTER);
		
		lblHora = new JLabel("hh:mm:ss");
		lblHora.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblHora.setForeground(Color.WHITE);
		lblHora.setBounds(719, 11, 94, 37);
		escritorio.add(lblHora);
		
		lblPortada = new JLabel("");
		lblPortada.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/img/FH-principal.jpg")));
		lblPortada.setBounds(0, -18, 858, 489);
		escritorio.add(lblPortada);
		
		//lamando al metodo
		mostrarHora();
		
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == mntmVeterinarios) {
			actionPerformedMntmVeterinarios(e);
		}
		if (e.getSource() == mntmRegistroCita) {
			actionPerformedMntmNuevaCita(e);
		}
		if (e.getSource() == mntmClientes) {
			actionPerformedMntmClientes(e);
		}
		if (e.getSource() == mntmVentasReporte) {
			actionPerformedMntmVentasReporte(e);
		}
		if (e.getSource() == mntmMascotas) {
			actionPerformedMntmMascotas(e);
		}
		if (e.getSource() == mntmSalir) {
			actionPerformedMntmSalir(e);
		}
	}
	protected void actionPerformedMntmSalir(ActionEvent e) {
		//Para cerrar principal
		System.exit(0);
	}
	
	protected void actionPerformedMntmClientes(ActionEvent e) {
		FrmCliente cli =new FrmCliente();
		cli.setVisible(true);
		escritorio.add(cli);
	}
	
	protected void actionPerformedMntmMascotas(ActionEvent e) {
		FrmMascota mas =new FrmMascota();
		mas.setVisible(true);
		escritorio.add(mas);
	}
	protected void actionPerformedMntmVentasReporte(ActionEvent e) {
		//FrmRptVtas ven =new FrmRptVtas();
		//ven.setVisible(true);
		//escritorio.add(ven);
	}
	
	//mostrar Hora
	private void mostrarHora() {
		HiloReloj h = new HiloReloj(lblHora);
				h.start();
	}
	protected void actionPerformedMntmNuevaCita(ActionEvent e) {
		FrmCita regCita =new FrmCita();
		regCita.setVisible(true);
		escritorio.add(regCita);
	}
	protected void actionPerformedMntmVeterinarios(ActionEvent e) {
		FrmVeterinario vet =new FrmVeterinario();
		vet.setVisible(true);
		escritorio.add(vet);
	}
}
