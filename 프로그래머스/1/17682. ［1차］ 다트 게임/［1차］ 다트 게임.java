import java.util.*;
class Solution {
    public int solution(String dartResult) {
        char[] els =  dartResult.toCharArray();
        int[] scores = new int[3];
        int[] options = new int[3];
        Arrays.fill(options, 1);
        
        int game = 0;
        int idx = 0;
        while(idx < dartResult.length()){
            // 점수
            int numStart = idx;
            while(dartResult.charAt(idx) >= '0' && dartResult.charAt(idx) <= '9'){
                idx++;
            }
            if(numStart == idx) idx++;
            int num = Integer.parseInt(dartResult.substring(numStart, idx));
            
            // 보너스
            char bonus = dartResult.charAt(idx);
            int mul = 0;
            if(bonus == 'S') mul = 1;
            else if(bonus == 'D') mul = 2;
            else if(bonus == 'T') mul = 3;
            
            scores[game] = (int)Math.pow(num, mul);
            idx++;
            
            // 옵션
            if(idx >= dartResult.length()) break;
            char option = dartResult.charAt(idx);
            if(option == '*'){
                if(game == 0) {
                    options[game] *= 2;
                } else {
                    options[game] *= 2;
                    options[game-1] *= 2;
                }
                idx++;
            }else if(option == '#'){
                options[game] *= -1;
                idx++;
            }
            game++;
        }
        
        int sum = 0;
        for(int i = 0; i < 3; i++){
            sum += scores[i] * options[i];
        }
        
        return sum;
    }
}