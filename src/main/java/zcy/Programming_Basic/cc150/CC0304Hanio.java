package zcy.Programming_Basic.cc150;
import java.util.*;
public class CC0304Hanio {

	public static void main(String[] args) {
		
		Tower t1 = new Tower("t1");
		Tower t2 = new Tower("t2");
		Tower t3 = new Tower("t3");
		
		int n=3;
		
		for (int i=n; i>=1; i--) {
			t3.stack.push(i);
		}
		
		CC0304Hanio.recur(t3, t1, t2, n);
	}
	
	private static void recur(Tower res, Tower tar, Tower buf, int n) {
		
		if (n==1) {
			System.out.println("The panel "+res.stack.peek() + " is moved from "+res.name+" to "+tar.name+" via "+buf.name);
			tar.stack.push(res.stack.pop());	
			return;
		}
		
		CC0304Hanio.recur(res, buf, tar, n-1);
		System.out.println("The panel "+res.stack.peek() + " is moved from "+res.name+" to "+tar.name+" via "+buf.name);
		tar.stack.push(res.stack.pop());
		CC0304Hanio.recur(buf, tar, res, n-1);
	}
}

class Tower {
	String name;
	Stack<Integer> stack;
	public Tower(String _name) {
		this.name = _name;
		this.stack = new Stack<Integer>();
	}
}
