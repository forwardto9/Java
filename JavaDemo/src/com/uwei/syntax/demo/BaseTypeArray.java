package com.uwei.syntax.demo;

import java.util.Arrays;

public class BaseTypeArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] iArray = new int[4];
		iArray[0] = 21;
		iArray[1] = 34;
		char [] cArray = new char[] {'b', 'a'};
		double [] dArray = {10.3, 423.45};
		float fArray [] = {56.05f, 78.98f};
		byte bArray[] = {'x', 'y'};
		for (int i = 0; i < 2; ++i) {
			System.out.print(iArray[i]);
			System.out.print("\n");
			System.out.print(cArray[i]);
			System.out.print("\n");
			System.out.print(dArray[i]);
			System.out.print("\n");
			System.out.print(fArray[i]);
			System.out.print("\n");
			System.out.print(bArray[i]);
			System.out.print("\n");
		}
		
		Arrays.sort(cArray);
		for (int i = 0; i < 2; ++i) {
			System.out.print(cArray[i]);
			System.out.print("\n");
		}
		
		System.out.print(Arrays.toString(fArray));
		System.out.print("\n");
		
		Arrays.fill(iArray, 3);
		System.out.print(Arrays.toString(iArray));
	}

}
