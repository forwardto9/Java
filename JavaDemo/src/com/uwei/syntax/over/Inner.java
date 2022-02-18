package com.uwei.syntax.over;

public class Inner {
	private String name;
	public Inner() {
		// TODO Auto-generated constructor stub
	}
	public void setName() {
		Imp imp = new Imp();
		imp.method();
	}
	
	public Imp impm() {
		return new Imp();
	}
	
	public PrivateImp impP() {
		return new PrivateImp();
	}
	
	public class Imp {
		public void method() {
			name = "x";
		}
		private void info() {
			System.out.println("Imp info()");
		}
	}
	
	private class PrivateImp {
		public void method() {
			name = "xP";
		}
		private void info() {
			System.out.println("PrivateImp info()");
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Inner inner = new Inner();
		inner.setName();
		System.out.println(inner.name);
		inner.impm().info();
		inner.impP().info();
	}
	

}
