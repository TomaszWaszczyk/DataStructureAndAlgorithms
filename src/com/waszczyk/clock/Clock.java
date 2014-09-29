package com.waszczyk.clock;

import java.awt.*;
import javax.swing.*;
import java.util.*;
import java.text.*;

/**
 * Prosty zegar w Swingu
 * 
 * @author kodatnik.blogspot.com
 */

// nowa klasa Zegar zbudowana w oparciu o klas� JLabel
class Clock extends JLabel implements Runnable {

	private Thread watek;
	private int pauza = 1000;

	public Clock() {
		super("", SwingConstants.CENTER);
		setFont(new Font("Consolas", Font.BOLD, 28));
		setBackground(Color.BLUE);
		setForeground(Color.WHITE);
		setOpaque(true);
	}

	// metoda start tworzy i uruchamia w�tek zegara
	public void start() {
		// je�li nie ma dzia�aj�cego w�tka, utw�rz i uruchom nowy
		if (watek == null) {
			watek = new Thread(this);
			watek.start();
		}
	}

	// metoda wywo�ana po starcie w�tku
	public void run() {
		// dop�ki zmienna watek wskazuje na bie��cy w�tek
		while (watek == Thread.currentThread()) {
			// nowy obiekt klasy Date
			Date time = new Date();
			// formatowanie
			DateFormat df = DateFormat.getTimeInstance(DateFormat.MEDIUM);
			// ustawiamy tekst
			setText(df.format(time));
			try {
				// wstrzymujemy dzia�anie w�tku na 1 sekund�
				watek.sleep(pauza);
			} catch (InterruptedException e) {
			}
		}
	}

	public void stop() {
		// ustawiamy referencj� watek na null
		watek = null;
	}
}