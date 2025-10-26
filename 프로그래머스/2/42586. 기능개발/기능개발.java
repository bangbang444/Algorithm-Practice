import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        
        List<Integer> list = new ArrayList<>();

        int date = (100-progresses[0]-1)/speeds[0]+1;
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
        
        int[] answer = list.stream()
                            .mapToInt(Integer::intValue)
                            .toArray();
        
        return answer;
    }
}