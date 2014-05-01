package com.waszczyk.binary;

public class Binary {

	public static boolean isBinary(int number){
		
		int copyNumber = number;
		
		while (copyNumber != 0) {
			if (copyNumber % 10 > 1) {
				return false;
			}
			copyNumber = copyNumber / 10;
		}
		return true;
		
	}
	
	public static void main(String[] args) {
	
		boolean a = isBinary(1001); 
		
		System.out.println(a);
	}
}
