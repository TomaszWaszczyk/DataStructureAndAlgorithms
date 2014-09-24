package com.waszczyk.interviewsample;

public class ArrayReverse {

	public static void main(String[] args) {

		int mojatablica[] = {1,2,3};
		reverseArray(mojatablica);
	}

	
	public static int[] reverseArray(int[] input) {

		for(int i = 0; i < input.length / 2; i++)
		{
		    int temp = input[i];
		    input[i] = input[input.length - i - 1];
		    input[input.length - i - 1] = temp;
		}
		
		for (int i = 0; i < input.length; i++) {
			System.out.println(input[i]);
		}
		
		return input;
	}
}
