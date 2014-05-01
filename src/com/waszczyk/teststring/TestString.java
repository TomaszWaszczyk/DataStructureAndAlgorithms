package com.waszczyk.teststring;

public class TestString {

	public static void main(String[] args) {
		
		String tomek = "Tomek";
		
		long start = System.nanoTime();
		for (int i = 0; i < 10000; i++) {
			
			tomek += "a";
		}
		

		System.out.println("Time1: " + (System.nanoTime() - start));
		
	}
}
