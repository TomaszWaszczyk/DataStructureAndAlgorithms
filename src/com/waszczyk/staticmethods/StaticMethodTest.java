package com.waszczyk.staticmethods;

public class StaticMethodTest {

	public static void main(String[] args) {
		
		Test t = new Test();
		t.normalMethod();
		
		
	}
}


class Person{
	
	String name;
	String address;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	public void calculateAge(int day, int month, int year){
		
		
	}
}

class Test{
	
	int normalVariable = 1;
	static int staticVariable = 5;
	
	public void normalMethod(){
		
		System.out.println(normalVariable);
		System.out.println(staticVariable);
		staticMethod();
	}
	
	public static void staticMethod(){
		
//		System.out.println(normalVariable);
		System.out.println(staticVariable);
//		normalMethod();
	}
}
