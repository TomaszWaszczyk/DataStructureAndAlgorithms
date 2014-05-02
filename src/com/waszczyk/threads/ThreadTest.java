package com.waszczyk.threads;

class Text implements Runnable{

	private String napis;
	
	public Text(String text){
		this.napis = text;
	}
	
	@Override
	public void run() {

		for (int i = 0; i < 10; i++) {
			System.out.println(napis);
			try {
				Thread.sleep((int)(Math.random() * 2000));
			} catch (InterruptedException e) {
				
				
			}
		}
	}
}

public class ThreadTest{
	
	public static void main(String[] args) {
		
		// created three objects Text
		Text firstString = new Text("First String");
		Text secondString = new Text("Second String");
		Text thirdString = new Text("Third String");
		
		//created three threads
		Thread firstThread = new Thread(firstString);
		Thread secondThread = new Thread(secondString);
		Thread thirdThread = new Thread(thirdString);
		
		// lets run our threads
		firstThread.start();
		secondThread.start();
		thirdThread.start();
		
	}
}

