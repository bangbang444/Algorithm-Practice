import java.util.*;
class Solution {
    public int[] solution(int[] arr, int divisor) {
        List<Integer> list = new ArrayList<>();
        for(int a : arr){
            if(a%divisor==0){
                list.add(a);
            }
        }
        if(list.size() == 0) return new int[]{-1};
        
        Collections.sort(list);
        int[] answer = new int[list.size()];
        int idx = 0;
        for(Integer a : list){
            answer[idx++] = a;
        }
        
        return answer;
    }
}