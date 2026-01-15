import java.util.*;
class Solution {
    public int solution(int[] scoville, int K) {
        
        PriorityQueue<Integer> scovilles = new PriorityQueue<>();
        for(int s : scoville){
            scovilles.offer(s);
        }
        int count = 0;
        while(scovilles.size() >= 2){
            
            if(scovilles.peek() >= K) break;
            
            Integer food1 = scovilles.poll();
            Integer food2 = scovilles.poll();
            scovilles.offer(food1 + food2*2);
            count++;
        }
        
        if(scovilles.size() == 1 && scovilles.peek() < K) count = -1;
        
        return count;
    }
}