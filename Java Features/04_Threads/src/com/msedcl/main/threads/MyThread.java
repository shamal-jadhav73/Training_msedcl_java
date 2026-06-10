package com.msedcl.main.threads;

public class MyThread implements Runnable {
	@Override
	public void run() {
		System.out.println("My thread is started.");
		for(int i=0;i<100;i++)
		{
			System.out.println(" Thread:: "+i);
		}
	}
}


