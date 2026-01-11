import java.util.*;
class Solution {
    public int solution(int k, int[] tangerine) {
        int[] value = new int[10000001];
        for(int t : tangerine){
            value[t]++;
        }
        Arrays.sort(value);
        
        int count = 0;
        int total = 0;
        for(int i = value.length-1; i >=0; i--){
            if(total + value[i] < k){
                total+=value[i];
                count++;
            }else break;
        }
        
        return count+1;
    }
}