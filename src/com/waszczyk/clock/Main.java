package com.waszczyk.clock;

import javax.swing.JFrame;

public class Main extends JFrame {

	 // konstruktor
	 public Main() {
	  // tytu� okna
	  super("Zegar w Swingu");
	  // rozmiar okna
	  setSize( 350, 100);
	  // ustawienie domy�lnej akcji przy zamykaniu okna
	  setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	  // ustawiamy widoczno�� okna
	  setVisible(true);
	  // nie pozwalamy zmienia� rozmiar�w okna
	  setResizable(false);

	  // tworzymy nowy obiekt klasy Zegar
	  Clock zegar = new Clock();
	  // dodajmy go do naszego okna
	  add(zegar);

	  // startujemy nasz zegar
	  zegar.start();
	 }

	 public static void main(String [] args) {
	  // utworzenie obiektu i wywo�anie konstruktora
	  new Main();
	 }
	}