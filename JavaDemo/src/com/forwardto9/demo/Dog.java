package com.forwardto9.demo;

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

}
