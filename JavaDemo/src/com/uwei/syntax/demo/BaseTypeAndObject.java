package com.uwei.syntax.demo;

public class BaseTypeAndObject {
	public enum MyEnum {
		Enum1(1, "u"),
		Enum2(2, "w");
		private int age;
		private String name;
		MyEnum(int x, String y) {
			age = x;
			name = y;
		}
	}

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

		System.out.println(MyEnum.Enum1);
		System.out.println(MyEnum.Enum1.name);
		
	}

}
