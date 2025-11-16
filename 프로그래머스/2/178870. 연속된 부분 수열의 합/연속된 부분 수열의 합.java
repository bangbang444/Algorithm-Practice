import java.util.*;
class Solution {
    public int[] solution(int[] sequence, int k) {
        
        int start = 0;
        int end = sequence.length-1;
        
        int sum = 0;
        for(int i = 0; i < sequence.length; i++){
            sum += sequence[i];
        }
        
        int[] answer = new int[]{0, sequence.length-1};
        while(start <= end && end < sequence.length){
            if(sum == k && end-start < answer[1] - answer[0]){
                answer = new int[]{start, end};
                
                sum-=sequence[start];
                start++;
                continue;
            }
            
            if(sum > k){
                sum-=sequence[end];
                end-=1;
            }else{
                sum-=sequence[start];
                start+=1;
                if(end+1 >= sequence.length) break;
                end+=1;
                sum+=sequence[end];
                
            }
            
        }
        
        return answer;
    }
}