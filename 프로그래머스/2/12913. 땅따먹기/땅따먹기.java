import java.util.*;
class Solution {
    int solution(int[][] land) {
        int[][] dp = new int[land.length][land[0].length];
        
        // dp 초기값
        dp[0][0] = land[0][0];
        dp[0][1] = land[0][1];
        dp[0][2] = land[0][2];
        dp[0][3] = land[0][3];
        
        // dp 진행
        for(int i = 1; i < land.length; i++){
            for(int j = 0; j < 4; j++){
                dp[i][j] = land[i][j] + Math.max(Math.max(dp[i-1][(j+1)%4], dp[i-1][(j+2)%4]), dp[i-1][(j+3)%4]);
            }
        }
        
        int answer = Arrays.stream(dp[land.length-1]).max().getAsInt();  

        return answer;
    }
}