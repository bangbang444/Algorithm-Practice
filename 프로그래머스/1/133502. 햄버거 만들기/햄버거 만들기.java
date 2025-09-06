import java.util.*;

class Solution {
    public int solution(int[] ingredient) {
        
        Stack<Integer> stack = new Stack<>();
        int count = 0;
        int answer = 0;
        
        for(int i : ingredient){
            if(stack.isEmpty()){
                stack.push(i);
                continue;
            }

            if(i == 1 && stack.size() >= 3){
                int third = stack.pop();
                int second = stack.pop();
                int first = stack.pop();
                if(first == 1 && second == 2 && third == 3) count++;
                else{
                    stack.push(first);
                    stack.push(second);
                    stack.push(third);
                    stack.push(i);
                }
                continue;
            }
            
            stack.push(i);
        }
        
        return count;
    }
}