package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import hilos.HiloBarraProgreso;
import hilos.HiloTiempo;

import javax.swing.JProgressBar;
import javax.swing.JLabel;
import java.awt.Dialog.ModalExclusionType;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

public class FrmPreLoader extends JFrame implements ChangeListener {

	private JPanel contentPane;
	public static JProgressBar prbCarga;
	private JLabel lblSpinner;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmPreLoader frame = new FrmPreLoader();
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
	public FrmPreLoader() {
		setTitle("Cargando...");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 344, 140);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		prbCarga = new JProgressBar();
		prbCarga.addChangeListener(this);
		prbCarga.setStringPainted(true);
		prbCarga.setBounds(0, 71, 338, 19);
		contentPane.add(prbCarga);
		
		JLabel lblMensajes = new JLabel("El sistema est\u00E1 cargando, espere unos segundos");
		lblMensajes.setForeground(Color.BLUE);
		lblMensajes.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblMensajes.setHorizontalAlignment(SwingConstants.CENTER);
		lblMensajes.setBounds(0, 5, 313, 14);
		contentPane.add(lblMensajes);
		
		lblSpinner = new JLabel("");
		lblSpinner.setBounds(137, 32, 46, 14);
		contentPane.add(lblSpinner);
		//llamando al metodo
		cargarBarraProgreso();
	}
	
	private void cargarBarraProgreso() {
		// llamar al proceso , hacer una instancia
			HiloBarraProgreso hp = new HiloBarraProgreso();
		//ejecutar el proceso
			hp.start();
	}
	public void stateChanged(ChangeEvent e) {
		if (e.getSource() == prbCarga) {
			stateChangedPrbCarga(e);
		}
	}
	protected void stateChangedPrbCarga(ChangeEvent e) {
		abrirVentanaPrincipal();
	}

	private void abrirVentanaPrincipal() {
		if(prbCarga.getValue() == 100) {
			FrmPrincipal prin = new FrmPrincipal();
			prin.setVisible(true);
			prin.setLocationRelativeTo(this);
			this.dispose();
		}
		
	}
}
