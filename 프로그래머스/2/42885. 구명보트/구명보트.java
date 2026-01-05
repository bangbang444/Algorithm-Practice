import java.util.*;
class Solution {
    public int solution(int[] people, int limit) {
        
        // 목표: 두 수의 합이 100에 가까운 집합들로 이뤄져야한다.
        Arrays.sort(people);    
        int count = 0;
        int s = 0, e = people.length-1;
        while(s <= e){
            int std = people[s];
            int sub = people[e];
            if(std + sub > limit){
                count++;
                e--;
            }else{
                count++;
                s++;
                e--;
            }
        }
        
        return count;
    }
}

// 2 6 7 8 3
// => 2 3 6 7 8