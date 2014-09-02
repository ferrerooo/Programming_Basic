package zcy.multithread;


/*
 *
要同步静态方法，需要一个用于整个类对象的锁，这个对象是就是这个类（XXX.class)。
例如：

public static synchronized int setName(String name){
Xxx.name = name;
}

等价于

public static int setName(String name){ 
synchronized(Xxx.class){ 
Xxx.name = name; 
} 
} 
 * 
 */

public class MT02_03SynStatic {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
