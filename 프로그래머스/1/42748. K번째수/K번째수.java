import java.util.*;
class Solution {
    public int[] solution(int[] array, int[][] commands) {
        
        int[] answer = new int[commands.length];
        int idx = 0;
        for(int[] cmd : commands){
            int a = cmd[0]-1;
            int b = cmd[1];
            int c = cmd[2]-1;
            
            int[] newArr = Arrays.copyOfRange(array, a, b);
            Arrays.sort(newArr);
            
            answer[idx++] = newArr[c]; 
        }
        return answer;
    }
}