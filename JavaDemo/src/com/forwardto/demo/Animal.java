package com.forwardto.demo;

public class Animal implements AnimalBehavior {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("I'm Running!");
	}

	@Override
	public void description() {
		// TODO Auto-generated method stub
		System.out.println("My current location is " + this.toString());
	}

}
