package zcy.multithread;

public class MT04_04Daemon {

public static void main(String []args){
        
		Thread t1 = new MyThread1116(); 	
		Thread t2 = new MyThread1117();
		t2.setDaemon(true);
		
		t2.start();
		t1.start();
     }
}

class MyThread1116 extends Thread { 
	public void run() { 
		for (int i = 0; i < 100; i++) { 
			System.out.println("线程1第" + i + "次执行！"); 
			try { Thread.sleep(1); } catch (InterruptedException e) { e.printStackTrace(); }
		} 
	} 
}
class MyThread1117 extends Thread { 
	public void run() { 
		for (int i = 0; i < 1000; i++) { 
			System.out.println("线程2第" + i + "次执行！"); 
			try { Thread.sleep(1); } catch (InterruptedException e) { e.printStackTrace(); }
		} 
	} 
}
