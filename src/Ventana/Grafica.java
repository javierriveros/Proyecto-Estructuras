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
		this.repaint();
	}

	public void paint(Graphics g) {
		super.paint(g);
		System.out.println("entra");
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2d.setColor(Color.BLACK);
		g2d.fillRect(0, 0, this.getWidth(), this.getHeight());

//		g2d.setColor(Color.BLACK);
	//	g2d.drawLine(0, this.getHeight() / 2, this.getWidth(), this.getHeight() / 2);

		if (valoresAmplitud.getTamano() != 0) {
			dibujarLineas(g2d);
		}

	}

	private void dibujarLineas(Graphics2D g2d) {
		g2d.setColor(new Color(58, 217, 150));
		float[] fragmentos = valoresAmplitud.toFloatArray();
		int razonDeCambio = (valoresAmplitud.getTamano() / this.getWidth()) / 2;
		int posicion = 0;
		float multiplicador = 1 / valoresAmplitud.getAmplitudMaxima();
		int contador = 0;
		int x1 = 0;
		int y1 = this.getHeight() / 2;
		for (int i = 0; i < fragmentos.length; i++) {
			if (i % razonDeCambio == 0) {
				float aux = fragmentos[i] * multiplicador;
				aux += 1;
				aux = (aux * this.getHeight()) / 2;
				int posY = (int) aux;
				contador++;
				g2d.drawLine(x1, y1, posicion, posY);
				x1 = posicion;
				y1 = posY;
				if (contador == 2) {
					contador = 0;
					posicion++;
				}
			}
		}
	}

	/**
	 * @return the valoresAmplitud
	 */
	public Lista getValoresAmplitud() {
		return valoresAmplitud;
	}

	/**
	 * @param valoresAmplitud the valoresAmplitud to set
	 */
	public void setValoresAmplitud(Lista valoresAmplitud) {
		this.valoresAmplitud = valoresAmplitud;
	}
}
