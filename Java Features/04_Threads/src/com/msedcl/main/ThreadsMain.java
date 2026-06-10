package com.msedcl.main;

import com.msedcl.main.threads.MyThread;

public class ThreadsMain {
public static void main(String[] args) {
	System.out.println("Main Starts");
	MyThread myThread=new MyThread();
	
	System.out.println("Object of Mythread is created");
	Thread thread=new Thread(myThread);
	System.out.println("Object of thread is created");
	thread.start();
	System.out.println("Thread is started");
	
	
	for(int i=0;i<100;i++)
	{
		System.out.println(" Main:: "+i);
	}
	System.out.println("Main Ends");
}
}
