package com.uwei.syntax.demo;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.TreeSet;
import java.util.Vector;



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
		result = o.name.compareToIgnoreCase("A");
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
			System.out.println(string);
		}
		
		TreeSet<D> treeSetD = new TreeSet<D>();
		treeSetD.add(new D("D"));
		treeSetD.add(new D("F"));
		treeSetD.add(new D("E"));
		treeSetD.add(new D("X"));
		treeSetD.add(new D("Y"));
		treeSetD.add(new D("K"));
		treeSetD.add(new D("A"));
		
		System.out.println(treeSetD.toString());
		TreeSet<Integer> treeSetInt= new TreeSet<Integer>();
		treeSetInt.add(5);
		treeSetInt.add(-2);
		treeSetInt.add(3);
		treeSetInt.add(14);
		System.out.println(treeSetInt.toString());

		PriorityQueue<Integer> pInt = new PriorityQueue<Integer>();
		pInt.add(12);
		pInt.add(-1);
		pInt.add(10);
		System.out.println(pInt.toString());
		while (!pInt.isEmpty()) {
			System.out.println(pInt.poll());
		}
		int [] intA = {9,12,45,6,235,688,19,130,415,516,90,987};
		
		// 类似二叉树的实现
		PriorityQueue<Integer> pIntQueue = new PriorityQueue<Integer>(intA.length, new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				return o2 - o1;
			}
			
		}) ;
		
		for(int i:intA) {
			pIntQueue.add(i);
		}
		
		System.out.println(pIntQueue.toString());
		while (!pIntQueue.isEmpty()) {
			System.out.println(pIntQueue.poll());
		}
		
		LinkedList<Integer> linkedListInt = new LinkedList<Integer>();
		linkedListInt.add(1);
		linkedListInt.add(10);
		linkedListInt.add(-9);
		linkedListInt.add(0);
		System.out.println(linkedListInt);
		
		ArrayList<String> arrayListString = new ArrayList<String>();
		arrayListString.add("uwei");
		arrayListString.add("demo");
		System.out.println(arrayListString);
		arrayListString.add(arrayListString.size(), "add");
		System.out.println(arrayListString);
		
		if (arrayListString.contains("demo")) {
			System.out.println("Yes, find it!");
		}
		for (Iterator<String> iterator = arrayListString.iterator(); iterator.hasNext();) {
			String string = iterator.next();
			System.out.println(string);
		}
		
		Stack<Integer> stackInt =  new Stack<Integer>();
		stackInt.push(1);
		stackInt.push(2);
		stackInt.push(3);
		System.out.println(stackInt);
		while (!stackInt.isEmpty()) {
			System.out.println(stackInt.pop());
		}
		
		Vector<Comparable> vectorString = new Vector<Comparable>();
		vectorString.setSize(20);
		vectorString.set(10, "10");
		vectorString.add("add1");
		vectorString.add("add2");
		vectorString.addElement("e1");
		vectorString.add(7);
		vectorString.addElement(new D("myD"));
		System.out.println(vectorString);
		vectorString.removeElement(7);
		System.out.println(vectorString);
	}

}
