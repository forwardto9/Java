package com.uwei.syntax.demo;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class StringType {

	public static void main(String[] args) throws UnsupportedEncodingException {
		// TODO Auto-generated method stub

		String stringName = "hello world"; // 用于常量最好
		System.out.print("first string is " + stringName + "\n");
		stringName = stringName + " 1"; // 不推荐使用 + 操作，性能问题
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
		System.out.println(Arrays.toString(sbArray));

		// Unicode编码需要两个或者更多字节表示
		System.out.println(Arrays.toString("a".getBytes(StandardCharsets.UTF_8)));
		System.out.println("a".getBytes(StandardCharsets.US_ASCII));

		// 新的JDK版本的String则以byte[]存储：如果String仅包含ASCII字符，则每个byte存储一个字符，
		// 否则，每两个byte存储一个字符，这样做的目的是为了节省内存，因为大量的长度较短的String通常仅包含ASCII字符
		String chString = "我是谁";
	}

}
