package com.uwei.syntax.demo;

public class BaseTypeAndObject {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i = 1;
		Integer intObject = i;
		System.out.print(intObject.toString());
		
		byte b = 'a'; // byte b = 'a';
		Byte bObject = b;
		System.out.print("\n" + bObject.toString());
		
		char c = 'c';
		Character cObject = c;
		System.out.print("\n" + cObject);
		
		boolean bool = false;
		Boolean boolObejct = bool;
		System.out.println(bool);

		String s = "string";
		Class cls = s.getClass();
		System.out.println(cls);
		
	}

}
