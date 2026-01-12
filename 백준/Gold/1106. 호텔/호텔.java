import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int INF = Integer.MAX_VALUE;
    static int MAX_COST = 100000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int c = Integer.parseInt(st.nextToken()); // 모을 C명
        int n = Integer.parseInt(st.nextToken()); // 도시 개수

        int[][] dp = new int[MAX_COST+1][n];
        int[][] info = new int[n][2];
        boolean initPass = false;
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            int cost = Integer.parseInt(st.nextToken());
            int cosNum = Integer.parseInt(st.nextToken());

            info[i][0] = cost;
            info[i][1] = cosNum;
            dp[cost][i] = cosNum;
        }

        Arrays.fill(dp[0], INF);

        int findIdx = -1;
        for(int i = 1; i <= MAX_COST; i++){
            boolean find = false;
            for(int j = 0; j < n; j++){
                int cost = info[j][0];
                int cosNum = info[j][1];

                if(i-cost < 0) {
                    dp[i][j] = INF;
                    continue;
                }

                int max = -1;
                for(int k = 0; k < n; k++){
                    int value = dp[i-cost][k];
                    if(value == INF) continue;
                    max = Math.max(dp[i-cost][k], max);
                }

                if(max+cosNum >= c || cosNum >= c){
                    find = true;
                    break;
                }
                if(dp[i][j] != 0) continue;
                dp[i][j] = max == -1 ? INF : max+cosNum;
            }

            if(find){
                findIdx = i;
                break;
            }
        }
        System.out.println(findIdx);
    }
}
