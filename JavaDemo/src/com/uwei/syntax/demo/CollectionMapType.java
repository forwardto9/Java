package com.uwei.syntax.demo;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.TreeSet;

import sun.management.counter.Variability;



class A {
	@Override
	public boolean equals(Object obj) { // 决定是否加入集合
		// TODO Auto-generated method stub
		return true;
	}
}

class B {
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return 9;
	}
}

class C {
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return true;
	}
	
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return 7;
	}
}

class D implements Comparable<D> {

	String name = "";
	public D(String name) {
		// TODO Auto-generated constructor stub
		this.name = name;
	}
	@Override
	public int compareTo(D o) {
		// TODO Auto-generated method stub
		int result = 0;
		result = this.name.compareToIgnoreCase("D");
		System.out.print("this name is " + this.name + " ======= " + result);
		System.out.print("\n");
		return result;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.name;
	}
}

public class CollectionMapType {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashSet<String>  stringHashSet = new HashSet<String>();
		stringHashSet.add("hello");
		stringHashSet.add("world");
		stringHashSet.add("uwei");
		stringHashSet.add("uwei"); // be replaced
		stringHashSet.add("language");
		for (String string : stringHashSet) {
			System.out.print(string);
		}
		
		System.out.print("\n");
		
		HashSet<Object> objects = new  HashSet<Object>();
		objects.add(new A());
		objects.add(new A());
		objects.add(new B());
		objects.add(new B());
		objects.add(new C());
		objects.add(new C());
		System.out.print(objects);
		
		LinkedHashSet<String> linkedHashSet = new LinkedHashSet<String>();
		linkedHashSet.add("abc");
		linkedHashSet.add("adc");
		linkedHashSet.add("demo");
		linkedHashSet.add("123");
		
		System.out.print("\n");
		for (String string : linkedHashSet) {
			System.out.print(string);
			System.out.print("\n");
		}
		
		TreeSet<D> treeSetD= new TreeSet<D>();
		treeSetD.add(new D("D"));
		treeSetD.add(new D("F"));
		treeSetD.add(new D("E"));
		treeSetD.add(new D("X"));
		
		System.out.print(treeSetD.toString());
		System.out.print("\n");
		TreeSet<Integer> treeSetInt= new TreeSet<Integer>();
		treeSetInt.add(5);
		treeSetInt.add(-2);
		treeSetInt.add(3);
		treeSetInt.add(14);
		System.out.print(treeSetInt.toString());
	}

}
