package zcy.Programming_Basic.leetcode;
import java.util.*;
public class L138LRUCache {

	public static void main(String[] args) {
		
		L138LRUCache l = new L138LRUCache(1);
		//set(2,1),get(2),set(3,2),get(2),get(3)
		
		l.set(2, 1);
		l.get(2);
		l.set(3, 2);
		l.get(2);
		l.get(3);
	}
	
	class Node {
        int key;
        int value;
        Node next;
        Node pre;
        public Node(int k, int v) {
            this.key = k;
            this.value = v;
            this.next = null;
            this.pre = null;
        }
    }
    
    private int cap;
    private Hashtable<Integer, Node> ht;
    private Node head;
    private Node tail;
    
    public L138LRUCache(int capacity) {
        this.cap = capacity;
        ht = new Hashtable<Integer, Node>();
        head = new Node(0, 0);
        tail = new Node(0,0);
        head.next = tail;
        tail.pre = head;
    }
    
    public int get(int key) {
        if (!ht.containsKey(key))
            return -1;
        else {
            Node cur = ht.get(key);
            
            cur.pre.next = cur.next;
            cur.next.pre = cur.pre;
            Node temp = head.next;
            head.next = cur;
            cur.pre = head;
            cur.next = temp;
            temp.pre = cur;

            return cur.value;
        }
    }
    
    public void set(int key, int value) {
        
        if (ht.containsKey(key)) {
            Node cur = ht.get(key);
            // update hashtable
            cur.value = value;
            ht.put(key, cur);
            // update double linked list
            cur.pre.next = cur.next;
            cur.next.pre = cur.pre;
            Node temp = head.next;
            head.next = cur;
            cur.pre = head;
            cur.next = temp;
            temp.pre = cur;
        } else {
            Node newnode = new Node(key, value);
            ht.put(key, newnode);
            Node temp = head.next;
            head.next = newnode;
            newnode.pre = head;
            newnode.next = temp;
            temp.pre = newnode;
            
            if (ht.size()>this.cap) {
                //delete ht
                Node del = tail.pre;
                ht.remove(del.key);
                //delete double linked list
                del.pre.next = del.next;
                del.next.pre = del.pre;
            }
        }
    }
}
