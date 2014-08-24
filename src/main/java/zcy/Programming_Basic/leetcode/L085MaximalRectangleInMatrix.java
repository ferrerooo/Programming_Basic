package zcy.Programming_Basic.leetcode;
import java.util.*;
public class L085MaximalRectangleInMatrix {
	
	
	public int maximalRectangle(char[][] matrix) {
        
        if (matrix == null || matrix.length==0 || matrix[0].length==0)
            return 0;
        
        int m = matrix.length;
        int n = matrix[0].length;
        
        int[] height = new int[n];
        int maxval = 0;
        
        for (int i=0;i<m;i++) {
            
            for (int j=0;j<n;j++) {
                if (matrix[i][j]=='0')
                    height[j] = 0;
                else
                    height[j] = height[j]+1;
            }
            
            int localval = largestRectangleArea(height);
            maxval = Math.max(maxval, localval);
            
        }
        return maxval;
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
