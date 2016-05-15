package Ventana;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JPanel;

import listas.Lista;

public class Grafica extends JPanel {
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

		g2d.setColor(new Color(207, 216, 220));
		g2d.fillRect(0, 0, this.getWidth(), this.getHeight());

		g2d.setColor(Color.BLACK);
		g2d.drawLine(0, this.getHeight() / 2, this.getWidth(), this.getHeight() / 2);

		int oldX = 0;
		int oldY = (int) (this.getHeight() / 2);
		/*
		 * int xPosicion = 0; int incremento = getIncrement(informacionAudio);
		 * g2d.setColor(Color.RED);
		 * 
		 * int t = 0;
		 * 
		 * for (t = 0; t < incremento; t += incremento) { g2d.drawLine(oldX,
		 * oldY, xPosicion, oldY); xPosicion++; oldX = xPosicion; }
		 */
	}

	private int getIncrement(Lista informacionAudio) {
		return informacionAudio.getTamano() / (informacionAudio.getTamano() * this.getWidth());
	}

	public void graficador(Lista listaAudio) {

	}
}
