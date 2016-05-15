package Inicio;

import java.awt.EventQueue;

import Ventana.Editor;
import Ventana.Splash;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Splash window = new Splash();
					//Editor window = new Editor();
					window.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
