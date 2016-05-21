package Ventana;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JPanel;

import jm.util.Read;
import listas.Lista;

public class Grafica extends JPanel {

	private Lista valoresAmplitud;

	public Grafica(Lista valoresAmplitud) {
		this.valoresAmplitud = valoresAmplitud;
		
	}

	public void paint(Graphics g) {
		super.paint(g);
		System.out.println("entre aqui");
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		//System.out.println("entra");
		g2d.setColor(new Color(207, 216, 220));
		g2d.fillRect(0, 0, this.getWidth(), this.getHeight());

		g2d.setColor(Color.BLACK);
		g2d.drawLine(0, this.getHeight() / 2, this.getWidth(), this.getHeight() / 2);
		if (valoresAmplitud != null) {
			//System.out.println("entra!!!");
			g2d.setColor(Color.RED);
			int razonDeCambio = valoresAmplitud.getTamano() / this.getWidth();
			int posicionEnGrafica = 0;
			int oldY = this.getHeight() / 2;
			int oldX = 0;
			for (int i = 1; i < valoresAmplitud.getTamano(); i++) {
				if(i % 1 == 0){
					float posicionY = valoresAmplitud.getAmplitudAt(i) + 1;
					//System.out.println(valoresAmplitud.getAmplitudAt(i));
					//System.out.println(posicionY);
					posicionY = (posicionY * this.getHeight()) / 2;
					int posY = (int) posicionY;
					//g2d.drawLine(oldX, oldY, posicionEnGrafica, posY);
					
					g2d.drawRect(posicionEnGrafica, posY, 0, 0);
										
					//System.out.println("Pare de lineas: " + oldX + " " + oldY + "\nPar de lineas:" + posicionEnGrafica + " " + posY);
					oldX = posicionEnGrafica;
					oldY = posY;
					if(i % razonDeCambio == 0) {
						posicionEnGrafica++;
					}
				}
			}
		}
	}
	

}
