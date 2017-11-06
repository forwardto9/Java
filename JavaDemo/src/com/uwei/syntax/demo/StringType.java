package com.uwei.syntax.demo;

import java.util.Arrays;

public class StringType {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String stringName = "hello world"; // 用于常量最好
		System.out.print("first string is " + stringName + "\n");
		stringName = stringName + " 1"; // 不要推荐使用 + 操作，性能问题
		System.out.print("string + 1 =  " + stringName + "\n");
		
		StringBuilder stringBuilder = new StringBuilder("this string is from StringBuilder");
		System.out.print(stringBuilder);
		System.out.print("\n");
		stringBuilder.append(" append string");
		System.out.print(stringBuilder);
		System.out.print("\n");
		
		StringBuffer stringBuffer = new StringBuffer("this string is from StringBuffer");
		System.out.print(stringBuffer);
		System.out.print("\n");
		String subStringFromStringBuffer = stringBuffer.substring(0, stringBuffer.capacity()/2);
		System.out.print("SubString from StringBuffer is " + subStringFromStringBuffer);
		System.out.print("\n");
		
		StringBuffer [] sbArray = new StringBuffer[2];
		Arrays.fill(sbArray, new StringBuffer("demo"));
		System.out.print(Arrays.toString(sbArray));
	}

}
