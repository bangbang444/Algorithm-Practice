import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int count = 0;
        int[] m = new int[31]; // 0 초기화
        Arrays.fill(m, 1);
        Arrays.sort(lost);
        Arrays.sort(reserve);
        
        for(int r : reserve){
            m[r] += 1;
        }
        for(int l : lost){
            m[l] -= 1;
        }
        
        for(int i = 0; i < lost.length; i++){
            
            // 잃어버린 사람
            int l = lost[i];
            
            //lost 동시 reserve
            if(m[l] == 1){ 
                count++;
                continue;
            }
            
            if(m[l-1] == 2){
                m[l-1] = 1;
                count++;
                continue;
            }
            
            if(m[l+1] == 2){
                m[l+1] = 1;
                count++;
                continue;
            }
        }
        
        
        return n - lost.length + count;
    }
}

/*
n:7
[2, 4]
[1, 2, 3, 4, 5]

*/