package myTest;
import java.util.Enumeration;
import java.util.Vector;
import java.util.Stack;
import java.util.Hashtable;

import java.io.*;


interface FileNameFilter {
	boolean accept(File f, String name);
}

class DirFilter implements FilenameFilter {
	private String n;
	DirFilter(String path) {
		this.n = path;
	}
	
	@Override
	public boolean accept(File f, String name) {
		// TODO Auto-generated method stub
		String s = new File(name).getName();
		return s.indexOf(n) != -1;
	}
	
}


class MyTest {
	private String testName = "";
	
	MyTest(String n) {
		this.testName = n;
	}
	
	public void show() {
		System.out.println("MyTest Show");
	}
	
	public void setTestName(String name) {
		this.testName = name;
	}
	public String getTestName() {
		return this.testName;
	}
	
//	@Override
	 public String toString() {
		return "MyTest";
	}
}

class MyT {
	
	int i = 0;
	
	public void show() {
		System.out.println("MyT Show");
	}
	
//	@Override
	 public String toString() {
		return "MyT";
	}
}

public class My2 {
	private static final String Integer = null;
	private int x = 0;
	private final class InnerPrivateClass {
		void show() {
			System.out.print(x);
		}
	}
	
	private final static class InnerStaticClass {
		
		static int xx = 0;
		void show () {
			System.out.print("xxxxx");
		}
	}
	
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
System.out.print("My2");
My2 my = new My2();
My2.InnerStaticClass is = new My2.InnerStaticClass();
is.show();
 

int [] intArray = new int[]{1,2,3,4,5,6};

int [] arrayCopy = intArray;
arrayCopy[1] = 22;

for (int i = 0; i < intArray.length; ++i) {
	System.out.print("\n");
	System.out.print(intArray[i]);
}

MyTest[] tArray = {new MyTest("u"), new MyTest("w")};
for (int i = 0; i < tArray.length; ++i) {
	System.out.print("\n" + tArray[i].getTestName());
}

Object[] tAnotherArray = {new MyT(), new MyTest("u")};
for (int i = 0; i < tAnotherArray.length; ++i) {
	System.out.println(tAnotherArray[i].toString());
}
 
Vector v = new Vector();
for (int i = 0; i < 10; ++i)
	v.addElement(new MyT());

v.addElement(new MyTest("Haha"));
//for (int i = 0; i < v.size(); ++i)
//	((MyT) v.elementAt(i)).show();


//Enumeration e = v.elements();
//while(e.hasMoreElements()) {
//	((MyT)e.nextElement()).show();
//}
Stack<MyT> s = new Stack<MyT>();
for (int i = 0; i < 10; ++i)
	s.push(new MyT());


Hashtable h = new Hashtable();

for (int i = 0; i < 10000; ++i) {
	Integer it = new Integer((int)(Math.random() * 20));
	if (h.containsKey(it)) {
		((MyT)h.get(it)).i++;
	} else {
		h.put(it, new MyT());
	}
}

System.out.println(h);

File path = new File(".");
String[] list;

if (args.length == 0) {
	list = path.list();
} else {
	list = path.list(new DirFilter(args[0]));
}

for(int i = 0; i < list.length; ++i) {
	System.out.println(list[i]);
}

 try {
	FileOutputStream fos = new FileOutputStream("txt.txt");
	try {
		fos.write("12345".getBytes());
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
} catch (FileNotFoundException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
 
  int ins = System.in.read();

  System.out.println(ins);


	}
}
