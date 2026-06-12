import java.util.*;
class Solution {
    public int solution(int[] d, int budget) {
        Arrays.sort(d);
        int leftBudget = budget;
        int count = 0;
        for(int i = 0; i < d.length; i++){
            if(leftBudget - d[i] >= 0){
                leftBudget -= d[i];
                count++;
            }
        }
        
        return count;
    }
}