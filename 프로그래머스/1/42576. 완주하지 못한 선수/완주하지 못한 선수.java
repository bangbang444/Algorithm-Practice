import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        
        Arrays.sort(participant);
        Arrays.sort(completion);
        
        int findIdx = -1;
        
        for(int i = 0; i < completion.length; i++){
            if(!completion[i].equals(participant[i])){
                findIdx = i;
                break;
            }
        }
        
        return findIdx == -1 ? participant[participant.length-1] : participant[findIdx];
    }
}