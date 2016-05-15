package listas;

public class Lista {

	private Nodo raiz;
	private int numElementos;

	public Lista() {
		this.raiz = null;
		this.numElementos = 0;
		this.raiz.setEnlaceSiguiente(raiz);
	}

	public Lista(float[] valores) {
		this.numElementos = valores.length;
		this.raiz = null;
		this.raiz.setEnlaceSiguiente(raiz);
	}

	public boolean isEmpty() {
		return this.numElementos == 0;
	}

	public void insertarPrimero(float amplitud) {
		if (isEmpty()) {
			this.raiz = new Nodo(amplitud);
			this.raiz.setEnlaceSiguiente(raiz);
			this.raiz.setEnlaceAnterior(raiz);
		} else {
			// Nodo recorrido = raiz;
			Nodo nuevo = new Nodo(amplitud);
			/*
			 * while(recorrido.getEnlaceSiguiente() != raiz){ recorrido =
			 * recorrido.getEnlaceSiguiente(); }
			 */
			/*
			 * recorrido.setEnlaceSiguiente(nuevo);
			 * nuevo.setEnlaceSiguiente(raiz); raiz = nuevo;
			 */
			nuevo.setEnlaceAnterior(this.raiz.getEnlaceAnteriror());
			this.raiz.getEnlaceAnteriror().setEnlaceSiguiente(nuevo);
			this.raiz.setEnlaceAnterior(nuevo);
			nuevo.setEnlaceSiguiente(this.raiz);
			this.raiz = nuevo;
		}
		numElementos++;
	}

	public void insertarUltimo(float amplitud) {
		if (isEmpty()) {
			this.raiz = new Nodo(amplitud);
			this.raiz.setEnlaceSiguiente(raiz);
			this.raiz.setEnlaceAnterior(raiz);
		} else {
		//	Nodo recorrido = raiz;
			Nodo nuevo = new Nodo(amplitud);
		/*	while (recorrido.getEnlaceSiguiente() != raiz) {
				recorrido = recorrido.getEnlaceSiguiente();
			} 
			recorrido.setEnlaceSiguiente(nuevo);
			nuevo.setEnlaceSiguiente(raiz); */
			nuevo.setEnlaceAnterior(this.raiz.getEnlaceAnteriror());
			nuevo.setEnlaceSiguiente(this.raiz);
			this.raiz.getEnlaceAnteriror().setEnlaceSiguiente(nuevo);
			this.raiz.setEnlaceAnterior(nuevo);
		}
		numElementos++;
	}

	public void insertar(float amplitud, int posicion) {
		if (!isEmpty() && posicion >= 1 && posicion <= numElementos + 1) {
			if (posicion == 1) {
				insertarPrimero(amplitud);
			} else if (posicion == numElementos + 1) {
				insertarUltimo(amplitud);
			} else {
				Nodo recorrido = this.raiz;
				Nodo nuevo = new Nodo(amplitud);
				for (int i = 2; i < posicion; i++) {
					recorrido = recorrido.getEnlaceSiguiente();
				}
			/*	nuevo.setEnlaceSiguiente(recorrido.getEnlaceSiguiente());
				recorrido.setEnlaceSiguiente(nuevo);  */
				nuevo.setEnlaceSiguiente(recorrido.getEnlaceSiguiente());
				recorrido.getEnlaceSiguiente().setEnlaceAnterior(nuevo);
				recorrido.setEnlaceSiguiente(nuevo);
				nuevo.setEnlaceAnterior(recorrido);
				numElementos++;
			}
		}
	}

	public float extraerPrimero() {
		if (!isEmpty() && this.numElementos != 1) {
			Nodo recorrido = this.raiz;
			while (recorrido.getEnlaceSiguiente() != raiz) {
				recorrido = recorrido.getEnlaceSiguiente();
			}
			float amplitud = this.raiz.getAmplitud();
			this.raiz = this.raiz.getEnlaceSiguiente();
			recorrido.setEnlaceSiguiente(this.raiz);
	    //  recorrido.setEnlaceSiguiente(raiz.getEnlaceSiguiente());
			this.numElementos--;
			return amplitud;
		} else if (numElementos == 1) {
			float amplitud = this.raiz.getAmplitud();
			this.raiz = null;
			this.numElementos--;
			return amplitud;
		} else {
			System.out.println("No hay elementos para extraer.");
			return Float.MAX_VALUE;
		}
	}

	public float extraerUltimo() {
		if (!isEmpty() && this.numElementos != 1) {
			Nodo recorrido = this.raiz;
			while (recorrido.getEnlaceSiguiente().getEnlaceSiguiente() != this.raiz) {
				recorrido = recorrido.getEnlaceSiguiente();
			}
			float amplitud = recorrido.getEnlaceSiguiente().getAmplitud();
		//  recorrido.setEnlaceSiguiente(recorrido.getEnlaceSiguiente().getEnlaceSiguiente());
			recorrido.setEnlaceSiguiente(this.raiz);
			this.numElementos--;
			return amplitud;
		} else if (numElementos == 1) {
			float amplitud = this.raiz.getAmplitud();
			this.raiz = null;
			this.numElementos--;
			return amplitud;
		} else {
			System.out.println("No hay elementos para extraer.");
			return Float.MAX_VALUE;
		}
	}

	public float extraer(int posicion) {
		if (!isEmpty() && posicion >= 1 && posicion <= this.numElementos) {
			if (posicion == 1) {
				return extraerPrimero();
			} else if (posicion == this.numElementos) {
				return extraerUltimo();
			} else {
				Nodo recorrido = this.raiz;
				for (int i = 2; i < posicion; i++) {
					recorrido = recorrido.getEnlaceSiguiente();
				}
				float amplitud = recorrido.getEnlaceSiguiente().getAmplitud();
				recorrido.setEnlaceSiguiente(recorrido.getEnlaceSiguiente().getEnlaceSiguiente());
				this.numElementos--;
				return amplitud;
			}
		} else {
			System.out.println("No hay elementos para extraer");
			return Float.MAX_VALUE;
		}
	}

	public float getAmplitudAt(int posicion) {
		if (!isEmpty() && posicion >= 1 && posicion <= numElementos) {
			Nodo recorrido = raiz;
			for (int i = 1; i < posicion; i++) {
				recorrido.getEnlaceSiguiente();
			}
			return recorrido.getAmplitud();
		} else {
			System.out.println("Posicion no existente");
			return Float.MAX_VALUE;
		}
	}
	
	public int getTamano(){
		return numElementos;
	}

	@Override
	public String toString() {
		String cadena = "Lista: -Numero elementos = " + numElementos + ". Tipo de datos = float"
				+ ". Guarda amplitudes";
		return cadena;
	}
}
