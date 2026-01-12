import java.util.*;
class Solution {
    public int[] solution(String msg) {
        Map<String, Integer> map = new HashMap<>();
        for(int i = 0; i < 26; i++){
            map.put(String.valueOf((char)(65+i)), i+1);
        }
        List<Integer> ans = new ArrayList<>();
        
        StringBuilder part = new StringBuilder();
        int lastIdx = 27;
        int idx = 0;
        while(idx < msg.length()){
            int p = 1;
            String sub = msg.substring(idx, idx+p);
            while(map.get(sub) != null && idx+p < msg.length()){
                p++;
                sub = msg.substring(idx, idx+p);
            }
            
            if(sub.length() > 1 && map.get(sub) == null){
                map.putIfAbsent(sub, lastIdx++);
                ans.add(map.get(sub.substring(0, sub.length()-1)));
                idx+=sub.length()-1;
            }else{
                ans.add(map.get(sub));
                if(sub.length() > 1){
                    idx += sub.length()-1;
                }
                idx++;
            }
        }
        
        int[] answer = new int[ans.size()];
        for(int i = 0; i < ans.size(); i++){
            answer[i] = ans.get(i);
        }
        
        return answer;
    }
}