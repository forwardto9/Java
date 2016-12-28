package com.forwardto9.demo;

public class MainDemo {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Animal animal = new Animal();
		animal.description();
		animal.run();
		
		Animal animal2 = new Bird("Jojo");
		animal2.description();
		
		try {			
			Bird bird =  new Bird("test");
			bird.description();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("The exception info is " + e.getMessage());
		}
		
		
		Dog dog = new Dog();
		dog.run();
		dog.description();
	}

}
