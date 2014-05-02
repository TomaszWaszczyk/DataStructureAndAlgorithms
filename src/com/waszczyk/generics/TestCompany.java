package com.waszczyk.generics;

public class TestCompany {

	public static void main(String[] args) {

		
		// Generics are only for Object type.
		Company<String> c1 = new Company<String>("Apple");
		Company<Integer> c2 = new Company<Integer>(13);
		Company<Double> c3 = new Company<Double>(12.32);

	
		System.out.println(c1.pobierzElement());
		
	}
}
