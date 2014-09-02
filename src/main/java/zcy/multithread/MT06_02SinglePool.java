package zcy.multithread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MT06_02SinglePool {

	public static void main(String[] args) {

		ExecutorService pool = Executors.newSingleThreadExecutor();
		Thread t1 = new MyThread1222("t1"); 
		Thread t2 = new MyThread1222("t2"); 
		Thread t3 = new MyThread1222("t3"); 
		Thread t4 = new MyThread1222("t4"); 
		Thread t5 = new MyThread1222("t5"); 
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

class MyThread1222 extends Thread{ 
	String name;
	public MyThread1222(String n){
		this.name = n;
	}
	@Override 
	public void run() { 
		System.out.println(Thread.currentThread().getName()+"正在执行。。。"+this.name); 
	} 
}
