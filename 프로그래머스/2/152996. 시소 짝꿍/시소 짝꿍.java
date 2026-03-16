import java.util.*;
class Solution {
    public long solution(int[] weights) {
        Map<Integer, Long> map = new HashMap<>();
        long answer = 0;
        
        Arrays.sort(weights);
        
        for(int w : weights){
            answer += map.getOrDefault(w, 0L);
            answer += map.getOrDefault(w * 2/3, 0L) * (w%3==0 ? 1: 0);
            answer += map.getOrDefault(w * 3/4, 0L) * (w%4==0 ? 1: 0);
            answer += map.getOrDefault(w / 2, 0L) * (w%2==0 ? 1: 0);
            
            map.put(w, map.getOrDefault(w,0L)+1);
        }
        
        return answer;
    }
}