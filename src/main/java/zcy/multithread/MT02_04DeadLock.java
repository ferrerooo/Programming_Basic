package zcy.multithread;

public class MT02_04DeadLock {

	public static void main(String []args){
        System.out.println("Hello World");
        
        A a = new A();
        B b = new B();
        
        Thread t1 = new Thread(new MyThread02031(a,b));
        Thread t2 = new Thread(new MyThread02032(a,b));
        
        t1.start();
        t2.start();
     }
}

class MyThread02031 implements Runnable {
    
    private A a;
    private B b;
    
    public MyThread02031(A _a, B _b) {
    	a = _a;
    	b = _b;
    }
    public void run() {
    	try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
    	synchronized(a){
    		synchronized(b){
    			System.out.println("11111");
    		}
    	}
    }    
}
class MyThread02032 implements Runnable {
	private A a;
	private B b;
	
	public MyThread02032(A _a, B _b) {
		a = _a;
		b = _b;
	}
	public void run() {
		synchronized(b){
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
    		synchronized(a){
    			System.out.println("22222");
    		}
    	}
	}
}

class A{ }
class B{ }