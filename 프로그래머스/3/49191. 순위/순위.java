import java.util.*;
class Solution {
    public int solution(int n, int[][] results) {
        int N = n;
        int[][] map1 = new int[N][N];
        int[][] map2 = new int[N][N];
        
        for(int i = 0; i < N; i++){
            Arrays.fill(map1[i], Integer.MAX_VALUE);    
            Arrays.fill(map2[i], Integer.MAX_VALUE);    
        }
        
        for(int[] result : results){
            int s = result[0]-1;
            int c = result[1]-1;
            map1[s][c] = 1;
            map2[c][s] = 1;
        }
        floyd(map1, N);
        floyd(map2, N);
        
        int count = 0;
        for(int i = 0; i < N; i++){
            int sum = 0;
            for(int j = 0; j < N; j++){
                if(map1[i][j] == 1 || map2[i][j] == 1)
                    sum++;
            }
            if(sum == N-1) count++;
        }
        
        return count;
    }
    
    public void floyd(int[][] map,int N){
        
        for(int k = 0; k < N; k++){
            for(int i = 0; i < N; i++){
                for(int j = 0; j < N; j++){
                    if(map[i][k] != Integer.MAX_VALUE && map[k][j] != Integer.MAX_VALUE){
                        int sum = map[i][k] + map[k][j];
                        if(sum >= 1) map[i][j] = 1;
                    }
                }
            }
        }
        
    }
    
}