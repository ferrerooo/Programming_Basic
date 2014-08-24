package zcy.Programming_Basic.leetcode;
import java.util.*;
public class L084LargestRectangle {

	public static void main(String[] args) {
		
		L084LargestRectangle l = new L084LargestRectangle();
		int[] height = {1,1};
		System.out.println(l.largestRectangleArea(height));
	}
	
	public int largestRectangleArea(int[] height) {
        
        if (height == null || height.length == 0)
            return 0;
        
        Stack<Integer> stack = new Stack<Integer>();
        int maxArea = 0;
        
        for (int i=0;i<height.length; i++) {
            
            if (stack.isEmpty() || height[i]>=height[stack.peek()])
                stack.push(i);
            else {
                
                while (!stack.isEmpty()&&height[i]<height[stack.peek()]) {
                    int h = height[stack.pop()];
                    int w = stack.isEmpty() ? i : (i-stack.peek()-1);
                    maxArea = Math.max(maxArea, w*h);
                }
                stack.push(i);
            }
        }
        
        while (!stack.isEmpty() ) {
            int h = height[stack.pop()];
            int w = stack.isEmpty()? height.length : (height.length-stack.peek()-1);
            maxArea = Math.max(maxArea, w*h);
        }
        
        return maxArea;
    }

}
