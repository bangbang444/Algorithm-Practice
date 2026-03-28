import java.util.*;
class Solution {
    public long solution(int n, int[] times) {
        
        long max = Arrays.stream(times).max().getAsInt();
        long left = 1;
        long right = max * n;  
        
        long minTime = Integer.MAX_VALUE;
        while(left <= right){
            long mid = (left + right)/2;
            long sum = 0;
            for(int time : times){
                sum += mid/time;
            }
            
            if(sum >= n){
                right = mid-1;
                minTime = mid;
            }else{
                left = mid+1;
            }
        }
        
        return minTime;
    }
}