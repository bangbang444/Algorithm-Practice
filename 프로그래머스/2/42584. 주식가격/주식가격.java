import java.util.*;
class Solution {
    public int[] solution(int[] prices) {

        int pl = prices.length;
        int[] answer = new int[pl];
        
        for(int i = 0; i < pl; i++){
            int count = 0;
            int cur = prices[i];
            for(int j = i+1; j < pl; j++){
                count++;
                if(prices[i] > prices[j]){
                    break;
                }
                
            }
            answer[i] = count;
        }
        
        
        return answer;
    }
}