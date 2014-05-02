package com.waszczyk.generics;

public class Company <T> {

	private T element;
	
	public Company (T element) {
		
		this.element = element;
	}
	
	public T pobierzElement(){
		return element;
	}
}
