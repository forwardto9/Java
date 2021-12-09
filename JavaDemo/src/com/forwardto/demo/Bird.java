package com.forwardto.demo;

public final class Bird extends Animal implements AnimalBehavior {
	private String name = null;
	
	public Bird() {
		//
	}
	
	public Bird(String n) throws Exception {
		// TODO Auto-generated constructor stub
		if (n.equals("test")) {
			try {
				throw new Exception("The initialization operation failed!");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			this.setName(n);
		}
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	
//	this is overload
	public void description() {
		System.out.println("I'm a bird!");
	}
}
