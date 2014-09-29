package com.waszczyk.clock;

import javax.swing.JFrame;

public class Main extends JFrame {

	 // konstruktor
	 public Main() {
	  // tytu³ okna
	  super("Zegar w Swingu");
	  // rozmiar okna
	  setSize( 350, 100);
	  // ustawienie domyœlnej akcji przy zamykaniu okna
	  setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	  // ustawiamy widocznoœæ okna
	  setVisible(true);
	  // nie pozwalamy zmieniaæ rozmiarów okna
	  setResizable(false);

	  // tworzymy nowy obiekt klasy Zegar
	  Clock zegar = new Clock();
	  // dodajmy go do naszego okna
	  add(zegar);

	  // startujemy nasz zegar
	  zegar.start();
	 }

	 public static void main(String [] args) {
	  // utworzenie obiektu i wywo³anie konstruktora
	  new Main();
	 }
	}