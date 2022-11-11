package hilos;

import vista.Logueo;

public class HiloTiempo extends Thread {
	@Override
  public void run() {
		for (int i = 0; i <=10; i++) {
			Logueo.lblTiempo.setText(i + "s");
			//pausa
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		//cerrar la ventana
		Logueo.frame.dispose();
 }
}
