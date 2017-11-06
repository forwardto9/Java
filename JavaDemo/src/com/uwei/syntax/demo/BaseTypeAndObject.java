package com.uwei.syntax.demo;

public class BaseTypeAndObject {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i = 1;
		Integer intObject = new Integer(i);
		System.out.print(intObject.toString());
		
		byte b = 'a'; // byte b = 'a';
		Byte bObject = new Byte(b);
		System.out.print("\n" + bObject.toString());
		
		char c = 'c';
		Character cObject = new Character(c);
		System.out.print("\n" + cObject);
		
		boolean bool = false;
		Boolean boolObejct = new Boolean(bool);
		System.out.print("\n");
		System.out.print(bool);
		
	}

}
