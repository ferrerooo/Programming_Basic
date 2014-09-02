package zcy.multithread;

/*
1）    只能同步方法，而不能同步变量和类；

2）、每个对象只有一个锁；当提到同步时，应该清楚在什么上同步？也就是说，在哪个对象上同步？

3）、不必同步类中所有的方法，类可以同时拥有同步和非同步方法。

4）、如果两个线程要执行一个类中的synchronized方法，并且两个线程使用相同的实例来调用方法，那么一次只能有一个线程能够执行方法，另一个需要等待，直到锁被释放。也就是说：如果一个线程在对象上获得一个锁，就没有任何其他线程可以进入（该对象的）类中的任何一个同步方法。

5）、如果线程拥有同步和非同步方法，则非同步方法可以被多个线程自由访问而不受锁的限制。

6）、线程睡眠时，它所持的任何锁都不会释放。

7）、线程可以获得多个锁。比如，在一个对象的同步方法里面调用另外一个对象的同步方法，则获取了两个对象的同步锁。

8）、同步损害并发性，应该尽可能缩小同步范围。同步不但可以同步整个方法，还可以同步方法中一部分代码块。

9）、在使用同步代码块时候，应该指定在哪个对象上同步，也就是说要获取哪个对象的锁。
 * */


// 这个例子是有点问题的。权且假设两个线程共享foo对象吧。
public class MT02_02Syn {

	public static void main(String []args){
        System.out.println("Hello World");
        
        MyThread021 t = new MyThread021();
        
        Thread t1 = new Thread(t, "t1");
        Thread t2 = new Thread(t, "t2");
        t1.start();
        t2.start();
     }
}

class MyThread021 implements Runnable {
    
    private Foo foo = new Foo();
    
    public void run() {
        for (int i = 0; i < 5000; i++) { 
            foo.deduct(1);
            try { 
                Thread.sleep(1); 
            } catch (InterruptedException e) { 
                e.printStackTrace(); 
            } 
            System.out.println(Thread.currentThread().getName()+":x="+foo.getX());
        }
    }
}
class Foo{
    private int x = 10000;

    //  public synchronized void deduct(int y) {
    //  x = x- y;
    //}
    public void deduct(int y) {
    	synchronized(this){
    		x = x- y;
    	}
    }

    public int getX(){
        return x;
    }
}
