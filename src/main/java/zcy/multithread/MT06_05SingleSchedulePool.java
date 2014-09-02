package zcy.multithread;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class MT06_05SingleSchedulePool {

	public static void main(String[] args) {

		ScheduledExecutorService pool = Executors.newSingleThreadScheduledExecutor();
		Thread t1 = new MyThread0931("t1"); 
		Thread t2 = new MyThread0931("t2"); 
		Thread t3 = new MyThread0931("t3"); 
		Thread t4 = new MyThread0931("t4"); 
		Thread t5 = new MyThread0931("t5"); 
		//将线程放入池中进行执行
		pool.execute(t1); 
		pool.execute(t2); 
		pool.execute(t3); 
		pool.scheduleAtFixedRate(t4, 0, 1, TimeUnit.SECONDS);
		pool.scheduleAtFixedRate(t5, 0, 1, TimeUnit.SECONDS);
		//关闭线程池 
		pool.shutdown();
	}

}

class MyThread0931 extends Thread{ 
	String name;
	public MyThread0931(String n){
		this.name = n;
	}
	@Override 
	public void run() { 
		System.out.println(Thread.currentThread().getName()+"正在执行。。。"+this.name); 
	} 
}