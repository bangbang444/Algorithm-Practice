import java.util.*;

public class Solution {
    public int solution(int n) {
                
        int sum = 0;
        int l = 10;
        while(n > 0){
            sum+=n%l;
            n/=10;
        }

        return sum;
    }
}