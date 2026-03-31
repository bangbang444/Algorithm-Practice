import java.util.*;
class Solution {
    // [진입, 탈출]
    public int solution(int[][] routes) {
        int count = 1;
        Arrays.sort(routes, (a,b) -> {
            if(a[0] != b[0])
                return a[0] - b[0];
            return a[1] - b[1];
        });
        
        int seq = 1;
        int std = routes[0][1];
        while(seq < routes.length){
            int curS = routes[seq][0];
            int curE = routes[seq][1];
            if(curS > std){
                std = curE;
                count++;
            }else if(curE < std){
                std = curE;
            }
            seq++;
        }
        
        return count;
    }
}