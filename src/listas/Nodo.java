package listas;

public class Nodo {

	private float amplitud;
	private Nodo enlace;
	
	public Nodo(float amplitud){
		this.amplitud = amplitud;
		enlace = null;
	}
	
	public Nodo(float amplitud, Nodo enlace){
		this.amplitud = amplitud;
		this.enlace = enlace;
	}
	
	public void setAmplitud(float amplitud){
		if(amplitud >= -1 && amplitud <= 1){
			this.amplitud = amplitud;
		} else{
			System.out.println("La amplitud debe estar entre -1 y 1");
		}
	}
	
	public void setEnlace(Nodo enlace){
		this.enlace = enlace;
	}
	
	public float getAmplitud(){
		return amplitud;
	}
	
	public Nodo getEnlace(){
		return enlace;
	}
	
}
