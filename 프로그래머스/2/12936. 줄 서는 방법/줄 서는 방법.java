import java.util.*;
class Solution {
    public int[] solution(int n, long k) {
        List<Integer> list = new ArrayList<>();
        long fact = 1;
        for(int i = 1; i <= n; i++){
            list.add(i);
            fact *= i;
        }
        
        k--;
        int N = n;
        int[] answer = new int[N];
        int idx = 0;
        while(N > 0){
            fact/=N;
            int seq = (int)(k/fact);
            
            
            
            answer[idx++] = list.get(seq);
            list.remove(seq);
            k-= fact*seq;
            N--;
       }
        
        return answer;
    }
}