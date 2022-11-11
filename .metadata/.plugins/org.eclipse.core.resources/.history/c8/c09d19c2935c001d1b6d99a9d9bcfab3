package hilos;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JLabel;

import vista.FrmPreLoader;
import vista.FrmPrincipal;

public class HiloReloj extends Thread {
	
	//atributo privado
	private JLabel lblHora;
	//constructor
	public HiloReloj(JLabel lblHora) {
		this.lblHora = lblHora;
	}
	
	public void run() {
		while (true) {
			
			//Obtener la fecha del sistema
			Date hora = new Date();
			//Formato para la hora
			SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss ");
			// mostrar la hora en la etiqueta "lblHora"
			//  FrmPrincipal.lblHora.setText(sdf.format(hora)); //cambiamos esto para cualquier ventana
			lblHora.setText(sdf.format(hora));
		}
}
}