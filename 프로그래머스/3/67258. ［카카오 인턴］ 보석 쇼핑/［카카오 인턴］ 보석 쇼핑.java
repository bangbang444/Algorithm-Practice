import java.util.*;
class Solution {
    public int[] solution(String[] gems) {
        Map<String, Integer> gemNums = new HashMap<>();
        int num = 0;
        for(String gem : gems){
            if(!gemNums.containsKey(gem)){
                gemNums.put(gem, num++);
            }
        }        
        
        int[] numsGem = new int[num];
        Set<String> set = new HashSet<>();
        int left = 0;
        int right = 0;
        int[] answer = {0, Integer.MAX_VALUE};
        boolean change = true;
        while(change){
            change = false;
            while(right < gems.length && set.size() < gemNums.size()){
                String cur = gems[right];
                set.add(cur);
                numsGem[gemNums.get(cur)]++;
                right++;
                change = true;
            }
            if(set.size() == gemNums.size() && answer[1]-answer[0] > right-(left+1)){
                answer = new int[]{left+1, right};
            }
            while(left <= right && set.size() == gemNums.size()){
                String cur = gems[left];
                numsGem[gemNums.get(cur)]--;
                if(numsGem[gemNums.get(cur)] == 0){
                    set.remove(cur);
                    if(answer[1]-answer[0] > right - (left+1)){
                        answer = new int[]{left+1, right};
                    }
                }
                left++;
                change = true;
            }
        }
        
        return answer;
    }
}