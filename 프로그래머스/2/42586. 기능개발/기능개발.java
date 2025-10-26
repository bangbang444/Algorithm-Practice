import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        
        List<Integer> list = new ArrayList<>();

        int date = 0;
        int count = 0;
        int progressCount = 0;
        int idx = 0;
        
        while(progressCount < progresses.length){
            int curRate = progresses[idx] + speeds[idx]*date;
            if(curRate >= 100){
                count++;
                idx++;
                progressCount++;
            }
            else{
                list.add(count);
                int needRate = 100-curRate;
                date += (needRate-1)/speeds[idx]+1;
                count = 0;
            }
        }
        list.add(count);
        
        int[] answer = new int[list.size()-1];
        for(int i = 0; i < list.size()-1; i++){
            answer[i] = list.get(i+1);
        }
        
        return answer;
    }
}