// 최소 이동거리 구하기
//
import java.util.*;
class Solution {
    int dTotal, pTotal;
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        dTotal = Arrays.stream(deliveries).sum();
        pTotal = Arrays.stream(pickups).sum();
    
        long distTotal = 0;
        int dStart = deliveries.length-1;
        int pStart = pickups.length-1;
        while(dTotal + pTotal > 0){
            
            // 배달
            int distD = 0;
            int leftCap = cap;
            while(leftCap > 0 && dTotal != 0){
                for(int i = dStart; i >= 0; i--){
                    if(deliveries[i] != 0){
                        int change = Math.min(leftCap, deliveries[i]);
                        deliveries[i] -= change;
                        dTotal -= change;
                        leftCap -= change;
                        distD = Math.max(distD, i+1);
                    }
                    if(leftCap == 0) break;
                }
            }
            // 픽업
            int distP = 0;
            leftCap = cap;
            while(leftCap > 0 && pTotal != 0){
                for(int i = pStart; i >= 0; i--){
                    if(pickups[i] != 0){
                        int change = Math.min(leftCap, pickups[i]);
                        pickups[i] -= change;
                        pTotal -= change;
                        distP = Math.max(distP, i+1);
                        leftCap -= change;
                    }
                    if(leftCap == 0) break;
                }
            }
            dStart = distD-1;
            pStart = distP-1;
            distTotal += Math.max(distP, distD)*2;
        }
        
        
        
        return distTotal;
    }
}