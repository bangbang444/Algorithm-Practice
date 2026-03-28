class Solution {
    int[][] map;
    public int solution(int m, int n, int[][] puddles) {
        map = new int[n][m];
        for(int[] puddle : puddles){
            int y = puddle[0]-1;
            int x = puddle[1]-1;
            map[x][y] = -1;
        }
        
        int[][] dp = new int[n][m];
        for(int i = 0; i < n; i++){
            if(map[i][0] == -1){
                break;
            }
            dp[i][0] = 1;
        }
        for(int i = 0; i < m; i++){
            if(map[0][i] == -1){
                break;
            }
            dp[0][i] = 1;
        }
        
        for(int i = 1; i < n; i++){
            for(int j = 1; j < m; j++){
                if(map[i][j] == -1) continue;
                
                dp[i][j] = (dp[i-1][j] + dp[i][j-1])%1_000_000_007;
            }
        }
        
        return dp[n-1][m-1];
    }
}