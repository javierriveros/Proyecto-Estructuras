package logica;

import java.io.File;
import java.util.regex.Pattern;

import javazoom.jlgui.basicplayer.BasicPlayer;
import javazoom.jlgui.basicplayer.BasicPlayerException;
import jm.audio.io.AudioFileIn;
import jm.audio.io.AudioFileOut;
import listas.Lista;

public class Cancion {
	private String nombreDelAudio;
	private int channelsNumber;
	private int sampleRate;
	private int depth;
	private float duracion;
	private Lista amplitudes;
	private String location;
	private BasicPlayer player;

	public Cancion(String ruta) {
		AudioFileIn archivo = new AudioFileIn(ruta);
		channelsNumber = archivo.getChannels();
		sampleRate = archivo.getSampleRate();
		depth = archivo.getBitResolution();
		amplitudes = new Lista(archivo.getSampleData());
		String name[] = ruta.split(Pattern.quote("\\"));
		nombreDelAudio = name[name.length - 1];
		duracion = amplitudes.getTamano() / sampleRate;
		location = ruta;
		player = new BasicPlayer();
		guardarTemporal();
	}

	/**
	 * Metodo que retorna una lista la cual contiene todo los samples de la
	 * canci�n.
	 * 
	 * @return Lista con los valores de amplitud
	 */
	public Lista getAmplitudes() {
		return amplitudes;
	}

	/**
	 * Guarda temporalmente la canci�n como un archivo .wav de nombre "elo".
	 */
	private void guardarTemporal() {
		@SuppressWarnings("unused")
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

	/**
	 * Carga el archivo de audio para posteriormente reproducirlo, pausarlo,
	 * resumirlo o detenerlo.
	 */
	public void cargarArchivo() {
		try {
			player.open(new File("elo.wav"));
		} catch (Exception ex) {

		}
	}

	/**
	 * Una vez cargado el archivo se puede poner a reproducir con este m�todo.
	 */
	public void play() {
		try {
			player.play();
		} catch (Exception ex) {

		}
	}

	/**
	 * Si el audio es pausado, este puede reanudar desde el ultimo lugar
	 * reproducido con este metodo.
	 */
	public void resume() {
		try {
			player.resume();
		} catch (Exception ex) {

		}
	}

	public void pause() {
		try {
			player.pause();
		} catch (BasicPlayerException e) {

		}
	}

	public void stop() {
		try {
			player.stop();
		} catch (BasicPlayerException e) {
			
		}
	}

	public String toString() {
		String info = "Nombre del archivo: " + this.nombreDelAudio + "\nDuracion: " + this.duracion
				+ "\nNumero de canales: " + this.channelsNumber + "Resolucion de bits: " + this.depth + "\nUbicacion:  "
				+ this.location + "\nPropietario: " + System.getProperty("user.name");
		return info;
	}
}
