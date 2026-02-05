// 백트래킹은 시간 초과
import java.util.*;
class Solution {
    int aMin = Integer.MAX_VALUE;
    Set<List<Integer>> set = new HashSet<>();
    public int solution(int[][] info, int n, int m) {
        
        steal(info, 0, 0, n, m, 0);
        
        return aMin == Integer.MAX_VALUE ? -1 : aMin;
    }
    public void steal(int[][] info, int aSum, int bSum, int n, int m, int seq){
        if(aSum >= n || bSum >= m) return;
        if(aSum >= aMin) return;
        if(set.contains(Arrays.asList(seq, aSum, bSum))) return;
        if(seq >= info.length){
            if(aSum < aMin){
                aMin = aSum;
            }
            return;
        }
        set.add(Arrays.asList(seq, aSum, bSum));
        
        steal(info, aSum+info[seq][0], bSum, n, m, seq+1);
        steal(info, aSum, bSum+info[seq][1], n, m, seq+1);
    }
}