package zcy.multithread;

public class MT03_01WaitNotify {

	public static void main(String []args){
		MyThread03011 t1 = new MyThread03011();
		t1.start();
		synchronized(t1) {			
			try {
				System.out.println("等待对象t1完成计算。。。");
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
