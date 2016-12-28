package my.thread.demo;

import java.util.ArrayList;


class X {
	public static int x;
}

class MyThread extends Thread {
	
	private static int countNumber = 0;
	private int number;
	private long loopCount = 9;
	
	MyThread() {
		number = countNumber++;
		System.out.println("Create a thread" + number);
	}
	
	public void run () {
		System.out.println( "Current thread NO. is " + number);
		while (true) {
			X.x = (int) (Math.random() * 10000 + 1);
			if (--this.loopCount == 0) {
				break;
			}
		}
		
		try {
			sleep(3);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}

class MyRunable extends Thread {
//class MyRunable implements Runnable {

	private Thread myThread = null;
	
	MyRunable() {
//		this.myThread = new Thread();
//		this.myThread.start();
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println(MyRunable.class.getName() + "  " + X.x);
	}
	
}

public class MyThreadDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ArrayList<MyThread> list = new ArrayList<MyThread>();
		
		for (int i = 0; i < 10; i++) {
			MyThread td = new MyThread();
			if (i ==5) {
				td.setPriority(Thread.MAX_PRIORITY);
			}
			td.start();
			list.add(td);
			
			MyRunable mr = new MyRunable();
			mr.start();
		}
		
		
		System.out.println("Done!");
		System.out.println(list);
	}

}
