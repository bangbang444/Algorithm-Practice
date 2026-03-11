import java.util.*;
class Solution {
    public int solution(int[] d, int budget) {
        Arrays.sort(d);
        int use = 0;
        int count = 0;
        for(int m : d){
            if(use + m <= budget){
                use += m;
                count++;
            }else break;
        }
        
        return count;
    }
}