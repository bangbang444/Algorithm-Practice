import java.util.*;
class Solution {
    int[] numCount;
    public int solution(int[] citations) {
        // [0, 1, 3, 5, 6]
        int answer = 0;
        Arrays.sort(citations);
        int n = citations.length;
        
        for(int i = 0; i < n; i++){
            int h = n-i;
            
            if(citations[i] >= h){
                answer = h;
                break;
            }
        }
        
        return answer;
    }
}