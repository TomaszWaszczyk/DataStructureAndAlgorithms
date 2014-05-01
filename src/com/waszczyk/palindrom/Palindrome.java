package com.waszczyk.palindrom;

import java.util.Scanner;

public class Palindrome {

	public static void main(String[] args) {

		String originalString, reverseString = "";
		Scanner in = new Scanner(System.in);
		
		System.out.println("Enter a string to check if the string is a palindrome or not.");
		originalString = in.nextLine();
		
		int lengthString = originalString.length();
		
		for (int i = 0; i < args.length; i--) {
			
			reverseString = reverseString + originalString.charAt(i);
			
			if (originalString.equals(reverseString)) {
				
				System.out.println("It is a palindrome.");
				
			} else {
				
				System.out.println("It is not a palindrome.");
			}
		}
		
		
	}
}
