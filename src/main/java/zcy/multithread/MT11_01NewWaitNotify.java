package zcy.multithread;

import java.util.concurrent.ExecutorService; 
import java.util.concurrent.Executors; 
import java.util.concurrent.locks.Condition; 
import java.util.concurrent.locks.Lock; 
import java.util.concurrent.locks.ReentrantLock;

public class MT11_01NewWaitNotify {

	public static void main(String[] args) { 
		//创建并发访问的账户
		MyCount1049 MyCount1049 = new MyCount1049("95599200901215522", 10000); 
		//创建一个线程池
		ExecutorService pool = Executors.newFixedThreadPool(2); 
		Thread t1 = new SaveThread1("张三", MyCount1049, 2000); 
		Thread t2 = new SaveThread1("李四", MyCount1049, 3600); 
		Thread t3 = new DrawThread1("王五", MyCount1049, 2700); 
		Thread t4 = new SaveThread1("老张", MyCount1049, 600); 
		Thread t5 = new DrawThread1("老牛", MyCount1049, 1300); 
		Thread t6 = new DrawThread1("胖子", MyCount1049, 800); 
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

class SaveThread1 extends Thread { 
	private String name; //操作人 
	private MyCount1049 MyCount1049; //账户 
	private int x; //存款金额 
	
	SaveThread1(String name, MyCount1049 MyCount1049, int x) { 
		this.name = name; 
		this.MyCount1049 = MyCount1049; 
		this.x = x; 
	} 
	public void run() { 
		MyCount1049.saving(x, name); 
	} 
}
class DrawThread1 extends Thread { 
	private String name; //操作人 
	private MyCount1049 MyCount1049; //账户
	private int x; //存款金额 
	DrawThread1(String name, MyCount1049 MyCount1049, int x) { 
		this.name = name; 
		this.MyCount1049 = MyCount1049; 
		this.x = x; 
	} 
	public void run() { 
		MyCount1049.drawing(x, name); 
	} 
}

class MyCount1049 { 
	private String oid; //账号 
	private int cash; //账户余额 
	private Lock lock = new ReentrantLock(); //账户锁 
	private Condition _save = lock.newCondition(); //存款条件 
	private Condition _draw = lock.newCondition(); //取款条件 
	MyCount1049(String oid, int cash) { 
		this.oid = oid; 
		this.cash = cash; 
	} 
	
	public void saving(int x, String name) { 
		lock.lock(); //获取锁
		if (x > 0) { 
			cash += x; //存款 
			System.out.println(name + "存款" + x + "，当前余额为" + cash); 
		} 
		_draw.signalAll(); //唤醒所有等待线程。 
		lock.unlock(); //释放锁 
	}

	public void drawing(int x, String name) { 
		lock.lock(); //获取锁 
		try { 
			if (cash - x < 0) { 
				_draw.await(); //阻塞取款操作 
			} else { 
				cash -= x; //取款 
				System.out.println(name + "取款" + x + "，当前余额为" + cash); 
			} 
			_save.signalAll(); //唤醒所有存款操作      .. 这里对吗？？  不是_draw.signalAll()吗？？
		} catch (InterruptedException e) { 
			e.printStackTrace(); 
		} finally { 
			lock.unlock(); //释放锁
		} 
	}
}

