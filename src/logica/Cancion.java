package logica;

import javax.sound.sampled.spi.AudioFileReader;

import com.sun.media.sound.AudioFloatConverter;

import jm.audio.io.AudioFileIn;
import jm.audio.io.AudioFileOut;
import jm.util.Play;
import jm.util.Read;
import listas.Lista;

public class Cancion {
	private String nombreDelAudio;
	private int channelsNumber;
	private int sampleRate;
	private int depth;
	private int samples;
	private float duracion;
	private Lista amplitudes;
	
	public Cancion(String ruta) {
		AudioFileIn archivo = new AudioFileIn(ruta);
		channelsNumber = archivo.getChannels();
		sampleRate = archivo.getSampleRate();
		depth = archivo.getBitResolution();
		amplitudes = new Lista(archivo.getSampleData());
		nombreDelAudio = ruta;
		duracion = amplitudes.getTamano() / sampleRate;
		guardarTemporal();
	}
	
	public Lista getAmplitudes() {
		return amplitudes;
	}
	
	private void guardarTemporal(){
		AudioFileOut salida = new AudioFileOut(amplitudes.toFloatArray(), "elo.wav", 1, sampleRate, depth);
	}
	
	public void guardadoTemporal() {
		guardarTemporal();
	}
	
	public String getNombreDelAudio() {
		return nombreDelAudio;
	}
	
	public float getDuracion() {
		return duracion;
	}
}
