import java.util.*;

class Solution {
    public long solution(long n) {
        List<Long> list = new ArrayList<>();
        int length = 0;
        while(n > 0){
            list.add(n%10);
            n/=10;
        }
        Collections.sort(list, Collections.reverseOrder());
        
        String number = "";
        for(long l : list){
            number+=l;
        }
        
        return Long.parseLong(number);
    }
}