import java.util.*;

class Solution {
    public int solution(int[] elements) {
        int eleng = elements.length;
        int[] el2 = new int[eleng*2+1];
        
        for(int i = 0; i < eleng*2; i++){
            el2[i+1] = elements[i%eleng] + el2[i];
        }
        
        Set<Integer> set = new HashSet<>();
        int p1 = 0, p2 = 1;
        while(p2+eleng < el2.length){
            
            for(int i = p2; i < p2+eleng; i++){
                int sum = el2[i]-el2[p1];
                if(!set.contains(sum)) set.add(sum);
            }
            
            p1++;
            p2=p1+1;
        }
        
        return set.size();
    }
}


//[7, 9, 1, 1, 4, 7, 9, 1, 1, 4]
//[0, 7, 16, 17, 18, 22, 29, 38, 39, 40, 44]