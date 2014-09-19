package zcy.multithread;
import java.util.concurrent.ExecutorService; 
import java.util.concurrent.Executors; 
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
public class MT12_02Atomic {

	public static void main(String[] args) { 
		ExecutorService pool = Executors.newFixedThreadPool(2); 
		Lock lock = new ReentrantLock();
		Runnable t1 = new MyRunnable1("张三", 2000, lock); 
		Runnable t2 = new MyRunnable1("李四", 3600, lock); 
		Runnable t3 = new MyRunnable1("王五", 2700, lock); 
		Runnable t4 = new MyRunnable1("老张", 600, lock); 
		Runnable t5 = new MyRunnable1("老牛", 1300, lock); 
		Runnable t6 = new MyRunnable1("胖子", 800,lock); 
		//执行各个线程 
		pool.execute(t1); 
		pool.execute(t2); 
		pool.execute(t3); 
		pool.execute(t4); 
		pool.execute(t5); 
		pool.execute(t6); 
		//关闭线程池
		pool.shutdown(); 
	}

}

class MyRunnable1 implements Runnable { 
	private static AtomicLong aLong = new AtomicLong(10000); 
	//原子量，每个线程都可以自由操作 
	private String name; 
	//操作人 
	private int x; 
	//操作数额
	private Lock lock; 
	MyRunnable1(String name, int x,Lock lock) { 
		this.name = name; 
		this.x = x; 
		this.lock = lock; 
	} 
	public void run() { 
		lock.lock(); 
		System.out.println(name + "执行了" + x + "，当前余额：" + aLong.addAndGet(x)); 
		lock.unlock(); 
		} 
	}
