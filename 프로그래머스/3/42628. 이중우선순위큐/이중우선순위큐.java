import java.util.*;
class Solution {
    public int[] solution(String[] operations) {
        TreeMap<Integer, Integer> map1 = new TreeMap<>();
        TreeMap<Integer, Integer> map2 = new TreeMap<>(Collections.reverseOrder());
        
        int[] answer = {0, 0};
        for(String op : operations){
            int num = Integer.parseInt(op.split(" ")[1]);
            boolean isAdd = false;
            if(op.startsWith("D")){
                isAdd = false;
            }else if(op.startsWith("I")){
                isAdd = true;
            }
            
            if(isAdd){
                map1.put(num, map1.getOrDefault(num, 0)+1);
                map2.put(num, map2.getOrDefault(num, 0)+1);
            }else if(num == 1){
                if(map2.size() == 0) continue;
                int max = map2.firstKey();
                if(map2.getOrDefault(max, 1) == 1){
                    map1.remove(max);
                    map2.remove(max);
                }else{
                    map1.put(num, map1.getOrDefault(max, 1)-1);
                    map2.put(num, map2.getOrDefault(max, 1)-1);
                }            
            }else if(num == -1){
                if(map1.size() == 0) continue;
                int min = map1.firstKey();
                if(map1.getOrDefault(min, 1) == 1){
                    map1.remove(min);
                    map2.remove(min);
                }else{
                    map1.put(num, map1.getOrDefault(min, 1)-1);
                    map2.put(num, map2.getOrDefault(min, 1)-1);
                }
            }
        }
        
        if(map1.size() == 1){
            Integer key = map1.firstKey();
            answer = new int[]{key, key};
        }else if(map1.size() == 0){
            answer = new int[]{0, 0};
        }else{
            Integer min = map1.firstKey();
            Integer max = map2.firstKey();
            answer = new int[]{max, min};
        }
        
        return answer;
    }
}