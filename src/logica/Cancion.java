package logica;

import java.io.File;
import java.util.regex.Pattern;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.spi.AudioFileReader;

import com.sun.media.sound.AudioFloatConverter;

import jm.audio.Audio;
import jm.audio.io.AudioFileIn;
import jm.audio.io.AudioFileOut;
import jm.util.Play;
import jm.util.Read;
import listas.Lista;
import listas.Nodo;

public class Cancion {
	private String nombreDelAudio;
	private int channelsNumber;
	private int sampleRate;
	private int depth;
	private int samples;
	private float duracion;
	private Lista amplitudes;
	private boolean entro;
	private Nodo nodoCopia;

	public Cancion(String ruta) {
		AudioFileIn archivo = new AudioFileIn(ruta);
		channelsNumber = archivo.getChannels();
		sampleRate = archivo.getSampleRate();
		depth = archivo.getBitResolution();
		amplitudes = new Lista(archivo.getSampleData(), this);
		String name[] = ruta.split(Pattern.quote("\\"));
		nombreDelAudio = name[name.length - 1];
		duracion = amplitudes.getTamano() / sampleRate;
		nodoCopia = null;
		
		guardarTemporal();
	}

	public Lista getAmplitudes() {
		return amplitudes;
	}

	private void guardarTemporal() {
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
		
	}
	
	public void setNodoCopia(Nodo nodo) {
		this.nodoCopia = nodo;
	}
	
	public Nodo getNodoCopia() {
		return nodoCopia;
	}

	public void pause() {
		System.out.println("Se llama a pausar");
		// hilo.pause();
	}

	public void stop() {
		Play.stopAudio();
	}

}
