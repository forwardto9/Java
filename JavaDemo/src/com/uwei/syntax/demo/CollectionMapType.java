package com.uwei.syntax.demo;

import java.util.*;
import java.util.Map.Entry;



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

	public enum EnumWeekday {
		SUN, MON, TUE,TUS,FRI,SAT
	}
	
	private static final Class<String> String = null;

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
		
		
		EnumMap<EnumWeekday, Integer> enumMap = new EnumMap<EnumWeekday, Integer>(EnumWeekday.class);
		enumMap.put(EnumWeekday.FRI, 5);
		enumMap.put(EnumWeekday.SUN, 0);
		for (Entry<EnumWeekday, Integer> entry : enumMap.entrySet()) {
			System.out.println(entry.getKey().name() + " : "  + entry.getValue());
		}
		
		IdentityHashMap<String, String> identityHashMap = new IdentityHashMap<String, String>();
		identityHashMap.put("MON", "monday");
		identityHashMap.put("SAT", "saturday");
		identityHashMap.put(new String("SAT"), "saturday 2"); // 要求相同的key必须在不同的存储区，才能完成相同的key的存储，否则会被替换
		for (Entry<String, String> entry:identityHashMap.entrySet()) {
			System.out.println(entry.getKey() + " : " + entry.getValue());
		}
		
		HashMap<String, Integer> rankHashMap = new HashMap<String, Integer>();
		rankHashMap.put("uwei", 1);
		rankHashMap.put("yuan", 2);
		rankHashMap.put("demo", 3);
		rankHashMap.put("demo", 4);
		rankHashMap.put("test", 0);
		rankHashMap.put("key", -1);
		for (Entry<String, Integer> entry : rankHashMap.entrySet()) {
			System.out.println(entry.getKey() + " : " + entry.getValue());
		}
		
		// 有序的HashMap
		LinkedHashMap<String, Integer> linkedHashMap = new LinkedHashMap<String, Integer>();
		linkedHashMap.put("uwei", 1);
		linkedHashMap.put("yuan", 2);
		linkedHashMap.put("demo", 3);
		linkedHashMap.put("demo", 4);
		linkedHashMap.put("test", 0);
		linkedHashMap.put("key", -1);
		for (Entry<String, Integer> entry : linkedHashMap.entrySet()) {
			System.out.println(entry.getKey() + " : " + entry.getValue());
		}
		
		// 有序，线程安全
		Hashtable<Integer, String> hashtable = new Hashtable<Integer, String>();
		hashtable.put(1, "hello");
		hashtable.put(3, "world");
		hashtable.put(0, "demo");
		hashtable.put(2, "test");
		hashtable.put(5, "dummy");
		
		for (Entry<Integer, String> entry : hashtable.entrySet()) {
			System.out.println(entry.getKey() + " : " + entry.getValue());
		}
		
		// 主要目的是操作properties文件
		Properties properties = new Properties();
		properties.put(3, 30);
		properties.put("u", 21);
//		properties.load(null); //主要是这个方法可以从文件中读取格式正确的数据
		for (Entry<Object, Object> entry:properties.entrySet()) {
			System.out.println(entry.getKey() + " : " + entry.getValue());
		}
		
		// 实现SortedMap,实现以Key排序map
		TreeMap<Integer, String> treeMap = new TreeMap<Integer, String>();
		treeMap.put(10, "A");
		treeMap.put(0, "B");
		treeMap.put(-1, "X");
		treeMap.put(18, "U");
		
		for(Entry<Integer, String> entry:treeMap.entrySet()) {
			System.out.println(entry.getKey() + " : " + entry.getValue());
		}
		
		
		String stringTestMapA = new String("a");
		String stringTestMapB = new String("b");
		
		// 弱引用
		WeakHashMap<String, String> weakMap = new WeakHashMap<String, String>();
		HashMap<String, String> map         =  new HashMap<String, String>();
		map.put(stringTestMapA, "aaaaa");
		map.put(stringTestMapB, "bbbb");
		
		weakMap.put(stringTestMapA, "aaaaa");
		weakMap.put(stringTestMapB, "bbbb");
		
		map.remove(stringTestMapA);
		stringTestMapA = null;
		stringTestMapB = null;
		System.gc();
		
		Iterator<?> iteratorMap = map.entrySet().iterator();
		while (iteratorMap.hasNext()) {
			java.util.Map.Entry<String, String> entry = (Entry<String, String>) iteratorMap.next();
			System.out.println(entry.getKey() + " : " + entry.getValue());
		}
		
		Iterator<?> iteratorWeakMap = weakMap.entrySet().iterator();
		while (iteratorWeakMap.hasNext()) {
			java.util.Map.Entry<String, String> entry = (Entry) iteratorWeakMap.next();
			System.out.println(entry.getKey() + " : " + entry.getValue());
		}
		
		// TODO: Concurrent Collection Type
	}

}
