package listas;

public class Lista {

	private Nodo raiz;
	private int numElementos;
	
	
	public Lista(){
		raiz = null;
		numElementos = 0;
		raiz.setEnlace(raiz);
	}
	
	public Lista(float[] valores){
		numElementos = valores.length;
		raiz = null;
		raiz.setEnlace(raiz);
	}
	
	public boolean isEmpty(){
		return numElementos == 0;
	}
	
	public void insertarPrimero(float amplitud){
		if(isEmpty()){
			raiz = new Nodo(amplitud);
			raiz.setEnlace(raiz);
		} else{
			Nodo recorrido = raiz;
			Nodo nuevo = new Nodo(amplitud);
			while(recorrido.getEnlace() != raiz){
				recorrido = recorrido.getEnlace();
			}
			recorrido.setEnlace(nuevo);
			nuevo.setEnlace(raiz);
			raiz = nuevo;
		}
		numElementos++;
	}
	
	public void insertarUltimo(float amplitud) {
		if(isEmpty()){
			raiz = new Nodo(amplitud);
			raiz.setEnlace(raiz);
		} else{
			Nodo recorrido = raiz;
			Nodo nuevo = new Nodo(amplitud);
			while(recorrido.getEnlace() != raiz){
				recorrido = recorrido.getEnlace();
			}
			recorrido.setEnlace(nuevo);
			nuevo.setEnlace(raiz);
		}
		numElementos++;
	}
	
	public void insertar(float amplitud, int posicion){
		if(!isEmpty() && posicion >=1 && posicion <= numElementos + 1){
			if(posicion == 1){
				insertarPrimero(amplitud);
			} else if (posicion == numElementos + 1){
				insertarUltimo(amplitud);
			} else{
				Nodo recorrido = raiz;
				Nodo nuevo = new Nodo(amplitud);
				for(int i = 2; i < posicion; i++){
					recorrido = recorrido.getEnlace();
				}
				nuevo.setEnlace(recorrido.getEnlace());
				recorrido.setEnlace(nuevo);
				numElementos++;
			}
		}
	}
	
	public float extraerPrimero(){
		if(!isEmpty() && numElementos != 1){
			Nodo recorrido = raiz;
			while(recorrido.getEnlace() != raiz){
				recorrido = recorrido.getEnlace();
			}
			float amplitud = raiz.getAmplitud();
			recorrido.setEnlace(raiz.getEnlace());
			numElementos--;
			return amplitud;
		} else if (numElementos == 1){
			float amplitud = raiz.getAmplitud();
			raiz = null;
			numElementos--;
			return amplitud;
		} else{
			System.out.println("No hay elementos para extraer.");
			return Float.MAX_VALUE;
		}
	}
	
	public float extraerUltimo() {
		if(!isEmpty() && numElementos != 1){
			Nodo recorrido = raiz;
			while(recorrido.getEnlace().getEnlace() != raiz){
				recorrido = recorrido.getEnlace();
			}
			float amplitud = recorrido.getEnlace().getAmplitud();
			recorrido.setEnlace(recorrido.getEnlace().getEnlace());
			numElementos--;
			return amplitud;
		} else if(numElementos == 1){
			float amplitud = raiz.getAmplitud();
			raiz = null;
			numElementos--;
			return amplitud;
		} else {
			System.out.println("No hay elementos para extraer.");
			return Float.MAX_VALUE;
		}
	}
	
	public float extraer(int posicion){
		if(!isEmpty() && posicion >= 1 && posicion <= numElementos){
			if (posicion == 1){
				return extraerPrimero();
			} else if (posicion == numElementos){
				return extraerUltimo();
			} else{
				Nodo recorrido = raiz;
				for(int i = 2; i < posicion; i++) {
					recorrido = recorrido.getEnlace();
				}
				float amplitud = recorrido.getEnlace().getAmplitud();
				recorrido.setEnlace(recorrido.getEnlace().getEnlace());
				numElementos--;
				return amplitud;
			}
		} else{
			System.out.println("No hay elementos para extraer");
			return Float.MAX_VALUE;
		}
	}
	
	public float getAmplitudAt(int posicion) {
		if(!isEmpty() && posicion >= 1 && posicion <= numElementos) {
			Nodo recorrido = raiz;
			for(int i = 1; i < posicion; i++){
				recorrido.getEnlace();
			}
			return recorrido.getAmplitud();
		} else{
			System.out.println("Posicion no existente");
			return Float.MAX_VALUE;
		}
	}
	
	@Override
	public String toString() {
		String cadena = "Lista: -Numero elementos = " + numElementos + ". Tipo de datos = float" +
				". Guarda amplitudes";
		return cadena;
	}
}
