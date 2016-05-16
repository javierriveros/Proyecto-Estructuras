package logica;

import javax.sound.sampled.spi.AudioFileReader;

import com.sun.media.sound.AudioFloatConverter;

import jm.audio.io.AudioFileIn;
import jm.util.Read;
import listas.Lista;

public class Cancion {
	private String nombreDelAudio;
	private int channelsNumber;
	private int sampleRate;
	private int samples;
	private float duracion;
	private Lista amplitudes;
	
	public Cancion(String ruta) {
		float[] data = Read.audio("D:/pepes.wav");
		for(int i = 0; i < data.length; i++) {
			System.out.println(data[i]);
		}
		amplitudes = new Lista(data);
		amplitudes.mostrar();
	}
	
	public Lista getAmplitudes() {
		return amplitudes;
	}
}
