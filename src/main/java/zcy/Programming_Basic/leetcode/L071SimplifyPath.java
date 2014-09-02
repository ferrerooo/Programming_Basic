package zcy.Programming_Basic.leetcode;
import java.util.*;
public class L071SimplifyPath {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public String simplifyPath(String path) {
        
        Stack<Character> stack = new Stack<Character>();
        
        for (int i=0;i<path.length();i++) {
            
            if (path.charAt(i) == '/') {
                
                if (stack.isEmpty() || stack.peek() != '/')
                    stack.push('/');
                
            } else if (path.charAt(i) != '.' ) {
                stack.push(path.charAt(i));
            } else {
                
                if (stack.peek() !='/')
                    stack.push('.');
                else {
                    
                    if (path.length()-1 == i) {
                        continue;
                    } else if (path.charAt(i+1) == '/') {
                        continue;
                    } else if (path.charAt(i+1)=='.' && path.length()-1 == i+1) {
                        if (stack.size() == 1)
                            break;
                        else {
                            stack.pop();
                            while (stack.peek()!='/')
                                stack.pop();
                            break;
                        }
                    } else if (path.charAt(i+1)=='.' && path.charAt(i+2)=='/') {
                        if (stack.size() == 1)
                            i++;
                        else {
                            stack.pop();
                            while (stack.peek()!='/')
                                stack.pop();
                            i++;
                        }
                    } else {
                        stack.push('.');
                    }
                    
                    
                }
                
            }
            
        }
        
        if (stack.size()>1 &&stack.peek() == '/')
            stack.pop();
        
        StringBuilder sb = new StringBuilder();
        
        while (!stack.isEmpty())
            sb.append(stack.pop());
        
        return sb.reverse().toString();
        
    }

}
