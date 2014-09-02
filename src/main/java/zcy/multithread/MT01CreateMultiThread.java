package zcy.multithread;

public class MT01CreateMultiThread {

	public static void main(String []args){
        
        Runnable r = new MyThread1("Runnalbe");        
        
        Thread t1 = new Thread(new MyThread1("thread-11111"));
        Thread t2 = new Thread(new MyThread1("thread-22222"));
        t1.start();
        t2.start();        
        
//        Thread t3 = new MyThread2("thread  - 3");
//        Thread t4 = new MyThread2("thread  - 4");
        Thread t3 = new MyThread2();
        Thread t4 = new MyThread2();
        t3.start();
        t4.start();
        
        Thread t5 = new Thread(r);
        Thread t6 = new Thread(r);
        t5.start();
        t6.start();
        
     }
}

class MyThread1 implements Runnable {
    private String name;
    public MyThread1(String s) {
        name = s;
    }
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) { 
            for (long k = 0; k < 100000000; k++) ; 
            System.out.println(name + ": " + i); 
        }
    }
}

class MyThread2 extends Thread {
    public MyThread2(String s) {
        super(s);
    }
    public MyThread2(){}
    @Override
    public void run() {
        for(int i = 0;i<5;i++){
            for(long k= 0; k <100000000;k++); 
            System.out.println(this.getName()+" :"+i); 
        }
    }
}