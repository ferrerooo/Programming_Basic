package zcy.multithread;

import java.util.concurrent.Executors; 
import java.util.concurrent.ExecutorService;

public class MT06_01FixedPool {

	public static void main(String[] args) {

		ExecutorService pool = Executors.newFixedThreadPool(1);
		Thread t1 = new MyThread1221("t1"); 
		Thread t2 = new MyThread1221("t2"); 
		Thread t3 = new MyThread1221("t3"); 
		Thread t4 = new MyThread1221("t4"); 
		Thread t5 = new MyThread1221("t5"); 
		//将线程放入池中进行执行
		pool.execute(t1); 
		pool.execute(t2); 
		pool.execute(t3); 
		pool.execute(t4); 
		pool.execute(t5); 
		//关闭线程池 
		pool.shutdown();
	}

}

class MyThread1221 extends Thread{ 
	String name;
	public MyThread1221(String n){
		this.name = n;
	}
	@Override 
	public void run() { 
		System.out.println(Thread.currentThread().getName()+"正在执行。。。"+this.name); 
	} 
}
