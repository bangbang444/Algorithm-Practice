import java.util.*;
class Solution {
    public int solution(String[] friends, String[] gifts) {
        // 선물을 주고 받는다.(적게 준 사람이 많이 준 사람에게 줌)
        // 준게 같으면 선물 지수 큰 사람이 작은 사람에게 줌
        // 선물 지수: 줌-받음 => 많이 받았으면 줘야함
        // 선물 지수도 같으면 주고받지 않는다.
        
        // / m r f n
        // m 0 0 2 0
        // r 3 0 0 0
        // f 1 1 0 0
        // n 1 0 0 0
        
        // 사람마다 번호 매기기
        Map<String, Integer> nums = new HashMap<>();
        int num = 0;
        for(String friend : friends){
            nums.put(friend, num++);
        }
        
        // 선물 주고 받은 표
        int[][] pMat = new int[friends.length][friends.length];
        for(String gift : gifts){
            StringTokenizer st = new StringTokenizer(gift);
            int num1 = nums.get(st.nextToken());
            int num2 = nums.get(st.nextToken());
            
            pMat[num1][num2] += 1;
        }
        
        // 선물 지수
        int[] pIdx = new int[friends.length];
        for(int i = 0; i <friends.length; i++){
            for(int j = 0; j < friends.length; j++){
                int score = pMat[i][j];
                pIdx[i] += score;
                pIdx[j] -= score;
            }
        }
        
        // 받을 선물
        int[] receive = new int[friends.length];
        for(int i = 0; i < friends.length-1; i++){
            for(int j = i+1; j < friends.length; j++){
                int aTob = pMat[i][j];
                int bToa = pMat[j][i];
                if(aTob < bToa){ // a가 더 적게 줌
                    receive[j] += 1;
                }else if(aTob > bToa){ // b가 더 적게 줌
                    receive[i] += 1;
                }else{ // 같을 경우 선물지수 비교
                    int aIdx = pIdx[i];
                    int bIdx = pIdx[j];
                    if(aIdx < bIdx){ // b에게 줘야함
                        receive[j] += 1;
                    }else if(aIdx > bIdx){ // a에게 줘야함
                        receive[i] += 1;
                    }
                }
            }
        }
        
        int max = Arrays.stream(receive).max().getAsInt();
        
        return max;
    }
}