package com.waszczyk.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class CrunchifyReflectionTutorial {
	
	public static void main(String[] args) {
		
		CrunchifyPOJO crunchify = new CrunchifyPOJO();
		System.out.println("Crunchify Object: --------------\n" + crunchify);

		// How to find out the Object belongs to which class?
		Class<?> clazz = crunchify.getClass();

		// Example1: -------------- How to get the Class's Name, CanonicalName
		// and SimpleName?
		String clazzName = clazz.getName();
		String clazzCanonicalName = clazz.getCanonicalName();
		String clazzSimpleName = clazz.getSimpleName();

		System.out.println("How to get the Class's Name, CanonicalName and SimpleName? --------------");
		System.out.println("1. clazzName: " + clazzName
				+ ", \n2. clazzCanonicalName: " + clazzCanonicalName
				+ ", \n3. clazzSimpleName: " + clazzSimpleName + "\n");

		// Example2: -------------- Let's find out if class object represents an
		// Array class
		int[][] crunchifyArr = { { 1, 1 }, { 2, 1 } };
		Class<? extends int[][]> arrClazz = crunchifyArr.getClass();
		System.out.println("Let's find out if class object represents an Array class --------------");
		
		if (arrClazz.isArray()) {
			System.out.println("- " + arrClazz.getSimpleName()
					+ " is an array class.\n");
		} else {
			System.out.println("- " + clazz.getSimpleName()
					+ " is not an array class.\n");
		}

		// Example3: -------------- Let's find out Object's Type
		Double crunchifyDouble = 11.1;
		System.out.println("Let's find out Object's Type --------------");
		System.out.println("- 11.1 is of Type: " + crunchifyDouble.getClass().getName() + "\n");

		// Example4: -------------- How to get SuperClass
		System.out.println("How to get SuperClass --------------");
		System.out.println("1. Superclass of crunchify: "
				+ crunchify.getClass().getSuperclass()
				+ "\n2. Superclass of crunchifyDouble: "
				+ crunchifyDouble.getClass().getSuperclass() + "\n");

		// Example5: -------------- How to check if class is Primitive Type of
		// not?
		System.out.println("How to check if class is Primitive Type of not? --------------");
		System.out.println("1. Is 'int' a Prmitive Type: " + int.class.isPrimitive());
		System.out.println("2. Is 'String' a Prmitive Type: " + String.class.isPrimitive());
		System.out.println("3. Is 'double' a Prmitive Type: " + double.class.isPrimitive());

		// Example6: -------------- How to create an object using Constructor
		// object?
		// A constructor reflection to create a string object by calling
		// String(String) and String(StringBuilder) constructors.
		Class<String> clazzString = String.class;
		System.out.println("\nHow to create object using Constructor object? --------------");
		try {
			Constructor<?> constructor = clazzString
					.getConstructor(new Class[] { String.class });
			String object = (String) constructor
					.newInstance(new Object[] { "Hello World!" });
			System.out.println("1. String.class = " + object);

			constructor = clazzString
					.getConstructor(new Class[] { StringBuilder.class });
			object = (String) constructor
					.newInstance(new Object[] { new StringBuilder(
							"Hello Universe!") });
			System.out.println("2. StringBuilder.class = " + object);
		} catch (Exception e) {
			e.printStackTrace();
		}

		// Example7: -------------- How to get constructors of a class object?
		System.out.println("\nHow to get constructors of a class object --------------");
		try {
			Constructor<? extends CrunchifyPOJO> constructor = crunchify
					.getClass().getConstructor();
			System.out.println("- Constructor = " + constructor.getName());
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		}

		// Example8: -------------- How to get field of a class object
		try {
			System.out.println("\nHow to get field of a class object --------------");
			Field[] methods = clazz.getFields();
			for (Field temp : methods) {
				System.out.println("- " + temp.getName());
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		// Example9: -------------- How to invoke a method using Method class?
		try {
			System.out.println("\nHow to invoke a method using Method class --------------");
			Class<?> c = Class.forName("com.crunchify.tutorial.CrunchifyPOJO");
			Object obj = c.newInstance();
			Method method = c.getDeclaredMethod("thisIsCrunchifyReflection");
			method.invoke(obj);
		} catch (Exception e) {

			System.out.println(e);
		}
	}

}
