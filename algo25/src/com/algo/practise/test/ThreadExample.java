package com.algo.practise.test;

//修改方法，使其保证输出 20
public class ThreadExample {
	private static volatile int i = 10;
	
	private static Object object = new Object();
	
	public static void main(String[] args) throws InterruptedException {
		Thread thread = new Thread(new Runnable() {
			@Override
			public void run() {
				i = 20;
				
				synchronized (object) {
					object.notifyAll();
				}
			}
		});
		thread.start();		
		
		synchronized (object) {
			object.wait();
		}
		
		System.out.print(i);
	}

}
