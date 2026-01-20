import java.util.*;
class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        
        Queue<Integer> q = new LinkedList<>();
        
        int idx = 0;
        int totalW = 0;
        int time = 0;
        
        for(int i = 0; i < bridge_length; i++){
            q.offer(0);
        }
        
        while(idx < truck_weights.length){
            time++;
            totalW -= q.poll();
            
            int next = truck_weights[idx];
            if(totalW + next <= weight){
                q.offer(next);
                totalW += next;
                idx++;
            }else{
                q.offer(0);
            }
        }
        
        return time + bridge_length;
    }
}