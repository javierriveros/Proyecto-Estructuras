package logica;
import java.io.File;
import java.util.regex.Pattern;

import javazoom.jlgui.basicplayer.BasicPlayer;
import javazoom.jlgui.basicplayer.BasicPlayerException;
import jm.audio.io.AudioFileIn;
import jm.audio.io.AudioFileOut;
import jm.util.Play;
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
	private String location;
	private BasicPlayer player;

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
		location = ruta;
		player = new BasicPlayer();
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
		try {
			player.open(new File("elo.wav"));
			player.play();
		} catch (BasicPlayerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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

	public String toString() {
		String info = "Nombre del archivo: " + this.nombreDelAudio
				+ "\nDuración: " + this.duracion
				+ "\nNúmero de canales: " + this.channelsNumber
				+ "Resolución de bits: " + this.depth
				+ "\nUbicación:  " + this.location
				+ "\nPropietario: " + System.getProperty("user.name");
		return info;
	}
}
