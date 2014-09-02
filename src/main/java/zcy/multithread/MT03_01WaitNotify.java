package zcy.multithread;

public class MT03_01WaitNotify {

	public static void main(String []args){
		MyThread03011 t1 = new MyThread03011();
		t1.start();
		synchronized(t1) {			
			try {
				System.out.println("等待对象t1完成计算。。。");
				// 哪个线程的运行中，含有wait()这个调用，哪个线程就等待。 此处是main线程（ 注意，不是t1线程 ）
				// 哪个对象的wait()方法被调用，在当前线程中，就把哪个对象的对象锁释放掉 （这里把t1对象的锁释放掉）
				t1.wait();// 这句话是关键！！
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(t1.total);			
		}
     }
}

class MyThread03011 extends Thread {
    public int total=0;
    @Override
    public void run() {
    	synchronized(this){
    		for (int i=1;i<=100;i++)
    			total += i;
                        notify();
    	}
    }
}
