package core.cliente;
import java.io.*;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicBoolean;

import javax.sound.sampled.*;

public class Player {
	static AtomicBoolean pausa = new AtomicBoolean(false);

	class Pausa extends Thread {
		public void run() {
			Scanner scan = new Scanner(System.in);
			while (true) {
				String temp = scan.nextLine();
				if (temp.equalsIgnoreCase("pausa")) {
					pausa.set(true);
				} else if (temp.equalsIgnoreCase("play")) {
					pausa.set(false);
				}
			}
		}
	}

	Pausa criar_pausador() {
		return new Pausa();
	}

	public static void main(String[] args)
			throws UnsupportedAudioFileException, IOException,
			LineUnavailableException {
		System.out.println("Playerzinho bolado...\nDigite o endereco da musica desejada: ");
		String endereco_musica = new Scanner(System.in).nextLine();
		Player instancia = new Player();
		
		File musica;
		while(!(musica = new File(endereco_musica)).exists()){
			System.out.println("Arquivo de música inexistente. Digite um endereço válido: ");
			endereco_musica = new Scanner(System.in).nextLine();
		}
		
		System.out.println("Tocando... (digite 'pausa' para pausar e 'play' para continuar)");
		
		AudioInputStream in = AudioSystem.getAudioInputStream(musica);

		AudioFormat baseFormat = in.getFormat();

		AudioFormat decodedFormat = new AudioFormat(
				AudioFormat.Encoding.PCM_SIGNED, // Encoding to use
				baseFormat.getSampleRate(), // sample rate (same as base format)
				16, // sample size in bits (thx to Javazoom)
				baseFormat.getChannels(), // # of Channels
				baseFormat.getChannels() * 2, // Frame Size
				baseFormat.getSampleRate(), // Frame Rate
				false // Big Endian
		);

		AudioInputStream decodedIn = AudioSystem.getAudioInputStream(
				decodedFormat, in);

		DataLine.Info info = new DataLine.Info(SourceDataLine.class,
				decodedFormat);
		SourceDataLine line = (SourceDataLine) AudioSystem.getLine(info);
		line.open(decodedFormat);
		Pausa pausador = instancia.criar_pausador();
		pausador.start();

		if (line != null) {
			byte[] data = new byte[4096]; // 4k is a reasonable transfer size.
			// Start
			line.start(); // Start the line.

			int nBytesRead;
			while ((nBytesRead = decodedIn.read(data, 0, data.length)) != -1) {
				while (pausa.get()) {
					if (line.isRunning()) {
						line.stop();
					}
				}
				line.start();
				line.write(data, 0, nBytesRead);
			}

			// Stop
			line.drain();
			line.stop();
			line.close();
			decodedIn.close();
		}
	}

}
