package com.uwei.syntax.over;

class InstrumentX {
	public void play(int x) {
		System.out.println("InstrumentX.play()");
	}
	public void show() {
		System.out.println("InstrumentX.show()");
	}
}

class NoteX {
	public static final int MIDD = 0, FLAT = 1;
}

class WindX extends InstrumentX {
	// 过载(overload)，即有新的实现
	public void play(NoteX x) {
		// TODO Auto-generated method stub
		System.out.println("WindX.play()");
	}
	// 覆盖(override)，即包含父类逻辑之后，填充自定义逻辑
	@Override
	public void show() {
		// TODO Auto-generated method stub
		super.show();
		System.out.println("WindX.show()");
	}
}


public class Over {

	public static void tune(InstrumentX i) {
		i.play(NoteX.FLAT);
//		i.show();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WindX flute = new WindX();
//		flute.show();
		tune(flute);
		
		
		Inner inner = new Inner();
		inner.setName();
		
		// 可见性用于代码框架的控制
		/*
		System.out.println(inner.name);
		inner.impm().info();
		inner.impP().info();
		*/
	}

}
