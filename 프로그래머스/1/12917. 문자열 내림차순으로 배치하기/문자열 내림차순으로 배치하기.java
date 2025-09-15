import java.util.*;
class Solution {
    public String solution(String s) {
        
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        
        StringBuilder answer = new StringBuilder();
        for(int i = chars.length-1; i >= 0; i--){
            answer.append(chars[i]);
        }
        
        return answer.toString();
    }
}