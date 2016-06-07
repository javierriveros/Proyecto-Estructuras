package logica;

import java.util.regex.Pattern;

import javax.sound.sampled.spi.AudioFileReader;

import com.sun.media.sound.AudioFloatConverter;

import jm.audio.Audio;
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
	private Hilo hilo;
	
	public Cancion(String ruta) {
		AudioFileIn archivo = new AudioFileIn(ruta);
		channelsNumber = archivo.getChannels();
		sampleRate = archivo.getSampleRate();
		depth = archivo.getBitResolution();
		amplitudes = new Lista(archivo.getSampleData());
		String name[] = ruta.split(Pattern.quote("\\"));
		nombreDelAudio = name[name.length-1];
		duracion = amplitudes.getTamano() / sampleRate;
		hilo = new Hilo();
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
	
	public void play() {
		hilo.start();
	}
	
	private class Hilo extends Thread{
		
		
		
		@Override
		public void run() {
			Play.audioFile("elo.wav");
		}
	}
}
