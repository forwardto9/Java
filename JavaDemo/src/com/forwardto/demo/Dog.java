package com.forwardto.demo;
import com.uwei.syntax.demo.MyAnnotation;

import java.lang.annotation.Inherited;

public class Dog  implements AnimalBehavior {
	
	 private final String name = "Koko";
	 
	 private AnimalBehavior abAnimalBehavior = new AnimalBehavior() {
		
		@Override
		public void run() {
			// TODO Auto-generated method stub
			System.out.print("Object running!");
		}
		
		@Override
		public void description() {
			// TODO Auto-generated method stub
			System.out.println("Show !");
		}
	};

	@Override
	public void run() {
		// TODO Auto-generated method stub
		abAnimalBehavior.run();
	}

	@Override
	public void description() {
		// TODO Auto-generated method stub
		System.out.println("I'm a dog!");
		System.out.println("My name is "  + this.name);
	}

	@MyAnnotation(type = 1, value = "function(x)")
	public void test(Integer x, String n) {
		// TODO 怎么执行value呢？
	}

}
