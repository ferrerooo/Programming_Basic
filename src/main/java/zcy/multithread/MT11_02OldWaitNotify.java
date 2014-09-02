package zcy.multithread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MT11_02OldWaitNotify {

	public static void main(String[] args) { 
		//创建并发访问的账户
		MyCount1104 MyCount1104 = new MyCount1104("95599200901215522", 10000); 
		//创建一个线程池
		ExecutorService pool = Executors.newFixedThreadPool(2); 
		Thread t1 = new SaveThread("张三", MyCount1104, 2000); 
		Thread t2 = new SaveThread("李四", MyCount1104, 3600); 
		Thread t3 = new DrawThread("王五", MyCount1104, 2700); 
		Thread t4 = new SaveThread("老张", MyCount1104, 600); 
		Thread t5 = new DrawThread("老牛", MyCount1104, 1300); 
		Thread t6 = new DrawThread("胖子", MyCount1104, 800); 
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

class SaveThread extends Thread { 
	private String name; //操作人 
	private MyCount1104 MyCount1104; //账户 
	private int x; //存款金额 
	
	SaveThread(String name, MyCount1104 MyCount1104, int x) { 
		this.name = name; 
		this.MyCount1104 = MyCount1104; 
		this.x = x; 
	} 
	public void run() { 
		MyCount1104.saving(x, name); 
	} 
}
class DrawThread extends Thread { 
	private String name; //操作人 
	private MyCount1104 MyCount1104; //账户
	private int x; //存款金额 
	DrawThread(String name, MyCount1104 MyCount1104, int x) { 
		this.name = name; 
		this.MyCount1104 = MyCount1104; 
		this.x = x; 
	} 
	public void run() { 
		MyCount1104.drawing(x, name); 
	} 
}

class MyCount1104 { 
	private String oid; //账号 
	private int cash; //账户余额
	MyCount1104(String oid, int cash) { 
		this.oid = oid; this.cash = cash; 
	} 

	public synchronized void saving(int x, String name) { 
		if (x > 0) { 
			cash += x; //存款
			System.out.println(name + "存款" + x + "，当前余额为" + cash); 
		} 
		notifyAll(); //唤醒所有等待线程。
	}
	
	public synchronized void drawing(int x, String name) { 
		if (cash - x < 0) { 
			try { 
				wait(); 
			} catch (InterruptedException e1) { 
				e1.printStackTrace(); 
			} 
		} else { 
			cash -= x; //取款 
			System.out.println(name + "取款" + x + "，当前余额为" + cash); 
		} 
		notifyAll(); //唤醒所有存款操作 
	} 
}
	
