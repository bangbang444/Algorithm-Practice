import java.util.*;

class Solution {
    public String solution(String s) {

        char pre = ' ';
        boolean isFirst = true;
        StringBuilder answer = new StringBuilder();
        for(char c : s.toCharArray()){
            if(pre == ' '){
                isFirst = true;
            }else{
                isFirst = false;
            }
            
            if(isFirst){
                answer.append(Character.toUpperCase(c));
            }else{
                answer.append(Character.toLowerCase(c));
            }
            
            pre = c;
        }
        
        return answer.toString();
    }
}