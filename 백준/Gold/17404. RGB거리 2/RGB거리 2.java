import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        int[][] table = new int[N][3];
        for(int i = 0; i< N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            table[i][0] = Integer.parseInt(st.nextToken());
            table[i][1] = Integer.parseInt(st.nextToken());
            table[i][2] = Integer.parseInt(st.nextToken());
        }


        int[][] dp = new int[N][3];
        for (int[] ints : dp) {
            Arrays.fill(ints, Integer.MAX_VALUE);
        }

        int totalMax1 = 0;
        dp[0][0] = table[0][0];
        dp[1][1] = table[1][1] + table[0][0];
        dp[1][2] = table[1][2] + table[0][0];

        for(int i = 2; i < N; i++){
            for(int j = 0; j < 3; j++){
                if(i == N-1 && j == 0){
                    dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2]) + table[i][1];
                    dp[i][2] = Math.min(dp[i-1][0], dp[i-1][1]) + table[i][2];
                    continue;
                }
                dp[i][j] = Math.min(dp[i-1][(j+1)%3], dp[i-1][(j+2)%3]) + table[i][j];
            }
        }
        totalMax1 = Math.min(Math.min(dp[N-1][0], dp[N-1][1]), dp[N-1][2]);

        int totalMax2 = 0;
        for (int[] ints : dp) {
            Arrays.fill(ints, Integer.MAX_VALUE);
        }
        dp[0][1] = table[0][1];
        dp[1][0] = table[1][0] + table[0][1];
        dp[1][2] = table[1][2] + table[0][1];
        for(int i = 2; i < N; i++){
            for(int j = 0; j < 3; j++){
                if(i == N-1 && j == 1){
                    dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2]) + table[i][0];
                    dp[i][2] = Math.min(dp[i-1][0], dp[i-1][1]) + table[i][2];
                    continue;
                }
                dp[i][j] = Math.min(dp[i-1][(j+1)%3], dp[i-1][(j+2)%3]) + table[i][j];
            }
        }
        totalMax2 = Math.min(Math.min(dp[N-1][0], dp[N-1][1]), dp[N-1][2]);


        int totalMax3 = 0;
        for (int[] ints : dp) {
            Arrays.fill(ints, Integer.MAX_VALUE);
        }
        dp[0][2] = table[0][2];
        dp[1][0] = table[1][0] + table[0][2];
        dp[1][1] = table[1][1] + table[0][2];
        for(int i = 2; i < N; i++){
            for(int j = 0; j < 3; j++){
                if(i == N-1 && j == 2){
                    dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2]) + table[i][0];
                    dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2]) + table[i][1];
                    continue;
                }
                dp[i][j] = Math.min(dp[i-1][(j+1)%3], dp[i-1][(j+2)%3]) + table[i][j];
            }
        }
        totalMax3 = Math.min(Math.min(dp[N-1][0], dp[N-1][1]), dp[N-1][2]);

        System.out.println(Math.min(Math.min(totalMax1, totalMax2), totalMax3));
    }
}
