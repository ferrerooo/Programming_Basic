package zcy.Programming_Basic.cc150;


public class CC0301UseArrayToBuildStack {

	public static void main(String[] args) {
		CC0301UseArrayToBuildStack t = new CC0301UseArrayToBuildStack(10,4);
        try {
            t.push(1, 11);
            t.push(1, 12);
            t.push(2, 21);
            t.push(3, 31);
            t.push(3, 32);
            t.push(2, 22);
            t.push(1, 13);
            System.out.println(  t.pop(1) );            
            System.out.println(t.pop(1));
            System.out.println(t.pop(1));
            
            System.out.println(  t.pop(3) );            
            System.out.println(t.pop(3));
        } catch (Exception e) {
            e.printStackTrace();
        }

	}
	
	int capacity;
	Node[] array;
	int freeListTop;
	int[] stackTop;
	
	public CC0301UseArrayToBuildStack(int c, int snum) {
		capacity = c;
		array = new Node[capacity];
		freeListTop = 0;
		stackTop = new int[snum];
		
		for (int i=0;i<array.length; i++) {
			array[i] = new Node(0, i+1);
		}
		for (int i=0;i<stackTop.length; i++)
			stackTop[i] = -1;
		
	}
	
	public void push(int stackNum, int value) {
		if (freeListTop == capacity)
			throw new RuntimeException("no space for new data");
		Node node = new Node(value, stackTop[stackNum]);
		int nextFreeListNode = array[freeListTop].pre;
		array[freeListTop] = node;
		stackTop[stackNum] = freeListTop;
		freeListTop = nextFreeListNode;
		return;
	}
	public int pop(int stackNum) {
		if (stackTop[stackNum] == -1)
			throw new RuntimeException("no data in this stack");
		int nextStackTop = array[stackTop[stackNum]].pre;
		int returnValue = array[stackTop[stackNum]].val;
		array[stackTop[stackNum]].pre = freeListTop;
		freeListTop = stackTop[stackNum];
		stackTop[stackNum] = nextStackTop;
		return returnValue;
	}
	public int peek(int stackNum) {
		if (stackTop[stackNum] == -1)
			throw new RuntimeException("no data in this stack");
		return array[stackTop[stackNum]].val;
	}
	public boolean isEmpty(int stackNum) {
		if (stackTop[stackNum] == -1)
			return true;
		else
			return false;
	}
	

}

class Node {
	int val;
	int pre;
	public Node(int _val, int _pre) {
		this.val = _val;
		this.pre = _pre;
	}
}
