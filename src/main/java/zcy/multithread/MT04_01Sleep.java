package zcy.multithread;

public class MT04_01Sleep {

public static void main(String []args){
        
		Thread t1 = new MyThread1111(); 
		Thread t2 = new Thread(new MyRunnable()); 
		t1.start(); 
		t2.start();
     }
}

class MyThread1111 extends Thread { 
	public void run() { 
		for (int i = 0; i < 3; i++) { 
			System.out.println("线程1第" + i + "次执行！"); 
			try { 
				Thread.sleep(50); 
			} catch (InterruptedException e) { 
				e.printStackTrace(); 
			} 
		} 
	} 
}

class MyRunnable implements Runnable {
	public void run() { 
		for (int i = 0; i < 3; i++) { 
			System.out.println("线程2第" + i + "次执行！"); 
			try { 
				Thread.sleep(50); 
			} catch (InterruptedException e) { 
				e.printStackTrace(); 
			} 
		} 
	} 
}
