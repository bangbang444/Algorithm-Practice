import java.util.*;
class Solution {
    public int solution(int[][] board, int[] moves) {
        
        Stack<Integer> stack = new Stack<>();
        
        for(int move : moves){ // 뽑은 곳
            move = move-1;
            for(int i = 0; i < board.length; i++){
                if(board[i][move] != 0){
                    stack.add(board[i][move]);
                    board[i][move] = 0;
                    break;
                }
            }
        }
        
        int score = 0;
        Stack<Integer> stack2 = new Stack<>();
        while(!stack.isEmpty()){
            
            int poll = stack.pop();
            
            if(stack2.isEmpty()){
                stack2.push(poll);
                continue;
            }
            
            if(poll == stack2.peek()){
                stack2.pop();
                score+=2;
                continue;
            }
            
            stack2.push(poll);
        }
        
        
        
        
        return score;
    }
}