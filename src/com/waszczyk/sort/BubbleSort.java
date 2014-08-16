package com.waszczyk.sort;


//https://stackoverflow.com/questions/8938235/java-sort-an-array

public class BubbleSort {

	public static void bubbleSort(int[] array) {
	    boolean swapped = true;
	    int j = 0;
	    int tmp;
	    while (swapped) {
	        swapped = false;
	        j++;
	        for (int i = 0; i < array.length - j; i++) {
	            if (array[i] > array[i + 1]) {
	                tmp = array[i];
	                array[i] = array[i + 1];
	                array[i + 1] = tmp;
	                swapped = true;
	            }
	        }
	    }
	}
	
	
	
	public static void main(String[] args) {
		
		int[] tab = {4,5,3,5,6,5,4,4,4,1};
		bubbleSort(tab);
		
		for (int i : tab) {
			System.out.println(i);
		}
	}
}
