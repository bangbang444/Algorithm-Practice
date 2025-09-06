import java.util.*;

class Solution {
    public String solution(String X, String Y) {
        // 공통인 숫자 모으기
        char[] x1 = X.toCharArray();
        char[] x2 = Y.toCharArray();
        Arrays.sort(x2);
       
        Map<Character, Integer> list = new HashMap<>();
        
        for(Character x : x1){
            list.put(x, list.getOrDefault(x, 0) + 1);
        }
        
        StringBuilder combination = new StringBuilder();
        for(Character x : x2){
            if(list.getOrDefault(x, 0) > 0){
                list.put(x, list.get(x) - 1);
                combination.append(x);
            }
        }
        
        // 내림차순으로 정렬 후 출력
        String preAnswer = combination.reverse().toString();
        
        if(preAnswer.equals("")){
            return "-1";
        }
        
        boolean isZero = true;
        for(int i = 0; i < preAnswer.length(); i++){
            if(preAnswer.charAt(i) != '0'){
                isZero = false;
                break;
            }
        }
        
        return isZero ? "0" : preAnswer;
    }
}