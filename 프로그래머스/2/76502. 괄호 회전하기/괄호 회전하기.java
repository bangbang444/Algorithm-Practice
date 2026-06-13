import java.util.*;
class Solution {
    public int solution(String s) {    
        char[] chs = s.toCharArray();
        int count = 0;
        for(int start = 0; start < chs.length; start++){
            Stack<Character> stack = new Stack<>();
            for(int i = 0; i < chs.length; i++){
                char ch = chs[(start+i)%chs.length];
                
                if(stack.isEmpty()){
                    stack.push(ch);
                    continue;
                }
                
                char top = stack.peek();
                
                if((top == '[' && ch == ']') || (top == '{' && ch == '}') || (top == '(' && ch == ')')){
                    stack.pop();
                }else{
                    stack.push(ch);
                }
            }
            if(stack.isEmpty()) count++;
        }
        
        return count;
    }
}