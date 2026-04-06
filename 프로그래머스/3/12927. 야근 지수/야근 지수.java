import java.util.*;
class Solution {
    public long solution(int n, int[] works) {
        List<Integer> list = new ArrayList<>();
        for(int w : works){
            list.add(w);
        }
        Collections.sort(list, Collections.reverseOrder());
        
        int idx = 0;
        while(n > 0 && list.get(0) != 0){
            int cur = list.get(idx);
            int next = idx+1 < list.size() ? list.get(idx+1) : -1;
            
            if(cur == next && idx < list.size()){
                idx = idx+1 >= list.size() ? idx : idx+1;
                continue;
            }else{
                while(n > 0 && idx >= 0 && list.get(idx)-1 >= 0){
                    list.set(idx, list.get(idx)-1);
                    idx--;
                    n--;
                }
                idx = idx < 0 ? 0 : idx;
                continue;
            }
        }
        
        long answer = 0;
        for(int w : list){
            answer += w*w;
        }
        
        return answer;
    }
}