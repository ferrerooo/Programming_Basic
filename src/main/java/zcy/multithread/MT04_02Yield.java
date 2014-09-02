package zcy.multithread;


/*
 *线程的让步含义就是使当前运行着线程让出CPU资源，但是然给谁不知道，仅仅是让出，线程状态回到可运行状态。 
 */

public class MT04_02Yield {

public static void main(String []args){
        
		Thread t1 = new MyThread1112(); 
		Thread t2 = new Thread(new MyRunnable1112()); 
		t1.start(); 
		t2.start();
     }
}

class MyThread1112 extends Thread { 
	public void run() { 
		for (int i = 0; i < 10; i++) { 
			System.out.println("线程1第" + i + "次执行！"); 
			
		} 
	} 
}

class MyRunnable1112 implements Runnable {
	public void run() { 
		for (int i = 0; i < 10; i++) { 
			System.out.println("线程2第" + i + "次执行！"); 
			Thread.yield();
			
		} 
	} 
}


