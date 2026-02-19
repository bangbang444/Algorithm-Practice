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
        int[] answer = new int[n];
        int idx = 0;
        while(n > 0){
            fact/=n;
            int seq = (int)(k/fact);
            answer[idx++] = list.get(seq);
            list.remove(seq);
            k -= fact*seq;
            n--;
       }
        
        return answer;
    }
}