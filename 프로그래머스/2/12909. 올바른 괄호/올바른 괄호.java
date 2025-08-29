import java.util.*;

class Solution {
    boolean solution(String s) {
        boolean answer = true;
        
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++){
            
            Character cur = s.charAt(i);
            if(stack.isEmpty()){stack.push(cur); continue;}
            
            if(stack.peek() == '(' && cur == ')') stack.pop();
            else stack.push(cur);
        }
        
        return stack.isEmpty();
    }
}