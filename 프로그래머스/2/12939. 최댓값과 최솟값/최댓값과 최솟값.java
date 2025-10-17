import java.util.*;

class Solution {
    public String solution(String s) {
        StringTokenizer st = new StringTokenizer(s);
        
        int max = -99999999;;
        int min = 999999999;
        while(st.hasMoreTokens()){
            int v = Integer.parseInt(st.nextToken());
            max = Math.max(v, max);
            min = Math.min(v, min);
        }
        
        StringBuilder answer = new StringBuilder();
        answer.append(min).append(" ").append(max);
        
        return answer.toString();
    }
}