package listas;

public class Nodo {

	private float amplitud;
	private Nodo enlaceSiguiente;
	private Nodo enlaceAnterior;

	public Nodo(float amplitud) {
		this.amplitud = amplitud;
		enlaceSiguiente = null;
		enlaceAnterior = null;
	}

	public Nodo(float amplitud, Nodo enlace) {
		this.amplitud = amplitud;
		this.enlaceSiguiente = enlace;
	}

	public void setAmplitud(float amplitud) {
		if (amplitud >= -1 && amplitud <= 1) {
			this.amplitud = amplitud;
		} else {
			System.out.println("La amplitud debe estar entre -1 y 1");
		}
	}

	public void setEnlaceSiguiente(Nodo enlaceSiguiente) {
		this.enlaceSiguiente = enlaceSiguiente;
	}

	public float getAmplitud() {
		return amplitud;
	}

	public Nodo getEnlaceSiguiente() {
		return enlaceSiguiente;
	}

	public void setEnlaceAnterior(Nodo enlaceAnterior) {
		this.enlaceAnterior = enlaceAnterior;
	}

	public Nodo getEnlaceAnteriror() {
		return this.enlaceAnterior;
	}

}
